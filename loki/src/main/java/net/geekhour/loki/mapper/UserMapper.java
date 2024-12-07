package net.geekhour.loki.mapper;

import net.geekhour.loki.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Jasper Yang
 * @since 2024-11-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from h_user where username = #{username}")
    User selectByUsername(String username);

    @Select("select EXISTS (SELECT 1 FROM h_user where username = #{role_name})")
    boolean existsByUsername(String username);


    @Select("select * from h_user where email = #{email}")
    User selectByEmail(String email);

    @Select("select EXISTS (SELECT 1 FROM h_user where email = #{email})")
    boolean existsByEmail(String email);

    @Select("select * from h_user where username = #{username}")
    Long getIdByUsername(String username);
}
