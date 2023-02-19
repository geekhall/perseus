package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Player;
import cn.geekhall.hela.server.mapper.PlayerMapper;
import cn.geekhall.hela.server.service.IPlayerService;
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
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements IPlayerService {

}
