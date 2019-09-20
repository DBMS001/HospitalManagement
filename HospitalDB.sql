-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: Hospital
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `DoctorID` int(10) NOT NULL,
  `DoctorName` varchar(20) DEFAULT NULL,
  `FatherName` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `ContactNo` bigint(20) DEFAULT NULL,
  `Qualifications` varchar(50) DEFAULT NULL,
  `Gender` varchar(1) DEFAULT 'M',
  `BloodGroup` varchar(5) DEFAULT 'O+',
  `DateOfJoining` date DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DoctorID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Mihir Wachasunder','Nachiket Wachasunder','mihir123@gmail.com',9404235687,'BAMS','M','O+','2019-09-09','karad'),(2,'Nachiket Wachasunder','Vasant Wachasunder','nachiket12@gmail.com',9874563210,'MD','M','O+','2019-09-11','Karad'),(3,'Neha Wachsunder','Nachiket Wachasunder','neha123@rediffmail.com',9786541230,'MD','F','O+','2019-09-11','Karad'),(5,'askldj alksdj','asssadm','as@abjsd',7539846210,'MBBS','M','A+','2019-09-20','adsh bkasjb');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientreg`
--

DROP TABLE IF EXISTS `patientreg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientreg` (
  `PatientID` int(10) NOT NULL,
  `PatientName` varchar(20) DEFAULT NULL,
  `FathersName` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `ContactNo` bigint(20) DEFAULT NULL,
  `Age` int(2) DEFAULT NULL,
  `Remarks` varchar(100) DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `BG` varchar(3) DEFAULT NULL,
  `Doctor` varchar(25) DEFAULT NULL,
  `Address` varchar(80) DEFAULT NULL,
  `State` varchar(30) DEFAULT NULL,
  `City` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`PatientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientreg`
--

LOCK TABLES `patientreg` WRITE;
/*!40000 ALTER TABLE `patientreg` DISABLE KEYS */;
INSERT INTO `patientreg` VALUES (1,'Dattaraj','Sanjay','dattaraj898@gmail.com',9049425095,21,'NA','M','O+','Dr. Nachiket','Katraj','Maharashtra','Pune'),(2,'hasvdh','sakj','nas@ajs',7894526130,21,'asd','M','A+','Dr. Mihir','ajsdb','Maharashtra','Kolhapur'),(3,'Nilesh','Sanjay','nil@gmail.com',9456873210,56,'NA','M','A+','Dr. Mihir','Pune','Maharashtra','Pune'),(4,'Sukrut','Anand','sukrut1@gmail.com',9654781230,54,'NA','M','A+','Dr. Mihir','Karad','Maharashtra','Karad'),(5,'Shreeram','Ramesh','ram@gmail.com',9852361470,25,'Scars all over the body','M','A+','Dr. Mihir','Pune','Maharashtra','Pune'),(16,'aksjdh','asjh','asdn@kasj',7539514620,22,'ssdfsdg','F','A+','Dr. Mihir','asssaDD','Maharashtra','Pune'),(18,'asydf','hdaisud','adsg@sdjg',1234567890,21,'NA','M','A+','Dr. Mihir','ajsgda asdj','Maharashtra','Pune'),(56,'sd','asd','sg@dh',1234567890,21,'NA','M','A+','Dr. Nachiket','ajshdf','Maharashtra','Pune');
/*!40000 ALTER TABLE `patientreg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrations`
--

DROP TABLE IF EXISTS `registrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrations` (
  `name` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `contact_no` bigint(20) NOT NULL,
  `sec_que` varchar(50) DEFAULT NULL,
  `sec_ans` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`contact_no`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrations`
--

LOCK TABLES `registrations` WRITE;
/*!40000 ALTER TABLE `registrations` DISABLE KEYS */;
INSERT INTO `registrations` VALUES ('Nilesh','Nil','nilesh','n.suryawanshi1168@gmail.com',9503293405,'Hospital\'s foundation year?','1990');
/*!40000 ALTER TABLE `registrations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-20 22:20:48
