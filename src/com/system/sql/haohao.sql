-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: topicsystem
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `id` varchar(40) DEFAULT NULL COMMENT '学院Id',
  `name` varchar(20) DEFAULT NULL COMMENT '学院名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学院表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES ('9283d015e5c94610b88c6f9557ca76c0','信息工程学院','2018-04-14 03:11:42','2018-04-14 18:42:18'),('db9d67264af5467c9c68de6e4e53b8ff','文学院','2018-04-14 03:11:42','2018-04-14 03:11:42'),('0c692cc2feca4624a64fe934e05c7240','土木工程学院','2018-04-14 03:11:42','2018-04-14 03:11:42'),('73f8f746811a48cd84a3d74f358565dd','机械学院','2018-04-14 03:11:42','2018-04-14 03:11:42'),('722ab5e83b3844e2baf32d8f8bad8467','外国语学院','2018-04-14 03:11:42','2018-04-14 03:11:42'),('8aa1b385ebf04fc68583dce125c7c635','法学院','2018-04-14 19:44:18','2018-04-14 19:44:18');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` varchar(40) DEFAULT NULL COMMENT '科系Id',
  `name` varchar(20) DEFAULT NULL COMMENT '科系名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `college_id` varchar(40) DEFAULT NULL COMMENT '学院id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='科系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('597759267a0b406291314631e4931af9','计算机科学与技术','2018-04-15 04:12:32','2018-04-15 04:12:32','9283d015e5c94610b88c6f9557ca76c0'),('c2f3c41853a548a0815abdfc8d5e06e5','软件工程','2018-04-15 04:34:48','2018-04-15 04:51:37','9283d015e5c94610b88c6f9557ca76c0');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `function`
--

