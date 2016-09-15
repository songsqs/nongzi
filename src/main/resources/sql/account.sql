SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '用户名',
  `customer_id` int(11) DEFAULT NULL COMMENT '对应的客户id',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `type` int(4) DEFAULT '0' COMMENT '用户类别(0:普通用户,1:管理员用户)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `idx_customer_id` (`customer_id`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录表';
