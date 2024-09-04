CREATE DATABASE  IF NOT EXISTS `eventos` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eventos`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: bty3pfyl9co1lwu9psk9-mysql.services.clever-cloud.com    Database: bty3pfyl9co1lwu9psk9
-- ------------------------------------------------------
-- Server version	8.0.22-13

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'a05a675a-1414-11e9-9c82-cecd01b08c7e:1-491550428,
a38a16d0-767a-11eb-abe2-cecd029e558e:1-465473338';

--
-- Table structure for table `administrativos`
--

DROP TABLE IF EXISTS `administrativos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrativos` (
  `id_persona` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `nro_documento` varchar(15) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_documento` varchar(10) NOT NULL,
  `id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `UQ_tipo_nro_documento` (`tipo_documento`,`nro_documento`),
  KEY `FK_administrativos_usuarios` (`id_usuario`),
  CONSTRAINT `FK_administrativos_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrativos`
--

LOCK TABLES `administrativos` WRITE;
/*!40000 ALTER TABLE `administrativos` DISABLE KEYS */;
INSERT INTO `administrativos` VALUES (1,'A_Benedetti','1999-06-06','A_Juan','41907416','3444509526','DNI',1);
/*!40000 ALTER TABLE `administrativos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_persona` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `nro_documento` varchar(15) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_documento` varchar(10) NOT NULL,
  `id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `UQ_tipo_nro_documento` (`tipo_documento`,`nro_documento`),
  KEY `FK_clientes_usuarios` (`id_usuario`),
  CONSTRAINT `FK_clientes_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'C_Benedetti','1999-06-06','C_Juan','41907416','3444509526','DNI',1),(2,'Fivago','2002-07-12','Mvplace','11222333','3444522222','DNI',2),(3,'Benedetti','1999-06-06','Juan Ignacio','41444555','3444555777','DNI',3),(4,'Benedetti','2005-09-16','Federica ','46778824','3444418783','DNI',4);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `nro_reserva` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_personas` int DEFAULT NULL,
  `fecha_evento` datetime(6) DEFAULT NULL,
  `fecha_reserva` datetime(6) DEFAULT NULL,
  `id_cliente` bigint NOT NULL,
  `id_salon` bigint NOT NULL,
  `costo_total` double DEFAULT NULL,
  PRIMARY KEY (`nro_reserva`),
  KEY `FK_eventos_clientes` (`id_cliente`),
  KEY `FK_eventos_salones` (`id_salon`),
  CONSTRAINT `FK_eventos_clientes` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_persona`),
  CONSTRAINT `FK_eventos_salones` FOREIGN KEY (`id_salon`) REFERENCES `salones` (`id_salon`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,151,'2023-04-20 00:00:00.000000','2023-04-20 19:31:25.533000',1,2,NULL);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos_servicios`
--

DROP TABLE IF EXISTS `eventos_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos_servicios` (
  `nro_reserva` bigint NOT NULL,
  `id_servicio` bigint NOT NULL,
  PRIMARY KEY (`nro_reserva`,`id_servicio`),
  KEY `FK_eventos_servicios_servicios` (`id_servicio`),
  CONSTRAINT `FK_eventos_servicios_eventos` FOREIGN KEY (`nro_reserva`) REFERENCES `eventos` (`nro_reserva`),
  CONSTRAINT `FK_eventos_servicios_servicios` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos_servicios`
--

