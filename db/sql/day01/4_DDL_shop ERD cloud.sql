drop database if exists shop;

create database if not exists shop;

use shop;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_ID`	varchar(13)	NOT NULL,
	`user_pw`	varchar(15) not null,
	`user_email`	varchar(40) unique not null,
	`user_phone`	varchar(14) not null,
	`user_level`	int not null default 1,
	`user_failNum`	int not null default 0
);

DROP TABLE IF EXISTS `identify`;

CREATE TABLE `identify` (
	`idf_num`	int	primary key auto_increment,
	`idf_code`	int not null,
	`idf_limit`	datetime not null,
	`idf_user_ID`	varchar(13)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pd_code`	varchar(20)	NOT NULL,
	`pd_title`	varchar(20) not null,
	`pd_content`	longtext not null,
	`pd_price`	int not null,
	`pd_ct_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `categori`;

CREATE TABLE `categori` (
	`ct_num`	int	primary key auto_increment,
	`ct_title`	varchar(20) not null unique
);

DROP TABLE IF EXISTS `thumbnail`;

CREATE TABLE `thumbnail` (
	`tn_num`	int	primary key auto_increment,
	`tn_file`	longtext not null,
	`tn_pd_code`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
	`cr_num`	int	primary key auto_increment,
	`cr_count`	int not null default 1,
	`cr_user_ID`	varchar(13)	NOT NULL,
	`cr_pd_code`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`od_num`	int	primary key auto_increment,
	`od_day`	datetime not null,
	`od_stat`	varchar(15) not null,
	`od_count`	int not null default 1,
	`od_price`	int not null default 0,
	`od_user_ID`	varchar(13)	NOT NULL,
	`od_pd_code`	varchar(20)	NOT NULL
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_ID`
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`pd_code`
);


ALTER TABLE `identify` ADD CONSTRAINT `FK_user_TO_identify_1` FOREIGN KEY (
	`idf_user_ID`
)
REFERENCES `user` (
	`user_ID`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_categori_TO_product_1` FOREIGN KEY (
	`pd_ct_num`
)
REFERENCES `categori` (
	`ct_num`
);

ALTER TABLE `thumbnail` ADD CONSTRAINT `FK_product_TO_thumbnail_1` FOREIGN KEY (
	`tn_pd_code`
)
REFERENCES `product` (
	`pd_code`
);

ALTER TABLE `cart` ADD CONSTRAINT `FK_user_TO_cart_1` FOREIGN KEY (
	`cr_user_ID`
)
REFERENCES `user` (
	`user_ID`
);

ALTER TABLE `cart` ADD CONSTRAINT `FK_product_TO_cart_1` FOREIGN KEY (
	`cr_pd_code`
)
REFERENCES `product` (
	`pd_code`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_user_TO_order_1` FOREIGN KEY (
	`od_user_ID`
)
REFERENCES `user` (
	`user_ID`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_product_TO_order_1` FOREIGN KEY (
	`od_pd_code`
)
REFERENCES `product` (
	`pd_code`
);
