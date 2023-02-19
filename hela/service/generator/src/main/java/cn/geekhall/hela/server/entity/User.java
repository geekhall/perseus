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
 * 用户
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Getter
@Setter
@TableName("h_user")
@ApiModel(value = "User对象", description = "用户")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("盐")
    private String salt;

    @ApiModelProperty("性别 1-男 2-女")
    private Boolean sex;

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("token过期时间")
    private LocalDateTime tokenExpireTime;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("部门ID")
    private Long departmentId;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("状态 1-正常 2-禁用")
    private Boolean status;

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
