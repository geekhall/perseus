package net.geekhour.generator;

import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.mysql.cj.xdevapi.Table;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * EnhanceFreemarkerTemplateEngine
 *
 * @author Jasper Yang
 * @create 2024/11/03 15:10
 */
public class EnhanceFreemarkerTemplateEngine extends FreemarkerTemplateEngine {

    @Override
    protected void outputCustomFile(@NotNull List<CustomFile> customFiles, @NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {
        String entityName = tableInfo.getEntityName();
        String entityPath = tableInfo.getEntityPath();
        String entityFile = String.format((entityPath + File.separator + "%s.java"), entityName);
        System.out.println("entityFile: " + entityFile);
        String otherPath = this.getPathInfo(OutputFile.parent);
        System.out.println("otherPath: " + otherPath);
        customFiles.forEach((customFile) -> {
            String fileName = String.format(otherPath + File.separator + entityName + "%s", customFile.getFileName());
            this.outputFile(new File(fileName), objectMap, customFile.getTemplatePath(), false);
        });
    }
}
