/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80402
 Source Host           : localhost:3306
 Source Schema         : mall-product-service

 Target Server Type    : MySQL
 Target Server Version : 80402
 File Encoding         : 65001

 Date: 28/08/2024 15:00:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `pid` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `sid` int NOT NULL COMMENT '所属商店id',
  `product_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品名称',
  `price` double NULL DEFAULT NULL COMMENT '商品单价',
  `details` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品描述',
  `is_hot` int NULL DEFAULT 0 COMMENT '是否热门: 0-不热门, 1-热门',
  `storage` int NULL DEFAULT 0 COMMENT '库存数量',
  `sale_volume` int NULL DEFAULT 0 COMMENT '销量',
  `image` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `status` int NULL DEFAULT 1 COMMENT '商品状态  1：上架   2：下架   3：删除',
  `priority` int NULL DEFAULT NULL COMMENT '显示优先级',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
  `created_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (1,2,'product_14',831.39,'This is the description for product_6',0,127,1,'/images/product_4.jpg',2,6,'2022-06-12 08:01:32','2021-09-15 07:02:46','creator_1','modifier_1'),(2,8,'product_12',535.45,'This is the description for product_4',0,420,1,'/images/product_3.jpg',3,8,'2021-09-27 04:42:57','2021-06-20 22:01:27','creator_2','modifier_1'),(3,5,'product_1',54.46,'This is the description for product_16',0,116,1,'/images/product_16.jpg',3,4,'2022-02-19 07:10:18','2022-08-04 21:24:23','creator_2','modifier_1'),(4,2,'product_2',120.88,'This is the description for product_16',1,89,1,'/images/product_10.jpg',2,1,'2021-01-04 17:59:36','2021-03-25 20:25:58','creator_0','modifier_1'),(5,2,'product_0',473.1,'This is the description for product_16',1,162,1,'/images/product_2.jpg',2,8,'2021-01-13 22:09:41','2022-09-13 12:59:47','creator_3','modifier_1'),(6,5,'product_4',736.03,'This is the description for product_14',1,27,1,'/images/product_3.jpg',1,1,'2021-09-21 14:12:19','2022-05-30 11:17:06','creator_3','modifier_1'),(7,6,'product_6',248.86,'This is the description for product_7',1,414,1,'/images/product_1.jpg',3,4,'2021-06-16 17:54:02','2021-08-09 07:43:08','creator_0','modifier_4'),(8,10,'product_4',761.85,'This is the description for product_14',1,266,1,'/images/product_13.jpg',3,2,'2023-03-02 00:35:05','2021-06-20 12:53:48','creator_3','modifier_2'),(9,6,'product_13',670.42,'This is the description for product_2',1,138,1,'/images/product_14.jpg',3,9,'2023-03-09 01:56:30','2022-11-28 16:42:55','creator_0','modifier_2'),(10,4,'product_0',65.84,'This is the description for product_16',1,201,1,'/images/product_9.jpg',2,8,'2023-07-01 12:14:05','2021-04-04 13:30:54','creator_4','modifier_1'),(11,9,'product_12',819.33,'This is the description for product_8',1,32,1,'/images/product_0.jpg',1,5,'2021-09-28 14:46:56','2023-04-30 04:48:12','creator_4','modifier_4'),(12,6,'product_15',915.34,'This is the description for product_0',1,132,1,'/images/product_17.jpg',3,8,'2022-12-13 15:53:09','2021-08-03 08:13:50','creator_3','modifier_4'),(13,1,'product_7',124.01,'This is the description for product_2',1,265,1,'/images/product_17.jpg',3,5,'2021-02-25 16:37:10','2023-05-09 22:04:20','creator_2','modifier_0'),(14,5,'product_8',255.63,'This is the description for product_6',1,227,1,'/images/product_11.jpg',2,8,'2022-06-08 04:08:19','2021-06-14 11:39:42','creator_3','modifier_2'),(15,6,'product_6',221.46,'This is the description for product_0',1,322,1,'/images/product_13.jpg',2,6,'2022-02-16 15:32:54','2023-06-27 22:00:01','creator_4','modifier_3'),(16,7,'product_9',555.03,'This is the description for product_18',1,262,1,'/images/product_17.jpg',1,1,'2022-09-10 16:40:31','2023-03-07 14:07:47','creator_1','modifier_2'),(17,2,'product_13',514.69,'This is the description for product_14',1,455,1,'/images/product_4.jpg',1,7,'2022-08-19 19:22:52','2021-07-06 09:21:09','creator_1','modifier_1'),(18,8,'product_14',669.69,'This is the description for product_8',1,155,1,'/images/product_14.jpg',3,8,'2021-03-09 20:22:48','2022-12-17 15:10:07','creator_0','modifier_0'),(19,8,'product_2',534.07,'This is the description for product_4',0,470,1,'/images/product_10.jpg',3,1,'2021-08-23 19:25:24','2021-01-13 00:21:16','creator_1','modifier_3'),(20,5,'product_4',535.72,'This is the description for product_14',0,448,1,'/images/product_9.jpg',3,6,'2022-04-28 23:54:30','2021-01-06 05:46:43','creator_3','modifier_1');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;
SET FOREIGN_KEY_CHECKS = 1;
