package cn.geekhall.auth.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * UserInfoResponse
 *
 * @author yiny
 * @date 2023/2/12 19:44
 */

@AllArgsConstructor
@Getter
@Setter
public class UserInfoResponse {

    private Long id;
    private String username;
    private String email;
    private List<String> roles;
}
