DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `name`        varchar(32) NOT NULL COMMENT '姓名',
    `password`    varchar(16) NOT NULL COMMENT '密码',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '电话',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `delete_flag` tinyint(1)  NOT NULL COMMENT '逻辑删除(未删除0,删除1)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

INSERT INTO `user` (`name`, `password`, `phone`, `create_time`, `update_time`, `delete_flag`) VALUES ('zhangsan', '123456', '13912345678', now(), now(), 0);