package net.geekhour.loki.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * UserInfoResponse
 *
 * @author Jasper Yang
 * @create 2024/11/03 23:49
 */
@AllArgsConstructor
@Getter
@Setter
public class UserInfoResponse {
    private Long id;
    private String username;
    private String email;

    private Collection<? extends GrantedAuthority> authorities;
}
