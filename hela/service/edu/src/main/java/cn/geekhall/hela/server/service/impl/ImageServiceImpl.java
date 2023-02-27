package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Image;
import cn.geekhall.hela.server.mapper.ImageMapper;
import cn.geekhall.hela.server.service.IImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-26
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

}
