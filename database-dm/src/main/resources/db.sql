DROP TABLE IF EXISTS `practice`.`user`;

CREATE TABLE `practice`.`user`
(
    `id` NUMBER NOT NULL,
    `name` NVARCHAR(32) NOT NULL,
    `password` NVARCHAR(16) NOT NULL,
    `phone` NVARCHAR(11) NOT NULL,
    `create_time` TIMESTAMP(0) NOT NULL,
    `update_time` TIMESTAMP(0) NOT NULL,
    `deleted` TINYINT NOT NULL,
    CONSTRAINT `PK_USER` NOT CLUSTER PRIMARY KEY(`id`)
);

INSERT INTO `practice`.`user` (`id`, `name`, `password`, `phone`, `create_time`, `update_time`, `deleted`) VALUES (1, 'zhangsan', '123456', '13912345678', now(), now(), 0);
INSERT INTO `practice`.`user` (`id`, `name`, `password`, `phone`, `create_time`, `update_time`, `deleted`) VALUES (2, 'lisi', '123456', '13912345678', now(), now(), 0);


DROP TABLE IF EXISTS `practice`.`cat`;

CREATE TABLE `practice`.`cat`
(
    `id` NUMBER NOT NULL,
    `user_id` NUMBER NOT NULL,
    `name` NVARCHAR(32) NOT NULL,
    `create_time` TIMESTAMP(0) NOT NULL,
    `update_time` TIMESTAMP(0) NOT NULL,
    `deleted` TINYINT NOT NULL,
    CONSTRAINT `PK_CAT` NOT CLUSTER PRIMARY KEY(`id`)
);

INSERT INTO `practice`.`cat` (`id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (1, 2, 'zs1', now(), now(), 0);
INSERT INTO `practice`.`cat` (`id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (2, 1, 'zs2', now(), now(), 0);
INSERT INTO `practice`.`cat` (`id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (3, 2, 'zs1', now(), now(), 0);
INSERT INTO `practice`.`cat` (`id`, `user_id`, `name`, `create_time`, `update_time`, `deleted`) VALUES (4, 2, 'ls2', now(), now(), 0);