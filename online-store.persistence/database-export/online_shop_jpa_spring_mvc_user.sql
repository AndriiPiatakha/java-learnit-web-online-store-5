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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `credit_card` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `partner_code` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `referrer_user_id` int DEFAULT NULL,
  `fk_user_role` int DEFAULT NULL,
  `enabled` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_h793lo2fhppyc9q920spcykwk` (`partner_code`),
  KEY `FKftb78p3ibhvs9vx23f724w7hc` (`fk_user_role`),
  KEY `FK3ydrrjc2w9ohh1t55fra06vkx` (`referrer_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (94,NULL,'admin@test.com','Admin','Admin',NULL,NULL,'$2a$10$7vimSyy0tns0BL421v5B6.RKhcKB5hVzZ1IpTDjDf9zxHQDoQlZGa',NULL,NULL,1),(95,NULL,'manager@test.com','Admin','Admin',0.00,NULL,'$2a$10$.EHbkUkMBw64DpjA9gugtu6qvFAotVSdP3ngKiPR1QmgDGs27uflK',NULL,NULL,1),(96,NULL,'t@t.com','Test','Test',0.00,'THAS5M','$2a$10$Pgen.myLeMjRUclUFMwKWuQHhBiXJdT.9c19N0fvLDNFSMVrc37k2',NULL,NULL,0),(97,NULL,'q@q.com','Qqqq','Qqqq',0.00,'NP791N','$2a$10$k58zh7WYlFWuLHEafK4VueLspZLKflOrQ7t7Fp7qBI6MJVhAf6F6q',NULL,NULL,0),(100,NULL,'y@y.com','Yyyy','Yyyy',0.00,'G5OG1Z','$2a$10$9B7t9HYcQmHBs2MSEfSCTOjjjDj1VnrW1wnuJaSvSwXcwwBx8ZT0m',NULL,NULL,0),(101,NULL,'w@w.com','Wwww','Wwww',0.00,'CVC1PD','$2a$10$Fhp00mG0cYUaK7pKOrdjvOUvmZISgQjv2tuv5wZ1XdVhRXlKbnOMO',NULL,NULL,1),(102,NULL,'e@e.com','Eeee','Eeee',0.00,'82ZOR0','$2a$10$2HbcbiV1gjqhQXB7hfuAiu46q2PjJvTG3VttHmKe0AX.A2wffkyRy',NULL,NULL,1),(103,NULL,'r@r.com','Rrrr','Rrrr',0.00,'1S4YT2','$2a$10$5QOvSpFEEmNKVrXmabcgtOJCNH/H070kwrMe7mxtZiXnvHKg0TG/G',NULL,NULL,1),(104,NULL,'u@u.com','Uuuu','Uuuu',0.00,'V2ZB63','$2a$10$DR1cjkl0fGjtNn5k0jfxI.pYld.fAupmHFejhX5OnqTbtgxCwSAUS',NULL,NULL,1),(105,NULL,'a@a.com','Aaaa','Aaaa',0.00,'MXV7MP','$2a$10$Vla1ZK6tWshe0MiE44HpCuC2sEZ7ZWZz1rsm8Y6549hN.PlJwCLrW',NULL,NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-28 15:48:47
