package net.geekhour.loki.config;

import net.geekhour.loki.security.UserDetailsServiceImpl;
import net.geekhour.loki.security.jwt.AuthEntryPointJwt;
import net.geekhour.loki.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * WebSecurityConfiguration
 *
 * @author Jasper Yang
 * @create 2024/11/03 23:12
 */
@Configuration
public class WebSecurityConfiguration {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    // deprecated
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    /**
     * 用于密码加密, 用户密码以BCryptPasswordEncoder加密后存储在数据库中
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    /**
//     * 配置拦截规则
//     * @param http the {@link HttpSecurity} to modify
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll(); // 退出登录
//
////        http.cors().and().csrf().disable() // 禁用跨站请求伪造
////                .authorizeRequests() // 授权配置
////                .antMatchers("/login").permitAll()
////                .antMatchers("/logout").permitAll()
////                .antMatchers("/register").permitAll()
////                .antMatchers("/test/**").permitAll()
////                .antMatchers("/upload/**").permitAll()
////                .antMatchers("/auth/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .defaultSuccessUrl("/index")
////                .permitAll()
////                .and()
////                .rememberMe()
////                .tokenValiditySeconds(1209600);
//        http.cors() // 允许跨域
//                .and().csrf().disable() // 禁用跨站请求伪造
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler) // 未授权处理
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // session管理 : 禁用session
//                .and().authorizeRequests().antMatchers("/auth/**").permitAll() // 允许所有用户访问"/auth/**"路径下的接口
//                .antMatchers("/upload/**").permitAll() // 允许所有用户访问"/upload/**"路径下的接口
//                .antMatchers("/test/**").permitAll()    // 允许所有用户访问"/test/**"路径下的接口
//                .anyRequest().authenticated()// 其他所有接口只能被具有"USER"角色的用户访问
//                .and().rememberMe().tokenValiditySeconds(1209600); // remember me 有效期为2周;
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
}
