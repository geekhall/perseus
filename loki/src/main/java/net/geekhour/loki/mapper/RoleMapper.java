package net.geekhour.loki.mapper;

import net.geekhour.loki.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author Jasper Yang
 * @since 2024-11-03
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from h_role where id = #{role_id}")
    Role findByRoleId(Long role_id);

    Integer addRole(Long userId, Long roleId);
    List<Role> getRolesByUserId(Long userId);
}
