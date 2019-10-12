/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3307
Source Database       : online

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-12 20:38:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `on_role`
-- ----------------------------
DROP TABLE IF EXISTS `on_role`;
CREATE TABLE `on_role` (
  `role_id` int(8) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `is_run` int(1) NOT NULL DEFAULT '0' COMMENT '0可用，1不可用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of on_role
-- ----------------------------
INSERT INTO `on_role` VALUES ('1', 'admin', '0');

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

-- ----------------------------
-- Table structure for `on_template_p`
-- ----------------------------
DROP TABLE IF EXISTS `on_template_p`;
CREATE TABLE `on_template_p` (
  `t_p_id` int(8) NOT NULL AUTO_INCREMENT,
  `t_p_name` varchar(32) DEFAULT NULL,
  `is_del` int(1) NOT NULL DEFAULT '0' COMMENT '0未删除，1已删除',
  PRIMARY KEY (`t_p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of on_template_p
-- ----------------------------
INSERT INTO `on_template_p` VALUES ('1', '系统管理', '0');

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
