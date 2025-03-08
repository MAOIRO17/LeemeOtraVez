-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `numCompra` varchar(255) DEFAULT NULL,
  `precioTotal` double NOT NULL,
  `usuario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4lnkw9964v2gf3b2sjbaealqw` (`usuario_id`),
  CONSTRAINT `FK4lnkw9964v2gf3b2sjbaealqw` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (9,'2025-03-08 16:38:56.945000','831',29,7),(10,'2025-03-08 16:45:06.829000','829',40,7),(11,'2025-03-08 16:49:28.144000','201',12,7),(12,'2025-03-08 16:56:39.444000','341',20,7),(13,'2025-03-08 17:15:54.635000','485',13,8);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compras`
--

DROP TABLE IF EXISTS `detalle_compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad` double NOT NULL,
  `precio` double NOT NULL,
  `precioTotal` double NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `compra_id` bigint DEFAULT NULL,
  `libro_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs7ksdchwhuo5bv58t28iti0f0` (`compra_id`),
  KEY `FKhs6wfu4hw43aov8kpo6a3mdbu` (`libro_id`),
  CONSTRAINT `FKhs6wfu4hw43aov8kpo6a3mdbu` FOREIGN KEY (`libro_id`) REFERENCES `libros` (`id`),
  CONSTRAINT `FKs7ksdchwhuo5bv58t28iti0f0` FOREIGN KEY (`compra_id`) REFERENCES `compras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compras`
--

LOCK TABLES `detalle_compras` WRITE;
/*!40000 ALTER TABLE `detalle_compras` DISABLE KEYS */;
INSERT INTO `detalle_compras` VALUES (10,2,10,20,'Metamorfosis',9,10),(11,1,9,9,'El principito',9,14),(12,2,15,30,'Los pilares de la tierra',10,11),(13,1,10,10,'Metamorfosis',10,10),(14,1,12,12,'El médico',11,9),(15,2,10,20,'Antología poética',12,13),(16,1,13,13,'El psicoanalista',13,15);
/*!40000 ALTER TABLE `detalle_compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `categoria` enum('ACCIÓN','CÓMIC','FANTASÍA','NOVELA','POESÍA') DEFAULT NULL,
  `idioma` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd32ydqw52st17vxwqkxa8kckk` (`usuario_id`),
  CONSTRAINT `FKd32ydqw52st17vxwqkxa8kckk` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (9,'Noah Gordon',2,'NOVELA',NULL,'medico.jpg',12,'El médico',5),(10,'Frank Kafka',2,'FANTASÍA',NULL,'metamorfosis.jpg',10,'Metamorfosis',5),(11,'Ken Follet',3,'FANTASÍA',NULL,'los-pilares-de-la-tierra.jpg',15,'Los pilares de la tierra',5),(12,'Vladimir Nabokov',1,'NOVELA',NULL,'default.jpg',8,'Lolita',5),(13,'Mario Benedetti',2,'POESÍA',NULL,'antologia.png',10,'Antología poética',5),(14,'Antoine de Saint-Exupéry',3,'FANTASÍA',NULL,'EL-PRINCIPITO.png',9,'El principito',5),(15,'John Katzenbach',2,'ACCIÓN',NULL,'psico.png',13,'El psicoanalista',5),(16,'Mahoma',1,'NOVELA',NULL,'El-coran.jpg',12,'Corán',5);
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `tlf` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (5,'Lugo','carlos@gmail.com','Carlos','$2a$10$So3CtEJgL4az9EOS48WtQeQ0ABVmfaEseGbWCYApT.tgkB34oJICK','ADMIN',NULL,'Carlos',NULL),(6,'Pontevedra','maria@gmail.com','Maria','$2a$10$5HmBh3yIH1hDFsCLWFlHeOtK5tI.G/QcTSTwMSO2AgMroubCP3GG2','USUARIO',NULL,'Maria',NULL),(7,'Madrid','bea@gmail.com','Bea','$2a$10$94vQGuDl2GiSYGTkQX1Mi.sk7a5QHWegWetyM0UZe1dmZPzPwTJwO','USUARIO',NULL,'Bea',NULL),(8,'Francia','ivan@gmail.com','Ivan','$2a$10$8NutmnhUavQe34RM.ghM5eTET0VMZb4Azc1OGUwbHwRdW9TGad6Wy','USUARIO',NULL,'Ivan',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-08 17:25:11
