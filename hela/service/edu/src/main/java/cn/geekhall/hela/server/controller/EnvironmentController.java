package cn.geekhall.hela.server.controller;

import cn.geekhall.hela.server.entity.Environment;
import cn.geekhall.hela.server.mapper.EnvironmentMapper;
import cn.geekhall.hela.server.mapper.ProductMapper;
import cn.geekhall.hela.server.service.IEnvironmentService;
import cn.geekhall.hela.server.service.impl.EnvironmentServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * EnvironmentController
 *
 * @author yiny
 * @date 2023/1/4 13:17
 */

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

    @Autowired
    private EnvironmentMapper environmentMapper;

    @Autowired
    private EnvironmentServiceImpl environmentService;

    @GetMapping("/greeting")
    public String greeting(){
        System.out.println("Greetings");
        return "Hello from hela environment";
    }

    @ResponseBody
    @RequestMapping("/all")
    public List<Environment> all() {
        System.out.println("EnvironmentController.all called ");
        return environmentService.list();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public Environment getEnvironment(@PathVariable("id") Long id) {
        System.out.println("getEnvironment called , id = " + id);
        Environment environment = environmentMapper.selectById(id);
        System.out.println(environment);
        return environment;
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateEnvironment(@RequestParam("id") Long id, @RequestParam("name") String name) {
        System.out.println("updateEnvironment called , id = " + id + ", name = " + name);
        Environment environment = new Environment();
        environment.setId(id);
        environment.setName(name);
        environmentMapper.updateById(environment);
        // ToDo: update Environment
        return "updateEnvironment success";
    }

    @RequestMapping("/delete/{id}")
    public void deleteEnvironment(@PathVariable("id") Long id) {
        environmentMapper.deleteById(id);
    }
}
