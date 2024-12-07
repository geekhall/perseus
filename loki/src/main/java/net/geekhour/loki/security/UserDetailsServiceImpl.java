package net.geekhour.loki.security;

import net.geekhour.loki.entity.User;
import net.geekhour.loki.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserDetailsServiceImpl
 *
 * @author Jasper Yang
 * @create 2024/11/03 23:14
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectByUsername(username);
        System.out.println("########## 004  user: " + username);
        System.out.println("########## 004  user: " + user);
        if (user == null) {
            System.out.println("用户不存在！ User not exists!");
//            throw new UsernameNotFoundException("User not exists!");
        }

        return UserDetailsImpl.build(user);
    }
}
