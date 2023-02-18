package cn.geekhall.hera.server.service.impl;

import cn.geekhall.hera.server.entity.Weapon;
import cn.geekhall.hera.server.mapper.WeaponMapper;
import cn.geekhall.hera.server.service.IWeaponService;
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
