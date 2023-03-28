/* Import roles */
INSERT INTO `role` VALUES (91,'ROLE_CUSTOMER'),(90,'ROLE_MANAGER'),(89,'ROLE_ADMIN');

/* Import privileges */
INSERT INTO `privilege` VALUES (9,'READ_PRIVILEGE'),(10,'WRITE_PRIVILEGE'),(11,'DELETE_PRIVILEGE');

/* Import role-privilege */
INSERT INTO `roles_privileges` VALUES (89,9),(89,10),(89,11),(90,9),(90,10),(91,9);

/* Import users */
INSERT INTO `user` VALUES (94,NULL,'admin@test.com','Admin','Admin',NULL,NULL,'$2a$10$7vimSyy0tns0BL421v5B6.RKhcKB5hVzZ1IpTDjDf9zxHQDoQlZGa',NULL,NULL,1),(95,NULL,'manager@test.com','Admin','Admin',0.00,NULL,'$2a$10$.EHbkUkMBw64DpjA9gugtu6qvFAotVSdP3ngKiPR1QmgDGs27uflK',NULL,NULL,1),(96,NULL,'t@t.com','Test','Test',0.00,'THAS5M','$2a$10$Pgen.myLeMjRUclUFMwKWuQHhBiXJdT.9c19N0fvLDNFSMVrc37k2',NULL,NULL,0),(97,NULL,'q@q.com','Qqqq','Qqqq',0.00,'NP791N','$2a$10$k58zh7WYlFWuLHEafK4VueLspZLKflOrQ7t7Fp7qBI6MJVhAf6F6q',NULL,NULL,0),(100,NULL,'y@y.com','Yyyy','Yyyy',0.00,'G5OG1Z','$2a$10$9B7t9HYcQmHBs2MSEfSCTOjjjDj1VnrW1wnuJaSvSwXcwwBx8ZT0m',NULL,NULL,0),(101,NULL,'w@w.com','Wwww','Wwww',0.00,'CVC1PD','$2a$10$Fhp00mG0cYUaK7pKOrdjvOUvmZISgQjv2tuv5wZ1XdVhRXlKbnOMO',NULL,NULL,1),(102,NULL,'e@e.com','Eeee','Eeee',0.00,'82ZOR0','$2a$10$2HbcbiV1gjqhQXB7hfuAiu46q2PjJvTG3VttHmKe0AX.A2wffkyRy',NULL,NULL,1),(103,NULL,'r@r.com','Rrrr','Rrrr',0.00,'1S4YT2','$2a$10$5QOvSpFEEmNKVrXmabcgtOJCNH/H070kwrMe7mxtZiXnvHKg0TG/G',NULL,NULL,1),(104,NULL,'u@u.com','Uuuu','Uuuu',0.00,'V2ZB63','$2a$10$DR1cjkl0fGjtNn5k0jfxI.pYld.fAupmHFejhX5OnqTbtgxCwSAUS',NULL,NULL,1),(105,NULL,'a@a.com','Aaaa','Aaaa',0.00,'MXV7MP','$2a$10$Vla1ZK6tWshe0MiE44HpCuC2sEZ7ZWZz1rsm8Y6549hN.PlJwCLrW',NULL,NULL,1);

/* Import role-user */
INSERT INTO `users_roles` VALUES (92,89),(93,90),(94,89),(95,90),(105,91);

/* Import categories */
INSERT INTO `category` VALUES (1,'Laptop','laptop2.png'),(2,'Phone','iphone.png'),(3,'TV','qledtv.png'),(4,'Chair','4.png'),(5,'Bed','5.png'),(6,'Sofa','6.png'),(8,'Camera','nikon.png');

