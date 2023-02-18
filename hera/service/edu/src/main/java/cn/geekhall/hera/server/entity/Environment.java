package cn.geekhall.hera.server.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Environment
 *
 * create table h_environment
 * (
 *     id BIGINT(20) not null comment '主键ID',
 *     name VARCHAR(30) null default null comment '名称',
 *     description VARCHAR(255) null default null comment '描述',
 *     db_type VARCHAR(30) null default null comment '数据库类型',
 *     db_host VARCHAR(30) null default null comment '数据库主机',
 *     db_port VARCHAR(30) null default null comment '数据库端口',
 *     db_serv_type VARCHAR(30) null default null comment '数据库连接类型(0-SID,1-SERVICE)',
 *     db_serv_name VARCHAR(30) null default null comment '数据库连接名称',
 *     db_name VARCHAR(30) null default null comment '数据库名称',
 *     db_user VARCHAR(30) null default null comment '数据库用户名',
 *     db_password VARCHAR(30) null default null comment '数据库密码',
 *     user_id BIGINT(20) null default null comment '用户ID',
 *     use_from datetime null default null comment '使用开始时间',
 *     use_to datetime null default null comment '使用结束时间',
 *     version int(11) null default null comment '版本号',
 *     create_time datetime comment '创建时间',
 *     update_time datetime comment '修改时间',
 *     deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
 *     PRIMARY key (id)
 * ) ENGINE = InnoDB CHARACTER SET = utf8 comment='测试环境';
 * @author yiny
 * @date 2023/1/4 12:35
 */
@Getter
@Setter
@TableName("h_environment")
@ApiModel(value = "Environment对象", description = "")
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
        private String useFrom;

        @ApiModelProperty("使用结束时间")
        private String useTo;

        @ApiModelProperty("版本号")
        @TableField(fill = FieldFill.INSERT)
        private Integer version;

        @ApiModelProperty("创建时间")
        @TableField(fill = FieldFill.INSERT)
        private String createTime;

        @ApiModelProperty("修改时间")
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private String updateTime;

        @TableLogic
        @ApiModelProperty("逻辑删除")
        private Boolean deleted;
}
