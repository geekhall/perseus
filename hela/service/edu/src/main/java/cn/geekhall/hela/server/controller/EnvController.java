package cn.geekhall.hela.server.controller;


import cn.geekhall.hela.server.entity.Env;
import cn.geekhall.hela.server.mapper.EnvMapper;
import cn.geekhall.hela.server.service.impl.EnvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 测试环境 前端控制器
 * </p>
 *
 * @author yiny
 * @since 2023-10-19
 */
@RestController
@RequestMapping("/env")
public class EnvController {

    @Autowired
    private EnvMapper envMapper;

    @Autowired
    private EnvServiceImpl envService;

    @ResponseBody
    @RequestMapping("/all")
    public List<Env> all() {
        System.out.println("EnvController.all called ");
        return envService.list();
    }


}
