package cn.geekhall.hela.server.security.services;

import cn.geekhall.hela.server.mapper.UserMapper;
import cn.geekhall.hela.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.geekhall.hela.server.entity.User;
//import com.bezkoder.spring.login.repository.UserRepository; // Spring Data JPA

/**
 * UserDetailsServiceImpl
 *
 * @author yiny
 * @date 2023/2/7 13:12
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectByUsername(username);

        if (user == null) {
            System.out.println("用户不存在！ User not exists!");
//            throw new UsernameNotFoundException("User not exists!");
        }

        return UserDetailsImpl.build(user);
    }
}
