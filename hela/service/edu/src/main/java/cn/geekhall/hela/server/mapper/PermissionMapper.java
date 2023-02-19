package cn.geekhall.hela.server.mapper;

import cn.geekhall.hela.server.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
