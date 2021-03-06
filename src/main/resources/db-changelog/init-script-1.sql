-- liquibase formatted SQL
-- changeset Biswajit:firstRun
-- COMMENT db creation INITIAL;

CREATE TABLE `user` (
  `id`             BIGINT(20) UNSIGNED                      NOT NULL AUTO_INCREMENT,
  `first_name`     VARCHAR(60)                              NOT NULL,
  `last_name`      VARCHAR(60)                              NOT NULL,
  `designation`    VARCHAR(100)                             NOT NULL,
  `date_of_birth`  DATE                                     NOT NULL,
  `created`        DATETIME                                 NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated`        DATETIME ON UPDATE CURRENT_TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);



CREATE TABLE `address`(
    `id`              BIGINT(20) UNSIGNED                       NOT NULL  AUTO_INCREMENT,
    `user_id`         BIGINT(20) UNSIGNED                       NOT NULL,
    `house_no`        VARCHAR(60),
    `road_no`         VARCHAR(60),
    `police_station`  VARCHAR(60),
    `city`            VARCHAR(50),
    `state`           VARCHAR(60),
    `country`         VARCHAR(80),
    `mobile_no`       VARCHAR(50),
    `email`           VARCHAR(100)                              NOT NULL,
    `address_type`    INT                                       NOT NULL,
    `created`        DATETIME                                 NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated`        DATETIME ON UPDATE CURRENT_TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    PRIMARY KEY (`id`)
);

INSERT INTO `user` (id,first_name,last_name, designation, date_of_birth, created) VALUES (1,'Biswajit','Debnath','Junior Software Engineer',DATE(NOW()),now());

INSERT INTO `address` (user_id,house_no,road_no,police_station,city,state,country,mobile_no,email,address_type,created)
VALUES (1,'Probashi Islam Tower','Ulon Road','Rampura','Dhaka','Dhaka','Bangladesh','8801937595521','biswajit.sust@gmail.com',1,now());

INSERT INTO `address` (user_id,house_no,road_no,police_station,city,state,country,mobile_no,email, address_type,created)
VALUES (1,'Songchail','Dhaka Sylhet','Debidwear','Comilla','Comilla','Bangladesh','8801557746060','biswajit.dcc@gmail.com',2,now());

INSERT INTO `address` (user_id,house_no,road_no,police_station,city,state,country,mobile_no,email, address_type,created)
VALUES (1,'Sepal','Tejgaon','Tejgaon','Teajgoin','Dhaka','Bangladesh','8801557746060','biswajit.dcc@gmail.com',3,now());