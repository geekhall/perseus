package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Environment;
import cn.geekhall.hela.server.mapper.EnvironmentMapper;
import cn.geekhall.hela.server.service.IEnvironmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试环境 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Service
public class EnvironmentServiceImpl extends ServiceImpl<EnvironmentMapper, Environment> implements IEnvironmentService {

}