DROP TABLE IF EXISTS `function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function` (
  `func_id` varchar(40) DEFAULT NULL COMMENT '权限Id',
  `name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `func_url` mediumtext COMMENT '权限url',
  `func_order` int(11) DEFAULT '0' COMMENT '权限顺序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `parent_id` varchar(40) DEFAULT NULL COMMENT '父权限ID',
  `func_key` varchar(40) DEFAULT NULL COMMENT '权限key用于表示唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `function`
--

LOCK TABLES `function` WRITE;
/*!40000 ALTER TABLE `function` DISABLE KEYS */;
INSERT INTO `function` VALUES ('e1d3d01925694787ae537a5fffd05bdc','人员管理','#',1,'2018-04-12 16:07:38','2018-04-12 16:07:38','-1','user'),('2f160d292c6148e4ad6d432d3a654838','角色管理','#',2,'2018-04-12 16:07:38','2018-04-12 16:07:38','-1','role'),('c885fce9558e4a3e9678349d40a51ef2','权限管理','#',3,'2018-04-12 16:11:32','2018-04-12 16:11:32','-1','function'),('00b2f69f50e540728dfb2de9891d715d','题目管理','#',4,'2018-04-12 16:11:32','2018-04-12 16:11:32','-1','project'),('ea2fa35a3e9649dd93883e53337f148e','人员查询','/user/list',2,'2018-04-13 16:10:49','2018-04-13 16:10:49','e1d3d01925694787ae537a5fffd05bdc','user-list'),('238795a9091c4978a7b64cb5e74ad528','角色查询','/role/list',2,'2018-04-13 16:10:49','2018-04-13 16:10:49','2f160d292c6148e4ad6d432d3a654838','role-list'),('594978d64ce3486d96cee76e1a94f6e3','权限查询','/function/list',1,'2018-04-13 16:10:49','2018-04-13 16:10:49','c885fce9558e4a3e9678349d40a51ef2','function-list'),('863376ad7d1d4656b90730daf63e2862','题目查询','/project/list',1,'2018-04-13 16:10:49','2018-04-13 16:10:49','00b2f69f50e540728dfb2de9891d715d','project-list'),('c3430d5e9b6c47b5814ffaa04dd461eb','题目新增','/project/add',2,'2018-04-13 16:10:49','2018-04-13 16:10:49','00b2f69f50e540728dfb2de9891d715d','project-add'),('0abdf72305fa44ee872a690fc7e95ece','题目修改','/project/update',3,'2018-04-13 16:10:49','2018-04-13 16:10:49','00b2f69f50e540728dfb2de9891d715d','project-update'),('61b8dde7a9614a5e9d881093f075da7a\n','基础信息','#',5,'2018-04-14 03:13:09','2018-04-14 03:13:09','-1','base'),('dfcd5e85371f48d998878366e621141c','学院查询','/college/list',2,'2018-04-14 03:17:02','2018-04-14 03:17:02','61b8dde7a9614a5e9d881093f075da7a','base-college'),('c03c326ff29a4d7f81f474f5ad497494','科系查询','/department/list',4,'2018-04-14 03:17:02','2018-04-14 03:17:02','61b8dde7a9614a5e9d881093f075da7a','base-department'),('a83173d201154e1dbb9fdc290fe46afc','学院管理','/college/manage',1,'2018-04-15 18:09:59','2018-04-15 18:09:59','61b8dde7a9614a5e9d881093f075da7a','base-college-manage'),('e2a6214923434809aa43e8f0c599d036','科系管理','/department/manage',3,'2018-04-15 18:09:59','2018-04-15 18:09:59','61b8dde7a9614a5e9d881093f075da7a','base-department-manage'),('a1425a51c5f449459f3e32291d78ea7f','人员管理','/user/manage',1,'2018-04-15 18:12:16','2018-04-15 18:12:16','e1d3d01925694787ae537a5fffd05bdc','user-manage'),('f2060550f20346e3b47e9f449a21401f','角色管理','/role/manage',1,'2018-04-15 18:12:16','2018-04-15 18:12:16','2f160d292c6148e4ad6d432d3a654838','role-manage');
/*!40000 ALTER TABLE `function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` varchar(40) DEFAULT NULL COMMENT '题目Id',
  `title` mediumtext COMMENT '题目名称',
  `detail` mediumtext COMMENT '详细描述',
  `memo` mediumtext COMMENT '备注',
  `student_count` int(11) DEFAULT '1' COMMENT '该题目所需学生个数',
  `belong_to` varchar(40) DEFAULT NULL COMMENT '题目所属教师user_id',
  `college_id` varchar(40) DEFAULT NULL COMMENT '所属学院',
  `department_id` varchar(40) DEFAULT NULL COMMENT '所属专业',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='毕业设计题目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolefunction`
--

DROP TABLE IF EXISTS `rolefunction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolefunction` (
  `role_id` varchar(40) DEFAULT NULL COMMENT '角色Id',
  `func_id` varchar(40) DEFAULT NULL COMMENT '权限Id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolefunction`
--

LOCK TABLES `rolefunction` WRITE;
/*!40000 ALTER TABLE `rolefunction` DISABLE KEYS */;
/*!40000 ALTER TABLE `rolefunction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` varchar(40) DEFAULT NULL COMMENT '角色Id',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `memo` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('9968deb53ea44a80a047b0256cfccf1f','教师','2018-04-15 19:02:22','2018-04-15 19:02:32','教师'),('a81f9e7ef4d543a0a25f131806c1ef6c','学生','2018-04-15 19:04:50','2018-04-15 19:04:57','学生');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useroles`
--

DROP TABLE IF EXISTS `useroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useroles` (
  `user_id` varchar(40) DEFAULT NULL COMMENT '人员Id',
  `role_id` varchar(40) DEFAULT NULL COMMENT '角色Id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useroles`
--

LOCK TABLES `useroles` WRITE;
/*!40000 ALTER TABLE `useroles` DISABLE KEYS */;
/*!40000 ALTER TABLE `useroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userproject`
--

DROP TABLE IF EXISTS `userproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userproject` (
  `user_id` varchar(40) DEFAULT NULL COMMENT '学生Id',
  `project_id` varchar(40) DEFAULT NULL COMMENT '题目Id',
  `score` int(11) DEFAULT NULL COMMENT '得分',
  `memo` mediumtext COMMENT '评语',
  `check_by` varchar(40) DEFAULT NULL COMMENT '评分人user_id',
  `check_date` datetime DEFAULT NULL COMMENT '评分日期',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生和毕设题目关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userproject`
--

LOCK TABLES `userproject` WRITE;
/*!40000 ALTER TABLE `userproject` DISABLE KEYS */;
/*!40000 ALTER TABLE `userproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` varchar(40) DEFAULT NULL COMMENT '人员Id',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `gender` int(11) DEFAULT '0' COMMENT '性别 0：男 。1；女',
  `college_id` varchar(40) DEFAULT NULL COMMENT '所属学院',
  `department_id` varchar(40) DEFAULT NULL COMMENT '所属专业',
  `account` varchar(30) NOT NULL COMMENT '登陆账号',
  `password` varchar(20) DEFAULT NULL COMMENT '登陆密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 19:11:38
