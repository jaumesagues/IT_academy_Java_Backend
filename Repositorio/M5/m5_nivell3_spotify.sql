-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: m5_nivell3_spotify
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
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albums` (
  `idAlbum` int NOT NULL AUTO_INCREMENT,
  `Titol` varchar(45) NOT NULL,
  `Any_publicacio` year NOT NULL,
  `Portada` blob,
  `idArtista` int NOT NULL,
  PRIMARY KEY (`idAlbum`),
  KEY `fk_Album_Artista_idx` (`idArtista`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums` DISABLE KEYS */;
INSERT INTO `albums` VALUES (1,'Todo tiene su tiempo',2019,NULL,2),(2,'Recopilatorio',2019,NULL,1),(3,'Bandas sonoras de peliculas',2018,NULL,3);
/*!40000 ALTER TABLE `albums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `albums_favorits`
--

DROP TABLE IF EXISTS `albums_favorits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albums_favorits` (
  `idUsuari` int NOT NULL,
  `idAlbum` int NOT NULL,
  PRIMARY KEY (`idUsuari`,`idAlbum`),
  KEY `fk_Albums_favorits_Albums1_idx` (`idAlbum`),
  CONSTRAINT `fk_Albums_favorits_Usuaris1` FOREIGN KEY (`idUsuari`) REFERENCES `usuaris` (`idUsuari`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums_favorits`
--

LOCK TABLES `albums_favorits` WRITE;
/*!40000 ALTER TABLE `albums_favorits` DISABLE KEYS */;
INSERT INTO `albums_favorits` VALUES (2,1),(1,2),(3,3);
/*!40000 ALTER TABLE `albums_favorits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistes`
--

DROP TABLE IF EXISTS `artistes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistes` (
  `idArtista` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Imatge` blob,
  PRIMARY KEY (`idArtista`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistes`
--

LOCK TABLES `artistes` WRITE;
/*!40000 ALTER TABLE `artistes` DISABLE KEYS */;
INSERT INTO `artistes` VALUES (1,'Luis Miguel',NULL),(2,'Juan Luis Guerra',NULL),(3,'Banda Municipal de Música de Barcelona',NULL);
/*!40000 ALTER TABLE `artistes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistes_relacionats`
--

DROP TABLE IF EXISTS `artistes_relacionats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistes_relacionats` (
  `idArtista1` int NOT NULL,
  `idArtista2` int NOT NULL,
  PRIMARY KEY (`idArtista1`,`idArtista2`),
  KEY `fk_Artistes_Relacionats_Artistes2_idx` (`idArtista2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistes_relacionats`
--

LOCK TABLES `artistes_relacionats` WRITE;
/*!40000 ALTER TABLE `artistes_relacionats` DISABLE KEYS */;
INSERT INTO `artistes_relacionats` VALUES (2,1),(1,2);
/*!40000 ALTER TABLE `artistes_relacionats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cançons`
--

DROP TABLE IF EXISTS `cançons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cançons` (
  `idCanço` int NOT NULL AUTO_INCREMENT,
  `Titol` varchar(45) NOT NULL,
  `Durada` int NOT NULL,
  `Num_reproduccions` int NOT NULL DEFAULT '0',
  `idAlbum` int DEFAULT NULL,
  PRIMARY KEY (`idCanço`),
  KEY `fk_Canço_Album_idx` (`idAlbum`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cançons`
--

LOCK TABLES `cançons` WRITE;
/*!40000 ALTER TABLE `cançons` DISABLE KEYS */;
INSERT INTO `cançons` VALUES (1,'Cafe',5,1000,2),(2,'Bachata',10,1500,2),(3,'West Side Story',60,2000,3);
/*!40000 ALTER TABLE `cançons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cançons_favorites`
--

DROP TABLE IF EXISTS `cançons_favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cançons_favorites` (
  `idUsuari` int NOT NULL,
  `idCanço` int NOT NULL,
  PRIMARY KEY (`idUsuari`,`idCanço`),
  KEY `fk_Cançons_favorites_Cançons1_idx` (`idCanço`),
  CONSTRAINT `fk_Cançons_favorites_Usuaris1` FOREIGN KEY (`idUsuari`) REFERENCES `usuaris` (`idUsuari`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cançons_favorites`
--

LOCK TABLES `cançons_favorites` WRITE;
/*!40000 ALTER TABLE `cançons_favorites` DISABLE KEYS */;
INSERT INTO `cançons_favorites` VALUES (1,1),(3,1),(1,2),(2,2),(3,2),(1,3);
/*!40000 ALTER TABLE `cançons_favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cançons_playlist`
--

DROP TABLE IF EXISTS `cançons_playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cançons_playlist` (
  `idPlaylist` int NOT NULL,
  `idCanço` int NOT NULL,
  `idUsuari` int NOT NULL,
  PRIMARY KEY (`idPlaylist`,`idCanço`),
  KEY `fk_Cançons_Playlist_Cançons1_idx` (`idCanço`),
  KEY `fk_Cançons_Playlist_Usuaris1_idx` (`idUsuari`),
  CONSTRAINT `fk_Cançons_Playlist_Playlists1` FOREIGN KEY (`idPlaylist`) REFERENCES `playlists` (`idPlaylist`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cançons_playlist`
--

LOCK TABLES `cançons_playlist` WRITE;
/*!40000 ALTER TABLE `cançons_playlist` DISABLE KEYS */;
INSERT INTO `cançons_playlist` VALUES (1,2,1),(1,1,2),(1,3,3);
/*!40000 ALTER TABLE `cançons_playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagaments`
--

DROP TABLE IF EXISTS `pagaments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagaments` (
  `Num_ordre` int NOT NULL AUTO_INCREMENT,
  `Data` date NOT NULL,
  `Import` float NOT NULL,
  `idSuscripcio` int NOT NULL,
  PRIMARY KEY (`Num_ordre`),
  KEY `fk_pagament_suscripcio_idx` (`idSuscripcio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagaments`
--

LOCK TABLES `pagaments` WRITE;
/*!40000 ALTER TABLE `pagaments` DISABLE KEYS */;
INSERT INTO `pagaments` VALUES (1,'2021-06-01',15,1),(2,'2021-07-01',15,1);
/*!40000 ALTER TABLE `pagaments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlists` (
  `idPlaylist` int NOT NULL AUTO_INCREMENT,
  `Titol` varchar(45) NOT NULL,
  `Data` date NOT NULL,
  `idUsuari` int NOT NULL,
  `Eliminada` bit(1) DEFAULT b'0',
  `Data_eliminacio` date DEFAULT NULL,
  `Compartida` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idPlaylist`),
  KEY `fk_Playlist_Usuari_idx` (`idUsuari`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES (1,'Mi lista','2021-07-12',1,_binary '\0',NULL,_binary '');
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguidors`
--

DROP TABLE IF EXISTS `seguidors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguidors` (
  `idUsuari` int NOT NULL,
  `idArtista` int NOT NULL,
  PRIMARY KEY (`idUsuari`,`idArtista`),
  KEY `fk_Seguidors_Artistes1_idx` (`idArtista`),
  CONSTRAINT `fk_Seguidors_Usuaris1` FOREIGN KEY (`idUsuari`) REFERENCES `usuaris` (`idUsuari`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguidors`
--

LOCK TABLES `seguidors` WRITE;
/*!40000 ALTER TABLE `seguidors` DISABLE KEYS */;
INSERT INTO `seguidors` VALUES (2,1),(1,2),(2,2),(1,3),(3,3);
/*!40000 ALTER TABLE `seguidors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suscripcions`
--

DROP TABLE IF EXISTS `suscripcions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suscripcions` (
  `idSuscripcio` int NOT NULL AUTO_INCREMENT,
  `Data_inici` date NOT NULL,
  `Data_renovacio` date NOT NULL,
  `Forma_pagament` enum('Paypal','Tarjeta') NOT NULL,
  `Usuari_Paypal` varchar(45) DEFAULT NULL,
  `Numer_Tarjeta` char(16) NOT NULL,
  PRIMARY KEY (`idSuscripcio`),
  KEY `fk_Suscripcions_Tarjetes1_idx` (`Numer_Tarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suscripcions`
--

LOCK TABLES `suscripcions` WRITE;
/*!40000 ALTER TABLE `suscripcions` DISABLE KEYS */;
INSERT INTO `suscripcions` VALUES (1,'2021-07-12','2022-07-12','Tarjeta',NULL,'123456789012');
/*!40000 ALTER TABLE `suscripcions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetes`
--

DROP TABLE IF EXISTS `tarjetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetes` (
  `Numero` char(16) NOT NULL,
  `Mes_caducitat` tinyint NOT NULL,
  `Any_caducitat` tinyint NOT NULL,
  `Codi_seguretat` smallint NOT NULL,
  PRIMARY KEY (`Numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetes`
--

LOCK TABLES `tarjetes` WRITE;
/*!40000 ALTER TABLE `tarjetes` DISABLE KEYS */;
INSERT INTO `tarjetes` VALUES ('123456789012',2,24,124);
/*!40000 ALTER TABLE `tarjetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuaris`
--

DROP TABLE IF EXISTS `usuaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuaris` (
  `idUsuari` int NOT NULL AUTO_INCREMENT,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Nom` varchar(45) NOT NULL,
  `Data_naixement` date DEFAULT NULL,
  `Sexe` enum('Home','Dona') DEFAULT NULL,
  `Pais` varchar(45) DEFAULT NULL,
  `CP` varchar(5) DEFAULT NULL,
  `Tipus` enum('Free','Premium') NOT NULL,
  `idSuscripcio` int DEFAULT NULL,
  PRIMARY KEY (`idUsuari`),
  KEY `fk_Usuaris_Suscripcions_idx` (`idSuscripcio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuaris`
--

LOCK TABLES `usuaris` WRITE;
/*!40000 ALTER TABLE `usuaris` DISABLE KEYS */;
INSERT INTO `usuaris` VALUES (1,'jaumesagues@yahoo.es','1234','Jaume Sagués','1979-02-03','Home','Espanya','08940','Free',0),(2,'shery@hotmail','5678','Shery Martínez','1982-06-15','Dona','Peru','08840','Premium',1),(3,'jordisagues@gmail.com','2468','Jordi Sagués','1982-03-11','Home','Espanya','08340','Free',0);
/*!40000 ALTER TABLE `usuaris` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-12 19:29:36
