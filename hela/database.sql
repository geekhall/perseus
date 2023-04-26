-- 数据库设计规约
-- 1. 库名与应用名称尽量一致
-- 2. 表名、字段名必须使用小写字母或者数字，禁止出现数字开头
-- 3. 表名不使用复数名词
-- 4. 表的命名最好是加上”业务名称_表的作用“，如edu_teacher
-- 5. 表必备三字段: id, create_time, update_time
create database if not exists olympians default charset utf8mb4 collate utf8mb4_general_ci;
create user 'zeus'@'%' identified by 'yy123456';
grant all privileges on olympians.* to 'zeus'@'%';
flush privileges;



-- h_user
drop table if exists `h_user`;
create table h_user
(
    id BIGINT(20) not null comment '主键ID',
    name VARCHAR(30) null default null comment '姓名',
    username VARCHAR(30) not null comment '用户名',
    password VARCHAR(100) not null comment '密码',
    salt VARCHAR(20) not null comment '盐',
    sex tinyint(1) null default null comment '性别 1-男 2-女',
    token varchar(100) null default null comment 'token',
    token_expire_time datetime null default null comment 'token过期时间',
    id_card varchar(20) null default null comment '身份证号',
    phone varchar(20) null default null comment '手机号',
    avatar varchar(255) null default null comment '头像',
    age int(11) null default null comment '年龄',
    email varchar(50) null default null comment '邮箱',
    department_id BIGINT(20) null default null comment '部门ID',
    role_id BIGINT(20) null default null comment '角色ID',
    status tinyint(1) null default null comment '状态 1-正常 2-禁用',
    version int(11) null default null comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id)
) comment='用户';



truncate table h_user;
insert into h_user (id, name, username, password, salt, sex, token, token_expire_time, id_card, phone, avatar, age, email, department_id, role_id, status, version, create_time)
values
(1, 'Jone Zhang', 'jone',password('jone'), '123456', 1, 'abc123', DATE_SUB(CURDATE(),INTERVAL -1 DAY), '210102199101010001','13000000001','avatar_url',31, 'test1@geekhall.com',1,1,1, 1, now()),

(2, 'Jack Ma', 'jack',password('jack'), '123456', 1, 'abc123', DATE_SUB(CURDATE(),INTERVAL -1 DAY), '210102199101010002','13000000002','avatar_url',31, 'test2@geekhall.com',1,1,1, 1, now()),
(3, 'Tom Li', 'tom',password('tom'), '123456', 1, 'abc123', DATE_SUB(CURDATE(),INTERVAL -1 DAY), '210102199101010003','13000000003','avatar_url',31, 'test3@geekhall.com',1,1,1, 1, now()),
(4, 'Jerry Chen', 'jerry',password('jerry'), '123456', 2, 'abc123', DATE_SUB(CURDATE(),INTERVAL -1 DAY), '210102199101010004','13000000004','avatar_url',31, 'test4@geekhall.com',1,1,1, 1, now()),
(5, 'Tony Liu', 'tony',password('tony'), '123456', 1, 'abc123', DATE_SUB(CURDATE(),INTERVAL -1 DAY), '210102199101010005','13000000005','avatar_url',31, 'test5@geekhall.com',1,1,1, 1, now()),
(6, 'Eric Zhao', 'eric',password('eric'), '123456', 1, 'abc123', DATE_SUB(CURDATE(),INTERVAL -1 DAY), '210102199101010006','13000000006','avatar_url',31, 'test6@geekhall.com',1,1,1, 1, now());

select * from h_user;

-- h_department 部门表
drop table if exists `h_department`;
create table h_department
(
    id BIGINT(20) not null comment '部门ID',
    name VARCHAR(30) null default null comment '部门名称',
    description VARCHAR(255) null default null comment '部门描述',
    code VARCHAR(30) null default null comment '部门编码',
    parent_id BIGINT(20) null default null comment '父级部门ID',
    level int(11) null default null comment '部门层级',
    sort int(10) unsigned not null default 0 comment '显示排序',
    version int(11) null default 1 comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id)
) comment='部门';

