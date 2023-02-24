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

//import cn.geekhall.auth.models.ERole;
//import cn.geekhall.auth.models.Role;
//import cn.geekhall.auth.models.User;
//import cn.geekhall.auth.payload.request.LoginRequest;
//import cn.geekhall.auth.payload.request.RegisterRequest;
//import cn.geekhall.auth.payload.response.MessageResponse;
//import cn.geekhall.auth.payload.response.UserInfoResponse;
//import cn.geekhall.auth.repository.RoleRepository;
//import cn.geekhall.auth.repository.UserRepository;
//import cn.geekhall.auth.security.jwt.JwtUtils;
//import cn.geekhall.auth.security.services.UserDetailsImpl;

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
        if (userMapper.selectByUsername(registerRequest.getUsername()) != null) {
            System.out.println("username is already taken");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userMapper.selectByEmail(registerRequest.getEmail()) != null) {
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

        List<Role> roles = new ArrayList<>();

        roles.add(roleMapper.findByRoleId(ERole.ROLE_USER));
        user.setRoles(roles);

        roles.forEach(role -> {
            switch (role.getName()) {
                case ROLE_ADMIN:
                    roleMapper.addRole(user.getId(), ERole.ROLE_ADMIN);
                    break;
                case ROLE_MODERATOR:
                    roleMapper.addRole(user.getId(), ERole.ROLE_MODERATOR);
                    break;
                case ROLE_USER:
                    roleMapper.addRole(user.getId(), ERole.ROLE_USER);
                    break;
                default:
                    break;
            }
        });

        userMapper.insert(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
