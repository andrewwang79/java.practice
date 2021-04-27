DROP TABLE IF EXISTS "practice"."user";

CREATE TABLE "practice"."user"
(
    "id" NUMBER NOT NULL,
    "name" NVARCHAR(32) NOT NULL,
    "password" NVARCHAR(16) NOT NULL,
    "phone" NVARCHAR(11) NOT NULL,
    "create_time" TIMESTAMP(0) NOT NULL,
    "update_time" TIMESTAMP(0) NOT NULL,
    "deleted" TINYINT NOT NULL,
    CONSTRAINT "PK_USER" NOT CLUSTER PRIMARY KEY("id")
);

INSERT INTO "practice"."user" (`name`, `password`, `phone`, `create_time`, `update_time`, `deleted`) VALUES ('zhangsan', '123456', '13912345678', now(), now(), 0);