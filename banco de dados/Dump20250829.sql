-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: enraizar
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendario` (
  `id_calendario` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `data` date NOT NULL DEFAULT (curdate()),
  PRIMARY KEY (`id_calendario`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `calendario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario`
--

LOCK TABLES `calendario` WRITE;
/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
INSERT INTO `calendario` VALUES (1,1,'2025-08-16'),(2,1,'2025-08-28'),(3,1,'2025-08-28'),(4,1,'2025-08-28'),(5,1,'2025-08-28'),(6,1,'2025-08-28'),(7,1,'2025-08-28'),(8,11,'2025-08-28'),(9,11,'2025-08-28'),(10,2,'2025-08-27'),(11,2,'2025-08-26'),(12,2,'2025-08-25'),(13,2,'2025-08-24'),(14,2,'2025-08-23'),(15,2,'2025-08-22'),(16,2,'2025-08-21'),(17,2,'2025-08-20'),(18,2,'2025-08-19'),(19,2,'2025-08-18'),(20,2,'2025-08-17'),(21,2,'2025-08-16'),(22,2,'2025-08-15'),(23,2,'2025-08-14'),(24,2,'2025-08-13');
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario_emocoes`
--

DROP TABLE IF EXISTS `calendario_emocoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendario_emocoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_calendario` int NOT NULL,
  `id_emocao` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_calendario` (`id_calendario`),
  KEY `id_emocao` (`id_emocao`),
  CONSTRAINT `calendario_emocoes_ibfk_1` FOREIGN KEY (`id_calendario`) REFERENCES `calendario` (`id_calendario`),
  CONSTRAINT `calendario_emocoes_ibfk_2` FOREIGN KEY (`id_emocao`) REFERENCES `emocoes` (`id_emocao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario_emocoes`
--

LOCK TABLES `calendario_emocoes` WRITE;
/*!40000 ALTER TABLE `calendario_emocoes` DISABLE KEYS */;
INSERT INTO `calendario_emocoes` VALUES (1,7,1),(2,8,1),(3,9,1),(4,10,1),(5,11,3),(6,12,4),(7,13,5),(8,14,6),(9,15,7),(10,16,5),(11,17,4),(12,18,3),(13,19,1),(14,20,2),(15,21,4),(16,22,3),(17,23,5),(18,24,3);
/*!40000 ALTER TABLE `calendario_emocoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emocoes`
--

DROP TABLE IF EXISTS `emocoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emocoes` (
  `id_emocao` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `valor` int NOT NULL,
  PRIMARY KEY (`id_emocao`),
  CONSTRAINT `emocoes_chk_1` CHECK ((`valor` between 0 and 10))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emocoes`
--

