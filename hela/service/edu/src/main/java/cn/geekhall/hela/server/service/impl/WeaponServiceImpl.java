package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Weapon;
import cn.geekhall.hela.server.mapper.WeaponMapper;
import cn.geekhall.hela.server.service.IWeaponService;
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
public class WeaponServiceImpl extends ServiceImpl<WeaponMapper, Weapon> implements IWeaponService {

}
