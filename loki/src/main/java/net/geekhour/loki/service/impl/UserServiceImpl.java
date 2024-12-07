package net.geekhour.loki.service.impl;

import net.geekhour.loki.entity.User;
import net.geekhour.loki.mapper.UserMapper;
import net.geekhour.loki.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Jasper Yang
 * @since 2024-11-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * generate token (生成token）
     * use user id and password to generate token
     *
     * @param db_user
     * @return
     */
    public String createToken(User db_user) {
        Long id = db_user.getId();
        String password = db_user.getPassword();
        String token = id + password;
        Long expireTime = System.currentTimeMillis() + 1000 * 60 * 60 * 24;
        token = token + expireTime;
        db_user.setToken(token);
        LocalDateTime expireDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(expireTime), ZoneId.systemDefault());
        db_user.setTokenExpireTime(expireDateTime);
        this.updateById(db_user);
        return token;
    }
}
