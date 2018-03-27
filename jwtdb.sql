/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost
 Source Database       : jwtdb

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 03/28/2018 00:24:12 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `AUTHORITY`;
CREATE TABLE `AUTHORITY` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `AUTHORITY`
-- ----------------------------
BEGIN;
INSERT INTO `AUTHORITY` VALUES ('1', 'ROLE_USER'), ('2', 'ROLE_ADMIN');
COMMIT;

-- ----------------------------
--  Table structure for `USER`
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `ENABLED` varchar(255) DEFAULT NULL,
  `LASTPASSWORDRESETDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `USER`
-- ----------------------------
BEGIN;
INSERT INTO `USER` VALUES ('1', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', '1', null), ('2', 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', '1', null), ('3', 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `USER_AUTHORITY`
-- ----------------------------
DROP TABLE IF EXISTS `USER_AUTHORITY`;
CREATE TABLE `USER_AUTHORITY` (
  `USER_ID` int(11) NOT NULL,
  `AUTHORITY_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`AUTHORITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `USER_AUTHORITY`
-- ----------------------------
BEGIN;
INSERT INTO `USER_AUTHORITY` VALUES ('1', '1'), ('1', '2'), ('2', '1'), ('3', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
