package cn.geekhall.hela.server.controller;

import cn.geekhall.hela.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * EduLoginController
 *
 * @author yiny
 * @date 2022/4/10 12:54
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin    //  CROS
public class EduLoginController {

    @PostMapping("/login")
    public Result login(){
        return Result.ok().data("token", "admin");
    }

    @GetMapping("/info")
    public Result info(){
        return Result.ok().data("roles", "[admin]").data("avatar", "https://gitee.com/geekhall/pic/raw/main/img/20220410130517.png");
    }
}
