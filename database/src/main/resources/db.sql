DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`         int(11)  NOT NULL AUTO_INCREMENT,
    `name`       varchar(32) DEFAULT NULL,
    `password`   varchar(16) DEFAULT NULL,
    `phone`      varchar(11) DEFAULT NULL,
    `create_time` datetime NOT NULL,
    `update_time` datetime NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

INSERT INTO `user` (`name`, `password`, `phone`, `create_time`, `update_time`) VALUES ('zhangsan', '123456', '13912345678', now(), now());