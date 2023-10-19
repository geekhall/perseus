package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Env;
import cn.geekhall.hela.server.mapper.EnvMapper;
import cn.geekhall.hela.server.service.IEnvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试环境 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-10-19
 */
@Service
public class EnvServiceImpl extends ServiceImpl<EnvMapper, Env> implements IEnvService {

}
