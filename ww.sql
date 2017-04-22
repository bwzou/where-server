-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2017-04-22 17:07:26
-- 服务器版本： 5.7.10-log
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ww`
--

-- --------------------------------------------------------

--
-- 表的结构 `attention`
--

CREATE TABLE `attention` (
  `user_id` int(11) NOT NULL,
  `grid_id` int(11) NOT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE `comment` (
  `share_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `content` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `footprint`
--

CREATE TABLE `footprint` (
  `foot_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `comment` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `footprint`
--

INSERT INTO `footprint` (`foot_id`, `user_id`, `latitude`, `longitude`, `comment`, `picture`, `create_time`) VALUES
(1, 5, 22.757704, 113.61433, '这次可以了吧', NULL, '2017-04-23 00:09:39'),
(2, 5, 22.757731, 113.614369, '测试', NULL, '2017-04-23 00:37:15');

-- --------------------------------------------------------

--
-- 表的结构 `friend`
--

CREATE TABLE `friend` (
  `user_id1` int(11) NOT NULL,
  `user_id2` int(11) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `grid`
--

CREATE TABLE `grid` (
  `grid_id` int(11) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `message`
--

CREATE TABLE `message` (
  `msg_id` int(11) NOT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `voice` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `emotion` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `is_read` int(2) DEFAULT '0' COMMENT '消息是否已读：1代表已读，0代表未读'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `message`
--

INSERT INTO `message` (`msg_id`, `from_user_id`, `to_user_id`, `msg`, `voice`, `video`, `emotion`, `create_time`, `latitude`, `longitude`, `is_read`) VALUES
(1, 5, 13, '发给他[笑脸]', NULL, NULL, NULL, '2017-04-08 10:25:39', NULL, NULL, 1),
(2, 5, 13, '刚刚给[瞌睡]', NULL, NULL, NULL, '2017-04-08 13:25:45', 23, 114, 1),
(3, 5, 13, '发广告[笑脸]', NULL, NULL, NULL, '2017-04-09 07:25:54', 22.75776, 113.61438, 1),
(4, 5, 13, '副局[笑脸]', NULL, NULL, NULL, '2017-04-09 10:26:00', 22.75776, 113.61438, 1),
(5, 5, 13, '发句号', NULL, NULL, NULL, '2017-04-09 12:58:34', 22.257752, 113.214378, 1),
(6, 5, 13, '赶紧结婚', NULL, NULL, NULL, NULL, 22.757752, 113.614378, 1),
(7, 5, 13, '国际会计[刺瞎]', NULL, NULL, NULL, NULL, 22.757752, 113.614378, 1);

-- --------------------------------------------------------

--
-- 表的结构 `share`
--

CREATE TABLE `share` (
  `share_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `grid_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `active_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `pictures` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `like` int(11) DEFAULT NULL,
  `like_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `thumb_up`
--

CREATE TABLE `thumb_up` (
  `share_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `user_id` int(10) UNSIGNED NOT NULL,
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
  `remind_time_to` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`user_id`, `nickname`, `password`, `where_name`, `gender`, `avatar`, `phone_number`, `area`, `two_dimension_code`, `signature`, `reminder`, `remind_time_from`, `remind_time_to`) VALUES
(2, 'zou', '123', NULL, NULL, NULL, '8529538', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'zou', '123', NULL, NULL, NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'zou', '123', NULL, NULL, NULL, '8529547', NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'zou', '123', NULL, NULL, NULL, '8529522', NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'zou', '123', NULL, NULL, NULL, '8529536', NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'zou', '123', NULL, NULL, NULL, '8529552', NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'zou', '123', NULL, NULL, NULL, '8529541', NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'zou', '123', NULL, NULL, NULL, '8529845', NULL, NULL, NULL, NULL, NULL, NULL),
(12, 'zou', '123', NULL, NULL, NULL, '8529588', NULL, NULL, NULL, NULL, NULL, NULL),
(13, 'zou', '123', NULL, NULL, NULL, '123456', NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attention`
--
ALTER TABLE `attention`
  ADD PRIMARY KEY (`user_id`,`grid_id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`share_id`,`user_id`);

--
-- Indexes for table `footprint`
--
ALTER TABLE `footprint`
  ADD PRIMARY KEY (`foot_id`);

--
-- Indexes for table `friend`
--
ALTER TABLE `friend`
  ADD PRIMARY KEY (`user_id1`);

--
-- Indexes for table `grid`
--
ALTER TABLE `grid`
  ADD PRIMARY KEY (`grid_id`),
  ADD KEY `latitude` (`latitude`,`longitude`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `share`
--
ALTER TABLE `share`
  ADD PRIMARY KEY (`share_id`);

--
-- Indexes for table `thumb_up`
--
ALTER TABLE `thumb_up`
  ADD PRIMARY KEY (`share_id`,`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `footprint`
--
ALTER TABLE `footprint`
  MODIFY `foot_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `message`
--
ALTER TABLE `message`
  MODIFY `msg_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
