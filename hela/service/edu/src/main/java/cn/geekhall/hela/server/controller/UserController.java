package cn.geekhall.hela.server.controller;


import cn.geekhall.hela.server.entity.User;
import cn.geekhall.hela.server.entity.validation.UserValidationRules;
import cn.geekhall.hela.server.mapper.UserMapper;
import cn.geekhall.hela.server.service.impl.UserServiceImpl;
import cn.geekhall.hela.utils.crypto.Encryption;
import cn.geekhall.hela.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/user")
@CrossOrigin    //  CROS
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;


    /**
     * login (登录）
     *
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody @Validated(UserValidationRules.UserLoginValidation.class) User user, BindingResult errors){
        System.out.println("【User】 controller 【login】 method called ...");
        if (errors.hasErrors()) {
            return Result.error().message(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage());
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User db_user = userMapper.selectOne(queryWrapper);
        if (db_user == null) {
            return Result.error().message("用户不存在！");
        }
        if (!db_user.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)))) {
            return Result.error().message("密码错误！");
        }
        return Result.ok().data("token", userService.createToken(db_user)).message("登录成功！");
    }


    /**
     * check if user exists (检查用户是否存在)
     */
    @GetMapping("/exists")
    public Result exists(@RequestParam String username) {
        System.out.println("【User】 controller 【exists】 method called ...");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        if (userMapper.exists(queryWrapper)) {
            return Result.ok().data("exists", true);
        }
        return Result.ok().data("exists", false);
    }
    /**
     * Sing up (注册)
      * @param user
     * @param errors
     * @return
     */
    @PostMapping("/signup")
    public Result signup(@RequestBody @Validated(UserValidationRules.UserSignupValidation.class) User user, BindingResult errors){
        System.out.println("【User】 controller 【signup】 method called ...");
        if (errors.hasErrors()) {
            return Result.error().message(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage());
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());

        if (userMapper.exists(queryWrapper)) {
            System.out.println("用户已存在！ User already exists!");
            return Result.error().message("用户已存在！");
        }
        String salt = Encryption.generateSalt(10);
//        String salt = "123456";
        user.setSalt(salt);
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
//        user.setPassword(Encryption.encryptMysql(user.getPassword(), salt));
        userService.save(user);
        return Result.ok().data("token", "admin").message("用户注册成功");
    }

    @PostMapping("/logout")
    public Result logout(){
        System.out.println("【User】 controller 【logout】 method called ...");
        return Result.ok();
    }


    @GetMapping("/info")
    public Result info(){
        System.out.println("【User】 controller 【info】 method called ...");
        return Result.ok().data("roles", "[admin]").data("avatar", "https://gitee.com/geekhall/pic/raw/main/img/20220410130517.png");
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Long id) {
        System.out.println("【User】 controller 【delete】 method called ...");
        Boolean result = userService.removeById(id);
        if (!result) {
            return Result.error().message("用户删除失败！");
        } else {
            return Result.ok().message("用户已成功删除！");
        }
    }


}
