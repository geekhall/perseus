package cn.geekhall.auth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author yiny
 * @date 2023/2/9 21:27
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @RequestMapping("/test")
    public String test(){
        return "hello auth test";
    }

}
