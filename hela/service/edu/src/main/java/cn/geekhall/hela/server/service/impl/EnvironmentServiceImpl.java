package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Environment;
import cn.geekhall.hela.server.mapper.EnvironmentMapper;
import cn.geekhall.hela.server.service.IEnvironmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * EnvironmentServiceImpl
 *
 * @author yiny
 * @date 2023/1/4 13:16
 */
@Service
public class EnvironmentServiceImpl extends ServiceImpl<EnvironmentMapper, Environment> implements IEnvironmentService {

}
