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
 * 部门
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Getter
@Setter
@TableName("h_department")
@ApiModel(value = "Department对象", description = "部门")
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("部门ID")
    private Long id;

    @ApiModelProperty("部门名称")
    private String name;

    @ApiModelProperty("部门描述")
    private String description;

    @ApiModelProperty("部门编码")
    private String code;

    @ApiModelProperty("父级部门ID")
    private Long parentId;

    @ApiModelProperty("部门层级")
    private Integer level;

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
