package net.geekhour.loki.service.impl;

import net.geekhour.loki.entity.Player;
import net.geekhour.loki.mapper.PlayerMapper;
import net.geekhour.loki.service.IPlayerService;
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
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements IPlayerService {

}
