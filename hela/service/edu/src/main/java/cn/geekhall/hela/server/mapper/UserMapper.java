package cn.geekhall.hela.server.mapper;

import cn.geekhall.hela.server.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * @Mapper注解表示这是一个数据持久层接口。
 *
 * @author yiny
 * @since 2022-03-26
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
