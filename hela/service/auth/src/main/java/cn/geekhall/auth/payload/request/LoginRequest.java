package cn.geekhall.auth.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * LoginRequest
 *
 * @author yiny
 * @date 2023/2/12 19:26
 */
@Data
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;


}
