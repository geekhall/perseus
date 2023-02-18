# Issue

## IDEA 工程导入后，无法识别部分Module

解决方法：右侧Maven的加号按钮，添加Maven Project。


## IDEA提示：未配置SpringBoot配置注解处理器

添加如下依赖：
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
</dependency>
```