LOCK TABLES `eventos_servicios` WRITE;
/*!40000 ALTER TABLE `eventos_servicios` DISABLE KEYS */;
INSERT INTO `eventos_servicios` VALUES (1,3);
/*!40000 ALTER TABLE `eventos_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_OWNER'),(3,'ROLE_CLIENT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_usuarios`
--

DROP TABLE IF EXISTS `roles_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles_usuarios` (
  `id_usuario` bigint NOT NULL,
  `id_rol` bigint NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_rol`),
  KEY `FK_roles_usuarios_roles` (`id_rol`),
  CONSTRAINT `FK_roles_usuarios_roles` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`),
  CONSTRAINT `FK_roles_usuarios_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_usuarios`
--

LOCK TABLES `roles_usuarios` WRITE;
/*!40000 ALTER TABLE `roles_usuarios` DISABLE KEYS */;
INSERT INTO `roles_usuarios` VALUES (1,1),(1,3);
/*!40000 ALTER TABLE `roles_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salones`
--

DROP TABLE IF EXISTS `salones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salones` (
  `id_salon` bigint NOT NULL AUTO_INCREMENT,
  `capacidad` int DEFAULT NULL,
  `costo_por_dia` double NOT NULL,
  `denominacion` varchar(255) DEFAULT NULL,
  `id_administrativo` bigint NOT NULL,
  `nombre_imagen` varchar(255) DEFAULT NULL,
  `calle_direccion` varchar(255) DEFAULT NULL,
  `numero_direccion` int DEFAULT NULL,
  `descripcion` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`id_salon`),
  KEY `FK_salones_administrativos` (`id_administrativo`),
  CONSTRAINT `FK_salones_administrativos` FOREIGN KEY (`id_administrativo`) REFERENCES `administrativos` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salones`
--

LOCK TABLES `salones` WRITE;
/*!40000 ALTER TABLE `salones` DISABLE KEYS */;
INSERT INTO `salones` VALUES (1,75,195000,'Variedades Eventos',1,'variedadesEventos','Rivadavia',171,'Variedades Eventos es el lugar ideal para celebraciones únicas y personalizadas. Nuestro salón cuenta con una ubicación céntrica, brindando comodidad y accesibilidad a tus invitados. Ofrecemos un espacio amplio y acogedor para que disfrutes de momentos inolvidables.'),(2,200,280000,'Faro del Lago',1,'faroDelLago','Ruta Nac. 12',235,'Faro del Lago es el lugar ideal para tu próximo evento. Con unas impresionantes vistas al lago, este salón ofrece un ambiente moderno y elegante para todo tipo de celebraciones. Con capacidad para hasta 200 personas, Faro del Lago cuenta con todas las comodidades necesarias para hacer de tu evento una experiencia inigualable.'),(3,120,220000,'Club Social',1,'clubSocial','1 de Mayo',83,'Club Social Gualeguay es un espacio histórico y elegante ubicado en una zona céntrica de la ciudad. Ofrecemos un salón ideal para eventos de todo tipo, brindando un ambiente exclusivo y distinguido para celebraciones inolvidables.'),(4,130,200000,'Olay\'s',1,'olays','Av. Presidente Illia',1320,'Olay\'s brinda un ambiente sofisticado para cualquier tipo de evento. Con una ubicación privilegiada en la ciudad, nuestras instalaciones ofrecen un espacio versátil y equipado para satisfacer todas las necesidades de los clientes más exigentes.'),(5,80,150000,'La Compañía',1,'laCompania','Prof. Roberto Moran',30,'La Compañía es el espacio perfecto para tus celebraciones. Con áreas verdes al aire libre y un salón amplio y versátil, nuestro lugar se adapta a cualquier tipo de festejo. Contamos con todas las comodidades necesarias para hacer que tu evento sea un éxito.');
/*!40000 ALTER TABLE `salones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `id_servicio` bigint NOT NULL AUTO_INCREMENT,
  `costo_por_dia` double NOT NULL,
  `denominacion` varchar(255) NOT NULL,
  `id_tipo_servicio` bigint NOT NULL,
  PRIMARY KEY (`id_servicio`),
  KEY `FK_servicios_tipos_servicios` (`id_tipo_servicio`),
  CONSTRAINT `FK_servicios_tipos_servicios` FOREIGN KEY (`id_tipo_servicio`) REFERENCES `tipos_servicios` (`id_tipo_servicio`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,4000,'Entrada',1),(2,5000,'Postre',1),(3,15000,'Cantante',2),(4,9000,'Proyección',2),(5,3000,'Guardarropas',4),(30,15000,'Glitter Bar',2);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_servicios`
--

DROP TABLE IF EXISTS `tipos_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_servicios` (
  `id_tipo_servicio` bigint NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tipo_servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_servicios`
--

LOCK TABLES `tipos_servicios` WRITE;
/*!40000 ALTER TABLE `tipos_servicios` DISABLE KEYS */;
INSERT INTO `tipos_servicios` VALUES (1,'Catering'),(2,'Entretenimiento'),(3,'Decoración'),(4,'Otros');
/*!40000 ALTER TABLE `tipos_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `activo` char(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`),
  UNIQUE KEY `UK_m2dvbwfge291euvmk6vkkocao` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'T','rajawan998@luxeic.com','$2a$10$oxdMpFaLQe4xQuHExUVrI.OukVITlvXgq84LPLTqQuZ/nd02R4y2y','admin'),(2,'T','fivagoj262@mvpalace.com','$2a$10$urGVBg6ey2BrDZPwdfsVgewHupCqVe5zQz84YHttY4M5b9Nsr/4SG','fivago'),(3,'T','juani_benedetti@hotmail.com.ar','$2a$10$tOGRwdw5RHtTIMwyWloLmut2vaJUo4Q2/XwzGlqkup2m1Bnzul7tG','Juani'),(4,'T','benedettifederica597@gmail.com','$2a$10$iWSLz3W6YrYPcO9oJMBtf.w2yAZNcP3Y0NulUEgE..2bsIe/3/ozq','Federica'),(5,'T','linon19241@apifan.com','$2a$10$76BuihruikYe.3FOvwj93eK2cYESZ07nWtt1vZbf.Q0vr9rLvjBDq','linon');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_verificacion`
--

DROP TABLE IF EXISTS `usuarios_verificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_verificacion` (
  `id_usuario_verificacion` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) DEFAULT NULL,
  `fecha_hora_expiracion` datetime(6) DEFAULT NULL,
  `id_usuario` bigint NOT NULL,
  PRIMARY KEY (`id_usuario_verificacion`),
  KEY `FK_usuarios_verificacion_usuarios` (`id_usuario`),
  CONSTRAINT `FK_usuarios_verificacion_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_verificacion`
--

LOCK TABLES `usuarios_verificacion` WRITE;
/*!40000 ALTER TABLE `usuarios_verificacion` DISABLE KEYS */;
INSERT INTO `usuarios_verificacion` VALUES (1,'839813','2023-03-08 21:02:04.062435',1),(2,'252685','2024-08-03 03:33:01.026956',2),(3,'726914','2024-08-03 03:36:24.739437',3),(4,'319976','2024-08-03 23:10:17.708528',4),(5,'113214','2024-08-25 17:54:21.283435',5);
/*!40000 ALTER TABLE `usuarios_verificacion` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-26 11:35:02
