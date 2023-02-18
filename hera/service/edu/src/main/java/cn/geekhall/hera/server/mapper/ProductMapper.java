package cn.geekhall.hera.server.mapper;

import cn.geekhall.hera.server.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
