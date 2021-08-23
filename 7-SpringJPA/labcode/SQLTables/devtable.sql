-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: workshopdb
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `developers`
--

DROP TABLE IF EXISTS `developers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `developers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `languages` varchar(255) DEFAULT NULL,
  `married` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developers`
--

LOCK TABLES `developers` WRITE;
/*!40000 ALTER TABLE `developers` DISABLE KEYS */;
INSERT INTO `developers` VALUES (1,28,'c++,c#,java,python',_binary '\0','Evelyn'),(2,51,'php',_binary '','Michael'),(3,45,'php,c++',_binary '\0','Michael'),(4,22,'c++,python',_binary '\0','Michael'),(5,55,'c#,java,python,php',_binary '','Olivia'),(6,42,'c#,php,python,c++',_binary '\0','Peter'),(7,22,'python',_binary '','Peter'),(8,36,'c++,php,c#,python',_binary '\0','Sophia'),(9,24,'php,python',_binary '\0','Emma'),(10,56,'c++',_binary '\0','Evelyn'),(11,51,'python,java,c#,c++',_binary '','Michael'),(12,34,'php,java',_binary '\0','Peter'),(13,30,'python,c#,java,c++',_binary '','Benjamin'),(14,23,'c#,java',_binary '','Emma'),(15,40,'c++,python,java,c#',_binary '','Evelyn'),(16,24,'c++,php,python,c#',_binary '','James'),(17,35,'php',_binary '\0','Evelyn'),(18,38,'php',_binary '\0','Benjamin'),(19,28,'php,python,c++,java',_binary '\0','Emma'),(20,40,'c++,python',_binary '','James'),(21,51,'php',_binary '','Olivia'),(22,30,'java,c++',_binary '\0','Michael'),(23,28,'c#,java,c++,php',_binary '','Emma'),(24,60,'php,java',_binary '','Peter'),(25,29,'c++,c#,java',_binary '\0','Sophia'),(26,46,'python,c#,java',_binary '\0','Michael'),(27,28,'c#,java,python',_binary '','James'),(28,54,'c#,php,c++',_binary '','Evelyn'),(29,47,'c++',_binary '\0','Olivia'),(30,30,'c#,c++',_binary '\0','Emma');
/*!40000 ALTER TABLE `developers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-18  7:30:36
