package cn.geekhall.hera.server.service.impl;

import cn.geekhall.hera.server.entity.Product;
import cn.geekhall.hera.server.mapper.ProductMapper;
import cn.geekhall.hera.server.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
