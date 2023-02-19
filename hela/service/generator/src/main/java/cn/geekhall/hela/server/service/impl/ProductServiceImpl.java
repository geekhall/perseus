package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Product;
import cn.geekhall.hela.server.mapper.ProductMapper;
import cn.geekhall.hela.server.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
