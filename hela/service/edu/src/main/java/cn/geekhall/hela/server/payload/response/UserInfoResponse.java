package cn.geekhall.hela.server.payload.response;

import cn.geekhall.hela.server.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * UserInfoResponse
 *
 * @author yiny
 * @date 2023/2/19 23:04
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
