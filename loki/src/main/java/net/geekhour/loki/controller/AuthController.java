package net.geekhour.loki.controller;

import net.geekhour.loki.entity.ERole;
import net.geekhour.loki.entity.User;
import net.geekhour.loki.mapper.RoleMapper;
import net.geekhour.loki.mapper.UserMapper;
import net.geekhour.loki.payload.LoginRequest;
import net.geekhour.loki.payload.MessageResponse;
import net.geekhour.loki.payload.RegisterRequest;
import net.geekhour.loki.payload.UserInfoResponse;
import net.geekhour.loki.security.UserDetailsImpl;
import net.geekhour.loki.security.jwt.JwtUtils;
import net.geekhour.loki.service.impl.UserServiceImpl;
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
import java.util.Random;

/**
 * @author Jasper Yang
 * @create 2024/11/03 22:58
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

//    @Autowired
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
