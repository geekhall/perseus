package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.User;
import cn.geekhall.hela.server.mapper.UserMapper;
import cn.geekhall.hela.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
