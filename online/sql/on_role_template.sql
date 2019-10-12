/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3307
Source Database       : online

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-12 20:39:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `on_role_template`
-- ----------------------------
DROP TABLE IF EXISTS `on_role_template`;
CREATE TABLE `on_role_template` (
  `id` varchar(32) NOT NULL,
  `role_id` int(8) DEFAULT NULL,
  `template_id` int(8) DEFAULT NULL COMMENT '子模块ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of on_role_template
-- ----------------------------
INSERT INTO `on_role_template` VALUES ('A', '1', '1');
