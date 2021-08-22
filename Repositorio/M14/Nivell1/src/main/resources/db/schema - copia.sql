-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema White_Collar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema White_Collar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `White_Collar` DEFAULT CHARACTER SET utf8 ;
USE `White_Collar` ;

-- -----------------------------------------------------
-- Table `White_Collar`.`Botigues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `White_Collar`.`Botigues` (
  `id` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `capacitat` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `White_Collar`.`Quadres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `White_Collar`.`Quadres` (
  `id` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NULL,
  `preu` FLOAT NOT NULL,
  `data_entrada` DATE NOT NULL,
  `Botigues_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Botigues_id`),
  INDEX `fk_Quadres_Botigues_idx` (`Botigues_id` ASC),
  CONSTRAINT `fk_Quadres_Botigues`
    FOREIGN KEY (`Botigues_id`)
    REFERENCES `White_Collar`.`Botigues` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
