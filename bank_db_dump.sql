-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: banksystem
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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank` (
  `pin` varchar(20) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `amount` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES ('','Sat Sep 06 12:50:20 IST 2025','Deposit','1000'),('706','Sat Sep 06 12:55:22 IST 2025','Deposit','5000'),('123','Sat Sep 06 20:22:47 IST 2025','Deposit','500'),('123','Sat Sep 06 20:23:44 IST 2025','Deposit','500'),('123','Sat Sep 06 20:25:42 IST 2025','Deposit','500'),('123','Sun Sep 07 11:45:53 IST 2025','Deposit','3000'),('123','Sun Sep 07 11:46:12 IST 2025','Withdrawl','4500'),('123','Sun Sep 07 12:12:09 IST 2025','Deposit','20000'),('123','Sun Sep 07 12:12:29 IST 2025','withdrawl','1000'),('123','Sun Sep 07 12:13:06 IST 2025','withdrawl','10000'),('123','Sun Sep 07 12:13:16 IST 2025','withdrawl','5000'),('123','Sun Sep 07 12:13:21 IST 2025','withdrawl','2000'),('123','Sun Sep 07 12:13:25 IST 2025','withdrawl','2000'),('429','Sun Sep 07 13:38:12 IST 2025','Deposit','10000000000'),('429','Sun Sep 07 13:39:36 IST 2025','Deposit','100000'),('429','Sun Sep 07 13:39:49 IST 2025','Deposit','50,000'),('429','Sun Sep 07 13:40:12 IST 2025','Deposit','50000'),('706','Sun Sep 07 13:41:02 IST 2025','Deposit','600000'),('706','Sun Sep 07 13:41:14 IST 2025','Deposit','1000000'),('706','Sun Sep 07 13:41:24 IST 2025','Withdrawl','1000000'),('706','Sun Sep 07 13:41:40 IST 2025','Withdrawl','605000');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `card_number` varchar(50) DEFAULT NULL,
  `pin` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('1409962960553945','123'),('1409963055875215','706'),('1409962944098924','429');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `name` varchar(30) DEFAULT NULL,
  `father_name` varchar(30) DEFAULT NULL,
  `DOB` varchar(30) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `marital_status` varchar(20) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `city` varchar(40) DEFAULT NULL,
  `pincode` varchar(30) DEFAULT NULL,
  `state` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('Ramesh','Ganesh','2025-09-23','Male','niitxhyadav@gmail.com','Married','pv','nd','110086','new delhi'),('Daniel','Rajesh','2025-09-30','Male','123@email.com','Married','nd','udaipur','111111','agra');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signupthree`
--

DROP TABLE IF EXISTS `signupthree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signupthree` (
  `account_type` varchar(40) DEFAULT NULL,
  `card_number` varchar(30) DEFAULT NULL,
  `pin` varchar(30) DEFAULT NULL,
  `facility` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signupthree`
--

LOCK TABLES `signupthree` WRITE;
/*!40000 ALTER TABLE `signupthree` DISABLE KEYS */;
INSERT INTO `signupthree` VALUES ('Saving Account','1409962960553945','123','ATM CARD'),('Recurring deposit Account','1409963055875215','706','ATM CARD'),('Fixed Deposit Account','1409962944098924','429','ATM CARD');
/*!40000 ALTER TABLE `signupthree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signuptwo`
--

DROP TABLE IF EXISTS `signuptwo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signuptwo` (
  `religion` varchar(30) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `income` varchar(30) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `occupation` varchar(60) DEFAULT NULL,
  `pan` varchar(20) DEFAULT NULL,
  `aadhar` varchar(60) DEFAULT NULL,
  `seniorcitizen` varchar(40) DEFAULT NULL,
  `existing_account` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signuptwo`
--

LOCK TABLES `signuptwo` WRITE;
/*!40000 ALTER TABLE `signuptwo` DISABLE KEYS */;
INSERT INTO `signuptwo` VALUES ('Hindu','General','Null','Non-Graduate','Salaried','110920','1213012839102','no','no'),('Hindu','OBC','Above 10,00,000','Doctrate','Retired','12121212121','22121212121','yes','no');
/*!40000 ALTER TABLE `signuptwo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-09 11:09:23
