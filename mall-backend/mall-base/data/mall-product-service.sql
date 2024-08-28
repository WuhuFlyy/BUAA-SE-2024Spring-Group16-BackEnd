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
INSERT INTO `t_product` VALUES (1, 1, 'producttest', 1.2, '12312', 0, 4, 0, '1', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_product` VALUES (2, 184, 'Orange core', 367.87, 'aQL0ejGz1m', 0, 690, 792, '1', 512, 964, '2006-07-11 08:50:17', '2020-05-15 15:27:59', 'rpkGOgMBPJ', '9sYmek4stn');
INSERT INTO `t_product` VALUES (3, 1, 'Sample', 99.99, 'This is a sample product.', 0, 100, NULL, '1', 1, NULL, '2002-05-11 11:16:43', '2024-08-28 09:38:00', 'NQKnCjzpo8', 'shopone');
INSERT INTO `t_product` VALUES (4, 1, 'Sample Product', 99.99, 'This is a sample product.', 0, 100, NULL, '1', 1, NULL, '2024-08-28 09:34:32', '2024-08-28 09:34:32', 'shopone', 'shopone');
INSERT INTO `t_product` VALUES (5, 1, 'Sample Product', 99.99, 'This is a sample product.', 0, 100, NULL, '1', 1, NULL, '2024-08-28 09:36:40', '2024-08-28 09:36:40', 'shopone', 'shopone');

SET FOREIGN_KEY_CHECKS = 1;
