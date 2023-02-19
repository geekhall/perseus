package cn.geekhall.hela.server.entity;

import cn.geekhall.hela.server.entity.validation.UserValidationRules;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.*;
//import javax.persistence.GeneratedValue; //Spring Data JPA

/**
 * <p>
 *
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@Data
@TableName("h_user")
@ApiModel(value = "User对象", description = "")
public class User extends Model<User> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @NotNull(groups = UserValidationRules.UserUpdateValidation.class, message = "用户id不能为空!")

    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("用户名")
    @NotEmpty(groups = {UserValidationRules.UserSignupValidation.class, UserValidationRules.UserLoginValidation.class}, message = "用户名不能为空！")
    @UniqueElements(groups = {UserValidationRules.UserSignupValidation.class}, message = "用户名已存在！")
    private String username;

    @ApiModelProperty("密码")
    @Size(groups = {UserValidationRules.UserSignupValidation.class, UserValidationRules.UserLoginValidation.class}, min = 8, message = "密码长度不能小于8！")
    @NotEmpty(groups = {UserValidationRules.UserSignupValidation.class, UserValidationRules.UserLoginValidation.class}, message = "密码不能为空！")
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
    @Min(groups = {UserValidationRules.UserSignupValidation.class, UserValidationRules.UserLoginValidation.class}, value = 3, message = "年龄不能小于3岁！")
    @Max(groups = {UserValidationRules.UserSignupValidation.class, UserValidationRules.UserLoginValidation.class}, value = 150, message = "年龄不能大于150！")
    private Integer age;

    @ApiModelProperty("邮箱")
    @Email(groups = {UserValidationRules.UserSignupValidation.class}, message = "邮箱格式错误!")
    @UniqueElements(groups = {UserValidationRules.UserSignupValidation.class}, message = "邮箱已存在！")
    private String email;

    @ApiModelProperty("部门ID")
    private Long departmentId;

    @ApiModelProperty("角色ID")
    private Long roleId;
    //    private List<Role> roles;

    @ApiModelProperty("状态 1-正常 2-禁用")
    private Boolean status;

    @Version
    @ApiModelProperty("版本号")
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    @ApiModelProperty("逻辑删除")
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;


    @Override
    public Serializable pkVal() {
        return this.id;
    }



    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
