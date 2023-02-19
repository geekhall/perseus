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
 * 测试环境
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Getter
@Setter
@TableName("h_environment")
@ApiModel(value = "Environment对象", description = "测试环境")
public class Environment extends Model<Environment> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("数据库类型")
    private String dbType;

    @ApiModelProperty("数据库主机")
    private String dbHost;

    @ApiModelProperty("数据库端口")
    private String dbPort;

    @ApiModelProperty("数据库连接类型(0-SID,1-SERVICE)")
    private String dbServType;

    @ApiModelProperty("数据库连接名称")
    private String dbServName;

    @ApiModelProperty("数据库名称")
    private String dbName;

    @ApiModelProperty("数据库用户名")
    private String dbUser;

    @ApiModelProperty("数据库密码")
    private String dbPassword;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("使用开始时间")
    private LocalDateTime useFrom;

    @ApiModelProperty("使用结束时间")
    private LocalDateTime useTo;

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
