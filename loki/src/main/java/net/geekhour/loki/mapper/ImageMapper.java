package net.geekhour.loki.mapper;

import net.geekhour.loki.entity.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jasper Yang
 * @since 2024-11-03
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    @Select("select * from h_image where name = #{name}")
    Optional<Image> findByName(String name);
}
