/*
 Navicat Premium Data Transfer

 Source Server         : docker上的MySQL
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3307
 Source Schema         : quick-start-v1

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 21/07/2020 15:39:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(60) NOT NULL COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('d09f213462b440f69bceff3c8b841743', 'yoona', 'yoona', '15602498163', 'm15602498163@163.com', 'YoonaDa', 'http://images.yoonada.cn/tmp_505aa876ff90ef0ad1e77245ffeb0cfa.jpg', '喜欢林允儿', '2020-07-21 15:23:37', '2020-07-21 15:23:37');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
