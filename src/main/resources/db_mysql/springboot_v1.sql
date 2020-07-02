/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_3306
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : springboot_v1

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 02/07/2020 11:10:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dg_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `dg_sys_menu`;
CREATE TABLE `dg_sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pid` int(11) NOT NULL COMMENT '父级主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单状态',
  `sort` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '排序',
  `last_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否末级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dg_sys_menu
-- ----------------------------
INSERT INTO `dg_sys_menu` VALUES (1, 0, '系统管理', NULL, '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (2, 1, '菜单管理', NULL, '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (3, 1, '用户管理', NULL, '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (4, 1, '角色管理', NULL, '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (5, 1, '权限管理', NULL, '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (6, 2, '菜单增加', '/menu/add', '1', '1', '1', NULL);
INSERT INTO `dg_sys_menu` VALUES (7, 2, '菜单删除', '/menu/del', '1', '1', '2', NULL);
INSERT INTO `dg_sys_menu` VALUES (8, 3, '用户增加', '/user/add', '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (9, 3, '用户删除', '/user/del', '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (10, 3, '用户列表', '/user/list', '1', '1', '3', NULL);
INSERT INTO `dg_sys_menu` VALUES (12, 4, '角色增加', '/role/add', '1', '1', NULL, NULL);
INSERT INTO `dg_sys_menu` VALUES (13, 4, '角色删除', '/role/del', '1', '1', NULL, NULL);

-- ----------------------------
-- Table structure for dg_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `dg_sys_permission`;
CREATE TABLE `dg_sys_permission`  (
  `permissionId` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NULL DEFAULT NULL,
  `parentId` bigint(20) NULL DEFAULT NULL,
  `parentIds` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permissionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resourceType` enum('menu','button') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dg_sys_permission
-- ----------------------------
INSERT INTO `dg_sys_permission` VALUES (1, b'0', 0, '0/', 'user:view', '用户管理', 'menu', 'user/userList');
INSERT INTO `dg_sys_permission` VALUES (2, b'0', 1, '0/1', 'user:add', '用户添加', 'button', 'user/userAdd');
INSERT INTO `dg_sys_permission` VALUES (3, b'0', 1, '0/1', 'user:del', '用户删除', 'button', 'user/userDel');

-- ----------------------------
-- Table structure for dg_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `dg_sys_role`;
CREATE TABLE `dg_sys_role`  (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`roleId`) USING BTREE,
  UNIQUE INDEX `UK_8sggqkp1sv8guimk979mf6anf`(`role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dg_sys_role
-- ----------------------------
INSERT INTO `dg_sys_role` VALUES (1, b'0', '管理员', 'admin');
INSERT INTO `dg_sys_role` VALUES (2, b'0', 'VIP会员', 'vip');
INSERT INTO `dg_sys_role` VALUES (3, b'1', 'test', 'test');

-- ----------------------------
-- Table structure for dg_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `dg_sys_role_permission`;
CREATE TABLE `dg_sys_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permissionId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKpuhqkr403td1v28c3e71cgm4b`(`roleId`) USING BTREE,
  INDEX `FKjwye79px7p33gsqu4kftj0ua1`(`permissionId`) USING BTREE,
  CONSTRAINT `dg_sys_role_permission_ibfk_1` FOREIGN KEY (`permissionId`) REFERENCES `dg_sys_permission` (`permissionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dg_sys_role_permission_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `dg_sys_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dg_sys_role_permission
-- ----------------------------
INSERT INTO `dg_sys_role_permission` VALUES (1, 1, 1);
INSERT INTO `dg_sys_role_permission` VALUES (2, 2, 1);
INSERT INTO `dg_sys_role_permission` VALUES (3, 2, 3);
INSERT INTO `dg_sys_role_permission` VALUES (4, 1, 3);

-- ----------------------------
-- Table structure for dg_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `dg_sys_user`;
CREATE TABLE `dg_sys_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expiredDate` date NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `UK_hl8fftx66p59oqgkkcfit3eay`(`userName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dg_sys_user
-- ----------------------------
INSERT INTO `dg_sys_user` VALUES (1, '2019-06-28 18:00:31', NULL, NULL, '管理员', '123456', '8d78869f470951332959580424d4bf4f', 0, 'admin');
INSERT INTO `dg_sys_user` VALUES (2, '2020-06-18 10:56:31', NULL, NULL, '测试人员', '748e5f32bf8bc70be48258e8e964f9bd', '8d78869f470951332959580424d4bf4f', 0, 'lijy');

-- ----------------------------
-- Table structure for dg_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `dg_sys_user_role`;
CREATE TABLE `dg_sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKgnn5rpnbwhx9fu93b19daiwbt`(`roleId`) USING BTREE,
  INDEX `FKsaymuhj4r4qr22w2q1e2oewx`(`userId`) USING BTREE,
  CONSTRAINT `dg_sys_user_role_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `dg_sys_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dg_sys_user_role_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `dg_sys_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dg_sys_user_role
-- ----------------------------
INSERT INTO `dg_sys_user_role` VALUES (1, 1, 1);
INSERT INTO `dg_sys_user_role` VALUES (2, 2, 3);

SET FOREIGN_KEY_CHECKS = 1;
