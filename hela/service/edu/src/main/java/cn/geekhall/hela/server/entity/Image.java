package cn.geekhall.hela.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CookieValue;

import java.io.Serializable;

/**
 * Image
 *
 * @author yiny
 * @date 2023/2/26 12:12
 */
@Getter
@Setter
@TableName("h_image")
@Builder
@ApiModel(value = "Image对象", description = "图像")
public class Image extends Model<Image> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("数据")
    private byte[] image;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
