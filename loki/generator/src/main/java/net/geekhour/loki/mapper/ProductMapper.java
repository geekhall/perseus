package net.geekhour.loki.mapper;

import net.geekhour.loki.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jasper Yang
 * @since 2024-11-03
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
