-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: m5_nivell2_youtube
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
-- Table structure for table `canals`
--

DROP TABLE IF EXISTS `canals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canals` (
  `idCanal` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Descripcio` text,
  `Data_creacio` date DEFAULT NULL,
  `idUsuari_creador` int NOT NULL,
  PRIMARY KEY (`idCanal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canals`
--

LOCK TABLES `canals` WRITE;
/*!40000 ALTER TABLE `canals` DISABLE KEYS */;
INSERT INTO `canals` VALUES (1,'Jaume','Canal del jaume','2021-07-12',1),(2,'Shery','Canal de Shery','2021-07-12',2);
/*!40000 ALTER TABLE `canals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentaris`
--

DROP TABLE IF EXISTS `comentaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentaris` (
  `idComentari` int NOT NULL AUTO_INCREMENT,
  `idUsuari` int NOT NULL,
  `idVideo` int NOT NULL,
  `Comentari` text NOT NULL,
  `Data_creacio` datetime NOT NULL,
  PRIMARY KEY (`idComentari`),
  KEY `Usuari_idx` (`idUsuari`),
  KEY `Video_idx` (`idVideo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentaris`
--

LOCK TABLES `comentaris` WRITE;
/*!40000 ALTER TABLE `comentaris` DISABLE KEYS */;
INSERT INTO `comentaris` VALUES (1,1,2,'Muy bueno','2021-07-12 00:00:00'),(2,2,1,'Muy divertido','2021-07-12 00:00:00');
/*!40000 ALTER TABLE `comentaris` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiquetes`
--

DROP TABLE IF EXISTS `etiquetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiquetes` (
  `idEtiqueta` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  PRIMARY KEY (`idEtiqueta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiquetes`
--

LOCK TABLES `etiquetes` WRITE;
/*!40000 ALTER TABLE `etiquetes` DISABLE KEYS */;
INSERT INTO `etiquetes` VALUES (1,'Casero'),(2,'Viajes');
/*!40000 ALTER TABLE `etiquetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes_dislikes`
--

DROP TABLE IF EXISTS `likes_dislikes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes_dislikes` (
  `Like_Dislike` enum('Like','Dislike') NOT NULL,
  `idUsuari` int NOT NULL,
  `idVideo` int NOT NULL,
  `Data_creacio` datetime NOT NULL,
  PRIMARY KEY (`idUsuari`,`idVideo`),
  KEY `fk_Likes_Dislikes_Videos1_idx` (`idVideo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes_dislikes`
--

LOCK TABLES `likes_dislikes` WRITE;
/*!40000 ALTER TABLE `likes_dislikes` DISABLE KEYS */;
INSERT INTO `likes_dislikes` VALUES ('Like',1,2,'2021-07-12 00:00:00'),('Dislike',2,1,'2021-07-12 00:00:00');
/*!40000 ALTER TABLE `likes_dislikes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes_dislikes_comentaris`
--

DROP TABLE IF EXISTS `likes_dislikes_comentaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes_dislikes_comentaris` (
  `Like_Dislike` enum('Like','Dislike') NOT NULL,
  `Data_creacio` datetime NOT NULL,
  `idUsuari` int NOT NULL,
  `idComentari` int NOT NULL,
  PRIMARY KEY (`idUsuari`,`idComentari`),
  KEY `fk_Likes_Dislikes_Comentaris_Comentaris1_idx` (`idComentari`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes_dislikes_comentaris`
--

LOCK TABLES `likes_dislikes_comentaris` WRITE;
/*!40000 ALTER TABLE `likes_dislikes_comentaris` DISABLE KEYS */;
INSERT INTO `likes_dislikes_comentaris` VALUES ('Like','2021-07-12 00:00:00',1,2),('Dislike','2021-07-12 00:00:00',2,1);
/*!40000 ALTER TABLE `likes_dislikes_comentaris` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlists` (
  `idPlaylist` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Data_creacio` date NOT NULL,
  `Estat` enum('Publica','Privada') NOT NULL,
  `idUsuari` int NOT NULL,
  PRIMARY KEY (`idPlaylist`),
  KEY `Usuari_idx` (`idUsuari`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES (1,'Lista de Jaume','2021-07-12','Publica',1),(2,'Lista de Shery','2021-07-12','Publica',2);
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_playlist_videos`
--

DROP TABLE IF EXISTS `rel_playlist_videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_playlist_videos` (
  `idPlaylist` int NOT NULL,
  `idVideo` int NOT NULL,
  PRIMARY KEY (`idPlaylist`,`idVideo`),
  KEY `fk_Rel_Playlist_Videos_Videos1_idx` (`idVideo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_playlist_videos`
--

LOCK TABLES `rel_playlist_videos` WRITE;
/*!40000 ALTER TABLE `rel_playlist_videos` DISABLE KEYS */;
INSERT INTO `rel_playlist_videos` VALUES (1,1),(2,1),(1,2),(2,2);
/*!40000 ALTER TABLE `rel_playlist_videos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_videos_etiquetes`
--

DROP TABLE IF EXISTS `rel_videos_etiquetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_videos_etiquetes` (
  `idRel_Videos_Etiquetes` int NOT NULL AUTO_INCREMENT,
  `IdVideo` int NOT NULL,
  `IdEtiqueta` int NOT NULL,
  PRIMARY KEY (`idRel_Videos_Etiquetes`),
  KEY `idVideo_idx` (`IdVideo`),
  KEY `idEtiqueta_idx` (`IdEtiqueta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_videos_etiquetes`
--

LOCK TABLES `rel_videos_etiquetes` WRITE;
/*!40000 ALTER TABLE `rel_videos_etiquetes` DISABLE KEYS */;
INSERT INTO `rel_videos_etiquetes` VALUES (1,1,1),(2,1,2),(3,2,1),(4,2,2);
/*!40000 ALTER TABLE `rel_videos_etiquetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suscripcions`
--

DROP TABLE IF EXISTS `suscripcions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suscripcions` (
  `idSuscripcio` int NOT NULL AUTO_INCREMENT,
  `idUsuari` int NOT NULL,
  `idCanal` int NOT NULL,
  PRIMARY KEY (`idSuscripcio`),
  KEY `idUsuari_idx` (`idUsuari`),
  KEY `Canal_idx` (`idCanal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suscripcions`
--

LOCK TABLES `suscripcions` WRITE;
/*!40000 ALTER TABLE `suscripcions` DISABLE KEYS */;
INSERT INTO `suscripcions` VALUES (1,1,2),(2,2,1);
/*!40000 ALTER TABLE `suscripcions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuaris`
--

DROP TABLE IF EXISTS `usuaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuaris` (
  `idUsuari` int NOT NULL AUTO_INCREMENT,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Nom` varchar(45) NOT NULL,
  `Naixement` date DEFAULT NULL,
  `Sexe` enum('Home','Dona') DEFAULT NULL,
  `Pais` varchar(45) DEFAULT NULL,
  `CP` varchar(5) DEFAULT NULL,
  `idCanal` int DEFAULT NULL,
  PRIMARY KEY (`idUsuari`),
  KEY `fk_Usuaris_Canales1_idx` (`idCanal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuaris`
--

LOCK TABLES `usuaris` WRITE;
/*!40000 ALTER TABLE `usuaris` DISABLE KEYS */;
INSERT INTO `usuaris` VALUES (1,'jaumesagues@yahoo.es','1234','Jaume Sagués Rodas','1979-02-03','Home','España','08840',1),(2,'shery@hotmail','5678','Shery Martínez','1982-06-15','Dona','Peru','08940',2);
/*!40000 ALTER TABLE `usuaris` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `idVideo` int NOT NULL AUTO_INCREMENT,
  `Titol` varchar(100) NOT NULL,
  `Descripcio` text,
  `Grandaria` int NOT NULL,
  `Ruta_archiu` varchar(100) NOT NULL,
  `Durada` float NOT NULL,
  `Thumbnail` blob,
  `Num_reproduccions` int DEFAULT NULL,
  `Estat` enum('public','privat','ocult') NOT NULL,
  `idUsuari_publica` int NOT NULL,
  `Data_publicacio` datetime DEFAULT NULL,
  PRIMARY KEY (`idVideo`),
  KEY `idUsuari_publica_idx` (`idUsuari_publica`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (1,'Video casero','Este es un video casero',100,'raiz',60,NULL,3,'public',1,'2021-07-12 00:00:00'),(2,'Video viaje','Este es un video de viaje',200,'raiz',120,NULL,2,'public',2,'2021-07-12 00:00:00');
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-12 18:23:02
