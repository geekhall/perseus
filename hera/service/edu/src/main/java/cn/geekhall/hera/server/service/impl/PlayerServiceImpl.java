package cn.geekhall.hera.server.service.impl;

import cn.geekhall.hera.server.entity.Player;
import cn.geekhall.hera.server.mapper.PlayerMapper;
import cn.geekhall.hera.server.service.IPlayerService;
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
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements IPlayerService {

}
