/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2022-01-31 12:54:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_no` int(11) DEFAULT NULL,
  `bill_proname` varchar(50) DEFAULT NULL,
  `bill_pronum` int(11) DEFAULT NULL,
  `bill_price` double(8,0) DEFAULT NULL,
  `bill_payment` int(11) DEFAULT NULL COMMENT 'check(bill_payment in (''0'',''1''))',
  `bill_prodescribe` varchar(200) DEFAULT NULL,
  `bill_date` datetime DEFAULT NULL,
  `provider_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `provider_id` (`provider_id`),
  CONSTRAINT `provider_id` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('3001', '901', '大炸弹', '9999', '8355', '0', '很好', '2021-06-05 14:52:45', '101');
INSERT INTO `bill` VALUES ('3010', '666', 'fgf', '3', '3', '1', 'dd', null, '101');
INSERT INTO `bill` VALUES ('3011', '22', 'ghk', '45', '77', '1', 'gg', null, '101');

-- ----------------------------
-- Table structure for `provider`
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider` (
  `provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_no` int(11) DEFAULT NULL,
  `provider_name` varchar(30) DEFAULT NULL,
  `provider_describe` varchar(20) DEFAULT NULL,
  `provider_contacts` varchar(25) DEFAULT NULL,
  `provider_tel` varchar(20) DEFAULT NULL,
  `provider_loc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES ('101', '2001', 'tom', '哒哒哒', '小光', '5566441', '广西');
INSERT INTO `provider` VALUES ('103', '101', '李获取', '结束', '1113355', '1456789', '将灯火辉煌');
INSERT INTO `provider` VALUES ('104', '711', '刘其喆', '666', '高承志', '188', '11#1101');
INSERT INTO `provider` VALUES ('105', '712', '高承志', '777', '王鹤蒙', '178', '11#1102');
INSERT INTO `provider` VALUES ('106', '713', '王鹤蒙', '888', '于浩', '136', '11#1103');
INSERT INTO `provider` VALUES ('107', '714', '于浩', 'ceo', '李事成', '189', '11#1104');
INSERT INTO `provider` VALUES ('108', '715', '李事成', 'hr', '秦某', '133', '11#1105');
INSERT INTO `provider` VALUES ('109', '101', '李', '理解是', '101988171', '178666453', '将大喊大叫吧');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_sex` int(1) unsigned zerofill DEFAULT NULL,
  `user_age` int(11) NOT NULL,
  `user_tel` varchar(20) DEFAULT NULL,
  `user_loc` varchar(100) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1001', 'admin', 'admin', '0', '20', '15411245641', '北京', '1');
INSERT INTO `user` VALUES ('1002', 'liu qi zhe', 'lishicheng', '1', '0', '144', '高承志 于浩 ', '2');
