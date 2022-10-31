/*
 Navicat Premium Data Transfer

 Source Server         : localdb
 Source Server Type    : MySQL
 Source Server Version : 50719 (5.7.19)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50719 (5.7.19)
 File Encoding         : 65001

 Date: 31/10/2022 00:32:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `opttext` varchar(1024) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of answer
-- ----------------------------
BEGIN;
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (21, '3', 1, 'Patriots', 'Correct');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (22, '2', 1, 'Patriots', 'Correct');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (23, '2', 1, 'Patriots', 'Correct');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (24, '1', 1, 'Patriots', 'Correct');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (25, '1', 1, 'Falcons', 'Incorrect');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (26, '2', 1, 'Falcons', 'Incorrect');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (28, '2', 2, 'Nissan,Honda', 'NA');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (29, '2', 3, 'Age:<18,Gander:Male', 'NA');
INSERT INTO `answer` (`id`, `userid`, `qid`, `opttext`, `result`) VALUES (30, '2', 1, 'Patriots', 'Correct');
COMMIT;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `qid` int(11) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `preans` varchar(255) DEFAULT NULL,
  `selections` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;
INSERT INTO `question` (`qid`, `question`, `preans`, `selections`, `type`) VALUES (1, 'Which team won the 2017 super bowl?', 'Patriots', '[\"Falcons\",\"Patriots\"] ', 'quiz');
INSERT INTO `question` (`qid`, `question`, `preans`, `selections`, `type`) VALUES (2, 'What\'s your favorite car brand?', 'NA', '[\"Nissan\",\"Honda\",\"Audi\",\"BMW\"]', 'poll');
INSERT INTO `question` (`qid`, `question`, `preans`, `selections`, `type`) VALUES (3, 'Please tell us a bit about yourself?', 'NA', '[{\"Age\":[\"<18\", \"18 to 35\",\"35 to 55\",\"> 55\"]}, {\"Gender\":[\"Male\",\"Female\"]}]', 'matrix');
INSERT INTO `question` (`qid`, `question`, `preans`, `selections`, `type`) VALUES (4, 'test quiz1', 'answer1', '[\"answer1\",\"answer2\"]', 'quiz');
INSERT INTO `question` (`qid`, `question`, `preans`, `selections`, `type`) VALUES (5, 'test quiz2', 'answer2', '[\"answer1\",\"answer2\"]', 'quiz');
INSERT INTO `question` (`qid`, `question`, `preans`, `selections`, `type`) VALUES (6, 'test poll1', 'NA', '[\"poll answer1\",\"poll answer2\"]', 'poll');
COMMIT;

-- ----------------------------
-- Table structure for site
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site` (
  `siteid` varchar(255) DEFAULT NULL,
  `qlist` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of site
-- ----------------------------
BEGIN;
INSERT INTO `site` (`siteid`, `qlist`) VALUES ('site1', '[1,2]');
INSERT INTO `site` (`siteid`, `qlist`) VALUES ('site2', '[3,4]');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`uuid`) VALUES ('1');
INSERT INTO `user` (`uuid`) VALUES ('2');
INSERT INTO `user` (`uuid`) VALUES ('3');
INSERT INTO `user` (`uuid`) VALUES ('4');
INSERT INTO `user` (`uuid`) VALUES ('5');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
