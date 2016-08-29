/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : nongzi

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-08-18 23:33:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品自增主键',
  `name` varchar(32) NOT NULL COMMENT '产品名称',
  `manufacturer` varchar(32) DEFAULT NULL COMMENT '生产厂商',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价(单位 元)',
  `price_lower` decimal(10,2) DEFAULT NULL COMMENT '单价最低价格(单位 元)',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `enable` tinyint(4) unsigned NOT NULL COMMENT '是否有效(0:无效,1:有效)',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='产品表';
