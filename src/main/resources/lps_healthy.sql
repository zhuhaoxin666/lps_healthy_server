-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: lps_healthy
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT 'admin',
  `password` varchar(300) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `depart_id` bigint NOT NULL AUTO_INCREMENT,
  `depart_name` varchar(50) NOT NULL,
  `foreign_hos_id` bigint DEFAULT NULL,
  PRIMARY KEY (`depart_id`),
  KEY `foreign_hos_id` (`foreign_hos_id`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`foreign_hos_id`) REFERENCES `hospital` (`hos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (2,'消化内科',1),(3,'预防保健科',1),(4,'心血管内科',1),(5,'呼吸科',1),(6,'感染科',1),(7,'普外科',1),(8,'骨科',1),(9,'神经外科',1),(10,'泌尿外科',1),(11,'耳鼻喉科',1),(12,'口腔科',1),(13,'皮肤科',1),(14,'儿科',1),(15,'妇科',1),(16,'眼科',1),(17,'中医科',11),(18,'急诊科',11),(19,'麻醉科',11),(20,'内科',11),(21,'外科',11),(22,'体检科',11),(23,'皮肤科',11),(24,'康复科',11),(25,'儿科',12),(26,'妇科',12),(27,'产科',12),(28,'放射科',12),(30,'急诊科',13),(31,'眼科',13),(32,'中医科',13),(33,'普外科',13),(34,'妇产科',13),(35,'五官科',13),(36,'妇产科',14),(37,'外科',14),(38,'皮肤性病科',14),(39,'中医科',14),(40,'内科',14),(41,'医学影像科',14),(42,'消化内科科',15),(43,'神经外科',15),(44,'妇产科',15),(45,'中医科',15),(46,'内科',15),(47,'骨科',15),(48,'感染科',16),(49,'消化内科',16),(50,'儿科',16),(51,'妇产科',16),(52,'神经外科',16),(53,'妇产科',16),(54,'中医科',17),(55,'神经外科',17),(56,'呼吸科',17),(57,'皮肤科',17),(58,'耳鼻喉科',18),(59,'眼科',18),(60,'妇科',19),(61,'妇产科',19),(62,'儿科',19),(64,'修改过后的测试科室',20),(65,'妇科',24);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `doc_id` bigint NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) NOT NULL,
  `doc_name` varchar(50) NOT NULL,
  `password` varchar(300) NOT NULL,
  `doc_level` varchar(50) DEFAULT NULL,
  `begin_work_date` date DEFAULT NULL,
  `end_work_date` date DEFAULT NULL,
  `foreign_depart_id` bigint DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `surplus_num_eight` int DEFAULT NULL,
  `surplus_num_nine` int DEFAULT NULL,
  `surplus_num_ten` int DEFAULT NULL,
  `surplus_num_fourteen` int DEFAULT NULL,
  `surplus_num_fifteen` int DEFAULT NULL,
  PRIMARY KEY (`doc_id`),
  UNIQUE KEY `nick_name` (`nick_name`),
  KEY `foreign_depart_id` (`foreign_depart_id`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`foreign_depart_id`) REFERENCES `department` (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'cdm01','陈冬梅','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',2,12.00,'doctor',3,3,3,3,3),(2,'yj01','杨杰','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',2,10.00,'doctor',4,4,4,4,4),(3,'ws01','武胜','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',2,10.00,'doctor',4,4,4,4,4),(4,'mj01','马健','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',3,12.00,'doctor',3,3,3,3,3),(5,'lq01','刘强','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',3,10.00,'doctor',4,4,4,4,4),(6,'lw01','鲁伟','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',4,12.00,'doctor',3,3,3,3,3),(7,'zsd01','朱绍东','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',4,10.00,'doctor',4,4,4,4,4),(8,'hmm01','韩梅梅','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',5,12.00,'doctor',3,3,3,3,3),(9,'lqd01','刘强东','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',5,10.00,'doctor',4,4,4,4,4),(10,'zwq01','赵文去','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',6,12.00,'doctor',3,3,3,3,3),(11,'zbw01','左邦威','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',6,10.00,'doctor',4,4,4,4,4),(12,'kdj01','孔德见','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',7,12.00,'doctor',3,3,3,3,3),(13,'wxy01','王新阳','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','实习医生','2019-12-30','2020-02-02',7,99.00,'doctor',4,4,4,4,4),(14,'fxy01','范项羽','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',8,12.00,'doctor',3,3,3,3,3),(15,'szy01','宋志予','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',8,10.00,'doctor',4,4,4,4,4),(16,'yjg01','于建刚','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',9,12.00,'doctor',3,3,3,3,3),(17,'lhz01','龙怀之','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',9,10.00,'doctor',4,4,4,4,4),(18,'ly01','刘永','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',10,12.00,'doctor',3,3,3,3,3),(19,'yzj01','杨泽君','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',10,10.00,'doctor',4,4,4,4,4),(20,'mkk01','马可可','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',11,12.00,'doctor',3,3,3,3,3),(21,'jf01','姬发','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',11,10.00,'doctor',4,4,4,4,4),(22,'zyl01','朱彦林','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',12,12.00,'doctor',3,3,3,3,3),(23,'ysz01','于松竹','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',12,10.00,'doctor',4,4,4,4,4),(24,'zxh01','周星宏','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',13,12.00,'doctor',3,3,3,3,3),(25,'zxw01','郑晓伟','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',13,10.00,'doctor',4,4,4,4,4),(26,'zrp01','郑睿朴','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',14,12.00,'doctor',3,3,3,3,3),(27,'sjy01','孙俊阳','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',14,10.00,'doctor',4,4,4,4,4),(28,'xwy01','徐伟业','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',15,12.00,'doctor',3,3,3,3,3),(29,'lyl01','吕元龙','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',15,10.00,'doctor',4,4,4,4,4),(32,'ly02','罗奕','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',16,12.00,'doctor',3,3,3,3,3),(33,'ljh01','林景鸿','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',16,10.00,'doctor',4,4,4,4,4),(34,'zxz02','张新只','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',17,12.00,'doctor',3,3,3,3,3),(35,'dy01','丁毅','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',17,10.00,'doctor',4,4,4,4,4),(38,'wrh02','王瑞华','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',18,12.00,'doctor',3,3,3,3,3),(39,'lhz02','刘弘章','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',18,10.00,'doctor',4,4,4,4,4),(40,'mgy02','莫国益','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',19,12.00,'doctor',3,3,3,3,3),(41,'zj02','周杰','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',19,10.00,'doctor',4,4,4,4,4),(42,'ll01','李立','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',20,12.00,'doctor',3,3,3,3,3),(43,'lj01','刘剑','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',20,10.00,'doctor',4,4,4,4,4),(44,'sxr01','孙学蓉','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',21,12.00,'doctor',3,3,3,3,3),(45,'rxm01','任雪梅','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',21,10.00,'doctor',4,4,4,4,4),(46,'lxy01','李晓莹','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',22,12.00,'doctor',3,3,3,3,3),(47,'wp01','吴平','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',22,10.00,'doctor',4,4,4,4,4),(48,'xr01','向荣','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',23,12.00,'doctor',3,3,3,3,3),(49,'hr01','胡蓉','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',23,10.00,'doctor',4,4,4,4,4),(54,'ly03','刘毅','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',24,12.00,'doctor',3,3,3,3,3),(55,'fzj01','方志见','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',24,10.00,'doctor',4,4,4,4,4),(56,'wh01','卫华','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',25,12.00,'doctor',3,3,3,3,3),(57,'yl01','于龙','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',25,10.00,'doctor',4,4,4,4,4),(58,'yhp01','杨海平','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',26,12.00,'doctor',3,3,3,3,3),(59,'zzq01','张志强','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',26,10.00,'doctor',4,4,4,4,4),(62,'lj02','李军','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',27,12.00,'doctor',3,3,3,3,3),(63,'cyp01','程永鹏','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',27,10.00,'doctor',4,4,4,4,4),(64,'lx01','刘希','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',28,12.00,'doctor',3,3,3,3,3),(65,'dxs01','丁贤胜','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',28,10.00,'doctor',4,4,4,4,4),(66,'zjl01','张家龙','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',30,12.00,'doctor',3,3,3,3,3),(67,'dss01','邓双双','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',30,10.00,'doctor',4,4,4,4,4),(68,'cyj01','陈应江','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',31,12.00,'doctor',3,3,3,3,3),(69,'cyy01','陈延玉','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',31,10.00,'doctor',4,4,4,4,4),(70,'lzq01','李志琼','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',32,12.00,'doctor',3,3,3,3,3),(71,'xy01','徐颖','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',32,10.00,'doctor',4,4,4,4,4),(72,'gy01','谷雨','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',33,12.00,'doctor',3,3,3,3,3),(73,'hl01','何磊','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',33,10.00,'doctor',4,4,4,4,4),(74,'wyl01','吴应林','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',34,12.00,'doctor',3,3,3,3,3),(75,'djj01','丁井菊','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',34,10.00,'doctor',4,4,4,4,4),(76,'zc01','张翠','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',35,12.00,'doctor',3,3,3,3,3),(77,'gzq01','葛臻琼','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',35,10.00,'doctor',4,4,4,4,4),(78,'wq01','王琴','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',36,12.00,'doctor',3,3,3,3,3),(79,'qbb01','邱彬彬','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',36,10.00,'doctor',4,4,4,4,4),(80,'ls01','罗霜','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',37,12.00,'doctor',3,3,3,3,3),(81,'lsf01','李顺芬','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',37,10.00,'doctor',4,4,4,4,4),(84,'lcx01','李昌选','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',38,12.00,'doctor',3,3,3,3,3),(85,'cyj02','陈应江','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',38,10.00,'doctor',4,4,4,4,4),(86,'dyd01','董元迪','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',39,12.00,'doctor',3,3,3,3,3),(87,'ljm02','黎金梅','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',39,10.00,'doctor',4,4,4,4,4),(88,'zyr01','钟叶蓉','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',40,12.00,'doctor',3,3,3,3,3),(89,'lm01','卢枚','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',40,10.00,'doctor',4,4,4,4,4),(90,'hh01','胡慧','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',41,12.00,'doctor',3,3,4,2,0),(91,'xwf01','向万发','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',41,10.00,'doctor',4,4,4,4,4),(92,'myy01','马圆圆','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-25','2022-04-29',42,12.00,'doctor',3,3,3,3,3),(93,'lmb01','刘明博','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','主治医生','2022-04-30','2022-05-04',42,10.00,'doctor',4,4,4,4,4),(98,'ycc01','羊吃吃','$2a$10$YcpVuNdAQzDi38hKNySmJOPAgkSMZH7QL8JvybuMdNoW3dcdnIeBO','见习医生','2022-05-07','2022-05-14',65,10.20,'doctor',1,1,1,1,1);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital` (
  `hos_id` bigint NOT NULL AUTO_INCREMENT,
  `hos_name` varchar(50) NOT NULL,
  `hos_level` varchar(20) NOT NULL,
  `hos_nature` varchar(20) NOT NULL,
  `hos_category` varchar(20) NOT NULL,
  `hos_address` varchar(100) NOT NULL,
  `hos_introduce` varchar(1000) NOT NULL,
  `hos_img_url` varchar(1000) NOT NULL,
  `hos_telephone` varchar(20) NOT NULL,
  PRIMARY KEY (`hos_id`),
  UNIQUE KEY `hospital_hos_name_uindex` (`hos_name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,'六盘水市人民医院','三甲','公立','综合','钟山区钟山西路56号','六盘水市人民医院始建于1977年，是一所三级甲等综合医院。2021年2月18日，被全国妇联组织公示为“全国三八红旗手（集体）”拟表彰对象。2021年6月，六盘水市人民医院党委被中共中央授予“全国先进基层党组织”称号。','https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/2934349b033b5bb52a84792b31d3d539b700bc90.jpg','8320006'),(11,'钟山区人民医院','二甲','公立','综合','钟山区凤凰社区大连路48号','六盘水市钟山人民医院是一所集医疗、预防、保健、康复、教学、科研于一体的二级甲等综合医院。现为国家PCCM专科规范化建设优秀单位、全国综合医院中医药工作示范单位。','https://img0.baidu.com/it/u=902460512,417781299&fm=253&fmt=auto&app=138&f=JPEG?w=667&h=500','8228731'),(12,'六盘水市妇幼保健院','三甲','公立','专科','钟山区南环路45号','六盘水市妇幼保健院系贵州省三级甲等妇幼保健院、贵州医科大学非直属附属医院、国家级住院医师规范化培训基地、贵州妇幼保健专科联盟成员单位，北京儿童医院和重庆儿童医院技术指导医院，集医疗、保健、教学、科研为一体，承担着六盘水市及周边地区妇女儿童的医疗保健任务和所辖县区的妇幼健康工作督导任务，是六盘水市危重孕产妇和危重新生儿救治中心。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fp9.itc.cn%2Fq_70%2Fimages03%2F20200730%2F5c25da0bf65d4ec59cf80d4669be8616.jpeg&refer=http%3A%2F%2Fp9.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652097642&t=d0652f380b31ef66b30fbf3574419b38','8697006'),(13,'水城区人民医院','三甲','公立','综合','双水新区凉都大道106号','水城区人民医院始建于1956年，系一家综合性三级甲等医院，开展内、外、妇、职防、儿、传染、五官、中医、针刀、肛肠等综合医疗服务，承担全区公共卫生突发事件、厂矿事故、交通事故急救、职业病防治等工作。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fepaper.lpswz.com%2Fldwb%2Fres%2F1%2F2%2F2009-11%2F18%2F10%2Fres01_attpic_brief.jpg&refer=http%3A%2F%2Fepaper.lpswz.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652098079&t=804078e92ef816d30b21f832d9004060','8936223'),(14,'六枝特区人民医院','二甲','公立','综合','六枝特区人民南路76号','六枝特区医院是六枝特区政府创办的唯一一家非营利性医院，是全区广大人民自己的医院。自2006年1月1日在全特区实行新型农村合作医疗以来，我院坚持以优质的服务、高超的技术、一流的质量、细心的护理、低廉的价格、安心舒适的就医环境、全心全意为全区广大老百姓服务，得到了全区人民的认可与肯定，成为了全区人民就医看病的首选医院。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.sdjzsj5y.com%2Fupload%2F201406%2F20140611154855199.jpg&refer=http%3A%2F%2Fwww.sdjzsj5y.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652098491&t=2702efaaef9345f2cb912661d7167ae4','5328491'),(15,'盘州市人民医院','二甲','公立','综合','盘州市城关镇解放南路中段','盘州市人民医院院1938年在大威寺（现一中校园内）建立，1954年搬迁至城关东山脚（俗称对门山），1990年搬迁至解放南路（南观桥），2015年3月部分科室搬迁至红果亦资孔社区。经过几十年的风雨历程，现已成为集医疗、保健、教学、科研为一体的综合性医院。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.kxlaser.com.cn%2FUploads%2Fueditor%2Fimage%2F20190723%2F5d3686e0d7873.jpg&refer=http%3A%2F%2Fwww.kxlaser.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652098814&t=4cf8091e38dbfe172f726455243b3c78','3221213'),(16,'水矿总医院','三乙','公立','综合','钟山区水西路17号','院本部位于六盘水市中心区，距六盘水火车站仅500 米,占地面积 6.5万平方米，交通便利，环境幽雅。建院四十年来，特别是近几年，全院医务工作者坚持和发扬“医德至上、医术求精、团结拼搏、争创一流 ”的精神，医院规模不断扩大、实力愈显雄厚， 现已发展为一所集医疗、预防保健、科研教学为一体的“三级合格医院”、“ 爱婴医院” 和贵州省高等医学院 校临床教学基地。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ff1.yihuimg.com%2FTFS%2Fupfile%2FWBJ%2F1033485%2F2016-03-23%2F268997_1458720248907_fullsize.jpg&refer=http%3A%2F%2Ff1.yihuimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652099116&t=9788cbcb5337e15074efe68b15e02e47','8179538'),(17,'首钢水钢总医院','三甲','公立','综合','钟山区钟山大道中段564号','首钢水钢总医院始建于1966年6月，经过50余年的发展，现已成为集医疗、教学、科研、预防、康复、急救于一体的现代化大型三级综合医院。北京大学首钢医院、中国医科大学航空总医院医联体成员单位；中国中医科学院广安门医院“李光熙名中医工作站”；中国医学科学院肿瘤医院、首都医科大学附属天坛医院专科联盟成员单位。贵州省人民医院紧密型医联体、遵义医科大学附属医院医联体成员单位，贵州省第三人民医院帮扶医院；华西医院远程会诊和继续医学教育平台医院，省内外多家医学类院校教学实习医院。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20200104%2Fad56f57208cc42688e35bb524f291177.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652099433&t=ed26f70f2be2da4d92eed26f98a2c228','2201120'),(18,'阳光五官科医院','二乙','私立','专科','钟山区人民中路240号','六盘水杨光五官专科医院创建于2008年，杨光医疗机构由院本部和盘县同仁五官专科医院组成。经过几年快速发展，现已建设成为六盘水市一流的五官专科医院，成为遵义医学院教学实习医院和遵义医学院附属医院白内障近视眼治疗中心培训基地。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.lpswz.com%2F09news%2Fimages%2Fattachement%2Fjpg%2Fsite2%2F20100611%2F002185d31e950d7bee9118.jpg&refer=http%3A%2F%2Fwww.lpswz.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652099853&t=5f071ae18752bf96fc0d8a8d3a0b727b','8695733'),(19,'六盘水友好妇科医院','二乙','私立','专科','钟山区经济开发区水西北路3号','六盘水友好妇产医院是一家具有专科特色、个性化服务的现代化医院，是一家集医疗、教研、预防、保健、咨询为一体 的现代化医疗服务机构。以学术研究为基础、新技术临床应用为发展方向、妇科为主的特色专科医院。','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fgss0.baidu.com%2F-fo3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2Fa686c9177f3e67091f7bab3237c79f3df9dc5580.jpg&refer=http%3A%2F%2Fgss0.baidu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652105793&t=bb96a8fc7c8cd49a2da7a42d8206c764','8102635'),(20,'测试医院','三甲','公立','综合','1','1','1','1'),(24,'中山医院','二','私立','专科','七十三转盘处','非常nice','http://localhost:8080/uploadImg/hosImages/2022/05/04/8e7c4a32-4175-4126-84c1-bdb8d1587173.jpg','111110000');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_record`
--

DROP TABLE IF EXISTS `order_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_record` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `surplus_num` int NOT NULL,
  `foreign_pid` bigint DEFAULT NULL,
  `foreign_did` bigint DEFAULT NULL,
  `order_hos_name` varchar(50) DEFAULT NULL,
  `order_department` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `foreign_did` (`foreign_did`),
  KEY `foreign_pid` (`foreign_pid`),
  CONSTRAINT `order_record_ibfk_1` FOREIGN KEY (`foreign_pid`) REFERENCES `patient` (`pat_id`),
  CONSTRAINT `order_record_ibfk_2` FOREIGN KEY (`foreign_did`) REFERENCES `doctor` (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_record`
--

LOCK TABLES `order_record` WRITE;
/*!40000 ALTER TABLE `order_record` DISABLE KEYS */;
INSERT INTO `order_record` VALUES (22,'2022-05-06',5,4,90,'六枝特区人民医院','医学影像科'),(23,'2022-04-26',4,2,90,'六枝特区人民医院','医学影像科');
/*!40000 ALTER TABLE `order_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `pat_id` bigint NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(500) NOT NULL,
  `id_card` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`pat_id`),
  UNIQUE KEY `patient_id_card_uindex` (`id_card`),
  UNIQUE KEY `patient_nick_name_uindex` (`nick_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (2,'喜喜','lucy','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','221025623556622556','13696548852','男',45),(3,'zhx','朱浩鑫','$2a$10$dGmAPEvdZFsQ2ZpkWbnckuyepL9MMvtj98/rFGKv2mkS1kJKOllnK','520221545856665555','13213213132','男',23),(4,'fuck123','吴兵','$2a$10$p7ZFIGS65u38VWVfDoHp7eDpD6FSHvwjR4lB00plRn29WlG/DSNnK','555555555555','111111111','男',24),(11,'niuniu','牛牛','$2a$10$TDkgjnhbPiPKiMEpqqipb.tnNxLdAvedlgKR0BsRkooExYXOkyDC2','520221199712303633','13596324568','男',24);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_record`
--

DROP TABLE IF EXISTS `report_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report_record` (
  `report_id` bigint NOT NULL AUTO_INCREMENT,
  `treatment_date` date NOT NULL,
  `report_url` varchar(200) DEFAULT NULL,
  `treatment_record` varchar(2000) DEFAULT NULL,
  `foreign_patient_id` bigint DEFAULT NULL,
  `foreign_doctor_id` bigint DEFAULT NULL,
  `report_hos_name` varchar(50) DEFAULT NULL,
  `report_depart_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  KEY `foreign_doctor_id` (`foreign_doctor_id`),
  KEY `foreign_patient_id` (`foreign_patient_id`),
  CONSTRAINT `report_record_ibfk_1` FOREIGN KEY (`foreign_patient_id`) REFERENCES `patient` (`pat_id`),
  CONSTRAINT `report_record_ibfk_2` FOREIGN KEY (`foreign_doctor_id`) REFERENCES `doctor` (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_record`
--

LOCK TABLES `report_record` WRITE;
/*!40000 ALTER TABLE `report_record` DISABLE KEYS */;
INSERT INTO `report_record` VALUES (1,'2022-04-27','http:://localhost:8080','该病人没问题',2,15,NULL,NULL),(2,'2022-04-30','http:://localhost:8080','身体很棒',2,20,NULL,NULL),(4,'2022-05-22','http://localhost:8080/uploadImg/hosImages/2022/05/05/0c44063a-7455-4961-8e20-f38d3d11c53a.jpg','效果良好，继续保持',3,98,'中山医院','妇科'),(5,'2022-05-08','http://localhost:8080/uploadImg/hosImages/2022/05/06/deda629f-0ed6-43d8-82d5-c5a30da87f65.jpg','好好吃药',3,13,'六盘水市人民医院','普外科');
/*!40000 ALTER TABLE `report_record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-06  3:07:45
