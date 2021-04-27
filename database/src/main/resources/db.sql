DROP TABLE IF EXISTS `practice`.`user`;

CREATE TABLE `practice`.`user`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `tenant_id`   int(11)     NOT NULL COMMENT '租户编号',
    `name`        varchar(32) NOT NULL COMMENT '姓名',
    `password`    varchar(16) NOT NULL COMMENT '密码',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '电话',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `deleted` tinyint(1)  NOT NULL COMMENT '逻辑删除(未删除0,删除1)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

INSERT INTO `practice`.`user` (`tenant_id`, `name`, `password`, `phone`, `create_time`, `update_time`, `deleted`) VALUES (1, 'zhangsan', '123456', '13912345678', now(), now(), 0);
INSERT INTO `practice`.`user` (`tenant_id`, `name`, `password`, `phone`, `create_time`, `update_time`, `deleted`) VALUES (2, 'lisi', '123456', '13912345678', now(), now(), 0);


DROP TABLE IF EXISTS `practice`.`cat`;

CREATE TABLE `practice`.`cat`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `tenant_id`   int(11)     NOT NULL COMMENT '租户编号',
    `user_id`     int(11)     NOT NULL COMMENT '用户编号',
    `name`        varchar(32) NOT NULL COMMENT '姓名',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `deleted` tinyint(1)  NOT NULL COMMENT '逻辑删除(未删除0,删除1)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

INSERT INTO `practice`.`cat` (`tenant_id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (2, 2, 'zs1', now(), now(), 0);
INSERT INTO `practice`.`cat` (`tenant_id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (1, 1, 'zs2', now(), now(), 0);
INSERT INTO `practice`.`cat` (`tenant_id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (2, 2, 'zs1', now(), now(), 0);
INSERT INTO `practice`.`cat` (`tenant_id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (2, 2, 'ls2', now(), now(), 0);
