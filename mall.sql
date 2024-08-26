-- MySQL dump 10.13  Distrib 9.0.1, for macos14 (arm64)
--
-- Host: localhost    Database: mall
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `t_address`
--

DROP TABLE IF EXISTS `t_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_address` (
  `aid` int NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
  `uid` int DEFAULT NULL COMMENT '归属的用户id',
  `name` varchar(20) DEFAULT NULL COMMENT '收货人姓名',
  `area_name` varchar(15) DEFAULT NULL COMMENT '校区-名称',
  `address` varchar(50) DEFAULT NULL COMMENT '详细地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `is_default` int DEFAULT NULL COMMENT '是否默认：0-不默认，1-默认',
  `created_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_address`
--

LOCK TABLES `t_address` WRITE;
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT INTO `t_address` VALUES (1,9,'name6','area8','address0','13453969486',1,'creator1','2021-10-28 14:39:22','modifier3','2022-12-30 22:30:40'),(2,5,'name9','area2','address6','13453969486',0,'creator2','2022-05-01 07:15:07','modifier2','2023-02-12 10:16:28'),(3,5,'name3','area6','address0','13453969486',1,'creator3','2023-07-03 10:44:53','modifier3','2021-12-07 09:44:52'),(4,1,'name9','area7','address7','13453969486',0,'creator2','2023-03-10 22:48:24','modifier2','2022-03-08 17:49:46'),(5,10,'name2','area7','address7','13037248261',1,'creator0','2022-07-02 08:06:34','modifier1','2023-08-14 11:16:46'),(6,2,'name3','area7','address5','13037248261',1,'creator2','2022-09-30 22:53:38','modifier4','2022-11-07 00:31:40'),(7,9,'name0','area1','address0','13409641443',1,'creator3','2021-09-11 09:57:47','modifier1','2023-02-16 09:45:51'),(8,9,'name2','area7','address9','13436213702',0,'creator2','2022-08-27 00:23:28','modifier1','2021-09-27 10:44:42'),(9,1,'name3','area5','address3','13973088368',0,'creator2','2022-07-18 11:50:48','modifier2','2021-04-25 21:03:13'),(10,5,'name1','area4','address2','13229388137',1,'creator1','2022-12-27 10:31:55','modifier4','2021-08-26 11:32:44');
/*!40000 ALTER TABLE `t_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cart`
--

DROP TABLE IF EXISTS `t_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_cart` (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT '购物车数据id',
  `uid` int NOT NULL COMMENT '用户id',
  `pid` int NOT NULL COMMENT '商品id',
  `version` varchar(50) DEFAULT NULL COMMENT '版本选择',
  `num` int DEFAULT NULL COMMENT '商品数量',
  `created_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cart`
--

LOCK TABLES `t_cart` WRITE;
/*!40000 ALTER TABLE `t_cart` DISABLE KEYS */;
INSERT INTO `t_cart` VALUES (1,6,19,'XXL',8,'user_3','2022-04-18 23:42:08','user_1','2021-05-22 16:20:14'),(2,2,15,'XXL',5,'user_7','2022-09-10 04:16:43','user_3','2021-10-19 14:02:34'),(3,2,12,'XXL',5,'user_8','2023-07-02 00:47:32','user_7','2022-05-29 14:22:23'),(4,2,15,'XXL',4,'user_1','2022-01-10 19:21:17','user_1','2022-12-20 05:42:20'),(5,2,4,'XXL',3,'user_1','2022-09-29 00:17:24','user_2','2021-11-13 22:21:55'),(6,4,9,'XXL',5,'user_8','2021-04-26 01:23:28','user_10','2022-09-14 18:23:13'),(7,1,7,'XXL',7,'user_3','2021-02-16 03:27:17','user_3','2021-11-21 10:22:17'),(8,10,11,'XXL',10,'user_8','2022-06-28 20:08:38','user_6','2023-02-24 07:26:11'),(9,2,4,'XXL',4,'user_5','2023-04-29 04:00:37','user_7','2021-03-13 15:42:55'),(10,6,11,'XXL',2,'user_5','2021-03-28 18:54:54','user_6','2022-12-23 07:32:18'),(11,9,5,'M',3,'user_7','2022-04-24 02:11:10','user_5','2021-03-05 03:22:05'),(12,7,19,'M',3,'user_4','2022-06-25 14:52:26','user_7','2023-05-03 15:35:47'),(13,2,20,'M',1,'user_8','2021-11-23 14:40:23','user_7','2021-03-06 21:23:52'),(14,6,13,'M',9,'user_5','2023-03-27 12:39:28','user_8','2022-01-10 12:33:46'),(15,4,13,'M',9,'user_2','2023-01-01 14:14:17','user_5','2022-07-16 07:58:44'),(16,3,19,'M',4,'user_7','2022-03-22 08:46:29','user_5','2022-07-23 21:47:00'),(17,8,5,'M',4,'user_2','2022-10-19 13:37:33','user_3','2022-09-15 11:22:58'),(18,4,10,'M',5,'user_8','2023-01-07 06:45:54','user_1','2023-08-10 02:20:39'),(19,3,12,'M',2,'user_2','2021-10-01 07:23:49','user_6','2023-01-02 17:41:31'),(20,2,5,'M',4,'user_1','2022-06-26 08:58:42','user_10','2023-02-06 14:04:33'),(21,8,7,'M',3,'user_10','2021-03-30 05:40:08','user_3','2023-05-30 12:12:42'),(22,1,11,'M',10,'user_7','2023-04-09 16:31:28','user_1','2021-11-08 00:24:44'),(23,9,4,'M',2,'user_8','2021-08-07 21:02:27','user_10','2023-07-23 17:29:24'),(24,9,16,'M',3,'user_8','2021-06-01 19:08:58','user_2','2021-10-10 18:13:57'),(25,7,8,'M',6,'user_5','2022-11-01 18:32:17','user_5','2022-02-23 10:45:09'),(26,9,20,'M',8,'user_8','2021-06-10 06:03:53','user_9','2022-01-24 17:16:48'),(27,8,15,'M',2,'user_7','2023-03-15 10:44:44','user_1','2021-03-12 16:29:02'),(28,2,12,'M',6,'user_10','2021-02-07 12:03:56','user_6','2022-08-15 15:13:37'),(29,1,5,'M',10,'user_7','2022-06-14 18:33:23','user_1','2021-03-13 05:36:42'),(30,1,11,'M',5,'user_7','2022-02-06 16:16:55','user_4','2021-09-07 00:27:26'),(31,7,12,'M',10,'user_2','2022-08-09 19:12:27','user_10','2022-05-18 21:05:12'),(32,4,3,'M',9,'user_7','2021-10-02 23:43:44','user_10','2023-01-31 17:25:15'),(33,3,4,'M',10,'user_10','2022-11-03 02:02:30','user_10','2023-03-10 09:55:06'),(34,2,9,'M',4,'user_3','2023-07-15 17:37:06','user_9','2022-02-07 00:05:47'),(35,7,3,'M',3,'user_2','2021-07-21 14:51:57','user_7','2022-06-08 10:14:58'),(36,10,20,'M',10,'user_8','2021-02-17 10:38:22','user_7','2022-02-23 20:59:27'),(37,10,5,'XXL',8,'user_4','2021-07-10 15:30:58','user_10','2022-06-19 21:13:07'),(38,4,3,'XXL',6,'user_10','2021-09-30 22:14:10','user_1','2023-04-30 17:01:10'),(39,9,4,'XXL',2,'user_8','2022-08-15 21:23:25','user_1','2022-11-14 07:09:19'),(40,1,11,'XXL',9,'user_2','2023-04-20 08:47:03','user_7','2023-07-02 18:12:18'),(41,4,14,'XXL',5,'user_5','2021-04-26 02:02:06','user_3','2023-08-10 12:12:14'),(42,7,12,'XXL',4,'user_2','2021-02-21 21:50:43','user_2','2022-12-26 06:18:56'),(43,6,3,'XXL',4,'user_2','2022-01-20 20:55:55','user_1','2021-04-26 12:04:02'),(44,2,8,'XXL',10,'user_1','2023-05-11 04:19:31','user_2','2022-12-03 10:52:38'),(45,4,19,'XXL',10,'user_5','2021-10-19 15:02:00','user_4','2022-03-31 21:24:23'),(46,7,12,'XXL',10,'user_6','2021-10-26 12:30:01','user_8','2023-03-11 16:41:48'),(47,6,14,'XXL',5,'user_4','2023-04-02 03:32:02','user_10','2022-12-21 08:02:44'),(48,8,11,'XXL',10,'user_2','2022-07-13 20:02:44','user_2','2022-04-17 20:34:32'),(49,9,11,'XXL',10,'user_5','2023-01-06 13:35:38','user_6','2022-08-18 22:03:03'),(50,9,19,'XXL',5,'user_8','2021-06-30 02:37:02','user_1','2023-05-23 21:36:23');
/*!40000 ALTER TABLE `t_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_comment` (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `uid` int NOT NULL COMMENT '评价用户id',
  `pid` int NOT NULL COMMENT '被评价商品id',
  `rate` double NOT NULL COMMENT '评分',
  `content` varchar(1000) DEFAULT NULL COMMENT '评价内容',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (1,2,6,2.4,'This is a comment for product_82'),(2,7,5,2.9,'This is a comment for product_66'),(3,2,9,1.6,'This is a comment for product_100'),(4,9,11,3.5,'This is a comment for product_90'),(5,5,1,2.5,'This is a comment for product_55'),(6,1,5,4.6,'This is a comment for product_56'),(7,2,14,4.4,'This is a comment for product_49'),(8,5,4,4.2,'This is a comment for product_10'),(9,1,8,2.1,'This is a comment for product_78'),(10,2,12,3.3,'This is a comment for product_15'),(11,4,13,3.8,'This is a comment for product_85'),(12,1,3,4.9,'This is a comment for product_42'),(13,6,19,3.8,'This is a comment for product_75'),(14,2,16,1.5,'This is a comment for product_86'),(15,5,12,2.4,'This is a comment for product_4'),(16,1,14,1.6,'This is a comment for product_100'),(17,5,11,2.4,'This is a comment for product_9'),(18,2,6,2.1,'This is a comment for product_8'),(19,3,5,4.2,'This is a comment for product_9'),(20,8,16,2.4,'This is a comment for product_7'),(21,2,13,2.3,'This is a comment for product_59'),(22,1,4,1.9,'This is a comment for product_31'),(23,9,5,4.8,'This is a comment for product_29'),(24,4,7,1.3,'This is a comment for product_8'),(25,1,18,1.8,'This is a comment for product_25'),(26,2,6,4.1,'This is a comment for product_96'),(27,7,18,3.1,'This is a comment for product_34'),(28,6,2,4.2,'This is a comment for product_26'),(29,3,18,3.7,'This is a comment for product_48'),(30,3,12,4.1,'This is a comment for product_57'),(31,8,2,2.6,'This is a comment for product_33'),(32,7,6,1.2,'This is a comment for product_51'),(33,4,10,3.2,'This is a comment for product_79'),(34,5,10,3.5,'This is a comment for product_10'),(35,1,2,3.7,'This is a comment for product_89'),(36,2,2,1.5,'This is a comment for product_79'),(37,5,10,1.5,'This is a comment for product_82'),(38,6,8,3.5,'This is a comment for product_61'),(39,3,15,2.6,'This is a comment for product_69'),(40,8,1,4.2,'This is a comment for product_59'),(41,10,5,4.9,'This is a comment for product_54'),(42,6,3,3.8,'This is a comment for product_67'),(43,1,10,2.5,'This is a comment for product_93'),(44,7,1,2.3,'This is a comment for product_68'),(45,4,8,2.1,'This is a comment for product_7'),(46,2,7,1.1,'This is a comment for product_7'),(47,1,13,1.8,'This is a comment for product_94'),(48,3,10,2,'This is a comment for product_52'),(49,8,7,2.9,'This is a comment for product_3'),(50,5,18,2.2,'This is a comment for product_53'),(51,6,13,1.8,'This is a comment for product_38'),(52,1,14,3.8,'This is a comment for product_50'),(53,3,19,4.1,'This is a comment for product_75'),(54,9,12,4.1,'This is a comment for product_15'),(55,1,14,3,'This is a comment for product_61'),(56,7,3,2.9,'This is a comment for product_26'),(57,2,14,4.2,'This is a comment for product_58'),(58,1,7,4.9,'This is a comment for product_61'),(59,5,12,1.9,'This is a comment for product_48'),(60,3,1,3.8,'This is a comment for product_5'),(61,1,5,3.6,'This is a comment for product_21'),(62,7,5,2.9,'This is a comment for product_45'),(63,5,5,3.9,'This is a comment for product_9'),(64,10,5,4.8,'This is a comment for product_75'),(65,3,3,1.6,'This is a comment for product_37'),(66,3,6,2.1,'This is a comment for product_13'),(67,3,18,2.1,'This is a comment for product_29'),(68,3,20,1.8,'This is a comment for product_27'),(69,8,13,1.2,'This is a comment for product_36'),(70,6,9,4.8,'This is a comment for product_84'),(71,1,4,4.1,'This is a comment for product_31'),(72,9,7,1.5,'This is a comment for product_70'),(73,7,8,3.2,'This is a comment for product_42'),(74,1,16,2.3,'This is a comment for product_16'),(75,9,18,4.1,'This is a comment for product_65'),(76,2,8,3.7,'This is a comment for product_27'),(77,10,11,4.8,'This is a comment for product_18'),(78,2,5,4.1,'This is a comment for product_54'),(79,2,5,2.3,'This is a comment for product_45'),(80,5,10,1.6,'This is a comment for product_3'),(81,7,10,1.2,'This is a comment for product_89'),(82,3,14,2.4,'This is a comment for product_31'),(83,9,10,3.8,'This is a comment for product_98'),(84,9,9,3.3,'This is a comment for product_86'),(85,5,17,4.1,'This is a comment for product_40'),(86,6,16,3.8,'This is a comment for product_44'),(87,1,7,2.4,'This is a comment for product_26'),(88,6,16,3.7,'This is a comment for product_35'),(89,1,17,1.3,'This is a comment for product_48'),(90,7,15,2.5,'This is a comment for product_64'),(91,2,1,2.9,'This is a comment for product_40'),(92,6,13,4.4,'This is a comment for product_70'),(93,5,6,4.1,'This is a comment for product_19'),(94,7,2,3.4,'This is a comment for product_31'),(95,7,7,1.8,'This is a comment for product_83'),(96,5,6,3.8,'This is a comment for product_29'),(97,2,4,1.3,'This is a comment for product_72'),(98,6,5,2.5,'This is a comment for product_42'),(99,4,18,3.8,'This is a comment for product_46'),(100,1,7,2.2,'This is a comment for product_87');
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment_image`
--

DROP TABLE IF EXISTS `t_comment_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_comment_image` (
  `ciid` int NOT NULL AUTO_INCREMENT COMMENT '评论图片id',
  `uid` int NOT NULL COMMENT '评论用户id',
  `cid` int NOT NULL COMMENT '对应评论id',
  `image_src` varchar(1000) NOT NULL COMMENT '图片路径',
  PRIMARY KEY (`ciid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment_image`
--

LOCK TABLES `t_comment_image` WRITE;
/*!40000 ALTER TABLE `t_comment_image` DISABLE KEYS */;
INSERT INTO `t_comment_image` VALUES (1,1,18,'/images/comments/250.jpg'),(2,1,96,'/images/comments/84.jpg'),(3,8,70,'/images/comments/974.jpg'),(4,10,5,'/images/comments/916.jpg'),(5,6,80,'/images/comments/751.jpg'),(6,6,73,'/images/comments/105.jpg'),(7,7,35,'/images/comments/507.jpg'),(8,6,61,'/images/comments/784.jpg'),(9,10,31,'/images/comments/255.jpg'),(10,9,56,'/images/comments/377.jpg'),(11,10,30,'/images/comments/207.jpg'),(12,2,74,'/images/comments/821.jpg'),(13,10,71,'/images/comments/292.jpg'),(14,1,71,'/images/comments/788.jpg'),(15,7,59,'/images/comments/672.jpg'),(16,7,67,'/images/comments/412.jpg'),(17,8,80,'/images/comments/751.jpg'),(18,3,91,'/images/comments/669.jpg'),(19,6,32,'/images/comments/290.jpg'),(20,10,7,'/images/comments/303.jpg'),(21,6,91,'/images/comments/159.jpg'),(22,7,1,'/images/comments/164.jpg'),(23,10,63,'/images/comments/5.jpg'),(24,10,55,'/images/comments/63.jpg'),(25,1,18,'/images/comments/798.jpg'),(26,2,18,'/images/comments/475.jpg'),(27,2,41,'/images/comments/317.jpg'),(28,5,6,'/images/comments/401.jpg'),(29,5,78,'/images/comments/468.jpg'),(30,5,23,'/images/comments/993.jpg'),(31,4,25,'/images/comments/967.jpg'),(32,1,35,'/images/comments/217.jpg'),(33,6,31,'/images/comments/207.jpg'),(34,5,16,'/images/comments/485.jpg'),(35,1,67,'/images/comments/361.jpg'),(36,5,71,'/images/comments/949.jpg'),(37,8,91,'/images/comments/451.jpg'),(38,6,32,'/images/comments/855.jpg'),(39,1,63,'/images/comments/287.jpg'),(40,10,5,'/images/comments/86.jpg'),(41,3,64,'/images/comments/710.jpg'),(42,6,71,'/images/comments/98.jpg'),(43,9,100,'/images/comments/648.jpg'),(44,5,6,'/images/comments/239.jpg'),(45,1,57,'/images/comments/513.jpg'),(46,4,80,'/images/comments/692.jpg'),(47,3,58,'/images/comments/332.jpg'),(48,6,54,'/images/comments/370.jpg'),(49,6,62,'/images/comments/503.jpg'),(50,9,76,'/images/comments/698.jpg'),(51,7,80,'/images/comments/868.jpg'),(52,4,5,'/images/comments/931.jpg'),(53,9,76,'/images/comments/609.jpg'),(54,2,80,'/images/comments/769.jpg'),(55,8,28,'/images/comments/831.jpg'),(56,7,57,'/images/comments/458.jpg'),(57,10,45,'/images/comments/509.jpg'),(58,8,63,'/images/comments/727.jpg'),(59,6,1,'/images/comments/67.jpg'),(60,5,30,'/images/comments/883.jpg'),(61,3,58,'/images/comments/100.jpg'),(62,3,82,'/images/comments/949.jpg'),(63,8,65,'/images/comments/516.jpg'),(64,2,74,'/images/comments/613.jpg'),(65,7,5,'/images/comments/46.jpg'),(66,7,96,'/images/comments/170.jpg'),(67,10,31,'/images/comments/749.jpg'),(68,8,73,'/images/comments/785.jpg'),(69,5,94,'/images/comments/890.jpg'),(70,7,63,'/images/comments/838.jpg'),(71,1,28,'/images/comments/465.jpg'),(72,6,86,'/images/comments/155.jpg'),(73,6,65,'/images/comments/179.jpg'),(74,4,80,'/images/comments/476.jpg'),(75,10,94,'/images/comments/688.jpg'),(76,3,9,'/images/comments/7.jpg'),(77,6,71,'/images/comments/502.jpg'),(78,6,65,'/images/comments/812.jpg'),(79,7,31,'/images/comments/662.jpg'),(80,7,70,'/images/comments/198.jpg'),(81,10,67,'/images/comments/527.jpg'),(82,3,71,'/images/comments/307.jpg'),(83,6,80,'/images/comments/746.jpg'),(84,5,62,'/images/comments/731.jpg'),(85,5,12,'/images/comments/123.jpg'),(86,3,75,'/images/comments/230.jpg'),(87,2,62,'/images/comments/956.jpg'),(88,8,63,'/images/comments/957.jpg'),(89,8,64,'/images/comments/445.jpg'),(90,8,84,'/images/comments/903.jpg'),(91,3,16,'/images/comments/552.jpg'),(92,4,46,'/images/comments/283.jpg'),(93,7,41,'/images/comments/110.jpg'),(94,5,11,'/images/comments/601.jpg'),(95,3,64,'/images/comments/264.jpg'),(96,6,56,'/images/comments/243.jpg'),(97,5,6,'/images/comments/507.jpg'),(98,6,14,'/images/comments/957.jpg'),(99,4,23,'/images/comments/633.jpg'),(100,7,35,'/images/comments/626.jpg');
/*!40000 ALTER TABLE `t_comment_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_favorite_product`
--

DROP TABLE IF EXISTS `t_favorite_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_favorite_product` (
  `fpid` int NOT NULL AUTO_INCREMENT COMMENT '收藏商品数据id',
  `uid` int NOT NULL COMMENT '用户id',
  `pid` int NOT NULL COMMENT '商品id',
  `created_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`fpid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_favorite_product`
--

LOCK TABLES `t_favorite_product` WRITE;
/*!40000 ALTER TABLE `t_favorite_product` DISABLE KEYS */;
INSERT INTO `t_favorite_product` VALUES (1,10,12,'user_2','2021-12-12 13:52:01','user_4','2022-12-15 06:49:32'),(2,9,18,'user_2','2022-01-08 15:00:24','user_8','2021-10-31 22:04:10'),(3,10,10,'user_2','2021-05-31 09:47:06','user_7','2021-01-23 07:40:07'),(4,9,16,'user_2','2021-11-11 08:05:36','user_9','2021-02-18 08:52:54'),(5,1,10,'user_2','2021-03-06 13:08:43','user_8','2021-07-02 05:49:46'),(6,10,9,'user_7','2021-12-26 14:14:42','user_10','2021-04-15 07:53:18'),(7,3,10,'user_8','2022-05-24 04:29:39','user_1','2022-12-11 00:49:27'),(8,4,10,'user_2','2022-10-20 14:48:21','user_2','2021-06-10 19:03:18'),(9,6,11,'user_4','2021-08-16 07:44:26','user_2','2022-10-02 02:09:32'),(10,10,5,'user_9','2021-01-19 04:49:19','user_1','2022-01-03 09:32:29'),(11,2,14,'user_2','2022-12-19 19:14:48','user_2','2022-01-02 00:03:44'),(12,6,20,'user_9','2021-12-24 06:19:05','user_4','2022-01-26 23:19:50'),(13,4,7,'user_5','2021-12-21 15:31:10','user_2','2021-05-03 14:16:33'),(14,1,12,'user_1','2022-10-13 18:24:58','user_4','2022-01-19 07:32:35'),(15,5,9,'user_4','2022-06-21 14:12:12','user_10','2022-09-13 23:29:46'),(16,9,18,'user_9','2021-02-10 10:13:46','user_4','2022-10-13 21:23:14'),(17,3,8,'user_1','2021-01-21 08:38:12','user_7','2021-03-14 11:38:00'),(18,6,8,'user_1','2021-06-14 13:21:25','user_5','2022-02-03 03:36:57'),(19,5,3,'user_9','2022-08-21 08:08:44','user_4','2021-09-05 08:46:20'),(20,6,14,'user_4','2021-01-06 03:36:20','user_7','2021-09-16 04:10:05'),(21,5,17,'user_6','2022-05-30 03:25:42','user_10','2022-12-12 14:36:25'),(22,8,11,'user_1','2021-06-13 07:24:28','user_9','2022-09-19 16:28:48'),(23,5,12,'user_4','2021-04-23 16:05:54','user_6','2022-05-08 01:38:44'),(24,7,8,'user_8','2021-02-11 04:43:10','user_7','2021-01-25 22:41:23'),(25,10,8,'user_6','2022-01-31 06:03:38','user_1','2022-05-30 16:37:02'),(26,2,15,'user_5','2021-05-11 18:14:20','user_6','2022-04-27 13:08:43'),(27,4,5,'user_4','2021-11-09 15:58:45','user_10','2022-07-12 11:58:52'),(28,4,16,'user_2','2022-04-16 05:33:04','user_6','2021-06-18 03:10:54'),(29,3,6,'user_9','2021-03-21 22:45:19','user_8','2021-01-03 12:56:46'),(30,5,7,'user_2','2022-05-31 09:10:46','user_1','2022-03-05 19:50:50'),(31,3,12,'user_3','2022-11-01 08:00:02','user_6','2021-11-03 06:14:59'),(32,3,10,'user_2','2021-11-02 14:14:50','user_7','2021-02-15 03:43:05'),(33,9,10,'user_7','2022-06-14 04:21:55','user_9','2021-07-16 07:15:14'),(34,7,9,'user_6','2022-05-17 07:24:20','user_4','2021-04-07 05:07:48'),(35,10,8,'user_2','2021-09-28 08:27:39','user_10','2022-02-23 18:00:05'),(36,9,8,'user_9','2021-10-01 14:49:42','user_8','2022-04-10 04:44:51'),(37,1,8,'user_4','2021-01-03 20:41:12','user_9','2022-05-31 20:47:09'),(38,2,5,'user_4','2022-05-17 16:41:42','user_10','2022-03-09 16:44:33'),(39,6,16,'user_9','2022-09-03 02:31:15','user_7','2021-08-15 01:06:13'),(40,4,14,'user_9','2022-07-21 00:06:48','user_6','2022-04-02 00:00:21'),(41,4,8,'user_9','2022-09-09 00:28:00','user_7','2022-12-18 07:48:41'),(42,4,8,'user_2','2021-11-29 16:13:47','user_6','2021-03-18 21:45:39'),(43,10,20,'user_5','2022-09-07 11:00:31','user_8','2022-08-27 22:40:44'),(44,1,1,'user_4','2021-10-08 02:51:26','user_7','2021-05-29 09:59:05'),(45,3,20,'user_1','2021-05-19 07:19:00','user_6','2022-02-04 02:24:25'),(46,6,3,'user_1','2022-10-15 14:41:29','user_3','2022-07-09 02:47:02'),(47,7,5,'user_1','2022-01-10 08:16:22','user_4','2021-12-05 10:52:27'),(48,3,16,'user_1','2021-09-03 03:19:18','user_9','2022-06-17 19:49:39'),(49,6,11,'user_5','2021-02-09 11:51:42','user_10','2022-08-14 05:55:27'),(50,2,12,'user_7','2022-07-22 04:09:22','user_7','2021-12-23 06:03:26');
/*!40000 ALTER TABLE `t_favorite_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_favorite_shop`
--

DROP TABLE IF EXISTS `t_favorite_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_favorite_shop` (
  `fsid` int NOT NULL AUTO_INCREMENT COMMENT '收藏店铺数据id',
  `uid` int NOT NULL COMMENT '用户id',
  `sid` int NOT NULL COMMENT '商店id',
  `created_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`fsid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_favorite_shop`
--

LOCK TABLES `t_favorite_shop` WRITE;
/*!40000 ALTER TABLE `t_favorite_shop` DISABLE KEYS */;
INSERT INTO `t_favorite_shop` VALUES (1,2,13,'user_1','2021-05-29 17:45:19','user_6','2021-01-26 17:42:15'),(2,5,7,'user_10','2022-12-31 22:46:02','user_8','2022-05-12 08:06:35'),(3,8,13,'user_5','2022-08-21 15:55:31','user_7','2021-03-01 15:55:42'),(4,8,13,'user_4','2021-01-19 14:54:50','user_1','2021-02-21 14:57:29'),(5,7,20,'user_3','2021-03-02 04:49:37','user_7','2022-07-25 13:34:11'),(6,8,10,'user_2','2021-10-03 21:20:33','user_3','2022-01-01 12:30:51'),(7,4,7,'user_4','2021-11-01 06:38:05','user_2','2022-01-20 03:09:47'),(8,8,7,'user_4','2021-06-10 13:43:51','user_10','2022-08-12 07:37:53'),(9,8,18,'user_5','2022-10-24 06:30:34','user_8','2021-12-12 14:29:29'),(10,4,16,'user_5','2021-07-14 21:44:13','user_7','2021-11-23 13:45:30'),(11,2,7,'user_4','2021-07-07 03:49:25','user_8','2022-01-08 21:50:20'),(12,9,18,'user_7','2022-03-19 03:14:01','user_7','2021-07-15 12:13:57'),(13,4,10,'user_10','2022-12-09 22:52:55','user_5','2021-12-24 04:05:14'),(14,2,17,'user_2','2022-08-13 22:53:04','user_9','2021-02-26 11:15:39'),(15,4,16,'user_9','2022-05-23 23:37:23','user_2','2021-06-05 15:47:28'),(16,8,7,'user_5','2022-09-27 01:39:12','user_1','2022-02-13 01:33:34'),(17,5,11,'user_10','2021-01-01 19:41:31','user_6','2022-04-11 19:39:53'),(18,9,13,'user_4','2021-05-18 21:53:56','user_5','2021-01-10 08:59:42'),(19,9,17,'user_2','2021-07-08 18:41:22','user_2','2022-04-15 05:39:43'),(20,2,10,'user_5','2021-02-22 21:25:38','user_1','2022-02-18 07:29:14');
/*!40000 ALTER TABLE `t_favorite_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_image`
--

DROP TABLE IF EXISTS `t_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_image` (
  `iid` int NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `pid` int NOT NULL COMMENT '对应商品id',
  `image_src` varchar(1000) NOT NULL COMMENT '图片内容',
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_image`
--

LOCK TABLES `t_image` WRITE;
/*!40000 ALTER TABLE `t_image` DISABLE KEYS */;
INSERT INTO `t_image` VALUES (1,4,'http://example.com/images/product_4/image_5.jpg'),(2,12,'http://example.com/images/product_12/image_3.jpg'),(3,14,'http://example.com/images/product_14/image_3.jpg'),(4,20,'http://example.com/images/product_20/image_1.jpg'),(5,12,'http://example.com/images/product_12/image_5.jpg'),(6,8,'http://example.com/images/product_8/image_1.jpg'),(7,10,'http://example.com/images/product_10/image_5.jpg'),(8,6,'http://example.com/images/product_6/image_3.jpg'),(9,8,'http://example.com/images/product_8/image_5.jpg'),(10,2,'http://example.com/images/product_2/image_1.jpg'),(11,7,'http://example.com/images/product_7/image_3.jpg'),(12,13,'http://example.com/images/product_13/image_2.jpg'),(13,8,'http://example.com/images/product_8/image_2.jpg'),(14,10,'http://example.com/images/product_10/image_3.jpg'),(15,14,'http://example.com/images/product_14/image_5.jpg'),(16,16,'http://example.com/images/product_16/image_3.jpg'),(17,16,'http://example.com/images/product_16/image_2.jpg'),(18,8,'http://example.com/images/product_8/image_2.jpg'),(19,2,'http://example.com/images/product_2/image_2.jpg'),(20,11,'http://example.com/images/product_11/image_2.jpg'),(21,4,'http://example.com/images/product_4/image_2.jpg'),(22,7,'http://example.com/images/product_7/image_3.jpg'),(23,11,'http://example.com/images/product_11/image_2.jpg'),(24,2,'http://example.com/images/product_2/image_2.jpg'),(25,1,'http://example.com/images/product_1/image_3.jpg'),(26,3,'http://example.com/images/product_3/image_2.jpg'),(27,17,'http://example.com/images/product_17/image_5.jpg'),(28,12,'http://example.com/images/product_12/image_4.jpg'),(29,16,'http://example.com/images/product_16/image_3.jpg'),(30,10,'http://example.com/images/product_10/image_5.jpg'),(31,6,'http://example.com/images/product_6/image_5.jpg'),(32,6,'http://example.com/images/product_6/image_4.jpg'),(33,14,'http://example.com/images/product_14/image_5.jpg'),(34,5,'http://example.com/images/product_5/image_1.jpg'),(35,12,'http://example.com/images/product_12/image_3.jpg'),(36,8,'http://example.com/images/product_8/image_3.jpg'),(37,8,'http://example.com/images/product_8/image_5.jpg'),(38,17,'http://example.com/images/product_17/image_2.jpg'),(39,10,'http://example.com/images/product_10/image_1.jpg'),(40,16,'http://example.com/images/product_16/image_2.jpg'),(41,12,'http://example.com/images/product_12/image_1.jpg'),(42,7,'http://example.com/images/product_7/image_5.jpg'),(43,12,'http://example.com/images/product_12/image_1.jpg'),(44,4,'http://example.com/images/product_4/image_4.jpg'),(45,1,'http://example.com/images/product_1/image_4.jpg'),(46,8,'http://example.com/images/product_8/image_1.jpg'),(47,14,'http://example.com/images/product_14/image_4.jpg'),(48,4,'http://example.com/images/product_4/image_3.jpg'),(49,5,'http://example.com/images/product_5/image_2.jpg'),(50,4,'http://example.com/images/product_4/image_5.jpg'),(51,12,'http://example.com/images/product_12/image_5.jpg'),(52,2,'http://example.com/images/product_2/image_1.jpg'),(53,17,'http://example.com/images/product_17/image_3.jpg'),(54,10,'http://example.com/images/product_10/image_4.jpg'),(55,10,'http://example.com/images/product_10/image_5.jpg'),(56,4,'http://example.com/images/product_4/image_1.jpg'),(57,12,'http://example.com/images/product_12/image_4.jpg'),(58,12,'http://example.com/images/product_12/image_3.jpg'),(59,10,'http://example.com/images/product_10/image_3.jpg'),(60,14,'http://example.com/images/product_14/image_1.jpg'),(61,17,'http://example.com/images/product_17/image_3.jpg'),(62,4,'http://example.com/images/product_4/image_1.jpg'),(63,13,'http://example.com/images/product_13/image_1.jpg'),(64,4,'http://example.com/images/product_4/image_5.jpg'),(65,6,'http://example.com/images/product_6/image_1.jpg'),(66,9,'http://example.com/images/product_9/image_1.jpg'),(67,16,'http://example.com/images/product_16/image_5.jpg'),(68,5,'http://example.com/images/product_5/image_4.jpg'),(69,12,'http://example.com/images/product_12/image_3.jpg'),(70,9,'http://example.com/images/product_9/image_1.jpg'),(71,9,'http://example.com/images/product_9/image_5.jpg'),(72,9,'http://example.com/images/product_9/image_3.jpg'),(73,1,'http://example.com/images/product_1/image_3.jpg'),(74,15,'http://example.com/images/product_15/image_3.jpg'),(75,6,'http://example.com/images/product_6/image_1.jpg'),(76,10,'http://example.com/images/product_10/image_5.jpg'),(77,8,'http://example.com/images/product_8/image_1.jpg'),(78,13,'http://example.com/images/product_13/image_2.jpg'),(79,6,'http://example.com/images/product_6/image_1.jpg'),(80,14,'http://example.com/images/product_14/image_4.jpg'),(81,20,'http://example.com/images/product_20/image_5.jpg'),(82,6,'http://example.com/images/product_6/image_2.jpg'),(83,10,'http://example.com/images/product_10/image_4.jpg'),(84,17,'http://example.com/images/product_17/image_5.jpg'),(85,10,'http://example.com/images/product_10/image_5.jpg'),(86,9,'http://example.com/images/product_9/image_1.jpg'),(87,7,'http://example.com/images/product_7/image_2.jpg'),(88,19,'http://example.com/images/product_19/image_3.jpg'),(89,16,'http://example.com/images/product_16/image_3.jpg'),(90,10,'http://example.com/images/product_10/image_4.jpg'),(91,6,'http://example.com/images/product_6/image_1.jpg'),(92,11,'http://example.com/images/product_11/image_5.jpg'),(93,5,'http://example.com/images/product_5/image_1.jpg'),(94,6,'http://example.com/images/product_6/image_2.jpg'),(95,3,'http://example.com/images/product_3/image_3.jpg'),(96,19,'http://example.com/images/product_19/image_3.jpg'),(97,12,'http://example.com/images/product_12/image_1.jpg'),(98,10,'http://example.com/images/product_10/image_5.jpg'),(99,19,'http://example.com/images/product_19/image_3.jpg'),(100,13,'http://example.com/images/product_13/image_3.jpg');
/*!40000 ALTER TABLE `t_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order` (
  `oid` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `uid` int NOT NULL COMMENT '用户id',
  `aid` int NOT NULL COMMENT '对应收获地址id',
  `version` varchar(50) DEFAULT NULL COMMENT '版本选择',
  `quantity` int DEFAULT NULL COMMENT '购买数量',
  `total_price` bigint DEFAULT NULL COMMENT '总价',
  `status` int DEFAULT NULL COMMENT '状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `created_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,9,7,'S',5,20191,3,'2022-09-28 00:42:27','2022-12-16 00:44:16','user_1','2022-09-28 00:42:27','user_5','2022-12-16 00:44:16'),(2,9,8,'S',5,16823,0,'2021-08-29 06:32:20','2022-09-24 23:55:05','user_10','2021-08-29 06:32:20','user_5','2022-09-24 23:55:05'),(3,5,10,'S',5,73990,4,'2022-12-24 22:04:16','2022-12-25 00:12:45','user_7','2022-12-24 22:04:16','user_3','2022-12-25 00:12:45'),(4,10,5,'S',5,86861,3,'2021-08-23 06:35:40','2022-08-30 02:01:19','user_9','2021-08-23 06:35:40','user_4','2022-08-30 02:01:19'),(5,10,5,'S',5,96149,2,'2021-08-30 03:33:16','2021-10-15 01:55:13','user_9','2021-08-30 03:33:16','user_5','2021-10-15 01:55:13'),(6,9,8,'S',5,88067,4,'2021-05-01 04:29:44','2022-10-29 08:51:59','user_8','2021-05-01 04:29:44','user_10','2022-10-29 08:51:59'),(7,5,2,'S',5,84725,0,'2022-07-01 19:50:05','2022-11-02 03:29:13','user_10','2022-07-01 19:50:05','user_8','2022-11-02 03:29:13'),(8,9,7,'S',5,68929,3,'2022-10-02 16:37:46','2022-11-27 00:21:37','user_9','2022-10-02 16:37:46','user_5','2022-11-27 00:21:37'),(9,2,6,'S',5,29849,3,'2022-09-08 05:21:16','2022-09-28 12:18:53','user_3','2022-09-08 05:21:16','user_3','2022-09-28 12:18:53'),(10,5,10,'S',5,96562,3,'2022-05-13 16:55:38','2022-12-06 15:51:57','user_10','2022-05-13 16:55:38','user_3','2022-12-06 15:51:57'),(11,1,9,'S',5,74104,0,'2022-03-11 15:33:02','2022-05-04 20:42:06','user_7','2022-03-11 15:33:02','user_7','2022-05-04 20:42:06'),(12,5,3,'S',5,3580,4,'2022-08-31 20:24:06','2022-09-14 05:07:13','user_4','2022-08-31 20:24:06','user_9','2022-09-14 05:07:13'),(13,9,7,'M',5,40762,1,'2021-12-23 15:22:14','2022-01-06 14:45:23','user_10','2021-12-23 15:22:14','user_5','2022-01-06 14:45:23'),(14,5,3,'M',5,12818,4,'2021-07-25 10:57:21','2022-12-20 11:15:55','user_7','2021-07-25 10:57:21','user_10','2022-12-20 11:15:55'),(15,9,8,'M',5,22114,3,'2021-06-13 18:05:45','2022-06-01 10:15:57','user_1','2021-06-13 18:05:45','user_10','2022-06-01 10:15:57'),(16,2,6,'M',5,78761,4,'2021-11-03 16:06:54','2022-02-20 20:12:02','user_9','2021-11-03 16:06:54','user_3','2022-02-20 20:12:02'),(17,5,10,'M',5,40124,3,'2022-12-26 14:05:33','2022-12-27 19:10:29','user_10','2022-12-26 14:05:33','user_2','2022-12-27 19:10:29'),(18,1,4,'M',5,56303,3,'2022-04-02 14:49:59','2022-11-11 05:01:22','user_5','2022-04-02 14:49:59','user_3','2022-11-11 05:01:22'),(19,5,10,'M',5,38203,3,'2021-02-04 12:30:48','2021-02-26 15:40:26','user_4','2021-02-04 12:30:48','user_3','2021-02-26 15:40:26'),(20,5,10,'M',5,56037,2,'2022-08-08 23:02:07','2022-09-17 04:18:43','user_4','2022-08-08 23:02:07','user_9','2022-09-17 04:18:43'),(21,1,9,'M',5,59120,2,'2021-01-13 03:08:58','2022-11-30 06:38:34','user_7','2021-01-13 03:08:58','user_3','2022-11-30 06:38:34'),(22,5,2,'M',5,99460,0,'2021-06-06 16:22:26','2021-10-20 20:05:04','user_4','2021-06-06 16:22:26','user_4','2021-10-20 20:05:04'),(23,5,3,'M',5,53822,3,'2021-12-24 13:04:54','2022-10-03 18:56:09','user_7','2021-12-24 13:04:54','user_10','2022-10-03 18:56:09'),(24,5,10,'L',5,26443,4,'2022-01-29 01:27:48','2022-10-08 11:56:36','user_4','2022-01-29 01:27:48','user_2','2022-10-08 11:56:36'),(25,5,3,'L',5,66946,2,'2022-05-07 04:17:34','2022-07-22 10:38:29','user_4','2022-05-07 04:17:34','user_9','2022-07-22 10:38:29'),(26,9,8,'L',5,7994,0,'2021-07-08 21:08:39','2021-12-27 10:39:01','user_9','2021-07-08 21:08:39','user_9','2021-12-27 10:39:01'),(27,10,5,'L',5,80107,2,'2021-02-12 18:04:05','2021-07-29 01:54:44','user_9','2021-02-12 18:04:05','user_10','2021-07-29 01:54:44'),(28,9,1,'L',5,8114,3,'2022-08-28 10:20:37','2022-09-10 12:17:13','user_1','2022-08-28 10:20:37','user_10','2022-09-10 12:17:13'),(29,2,6,'L',5,48067,4,'2021-12-16 00:45:41','2022-12-18 12:18:20','user_8','2021-12-16 00:45:41','user_10','2022-12-18 12:18:20'),(30,10,5,'L',5,77968,3,'2022-12-07 13:20:08','2022-12-23 04:33:39','user_9','2022-12-07 13:20:08','user_6','2022-12-23 04:33:39');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_item`
--

DROP TABLE IF EXISTS `t_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_item` (
  `oiid` int NOT NULL AUTO_INCREMENT COMMENT '订单条目id',
  `oid` int NOT NULL COMMENT '所属订单id',
  `pid` int NOT NULL COMMENT '订单条目包含的商品id',
  `version` varchar(50) DEFAULT NULL COMMENT '版本选择',
  `created_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`oiid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_item`
--

LOCK TABLES `t_order_item` WRITE;
/*!40000 ALTER TABLE `t_order_item` DISABLE KEYS */;
INSERT INTO `t_order_item` VALUES (1,19,1,NULL,'user_3','2022-07-27 11:38:44','user_7','2022-12-08 17:35:59'),(2,12,13,NULL,'user_10','2022-06-04 17:26:19','user_2','2022-12-05 10:14:36'),(3,22,1,NULL,'user_1','2022-06-17 20:27:06','user_5','2022-10-30 22:56:48'),(4,13,11,NULL,'user_5','2022-04-17 19:30:01','user_9','2022-05-19 17:44:20'),(5,14,4,NULL,'user_9','2022-03-28 14:40:20','user_1','2022-11-11 14:08:49'),(6,27,19,NULL,'user_10','2022-12-27 06:34:52','user_7','2022-12-28 03:53:01'),(7,15,15,NULL,'user_6','2022-07-04 00:10:47','user_5','2022-11-25 11:23:55'),(8,6,20,NULL,'user_1','2022-11-17 21:36:37','user_2','2022-12-16 15:25:27'),(9,22,20,NULL,'user_2','2022-03-07 23:02:36','user_9','2022-03-21 17:47:53'),(10,6,16,NULL,'user_4','2022-01-02 16:26:31','user_7','2022-06-19 12:34:00'),(11,27,17,NULL,'user_4','2021-07-20 10:11:44','user_3','2021-07-31 20:33:14'),(12,27,4,NULL,'user_3','2022-10-13 19:37:40','user_5','2022-11-29 19:36:44'),(13,24,20,NULL,'user_9','2021-12-23 12:13:22','user_7','2021-12-27 11:39:31'),(14,5,13,NULL,'user_7','2021-11-06 03:49:53','user_9','2022-07-23 20:55:41'),(15,12,17,NULL,'user_4','2022-04-24 22:56:18','user_2','2022-05-18 07:45:03'),(16,1,19,NULL,'user_6','2022-10-11 20:11:03','user_4','2022-10-28 04:33:03'),(17,28,17,NULL,'user_2','2021-10-31 20:22:19','user_1','2022-07-28 17:55:54'),(18,7,20,NULL,'user_9','2021-06-18 03:06:01','user_8','2021-07-03 01:16:59'),(19,25,1,NULL,'user_5','2022-11-04 13:08:25','user_9','2022-11-14 20:34:21'),(20,16,18,NULL,'user_5','2022-06-09 16:57:45','user_2','2022-12-29 14:22:34'),(21,25,9,NULL,'user_6','2022-12-04 12:01:11','user_1','2022-12-28 02:29:45'),(22,22,16,NULL,'user_6','2022-09-06 14:21:51','user_4','2022-12-04 00:08:19'),(23,16,5,NULL,'user_1','2022-03-20 15:09:22','user_7','2022-06-26 04:18:39'),(24,23,2,NULL,'user_3','2021-03-31 11:37:18','user_1','2022-10-13 05:55:53'),(25,7,13,NULL,'user_4','2022-03-26 03:43:25','user_1','2022-09-15 02:01:42'),(26,3,17,NULL,'user_5','2022-06-05 22:50:56','user_7','2022-07-22 02:51:03'),(27,15,17,NULL,'user_9','2022-10-02 10:22:04','user_4','2022-11-11 13:59:05'),(28,9,15,NULL,'user_4','2022-06-30 19:19:40','user_1','2022-12-25 02:53:13'),(29,23,2,NULL,'user_9','2022-11-23 18:25:35','user_5','2022-12-30 07:22:23'),(30,27,14,NULL,'user_5','2021-12-28 01:40:44','user_3','2022-06-19 02:24:36'),(31,13,8,NULL,'user_5','2022-11-22 04:12:42','user_6','2022-12-18 19:35:14'),(32,1,16,NULL,'user_2','2021-08-24 05:13:47','user_4','2022-08-20 01:14:09'),(33,30,20,NULL,'user_5','2021-03-06 22:32:24','user_3','2022-11-28 11:34:42'),(34,15,4,NULL,'user_5','2021-03-11 03:28:42','user_4','2022-09-08 22:51:58'),(35,25,14,NULL,'user_4','2022-05-17 22:50:13','user_1','2022-10-06 07:26:06'),(36,25,2,NULL,'user_5','2021-11-11 14:12:07','user_2','2022-01-28 10:45:43'),(37,22,13,NULL,'user_5','2021-01-05 23:33:19','user_4','2021-12-20 07:08:02'),(38,2,1,NULL,'user_1','2021-06-07 07:40:14','user_7','2022-05-05 22:14:58'),(39,15,14,NULL,'user_9','2022-09-24 02:35:33','user_7','2022-09-24 13:08:57'),(40,21,15,NULL,'user_7','2022-11-11 23:44:59','user_3','2022-12-03 12:36:46'),(41,5,2,NULL,'user_10','2021-09-28 05:46:21','user_8','2022-10-16 06:29:31'),(42,16,14,NULL,'user_5','2021-06-23 03:32:54','user_7','2022-03-12 17:30:54'),(43,7,8,NULL,'user_4','2022-04-24 02:17:51','user_5','2022-06-11 06:30:48'),(44,12,13,NULL,'user_4','2022-02-19 13:35:33','user_2','2022-04-25 22:42:53'),(45,23,17,NULL,'user_9','2021-07-06 07:32:26','user_1','2022-01-22 15:38:56'),(46,27,14,NULL,'user_8','2021-08-15 13:37:04','user_3','2022-08-27 05:06:25'),(47,4,14,NULL,'user_4','2022-06-07 14:48:27','user_2','2022-07-02 16:49:44'),(48,27,2,NULL,'user_5','2021-12-21 06:05:16','user_10','2022-11-07 01:05:20'),(49,12,18,NULL,'user_2','2021-02-20 10:33:21','user_4','2021-05-24 01:12:42'),(50,1,6,NULL,'user_5','2021-03-30 06:34:13','user_6','2021-04-10 22:42:22');
/*!40000 ALTER TABLE `t_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product` (
  `pid` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `sid` int NOT NULL COMMENT '所属商店id',
  `product_name` varchar(50) NOT NULL COMMENT '商品名称',
  `price` double DEFAULT NULL COMMENT '商品单价',
  `details` varchar(1000) NOT NULL COMMENT '商品描述',
  `is_hot` int DEFAULT '0' COMMENT '是否热门: 0-不热门, 1-热门',
  `storage` int DEFAULT NULL COMMENT '库存数量',
  `sale_volume` int DEFAULT '0' COMMENT '销量',
  `image` varchar(500) DEFAULT NULL COMMENT '图片路径',
  `status` int DEFAULT '1' COMMENT '商品状态  1：上架   2：下架   3：删除',
  `priority` int DEFAULT NULL COMMENT '显示优先级',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `created_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modified_user` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (1,2,'product_14',831.39,'This is the description for product_6',0,127,1,'/images/product_4.jpg',2,6,'2022-06-12 08:01:32','2021-09-15 07:02:46','creator_1','modifier_1'),(2,8,'product_12',535.45,'This is the description for product_4',0,420,1,'/images/product_3.jpg',3,8,'2021-09-27 04:42:57','2021-06-20 22:01:27','creator_2','modifier_1'),(3,5,'product_1',54.46,'This is the description for product_16',0,116,1,'/images/product_16.jpg',3,4,'2022-02-19 07:10:18','2022-08-04 21:24:23','creator_2','modifier_1'),(4,2,'product_2',120.88,'This is the description for product_16',1,89,1,'/images/product_10.jpg',2,1,'2021-01-04 17:59:36','2021-03-25 20:25:58','creator_0','modifier_1'),(5,2,'product_0',473.1,'This is the description for product_16',1,162,1,'/images/product_2.jpg',2,8,'2021-01-13 22:09:41','2022-09-13 12:59:47','creator_3','modifier_1'),(6,5,'product_4',736.03,'This is the description for product_14',1,27,1,'/images/product_3.jpg',1,1,'2021-09-21 14:12:19','2022-05-30 11:17:06','creator_3','modifier_1'),(7,6,'product_6',248.86,'This is the description for product_7',1,414,1,'/images/product_1.jpg',3,4,'2021-06-16 17:54:02','2021-08-09 07:43:08','creator_0','modifier_4'),(8,10,'product_4',761.85,'This is the description for product_14',1,266,1,'/images/product_13.jpg',3,2,'2023-03-02 00:35:05','2021-06-20 12:53:48','creator_3','modifier_2'),(9,6,'product_13',670.42,'This is the description for product_2',1,138,1,'/images/product_14.jpg',3,9,'2023-03-09 01:56:30','2022-11-28 16:42:55','creator_0','modifier_2'),(10,4,'product_0',65.84,'This is the description for product_16',1,201,1,'/images/product_9.jpg',2,8,'2023-07-01 12:14:05','2021-04-04 13:30:54','creator_4','modifier_1'),(11,9,'product_12',819.33,'This is the description for product_8',1,32,1,'/images/product_0.jpg',1,5,'2021-09-28 14:46:56','2023-04-30 04:48:12','creator_4','modifier_4'),(12,6,'product_15',915.34,'This is the description for product_0',1,132,1,'/images/product_17.jpg',3,8,'2022-12-13 15:53:09','2021-08-03 08:13:50','creator_3','modifier_4'),(13,1,'product_7',124.01,'This is the description for product_2',1,265,1,'/images/product_17.jpg',3,5,'2021-02-25 16:37:10','2023-05-09 22:04:20','creator_2','modifier_0'),(14,5,'product_8',255.63,'This is the description for product_6',1,227,1,'/images/product_11.jpg',2,8,'2022-06-08 04:08:19','2021-06-14 11:39:42','creator_3','modifier_2'),(15,6,'product_6',221.46,'This is the description for product_0',1,322,1,'/images/product_13.jpg',2,6,'2022-02-16 15:32:54','2023-06-27 22:00:01','creator_4','modifier_3'),(16,7,'product_9',555.03,'This is the description for product_18',1,262,1,'/images/product_17.jpg',1,1,'2022-09-10 16:40:31','2023-03-07 14:07:47','creator_1','modifier_2'),(17,2,'product_13',514.69,'This is the description for product_14',1,455,1,'/images/product_4.jpg',1,7,'2022-08-19 19:22:52','2021-07-06 09:21:09','creator_1','modifier_1'),(18,8,'product_14',669.69,'This is the description for product_8',1,155,1,'/images/product_14.jpg',3,8,'2021-03-09 20:22:48','2022-12-17 15:10:07','creator_0','modifier_0'),(19,8,'product_2',534.07,'This is the description for product_4',0,470,1,'/images/product_10.jpg',3,1,'2021-08-23 19:25:24','2021-01-13 00:21:16','creator_1','modifier_3'),(20,5,'product_4',535.72,'This is the description for product_14',0,448,1,'/images/product_9.jpg',3,6,'2022-04-28 23:54:30','2021-01-06 05:46:43','creator_3','modifier_1');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_shop`
--

DROP TABLE IF EXISTS `t_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_shop` (
  `sid` int NOT NULL AUTO_INCREMENT COMMENT '商店id',
  `username` varchar(20) NOT NULL COMMENT '商户用户名',
  `password` char(32) NOT NULL COMMENT '商户的密码',
  `salt` char(36) DEFAULT NULL COMMENT '商户的盐值',
  `shopname` varchar(20) NOT NULL COMMENT '商店名',
  `fans_number` int DEFAULT '0' COMMENT '商店粉丝数量',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(50) DEFAULT NULL COMMENT '商店地址',
  `is_authenticated` int DEFAULT NULL COMMENT '是否认证：0-未认证，1-已认证',
  `created_user` varchar(20) DEFAULT NULL COMMENT '日志-创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志-创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '日志-最后修改执行人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志-最后修改时间',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_shop`
--

LOCK TABLES `t_shop` WRITE;
/*!40000 ALTER TABLE `t_shop` DISABLE KEYS */;
INSERT INTO `t_shop` VALUES (1,'shop_user0','xuiqa4l1tqvhdmi7tpj1tsy9352zfzve','ghvqz1h1yz2j1knkl4sqa3chh113g0kls0xy','shop0',7014,'13290359754','shop0@example.com','Address 0',1,'creator1','2021-04-28 06:23:38','modifier0','2021-05-11 05:04:40'),(2,'shop_user1','e4nc1w0ct8fbit0ucryeeqr6iqg30awb','4qdez4mdm902d6bg3xux960ooxs7d7b7z6py','shop1',2441,'13369103757','shop1@example.com','Address 1',0,'creator2','2021-11-28 14:08:22','modifier4','2022-11-11 12:15:08'),(3,'shop_user2','b75eucg2jsr37ixhetmbefobk1gvoy44','0u5axh890qreah12udgd5kumj9xhqe781f2x','shop2',2608,'13812795475','shop2@example.com','Address 2',0,'creator0','2022-10-30 16:06:13','modifier2','2022-07-12 16:54:49'),(4,'shop_user3','f75c2u3n1drzm49dr9z0y3e2kcuycm0c','8djsxrvss9uulawg0bbswti7pklfmbiwf63t','shop3',7805,'13909114753','shop3@example.com','Address 3',0,'creator4','2023-03-01 03:46:42','modifier1','2022-04-21 17:43:31'),(5,'shop_user4','aed5fffiffk16oxwi012kkgqdokof0rm','ho2vxu9yjngqtsokw4ssaqf5qx97zn2o5nvr','shop4',9482,'13099904471','shop4@example.com','Address 4',1,'creator2','2022-12-31 20:27:43','modifier0','2021-10-11 15:28:58'),(6,'shop_user5','ppulxcexjkcrhd3nn3bb0372nd9frir4','7v71to20so1xsg65qepleziprzj47a1p58na','shop5',9644,'13945435110','shop5@example.com','Address 5',0,'creator0','2021-12-13 00:29:50','modifier2','2023-05-09 05:44:47'),(7,'shop_user6','0mln99jsut1rxpz0sybvt0oej8fu8ay9','uf2pv9jkdgjfnnmz1cd86ctaf9bfz9hdm22r','shop6',1039,'13691301187','shop6@example.com','Address 6',0,'creator1','2023-02-03 04:50:12','modifier1','2021-01-25 11:47:34'),(8,'shop_user7','aty5fcj3sdrg5bsdkxjj9dtf8rcwyws2','7d5slexbbr78y2ef13bfjfho0z8rkg8buuvo','shop7',3895,'13230140813','shop7@example.com','Address 7',0,'creator1','2023-07-08 23:50:33','modifier3','2021-05-23 23:15:53'),(9,'shop_user8','2y23dhbburmt0gn0qfjhck3n5wnru3ih','ehu3zdeq28iv0at6da523c8zsqm4p7hlo6da','shop8',4235,'13026683641','shop8@example.com','Address 8',0,'creator2','2022-04-26 17:40:17','modifier1','2022-03-09 15:44:01'),(10,'shop_user9','igacz3wqoh30ugywi35nsqg6gb68ryqr','8s7ber3w9gikp8ajff04euiecscciizejtm4','shop9',937,'13148187978','shop9@example.com','Address 9',0,'creator0','2021-05-04 04:08:50','modifier2','2023-02-03 20:00:50');
/*!40000 ALTER TABLE `t_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `type` varchar(20) NOT NULL COMMENT '注册类型',
  `password` char(32) NOT NULL COMMENT '密码',
  `salt` char(36) DEFAULT NULL COMMENT '盐值',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮箱',
  `gender` varchar(1) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(50) DEFAULT NULL COMMENT '头像',
  `is_delete` int DEFAULT NULL COMMENT '是否删除：0-未删除，1-已删除',
  `created_user` varchar(20) DEFAULT NULL COMMENT '日志-创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志-创建时间',
  `modified_user` varchar(20) DEFAULT NULL COMMENT '日志-最后修改执行人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志-最后修改时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'user0','regular','raj7uhz22e4tn1o90ikrh6md714drrrg','9q38rsqwutnj9rlk5j8tccf2qdamd6t5vug3','13384011491','user0@example.com','0','avatar9.png',0,'creator4','2022-06-24 23:15:55','modifier3','2023-03-28 09:33:32'),(2,'user1','regular','tzxi9y8h2ksqasakpf760c4wntrbtfqy','tsv9x4ggsgit7he93n1q00lq90xdfknsmpyn','13304540919','user1@example.com','1','avatar7.png',0,'creator0','2022-08-11 06:01:18','modifier3','2021-12-10 04:40:03'),(3,'user2','admin','0l3e34gzj4owftpl2igkfsx4z3i9pm4w','0wk8i5545d1x03wtv2videy23y3duhnkf6nt','13214122090','user2@example.com','0','avatar2.png',0,'creator4','2021-12-07 03:44:56','modifier3','2022-06-08 00:20:59'),(4,'user3','regular','s2qd5icyb3ufjpaqle6y7jn3h2y0s46j','b23vefot41gfauvife2ohaix7eabp1vr88md','13391096461','user3@example.com','1','avatar4.png',0,'creator1','2022-08-14 20:04:37','modifier1','2021-08-26 16:22:57'),(5,'user4','regular','orhntzwxjiiua4i9whgluz4arcp0joo2','c69adrjobglh4qoltpldbbuz7rb3c4q68kfk','13817379094','user4@example.com','0','avatar2.png',0,'creator0','2022-10-11 05:34:01','modifier2','2021-12-05 18:11:22'),(6,'user5','admin','r5gsgan2vmkqf3e0i23hnyvj68sf1nft','kq8qb4vbm3u67qvy25rxhszjjj9zuovbdagv','13616047126','user5@example.com','1','avatar9.png',0,'creator4','2023-08-05 00:04:28','modifier3','2023-01-21 05:46:39'),(7,'user6','regular','dgpi88apqm6r1vwl113va532pe1cd2fn','zi6yygthliy5sri2t1s2u9i9l673l6n2zh62','13656477392','user6@example.com','0','avatar5.png',0,'creator2','2021-09-10 11:43:52','modifier3','2023-03-26 03:25:33'),(8,'user7','regular','3d017l03su4818n1wqams7wx48zvfyt0','puaecrgyztgnk0afo7nfh6f8q4eqgmxskd79','13932226745','user7@example.com','1','avatar8.png',0,'creator2','2022-12-26 07:24:37','modifier4','2021-12-05 20:44:38'),(9,'user8','admin','jdcptv64dzskalhrepf5dnkytfj44ceu','gthmryt2zzna0hfi6ok2rzy0mb5kjx16rrl0','13107005844','user8@example.com','1','avatar8.png',0,'creator0','2021-07-27 05:24:17','modifier0','2022-01-08 23:41:34'),(10,'user9','admin','lxhavp3iu5rpe862m47rnsm75od0tn7z','tny39umug43zwqza4s8cgcb9cioz1h7s1ht6','13810954964','user9@example.com','1','avatar4.png',0,'creator3','2022-12-20 10:55:19','modifier0','2022-02-20 20:56:55');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_version`
--

DROP TABLE IF EXISTS `t_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_version` (
  `vid` int NOT NULL AUTO_INCREMENT COMMENT '版本条目id',
  `version` varchar(50) NOT NULL COMMENT '版本名称',
  `pid` int NOT NULL COMMENT '对应商品id',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_version`
--

LOCK TABLES `t_version` WRITE;
/*!40000 ALTER TABLE `t_version` DISABLE KEYS */;
INSERT INTO `t_version` VALUES (1,'version_1',10),(2,'version_2',7),(3,'version_3',5),(4,'version_4',6),(5,'version_5',18),(6,'version_6',20),(7,'version_7',13),(8,'version_8',5),(9,'version_9',5),(10,'version_10',5),(11,'version_11',19),(12,'version_12',14),(13,'version_13',20),(14,'version_14',11),(15,'version_15',12),(16,'version_16',8),(17,'version_17',19),(18,'version_18',17),(19,'version_19',6),(20,'version_20',11),(21,'version_21',19),(22,'version_22',7),(23,'version_23',7),(24,'version_24',8),(25,'version_25',13),(26,'version_26',5),(27,'version_27',3),(28,'version_28',14),(29,'version_29',17),(30,'version_30',9),(31,'version_31',6),(32,'version_32',7),(33,'version_33',20),(34,'version_34',6),(35,'version_35',14),(36,'version_36',5),(37,'version_37',19),(38,'version_38',5),(39,'version_39',7),(40,'version_40',13),(41,'version_41',11),(42,'version_42',20),(43,'version_43',17),(44,'version_44',15),(45,'version_45',20),(46,'version_46',7),(47,'version_47',18),(48,'version_48',20),(49,'version_49',14),(50,'version_50',13),(51,'version_51',2),(52,'version_52',20),(53,'version_53',14),(54,'version_54',8),(55,'version_55',14),(56,'version_56',6),(57,'version_57',16),(58,'version_58',19),(59,'version_59',3),(60,'version_60',7),(61,'version_61',5),(62,'version_62',17),(63,'version_63',5),(64,'version_64',6),(65,'version_65',5),(66,'version_66',20),(67,'version_67',13),(68,'version_68',17),(69,'version_69',9),(70,'version_70',6),(71,'version_71',19),(72,'version_72',1),(73,'version_73',8),(74,'version_74',8),(75,'version_75',9),(76,'version_76',6),(77,'version_77',17),(78,'version_78',12),(79,'version_79',18),(80,'version_80',20),(81,'version_81',2),(82,'version_82',20),(83,'version_83',14),(84,'version_84',9),(85,'version_85',18),(86,'version_86',8),(87,'version_87',5),(88,'version_88',19),(89,'version_89',18),(90,'version_90',20),(91,'version_91',1),(92,'version_92',19),(93,'version_93',16),(94,'version_94',14),(95,'version_95',7),(96,'version_96',17),(97,'version_97',4),(98,'version_98',8),(99,'version_99',11),(100,'version_100',6);
/*!40000 ALTER TABLE `t_version` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-22 10:07:20
