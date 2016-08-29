/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : nongzi

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-08-18 23:33:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '       自增主键',
  `name` varchar(16) NOT NULL COMMENT ' 客户姓名',
  `id_no` varchar(32) DEFAULT NULL COMMENT '客户身份证号',
  `mobile` varchar(16) DEFAULT NULL COMMENT '   客户手机号码     ',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '客户生日',
  `province` varchar(16) DEFAULT NULL COMMENT '客户居住地-省',
  `city` varchar(16) DEFAULT NULL COMMENT '客户居住地-市',
  `district` varchar(16) DEFAULT NULL COMMENT '客户居住地-区',
  `village` varchar(32) DEFAULT NULL COMMENT '客户居住地-村',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `enable` tinyint(4) unsigned DEFAULT NULL COMMENT '是否有效(0:无效,1:有效)',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='客户表';
