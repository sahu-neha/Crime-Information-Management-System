-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: crime_management
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `crime`
--

DROP TABLE IF EXISTS `crime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime` (
  `id` int NOT NULL AUTO_INCREMENT,
  `crime_id` varchar(4) NOT NULL,
  `crime_type` tinyint NOT NULL,
  `crime_desc` varchar(200) NOT NULL,
  `ps_area` varchar(30) NOT NULL,
  `crime_date` date NOT NULL,
  `complaint_date` date NOT NULL,
  `victim_name` varchar(20) NOT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `crime_id` (`crime_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime`
--

LOCK TABLES `crime` WRITE;
/*!40000 ALTER TABLE `crime` DISABLE KEYS */;
INSERT INTO `crime` VALUES (1,'cr01',3,'murder','surajpur','2022-09-15','2023-03-30','naina',0),(4,'cr03',8,'fraud at bank','jammu','2023-01-25','2023-04-01','nisha kushwaha',0),(5,'cr00',6,'at the neighbours house at night','nagpur','2023-01-01','2023-04-02','nihar',1),(6,'c000',12,'abused by mother in law','bhuvaneshwar','2005-10-05','2023-04-03','yashoda',0);
/*!40000 ALTER TABLE `crime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crime_to_criminal`
--

DROP TABLE IF EXISTS `crime_to_criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime_to_criminal` (
  `crime_id` varchar(4) NOT NULL,
  `criminal_id` varchar(4) NOT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`crime_id`,`criminal_id`),
  KEY `criminal_id` (`criminal_id`),
  CONSTRAINT `crime_to_criminal_ibfk_1` FOREIGN KEY (`crime_id`) REFERENCES `crime` (`crime_id`),
  CONSTRAINT `crime_to_criminal_ibfk_2` FOREIGN KEY (`criminal_id`) REFERENCES `criminal` (`criminal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime_to_criminal`
--

LOCK TABLES `crime_to_criminal` WRITE;
/*!40000 ALTER TABLE `crime_to_criminal` DISABLE KEYS */;
INSERT INTO `crime_to_criminal` VALUES ('c000','c000',1);
/*!40000 ALTER TABLE `crime_to_criminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crime_type`
--

DROP TABLE IF EXISTS `crime_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime_type` (
  `crime_type_name` varchar(30) NOT NULL,
  `crime_type_id` tinyint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`crime_type_id`),
  UNIQUE KEY `crime_type_name` (`crime_type_name`),
  UNIQUE KEY `crime_type_id` (`crime_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime_type`
--

LOCK TABLES `crime_type` WRITE;
/*!40000 ALTER TABLE `crime_type` DISABLE KEYS */;
INSERT INTO `crime_type` VALUES ('Bribery',15),('Burglary',5),('Domestic violence',12),('Drug trafficking',6),('Fraud',8),('Homicide',3),('Human trafficking',10),('Kidnapping',4),('Money laundering',11),('Religious violence',9),('Robbery',1),('Sexual harassment',14),('Stalking',13),('Terrorism',7),('Theft',2);
/*!40000 ALTER TABLE `crime_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criminal`
--

DROP TABLE IF EXISTS `criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criminal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `criminal_id` varchar(4) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(1) NOT NULL,
  `identifying_mark` varchar(30) DEFAULT NULL,
  `first_arrest_date` date NOT NULL,
  `arrested_from_ps_area` varchar(20) NOT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `criminal_id` (`criminal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criminal`
--

LOCK TABLES `criminal` WRITE;
/*!40000 ALTER TABLE `criminal` DISABLE KEYS */;
INSERT INTO `criminal` VALUES (2,'c002','kasturi','goswami','1994-02-22','f','scar on forehead','2022-05-21','raipur',0),(3,'c003','ashish','sharma','1999-11-25','m','slit on right eyebrow','2023-01-18','thane',0),(4,'cri1','kamal','thapa','1991-01-01','m','scar on right palm','2020-03-31','patna',0),(5,'c000','priya','sharma','1995-08-25','f','mole on face','2022-10-24','jaipur',0);
/*!40000 ALTER TABLE `criminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `login_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact_no` int DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'neha','neha123','neha@mail.com',1234567890),(2,'neha1','1234','e@m.com',1234560445),(3,'subham','420','ksubham',911),(5,'hrithik vishwakarma','123','g@',1234567890),(6,'neha','12345','email12345',1234561230);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `public_complaint`
--

DROP TABLE IF EXISTS `public_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `public_complaint` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `crime_desc` varchar(200) NOT NULL,
  `crime_date` date NOT NULL,
  `complaint_date` date NOT NULL,
  `victim_name` varchar(20) NOT NULL,
  `suspect` varchar(30) DEFAULT NULL,
  `crime_type` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `crime_type` (`crime_type`),
  CONSTRAINT `public_complaint_ibfk_1` FOREIGN KEY (`crime_type`) REFERENCES `crime_type` (`crime_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `public_complaint`
--

LOCK TABLES `public_complaint` WRITE;
/*!40000 ALTER TABLE `public_complaint` DISABLE KEYS */;
INSERT INTO `public_complaint` VALUES (1,'g@','mantri chori in kolkata','2023-03-31','2023-04-03','raju tyagi','k subham',4);
/*!40000 ALTER TABLE `public_complaint` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-03 23:36:54
