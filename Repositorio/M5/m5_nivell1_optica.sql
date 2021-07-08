CREATE DATABASE  IF NOT EXISTS `m5_nivell1_optica` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `m5_nivell1_optica`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: m5_nivell1_optica
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `idClient` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(60) NOT NULL,
  `Adreça` varchar(60) DEFAULT NULL,
  `Telefon` varchar(9) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Data_registre` date DEFAULT NULL,
  `idClient_recomanat` int DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  KEY `idClient_recomanat_idx` (`idClient_recomanat`),
  CONSTRAINT `idClient_recomanat` FOREIGN KEY (`idClient_recomanat`) REFERENCES `clients` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (6,'X',NULL,NULL,NULL,NULL,NULL),(7,'Y',NULL,NULL,NULL,NULL,6),(8,'Z',NULL,NULL,NULL,NULL,NULL),(9,'W',NULL,NULL,NULL,NULL,7);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marques`
--

DROP TABLE IF EXISTS `marques`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marques` (
  `idMarca` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `idProveidor` int NOT NULL,
  PRIMARY KEY (`idMarca`),
  KEY `idProveidor_idx` (`idProveidor`),
  CONSTRAINT `idProveidor` FOREIGN KEY (`idProveidor`) REFERENCES `proveidors` (`idProveidor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marques`
--

LOCK TABLES `marques` WRITE;
/*!40000 ALTER TABLE `marques` DISABLE KEYS */;
INSERT INTO `marques` VALUES (1,'Nothifixis',1),(2,'Raiban',3),(3,'MarcaMayor',2);
/*!40000 ALTER TABLE `marques` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `montures`
--

DROP TABLE IF EXISTS `montures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `montures` (
  `idMontura` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  PRIMARY KEY (`idMontura`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `montures`
--

LOCK TABLES `montures` WRITE;
/*!40000 ALTER TABLE `montures` DISABLE KEYS */;
INSERT INTO `montures` VALUES (1,'Flotant'),(2,'Pasta'),(3,'Metal·lica');
/*!40000 ALTER TABLE `montures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveidors`
--

DROP TABLE IF EXISTS `proveidors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveidors` (
  `idProveidor` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(60) NOT NULL,
  `Carrer` varchar(60) DEFAULT NULL,
  `Num_Adreça` int DEFAULT NULL,
  `Pis_Adreça` int DEFAULT NULL,
  `Porta_Adreça` int DEFAULT NULL,
  `Ciutat` varchar(45) DEFAULT NULL,
  `CP` varchar(5) DEFAULT NULL,
  `Pais` varchar(45) DEFAULT NULL,
  `Telefon` varchar(9) DEFAULT NULL,
  `Fax` varchar(9) DEFAULT NULL,
  `NIF` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idProveidor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveidors`
--

LOCK TABLES `proveidors` WRITE;
/*!40000 ALTER TABLE `proveidors` DISABLE KEYS */;
INSERT INTO `proveidors` VALUES (1,'A','Major',1,1,1,'Cornella','08940','Espanya',NULL,NULL,'123456789'),(2,'B','Doctor Arus',3,2,4,'Viladecans','08840','Espanya',NULL,NULL,'987654321'),(3,'C','Sants',54,3,2,'Barcelona','08050','España',NULL,NULL,'135798642');
/*!40000 ALTER TABLE `proveidors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ulleres`
--

DROP TABLE IF EXISTS `ulleres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ulleres` (
  `idUllera` int NOT NULL AUTO_INCREMENT,
  `idMarca` int NOT NULL,
  `Graduacio_dreta` float DEFAULT NULL,
  `Graduacio_esquerra` float DEFAULT NULL,
  `Color_montura` varchar(15) DEFAULT NULL,
  `Color_vidre_dret` varchar(15) DEFAULT NULL,
  `Color_vidre_esquerra` varchar(15) DEFAULT NULL,
  `Preu` float DEFAULT NULL,
  `idClient` int NOT NULL,
  `idVenedor` int NOT NULL,
  `idMontura` int NOT NULL,
  PRIMARY KEY (`idUllera`),
  KEY `idMarca_idx` (`idMarca`),
  KEY `idClient_idx` (`idClient`),
  KEY `idVenedor_idx` (`idVenedor`),
  KEY `fk_Ulleres_Montures1_idx` (`idMontura`),
  CONSTRAINT `fk_Ulleres_Montures1` FOREIGN KEY (`idMontura`) REFERENCES `montures` (`idMontura`),
  CONSTRAINT `idClient` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  CONSTRAINT `idMarca` FOREIGN KEY (`idMarca`) REFERENCES `marques` (`idMarca`),
  CONSTRAINT `idVenedor` FOREIGN KEY (`idVenedor`) REFERENCES `venedors` (`idVenedor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ulleres`
--

LOCK TABLES `ulleres` WRITE;
/*!40000 ALTER TABLE `ulleres` DISABLE KEYS */;
INSERT INTO `ulleres` VALUES (2,1,0.5,0,'Blau','Transparent','Negre',120,6,2,1),(3,3,0,0,'Negre','Negre','Negre',60,7,1,3),(4,2,1,1,'Vermell','Transparent','Transparent',80,8,3,2);
/*!40000 ALTER TABLE `ulleres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venedors`
--

DROP TABLE IF EXISTS `venedors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venedors` (
  `idVenedor` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  PRIMARY KEY (`idVenedor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venedors`
--

LOCK TABLES `venedors` WRITE;
/*!40000 ALTER TABLE `venedors` DISABLE KEYS */;
INSERT INTO `venedors` VALUES (1,'Juan'),(2,'Josep'),(3,'Asa'),(4,'Quico'),(5,'Toni'),(6,'Marcel·li');
/*!40000 ALTER TABLE `venedors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-07 17:17:17
