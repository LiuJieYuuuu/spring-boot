/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3307
Source Database       : online

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-12 20:39:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `on_template_s`
-- ----------------------------
DROP TABLE IF EXISTS `on_template_s`;
CREATE TABLE `on_template_s` (
  `t_s_id` int(8) NOT NULL AUTO_INCREMENT,
  `t_s_name` varchar(32) DEFAULT NULL,
  `t_s_url` varchar(256) DEFAULT NULL,
  `is_del` int(1) DEFAULT NULL,
  `t_parent_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`t_s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of on_template_s
-- ----------------------------
INSERT INTO `on_template_s` VALUES ('1', '模块管理', '/system/moduleManager', '0', '1');
