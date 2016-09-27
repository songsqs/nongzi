
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_role
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `account_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL COMMENT '登录账号id',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称(admin,manager,normal)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`account_role_id`),
  KEY `idx_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';
