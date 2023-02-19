package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Permission;
import cn.geekhall.hela.server.mapper.PermissionMapper;
import cn.geekhall.hela.server.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
