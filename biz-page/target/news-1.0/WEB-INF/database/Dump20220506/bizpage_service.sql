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
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,NULL,NULL,NULL,NULL,'Giải pháp trung tâm dữ liệu tổng thể của CQL bao gồm cơ sở hạ tầng, thiết kế đã được chứng minh phù hợp với các tiêu chuẩn quốc tế mới nhất, bao quát đầy đủ mọi nhu cầu kinh doanh hiện đại.','Tích hợp hệ thống','bi-briefcase'),(2,NULL,NULL,NULL,NULL,'Giải pháp phân tích sự kiện và cảnh báo an ninh Lợi ích: giám sát, phân tích và quản lý tập trung hệ thống nhật ký (log). Tính năng: – Thu thập log từ tất cả','Giải pháp bảo mật toàn diện','bi-card-checklist'),(3,NULL,NULL,NULL,NULL,'Khi doanh nghiệp của bạn cần củng cố và ảo hóa môi trường IT, việc tận dụng các công nghệ và cách tiếp cận mạng mới','Dịch vụ và hạ tầng cntt','bi-bar-chart'),(4,NULL,NULL,NULL,NULL,'Ngày nay, hệ thống Camera quan sát đã trở nên hết sức thông dụng đối với mọi người, nó có thể được lắp đặt để giám sát hoạt động ở mọi nơi','Hệ thống an ninh','bi-binoculars'),(5,NULL,NULL,NULL,NULL,'DrayTek cung cấp khá nhiều loại thiết bị mạng không dây, từ loại cơ bản với chuẩn IEEE 802.11g đến các phiên bản mở rộng bởi phương thức packet-overdriver hoặc Super GTM . Đặc biệt khi các chi tiết kỹ thuật mới của chuẩn 802.11n sắp được hoàn thành và phê chuẩn, DrayTek sẽ nổ lực vào việc tạo ra các dòng sản phẩm không dây mới theo xu hướng đó và ngày càng hoàn thiện hơn.','Giải pháp mạng không dây','bi-brightness-high'),(6,NULL,NULL,NULL,NULL,'Internet vạn vật (IoT) kết nối mạng lưới các cảm biến, các thiết bị kích hoạt, thiết bị thông minh vật lý (cả trong dân dụng và công nghiệp) theo cách làm cho chúng thông minh, có thể lập trình và có khả năng tương tác với con người lẫn giao tiếp với nhau.','Giải pháp iot','bi-calendar4-week');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-06 17:20:35
