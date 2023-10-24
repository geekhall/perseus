/*
 Navicat Premium Data Transfer

 Source Server         : docker-mysql
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3316
 Source Schema         : olympians

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 19/10/2023 11:49:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_env
-- ----------------------------
DROP TABLE IF EXISTS `h_env`;
CREATE TABLE `h_env` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `db_type` varchar(30) DEFAULT NULL COMMENT '数据库类型',
  `db_host` varchar(30) DEFAULT NULL COMMENT '数据库主机',
  `db_port` varchar(30) DEFAULT NULL COMMENT '数据库端口',
  `db_serv_type` varchar(30) DEFAULT NULL COMMENT '数据库连接类型(0-SID,1-SERVICE)',
  `db_serv_name` varchar(30) DEFAULT NULL COMMENT '数据库连接名称',
  `db_name` varchar(30) DEFAULT NULL COMMENT '数据库名称',
  `db_user` varchar(30) DEFAULT NULL COMMENT '数据库用户名',
  `db_password` varchar(30) DEFAULT NULL COMMENT '数据库密码',
  `app_address` varchar(30) DEFAULT NULL COMMENT '应用地址',
  `esb_address` varchar(30) DEFAULT NULL COMMENT 'ESB地址',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(512) DEFAULT NULL COMMENT '使用人',
  `user_project` varchar(512) DEFAULT NULL COMMENT '使用项目',
  `use_from` datetime DEFAULT NULL COMMENT '使用开始时间',
  `use_to` datetime DEFAULT NULL COMMENT '使用结束时间',
  `version` int DEFAULT NULL COMMENT '版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='测试环境';

SET FOREIGN_KEY_CHECKS = 1;
