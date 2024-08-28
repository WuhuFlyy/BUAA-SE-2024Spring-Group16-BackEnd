/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80402
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80402
 File Encoding         : 65001

 Date: 28/08/2024 15:00:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address`  (
  `aid` int NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
  `uid` int NULL DEFAULT NULL COMMENT '归属的用户id',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `area_name` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '校区-名称',
  `address` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机',
  `is_default` int NULL DEFAULT NULL COMMENT '是否默认：0-不默认，1-默认',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_address
-- ----------------------------

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart`  (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT '购物车数据id',
  `uid` int NOT NULL COMMENT '用户id',
  `pid` int NOT NULL COMMENT '商品id',
  `version` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '版本选择',
  `quantity` int NULL DEFAULT NULL COMMENT '商品数量',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES (1, 3, 1, 'v1.0', 2, 'wangwu', '2024-08-28 10:14:21', 'wangwu', '2024-08-28 10:14:21');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `uid` int NOT NULL COMMENT '评价用户id',
  `pid` int NOT NULL COMMENT '被评价商品id',
  `rate` double NOT NULL COMMENT '评分',
  `content` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (3, 1, 101, 4.5, 'This is a sample comment.');
INSERT INTO `t_comment` VALUES (4, 1, 101, 4.5, 'This is a sample comment.');
INSERT INTO `t_comment` VALUES (5, 1, 101, 4.5, 'This is a sample comment.');
INSERT INTO `t_comment` VALUES (6, 1, 101, 4.5, 'This is a sample comment.');
INSERT INTO `t_comment` VALUES (7, 1, 101, 4.5, 'This is a sample comment.');
INSERT INTO `t_comment` VALUES (8, 1, 101, 4, 'sample comment.');
INSERT INTO `t_comment` VALUES (9, 1, 1, 4, 'sample comment.');
INSERT INTO `t_comment` VALUES (10, 1, 1, 5, 'sample comment.');

-- ----------------------------
-- Table structure for t_comment_image
-- ----------------------------
DROP TABLE IF EXISTS `t_comment_image`;
CREATE TABLE `t_comment_image`  (
  `ciid` int NOT NULL AUTO_INCREMENT COMMENT '评论图片id',
  `uid` int NOT NULL COMMENT '评论用户id',
  `cid` int NOT NULL COMMENT '对应评论id',
  `image_src` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片路径',
  PRIMARY KEY (`ciid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment_image
-- ----------------------------
INSERT INTO `t_comment_image` VALUES (2, 1, 7, 'http://example.com/image1.jpg');
INSERT INTO `t_comment_image` VALUES (3, 1, 7, 'http://example.com/image2.jpg');
INSERT INTO `t_comment_image` VALUES (4, 1, 8, 'http://example.com/image1.jpg');
INSERT INTO `t_comment_image` VALUES (5, 1, 8, 'http://example.com/image2.jpg');
INSERT INTO `t_comment_image` VALUES (6, 1, 9, 'http://example.com/image1.jpg');
INSERT INTO `t_comment_image` VALUES (7, 1, 9, 'http://example.com/image2.jpg');
INSERT INTO `t_comment_image` VALUES (8, 1, 10, 'http://example.com/image1.jpg');
INSERT INTO `t_comment_image` VALUES (9, 1, 10, 'http://example.com/image2.jpg');

-- ----------------------------
-- Table structure for t_favorite_product
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite_product`;
CREATE TABLE `t_favorite_product`  (
  `fpid` int NOT NULL AUTO_INCREMENT COMMENT '收藏商品数据id',
  `uid` int NOT NULL COMMENT '用户id',
  `pid` int NOT NULL COMMENT '商品id',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`fpid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_favorite_product
-- ----------------------------
INSERT INTO `t_favorite_product` VALUES (2, 1, 1, 'zhangsan', '2024-08-19 22:43:15', 'zhangsan', '2024-08-19 22:43:15');

-- ----------------------------
-- Table structure for t_favorite_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite_shop`;
CREATE TABLE `t_favorite_shop`  (
  `fsid` int NOT NULL AUTO_INCREMENT COMMENT '收藏店铺数据id',
  `uid` int NOT NULL COMMENT '用户id',
  `sid` int NOT NULL COMMENT '商品id',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`fsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_favorite_shop
-- ----------------------------
INSERT INTO `t_favorite_shop` VALUES (4, 1, 1, 'zhangsan', '2024-08-19 22:52:24', 'zhangsan', '2024-08-19 22:52:24');

-- ----------------------------
-- Table structure for t_image
-- ----------------------------
DROP TABLE IF EXISTS `t_image`;
CREATE TABLE `t_image`  (
  `iid` int NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `pid` int NOT NULL COMMENT '对应商品id',
  `image_src` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片内容',
  PRIMARY KEY (`iid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_image
-- ----------------------------
INSERT INTO `t_image` VALUES (1, 1, '123');
INSERT INTO `t_image` VALUES (2, 3, '0rHFEu0Upo');
INSERT INTO `t_image` VALUES (3, 1, 'SgLylzez6v');
INSERT INTO `t_image` VALUES (4, 2, 'test');
INSERT INTO `t_image` VALUES (5, 4, 'http://example.com/image1.jpg');
INSERT INTO `t_image` VALUES (6, 5, 'http://example.com/image2.jpg');
INSERT INTO `t_image` VALUES (7, 3, 'http://example.com/image1.jpg');
INSERT INTO `t_image` VALUES (8, 3, 'http://example.com/image2.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `oid` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `uid` int NOT NULL COMMENT '用户id',
  `aid` int NOT NULL COMMENT '对应收获地址id',
  `version` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '版本选择',
  `quantity` int NULL DEFAULT NULL COMMENT '购买数量',
  `total_price` bigint NULL DEFAULT NULL COMMENT '总价',
  `status` int NULL DEFAULT NULL COMMENT '状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成',
  `order_time` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `oiid` int NOT NULL AUTO_INCREMENT COMMENT '订单条目id',
  `oid` int NOT NULL COMMENT '所属订单id',
  `pid` int NOT NULL COMMENT '订单条目包含的商品id',
  `version` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '版本选择',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`oiid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

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
  `storage` int NULL DEFAULT NULL COMMENT '库存数量',
  `sale_volume` int NULL DEFAULT 0 COMMENT '销量',
  `image` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `status` int NULL DEFAULT 1 COMMENT '商品状态  1：上架   2：下架   3：删除',
  `priority` int NULL DEFAULT NULL COMMENT '显示优先级',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
  `created_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (1, 1, 'producttest', 1.2, '12312', 0, NULL, 0, NULL, 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop`  (
  `sid` int NOT NULL AUTO_INCREMENT COMMENT '商店id',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商户用户名',
  `password` char(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商户的密码',
  `salt` char(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商户的盐值',
  `shopname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商店名',
  `fans_number` int NULL DEFAULT 0 COMMENT '商店粉丝数量',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商店地址',
  `is_authenticated` int NULL DEFAULT NULL COMMENT '是否认证：0-未认证，1-已认证',
  `created_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日志-创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '日志-创建时间',
  `modified_user` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日志-最后修改执行人',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '日志-最后修改时间',
  PRIMARY KEY (`sid`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO `t_shop` VALUES (1, 'shopone', '123456', NULL, 'what', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_shop` VALUES (2, 'lisi', '123456', NULL, 'Test Shop', 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_shop` VALUES (3, 'wangwe', '98E77A4B75A48E7F31DBEA3D86EA3348', '95336F2A-55FF-4CFB-8E3D-3DCD14DC0F31', 'wangwe', 0, NULL, NULL, NULL, 1, 'wangwe', '2024-08-26 11:34:42', 'wangwe', '2024-08-26 11:34:42');
INSERT INTO `t_shop` VALUES (4, 'wangwetest', '13FB84F9B5A5163FF6AC7CB13F7D36E3', '8A422019-5E8C-4F53-870D-6670A1AF1A2F', 'wangwetest', 0, NULL, NULL, NULL, 1, 'wangwetest', '2024-08-27 09:53:05', 'wangwetest', '2024-08-27 09:53:05');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zhangsan', '1', '123456', '123', '18841919032', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_version
-- ----------------------------
DROP TABLE IF EXISTS `t_version`;
CREATE TABLE `t_version`  (
  `vid` int NOT NULL AUTO_INCREMENT COMMENT '版本条目id',
  `version` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '版本名称',
  `pid` int NOT NULL COMMENT '对应商品id',
  PRIMARY KEY (`vid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_version
-- ----------------------------
INSERT INTO `t_version` VALUES (1, 'v1.0', 1);
INSERT INTO `t_version` VALUES (2, 'v2.0', 5);
INSERT INTO `t_version` VALUES (3, 'v1.0', 3);
INSERT INTO `t_version` VALUES (4, 'v2.0', 3);

SET FOREIGN_KEY_CHECKS = 1;
