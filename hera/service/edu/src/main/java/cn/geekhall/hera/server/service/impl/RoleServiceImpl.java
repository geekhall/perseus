package cn.geekhall.hera.server.service.impl;

import cn.geekhall.hera.server.entity.Role;
import cn.geekhall.hera.server.mapper.RoleMapper;
import cn.geekhall.hera.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
