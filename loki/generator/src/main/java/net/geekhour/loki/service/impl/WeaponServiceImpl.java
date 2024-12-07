package net.geekhour.loki.service.impl;

import net.geekhour.loki.entity.Weapon;
import net.geekhour.loki.mapper.WeaponMapper;
import net.geekhour.loki.service.IWeaponService;
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
public class WeaponServiceImpl extends ServiceImpl<WeaponMapper, Weapon> implements IWeaponService {

}
