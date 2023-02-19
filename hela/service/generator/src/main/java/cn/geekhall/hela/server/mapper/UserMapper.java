package cn.geekhall.hela.server.mapper;

import cn.geekhall.hela.server.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
