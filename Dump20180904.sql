-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: reportautomation
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `defect`
--

DROP TABLE IF EXISTS `defect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `defect` (
  `DEFECT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DEFECT_ASSIGNED_TO` varchar(255) DEFAULT NULL,
  `DEFECT_CREATED_TIME_STAMP` datetime DEFAULT NULL,
  `DEFECT_DISCRIPTION` varchar(255) DEFAULT NULL,
  `PROJECT` varchar(255) DEFAULT NULL,
  `DEFECT_RAISED_BY` varchar(255) DEFAULT NULL,
  `RELEASE_ID` bigint(20) DEFAULT NULL,
  `DEFECT_STATUS` varchar(255) DEFAULT NULL,
  `DEFECT_UPDATED_TIME_STAMP` datetime DEFAULT NULL,
  PRIMARY KEY (`DEFECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defect`
--

LOCK TABLES `defect` WRITE;
/*!40000 ALTER TABLE `defect` DISABLE KEYS */;
INSERT INTO `defect` VALUES (1,'dev1',NULL,'description','ALPHA','qa1',1,'OPEN',NULL),(2,'dev1',NULL,'description','ALPHA','qa1',1,'OPEN',NULL);
/*!40000 ALTER TABLE `defect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `release_meta`
--

DROP TABLE IF EXISTS `release_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `release_meta` (
  `RELEASE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RELEASE_PROJECT` varchar(255) DEFAULT NULL,
  `RELEASE_VERSION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RELEASE_ID`),
  UNIQUE KEY `UK_846iolc4ac7de4f6mkof9tq2h` (`RELEASE_PROJECT`,`RELEASE_VERSION`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `release_meta`
--

LOCK TABLES `release_meta` WRITE;
/*!40000 ALTER TABLE `release_meta` DISABLE KEYS */;
INSERT INTO `release_meta` VALUES (1,'ALPHA','1'),(2,'BETA','0'),(3,'BETA','1'),(4,'DELTA','0'),(5,'DELTA','1');
/*!40000 ALTER TABLE `release_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `report` (
  `reportId` bigint(20) NOT NULL AUTO_INCREMENT,
  `ATTACHMENT` varchar(255) DEFAULT NULL,
  `COMMENT` varchar(255) DEFAULT NULL,
  `REPORT_CREATE_TIME_STAMP` datetime DEFAULT NULL,
  `REPORT_DATE` date DEFAULT NULL,
  `PROGRESS` double DEFAULT NULL,
  `PROJECT` varchar(255) DEFAULT NULL,
  `RELEASE_ID` bigint(20) DEFAULT NULL,
  `REPORT_REVIEWED_BY` varchar(255) DEFAULT NULL,
  `REPORT_STATUS` varchar(255) DEFAULT NULL,
  `REPORT_SUBMITTED_BY` varchar(255) DEFAULT NULL,
  `REPORT_UPDATE_TIME_STAMP` datetime DEFAULT NULL,
  PRIMARY KEY (`reportId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_cases`
--

DROP TABLE IF EXISTS `test_cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test_cases` (
  `ticket_id` bigint(10) NOT NULL,
  `test_case_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  UNIQUE KEY `ticket_id_UNIQUE` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_cases`
--

LOCK TABLES `test_cases` WRITE;
/*!40000 ALTER TABLE `test_cases` DISABLE KEYS */;
INSERT INTO `test_cases` VALUES (1,40),(2,15),(3,24);
/*!40000 ALTER TABLE `test_cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `TICKET_BUSINESS_OWNER` varchar(255) DEFAULT NULL,
  `TICKET_DISCRIPTION` varchar(255) DEFAULT NULL,
  `RELEASE_ID` bigint(20) DEFAULT NULL,
  `TICKET_STATUS` varchar(255) DEFAULT NULL,
  `TICKET_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'OWNER1','DESC_1',1,'OPEN','A-1'),(2,'OWNER2','DESC_2',1,'OPEN','A-2'),(3,'OWNER3','DESC_3',2,'OPEN','B-1'),(4,'OWNER4','DESC_4',3,'OPEN','D-0');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-04  7:56:20
