/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3307
Source Database       : online

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-10 20:12:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `on_user`
-- ----------------------------
DROP TABLE IF EXISTS `on_user`;
CREATE TABLE `on_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `role_id` varchar(5) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of on_user
-- ----------------------------
INSERT INTO `on_user` VALUES ('05F43DF88A0C443BAC1852A0F290C91D', '德安', '1234', '163@qq.com', '1', null);
INSERT INTO `on_user` VALUES ('1747EADBF67F42EDB885162167D12249', '等我一下~', '1234', '7895@qq.com', '1', null);
INSERT INTO `on_user` VALUES ('40165034788944FCA9C96B30B0569E99', '超级管理员', 'admin', 'admin@qq.com', '1', '0023A6DAAD444DF286ACAB37971585FD.JPG');
INSERT INTO `on_user` VALUES ('7EDDE98BD51E445D8DD27D8A2CB51E68', '御风者', '61Tb03b0', '2080207839@qq.com', '1', null);
INSERT INTO `on_user` VALUES ('9EDC36718E4040D6822DA398D7A38281', '一二三', '1234', '369@qq.com', '1', null);
INSERT INTO `on_user` VALUES ('BFA883B599614EC4AD4E8889E4D6E167', 'dasa', 'w49D5e66', '123@qq.com', '1', null);
INSERT INTO `on_user` VALUES ('DC987886BF084ABDBA7160F74BE38D68', '独爱繁星', '1234', '152796@qq.com', '1', null);
