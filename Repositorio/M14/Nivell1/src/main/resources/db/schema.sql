-- MySQL Workbench Forward 

-- -----------------------------------------------------
-- Table `White_Collar`.`Botigues`
-- -----------------------------------------------------
--DROP TABLE IF EXISTS `Botigues`;
CREATE TABLE IF NOT EXISTS `Botigues` (
  `id` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `capacitat` INT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `White_Collar`.`Quadres`
-- -----------------------------------------------------
--DROP TABLE IF EXISTS `Quadres`;
CREATE TABLE IF NOT EXISTS `Quadres` (
  `id` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NULL,
  `preu` FLOAT NOT NULL,
  `data_entrada` DATE NOT NULL,
  `Botigues_id` INT NOT NULL,
  PRIMARY KEY (`id`));

