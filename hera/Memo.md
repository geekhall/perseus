## 工具及软件版本

* IDE: IDEA 2021.2
* JDK: JDK8+
* 构建工具： IDEA自带 Maven 3.6.3
* MySQL：MAMP MySQL 5.7.34
* SpringBoot ： 2.6.4
* MyBatisPlus： 3.5.1

## 创建数据库
### 准备工作

开始使用MAMP之前需要使用自带的PMA（phpMyAdmin）网页工具执行以下命令，来修改root用户支持远程登陆，

这样我们就可以通过NaviCat等工具来远程连接管理MySQL了。

```sql
update mysql.user set authentication_string=PASSWORD('your_password'),plugin='mysql_native_password' where user='root';

-- （1）修改host允许远程登录
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'your_password' WITH GRANT OPTION;

-- （2）修改验证方式允许密码登录
update mysql.user set authentication_string=PASSWORD('your_password'),plugin='mysql_native_password' where user='root';

```

```sql

-- 创建数据库
create database olympians default charset=utf8;

-- 创建用户并授权;
use mysql;
CREATE USER 'zeus'@'%' IDENTIFIED BY 'yy123456';
flush privileges;

-- 为用户添加权限
GRANT ALL ON olympians.* TO 'zeus'@'%';
flush privileges;
```

添加数据
参考 `database.sql` 文件
建表时需要注意，最好不要使用SQL关键字作为表的字段，比如使用describe，desc等的话
会报SQL语句错误。

## 创建工程

参考 `Environment_proj.md`



创建HelloController测试项目是否正常

```java
@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot";
    }
}
```



### 设置自定义表名称

可以给实体JavaBean类加上`@TableName("tablename")`注解来自定义实体Bean所对应的数据库表名称。

### 设置自定义主键

可以在实体Bean的属性前加上`@TableId(value="uid")` 注解来自定义主键

### 设置主键自增

`@TableId(value="uid", type=IdType.AUTO)`

### @TableField

指定属性所对应的字段名

### @TableLogic

指定属性所对应的字段为逻辑删除字段

### 雪花算法

雪花算法是由Twitter公布的分布式主键生成算法。它能够保证不同表的主键的不重复性，以及相同表的主键有序性。

* 核心思想

1bit 符号位 + 41bit毫秒时间戳 + 10bit机器ID（5bit数据中心+5bit机器id，可部署在1024个节点） + 12bit作为毫秒内流水号（毫秒内4096个ID）

### Wrapper

* Wrapper
  - AbstractWrapper : 用于查询条件封装，生成sql的where条件
    - QueryWrapper： 查询条件封装
    - UpdateWrapper： 更新条件封装
    - AbstractLambdaWrapper： 使用Lambda语法
      - LambdaQueryWrapper： 用于Lambda语法使用的查询Wrapper
      - LambdaUpdateWrapper： Lambda更新封装Wrapper


  