/*
 Navicat Premium Data Transfer
 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : dm
 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001
 Date: 12/10/2020 22:24:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
                          `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
                          `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `birth` timestamp(0) NULL DEFAULT NULL,
                          `gender` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;