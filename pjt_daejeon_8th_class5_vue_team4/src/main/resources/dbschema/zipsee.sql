-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zipsee
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zipsee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zipsee` DEFAULT CHARACTER SET utf8 ;
USE `zipsee` ;

-- -----------------------------------------------------
-- Table `zipsee`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`USER` (
  `USER_ID` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `NICK_NAME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `PHONE` VARCHAR(45) NOT NULL,
  `SEX` VARCHAR(45) NOT NULL,
  `REGISTER_DATE` DATETIME NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `user_id_UNIQUE` (`USER_ID` ASC) VISIBLE,
  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`INTEREST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`INTEREST` (
  `INTEREST_ID` INT NOT NULL AUTO_INCREMENT,
  `INTEREST_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`INTEREST_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`USER_INTEREST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`USER_INTEREST` (
  `USER_INTEREST_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` VARCHAR(45) NOT NULL,
  `INTEREST_ID` INT NOT NULL,
  PRIMARY KEY (`USER_INTEREST_ID`),
  INDEX `user_interest_userid_fk_idx` (`USER_ID` ASC) VISIBLE,
  INDEX `user_interest_interestid_fk_idx` (`INTEREST_ID` ASC) VISIBLE,
  CONSTRAINT `user_interest_userid_fk`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `zipsee`.`USER` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_interest_interestid_fk`
    FOREIGN KEY (`INTEREST_ID`)
    REFERENCES `zipsee`.`INTEREST` (`INTEREST_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`DONG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`DONG` (
  `DONG_CODE` VARCHAR(45) NOT NULL,
  `DONG_NAME` VARCHAR(45) NULL,
  `GUGUN_NAME` VARCHAR(45) NULL,
  `SIDO_NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`DONG_CODE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`USER_DONG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`USER_DONG` (
  `USER_DONG_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` VARCHAR(45) NOT NULL,
  `DONG_CODE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USER_DONG_ID`),
  INDEX `user_dong_userid_fk_idx` (`USER_ID` ASC) VISIBLE,
  INDEX `user_dong_dongcode_fk_idx` (`DONG_CODE` ASC) VISIBLE,
  CONSTRAINT `user_dong_userid_fk`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `zipsee`.`USER` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_dong_dongcode_fk`
    FOREIGN KEY (`DONG_CODE`)
    REFERENCES `zipsee`.`DONG` (`DONG_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`HOUSEINFO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`HOUSEINFO` (
  `HOUSE_ID` INT NOT NULL AUTO_INCREMENT,
  `HOUSE_NAME` VARCHAR(45) NOT NULL,
  `HOUSE_TYPE` VARCHAR(45) NOT NULL,
  `DONG_CODE` VARCHAR(45) NOT NULL,
  `DONG_NAME` VARCHAR(45) NULL,
  `BUILD_YEAR` INT NULL,
  `JIBUN` VARCHAR(45) NULL,
  `LAT` VARCHAR(45) NOT NULL,
  `LNG` VARCHAR(45) NOT NULL,
  `IMG` VARCHAR(45) NULL,
  INDEX `house_dong_dongcode_fk_idx` (`DONG_CODE` ASC) VISIBLE,
  PRIMARY KEY (`HOUSE_ID`),
  CONSTRAINT `house_dong_dongcode_fk`
    FOREIGN KEY (`DONG_CODE`)
    REFERENCES `zipsee`.`DONG` (`DONG_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`HOUSEDEAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`HOUSEDEAL` (
  `DEAL_ID` INT NOT NULL,
  `HOUSE_ID` INT NULL,
  `AREA` INT NULL,
  `FLOOR` INT NULL,
  `DEAL_TYPE` VARCHAR(45) NOT NULL,
  `PRICE` INT NULL,
  PRIMARY KEY (`DEAL_ID`),
  INDEX `deal_info_houseid_fk_idx` (`HOUSE_ID` ASC) VISIBLE,
  CONSTRAINT `deal_info_houseid_fk`
    FOREIGN KEY (`HOUSE_ID`)
    REFERENCES `zipsee`.`HOUSEINFO` (`HOUSE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`USER_DEAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`USER_DEAL` (
  `USER_DEAL_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` VARCHAR(45) NOT NULL,
  `DEAL_ID` INT NOT NULL,
  PRIMARY KEY (`USER_DEAL_ID`),
  INDEX `user_deal_userid_fk_idx` (`USER_ID` ASC) VISIBLE,
  INDEX `user_deal_dealid_fk_idx` (`DEAL_ID` ASC) VISIBLE,
  CONSTRAINT `user_deal_userid_fk`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `zipsee`.`USER` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_deal_dealid_fk`
    FOREIGN KEY (`DEAL_ID`)
    REFERENCES `zipsee`.`HOUSEDEAL` (`DEAL_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`BOARD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`BOARD` (
  `BOARD_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` VARCHAR(45) NOT NULL,
  `TITLE` VARCHAR(45) NOT NULL,
  `CONTENT` VARCHAR(45) NOT NULL,
  `REGISTER_DATE` DATETIME NOT NULL,
  PRIMARY KEY (`BOARD_ID`),
  INDEX `board_user_userid_fk_idx` (`USER_ID` ASC) VISIBLE,
  CONSTRAINT `board_user_userid_fk`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `zipsee`.`USER` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zipsee`.`COMMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zipsee`.`COMMENT` (
  `COMMENT_ID` INT NOT NULL AUTO_INCREMENT,
  `BOARD_ID` VARCHAR(45) NOT NULL,
  `CONTENT` VARCHAR(45) NOT NULL,
  `REGISTER_DATE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`COMMENT_ID`),
  INDEX `board_comment_commentid_fk_idx` (`BOARD_ID` ASC) VISIBLE,
  CONSTRAINT `board_comment_commentid_fk`
    FOREIGN KEY (`BOARD_ID`)
    REFERENCES `zipsee`.`BOARD` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
