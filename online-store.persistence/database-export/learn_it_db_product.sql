-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: learn_it_db
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
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `guid` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(1500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `img_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'f5be91d2732a47508c5b28443d880fa9','HP Laptop 1','This is a good laptop',1500.56,1,'hp.png'),(2,'a3d14989445a4834ae4e329a24ca2db3','Apple iPhone',NULL,2000.99,2,'iphone.jpg'),(3,'a1e1a58df59d44e3b2fbc1d4aba030b7','Samsung Galaxy S21',NULL,1100.10,2,'samsung-galaxy.jpg'),(4,'6cf198bbe8b44805b86b354830df0c2e','Asus Zenbook',NULL,1857.28,1,'asus-zenbook.jpg'),(6,'c0907ed8fedf465786a7f3620b02fba6','Samsung QLED TV',NULL,2519.78,3,'qled.jpg'),(8,'9d9120ab547b4baba7bf1122aa2f1c25','Laptop Dell',NULL,30.00,1,'dell.jpg'),(9,'7194b5cbef2e48eab2e1132187cad758','Chair 1',NULL,39.00,4,'chair.jpg'),(10,'0ecca07f1795440494244f49ac088a49','Chair 2',NULL,49.00,4,'chair.jpg'),(11,'f479923e395843d0ab00cbad5e924ed2','Chair 3',NULL,59.00,4,'chair.jpg'),(12,'496a85967e3a4486a5d33e8b74b20670','Sofa 1',NULL,487.00,6,'sofa.jpg'),(13,'9e702a2f4a6944f68cbb67cf24bd2951','Sofa 2',NULL,557.00,6,'sofa.jpg'),(14,'0c7563c33eb748669b48e99da84207c7','Sofa 3',NULL,673.00,6,'sofa.jpg'),(15,'74f7a23c7fdf4ed4af2dedae7523ac38','Bed 1',NULL,488.00,5,'bed.jpg'),(16,'d5d046ac021d4d8987516771520dd1ec','Bed 2',NULL,599.00,5,'bed.jpg'),(17,'6de34c4df675418796640f7a79ec6663','Bed 3',NULL,732.00,5,'bed.jpg'),(18,'26192070f3c148dc842455405dd39a75','Camera 1',NULL,1100.00,8,'camera.jpg'),(19,'4762889e5ee244458e2fc6d01b1405e0','Camera 2',NULL,1800.00,8,'camera.jpg'),(20,'6ca8dd95586546ff9e2235ae37efaf9a','Camera 3',NULL,2800.00,8,'camera.jpg'),(21,'501c78a5c3214337baf9a067065a9df5','HP Laptop 2','This is a good laptop',1899.99,1,'hp.png'),(22,'3484c108c97747689efe4bd617a09259','HP Laptop 3','This is a good laptop',1899.99,1,'hp.png'),(23,'334d1661e65444208f06b9bcd8c4b3bc','HP Laptop 4','This is a good laptop',1899.99,1,'hp.png'),(24,'f02a6c36f19644feb4e5089eeb0fa992','HP Laptop 5','This is a good laptop',1899.99,1,'hp.png'),(25,'8acb8cb701434ca49f766932062e2e0f','HP Laptop 6','This is a good laptop',1899.99,1,'hp.png'),(26,'fe75b9df82824c5b86fa097fc61b8733','HP Laptop 7','This is a good laptop',1899.99,1,'hp.png'),(27,'b4873884807344aebab1a5969d1cd125','HP Laptop 8','This is a good laptop',1899.99,1,'hp.png'),(28,'9c52c966e00f455a8ceeaf6d933f77eb','HP Laptop 9','This is a good laptop',1899.99,1,'hp.png'),(29,'fa391a202a6d45e89ea0b3c018d170e2','HP Laptop 10','This is a good laptop',1899.99,1,'hp.png'),(30,'b2f3f9625e5b4616973cc6dbce1d2bbb','HP Laptop 11','This is a good laptop',1899.99,1,'hp.png');
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

-- Dump completed on 2022-07-03 17:58:17
