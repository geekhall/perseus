package cn.geekhall.hela.base.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HelaException
 *
 * @author yiny
 * @date 2022/3/28 06:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelaException extends RuntimeException{
    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("消息")
    private String message;
}
