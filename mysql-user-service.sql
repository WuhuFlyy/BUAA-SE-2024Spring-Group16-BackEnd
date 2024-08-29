/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80402
 Source Host           : localhost:3306
 Source Schema         : mall-user-service

 Target Server Type    : MySQL
 Target Server Version : 80402
 File Encoding         : 65001

 Date: 28/08/2024 15:00:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '注册类型',
  `password` char(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `salt` char(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `gender` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `is_delete` int NULL DEFAULT NULL COMMENT '是否删除：0-未删除，1-已删除',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日志-创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '日志-创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日志-最后修改执行人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '日志-最后修改时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'user0','regular','raj7uhz22e4tn1o90ikrh6md714drrrg','9q38rsqwutnj9rlk5j8tccf2qdamd6t5vug3','13384011491','user0@example.com','0','avatar9.png',0,'creator4','2022-06-24 23:15:55','modifier3','2023-03-28 09:33:32'),(2,'user1','regular','tzxi9y8h2ksqasakpf760c4wntrbtfqy','tsv9x4ggsgit7he93n1q00lq90xdfknsmpyn','13304540919','user1@example.com','1','avatar7.png',0,'creator0','2022-08-11 06:01:18','modifier3','2021-12-10 04:40:03'),(3,'user2','admin','0l3e34gzj4owftpl2igkfsx4z3i9pm4w','0wk8i5545d1x03wtv2videy23y3duhnkf6nt','13214122090','user2@example.com','0','avatar2.png',0,'creator4','2021-12-07 03:44:56','modifier3','2022-06-08 00:20:59'),(4,'user3','regular','s2qd5icyb3ufjpaqle6y7jn3h2y0s46j','b23vefot41gfauvife2ohaix7eabp1vr88md','13391096461','user3@example.com','1','avatar4.png',0,'creator1','2022-08-14 20:04:37','modifier1','2021-08-26 16:22:57'),(5,'user4','regular','orhntzwxjiiua4i9whgluz4arcp0joo2','c69adrjobglh4qoltpldbbuz7rb3c4q68kfk','13817379094','user4@example.com','0','avatar2.png',0,'creator0','2022-10-11 05:34:01','modifier2','2021-12-05 18:11:22'),(6,'user5','admin','r5gsgan2vmkqf3e0i23hnyvj68sf1nft','kq8qb4vbm3u67qvy25rxhszjjj9zuovbdagv','13616047126','user5@example.com','1','avatar9.png',0,'creator4','2023-08-05 00:04:28','modifier3','2023-01-21 05:46:39'),(7,'user6','regular','dgpi88apqm6r1vwl113va532pe1cd2fn','zi6yygthliy5sri2t1s2u9i9l673l6n2zh62','13656477392','user6@example.com','0','avatar5.png',0,'creator2','2021-09-10 11:43:52','modifier3','2023-03-26 03:25:33'),(8,'user7','regular','3d017l03su4818n1wqams7wx48zvfyt0','puaecrgyztgnk0afo7nfh6f8q4eqgmxskd79','13932226745','user7@example.com','1','avatar8.png',0,'creator2','2022-12-26 07:24:37','modifier4','2021-12-05 20:44:38'),(9,'user8','admin','jdcptv64dzskalhrepf5dnkytfj44ceu','gthmryt2zzna0hfi6ok2rzy0mb5kjx16rrl0','13107005844','user8@example.com','1','avatar8.png',0,'creator0','2021-07-27 05:24:17','modifier0','2022-01-08 23:41:34'),(10,'user9','admin','lxhavp3iu5rpe862m47rnsm75od0tn7z','tny39umug43zwqza4s8cgcb9cioz1h7s1ht6','13810954964','user9@example.com','1','avatar4.png',0,'creator3','2022-12-20 10:55:19','modifier0','2022-02-20 20:56:55');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
SET FOREIGN_KEY_CHECKS = 1;
