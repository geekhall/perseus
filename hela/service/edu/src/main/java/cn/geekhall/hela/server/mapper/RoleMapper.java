package cn.geekhall.hela.server.mapper;

import cn.geekhall.hela.server.entity.ERole;
import cn.geekhall.hela.server.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select * from role where id = #{role_id}")
    Role findByRoleId(ERole role_id);

    Integer addRole(Long userId, ERole roleId);
    List<Role> getRoles(Long userId);
}
