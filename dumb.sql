-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: pets
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `client_pets`
--

DROP TABLE IF EXISTS `client_pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_pets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `pet_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_id` (`client_id`),
  KEY `pet_id` (`pet_id`),
  CONSTRAINT `FK_connected_pets_with_owner_pets` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_connected_pets_with_owner_users` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=515 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_pets`
--

LOCK TABLES `client_pets` WRITE;
/*!40000 ALTER TABLE `client_pets` DISABLE KEYS */;
INSERT INTO `client_pets` VALUES (4,1,4),(5,1,2),(6,1,3),(334,29,32),(335,29,32),(336,29,32),(337,29,4),(350,8,27),(351,8,28),(359,8,32),(360,8,32),(494,17,36),(507,2,13),(508,2,37),(509,2,11),(511,52,38),(513,54,39),(514,54,40);
/*!40000 ALTER TABLE `client_pets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `second_name` varchar(45) NOT NULL,
  `phone_number` bigint(20) NOT NULL,
  `doctor_cards` varchar(50) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'lokha','Лёха','Ковальчук',1,NULL,'qwerty',0),(2,'arseniy','Арсений','Ковальчук',1,NULL,'1',0),(8,'Capitoska','Арсений','Камадей',333955561,'Capitoska_Top','123',1),(10,'kosya','Dasha','Kosyakova',34567890,NULL,'1234',0),(11,'Redster','Илья','Поух',3930260,NULL,'qwerty',0),(13,'12345','Арсений','ККК',123445,NULL,'12345',0),(17,'kosya_kosia','Даша','Косякова',375295709665,NULL,'12345',0),(21,'Doctor','Doctor','Doctor',2345324,'1','3216',1),(23,'doc123','doc','Косякова',12345,'12345','12345',1),(29,'mar1','Марина','Костылева',37529213234,'12345','12345',1),(30,'cap123','Виталя ','Камадей',228,NULL,'qwerty',0),(31,'ironman','Тони','Старк',3231231,NULL,'marvel',0),(32,'333','Арсений','Камадей',333,NULL,'333',0),(40,'Niktorov','Виктор','Никторов',123124,'dantist_3','1111',1),(46,'Shnaic','Мартин','Шнайцер',23448442,'Gill4233','13232',1),(50,'taras','Илья','Тарасенко',3752957890,'summer-123','123',1),(51,'nikitin','Илья','Никитин',880044,'Francis3347','123',1),(52,'dashaK','Даша','Косякова',234556,NULL,'123',0),(53,'tarazenko','Илья','Тарасенко',234567,'Abramson6374','123',1),(54,'olya','Оля','Гоголева',3455678,NULL,'123',0);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disease_histories`
--

DROP TABLE IF EXISTS `disease_histories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disease_histories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(2000) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `date_visit` date NOT NULL,
  `pet_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT '0',
  `date_answer` date DEFAULT NULL,
  `answer` varchar(2000) DEFAULT NULL,
  `doctor_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disease_histories`
--

LOCK TABLES `disease_histories` WRITE;
/*!40000 ALTER TABLE `disease_histories` DISABLE KEYS */;
INSERT INTO `disease_histories` VALUES (4,'Не открывается одно глазко',8,'2019-05-19',4,8,'2019-05-22','С вашим питомцем все хорошо!',5),(9,'Пришёл с большим шрамом.',1,'2019-05-19',4,NULL,NULL,NULL,5),(12,'Что-то с ним не так. Направили к вам.',2,'2019-05-19',13,8,'2019-05-20','Здоров',2),(13,'Простуда',17,'2019-05-20',32,8,'2019-05-20','Ничего страшного. Все хорошо. ',2),(14,' хочу сделать осмотр',17,'2019-05-20',36,NULL,NULL,NULL,1),(15,'Болит левая лапка',17,'2019-05-20',36,NULL,NULL,NULL,0),(16,'Подозрения на то, что грызун ослеп!!',2,'2019-05-20',3,8,'2019-05-21','Ухудшение зрения. Прописаны капли \"Pchelodar Ясные глазки\" 3 раза в день. 14 дней. Следующий приём через 7 дней!',2),(17,'Профилактика',2,'2019-05-23',13,NULL,NULL,NULL,7),(18,'простыл',17,'2019-05-22',36,NULL,NULL,NULL,2),(19,'простыл',52,'2019-05-22',38,8,'2019-05-22','Ничего страшного',2),(20,'болят глаза',54,'2019-05-22',39,8,'2019-05-22','прокапать глаза',2);
/*!40000 ALTER TABLE `disease_histories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_info`
--

DROP TABLE IF EXISTS `doctor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) DEFAULT '0',
  `vote_amount` int(11) DEFAULT '0',
  `sum_vote` int(11) DEFAULT '0',
  `specialty` int(11) DEFAULT '0',
  `result` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_info`
--

LOCK TABLES `doctor_info` WRITE;
/*!40000 ALTER TABLE `doctor_info` DISABLE KEYS */;
INSERT INTO `doctor_info` VALUES (2,0,0,0,0,0),(3,0,0,0,1,0),(4,0,0,0,2,0),(6,0,0,0,0,0),(7,0,0,0,2,0),(8,0,0,0,2,0),(9,0,0,0,0,0),(12,0,0,0,0,0),(13,0,0,0,0,0),(14,0,0,0,0,0),(16,0,0,0,0,0),(17,0,0,0,0,0),(18,0,0,0,0,0),(22,0,0,0,2,0),(23,0,0,0,0,0),(24,0,0,0,2,0);
/*!40000 ALTER TABLE `doctor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` varchar(50) NOT NULL DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (1,'0','собака','собака',10),(2,'0','мурзик','кот',5),(3,'0','шарик','собака',8),(4,'0','барсик','собака',3),(5,'0','пустынник','кот',2),(11,'1','Джек','Собака',10),(13,'Мужской','Томик','Кот',12),(14,'1','Арсений','Грызун',1),(26,'Man','Илья','Екзотическое',100),(27,'Man','Мурзик','Собака',12),(28,'Man','lk','Собака',123),(29,'Man','NotName','Собака',12),(32,'Woman','Грейси','Кот',1),(34,'Man','Тоик','Кот',1),(35,'Man','ва','Собака',1),(36,'Woman','Грейси','Кот',1),(37,'Man','Джери','Грызун',8),(38,'Woman','Слиппи','Кот',2),(39,'Man','Степан','Кот',2),(40,'Woman','Слиппи','Грызун',4);
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unregistered_doctor_cards`
--

DROP TABLE IF EXISTS `unregistered_doctor_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unregistered_doctor_cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_card` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unregistered_doctor_cards`
--

LOCK TABLES `unregistered_doctor_cards` WRITE;
/*!40000 ALTER TABLE `unregistered_doctor_cards` DISABLE KEYS */;
/*!40000 ALTER TABLE `unregistered_doctor_cards` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-08 11:40:11
