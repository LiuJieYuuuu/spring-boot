/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3307
Source Database       : online

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-12 20:39:15
*/

SET FOREIGN_KEY_CHECKS=0;

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