/* Import products */
INSERT INTO `product` VALUES (1,'This is a good laptop','f5be91d2732a47508c5b28443d880fa9','hp.png',1500.56,'HP Laptop 1',1),(2,NULL,'a3d14989445a4834ae4e329a24ca2db3','iphone.jpg',2000.99,'Apple iPhone',2),(3,NULL,'a1e1a58df59d44e3b2fbc1d4aba030b7','samsung-galaxy.jpg',1100.10,'Samsung Galaxy S21',2),(4,NULL,'6cf198bbe8b44805b86b354830df0c2e','asus-zenbook.jpg',1857.28,'Asus Zenbook',1),(6,NULL,'c0907ed8fedf465786a7f3620b02fba6','qled.jpg',2519.78,'Samsung QLED TV',3),(8,NULL,'9d9120ab547b4baba7bf1122aa2f1c25','dell.jpg',30.00,'Laptop Dell',1),(9,NULL,'7194b5cbef2e48eab2e1132187cad758','chair.jpg',39.00,'Chair 1',4),(10,NULL,'0ecca07f1795440494244f49ac088a49','chair.jpg',49.00,'Chair 2',4),(11,NULL,'f479923e395843d0ab00cbad5e924ed2','chair.jpg',59.00,'Chair 3',4),(12,NULL,'496a85967e3a4486a5d33e8b74b20670','sofa.jpg',487.00,'Sofa 1',6),(13,NULL,'9e702a2f4a6944f68cbb67cf24bd2951','sofa.jpg',557.00,'Sofa 2',6),(14,NULL,'0c7563c33eb748669b48e99da84207c7','sofa.jpg',673.00,'Sofa 3',6),(15,NULL,'74f7a23c7fdf4ed4af2dedae7523ac38','bed.jpg',488.00,'Bed 1',5),(16,NULL,'d5d046ac021d4d8987516771520dd1ec','bed.jpg',599.00,'Bed 2',5),(17,NULL,'6de34c4df675418796640f7a79ec6663','bed.jpg',732.00,'Bed 3',5),(18,NULL,'26192070f3c148dc842455405dd39a75','camera.jpg',1100.00,'Camera 1',8),(19,NULL,'4762889e5ee244458e2fc6d01b1405e0','camera.jpg',1800.00,'Camera 2',8),(20,NULL,'6ca8dd95586546ff9e2235ae37efaf9a','camera.jpg',2800.00,'Camera 3',8),(21,'This is a good laptop','501c78a5c3214337baf9a067065a9df5','hp.png',1899.99,'HP Laptop 2',1),(22,'This is a good laptop','3484c108c97747689efe4bd617a09259','hp.png',1899.99,'HP Laptop 3',1),(23,'This is a good laptop','334d1661e65444208f06b9bcd8c4b3bc','hp.png',1899.99,'HP Laptop 4',1),(24,'This is a good laptop','f02a6c36f19644feb4e5089eeb0fa992','hp.png',1899.99,'HP Laptop 5',1),(25,'This is a good laptop','8acb8cb701434ca49f766932062e2e0f','hp.png',1899.99,'HP Laptop 6',1),(26,'This is a good laptop','fe75b9df82824c5b86fa097fc61b8733','hp.png',1899.99,'HP Laptop 7',1),(27,'This is a good laptop','b4873884807344aebab1a5969d1cd125','hp.png',1899.99,'HP Laptop 8',1),(28,'This is a good laptop','9c52c966e00f455a8ceeaf6d933f77eb','hp.png',1899.99,'HP Laptop 9',1),(29,'This is a good laptop','fa391a202a6d45e89ea0b3c018d170e2','hp.png',1899.99,'HP Laptop 10',1),(30,'This is a good laptop','b2f3f9625e5b4616973cc6dbce1d2bbb','hp.png',1899.99,'HP Laptop 11',1);

/* Import purchase statuses */
INSERT INTO `purchase_status` VALUES (1,'receive_request'),(2,'waiting_for_paymenet'),(3,'payed'),(4,'shipping'),(5,'shipped'),(6,'completed');

/* Import purchases */
INSERT INTO `purchase` VALUES (12,'2021-11-02 20:14:28',1,94),(13,'2021-11-02 20:14:28',5,95),(14,'2021-11-02 20:14:28',2,94),(15,'2021-11-02 20:14:28',5,95),(16,'2021-11-02 20:14:28',4,94),(17,'2021-11-02 20:14:28',6,67),(18,'2021-11-02 20:14:28',6,65),(19,'2021-11-02 20:14:28',6,65),(20,'2021-11-02 20:14:28',6,66),(21,'2021-11-02 20:14:28',6,67),(22,'2021-11-02 20:14:28',6,65),(23,'2021-11-02 20:14:28',1,66),(24,'2021-11-02 20:49:46',6,67),(25,'2022-01-03 17:54:08',6,65),(29,'2022-05-01 11:44:04',1,66),(30,'2022-05-01 11:44:39',2,67),(31,'2022-05-01 14:49:08',6,65),(32,'2022-05-01 14:49:14',4,66),(33,'2022-05-01 14:50:41',4,67),(34,'2022-05-01 14:50:52',6,65),(35,'2022-05-01 16:41:06',6,66),(36,'2022-05-02 14:53:20',2,67),(37,'2022-05-03 13:38:24',6,65),(38,'2022-05-03 14:25:04',6,66),(39,'2022-05-04 14:11:13',6,67),(40,'2022-05-04 14:16:39',6,65),(41,'2022-05-06 11:12:47',1,66),(42,'2022-07-02 18:28:24',1,67),(43,'2022-07-02 18:31:55',1,65),(44,'2022-07-02 18:32:10',1,66),(45,'2022-07-02 18:36:20',1,67),(46,'2022-07-02 18:41:20',1,65),(3,'2022-11-15 21:09:49',1,67),(4,'2022-11-15 21:46:56',3,67);

/* Import purchase-product */
INSERT INTO `purchase_product` VALUES (12,1),(12,2),(12,3),(13,1),(13,4),(14,2),(15,1),(15,6),(15,1),(16,2),(17,2),(18,1),(19,2),(20,6),(21,4),(22,3),(23,3),(24,1),(24,1),(24,2),(25,3),(29,4),(29,1),(30,4),(31,1),(31,2),(31,3),(32,1),(32,2),(32,3),(33,1),(33,2),(33,3),(34,1),(34,2),(34,3),(35,1),(36,4),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(46,1),(3,1),(4,1);