truncate table h_department;
insert into h_department (id, name, description, code, parent_id, level, sort, version, create_time)
values
(1, '信息科技部', '信息科技部', '0001', null, 1, 1, 1, now()),
(2, '人力资源部', '人力资源部', '0002', null, 1, 2, 1, now()),
(3, '财务部', '财务部', '0003', null, 1, 3, 1, now()),
(4, '市场部', '市场部', '0004', null, 1, 4, 1, now()),
(5, '销售部', '销售部', '0005', null, 1, 5, 1, now()),
(6, '研发部', '研发部', '0006', null, 1, 6, 1, now()),
(7, '运营部', '运营部', '0007', null, 1, 7, 1, now()),
(8, '产品部', '产品部', '0008', null, 1, 8, 1, now()),
(9, '行政部', '行政部', '0009', null, 1, 9, 1, now()),
(10, '客服部', '客服部', '0010', null, 1, 10, 1, now()),
(11, '技术部', '技术部', '0011', null, 1, 11, 1, now()),
(12, '质量部', '质量部', '0012', null, 1, 12, 1, now()),
(13, '采购部', '采购部', '0013', null, 1, 13, 1, now()),
(14, '后勤部', '后勤部', '0014', null, 1, 14, 1, now()),
(15, '法务部', '法务部', '0015', null, 1, 15, 1, now()),
(16, '风控部', '风控部', '0016', null, 1, 16, 1, now()),
(17, '风险部', '风险部', '0017', null, 1, 17, 1, now()),
(18, '审计部', '审计部', '0018', null, 1, 18, 1, now()),
(19, '资产部', '资产部', '0019', null, 1, 19, 1, now()),
(20, '资金部', '资金部', '0020', null, 1, 20, 1, now()),
(21, '投资部', '投资部', '0021', null, 1, 21, 1, now());

