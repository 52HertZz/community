/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : it_community

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 05/12/2019 23:26:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ic_post
-- ----------------------------
DROP TABLE IF EXISTS `ic_post`;
CREATE TABLE `ic_post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '帖子内容',
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子标签',
  `gmt_create` bigint(255) NULL DEFAULT NULL COMMENT '帖子创建时间',
  `gmt_modified` bigint(255) NULL DEFAULT NULL COMMENT '帖子修改时间',
  `creator_id` int(11) NULL DEFAULT NULL COMMENT '发帖人id',
  `like_count` int(11) NULL DEFAULT 0 COMMENT '点赞数',
  `dislike_count` int(11) NULL DEFAULT 0 COMMENT '点踩数',
  `comment_count` int(11) NULL DEFAULT 0 COMMENT '评论数',
  `favorite_count` int(11) NULL DEFAULT 0 COMMENT '收藏数',
  `view_count` int(11) NULL DEFAULT 0 COMMENT '浏览数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ic_user
-- ----------------------------
DROP TABLE IF EXISTS `ic_user`;
CREATE TABLE `ic_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `account_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所基于平台的id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `token` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登录令牌',
  `gmt_create` bigint(20) NULL DEFAULT NULL COMMENT '用户创建时间',
  `gmt_modified` bigint(20) NULL DEFAULT NULL COMMENT '用户修改时间',
  `bio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
