package cn.geekhall.hera.server.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@Getter
@Setter
@TableName("h_teacher")
@ApiModel(value = "Teacher对象", description = "讲师")
public class Teacher extends Model<Teacher> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("讲师ID")
    private Long id;

    @ApiModelProperty(value = "讲师姓名", example = "张三")
    private String name;

    @ApiModelProperty(value = "讲师简介", example = "专注互联网")
    private String intro;

    @ApiModelProperty(value = "讲师资历，一句话说明讲师",example = "十年大厂开发经验")
    private String career;

    @ApiModelProperty(value = "头衔 1-高级讲师 2-资深讲师 3-专家讲师 4-首席讲师", example = "1")
    private Integer level;

    @ApiModelProperty(value = "讲师头像", example = "")
    private String avatar;

    @ApiModelProperty(value = "排序", example = "1")
    private Integer sort;

    @ApiModelProperty("版本号")
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
