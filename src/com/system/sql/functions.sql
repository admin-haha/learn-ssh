-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: topicsystem
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Dumping data for table `function`
--

LOCK TABLES `function` WRITE;
/*!40000 ALTER TABLE `function` DISABLE KEYS */;
INSERT INTO `function` VALUES ('e1d3d01925694787ae537a5fffd05bdc','人员管理','#',1,'2018-04-12 16:07:38','2018-04-12 16:07:38','-1','user'),('2f160d292c6148e4ad6d432d3a654838','角色管理','#',2,'2018-04-12 16:07:38','2018-04-12 16:07:38','-1','role'),('c885fce9558e4a3e9678349d40a51ef2','权限管理','#',3,'2018-04-12 16:11:32','2018-04-12 16:11:32','-1','function'),('00b2f69f50e540728dfb2de9891d715d','题目管理','#',4,'2018-04-12 16:11:32','2018-04-12 16:11:32','-1','project'),('ea2fa35a3e9649dd93883e53337f148e','人员查询','/user/list',1,'2018-04-13 16:10:49','2018-04-13 16:10:49','e1d3d01925694787ae537a5fffd05bdc','user-list'),('5f8a786a9b4d46189ccc2023c7189ab8','人员新增','/user/add',2,'2018-04-13 16:10:49','2018-04-13 16:10:49','e1d3d01925694787ae537a5fffd05bdc','user-add'),('10f0f548e09d4644bb325a54757e23b2','人员修改','/user/update',3,'2018-04-13 16:10:49','2018-04-13 16:10:49','e1d3d01925694787ae537a5fffd05bdc','user-update'),('238795a9091c4978a7b64cb5e74ad528','角色查询','/role/list',1,'2018-04-13 16:10:49','2018-04-13 16:10:49','2f160d292c6148e4ad6d432d3a654838','role-list'),('6256e3d29d5d4cdf8df9634ccdb04789','角色新增','/role/add',2,'2018-04-13 16:10:49','2018-04-13 16:10:49','2f160d292c6148e4ad6d432d3a654838','role-add'),('7966c5da3c1e4478b2f1156ac0d464c4','角色修改','/role/update',3,'2018-04-13 16:10:49','2018-04-13 16:10:49','2f160d292c6148e4ad6d432d3a654838','role-update'),('594978d64ce3486d96cee76e1a94f6e3','权限查询','/function/list',1,'2018-04-13 16:10:49','2018-04-13 16:10:49','c885fce9558e4a3e9678349d40a51ef2','function-list'),('d3a0eb6be27046f5a25fd2b8f5d475ed','权限新增','/function/add',2,'2018-04-13 16:10:49','2018-04-13 16:10:49','c885fce9558e4a3e9678349d40a51ef2','function-add'),('da23baa0fac4482b95eeed667df212a0','权限修改','/function/update',3,'2018-04-13 16:10:49','2018-04-13 16:10:49','c885fce9558e4a3e9678349d40a51ef2','function-update'),('863376ad7d1d4656b90730daf63e2862','题目查询','/project/list',1,'2018-04-13 16:10:49','2018-04-13 16:10:49','00b2f69f50e540728dfb2de9891d715d','project-list'),('c3430d5e9b6c47b5814ffaa04dd461eb','题目新增','/project/add',2,'2018-04-13 16:10:49','2018-04-13 16:10:49','00b2f69f50e540728dfb2de9891d715d','project-add'),('0abdf72305fa44ee872a690fc7e95ece','题目修改','/project/update',3,'2018-04-13 16:10:49','2018-04-13 16:10:49','00b2f69f50e540728dfb2de9891d715d','project-update');
/*!40000 ALTER TABLE `function` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-13 17:43:13
