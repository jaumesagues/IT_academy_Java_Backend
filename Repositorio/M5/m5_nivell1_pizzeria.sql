-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: m5_nivell1_pizzeria
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
-- Table structure for table `botigues`
--

DROP TABLE IF EXISTS `botigues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `botigues` (
  `idBotiga` int NOT NULL AUTO_INCREMENT,
  `Adreça` varchar(60) NOT NULL,
  `CP` varchar(5) NOT NULL,
  `idLocalitat` int NOT NULL,
  PRIMARY KEY (`idBotiga`),
  KEY `idLocalitat_idx` (`idLocalitat`),
  CONSTRAINT `fk_idLocalitat` FOREIGN KEY (`idLocalitat`) REFERENCES `localitats` (`idLocalitat`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `botigues`
--

LOCK TABLES `botigues` WRITE;
/*!40000 ALTER TABLE `botigues` DISABLE KEYS */;
INSERT INTO `botigues` VALUES (1,'Carrer Major','08840',2),(2,'Carrer Sants','08080',1),(3,'Carrer Tarraco','43001',4),(4,'Plaça del poble','41001',7);
/*!40000 ALTER TABLE `botigues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories_pizza`
--

DROP TABLE IF EXISTS `categories_pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories_pizza` (
  `idCategoriesPizza` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoriesPizza`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories_pizza`
--

LOCK TABLES `categories_pizza` WRITE;
/*!40000 ALTER TABLE `categories_pizza` DISABLE KEYS */;
INSERT INTO `categories_pizza` VALUES (1,'Infantil'),(2,'Petita'),(3,'Mitjana'),(4,'Familiar');
/*!40000 ALTER TABLE `categories_pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `idClient` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Cognoms` varchar(60) NOT NULL,
  `CP` varchar(5) DEFAULT NULL,
  `idLocalitat` int NOT NULL,
  `Telefon` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  KEY `idLocalitat_idx` (`idLocalitat`),
  CONSTRAINT `idLocalitat` FOREIGN KEY (`idLocalitat`) REFERENCES `localitats` (`idLocalitat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Ovidi','Casals','08840',2,NULL),(2,'Dani','Sa','08080',1,NULL),(3,'Clara','García','43001',4,NULL);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comandes`
--

