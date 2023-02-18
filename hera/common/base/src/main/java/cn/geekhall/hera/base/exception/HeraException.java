package cn.geekhall.hera.base.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HeraException
 *
 * @author yiny
 * @date 2022/3/28 06:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeraException extends RuntimeException{
    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("消息")
    private String message;
}
