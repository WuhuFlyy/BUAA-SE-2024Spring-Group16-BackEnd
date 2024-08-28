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
INSERT INTO `t_user` VALUES (1, 'zhangsan', 'buyer', '1A3DA0C7FCEEDF045A3174DE810DA0DE', '2F438D72-407D-46CA-B375-A3D6CB4DFABE', '18841919032', NULL, NULL, NULL, 0, NULL, NULL, NULL, '2024-08-22 16:16:13');
INSERT INTO `t_user` VALUES (2, 'lisi', 'buyer', '75F9E338FC98F894E0149CAF0F8E8511', '2F438D72-407D-46CA-B375-A3D6CB4DFABE', NULL, NULL, NULL, NULL, 0, 'lisi', '2024-08-22 15:54:15', 'lisi', '2024-08-22 16:19:48');
INSERT INTO `t_user` VALUES (3, 'wangwu', 'seller', '75F37D13593C4A9DA7FEA4DD05573CD5', '1AD6E33F-F7E1-41E8-8C0D-C213256A1AF1', NULL, NULL, NULL, NULL, 0, 'wangwu', '2024-08-23 16:28:11', 'wangwu', '2024-08-23 16:28:11');
INSERT INTO `t_user` VALUES (18, 'wang1023', 'seller', 'E7E9ADD0C108869DB1C4DFFFAC3EAB90', 'A5266406-CB78-4793-9BEA-878011314EEB', NULL, NULL, NULL, NULL, 0, 'wang1023', '2024-08-24 14:47:02', 'wang1023', '2024-08-24 14:47:02');
INSERT INTO `t_user` VALUES (19, 'wang1', 'seller', '98CFDF2AC900B5C58FF724A61AEEFF8E', '9CE780BF-4631-4518-A66D-4ABD33B539DE', NULL, NULL, NULL, NULL, 0, 'wang1', '2024-08-24 14:48:35', 'wang1', '2024-08-24 14:48:35');
INSERT INTO `t_user` VALUES (20, 'wan', 'seller', '999C81CB45BF43B52F2C4F12E25D91C5', '52CE8C33-B4C7-4BE7-87C6-A4F644B3C2CB', NULL, NULL, NULL, NULL, 0, 'wan', '2024-08-24 14:50:24', 'wan', '2024-08-24 14:50:24');
INSERT INTO `t_user` VALUES (21, 'wa', 'seller', 'A09F79C036A1807A66AE039A799A0D6B', '63DDE031-9E9E-488F-A950-B4943861AA29', NULL, NULL, NULL, NULL, 0, 'wa', '2024-08-24 14:51:32', 'wa', '2024-08-24 14:51:32');
INSERT INTO `t_user` VALUES (22, 'wangw', 'seller', '835A777A10844CFF2D602F01C7F3F3C0', '02D78D24-CF44-44BA-A30B-A9DE95BDCFC8', NULL, NULL, NULL, NULL, 0, 'wangw', '2024-08-26 11:17:34', 'wangw', '2024-08-26 11:17:34');
INSERT INTO `t_user` VALUES (23, 'wangwei', 'seller', '1F825F350E005A33826990BE96AB41FC', '78F2FAF5-F17E-4A57-8878-05A6DF89D10B', NULL, NULL, NULL, NULL, 0, 'wangwei', '2024-08-26 11:21:07', 'wangwei', '2024-08-26 11:21:07');
INSERT INTO `t_user` VALUES (24, 'wangwe', 'seller', '98E77A4B75A48E7F31DBEA3D86EA3348', '95336F2A-55FF-4CFB-8E3D-3DCD14DC0F31', NULL, NULL, NULL, NULL, 0, 'wangwe', '2024-08-26 11:34:42', 'wangwe', '2024-08-26 11:34:42');
INSERT INTO `t_user` VALUES (25, 'wangwetest', 'seller', '13FB84F9B5A5163FF6AC7CB13F7D36E3', '8A422019-5E8C-4F53-870D-6670A1AF1A2F', NULL, NULL, NULL, NULL, 0, 'wangwetest', '2024-08-27 09:53:05', 'wangwetest', '2024-08-27 09:53:05');

SET FOREIGN_KEY_CHECKS = 1;
