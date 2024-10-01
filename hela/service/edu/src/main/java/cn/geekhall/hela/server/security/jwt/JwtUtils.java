package cn.geekhall.hela.server.security.jwt;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import cn.geekhall.hela.server.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;

/**
 * JwtUtils
 *
 * @author yiny
 * @date 2023/2/7 13:12
 */

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    // Secret key of JWT token
    @Value("${hela.app.jwtSecret}")
    private String jwtSecret;

    // Expiration time of JWT token in milliseconds (1000 * 60 * 60 * 24 = 24 hours)
    @Value("${hela.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${hela.app.jwtCookieName}")
    private String jwtCookie;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
        return cookie;
    }

    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
        return cookie;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(jwtSecret).parseClaimsJws(authToken);
        Claims claims = claimsJws.getBody();
//        String username = claims.get("username", String.class);
//        String role = claims.get("role", String.class);
//        String id = claims.getId();
//        String subject = claims.getSubject();
//        Date issuedAt = claims.getIssuedAt();
//        Date expiration = claims.getExpiration();
//        System.out.println("id = " + id);
//        System.out.println("subject = " + subject);
//        System.out.println("issuedAt = " + issuedAt);
//        System.out.println("expiration = " + expiration);
//        System.out.println("username = " + username);
//        System.out.println("role = " + role);
//

        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String generateTokenFromUsername(String username) {
        String token = Jwts.builder()
                // Header
//                .setHeaderParam("typ", "JWT")
//                .setHeaderParam("alg", "HS512")
                // Payload
//                .setId(UUID.randomUUID().toString())
//                .claim("username", username)
//                .claim("role", "admin")
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                // Signature
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
        System.out.println("token = " + token);
        return token;
    }

    public String generateJwtToken(Authentication authentication) {
        return generateTokenFromUsername(((UserDetailsImpl) authentication.getPrincipal()).getUsername());
    }
}
