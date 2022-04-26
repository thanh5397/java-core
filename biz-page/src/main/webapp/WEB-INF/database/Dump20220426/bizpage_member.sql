-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: bizpage
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  `testimonial_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlmd4h7lh9acdyvi0xxbvsqrmk` (`department_id`),
  KEY `FKcjte2jn9pvo9ud2hyfgwcja0k` (`team_id`),
  KEY `FKh94ifafagx5ubk3062swabx5b` (`testimonial_id`),
  CONSTRAINT `FKcjte2jn9pvo9ud2hyfgwcja0k` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKh94ifafagx5ubk3062swabx5b` FOREIGN KEY (`testimonial_id`) REFERENCES `testimonial` (`id`),
  CONSTRAINT `FKlmd4h7lh9acdyvi0xxbvsqrmk` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,NULL,NULL,NULL,NULL,'assets/img/team-1.jpg','Walter White',1,1,NULL),(2,NULL,NULL,NULL,NULL,'assets/img/team-2.jpg','Sarah Jhonson',2,2,NULL),(3,NULL,NULL,NULL,NULL,'assets/img/team-3.jpg','William Anderson',3,3,NULL),(4,NULL,NULL,NULL,NULL,'assets/img/team-4.jpg','Amanda Jepson',4,4,NULL),(5,NULL,NULL,NULL,NULL,'assets/img/testimonial-1.jpg','Saul Goodman',5,NULL,1),(6,NULL,NULL,NULL,NULL,'assets/img/testimonial-2.jpg','Sara Wilsson',6,NULL,2),(7,NULL,NULL,NULL,NULL,'assets/img/testimonial-3.jpg','Jena Karlis',7,NULL,3),(8,NULL,NULL,NULL,NULL,'assets/img/testimonial-4.jpg','Matt Brandon',8,NULL,4),(9,NULL,NULL,NULL,NULL,'assets/img/testimonial-5.jpg','John Larson',9,NULL,5);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-26 20:00:42
