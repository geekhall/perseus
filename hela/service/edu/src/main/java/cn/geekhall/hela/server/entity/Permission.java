package cn.geekhall.hela.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Getter
@Setter
@TableName("h_permission")
@ApiModel(value = "Permission对象", description = "权限")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权限ID")
    private Long id;

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("权限描述")
    private String description;

    @ApiModelProperty("权限编码")
    private String code;

    @ApiModelProperty("显示排序")
    private Integer sort;

    @ApiModelProperty("版本号")
    private Integer version;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除")
    private Boolean deleted;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
