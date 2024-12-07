package net.geekhour.loki;

import net.geekhour.loki.security.UserDetailsImpl;
import net.geekhour.loki.security.jwt.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JwtUtilsTest
 *
 * @author Jasper Yang
 * @create 2024/11/25 00:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUtilsTest {

    @Value("${loki.app.jwtSecret}")
    private String jwtSecret;

    @Test
    public void testGetJwtFromCookies(){
        return;
    }

    @Test
    public void testGenerateJwtCookie(){
        System.out.println("=====jwtSecret: " + jwtSecret);
        UserDetailsImpl userDetails = new UserDetailsImpl(1L, "test", "test", "test", null);

        JwtUtils jwtUtils = new JwtUtils();
        ResponseCookie responseCookie = jwtUtils.generateJwtCookie(userDetails);
//        assert responseCookie != null;
        System.out.println("responseCookie: " + responseCookie);

    }

    @Test
    public void testGetCleanJwtCookie(){

    }

    @Test
    public void testGetUserNameFromJwtToken(){

    }
}
