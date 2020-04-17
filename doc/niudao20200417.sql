-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: niudao
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` varchar(50) NOT NULL,
  `course_type_id` varchar(50) DEFAULT NULL,
  `course_category_id` varchar(50) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `course_img` varchar(500) DEFAULT NULL,
  `course_des` varchar(2000) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `study_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK_Reference_2` (`course_type_id`),
  KEY `FK_Reference_4` (`course_category_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`course_type_id`) REFERENCES `course_type` (`course_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`course_category_id`) REFERENCES `course_category` (`course_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('1702de0aec635aa3f85881dd92b363b6','a2bf1fd80ce1bb32b1febe49e88af866','520c3db3288266908aa6d21d3779ce8a','最实在的安全认证视频教程','1、组件的详细使用—第一版和第二版区别以及为什么要用组件开发.png','安全认证',28.00,'2020-04-01 16:05:13',NULL),('335a98cdcafc89a49756a73b8241c111','a2bf1fd80ce1bb32b1febe49e88af866','db40ba59f2b7d1f0117297993369a4df','Vue组件设计','000000.png','知识点包括java基础和高级\n适用于有一定工作经验的java开发者，如1~5年经验。',9.90,'2020-03-30 16:05:19',NULL),('47fcf4a07ccd374d2ef6a6b020a60b38','8819e2590b2a66209271c7879f564458','bfd67c14ddb0eb23fead2a5e5a83481a','项目管理6个关键阶段','项目管理关键阶段.png','1、项目的全生命周期和里程碑\n2、项目需求调研阶段\n3、项目需求分析阶段\n4、项目概要设计阶段\n5、项目详细设计阶段\n6、开发阶段之后以及项目管理-团队搭建、计划、沟通、汇报',0.00,'2020-03-20 16:05:24',NULL),('4ffa3c85ab02f2a0446187c50b53a6e5','1f5c6fe37b7219eaa763b109b77cf7fb','520c3db3288266908aa6d21d3779ce8a','SpringAop原理和示例','fm.jpg','比较全面的介绍SpringAop原理和示例',NULL,'2020-02-25 16:05:29',NULL),('6ae80ec7b66503800e93c5720ce55863','9de0eac205fd4f2e2452c1182b2b473c','d3bf81b9c0bbbae252b17fe38b12cbd0','5分钟搞懂“区块链”！看完妈妈再也不用担心我被骗了！','区块链02.png','5分钟搞懂“区块链”！看完妈妈再也不用担心我被骗了！',NULL,'2020-03-21 16:05:44',NULL),('78978817c003e2cce023e6def42daf14','8819e2590b2a66209271c7879f564458','520c3db3288266908aa6d21d3779ce8a','代码生成工具EasyCode','代码生成工具EasyCode，大大提高开发效率.png','代码生成工具EasyCode',NULL,'2019-12-19 16:05:35',NULL),('7be17bc8c95aa67bf2f219b2aa83b343','8819e2590b2a66209271c7879f564458','520c3db3288266908aa6d21d3779ce8a','前端基于vue、axios，后端基于springSecurity、JWT、BCR算法加密解密一个完整的登录、权限管理','安全登录认证.png','前端基于vue、axios，后端基于springSecurity、JWT、BCR算法加密解密一个完整的登录、权限管理。',NULL,'2020-03-18 16:05:44',NULL),('87f98f8cef3772a22fdd7d8546e4ddd8','8819e2590b2a66209271c7879f564458',NULL,'Springboot、ssm、vue，我知道这是你们的刚需。准备录制这个学习平台的教程。','1845feb43ccba7104a94252510918c9ffb5d22b4.jpg','Springboot、ssm、vue，我知道这是你们的刚需。准备录制这个学习平台的教程，',NULL,'2020-04-13 16:05:44',NULL),('932b5e5644d371d8896509653b182f1e','1f5c6fe37b7219eaa763b109b77cf7fb','508076bbf09b4e14726e3227423c82cc','客户管理系统','0-封面png.png','客户管理系统',NULL,'2020-03-20 16:05:51',NULL),('966011798d12b2894133873e46b1eaba','9de0eac205fd4f2e2452c1182b2b473c','d3bf81b9c0bbbae252b17fe38b12cbd0','TED演讲：区块链将如何改变金钱与贸易?','区块链01.png','区块链将如何改变金钱与贸易?',NULL,'2020-03-20 16:05:51',NULL),('b84396e7bee71c2e9645de1e363d2a01','8819e2590b2a66209271c7879f564458','bf9eef08855de5636c6832d2061c0b20','少走弯路：快速分清楚前后端分离的开发方法','web架构.png','这是一个很好的引导性教材，使你在没有认清Web项目前后端分离的技术方向时，给你一个全貌的认识，知道自己要学些什么。\n30多分钟就能分清楚前后端分离的开发方法，还带你用脚手架创建Vue项目，后端API开发统一返回对象的封装方式，少走弯路。',NULL,'2020-03-20 16:05:51',NULL),('c587151d73e75d4f788b3ee002bdda92','1f5c6fe37b7219eaa763b109b77cf7fb','db40ba59f2b7d1f0117297993369a4df','Vue组件开发','封面.png','Vue组件开发',NULL,'2020-03-30 16:05:57',NULL),('df30d09f621fd32cad9066210e5a4523','9de0eac205fd4f2e2452c1182b2b473c','5ee184a4b85c9c21a9fa6a24e15b281b','Java零基础教程视频（适合Java 0基础，Java初学入门）','java基础001.png','基础类型、变量、类、方法、集合、常用算法、设计模式',NULL,'2020-04-01 16:06:03',NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_and_knowledge`
--

DROP TABLE IF EXISTS `course_and_knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_and_knowledge` (
  `id` varchar(50) NOT NULL,
  `course_id` varchar(50) DEFAULT NULL,
  `course_knowledge_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`course_id`),
  KEY `FK_Reference_6` (`course_knowledge_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`course_knowledge_id`) REFERENCES `course_knowledge` (`course_knowledge_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_and_knowledge`
--

LOCK TABLES `course_and_knowledge` WRITE;
/*!40000 ALTER TABLE `course_and_knowledge` DISABLE KEYS */;
INSERT INTO `course_and_knowledge` VALUES ('01e67e0af4b4f1f4ffddbddeb9e72412','df30d09f621fd32cad9066210e5a4523','309e4981cfb7b2386144b4872f2f59b8'),('08f47c3b5d7ef0da4162e0195144ef7d','1702de0aec635aa3f85881dd92b363b6','5610c4827c806eba1f5aca7774a3b5cb'),('0b73b34962ad2e13967fb4286f613bd4','87f98f8cef3772a22fdd7d8546e4ddd8','5610c4827c806eba1f5aca7774a3b5cb'),('12207b36170715c6e8b594a49fc99882','b84396e7bee71c2e9645de1e363d2a01','ad3e3694598befadca3f33d42db739d1'),('1469ffec0522b2fdb1c9407286e2b881','335a98cdcafc89a49756a73b8241c111','64fc6bc26a58f20134034be265194ad3'),('25f205cf394821f8ba1a86d487727096','932b5e5644d371d8896509653b182f1e','076406cee6824e34cdd61b41001c5b23'),('267a00f8fa2fc2b3d9e711b95febb520','4ffa3c85ab02f2a0446187c50b53a6e5','076406cee6824e34cdd61b41001c5b23'),('269811d2ebfdeaec6c6df56df4b3ad83','87f98f8cef3772a22fdd7d8546e4ddd8','96ff6b03d90c36307908feb095f7c757'),('2b282395a442b4ca02044a93dd2a4bbb','87f98f8cef3772a22fdd7d8546e4ddd8','6478180a15aa81d6cd3e049f6d01c57f'),('310a90ada1c4475c8a1d1253544d1154','4ffa3c85ab02f2a0446187c50b53a6e5','a5e1427af7f5e9b8b0ead54c8bc7f64b'),('48c54b5b91fd078809c822163636fabd','87f98f8cef3772a22fdd7d8546e4ddd8','60b8f403ac17c71fb0c455645ac35006'),('55ab56b7322186e151b7d765975ae367','6ae80ec7b66503800e93c5720ce55863','32d26c2fe2a0d503566a342ee6feb95c'),('5c47fe95445c645c75157b3a88bfe510','335a98cdcafc89a49756a73b8241c111','0a88fb69d29a62a94f6465f21457de30'),('603388b9d9f81fe186e633610785cd3a','87f98f8cef3772a22fdd7d8546e4ddd8','30a714bf3d5ef217ffc25a34dd288ed9'),('7d04962d622b4603d305794f95ec4263','335a98cdcafc89a49756a73b8241c111','96ff6b03d90c36307908feb095f7c757'),('7f4d1109cfb2c839deafdbece4953b00','932b5e5644d371d8896509653b182f1e','7023872e01509a9b82cc676d2279db9c'),('971dd6e6f8a702e56d9bab20e320938e','87f98f8cef3772a22fdd7d8546e4ddd8','309e4981cfb7b2386144b4872f2f59b8'),('97df4784293733eb46041f2c4e1b9bef','966011798d12b2894133873e46b1eaba','32d26c2fe2a0d503566a342ee6feb95c'),('a74acf9d9cd994ded2ae289900ce24f9','78978817c003e2cce023e6def42daf14','076406cee6824e34cdd61b41001c5b23'),('ac7da752764d1f4a855016f5aaed2886','87f98f8cef3772a22fdd7d8546e4ddd8','64fc6bc26a58f20134034be265194ad3'),('b317a93a692d2225a315786bd55db33b','7be17bc8c95aa67bf2f219b2aa83b343','076406cee6824e34cdd61b41001c5b23'),('b7ad3f8bb6315e919f94835a212220c4','1702de0aec635aa3f85881dd92b363b6','30a714bf3d5ef217ffc25a34dd288ed9'),('b7c174266273dd337da367d7c5716b76','7be17bc8c95aa67bf2f219b2aa83b343','2d1fb04c5dea34f74d336152c97d74a7'),('d470ef77eeb1fd8c1098ab3f062ec465','932b5e5644d371d8896509653b182f1e','309e4981cfb7b2386144b4872f2f59b8'),('d51d95f0cedd8fc3d3d5b3b554477574','b84396e7bee71c2e9645de1e363d2a01','6478180a15aa81d6cd3e049f6d01c57f'),('d883c87045677190196d13a178c7ef6f','87f98f8cef3772a22fdd7d8546e4ddd8','076406cee6824e34cdd61b41001c5b23'),('db9dd525775df3be5383940f72989f46','932b5e5644d371d8896509653b182f1e','2fba6acb0d1f926f9a07bbad677f41b2'),('dbcc13fd3165a856098b1b05189f02f1','1702de0aec635aa3f85881dd92b363b6','076406cee6824e34cdd61b41001c5b23'),('e47b0f0bb714a156c41c53f7a5d48b55','87f98f8cef3772a22fdd7d8546e4ddd8','2d1fb04c5dea34f74d336152c97d74a7'),('e4ab3aa8e098eca9ccd0f3029d21c021','1702de0aec635aa3f85881dd92b363b6','2d1fb04c5dea34f74d336152c97d74a7'),('edc352b292916acf5e1419c6deabbcbe','78978817c003e2cce023e6def42daf14','2d1fb04c5dea34f74d336152c97d74a7'),('f8f06bfb4ce612ce360cdb812b5316ef','7be17bc8c95aa67bf2f219b2aa83b343','5610c4827c806eba1f5aca7774a3b5cb');
/*!40000 ALTER TABLE `course_and_knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_and_people`
--

DROP TABLE IF EXISTS `course_and_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_and_people` (
  `id` varchar(50) NOT NULL,
  `course_for_people_id` varchar(50) DEFAULT NULL,
  `course_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`course_for_people_id`),
  KEY `FK_Reference_8` (`course_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`course_for_people_id`) REFERENCES `course_for_people` (`course_for_people_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_and_people`
--

LOCK TABLES `course_and_people` WRITE;
/*!40000 ALTER TABLE `course_and_people` DISABLE KEYS */;
INSERT INTO `course_and_people` VALUES ('0f0f54349848475418918f0516313c83','9926652f832337989faefa61b2148a7f','7be17bc8c95aa67bf2f219b2aa83b343'),('14008171338c1a639fca88f5df8299fd','9926652f832337989faefa61b2148a7f','966011798d12b2894133873e46b1eaba'),('1a2181e109b9a1bcc804d5286c2364e6','22c4229866921d7e3ccf37bb7993ac84','78978817c003e2cce023e6def42daf14'),('2d649ad1363416e84dd0f4c838efe193','379329d3bd4c718ba2680ed1737731a2','1702de0aec635aa3f85881dd92b363b6'),('40b4649c3c0ca2c6fe71423314c8f621','9926652f832337989faefa61b2148a7f','78978817c003e2cce023e6def42daf14'),('56d8bbe43fe5c1cef248684a2f1d3e19','22c4229866921d7e3ccf37bb7993ac84','6ae80ec7b66503800e93c5720ce55863'),('5ea352af660c9b5aea5b16ca42f40a2d','9926652f832337989faefa61b2148a7f','c587151d73e75d4f788b3ee002bdda92'),('702b9fa1a977a1d7230de93551ce84b5','9926652f832337989faefa61b2148a7f','335a98cdcafc89a49756a73b8241c111'),('7acd04e9a1247b1388f1069ed08debbb','9926652f832337989faefa61b2148a7f','87f98f8cef3772a22fdd7d8546e4ddd8'),('7cd7f5e66bc386db5c8e88e158db3f42','9926652f832337989faefa61b2148a7f','932b5e5644d371d8896509653b182f1e'),('89bdccd7e7e8d15ed0f78d1877997069','22c4229866921d7e3ccf37bb7993ac84','7be17bc8c95aa67bf2f219b2aa83b343'),('9ca777a5e26780ac3c77bd7931683a74','22c4229866921d7e3ccf37bb7993ac84','c587151d73e75d4f788b3ee002bdda92'),('aa3a5ccbbe3e32432e603826d44e42f9','e734d0348ec445596fd8cd66db9a1b6b','335a98cdcafc89a49756a73b8241c111'),('b13dc5d2ae86ba5b150b688b6ab1f925','e734d0348ec445596fd8cd66db9a1b6b','4ffa3c85ab02f2a0446187c50b53a6e5'),('d82f64d7d0f6e7760052229856a6ac67','379329d3bd4c718ba2680ed1737731a2','b84396e7bee71c2e9645de1e363d2a01'),('d8832b9ed2bb168c50e152a4ca2f76c6','22c4229866921d7e3ccf37bb7993ac84','df30d09f621fd32cad9066210e5a4523'),('ec2170423f32900c7032d232b4b6feb9','379329d3bd4c718ba2680ed1737731a2','47fcf4a07ccd374d2ef6a6b020a60b38'),('efc459ae5b028744a0effe15150a36cb','e734d0348ec445596fd8cd66db9a1b6b','b84396e7bee71c2e9645de1e363d2a01'),('f7aea66842671f98da8fee0a0ed0b9eb','22c4229866921d7e3ccf37bb7993ac84','966011798d12b2894133873e46b1eaba');
/*!40000 ALTER TABLE `course_and_people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_category`
--

DROP TABLE IF EXISTS `course_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_category` (
  `course_category_id` varchar(50) NOT NULL,
  `course_category_name` varchar(100) DEFAULT NULL,
  `course_category_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_category`
--

LOCK TABLES `course_category` WRITE;
/*!40000 ALTER TABLE `course_category` DISABLE KEYS */;
INSERT INTO `course_category` VALUES ('0c8728ee7f089e1bdf4693f51f5aa2f9','前端语言',200),('1c43114e9947c95f2733a2e1136f4f65','中间件',460),('1f34fc98060165f33490f56de18dadd6','嵌入式',1000),('508076bbf09b4e14726e3227423c82cc','其它',1500),('520c3db3288266908aa6d21d3779ce8a','MVC框架',300),('565d156f7a316105c0330aaec3b81963','职场经验',1400),('5b801c1ac619a82baa1d80012dbf731b','大数据',800),('5ee184a4b85c9c21a9fa6a24e15b281b','后端语言',100),('601422517dee691bcdadaaa0be1d2eb0','面试分享',1300),('a49cd5e5e42d64124f185673d67a3600','小程序端',600),('a7e7af0166d8382d871d9ee26f7cea23','App端',700),('bf9eef08855de5636c6832d2061c0b20','系统架构',450),('bfd67c14ddb0eb23fead2a5e5a83481a','项目管理',1200),('c0e3d802e4f9283e13d562490d722dec','UI设计',1100),('c1d8566f96461f08ae3886add005052c','数据库',500),('d3bf81b9c0bbbae252b17fe38b12cbd0','区块链',900),('db40ba59f2b7d1f0117297993369a4df','前端框架',400);
/*!40000 ALTER TABLE `course_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_chapter`
--

DROP TABLE IF EXISTS `course_chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_chapter` (
  `course_chapter_id` varchar(50) NOT NULL,
  `course_id` varchar(50) DEFAULT NULL,
  `course_chapter_name` varchar(100) DEFAULT NULL,
  `course_chapter_img` varchar(255) DEFAULT NULL,
  `course_chapter_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_chapter_type` int(11) DEFAULT NULL,
  `course_chapter_sort` int(11) DEFAULT '0',
  PRIMARY KEY (`course_chapter_id`),
  KEY `FK_Reference_1` (`course_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_chapter`
--

LOCK TABLES `course_chapter` WRITE;
/*!40000 ALTER TABLE `course_chapter` DISABLE KEYS */;
INSERT INTO `course_chapter` VALUES ('017df6a23ff764ffa3ee729d6c77996f','47fcf4a07ccd374d2ef6a6b020a60b38','1、项目的全生命周期和里程碑',NULL,'http://player.bilibili.com/player.html?aid=99660640&bvid=BV1Q7411X7TH&cid=170180901&page=1',2,1),('02541107d6b377bc11e40d9430f81300','c587151d73e75d4f788b3ee002bdda92','组件使用的配置',NULL,'http://player.bilibili.com/player.html?aid=98410225&bvid=BV1DE411F71m&cid=167993930&page=4',2,4),('0b81e8a932a1e9ddb53bed2d282df9af','335a98cdcafc89a49756a73b8241c111','Vue组件设计',NULL,'http://player.bilibili.com/player.html?aid=98021165&bvid=BV1VE411P7dz&cid=167319294&page=1',2,1),('0d11e5aff41532af983a915686a4e7b8','4ffa3c85ab02f2a0446187c50b53a6e5','AOP前置方法@Befaore',NULL,'http://player.bilibili.com/player.html?aid=91703306&bvid=BV137411M792&cid=156580148&page=4',2,4),('0d7ec9b5bf1ba7d8c32904050968ba83','932b5e5644d371d8896509653b182f1e','第一节：建立数据库表',NULL,'http://player.bilibili.com/player.html?aid=74748299&bvid=BV1tE411i7G9&cid=153726281&page=2',2,2),('179e3f357ccdfb73a3d8bd39e4a1aa2f','b84396e7bee71c2e9645de1e363d2a01','3、脚手架搭建前端+后端分离项目',NULL,'http://player.bilibili.com/player.html?aid=92009192&bvid=BV1K7411T7N7&cid=157507726&page=3',2,3),('1bce407c5050d744307454c06cd9fdce','7be17bc8c95aa67bf2f219b2aa83b343','1、整体说明',NULL,'http://player.bilibili.com/player.html?aid=95750500&bvid=BV1KE41157nL&cid=163457650&page=1',2,1),('2130002cc3854bf0838b65df1ff7e8aa','b84396e7bee71c2e9645de1e363d2a01','2、弱前端+后端分离项目',NULL,'http://player.bilibili.com/player.html?aid=92009192&bvid=BV1K7411T7N7&cid=157438478&page=2',2,2),('2269b6e8d4899eb2a1f858395106b9c9','966011798d12b2894133873e46b1eaba','无字幕',NULL,'http://player.bilibili.com/player.html?aid=73516082&bvid=BV1zE411a78T&cid=125754660&page=3',2,3),('2a4e583b69f2fa03daf34f1b06215267','932b5e5644d371d8896509653b182f1e','课程整体介绍',NULL,'http://player.bilibili.com/player.html?aid=74748299&bvid=BV1tE411i7G9&cid=127862924&page=10',2,1),('365bcc97e9df07b52fecc1ed6fec0ec5','47fcf4a07ccd374d2ef6a6b020a60b38','2、项目需求调研阶段',NULL,'http://player.bilibili.com/player.html?aid=99660640&bvid=BV1Q7411X7TH&cid=174667244&page=2',2,2),('3e5b32354a64339be49b0438bd3655c0','4ffa3c85ab02f2a0446187c50b53a6e5','AOP的魅力之处',NULL,'http://player.bilibili.com/player.html?aid=91703306&bvid=BV137411M792&cid=156579469&page=3',2,3),('41ec638730012cf21aa8f69280a9ad6a','1702de0aec635aa3f85881dd92b363b6','基本需求',NULL,'http://player.bilibili.com/player.html?aid=95750500&bvid=BV1KE41157nL',2,1),('561cca3857ed6f56c481b0d4fb11ba78','6ae80ec7b66503800e93c5720ce55863','5分钟搞懂“区块链”',NULL,'http://player.bilibili.com/player.html?aid=73886508&bvid=BV1QE411h7uH&cid=126387934&page=1',2,1),('57881cebdd55f0f158f37129fbc0e73f','c587151d73e75d4f788b3ee002bdda92','用列表组件3分钟做一个功能',NULL,'http://player.bilibili.com/player.html?aid=98410225&bvid=BV1DE411F71m&cid=167993743&page=3',2,3),('59a9952b56222a1e3b11aac51de5c38e','c587151d73e75d4f788b3ee002bdda92','表单组件的开发',NULL,'http://player.bilibili.com/player.html?aid=98410225&bvid=BV1DE411F71m&cid=169253303&page=7',2,7),('59eb14c33652997a405c377cb585688f','df30d09f621fd32cad9066210e5a4523','1、环境安装',NULL,'http://player.bilibili.com/player.html?aid=11361088&bvid=BV1Rx411876f&cid=18787271&page=23',2,1),('5acabef0a838bbc779316b91e02b89c4','47fcf4a07ccd374d2ef6a6b020a60b38','3、项目需求分析阶段',NULL,'http://player.bilibili.com/player.html?aid=99660640&bvid=BV1Q7411X7TH&cid=174667244&page=3',2,3),('5d50c065ebd3cc5210ae05cec6c70f89','47fcf4a07ccd374d2ef6a6b020a60b38','4、项目概要设计阶段',NULL,'http://player.bilibili.com/player.html?aid=99660640&bvid=BV1Q7411X7TH&cid=174667244&page=4',2,4),('5f6a401c5e576d21c438df4815bd7f3f','932b5e5644d371d8896509653b182f1e','第二节：创建后台项目',NULL,'http://player.bilibili.com/player.html?aid=74748299&bvid=BV1tE411i7G9&cid=153726292&page=3',2,3),('60457944fa22a19e2fba069a5a2cf1af','c587151d73e75d4f788b3ee002bdda92','表单组件的设计',NULL,'http://player.bilibili.com/player.html?aid=98410225&bvid=BV1DE411F71m&cid=169252826&page=6',2,6),('6981edffc866b7ada60ad02577e4e86a','b84396e7bee71c2e9645de1e363d2a01','1、前后端放在一起打包的项目',NULL,'http://player.bilibili.com/player.html?aid=92009192&bvid=BV1K7411T7N7&cid=157218689&page=1',2,1),('7078213556bf33d858beb6b6f5202aa9','47fcf4a07ccd374d2ef6a6b020a60b38','5、项目详细设计阶段',NULL,'http://player.bilibili.com/player.html?aid=99660640&bvid=BV1Q7411X7TH&cid=174667244&page=5',2,5),('7773b192bcfaff37f8e8859e6698d208','c587151d73e75d4f788b3ee002bdda92','组件设计扩展思路',NULL,'http://player.bilibili.com/player.html?aid=98410225&bvid=BV1DE411F71m&cid=167994880&page=5',2,5),('7aa9fb534ff552f91c9e209414cec930','78978817c003e2cce023e6def42daf14','代码生成工具EasyCode',NULL,'http://player.bilibili.com/player.html?aid=92214964&bvid=BV1q7411N7eV&cid=157450969&page=1',2,1),('88dc21b1800715a113ea0eee0ba29719','7be17bc8c95aa67bf2f219b2aa83b343','5、前后端技术框架说明',NULL,'http://player.bilibili.com/player.html?aid=95750500&bvid=BV1KE41157nL&cid=163929055&page=5',2,5),('9521a95d74986b0d524303846a1a3c97','966011798d12b2894133873e46b1eaba','双语',NULL,'http://player.bilibili.com/player.html?aid=73516082&bvid=BV1zE411a78T&cid=125754752&page=1',2,1),('980257bdd1190083a0e29fadaf116066','7be17bc8c95aa67bf2f219b2aa83b343','2、需求描述和重要的流程',NULL,'http://player.bilibili.com/player.html?aid=95750500&bvid=BV1KE41157nL&cid=164588198&page=2',2,2),('9e6db4ad44cae585583ddd034b15f65b','87f98f8cef3772a22fdd7d8546e4ddd8','Springboot、ssm、vue，我知道这是你们的刚需。准备录制这个学习平台的教程',NULL,'http://player.bilibili.com/player.html?aid=412676027&bvid=BV1JV411o7qq&cid=177097834&page=1',2,1),('af69599d48870c2e25a88afdd94200b5','7be17bc8c95aa67bf2f219b2aa83b343','3、技术分解、数据库设计',NULL,'http://player.bilibili.com/player.html?aid=95750500&bvid=BV1KE41157nL&cid=163864836&page=3',2,3),('b29dbed09d467316acaf310fab7223c8','4ffa3c85ab02f2a0446187c50b53a6e5','AOP是什么',NULL,'http://player.bilibili.com/player.html?aid=91703306&bvid=BV137411M792&cid=156577291&page=1',2,1),('bed5a0070e7d93dcd65230d98c724bdd','7be17bc8c95aa67bf2f219b2aa83b343','4、源码下载和部署运行',NULL,'http://player.bilibili.com/player.html?aid=95750500&bvid=BV1KE41157nL&cid=163878221&page=4',2,4),('bf7ac79548b109cb30441ebf0689ff4e','4ffa3c85ab02f2a0446187c50b53a6e5','菜鸟级别怎么处理AOP的场景',NULL,'http://player.bilibili.com/player.html?aid=91703306&bvid=BV137411M792&cid=156578787&page=2',2,2),('cb915bf418fc457cf99529d4e451b808','c587151d73e75d4f788b3ee002bdda92','和第一版的区别是什么？',NULL,'http://player.bilibili.com/player.html?aid=98410225&bvid=BV1DE411F71m&cid=167993189&page=1',2,1),('d5e633ac26da6b4a2c1f321fba9726f2','47fcf4a07ccd374d2ef6a6b020a60b38','6、开发阶段之后以及项目管理-团队搭建、计划、沟通、汇报',NULL,'http://player.bilibili.com/player.html?aid=99660640&bvid=BV1Q7411X7TH&cid=174667244&page=6',2,6),('e9eeca592fcc74761834d85fb12e3f81','c587151d73e75d4f788b3ee002bdda92','用表单组件3分钟做一个功能',NULL,'http://player.bilibili.com/player.html?aid=98410225&bvid=BV1DE411F71m&cid=167993348&page=2',2,2),('eef97661d36c676a6ed92368df699b94','966011798d12b2894133873e46b1eaba','英语',NULL,'http://player.bilibili.com/player.html?aid=73516082&bvid=BV1zE411a78T&cid=125754870&page=2',2,2);
/*!40000 ALTER TABLE `course_chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_comment`
--

DROP TABLE IF EXISTS `course_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_comment` (
  `comment_id` varchar(50) DEFAULT NULL,
  `comment_text` varchar(500) DEFAULT NULL,
  `comment_time` datetime DEFAULT NULL,
  `comment_id_ref` varchar(50) DEFAULT NULL,
  `course_id` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  KEY `FK_Reference_9` (`course_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_comment`
--

LOCK TABLES `course_comment` WRITE;
/*!40000 ALTER TABLE `course_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_for_people`
--

DROP TABLE IF EXISTS `course_for_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_for_people` (
  `course_for_people_id` varchar(50) NOT NULL,
  `course_for_people_name` varchar(100) DEFAULT NULL,
  `course_for_people_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_for_people_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_for_people`
--

LOCK TABLES `course_for_people` WRITE;
/*!40000 ALTER TABLE `course_for_people` DISABLE KEYS */;
INSERT INTO `course_for_people` VALUES ('22c4229866921d7e3ccf37bb7993ac84','零基础',1),('379329d3bd4c718ba2680ed1737731a2','5年以上工作经验',4),('9926652f832337989faefa61b2148a7f','0-3年工作经验',2),('e734d0348ec445596fd8cd66db9a1b6b','3-5年工作经验',3);
/*!40000 ALTER TABLE `course_for_people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_knowledge`
--

DROP TABLE IF EXISTS `course_knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_knowledge` (
  `course_knowledge_id` varchar(50) NOT NULL,
  `course_category_id` varchar(50) DEFAULT NULL COMMENT '分类',
  `course_knowledge_name` varchar(100) DEFAULT NULL,
  `course_knowledge_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_knowledge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_knowledge`
--

LOCK TABLES `course_knowledge` WRITE;
/*!40000 ALTER TABLE `course_knowledge` DISABLE KEYS */;
INSERT INTO `course_knowledge` VALUES ('076406cee6824e34cdd61b41001c5b23','520c3db3288266908aa6d21d3779ce8a','SpringBoot',111),('09cd4b16afa21a1924f667da7a17e09e','bf9eef08855de5636c6832d2061c0b20','SpringCloud',120),('0a88fb69d29a62a94f6465f21457de30','db40ba59f2b7d1f0117297993369a4df','vue-router',322),('1b422984e8be28dfd5bdbf8cfcdbe072','bf9eef08855de5636c6832d2061c0b20','ZooKeeper',122),('2552e3eb57f823339d8b9c827ee30452','5ee184a4b85c9c21a9fa6a24e15b281b','php',101),('271ae0896ba356a50bf98a7fe48d02ff','5b801c1ac619a82baa1d80012dbf731b','AI​深度网络',502),('29ca78337b119c7898636e84bf5d47c8','5b801c1ac619a82baa1d80012dbf731b','AI​机器学习',503),('2d1fb04c5dea34f74d336152c97d74a7','520c3db3288266908aa6d21d3779ce8a','MyBatis',103),('2fba6acb0d1f926f9a07bbad677f41b2','be50cb9d449ed4d66dd3bad371f830af','HTML',300),('309e4981cfb7b2386144b4872f2f59b8','5ee184a4b85c9c21a9fa6a24e15b281b','Java',100),('30a714bf3d5ef217ffc25a34dd288ed9','520c3db3288266908aa6d21d3779ce8a','SpringMVC',110),('32d26c2fe2a0d503566a342ee6feb95c','d3bf81b9c0bbbae252b17fe38b12cbd0','区块链概念',600),('377ab6bcb49f3359b0c55396b4088c98','5b801c1ac619a82baa1d80012dbf731b','python',500),('40c3c25b2fb746ebd04c70193d731218','5ee184a4b85c9c21a9fa6a24e15b281b','C#',102),('49e24e9c8248ada6752e6dada4ffa549','1f34fc98060165f33490f56de18dadd6','Redis',400),('5610c4827c806eba1f5aca7774a3b5cb','520c3db3288266908aa6d21d3779ce8a','SpringSecurity',112),('60b8f403ac17c71fb0c455645ac35006','be50cb9d449ed4d66dd3bad371f830af','JavaScript',302),('6478180a15aa81d6cd3e049f6d01c57f','bf9eef08855de5636c6832d2061c0b20','WEB项目架构',117),('64fc6bc26a58f20134034be265194ad3','db40ba59f2b7d1f0117297993369a4df','vue事件绑定',321),('7023872e01509a9b82cc676d2279db9c','be50cb9d449ed4d66dd3bad371f830af','CSS3',301),('75dc9f738d053cf1c508a11f084c4080','1f34fc98060165f33490f56de18dadd6','ElasticSearch',401),('96ff6b03d90c36307908feb095f7c757','db40ba59f2b7d1f0117297993369a4df','vue双向绑定',320),('9c85638416a60ff29d1083d6d6a797ae','bf9eef08855de5636c6832d2061c0b20','分布式架构',119),('9eda1b04b761d8579199b856c54731b9','bf9eef08855de5636c6832d2061c0b20','ActivateMQ',123),('9ee934d6e5905c370cc0e56b801eae64','5b801c1ac619a82baa1d80012dbf731b','AI​神经网络',501),('a287b86452935349329f6b9c036a680f','520c3db3288266908aa6d21d3779ce8a','Hibernate',104),('a5e1427af7f5e9b8b0ead54c8bc7f64b','520c3db3288266908aa6d21d3779ce8a','SpringAop',113),('a63912a5dff9ef60f29f95b303b4aff5','db40ba59f2b7d1f0117297993369a4df','vuex',323),('ad3e3694598befadca3f33d42db739d1','bf9eef08855de5636c6832d2061c0b20','企业级开发架构',118),('c5413913f2460f907e0914e7ed48fd1c','5b801c1ac619a82baa1d80012dbf731b','AI深度学习',504),('f2554a0a2185f62ad5d9572cb0f5aeac','bf9eef08855de5636c6832d2061c0b20','Dubbo',121);
/*!40000 ALTER TABLE `course_knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_type`
--

DROP TABLE IF EXISTS `course_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_type` (
  `course_type_id` varchar(50) NOT NULL,
  `course_type_name` varchar(100) DEFAULT NULL,
  `course_type_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_type`
--

LOCK TABLES `course_type` WRITE;
/*!40000 ALTER TABLE `course_type` DISABLE KEYS */;
INSERT INTO `course_type` VALUES ('1f5c6fe37b7219eaa763b109b77cf7fb','技术进阶',2),('8819e2590b2a66209271c7879f564458','项目实战',4),('9de0eac205fd4f2e2452c1182b2b473c','基础入门',1),('a2bf1fd80ce1bb32b1febe49e88af866','高级强化',3);
/*!40000 ALTER TABLE `course_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '商品登记时间（新增）',
  `product_sale_model` int(8) NOT NULL COMMENT '销售模式（1：现货销售；2：预售模式）--必填项',
  `product_name_value` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品智能显示名称',
  `product_standards_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品规格显示',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称--必填项',
  `product_sale_num` int(8) DEFAULT NULL COMMENT '销量',
  `product_type_id` int(8) NOT NULL COMMENT '商品分类ID-外键--必选项',
  `product_img_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片-URL地址（多张图逗号分开）-外键',
  `product_img_index_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '第一张图片URL（用于后台列表展现、前端列表、首页等地方）',
  `product_video_id` int(8) DEFAULT NULL COMMENT '商品视频-URL地址（单个视频）-外键',
  `product_sku` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品唯一编码（如：白色巧克力、黑色巧克力）',
  `product_spu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品编码-但不是唯一的（如：巧克力）',
  `product_sale_price` decimal(8,2) NOT NULL COMMENT '出售价格（单位：元）--必填项',
  `product_sale_unit_id` int(11) DEFAULT NULL COMMENT '商品单位（如：市场价：20元/公斤）',
  `product_cost_price` decimal(8,2) DEFAULT NULL COMMENT '成本价格（单位：元）',
  `product_market_price` decimal(8,2) DEFAULT NULL COMMENT '市场价格（用于对比）（单位：元）',
  `product_amount` int(8) DEFAULT NULL COMMENT '库存总数量（后台可更新【增加-减少】）',
  `product_standards` decimal(8,2) DEFAULT NULL COMMENT '规格',
  `product_amount_unit_id` int(8) DEFAULT NULL COMMENT '重量单位-外键',
  `product_copies` int(8) DEFAULT NULL COMMENT '份数',
  `product_volume` decimal(8,2) DEFAULT NULL COMMENT '体积',
  `product_volume_unit_id` int(8) DEFAULT NULL COMMENT '体积单位-外键',
  `product_sale_model2_num` int(8) DEFAULT NULL COMMENT '预售商品数量',
  `product_tag_id` int(8) DEFAULT NULL COMMENT '商品标签-外键',
  `product_state` int(8) DEFAULT NULL COMMENT '商品状态（1：上架、0：下架0，2：售完）【可通过时间控制：发布即上架、发布不上架、设置一个时间上架】',
  `product_information` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '商品详细描述信息',
  `product_view_num` int(11) DEFAULT NULL COMMENT '访问量',
  `product_view_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '访问来源【移动端、PC端(预留)】',
  `product_up_time` datetime DEFAULT NULL COMMENT '商品发布时间',
  `product_pn_value` tinyint(1) DEFAULT NULL COMMENT '是否启用智能标题',
  `product_gg_value` tinyint(1) DEFAULT NULL COMMENT '是否启用大约规格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (46,'2019-10-19 11:00:00',2,'苏泊尔（SUPOR）小容量高压锅迷你压力锅家 咖啡色 2.5L*12','2.5L*12','苏泊尔（SUPOR）小容量高压锅迷你压力锅家 咖啡色',0,8,'108,101','苏泊尔2.jpg',0,'','',278.00,22,230.00,399.00,0,2.50,0,12,0.00,0,0,1,0,'',0,'',NULL,1,0),(47,'2019-10-23 11:00:00',2,'樱桃 约500g*5','约500g*5','樱桃',0,1,'94,77','tj3.jpg',0,'','',88.00,21,60.00,128.00,0,500.00,0,5,0.00,0,0,1,0,'',0,'',NULL,1,1),(60,'2019-10-19 11:00:00',1,'原泽味 泰国进口龙眼水果 新鲜桂圆 1.5kg*12','1.5kg*12','原泽味 泰国进口龙眼水果 新鲜桂圆',0,1,'110,112,92','桂圆1.jpg',0,'','',49.90,20,30.00,80.00,0,1.50,0,12,0.00,0,0,3,0,'',0,'',NULL,1,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_attributes`
--

DROP TABLE IF EXISTS `product_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_attributes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品属性ID',
  `product_attributes_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品属性名称',
  `product_attributes_sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_attributes`
--

LOCK TABLES `product_attributes` WRITE;
/*!40000 ALTER TABLE `product_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_review`
--

DROP TABLE IF EXISTS `product_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `review_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `review_stars` int(11) DEFAULT NULL COMMENT '等级【1~5等级】',
  `review_img_id` int(11) DEFAULT NULL COMMENT '用户晒图ID',
  `review_vidoe_id` int(11) DEFAULT NULL COMMENT '用户晒短视频ID',
  `review_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来源（1移动端、PC端【预留】）',
  `review_perent_id` int(11) DEFAULT NULL COMMENT '父节点ID【追评使用】',
  `review_likes` int(11) DEFAULT NULL COMMENT '点赞数量',
  `review_reply` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '客服回复（后台回复）',
  `review_reply_time` datetime DEFAULT NULL COMMENT '客服回复时间',
  `review_state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_review`
--

LOCK TABLES `product_review` WRITE;
/*!40000 ALTER TABLE `product_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_table`
--

DROP TABLE IF EXISTS `product_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_table` (
  `product_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `product_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `num` int(11) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_table`
--

LOCK TABLES `product_table` WRITE;
/*!40000 ALTER TABLE `product_table` DISABLE KEYS */;
INSERT INTO `product_table` VALUES ('4001d341639e40b0aa40bc685d57c37c','榴莲',45,15.00),('7b635cc84bce7d35179a21259e0ae52e','葡萄',50,6.80),('a970e6817a3fb3f575a2caeef0658eb1','梨子',5800,6.00),('c5df33344a096427297262f6bfcf9dc3','柚子',6,6.00),('e399083c104bb7aeb0e2371a85275ee3','苹果',5,6.80),('e68bc88cfa5ae593d7f4bbee38a74735','香蕉',6,3.00);
/*!40000 ALTER TABLE `product_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_tag`
--

DROP TABLE IF EXISTS `product_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `product_tag_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品标签名称【如：爆款、最爱、超喜欢、女神节热销品、熬夜最佳搭档零食】',
  `product_tag_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_tag_sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tag`
--

LOCK TABLES `product_tag` WRITE;
/*!40000 ALTER TABLE `product_tag` DISABLE KEYS */;
INSERT INTO `product_tag` VALUES (1,'新品','primary',1),(2,'畅销','danger',2),(3,'特价','success',3),(4,'1元购','warning',4);
/*!40000 ALTER TABLE `product_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `product_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品分类名称',
  `product_type_perent_id` int(11) NOT NULL COMMENT '父节点ID（如果是顶级则是0）',
  `product_type_sort` int(11) DEFAULT NULL COMMENT '排序',
  `product_type_state` int(11) DEFAULT NULL COMMENT '状态（1：可用；0：不可用；）',
  `product_type_img_id` int(11) DEFAULT NULL COMMENT '分类图片【可以带图片】',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES (1,'新鲜水果',0,1,1,NULL),(2,'粮油散货',0,1,1,NULL),(3,'清洁洗护',0,2,1,NULL),(4,'酒水饮料',0,3,1,NULL),(5,'休闲零食',0,2,1,NULL),(6,'进口零食',0,1,1,NULL),(7,'牛奶乳品',0,2,1,NULL),(8,'家居日用',0,1,1,NULL),(9,'精品推荐',0,1,1,NULL),(29,'uuuuu ',0,5,1,0);
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_unit`
--

DROP TABLE IF EXISTS `product_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `unit_name_zh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文单位名称（如：千克）',
  `unit_name_en` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '英文单位名称（如：kg）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_unit`
--

LOCK TABLES `product_unit` WRITE;
/*!40000 ALTER TABLE `product_unit` DISABLE KEYS */;
INSERT INTO `product_unit` VALUES (1,'盒','dw'),(2,'件','dw'),(3,'袋','dw'),(4,'个','dw'),(20,'kg','gg'),(21,'g','gg'),(22,'L','gg'),(23,'ml','gg');
/*!40000 ALTER TABLE `product_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `type_id` int(8) DEFAULT NULL COMMENT '资源类型ID-外键',
  `resource_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源名称（URL地址）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `resource_size` decimal(12,2) DEFAULT NULL COMMENT '资源大小（单位MB：9.35MB)',
  `resource_state` int(8) DEFAULT NULL COMMENT '资源状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (78,NULL,'3.jpeg','2019-10-19 20:33:51',64542.00,1),(86,NULL,'HGFEW.jpeg','2019-10-24 16:11:39',46507.00,1),(92,NULL,'hh.jpeg','2019-10-24 16:11:40',105630.00,1),(93,NULL,'JJ.jpeg','2019-10-24 16:11:40',39670.00,1),(94,NULL,'tj3.jpg','2019-10-24 16:11:40',85107.00,1),(95,NULL,'tj2.jpg','2019-10-24 16:11:40',145113.00,1),(96,NULL,'yy.jpeg','2019-10-24 17:39:12',55454.00,1),(97,NULL,'U.jpeg','2019-10-24 17:55:51',30115.00,1),(98,NULL,'2.jpeg','2019-10-24 17:55:58',98629.00,1),(99,NULL,'风干牛肉200gl.jpeg','2019-10-24 21:57:41',135051.00,1),(100,NULL,'伊利48ml.jpeg','2019-10-24 22:02:43',224150.00,1),(101,NULL,'酒水-中国梦1.jpg','2019-10-24 22:09:47',187711.00,1),(102,NULL,'酒水-中国梦2.jpg','2019-10-24 22:09:47',392238.00,1),(103,NULL,'酒水-五粮液.jpg','2019-10-24 22:13:30',110358.00,1),(104,NULL,'休闲零食-多种混合1.jpg','2019-10-24 22:16:31',86443.00,1),(105,NULL,'金龙鱼.jpg','2019-10-24 22:23:41',47908.00,1),(106,NULL,'金龙鱼1.png','2019-10-24 22:23:46',47908.00,1),(107,NULL,'清洁-雅彩洁.jpg','2019-10-24 22:28:41',94008.00,1),(108,NULL,'苏泊尔2.jpg','2019-10-24 22:33:43',68609.00,1),(109,NULL,'苏泊尔1.jpg','2019-10-24 22:33:44',86770.00,1),(110,NULL,'桂圆1.jpg','2019-10-24 22:39:40',63724.00,1),(111,NULL,'桂圆2.jpg','2019-10-24 22:39:40',65624.00,1),(113,NULL,'农夫山泉.jpg','2019-10-24 22:42:50',64900.00,1),(114,NULL,'梨子.jpg','2019-10-24 23:28:50',100556.00,1),(115,NULL,'农夫山泉3333.jpg','2019-10-26 15:50:29',64900.00,1),(117,NULL,'UD.jpeg','2019-11-12 16:10:56',94049.00,1),(118,NULL,'zf.png','2019-11-12 16:27:26',1213.00,1),(119,NULL,'0.png','2020-03-16 17:43:24',440026.00,1),(121,NULL,'0.png','2020-03-16 17:47:24',440026.00,1),(122,NULL,'0.png','2020-03-16 17:48:11',440026.00,1),(123,NULL,'1.jpg','2020-03-29 19:16:06',122607.00,1),(124,NULL,'000000.png','2020-03-29 19:18:16',980298.00,1),(125,NULL,'封面.png','2020-03-29 19:33:14',280024.00,1),(126,NULL,'安全登录认证.png','2020-03-29 19:34:27',572711.00,1),(127,NULL,'9、表单组件数据校验规则钩子参数.png','2020-03-30 18:30:59',153039.00,1),(128,NULL,'3、用了组件,一个列表3分钟就可以出锅.png','2020-03-30 18:58:52',145695.00,1),(129,NULL,'2、用了组件就是牛,3分钟就可以做一个新增数据表单.png','2020-03-30 18:59:08',191147.00,1),(130,NULL,'8-表单组件的新增、修改通用方法开发和技巧处理.png','2020-03-30 18:59:08',43559.00,1),(131,NULL,'7、表单组件开发-组件模板和绑定模型.png','2020-03-30 18:59:08',151666.00,1),(132,NULL,'4、组件配置-修改、删除及其他事件.png','2020-03-30 18:59:09',105298.00,1),(133,NULL,'5、组件设计、扩展思路和复杂应用的配置方法.png','2020-03-30 18:59:31',219637.00,1),(134,NULL,'10、表单组件的其他参数、钩子参数、方法开发.png','2020-03-30 18:59:31',147127.00,1),(135,NULL,'项目管理关键阶段.png','2020-04-03 16:25:31',1031465.00,1),(136,NULL,'0-封面png.png','2020-04-05 15:49:28',442598.00,1),(137,NULL,'fm.jpg','2020-04-05 15:54:01',190681.00,1),(138,NULL,'代码生成工具EasyCode，大大提高开发效率.png','2020-04-05 15:59:35',110834.00,1),(139,NULL,'java基础知识.jpg','2020-04-08 19:40:32',102205.00,1),(140,NULL,'web架构.png','2020-04-08 19:47:18',141833.00,1),(141,NULL,'区块链01.png','2020-04-08 19:57:16',512518.00,1),(142,NULL,'区块链02.png','2020-04-08 20:06:03',193464.00,1),(143,NULL,'java基础001.png','2020-04-08 20:21:54',115195.00,1),(144,NULL,'1、组件的详细使用—第一版和第二版区别以及为什么要用组件开发.png','2020-04-08 20:22:55',130088.00,1),(145,NULL,'1845feb43ccba7104a94252510918c9ffb5d22b4.jpg','2020-04-14 13:36:16',657116.00,1);
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_type`
--

DROP TABLE IF EXISTS `resource_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源类型名称',
  `resource_type_sort` int(11) DEFAULT NULL COMMENT '排序',
  `resource_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源分类【1：图片，2：视频；3：压缩文件；4：其他】',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_type`
--

LOCK TABLES `resource_type` WRITE;
/*!40000 ALTER TABLE `resource_type` DISABLE KEYS */;
INSERT INTO `resource_type` VALUES (1,'',1,'未分类'),(2,'img',1,'商品图库'),(3,'img',2,'品牌LOGO'),(4,'img',3,'系统图标');
/*!40000 ALTER TABLE `resource_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_backend_api_table`
--

DROP TABLE IF EXISTS `sys_backend_api_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_backend_api_table` (
  `backend_api_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `backend_api_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'API名称',
  `backend_api_url` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'API请求地址',
  `backend_api_method` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'API请求方式：GET、POST、PUT、DELETE',
  `pid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父ID',
  `backend_api_sort` int(11) NOT NULL COMMENT '排序',
  `description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`backend_api_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_backend_api_table`
--

LOCK TABLES `sys_backend_api_table` WRITE;
/*!40000 ALTER TABLE `sys_backend_api_table` DISABLE KEYS */;
INSERT INTO `sys_backend_api_table` VALUES ('1','所有','/**','GET,POST,PUT,DELETE','',100,'admin特有'),('234dbd90c37363e2a6dea629adc7389e','编辑商品','/productTag','GET','4725d5b946c8789ebd2f758a93d416d8',204,''),('3c4593addf852016a49bab68b7539441','商品查询','/product/list','GET','4725d5b946c8789ebd2f758a93d416d8',201,NULL),('4725d5b946c8789ebd2f758a93d416d8','商品管理','none','',NULL,200,'商品管理下所有API'),('49bcd49553fd6274c5ea8b6fcc84097e','订单模块','none',NULL,NULL,300,'订单模块下的所有API'),('623c3f7156fb4a345f3c030f87d09aa9','菜单管理','/sysFrontendMenuTable','GET,POST,PUT,DELETE','ccb6659817cf193adc6bfb4dc17709ec',902,'前端菜单管理'),('73b81575b6737e4d38e6716bc773c5bb','订单查询','/order','GET','49bcd49553fd6274c5ea8b6fcc84097e',301,'订单查询'),('750be7ac660b8572993d540117b93758','商品单位','/productUnit','GET','4725d5b946c8789ebd2f758a93d416d8',205,NULL),('760ba9bf47fcda793203b1f3cd731083','删除商品','/productTable','DELETE','4725d5b946c8789ebd2f758a93d416d8',208,''),('8ba918894b2ed504e2a3db56b33327b4','订单处理','/order/?','GET','49bcd49553fd6274c5ea8b6fcc84097e',302,'单条查询'),('9e70d298027fc5a101f40b1cd38d3d41','前端菜单显示','/frontendMenu','GET','ccb6659817cf193adc6bfb4dc17709ec',901,'前端左侧菜单显示'),('adc60ab150c543223d9d454b1e9d43a6','商品销售模式','/productSaleModelEnum','GET','4725d5b946c8789ebd2f758a93d416d8',202,''),('ccb6659817cf193adc6bfb4dc17709ec','系统管理','none',NULL,NULL,900,NULL),('fa0c9a0b71a1d654f4ad2db4aac8e903','商品类型','/productType','GET','4725d5b946c8789ebd2f758a93d416d8',203,'');
/*!40000 ALTER TABLE `sys_backend_api_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_frontend_menu_table`
--

DROP TABLE IF EXISTS `sys_frontend_menu_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_frontend_menu_table` (
  `frontend_menu_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `frontend_menu_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '前端菜单名称',
  `frontend_menu_url` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '前端菜单访问HTML地址',
  `pid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父ID',
  `frontend_menu_sort` int(11) NOT NULL COMMENT '排序',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`frontend_menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_frontend_menu_table`
--

LOCK TABLES `sys_frontend_menu_table` WRITE;
/*!40000 ALTER TABLE `sys_frontend_menu_table` DISABLE KEYS */;
INSERT INTO `sys_frontend_menu_table` VALUES ('0af385f5e237445d369a49cb35b20da4','系统管理',NULL,NULL,900,NULL),('105eb6c65a907eb589dbd3a9eeea013a','商品管理',NULL,NULL,300,'商品管理'),('2e5739a73173a22ed55eca37bb67aae6','播放分析',NULL,'b65d3ad4906ffc8be6932f9a1f51df1d',601,NULL),('2e64af3e9417edb494a5b9ee39af3143','H5首页','h5.codingstudy.cn','895e5cbdc0b5e8b1083a81347d044f2a',1002,'H5首页'),('3daac351f94805e49fba4e82fa3d1ffa','Web首页','http://localhost:81','895e5cbdc0b5e8b1083a81347d044f2a',1001,'Web首页'),('40ca076892e16ef6f788eb4d753df964','用户管理','sys/user.html','0af385f5e237445d369a49cb35b20da4',901,NULL),('420af788562ba60c2a181acf204e145b','课程评论','./course/comment.html','434e4bd50799bd145f4590d0f4705162',207,'课程评论'),('434e4bd50799bd145f4590d0f4705162','课程管理','',NULL,200,NULL),('445f07c86a4e0a89767ca9dcea10c9e7','课程知识点','./course/knowledge.html','434e4bd50799bd145f4590d0f4705162',205,'课程知识点和知识点配置'),('737addccb1ac6307d29802ad988b13d8','课程管理','./course/course.html','434e4bd50799bd145f4590d0f4705162',201,'课程管理、章节管理'),('7f448ccf628eb577e20f6413c5810300','阅读分析',NULL,'b65d3ad4906ffc8be6932f9a1f51df1d',602,NULL),('80c23202f9d72076359518ef33854a4f','角色-菜单分配','sys/rolemenu.html','0af385f5e237445d369a49cb35b20da4',906,'角色-菜单分配'),('895e5cbdc0b5e8b1083a81347d044f2a','多端访问','',NULL,1000,'Web端首页'),('94025c8731dc0dc403b66f9e8899cbc7','商品查询','./product/list.html','105eb6c65a907eb589dbd3a9eeea013a',301,'商品查询'),('a3baa2f584b4032be78d38bd49b891c8','课程分类','./course/category.html','434e4bd50799bd145f4590d0f4705162',203,'课程分类'),('ab9fdc8116dab6c8d110aa4387c97e08','角色-API分配','sys/roleapi.html','0af385f5e237445d369a49cb35b20da4',907,'角色-API分配'),('b2dcfb940a72deb68b338b934128a1e4','图片查询','./resource/index.html','b3c72fd354b3df32ceb1dd7db0c61086',401,NULL),('b3c72fd354b3df32ceb1dd7db0c61086','资源管理',NULL,NULL,400,NULL),('b65d3ad4906ffc8be6932f9a1f51df1d','数据分析',NULL,NULL,600,NULL),('b973d15c229778a6d98e742d096b2e41','角色管理','sys/role.html','0af385f5e237445d369a49cb35b20da4',902,'角色管理页面'),('ba29ce1aa363a74cb10d96940ec0868a','课程适用人群','./course/for_people.html','434e4bd50799bd145f4590d0f4705162',206,NULL),('d271e480d26fd269d27ddb7f152d5fcd','课程类型','./course/type.html','434e4bd50799bd145f4590d0f4705162',204,NULL),('d2948d3e4a0914825f70aa39ce1c9d23','账号信息','sys/info.html','0af385f5e237445d369a49cb35b20da4',908,NULL),('e1fc2013f32ece3c772becb9489296e4','后端API管理','sys/api.html','0af385f5e237445d369a49cb35b20da4',904,'后端API管理页面'),('e529e97e6ab0f95fc85cfbda5247eeaa','前端菜单管理','sys/menu.html','0af385f5e237445d369a49cb35b20da4',903,NULL),('eb70ecd66ed156ca2f49e4d0e32b36f6','角色-用户分配','sys/roleuser.html','0af385f5e237445d369a49cb35b20da4',905,'角色用户分配');
/*!40000 ALTER TABLE `sys_frontend_menu_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_backend_api_table`
--

DROP TABLE IF EXISTS `sys_role_backend_api_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_backend_api_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `backend_api_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'API管理表ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_backend_api_table`
--

LOCK TABLES `sys_role_backend_api_table` WRITE;
/*!40000 ALTER TABLE `sys_role_backend_api_table` DISABLE KEYS */;
INSERT INTO `sys_role_backend_api_table` VALUES (10,'d04c2ebb1e32995f384ad49f6d4b421d','234dbd90c37363e2a6dea629adc7389e'),(11,'d04c2ebb1e32995f384ad49f6d4b421d','fa0c9a0b71a1d654f4ad2db4aac8e903'),(12,'d04c2ebb1e32995f384ad49f6d4b421d','4725d5b946c8789ebd2f758a93d416d8'),(13,'d04c2ebb1e32995f384ad49f6d4b421d','760ba9bf47fcda793203b1f3cd731083'),(14,'d04c2ebb1e32995f384ad49f6d4b421d','49bcd49553fd6274c5ea8b6fcc84097e'),(15,'d04c2ebb1e32995f384ad49f6d4b421d','adc60ab150c543223d9d454b1e9d43a6'),(16,'d04c2ebb1e32995f384ad49f6d4b421d','73b81575b6737e4d38e6716bc773c5bb'),(17,'d04c2ebb1e32995f384ad49f6d4b421d','8ba918894b2ed504e2a3db56b33327b4'),(18,'1','1'),(22,'2f412c59e5077e0cd53d21fac3eee402','8ba918894b2ed504e2a3db56b33327b4'),(23,'2f412c59e5077e0cd53d21fac3eee402','73b81575b6737e4d38e6716bc773c5bb'),(24,'2f412c59e5077e0cd53d21fac3eee402','49bcd49553fd6274c5ea8b6fcc84097e'),(25,'2f412c59e5077e0cd53d21fac3eee402','adc60ab150c543223d9d454b1e9d43a6');
/*!40000 ALTER TABLE `sys_role_backend_api_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_frontend_menu_table`
--

DROP TABLE IF EXISTS `sys_role_frontend_menu_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_frontend_menu_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `frontend_menu_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '前端菜单管理ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_frontend_menu_table`
--

LOCK TABLES `sys_role_frontend_menu_table` WRITE;
/*!40000 ALTER TABLE `sys_role_frontend_menu_table` DISABLE KEYS */;
INSERT INTO `sys_role_frontend_menu_table` VALUES (52,'1','*'),(53,'1','b2dcfb940a72deb68b338b934128a1e4'),(54,'1','c9fe45ef063af26c3e4c3208ffe1ff9f'),(55,'1','105eb6c65a907eb589dbd3a9eeea013a'),(56,'1','434e4bd50799bd145f4590d0f4705162'),(57,'1','e529e97e6ab0f95fc85cfbda5247eeaa'),(58,'1','e1fc2013f32ece3c772becb9489296e4'),(59,'1','737addccb1ac6307d29802ad988b13d8'),(60,'1','6423ae277e4ec862ff23bd7b2c0922ce'),(61,'1','b65d3ad4906ffc8be6932f9a1f51df1d'),(62,'1','d2948d3e4a0914825f70aa39ce1c9d23'),(63,'1','b3c72fd354b3df32ceb1dd7db0c61086'),(64,'1','eb70ecd66ed156ca2f49e4d0e32b36f6'),(65,'1','94025c8731dc0dc403b66f9e8899cbc7'),(66,'1','b973d15c229778a6d98e742d096b2e41'),(67,'1','7f448ccf628eb577e20f6413c5810300'),(68,'1','40ca076892e16ef6f788eb4d753df964'),(69,'1','0af385f5e237445d369a49cb35b20da4'),(70,'1','ab9fdc8116dab6c8d110aa4387c97e08'),(71,'1','76cb7b2df76c79d159c561ecfbd54ef2'),(72,'1','2e5739a73173a22ed55eca37bb67aae6'),(73,'1','a3baa2f584b4032be78d38bd49b891c8'),(74,'1','c7eb10d6513f40ac25f75e34a2679eab'),(75,'1','3a8846521659085ed6ce0b0187d6d72a'),(120,'d04c2ebb1e32995f384ad49f6d4b421d','b3c72fd354b3df32ceb1dd7db0c61086'),(121,'d04c2ebb1e32995f384ad49f6d4b421d','6423ae277e4ec862ff23bd7b2c0922ce'),(122,'d04c2ebb1e32995f384ad49f6d4b421d','c7eb10d6513f40ac25f75e34a2679eab'),(123,'d04c2ebb1e32995f384ad49f6d4b421d','105eb6c65a907eb589dbd3a9eeea013a'),(124,'d04c2ebb1e32995f384ad49f6d4b421d','b65d3ad4906ffc8be6932f9a1f51df1d'),(125,'d04c2ebb1e32995f384ad49f6d4b421d','2e5739a73173a22ed55eca37bb67aae6'),(126,'d04c2ebb1e32995f384ad49f6d4b421d','434e4bd50799bd145f4590d0f4705162'),(127,'d04c2ebb1e32995f384ad49f6d4b421d','94025c8731dc0dc403b66f9e8899cbc7'),(128,'d04c2ebb1e32995f384ad49f6d4b421d','7f448ccf628eb577e20f6413c5810300'),(129,'d04c2ebb1e32995f384ad49f6d4b421d','3a8846521659085ed6ce0b0187d6d72a'),(130,'d04c2ebb1e32995f384ad49f6d4b421d','b2dcfb940a72deb68b338b934128a1e4'),(131,'d04c2ebb1e32995f384ad49f6d4b421d','737addccb1ac6307d29802ad988b13d8'),(132,'d04c2ebb1e32995f384ad49f6d4b421d','a3baa2f584b4032be78d38bd49b891c8'),(133,'d04c2ebb1e32995f384ad49f6d4b421d','c9fe45ef063af26c3e4c3208ffe1ff9f'),(155,'ad6c8c05447aa8e6f941832d09b76559','737addccb1ac6307d29802ad988b13d8'),(156,'ad6c8c05447aa8e6f941832d09b76559','420af788562ba60c2a181acf204e145b'),(157,'ad6c8c05447aa8e6f941832d09b76559','d271e480d26fd269d27ddb7f152d5fcd'),(158,'ad6c8c05447aa8e6f941832d09b76559','434e4bd50799bd145f4590d0f4705162'),(159,'ad6c8c05447aa8e6f941832d09b76559','a3baa2f584b4032be78d38bd49b891c8'),(160,'ad6c8c05447aa8e6f941832d09b76559','ba29ce1aa363a74cb10d96940ec0868a'),(161,'ad6c8c05447aa8e6f941832d09b76559','445f07c86a4e0a89767ca9dcea10c9e7'),(162,'2f412c59e5077e0cd53d21fac3eee402','b3c72fd354b3df32ceb1dd7db0c61086'),(163,'2f412c59e5077e0cd53d21fac3eee402','94025c8731dc0dc403b66f9e8899cbc7'),(164,'2f412c59e5077e0cd53d21fac3eee402','b65d3ad4906ffc8be6932f9a1f51df1d'),(165,'2f412c59e5077e0cd53d21fac3eee402','105eb6c65a907eb589dbd3a9eeea013a'),(166,'2f412c59e5077e0cd53d21fac3eee402','434e4bd50799bd145f4590d0f4705162'),(167,'2f412c59e5077e0cd53d21fac3eee402','a3baa2f584b4032be78d38bd49b891c8'),(168,'2f412c59e5077e0cd53d21fac3eee402','d271e480d26fd269d27ddb7f152d5fcd'),(169,'2f412c59e5077e0cd53d21fac3eee402','737addccb1ac6307d29802ad988b13d8'),(170,'2f412c59e5077e0cd53d21fac3eee402','b2dcfb940a72deb68b338b934128a1e4'),(171,'2f412c59e5077e0cd53d21fac3eee402','7f448ccf628eb577e20f6413c5810300'),(172,'2f412c59e5077e0cd53d21fac3eee402','ba29ce1aa363a74cb10d96940ec0868a'),(173,'2f412c59e5077e0cd53d21fac3eee402','445f07c86a4e0a89767ca9dcea10c9e7'),(174,'2f412c59e5077e0cd53d21fac3eee402','2e5739a73173a22ed55eca37bb67aae6');
/*!40000 ALTER TABLE `sys_role_frontend_menu_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_table`
--

DROP TABLE IF EXISTS `sys_role_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_table` (
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE KEY `sys_role_table_pk` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_table`
--

LOCK TABLES `sys_role_table` WRITE;
/*!40000 ALTER TABLE `sys_role_table` DISABLE KEYS */;
INSERT INTO `sys_role_table` VALUES ('1','ROLE_ADMIN','超级管理员'),('2f412c59e5077e0cd53d21fac3eee402','ROLE_校长','校长'),('ad6c8c05447aa8e6f941832d09b76559','ROLE_SHOP_BUSINESS','主任');
/*!40000 ALTER TABLE `sys_role_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_user_table`
--

DROP TABLE IF EXISTS `sys_role_user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `user_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user_table`
--

LOCK TABLES `sys_role_user_table` WRITE;
/*!40000 ALTER TABLE `sys_role_user_table` DISABLE KEYS */;
INSERT INTO `sys_role_user_table` VALUES (43,'d04c2ebb1e32995f384ad49f6d4b421d','6268cbe21e573513a66799114d925e04'),(54,'1','bcad19f214499feab47f15b18ae9bc88'),(55,'2f412c59e5077e0cd53d21fac3eee402','c2ea699c481735cd2288dcedbc558d54'),(56,'ad6c8c05447aa8e6f941832d09b76559','6af8e3382c986033b0472a115db59e07');
/*!40000 ALTER TABLE `sys_role_user_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_table`
--

DROP TABLE IF EXISTS `sys_user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_table` (
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `user_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
  `pass_word` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码-BCR算法加密',
  `description` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_table`
--

LOCK TABLES `sys_user_table` WRITE;
/*!40000 ALTER TABLE `sys_user_table` DISABLE KEYS */;
INSERT INTO `sys_user_table` VALUES ('6af8e3382c986033b0472a115db59e07','test','$2a$10$xTcZJIFjAfjZsgsWRSU86OFZot.QDDf5tw0wW3/tjKQ8f3o4jAwlG','测试账号',1),('bcad19f214499feab47f15b18ae9bc88','admin','$2a$10$JtT9BKxQvhZWWDeqBrC0.e52hGjvF.eFpG4SQ1.BDYaGPb2sz2irK','超级管理员',1),('c2ea699c481735cd2288dcedbc558d54','ming206','$2a$10$tFHMAAfwOLNYBRQgtS9hxecp.ujnLgxKi9LDechuKo4NWghaVApxq',NULL,1);
/*!40000 ALTER TABLE `sys_user_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'niudao'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-17 17:27:27
