-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hwdb04
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hwdb04
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hwdb04` ;
USE `hwdb04` ;

-- -----------------------------------------------------
-- Table `hwdb04`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hwdb04`.`user` ;

CREATE TABLE IF NOT EXISTS `hwdb04`.`user` (
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(45) NULL,
  `useraddress` VARCHAR(45) NULL,
  `userphone` VARCHAR(45) NULL,
  `userexphone` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hwdb04`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hwdb04`.`product` ;

CREATE TABLE IF NOT EXISTS `hwdb04`.`product` (
  `productcode` INT NOT NULL,
  `producttitle` VARCHAR(45) NOT NULL,
  `productprice` INT NOT NULL,
  PRIMARY KEY (`productcode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hwdb04`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hwdb04`.`order` ;

CREATE TABLE IF NOT EXISTS `hwdb04`.`order` (
  `ordernum` INT NOT NULL AUTO_INCREMENT,
  `orderprice` INT NOT NULL,
  `paymentstatus` TINYINT NOT NULL,
  `deliverystatus` TINYINT NOT NULL,
  `productcode` INT NOT NULL,
  `orderquantity` INT NOT NULL,
  `userid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`ordernum`),
  INDEX `order_userid_fk_idx` (`userid` ASC) VISIBLE,
  INDEX `order_productcode_fk_idx` (`productcode` ASC) VISIBLE,
  CONSTRAINT `order_userid_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `hwdb04`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_productcode_fk`
    FOREIGN KEY (`productcode`)
    REFERENCES `hwdb04`.`product` (`productcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
