-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bloodtestdiary
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bloodtestdiary
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bloodtestdiary` DEFAULT CHARACTER SET utf8 ;
USE `bloodtestdiary` ;

-- -----------------------------------------------------
-- Table `bloodtestdiary`.`patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bloodtestdiary`.`patients` (
  `idpatient` INT NOT NULL AUTO_INCREMENT,
  `forename` VARCHAR(100) NULL DEFAULT NULL,
  `surname` VARCHAR(100) NULL DEFAULT NULL,
  `DOB` DATE NULL DEFAULT NULL,
  `email` VARCHAR(150) NULL DEFAULT NULL,
  `sex` CHAR(1) NULL DEFAULT NULL,
  `address` VARCHAR(1000) NULL DEFAULT NULL,
  `diagnosis` LONGTEXT NULL DEFAULT NULL,
  `trasplant` LONGTEXT NULL DEFAULT NULL,
  `local_hospital` VARCHAR(200) NULL DEFAULT NULL,
  `surgery` VARCHAR(200) NULL DEFAULT NULL,
  `comments` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idpatient`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bloodtestdiary`.`label`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bloodtestdiary`.`label` (
  `idlabel` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `color` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idlabel`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bloodtestdiary`.`test_carried_over`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bloodtestdiary`.`test_carried_over` (
  `idtest_carried_over` INT NOT NULL AUTO_INCREMENT,
  `OPA` VARCHAR(45) NULL,
  `test_carried_overcol` VARCHAR(45) NULL,
  `date` DATETIME NULL,
  `completed` TINYINT NULL DEFAULT 0,
  `commet` VARCHAR(100) NULL,
  `notified` TINYINT NULL DEFAULT 0,
  `idpatient` INT NULL,
  `idlabel` INT NULL,
  -- INDEX `idpatient` (`idpatient` ASC),
  -- INDEX `idlabel` (`idlabel` ASC),
  PRIMARY KEY (`idtest_carried_over`),
  -- CONSTRAINT `idpatient`
    FOREIGN KEY (`idpatient`)
    REFERENCES `bloodtestdiary`.`patients` (`idpatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  -- CONSTRAINT `idlabel`
    FOREIGN KEY (`idlabel`)
    REFERENCES `bloodtestdiary`.`label` (`idlabel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bloodtestdiary`.`contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bloodtestdiary`.`contacts` (
  `idcontact` INT NOT NULL AUTO_INCREMENT,
  `contactNum` VARCHAR(100) NULL DEFAULT NULL,
  `notes` VARCHAR(100) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL,
  `idpatient` INT NULL,
  PRIMARY KEY (`idcontact`),
  -- INDEX `idpatient` (`idpatient` ASC),
  -- CONSTRAINT `idpatient`
    FOREIGN KEY (`idpatient`)
    REFERENCES `bloodtestdiary`.`patients` (`idpatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bloodtestdiary`.`hospitals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bloodtestdiary`.`hospitals` (
  `idhospital` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`idhospital`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bloodtestdiary`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bloodtestdiary`.`staff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `forename` VARCHAR(100) NULL DEFAULT NULL,
  `surname` VARCHAR(100) NULL DEFAULT NULL,
  `DOB` DATE NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `username` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `notes` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bloodtestdiary`.`test_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bloodtestdiary`.`test_schedule` (
  `idtest_schedule` INT NOT NULL AUTO_INCREMENT,
  `OPA` VARCHAR(45) NULL DEFAULT NULL,
  `date` DATETIME NULL DEFAULT NULL,
  `completed` TINYINT(4) NULL DEFAULT 0,
  `commet` VARCHAR(100) NULL DEFAULT NULL,
  `notified` TINYINT(4) NULL DEFAULT '0',
  `idpatient` INT NULL,
  `idlabel` INT NULL,
  PRIMARY KEY (`idtest_schedule`),
  -- INDEX `idpatient` (`idpatient` ASC),
  -- INDEX `idlabel` (`idlabel` ASC),
  -- CONSTRAINT `idpatient`
    FOREIGN KEY (`idpatient`)
    REFERENCES `bloodtestdiary`.`patients` (`idpatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  -- CONSTRAINT `idlabel`
    FOREIGN KEY (`idlabel`)
    REFERENCES `bloodtestdiary`.`label` (`idlabel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bloodtestdiary`.`label`
-- -----------------------------------------------------
START TRANSACTION;
USE `bloodtestdiary`;
INSERT INTO `bloodtestdiary`.`label` (`idlabel`, `name`, `color`, `description`) VALUES (1, 'Black', 'black', 'Routine Bloods');
INSERT INTO `bloodtestdiary`.`label` (`idlabel`, `name`, `color`, `description`) VALUES (2, 'Red', 'red', 'Urgent Bloods');
INSERT INTO `bloodtestdiary`.`label` (`idlabel`, `name`, `color`, `description`) VALUES (3, 'Blue', 'blue', 'Local Hospital Visit');
INSERT INTO `bloodtestdiary`.`label` (`idlabel`, `name`, `color`, `description`) VALUES (4, 'Aqua', 'aqua', 'Clinic Appoitment');

COMMIT;