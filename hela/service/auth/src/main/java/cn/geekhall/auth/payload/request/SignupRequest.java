package cn.geekhall.auth.payload.request;

import cn.geekhall.auth.models.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * SignupRequest
 *
 * @author yiny
 * @date 2023/2/12 19:37
 */
@Setter
@Getter
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;


    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
