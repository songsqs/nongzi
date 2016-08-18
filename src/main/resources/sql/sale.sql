/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : nongzi

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-08-18 23:34:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售主键id',
  `customer_id` int(11) DEFAULT NULL COMMENT '购买客户id',
  `customer_name` varchar(16) DEFAULT NULL COMMENT '购买客户姓名,冗余存储',
  `product_id` int(11) DEFAULT NULL COMMENT '购买商品id',
  `product_name` varchar(32) DEFAULT NULL COMMENT '购买商品名称,冗余存储',
  `price` decimal(10,2) DEFAULT NULL COMMENT '销售单价(单位 元)',
  `num` int(11) DEFAULT NULL COMMENT '销售数量',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '销售总价(单位 元)',
  `profit` decimal(10,2) DEFAULT NULL COMMENT '盈利(单位 元)',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `enable` tinyint(3) unsigned DEFAULT NULL COMMENT '是否有效(0:无效,1:有效)',
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='销售表';
