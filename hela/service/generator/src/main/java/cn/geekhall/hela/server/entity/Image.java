package cn.geekhall.hela.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.sql.Blob;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author yiny
 * @since 2023-02-26
 */
@Getter
@Setter
@TableName("h_image")
@ApiModel(value = "Image对象", description = "")
public class Image extends Model<Image> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("数据")
    private byte[] data;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
