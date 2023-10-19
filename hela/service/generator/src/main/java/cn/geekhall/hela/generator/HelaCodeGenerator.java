package cn.geekhall.hela.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * HelaCodeGenerator
 * Usage:
 *     1. 修改数据库连接信息
 *     2. 修改包名
 *     3. 修改需要生成的表名
 *     4. 在数据库中提前准备好表结构（表要先建好，否则不能生成对应的源码）
 *     5. 运行main方法
 *     6. 生成的源码在service/generator/src/main/java/cn/geekhall/hela/server目录下
 *     7. 生成的源码需要手动复制到service/server/src/main/java/cn/geekhall/hela/server目录下，注意不要覆盖已有的源码
 *     8. 去掉生成的源码中XxxController中@RequestMapping("/server/department")的server前缀
 *     9. 修改entity中的公共部分注解
 *
 *     @TableId(value = "id", type = IdType.AUTO)
 *              @Version
 *              @ApiModelProperty("版本号")
 *              @TableField(fill = FieldFill.INSERT)
 *              private Integer version;
 *
 *              @ApiModelProperty("创建时间")
 *              @TableField(fill = FieldFill.INSERT)
 *              private LocalDateTime createTime;
 *
 *              @ApiModelProperty("修改时间")
 *              @TableField(fill = FieldFill.INSERT_UPDATE)
 *              private LocalDateTime updateTime;
 *
 *              @TableLogic
 *              @ApiModelProperty("逻辑删除")
 *              @TableField(fill = FieldFill.INSERT)
 *              private Boolean deleted;
 *
 * @author yiny
 */
public class HelaCodeGenerator {
    public static void main(String[] args) {
        List<String> includes = new ArrayList<String>();
        includes.add("h_env");
//        includes.add("h_image");
//        includes.add("h_teacher");
//        includes.add("h_user");
//        includes.add("h_role");
//        includes.add("h_permission");
//        includes.add("h_department");
//        includes.add("h_environment");
//        includes.add("h_player");
//        includes.add("h_product");
//        includes.add("h_weapon");
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .entityBuilder()
                .disableSerialVersionUID()
                .enableChainModel()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleteFlag")
                .naming(NamingStrategy.no_change)
                .columnNaming(NamingStrategy.underline_to_camel)
                .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .idType(IdType.AUTO)
                .formatFileName("%sEntity")
                .build();


        FastAutoGenerator.create("jdbc:mysql://localhost:3316/olympians?userUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "zeus", "yy123456")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("yiny") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/service/generator/src/main/java"); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("cn.geekhall.hela")  // 设置父包名
                            .moduleName("server")       // 设置父包模块名
                            .entity("entity")             // Entity包名
                            .service("service")         // Service包名
                            .serviceImpl("service.impl") // ServiceImpl包名
                            .controller("controller")   // Controller包名
                            .mapper("mapper")           // Mapper包名
                            .xml("mapper")              // Mapper XML包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    System.getProperty("user.dir") + "/service/generator/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(includes) // 设置需要生成的表名
                            .addTablePrefix("h_") // 设置过滤表前缀
                            .entityBuilder()
                            .enableActiveRecord()
                            .naming(NamingStrategy.underline_to_camel)  // 数据库表映射到实体的命名策略，下划线转驼峰
                            .enableLombok()                             // 开启Lombok支持
//                            .logicDeleteColumnName("is_deleted")        // 逻辑删除字段名
                            .controllerBuilder()
                            .formatFileName("%sController")             // 格式化Controller名称
                            .enableRestStyle()                          // 开启生成@RestController
                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .enableMapperAnnotation()                   // 开启@Mapper注解
                            .formatMapperFileName("%sMapper")           // 格式化Mapper文件名
                            .formatXmlFileName("%sMapper");             // 格式化xml文件名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
