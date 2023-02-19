package cn.geekhall.hela.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author yiny
 * @date 2023/2/19 22:23
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/test")
@RestController
public class TestController {

        @RequestMapping("/hello")
        public String hello(){
            return "hello";
        }
}
