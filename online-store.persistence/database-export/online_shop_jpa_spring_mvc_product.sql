-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: online_shop_jpa_spring_mvc
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `guid` varchar(255) DEFAULT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'This is a good laptop','f5be91d2732a47508c5b28443d880fa9','hp.png',1500.56,'HP Laptop 1',1),(2,NULL,'a3d14989445a4834ae4e329a24ca2db3','iphone.jpg',2000.99,'Apple iPhone',2),(3,NULL,'a1e1a58df59d44e3b2fbc1d4aba030b7','samsung-galaxy.jpg',1100.10,'Samsung Galaxy S21',2),(4,NULL,'6cf198bbe8b44805b86b354830df0c2e','asus-zenbook.jpg',1857.28,'Asus Zenbook',1),(6,NULL,'c0907ed8fedf465786a7f3620b02fba6','qled.jpg',2519.78,'Samsung QLED TV',3),(8,NULL,'9d9120ab547b4baba7bf1122aa2f1c25','dell.jpg',30.00,'Laptop Dell',1),(9,NULL,'7194b5cbef2e48eab2e1132187cad758','chair.jpg',39.00,'Chair 1',4),(10,NULL,'0ecca07f1795440494244f49ac088a49','chair.jpg',49.00,'Chair 2',4),(11,NULL,'f479923e395843d0ab00cbad5e924ed2','chair.jpg',59.00,'Chair 3',4),(12,NULL,'496a85967e3a4486a5d33e8b74b20670','sofa.jpg',487.00,'Sofa 1',6),(13,NULL,'9e702a2f4a6944f68cbb67cf24bd2951','sofa.jpg',557.00,'Sofa 2',6),(14,NULL,'0c7563c33eb748669b48e99da84207c7','sofa.jpg',673.00,'Sofa 3',6),(15,NULL,'74f7a23c7fdf4ed4af2dedae7523ac38','bed.jpg',488.00,'Bed 1',5),(16,NULL,'d5d046ac021d4d8987516771520dd1ec','bed.jpg',599.00,'Bed 2',5),(17,NULL,'6de34c4df675418796640f7a79ec6663','bed.jpg',732.00,'Bed 3',5),(18,NULL,'26192070f3c148dc842455405dd39a75','camera.jpg',1100.00,'Camera 1',8),(19,NULL,'4762889e5ee244458e2fc6d01b1405e0','camera.jpg',1800.00,'Camera 2',8),(20,NULL,'6ca8dd95586546ff9e2235ae37efaf9a','camera.jpg',2800.00,'Camera 3',8),(21,'This is a good laptop','501c78a5c3214337baf9a067065a9df5','hp.png',1899.99,'HP Laptop 2',1),(22,'This is a good laptop','3484c108c97747689efe4bd617a09259','hp.png',1899.99,'HP Laptop 3',1),(23,'This is a good laptop','334d1661e65444208f06b9bcd8c4b3bc','hp.png',1899.99,'HP Laptop 4',1),(24,'This is a good laptop','f02a6c36f19644feb4e5089eeb0fa992','hp.png',1899.99,'HP Laptop 5',1),(25,'This is a good laptop','8acb8cb701434ca49f766932062e2e0f','hp.png',1899.99,'HP Laptop 6',1),(26,'This is a good laptop','fe75b9df82824c5b86fa097fc61b8733','hp.png',1899.99,'HP Laptop 7',1),(27,'This is a good laptop','b4873884807344aebab1a5969d1cd125','hp.png',1899.99,'HP Laptop 8',1),(28,'This is a good laptop','9c52c966e00f455a8ceeaf6d933f77eb','hp.png',1899.99,'HP Laptop 9',1),(29,'This is a good laptop','fa391a202a6d45e89ea0b3c018d170e2','hp.png',1899.99,'HP Laptop 10',1),(30,'This is a good laptop','b2f3f9625e5b4616973cc6dbce1d2bbb','hp.png',1899.99,'HP Laptop 11',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-28 15:48:48
