/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : ww

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-04-09 15:37:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention` (
  `user_id` int(11) NOT NULL,
  `grid_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attention
-- ----------------------------

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `voice` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `emotion` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `is_read` int(2) DEFAULT '0' COMMENT '消息是否已读：1代表已读，0代表未读',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('1', '5', '13', '发给他[笑脸]', null, null, null, '2017-04-08 10:25:39', null, null, '1');
INSERT INTO `chat` VALUES ('2', '5', '13', '刚刚给[瞌睡]', null, null, null, '2017-04-08 13:25:45', '23', '114', '1');
INSERT INTO `chat` VALUES ('3', '5', '13', '发广告[笑脸]', null, null, null, '2017-04-09 07:25:54', '22.75776', '113.61438', '1');
INSERT INTO `chat` VALUES ('4', '5', '13', '副局[笑脸]', null, null, null, '2017-04-09 10:26:00', '22.75776', '113.61438', '1');
INSERT INTO `chat` VALUES ('5', '5', '13', '发句号', null, null, null, '2017-04-09 12:58:34', '22.257752', '113.214378', '1');
INSERT INTO `chat` VALUES ('6', '5', '13', '赶紧结婚', null, null, null, null, '22.757752', '113.614378', '1');
INSERT INTO `chat` VALUES ('7', '5', '13', '国际会计[刺瞎]', null, null, null, null, '22.757752', '113.614378', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `msg_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `user_id1` int(11) NOT NULL,
  `user_id2` int(11) DEFAULT NULL,
  `user_id3` int(11) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------

-- ----------------------------
-- Table structure for grid
-- ----------------------------
DROP TABLE IF EXISTS `grid`;
CREATE TABLE `grid` (
  `grid_id` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grid
-- ----------------------------

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `msg_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `grid_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `active_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `pictures` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `like` int(11) DEFAULT NULL,
  `like_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share
-- ----------------------------

-- ----------------------------
-- Table structure for thumb_up
-- ----------------------------
DROP TABLE IF EXISTS `thumb_up`;
CREATE TABLE `thumb_up` (
  `msg_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of thumb_up
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `where_name` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL COMMENT '0是男1是女2是保密',
  `avatar` varchar(255) DEFAULT NULL,
  `phone_number` varchar(11) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `two_dimension_code` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `reminder` varchar(255) DEFAULT NULL,
  `remind_time_from` datetime DEFAULT NULL,
  `remind_time_to` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'zou', '123', null, null, null, '8529538', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('5', 'zou', '123', null, null, null, '123', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'zou', '123', null, null, null, '8529547', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', 'zou', '123', null, null, null, '8529522', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', 'zou', '123', null, null, null, '8529536', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('9', 'zou', '123', null, null, null, '8529552', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('10', 'zou', '123', null, null, null, '8529541', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('11', 'zou', '123', null, null, null, '8529845', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('12', 'zou', '123', null, null, null, '8529588', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('13', 'zou', '123', null, null, null, '123456', null, null, null, null, null, null);
