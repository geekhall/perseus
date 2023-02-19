package cn.geekhall.hela.server.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

}