DROP TABLE IF EXISTS `comandes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comandes` (
  `idComanda` int NOT NULL AUTO_INCREMENT,
  `idClient` int NOT NULL,
  `Data_hora` datetime NOT NULL,
  `Entrega` enum('Domicili','Botiga') NOT NULL COMMENT 'Recollir a botiga, domicili',
  `idRepartidor` int DEFAULT NULL COMMENT 'Només en cas de repartiment a domicili',
  `idBotiga` int NOT NULL,
  `Data_hora_repartiment` datetime DEFAULT NULL COMMENT 'Només en cas de repartiment a domicili',
  PRIMARY KEY (`idComanda`),
  KEY `idRepartidor_idx` (`idRepartidor`),
  KEY `idBotiga_idx` (`idBotiga`),
  KEY `idClient_idx` (`idClient`),
  CONSTRAINT `comandes_fk_idBotiga` FOREIGN KEY (`idBotiga`) REFERENCES `botigues` (`idBotiga`),
  CONSTRAINT `idClient` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  CONSTRAINT `idRepartidor` FOREIGN KEY (`idRepartidor`) REFERENCES `empleats` (`IdEmpleat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comandes`
--

LOCK TABLES `comandes` WRITE;
/*!40000 ALTER TABLE `comandes` DISABLE KEYS */;
INSERT INTO `comandes` VALUES (1,1,'2021-04-07 22:15:00','Domicili',1,1,NULL),(2,2,'2021-04-07 23:00:00','Botiga',NULL,2,NULL),(3,3,'2021-04-07 23:00:00','Botiga',NULL,3,NULL);
/*!40000 ALTER TABLE `comandes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleats`
--

DROP TABLE IF EXISTS `empleats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleats` (
  `IdEmpleat` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Cognoms` varchar(60) NOT NULL,
  `NIF` varchar(9) NOT NULL,
  `Telefon` varchar(9) DEFAULT NULL,
  `Posicio` enum('Repartidor','Cuiner') DEFAULT NULL COMMENT 'Cuiner o repartidor',
  `idBotiga` int NOT NULL,
  PRIMARY KEY (`IdEmpleat`),
  KEY `idBotiga_idx` (`idBotiga`),
  CONSTRAINT `idBotiga` FOREIGN KEY (`idBotiga`) REFERENCES `botigues` (`idBotiga`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleats`
--

LOCK TABLES `empleats` WRITE;
/*!40000 ALTER TABLE `empleats` DISABLE KEYS */;
INSERT INTO `empleats` VALUES (1,'Jaume','Sagues','1','936582415','Repartidor',1),(2,'Jordi','Sagues','2',NULL,'Cuiner',1),(3,'Shery','Martínez','3',NULL,'Repartidor',2),(4,'Nando','Orihuela','4',NULL,'Cuiner',2);
/*!40000 ALTER TABLE `empleats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localitats`
--

DROP TABLE IF EXISTS `localitats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localitats` (
  `idLocalitat` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `idProvincia` int NOT NULL,
  PRIMARY KEY (`idLocalitat`),
  KEY `idProvincia_idx` (`idProvincia`),
  CONSTRAINT `idProvincia` FOREIGN KEY (`idProvincia`) REFERENCES `provincies` (`idProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localitats`
--

LOCK TABLES `localitats` WRITE;
/*!40000 ALTER TABLE `localitats` DISABLE KEYS */;
INSERT INTO `localitats` VALUES (1,'Barcelona',1),(2,'Viladecans',1),(3,'Cornella',1),(4,'Tarragona',2),(5,'Reus',2),(6,'Salou',2),(7,'Lleida',3),(8,'Girona',4);
/*!40000 ALTER TABLE `localitats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productes`
--

DROP TABLE IF EXISTS `productes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productes` (
  `idProducte` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Descripcio` text,
  `Imatge` varchar(120) DEFAULT NULL,
  `Preu` float NOT NULL,
  `Tipus` enum('Beguda','Hamburguesa','Pizza') DEFAULT NULL COMMENT 'Beguda, pizza o hamburguesa',
  `idCategoriaPizza` int DEFAULT NULL COMMENT 'En cas que sigui pizza, s''emmagatzema l''identificador de la categoria de pizza',
  PRIMARY KEY (`idProducte`),
  KEY `idCategoriaPizza_idx` (`idCategoriaPizza`),
  CONSTRAINT `idCategoriaPizza` FOREIGN KEY (`idCategoriaPizza`) REFERENCES `categories_pizza` (`idCategoriesPizza`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productes`
--

LOCK TABLES `productes` WRITE;
/*!40000 ALTER TABLE `productes` DISABLE KEYS */;
INSERT INTO `productes` VALUES (1,'Cocacola',NULL,NULL,1.5,'Beguda',NULL),(2,'Hamburguesa completa',NULL,NULL,6,'Hamburguesa',NULL),(3,'Pizza infantil',NULL,NULL,8,'Pizza',1),(4,'Pizza carbonara mediana',NULL,NULL,10,'Pizza',3),(5,'Pizza barbacoa familiar',NULL,NULL,15,'Pizza',4);
/*!40000 ALTER TABLE `productes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincies`
--

DROP TABLE IF EXISTS `provincies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincies` (
  `idProvincia` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  PRIMARY KEY (`idProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincies`
--

LOCK TABLES `provincies` WRITE;
/*!40000 ALTER TABLE `provincies` DISABLE KEYS */;
INSERT INTO `provincies` VALUES (1,'Barcelona'),(2,'Tarragona'),(3,'Lleida'),(4,'Girona');
/*!40000 ALTER TABLE `provincies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_comandes_productes`
--

DROP TABLE IF EXISTS `rel_comandes_productes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_comandes_productes` (
  `idRel_Comandes_Productes` int NOT NULL AUTO_INCREMENT,
  `idComanda` int NOT NULL,
  `idProducte` int NOT NULL,
  `Quantitat` int DEFAULT NULL,
  PRIMARY KEY (`idRel_Comandes_Productes`),
  KEY `idComanda_idx` (`idComanda`),
  KEY `idProducte_idx` (`idProducte`),
  CONSTRAINT `idComanda` FOREIGN KEY (`idComanda`) REFERENCES `comandes` (`idComanda`),
  CONSTRAINT `idProducte` FOREIGN KEY (`idProducte`) REFERENCES `productes` (`idProducte`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_comandes_productes`
--

LOCK TABLES `rel_comandes_productes` WRITE;
/*!40000 ALTER TABLE `rel_comandes_productes` DISABLE KEYS */;
INSERT INTO `rel_comandes_productes` VALUES (1,1,1,3),(2,1,2,1),(3,1,3,4),(4,2,3,2),(5,2,3,3),(6,3,5,1),(7,3,1,2);
/*!40000 ALTER TABLE `rel_comandes_productes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-07 22:24:09
