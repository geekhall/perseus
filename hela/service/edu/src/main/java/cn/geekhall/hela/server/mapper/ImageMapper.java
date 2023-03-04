package cn.geekhall.hela.server.mapper;

import cn.geekhall.hela.server.entity.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yiny
 * @since 2023-02-26
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    @Select("select * from h_image where name = #{name}")
    Optional<Image> findByName(String name);
}
