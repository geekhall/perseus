package cn.geekhall.hela.server.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * LoginRequest
 *
 * @author yiny
 * @date 2023/2/19 21:05
 */
@Getter
@Setter
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
