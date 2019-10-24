CREATE DATABASE  IF NOT EXISTS `inmobiliaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `inmobiliaria`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: inmobiliaria
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquiler` (
  `alquiler_id` int(11) NOT NULL AUTO_INCREMENT,
  `monto_total` decimal(14,2) NOT NULL,
  `moneda` varchar(5) NOT NULL,
  `inmueble_id` int(11) NOT NULL,
  PRIMARY KEY (`alquiler_id`),
  KEY `alquiler_inmueble_FK_idx` (`inmueble_id`),
  CONSTRAINT `alquiler_inmueble_FK` FOREIGN KEY (`inmueble_id`) REFERENCES `inmueble` (`inmueble_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `contrato_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `reserva_id` int(11) NOT NULL,
  PRIMARY KEY (`contrato_id`),
  KEY `contrato_reserva_FK_idx` (`reserva_id`),
  CONSTRAINT `contrato_reserva_FK` FOREIGN KEY (`reserva_id`) REFERENCES `reserva` (`reserva_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmobiliaria`
--

DROP TABLE IF EXISTS `inmobiliaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmobiliaria` (
  `inmobiliaria_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` int(11) NOT NULL,
  `domicilio` varchar(255) NOT NULL,
  PRIMARY KEY (`inmobiliaria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmobiliaria`
--

LOCK TABLES `inmobiliaria` WRITE;
/*!40000 ALTER TABLE `inmobiliaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `inmobiliaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmueble` (
  `inmueble_id` int(11) NOT NULL AUTO_INCREMENT,
  `moneda` varchar(5) NOT NULL,
  `valor` decimal(14,2) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `superficie_total` int(11) NOT NULL,
  `nro_dormitorios` int(11) NOT NULL,
  `total_ambientes` int(11) NOT NULL,
  `cantidad_baños` int(11) NOT NULL,
  `tipo_inmueble` varchar(45) NOT NULL,
  `finalidad` varchar(10) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `barrio` varchar(255) NOT NULL,
  `localidad` varchar(255) NOT NULL,
  `locador_id` int(11) NOT NULL,
  `inmobiliaria_id` int(11) NOT NULL,
  PRIMARY KEY (`inmueble_id`),
  KEY `inmueble_locador_FK_idx` (`locador_id`),
  KEY `inmueble_inmobiliaria_FK_idx` (`inmobiliaria_id`),
  CONSTRAINT `inmueble_inmobiliaria_FK` FOREIGN KEY (`inmobiliaria_id`) REFERENCES `inmobiliaria` (`inmobiliaria_id`),
  CONSTRAINT `inmueble_locador_FK` FOREIGN KEY (`locador_id`) REFERENCES `locador` (`locador_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locador`
--

DROP TABLE IF EXISTS `locador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locador` (
  `locador_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `dni` varchar(25) NOT NULL,
  `email` varchar(255) NOT NULL,
  `domicilio` varchar(255) NOT NULL,
  PRIMARY KEY (`locador_id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locador`
--

LOCK TABLES `locador` WRITE;
/*!40000 ALTER TABLE `locador` DISABLE KEYS */;
/*!40000 ALTER TABLE `locador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locatario`
--

DROP TABLE IF EXISTS `locatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locatario` (
  `locatario_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `dni` varchar(25) NOT NULL,
  `domilicio` varchar(255) NOT NULL,
  `localidad` varchar(255) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` int(11) NOT NULL,
  PRIMARY KEY (`locatario_id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locatario`
--

LOCK TABLES `locatario` WRITE;
/*!40000 ALTER TABLE `locatario` DISABLE KEYS */;
/*!40000 ALTER TABLE `locatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `reserva_id` int(11) NOT NULL AUTO_INCREMENT,
  `alquiler_id` int(11) NOT NULL,
  `venta_id` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`reserva_id`),
  KEY `reserva_alquiler_FK_idx` (`alquiler_id`),
  KEY `reserva_venta_FK_idx` (`venta_id`),
  CONSTRAINT `reserva_alquiler_FK` FOREIGN KEY (`alquiler_id`) REFERENCES `alquiler` (`alquiler_id`),
  CONSTRAINT `reserva_venta_FK` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`venta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `inmobiliaria_id` int(11) NOT NULL,
  `locatario_id` int(11) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `usuario_inmobiliaria_FK_idx` (`inmobiliaria_id`),
  KEY `usuario_locatario_FK_idx` (`locatario_id`),
  CONSTRAINT `usuario_inmobiliaria_FK` FOREIGN KEY (`inmobiliaria_id`) REFERENCES `inmobiliaria` (`inmobiliaria_id`),
  CONSTRAINT `usuario_locatario_FK` FOREIGN KEY (`locatario_id`) REFERENCES `locatario` (`locatario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `venta_id` int(11) NOT NULL AUTO_INCREMENT,
  `meses_alquiler` int(11) NOT NULL,
  `moneda` varchar(5) NOT NULL,
  `monto_total` decimal(14,2) NOT NULL,
  `inmueble_id` int(11) NOT NULL,
  PRIMARY KEY (`venta_id`),
  KEY `venta_inmueble_FK_idx` (`inmueble_id`),
  CONSTRAINT `venta_inmueble_FK` FOREIGN KEY (`inmueble_id`) REFERENCES `inmueble` (`inmueble_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-24 14:56:30
