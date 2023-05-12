

-- -----------------------------------------------------
-- Schema moviedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `moviedb`;

CREATE SCHEMA `moviedb`;
USE `moviedb` ;

-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`category` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE=InnoDB
    AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`product` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) DEFAULT NULL,
    `description` VARCHAR(255) DEFAULT NULL,
    `poster_url` VARCHAR(255) NOT NULL,
    `running_time` INT NOT NULL,
    `units_in_stock` INT(11) DEFAULT NULL,
    `date_added` DATETIME(6) DEFAULT NULL,
    `release_date` DATETIME(6)NOT NULL,
    `director` VARCHAR(255) NOT NULL,
    `main_actor` VARCHAR(255) NOT NULL,
    `category_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_category` (`category_id`),
    CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
    )
    ENGINE=InnoDB
    AUTO_INCREMENT = 1;

