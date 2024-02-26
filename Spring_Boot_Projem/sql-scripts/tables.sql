CREATE TABLE `role` (
	`name` varchar(45) NOT NULL,
	PRIMARY KEY (`name`)
);

CREATE TABLE `my_database`.`city` (
`name` VARCHAR(45) NOT NULL,
`description` LONGTEXT NOT NULL,
PRIMARY KEY (`name`),
UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

CREATE TABLE `my_database`.`ad_type` (
`name` VARCHAR(45) NOT NULL,
`description` LONGTEXT NOT NULL,
PRIMARY KEY (`name`),
UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

CREATE TABLE `user` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`username` varchar(45) NOT NULL,
`name` varchar(45) NOT NULL,
`surname` varchar(45) NOT NULL,
`phone` varchar(25) NOT NULL,
`age` INT,
`mail` varchar(45) NOT NULL,
`password` char(80) NOT NULL,
`enabled` tinyint NOT NULL,
`role` varchar(45) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `role_fk_constraint` FOREIGN KEY (`role`) REFERENCES `role` (`name`)
ON DELETE NO ACTION ON UPDATE NO ACTION,
UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

CREATE TABLE `my_database`.`ad` (
`id` INT NOT NULL AUTO_INCREMENT,
`date` DATE NOT NULL,
`ad_owner` INT(11) NOT NULL,
`city_name` VARCHAR(45) NOT NULL,
`header` VARCHAR(45) NOT NULL,
`description` LONGTEXT NOT NULL,
`price` FLOAT NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
CONSTRAINT `ad_owner_fk_constraint` FOREIGN KEY (`ad_owner`) REFERENCES `user` (`id`)
ON DELETE NO ACTION ON UPDATE NO ACTION ,
CONSTRAINT `city_name_fk_constraint` FOREIGN KEY (`city_name`) REFERENCES `city` (`name`)
ON DELETE NO ACTION ON UPDATE NO ACTION);

CREATE TABLE `my_database`.`image` (
`id` INT NOT NULL AUTO_INCREMENT,
`image_owner_ad` INT(11) NOT NULL,
`file_location` LONGTEXT NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
CONSTRAINT `image_owner_ad_fk_constraint` FOREIGN KEY (`image_owner_ad`) REFERENCES `ad` (`id`)
ON DELETE NO ACTION ON UPDATE NO ACTION);

CREATE TABLE `my_database`.`ad_ad_type` (
`ad_id` INT NOT NULL,
`ad_type` VARCHAR(45) NOT NULL,
PRIMARY KEY (`ad_id`,`ad_type`),
CONSTRAINT `ad_fk_constraint` FOREIGN KEY (`ad_id`) REFERENCES `ad` (`id`)
ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `adType_fk_constraint` FOREIGN KEY (`ad_type`) REFERENCES `ad_type` (`name`)
ON DELETE NO ACTION ON UPDATE NO ACTION
);