LOCK TABLES `emocoes` WRITE;
/*!40000 ALTER TABLE `emocoes` DISABLE KEYS */;
INSERT INTO `emocoes` VALUES (1,'Muito bem',10),(2,'Bem',8),(3,'Normal',7),(4,'Apático',0),(5,'Complicado',3),(6,'Difícil',2),(7,'Muito difícil',1);
/*!40000 ALTER TABLE `emocoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipes`
--

DROP TABLE IF EXISTS `equipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` tinytext,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipes`
--

LOCK TABLES `equipes` WRITE;
/*!40000 ALTER TABLE `equipes` DISABLE KEYS */;
INSERT INTO `equipes` VALUES (1,'enraizar','equipe enraizar','2025-08-23 19:00:16','2025-08-26 16:55:52');
/*!40000 ALTER TABLE `equipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setores`
--

DROP TABLE IF EXISTS `setores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setores` (
  `id_setor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_setor`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setores`
--

LOCK TABLES `setores` WRITE;
/*!40000 ALTER TABLE `setores` DISABLE KEYS */;
INSERT INTO `setores` VALUES (1,'RH','Recursos Humanos'),(2,'Financeiro','Gestão financeira e contabilidade'),(3,'TI','Tecnologia da Informação'),(4,'Marketing','Comunicação e campanhas'),(5,'Operações','Atividades operacionais da empresa');
/*!40000 ALTER TABLE `setores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_email` varchar(50) NOT NULL,
  `senha` char(60) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `sobrenome` varchar(50) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `id_setor` int DEFAULT NULL,
  `tipo_usuario` enum('Administrador','Colaborador') NOT NULL DEFAULT 'Colaborador',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_email` (`login_email`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `id_setor` (`id_setor`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_setor`) REFERENCES `setores` (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'paulo_enraizar@gmail.com','enraizarp@im','Paulo','Paim','1994-03-26','12345678901',1,'Administrador','2025-08-20 23:00:38','2025-08-20 23:00:38'),(2,'camila_enraizar@gmail.com','2006','Camila','Schmidt','2006-05-11','15004161933',3,'Administrador','2025-08-20 23:01:39','2025-08-20 23:01:39'),(6,'gabrielazz@gmail.com','1234','Gabriela','Zimmerman','2005-03-26','12345678911',3,'Colaborador','2025-08-26 16:14:35','2025-08-26 16:14:35'),(7,'ayla@gmail.com','ayla1','Ayla','Silva','1980-03-21','45690826511',1,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(8,'lucas.almeida@gmail','lucasA2','Lucas','Almeida','1995-03-14','51498263704',2,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(9,'mariana@gmail','mari3','Mariana','Oliveira','1988-07-27','20351786471',3,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(10,'rafa@gmail.com','rafa4','Rafael','Souza','1999-11-05','38542917609',4,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(11,'fefe@gmail.com','fefez6','Fernanda','Costa','1976-01-22','14629573820',5,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(12,'bruninho@hotmail.com','brubru7','Bruno','Martins','1982-09-19','62485391288',1,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(13,'anaBebe@gmail.com','aninha8','Ana','Beatriz Rocha','1993-04-03','75248136907',2,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(14,'carlos.henrique.lima@gmail.com','carlinhos9','Carlos Henrique','Lima','1978-07-16','41396728540',3,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(15,'juliana.mendes@gmail.com','J6kW4rT1','Juliana','Mendes','2000-06-08','23167845902',4,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(16,'diego.ferreira@gmail.com','D5qR7fP3','Diego','Ferreira','1985-08-25','90457261830',5,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(17,'patricia.nogueira@gmail.com','P8vT1sL4','Patrícia','Nogueira','1997-10-30','67235489159',1,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(18,'felipe.araujo@gmail.com','F2kX7nQ8','Felipe','Araújo','1974-02-18','58241937600',2,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(19,'camila.ribeiro@gmail.com','C9sW4mR2','Camila','Ribeiro','2001-05-21','74321980563',3,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(20,'thiago.cardoso@gmail.com','T7hF3pL5','Thiago','Cardoso','1992-07-12','89132457628',4,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(21,'aline.barbosa@gmail.com','A5gR9kT3','Aline','Barbosa','1986-03-09','37521694815',5,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(22,'gabriel.duarte@gmail.com','G4tP8sQ1','Gabriel','Duarte','1973-11-26','12890467340',1,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(23,'larissa.pires@gmail.com','L6vN2fR8','Larissa','Pires','1998-04-04','94761238577',2,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(24,'marcelo.teixeira@gmail.com','M8rT1kS4','Marcelo','Teixeira','1980-09-17','20654893121',3,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(25,'natalia.freitas@gmail.com','N3fP7vL9','Natália','Freitas','1991-01-29','83457216006',4,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(26,'rodrigo.moreira@gmail.com','R5kW2tQ6','Rodrigo','Moreira','1989-08-13','91526374832',5,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(27,'tatiane.gomes@gmail.com','T8mS4rP1','Tatiane','Gomes','2002-02-23','56321489794',1,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(28,'paulo.cesar.vieira@gmail.com','P6fR3kL9','Paulo César','Vieira','1977-12-10','47280513958',2,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(29,'simone.falcao@gmail.com','S2vM8tQ5','Simone','Falcão','1984-06-02','69715482003',3,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(30,'eduardo.pinto@gmail.com','E7hP4kR2','Eduardo','Pinto','1990-05-07','18426935710',4,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(31,'vanessa.moraes@gmail.com','V5kR2sM8','Vanessa','Moraes','1996-07-15','39285147066',5,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49'),(32,'andre.santana@gmail.com','A9tF3vL6','André','Santana','1972-01-01','60894731582',1,'Colaborador','2025-08-26 16:35:49','2025-08-26 16:35:49');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_equipe`
--

DROP TABLE IF EXISTS `usuarios_equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_equipe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `id_equipe` int DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_equipe` (`id_equipe`),
  CONSTRAINT `usuarios_equipe_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `usuarios_equipe_ibfk_2` FOREIGN KEY (`id_equipe`) REFERENCES `equipes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_equipe`
--

LOCK TABLES `usuarios_equipe` WRITE;
/*!40000 ALTER TABLE `usuarios_equipe` DISABLE KEYS */;
INSERT INTO `usuarios_equipe` VALUES (3,2,1,'PO');
/*!40000 ALTER TABLE `usuarios_equipe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-29  6:47:59
