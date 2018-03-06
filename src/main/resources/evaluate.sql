/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : evaluate

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-03-06 10:11:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `remark` varchar(20) DEFAULT NULL COMMENT '昵称，中文名',
  `role` varchar(10) NOT NULL COMMENT '角色1，超级管理员，2 普通管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('0000000001', 'admin', '6F8F2F6F60FF2BAA2600E19AAD05F0D8', '管理员', '1');
INSERT INTO `tb_admin` VALUES ('0000000002', 'zhangsan', '6F8F2F6F60FF2BAA2600E19AAD05F0D8', '张三', '2');
INSERT INTO `tb_admin` VALUES ('0000000003', 'lisi', '6F8F2F6F60FF2BAA2600E19AAD05F0D8', '李四', '2');

-- ----------------------------
-- Table structure for `tb_depart`
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `departname` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_depart
-- ----------------------------
INSERT INTO `tb_depart` VALUES ('0000000001', '维护业务部');
INSERT INTO `tb_depart` VALUES ('0000000002', '市场业务部');
INSERT INTO `tb_depart` VALUES ('0000000003', '综合部');
INSERT INTO `tb_depart` VALUES ('0000000004', '工程建设部');
INSERT INTO `tb_depart` VALUES ('0000000005', '全业务支撑中心');
INSERT INTO `tb_depart` VALUES ('0000000006', '采购与物资管理中心');

-- ----------------------------
-- Table structure for `tb_evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `tb_evaluate`;
CREATE TABLE `tb_evaluate` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userid` int(10) NOT NULL,
  `departid` int(10) NOT NULL,
  `optionid` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_evaluate
-- ----------------------------
INSERT INTO `tb_evaluate` VALUES ('0000000013', '1', '1', '1');
INSERT INTO `tb_evaluate` VALUES ('0000000014', '1', '2', '1');
INSERT INTO `tb_evaluate` VALUES ('0000000015', '1', '3', '1');
INSERT INTO `tb_evaluate` VALUES ('0000000016', '1', '4', '1');
INSERT INTO `tb_evaluate` VALUES ('0000000017', '1', '5', '1');
INSERT INTO `tb_evaluate` VALUES ('0000000018', '1', '6', '1');

-- ----------------------------
-- Table structure for `tb_option`
-- ----------------------------
DROP TABLE IF EXISTS `tb_option`;
CREATE TABLE `tb_option` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '选项名称',
  `Score` int(3) NOT NULL DEFAULT '10' COMMENT '选项分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_option
-- ----------------------------
INSERT INTO `tb_option` VALUES ('0000000001', '满意', '10');
INSERT INTO `tb_option` VALUES ('0000000002', '良好', '8');
INSERT INTO `tb_option` VALUES ('0000000003', '一般', '6');
INSERT INTO `tb_option` VALUES ('0000000004', '不满意', '4');

-- ----------------------------
-- Table structure for `tb_person`
-- ----------------------------
DROP TABLE IF EXISTS `tb_person`;
CREATE TABLE `tb_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_person
-- ----------------------------
INSERT INTO `tb_person` VALUES ('1', '张三');
INSERT INTO `tb_person` VALUES ('2', '李四');
INSERT INTO `tb_person` VALUES ('3', '王五');
INSERT INTO `tb_person` VALUES ('4', '赵六');
INSERT INTO `tb_person` VALUES ('5', '钱七');
INSERT INTO `tb_person` VALUES ('6', '孙八');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) NOT NULL,
  `remark` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('0000000001', '17612163983', '糖糖');
INSERT INTO `tb_user` VALUES ('0000000002', '15538310583', '飘飘');
