package cn.geekhall.hela.server.controller;

import cn.geekhall.hela.server.entity.ERole;
import cn.geekhall.hela.server.mapper.RoleMapper;
import cn.geekhall.hela.server.mapper.UserMapper;
import cn.geekhall.hela.server.payload.request.LoginRequest;
import cn.geekhall.hela.server.payload.request.RegisterRequest;
import cn.geekhall.hela.server.payload.response.MessageResponse;
import cn.geekhall.hela.server.payload.response.UserInfoResponse;
import cn.geekhall.hela.server.security.services.UserDetailsImpl;
import cn.geekhall.hela.utils.Result;
import freemarker.log.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.geekhall.hela.server.service.impl.UserServiceImpl;
import cn.geekhall.hela.server.entity.User;
import cn.geekhall.hela.server.entity.Role;
import cn.geekhall.hela.server.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * AuthController
 *
 * @author yiny
 * @date 2023/2/19 21:01
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("login");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), userDetails.getAuthorities()));

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if (userMapper.existsByUsername(registerRequest.getUsername())) {
            System.out.println("username is already taken");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userMapper.existsByEmail(registerRequest.getEmail())) {
            System.out.println("email is already in use");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(registerRequest.getUsername(),
                registerRequest.getEmail(),
                encoder.encode(registerRequest.getPassword()));
        // generate salt
        Random random = new Random();
        String salt = String.valueOf(random.nextInt(1000000));
        user.setSalt(salt);
        user.setRoleId(ERole.ROLE_USER.getValue());
        userMapper.insert(user);

//        Long user_id = userMapper.getIdByUsername(registerRequest.getUsername());
//        System.out.println("user_id: " + user_id);
//
//        List<Role> roles = new ArrayList<>();
//        Role roleUser = new Role();
//        roleUser.setName(ERole.ROLE_USER);
//        System.out.println("roleUser: " + roleUser);
//        roles.add(roleUser);
//        user.setRoles(roles);
//        System.out.println("roles: " + roles);
//        roles.forEach(role -> {
//            switch (role.getName()) {
//                case ROLE_ADMIN:
//                    roleMapper.addRole(user_id, ERole.ROLE_ADMIN.getValue());
//                    break;
//                case ROLE_MODERATOR:
//                    roleMapper.addRole(user_id, ERole.ROLE_MODERATOR.getValue());
//                    break;
//                case ROLE_USER:
//                    roleMapper.addRole(user_id, ERole.ROLE_USER.getValue());
//                    break;
//                default:
//                    break;
//            }
//        });



        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