-- h_role 角色表
DROP TABLE IF EXISTS `h_role`;
CREATE TABLE `h_role` (
      `id` bigint(20) NOT NULL COMMENT '角色ID',
      `name` varchar(30) DEFAULT NULL COMMENT '角色名称',
      `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
      `code` varchar(30) DEFAULT NULL COMMENT '角色编码',
      `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
      `version` int(11) DEFAULT '1' COMMENT '版本号',
      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
      `update_time` datetime DEFAULT NULL COMMENT '修改时间',
      `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';


truncate table h_role;
INSERT INTO `olympians`.`h_role` (`id`, `name`, `description`, `code`, `sort`, `version`, `create_time`, `update_time`, `deleted`) VALUES (1, 'ROLE_ADMIN', '超级管理员', '0001', 1, 1, '2023-02-06 12:55:45', NULL, 0);
INSERT INTO `olympians`.`h_role` (`id`, `name`, `description`, `code`, `sort`, `version`, `create_time`, `update_time`, `deleted`) VALUES (2, 'ROLE_MANAGER', '管理员', '0002', 2, 1, '2023-02-06 12:55:45', NULL, 0);
INSERT INTO `olympians`.`h_role` (`id`, `name`, `description`, `code`, `sort`, `version`, `create_time`, `update_time`, `deleted`) VALUES (3, 'ROLE_MODERATOR', '会员', '0003', 3, 1, '2023-02-06 12:55:45', NULL, 0);
INSERT INTO `olympians`.`h_role` (`id`, `name`, `description`, `code`, `sort`, `version`, `create_time`, `update_time`, `deleted`) VALUES (4, 'ROLE_USER', '普通用户', '0004', 4, 1, '2023-02-06 12:55:45', NULL, 0);
INSERT INTO `olympians`.`h_role` (`id`, `name`, `description`, `code`, `sort`, `version`, `create_time`, `update_time`, `deleted`) VALUES (5, 'ROLE_DEV', '开发用户', '0005', 5, 1, '2023-02-06 12:55:45', NULL, 0);
INSERT INTO `olympians`.`h_role` (`id`, `name`, `description`, `code`, `sort`, `version`, `create_time`, `update_time`, `deleted`) VALUES (6, 'ROLE_TEST', '测试用户', '0006', 6, 1, '2023-02-06 12:55:45', NULL, 0);

-- h_user_role 用户角色关系表
drop table if exists `h_user_role`;
create table h_user_role
(
    id BIGINT(20) not null comment '用户角色关系ID',
    user_id BIGINT(20) not null comment '用户ID',
    role_id BIGINT(20) not null comment '角色ID',
    version int(11) null default 1 comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id)
);

-- h_permission 权限表
drop table if exists `h_permission`;
create table h_permission
(
    id BIGINT(20) not null comment '权限ID',
    name VARCHAR(30) null default null comment '权限名称',
    description VARCHAR(255) null default null comment '权限描述',
    code VARCHAR(30) null default null comment '权限编码',
    sort int(10) unsigned not null default 0 comment '显示排序',
    version int(11) null default 1 comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id)
) comment='权限';

truncate table h_permission;
insert into h_permission (id, name, description, code, sort, version, create_time)
values
(1, '用户管理', '用户管理', '0001', 1, 1, now()),
(2, '角色管理', '角色管理', '0002', 2, 1, now()),
(3, '权限管理', '权限管理', '0003', 3, 1, now()),
(4, '部门管理', '部门管理', '0004', 4, 1, now()),
(5, '菜单管理', '菜单管理', '0005', 5, 1, now()),
(6, '字典管理', '字典管理', '0006', 6, 1, now()),
(7, '系统日志', '系统日志', '0007', 7, 1, now()),
(8, '系统监控', '系统监控', '0008', 8, 1, now()),
(9, '系统配置', '系统配置', '0009', 9, 1, now()),
(10, '系统通知', '系统通知', '0010', 10, 1, now()),
(11, '系统工具', '系统工具', '0011', 11, 1, now()),
(12, '系统接口', '系统接口', '0012', 12, 1, now()),
(13, '系统文档', '系统文档', '0013', 13, 1, now()),
(14, '系统报表', '系统报表', '0014', 14, 1, now()),
(15, '系统地图', '系统地图', '0015', 15, 1, now());

-- h_role_permission 角色权限关联表
drop table if exists `h_role_permission`;
create table h_role_permission
(
    id BIGINT(20) not null comment '角色权限关联ID',
    role_id BIGINT(20) null default null comment '角色ID',
    permission_id BIGINT(20) null default null comment '权限ID',
    version int(11) null default 1 comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id)
) comment='角色权限关联';

truncate table h_role_permission;
insert into h_role_permission (id, role_id, permission_id, version, create_time)
values
(1, 1, 1, 1, now()),
(2, 1, 2, 1, now()),
(3, 1, 3, 1, now()),
(4, 1, 4, 1, now()),
(5, 1, 5, 1, now()),
(6, 1, 6, 1, now()),
(7, 1, 7, 1, now()),
(8, 1, 8, 1, now()),
(9, 1, 9, 1, now()),
(10, 1, 10, 1, now()),
(11, 1, 11, 1, now()),
(12, 1, 12, 1, now()),
(13, 1, 13, 1, now()),
(14, 1, 14, 1, now()),
(15, 1, 15, 1, now()),
(16, 2, 1, 1, now()),
(17, 2, 2, 1, now()),
(18, 2, 3, 1, now()),
(19, 2, 4, 1, now()),
(20, 2, 5, 1, now()),
(21, 2, 6, 1, now()),
(22, 2, 7, 1, now()),
(23, 2, 8, 1, now()),
(24, 2, 9, 1, now()),
(25, 3, 1, 1, now()),
(26, 3, 2, 1, now()),
(27, 3, 3, 1, now()),
(28, 4, 1, 1, now());



-- 也可以使用下面的语句修改表添加逻辑删除字段
-- alter table `h_user` add column `deleted` tinyint(1) default 0 comment '逻辑删除'


-- h_chapter 章节表
drop table if exists `h_chapter`;
create table h_chapter
(
    id BIGINT(20) not null comment '章节ID',
    course_id BIGINT(20) null default null comment '课程ID',
    title varchar(255) not null comment '标题',
    sort int(10) unsigned not null default 0 comment '显示排序',
    version int(11) null default 1 comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id),
    key `idx_course_id` (`course_id`)
) comment='课程';

insert into h_chapter (id, course_id, title, sort, create_time) values
   (1, 1, '十分钟Git入门教程', 1, now()),
   (2, 2, '十分钟Markdown入门教程', 2, now());


-- h_chapter 讲师表
drop table if exists `h_teacher`;
create table h_teacher
(
    id BIGINT(20) not null comment '讲师ID',
    name varchar(64) not null comment '讲师姓名',
    intro varchar(500) not null default '' comment '讲师简介',
    career varchar(500) default null comment '讲师资历，一句话说明讲师',
    level int(10) unsigned not null comment '头衔 1-高级讲师 2-资深讲师 3-专家讲师 4-首席讲师',
    avatar varchar(255) default null comment '讲师头像',
    sort int(10) unsigned not null default 0 comment '排序',
    version int(11) null default 1 comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id),
    key `uk_name` (`name`)
) comment='讲师';
insert into h_teacher (id, name, intro, career, level, sort, create_time) values
(1, '张三', '十余年丰富前后端开发经验', '资深讲师', 2, 1, now()),
(2, '李四', '多年丰富前端开发经验', '高级讲师', 1, 2, now());


drop table  if EXISTS `h_product`;
CREATE TABLE `h_product`  (
                              `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                              `name` varchar(255) NOT NULL  COMMENT '商品名称',
                              `description` varchar(255) NULL DEFAULT NULL COMMENT '商品描述',
                              `brand` varchar(255) NULL DEFAULT NULL COMMENT '品牌',
                              `price` decimal(17,2) DEFAULT NULL COMMENT '价格',
                              `is_deleted` tinyint(1) default 0,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;
delete from h_product;
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(1,'MacBookPro','Mac book pro', 'Apple', 15000.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(2,'MacBookAir','Mac book air', 'Apple', 8000.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(3,'iPhone13','iphone13 pro max', 'Apple', 9800.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(4,'iMac','iMac', 'Apple', 12000.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(5,'iWatch','iWatch', 'Apple', 4000.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(6,'MacMini','MacMini', 'Apple', 6000.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(7,'AirPots','Air Pots Pro', 'Apple', 2000.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(8,'Surface','Surface book', 'Microsoft', 8000.00);
insert into h_product (`id`, `name`, `description`, `brand`, `price`) values(9,'Honor','Honor phone', 'Huawei', 2000.00);

drop table if EXISTS `h_role`;
create table `h_role`(
                         `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                         `name` varchar(255) NOT NULL  COMMENT '角色名称',
                         `description` varchar(255) NULL DEFAULT NULL COMMENT '角色描述',
                         PRIMARY key (`id`) using BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;
delete from h_role;
insert into h_role(`id`, `name`, `description`) values(1, 'Ares','战神');


drop table if exists `h_weapon`;
create table `h_weapon`(
                           `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                           `name` varchar(255) NOT NULL  COMMENT '武器名称',
                           `description` varchar(255) NULL DEFAULT NULL COMMENT '武器描述',
                           PRIMARY key (`id`) using BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;
delete from h_weapon;
insert into h_weapon(`id`,`name`,`description`) values(1, '雷神之锤','雷神Thor的锤子');


DROP TABLE IF EXISTS h_player;
CREATE TABLE h_player
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NOT NULL  COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id) using BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;

DELETE FROM h_player;

INSERT INTO h_player (id, name, age, email) VALUES
                                                (1, 'Jone', 18, 'test1@geekhall.cn'),
                                                (2, 'Jack', 20, 'test2@geekhall.cn'),
                                                (3, 'Tom', 28, 'test3@geekhall.cn'),
                                                (4, 'Sandy', 21, 'test4@geekhall.cn'),
                                                (5, 'Billie', 24, 'test5@geekhall.cn');


DROP TABLE IF EXISTS h_article;
CREATE TABLE h_article
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    title VARCHAR(255) NOT NULL  COMMENT '标题',
    subtitle VARCHAR(255) NOT NULL  COMMENT '副标题',
    summary TINYTEXT NULL DEFAULT NULL COMMENT '摘要',
    content TEXT NOT NULL  COMMENT '正文',
    author_id BIGINT(20) NULL DEFAULT NULL COMMENT '作者ID',
    create_date BIGINT(20) NULL DEFAULT NULL COMMENT '创建日期',
    PRIMARY KEY (id) using BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;


drop table if exists `h_environment`;
create table h_environment
(
    id BIGINT(20) not null comment '主键ID',
    name VARCHAR(30) null default null comment '名称',
    description VARCHAR(255) null default null comment '描述',
    db_type VARCHAR(30) null default null comment '数据库类型',
    db_host VARCHAR(30) null default null comment '数据库主机',
    db_port VARCHAR(30) null default null comment '数据库端口',
    db_serv_type VARCHAR(30) null default null comment '数据库连接类型(0-SID,1-SERVICE)',
    db_serv_name VARCHAR(30) null default null comment '数据库连接名称',
    db_name VARCHAR(30) null default null comment '数据库名称',
    db_user VARCHAR(30) null default null comment '数据库用户名',
    db_password VARCHAR(30) null default null comment '数据库密码',
    user_id BIGINT(20) null default null comment '用户ID',
    use_from datetime null default null comment '使用开始时间',
    use_to datetime null default null comment '使用结束时间',
    version int(11) null default null comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id)
) ENGINE = InnoDB CHARACTER SET = utf8 comment='测试环境';

insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`)
values(1, 'Kf', '开发环境', 'Oracle11g', '16.24.33.7', '1521', '0','sopdb1','cbs', 'cbs', '******');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`)
values(2, 'Bb', '版本环境', 'Oracle11g', '16.24.33.8', '1529', '0','sopdbver','cbs', 'cbs', '******');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(3, 'Ver', 'Ver环境', 'Oracle11g', '16.24.44.131', '1529', '0','cbs','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(4, 'Kyiv', '基辅环境', 'Oracle11g', '16.24.44.131', '1529', '0','cbs1','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(5, 'Kite', 'Kite环境', 'Oracle11g', '16.24.44.131', '1529', '0','cbsqy','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(6, 'Rose', 'Rose环境', 'Oracle11g', '16.24.44.132', '1529', '0','cbs','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(7, 'Moscow', '莫斯科环境', 'Oracle11g', '16.24.44.132', '1529', '0','cbs1','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(8, 'Kj', '会计环境', 'Oracle11g', '16.24.44.132', '1529', '0','cbs2','cbs', 'cbs', '******', '1', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(9, 'Test', 'Test环境', 'Oracle11g', '16.24.44.132', '1529', '0','cbs3','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(10, 'New1', '新DB环境1', 'Oracle19c', '16.24.44.105', '1529', '1','cbs1','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');
insert into h_environment (`id`, `name`, `description`, `db_type`, `db_host`, `db_port`, `db_serv_type`, `db_serv_name`, `db_name`, `db_user`, `db_password`, `user_id`, `use_from`, `use_to`)
values(11, 'New2', '新DB环境2', 'Oracle19c', '16.24.44.105', '1529', '1','cbs2','cbs', 'cbs', '******', '2', '2023-01-01 00:00:00', '2023-1-4 23:59:59');






drop table if exists `h_machine`;
create table h_machine
(
    id BIGINT(20) not null comment '主键ID',
    name VARCHAR(30) null default null comment '名称',
    type int(11) null default null comment '类型',
    ip varchar(50) null default null comment 'ip地址',
    os varchar(50) null default null comment '操作系统',
    cpu varchar(50) null default null comment 'cpu',
    memory varchar(50) null default null comment '内存',
    disk varchar(50) null default null comment '磁盘',
    environment_id BIGINT(20) null default null comment '环境ID',
    version int(11) null default null comment '版本号',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    deleted tinyint(1) unsigned not null default 0 comment '逻辑删除',
    PRIMARY key (id)
) ENGINE = InnoDB CHARACTER SET = utf8 comment='服务器';


DROP TABLE IF EXISTS h_image;
CREATE TABLE h_image
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NOT NULL  COMMENT '名称',
    type VARCHAR(50) NULL DEFAULT NULL COMMENT '类型',
    path VARCHAR(256) NULL DEFAULT NULL COMMENT '路径',
    data LONGBLOB NULL DEFAULT NULL COMMENT '数据',
    PRIMARY KEY (id) using BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;

DELETE FROM h_image;



create table persistent_logins
(
    username varchar(64) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null default current_timestamp on update current_timestamp,
    primary key (series)
) ENGINE = InnoDB CHARACTER SET = utf8;
