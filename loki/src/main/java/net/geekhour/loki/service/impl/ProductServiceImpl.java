package net.geekhour.loki.service.impl;

import net.geekhour.loki.entity.Product;
import net.geekhour.loki.mapper.ProductMapper;
import net.geekhour.loki.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jasper Yang
 * @since 2024-11-03
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
