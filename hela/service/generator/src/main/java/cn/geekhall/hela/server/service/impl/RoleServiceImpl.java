package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Role;
import cn.geekhall.hela.server.mapper.RoleMapper;
import cn.geekhall.hela.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
