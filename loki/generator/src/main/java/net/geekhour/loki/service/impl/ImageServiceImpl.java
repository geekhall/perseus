package net.geekhour.loki.service.impl;

import net.geekhour.loki.entity.Image;
import net.geekhour.loki.mapper.ImageMapper;
import net.geekhour.loki.service.IImageService;
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
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

}
