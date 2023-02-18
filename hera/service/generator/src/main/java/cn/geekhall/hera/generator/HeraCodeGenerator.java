package cn.geekhall.hera.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * HeraCodeGenerator
 *
 * @author yiny
 */
public class HeraCodeGenerator {
    public static void main(String[] args) {
        List<String> includes = new ArrayList<String>();
        includes.add("h_teacher");
        includes.add("h_user");
        includes.add("h_role");
        includes.add("h_player");
        includes.add("h_product");
        includes.add("h_weapon");
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
                    builder.parent("cn.geekhall.hera")  // 设置父包名
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
