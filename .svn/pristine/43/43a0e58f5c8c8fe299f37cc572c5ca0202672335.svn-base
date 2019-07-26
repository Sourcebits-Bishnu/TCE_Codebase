/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.7.22-0ubuntu0.17.10.1-log : Database - Content_Schema
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`Content_Schema` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `student-content-db`;

/*Table structure for table `ayp_amaster` */

DROP TABLE IF EXISTS `ayp_amaster`;

CREATE TABLE `ayp_amaster` (
  `aypId` varchar(45) NOT NULL,
  `schoolId` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `planStatus` int(11) NOT NULL DEFAULT '0' COMMENT '1- active, 0-inactive, 2-Archived',
  `syncStatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`aypId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ayp_sec` */

DROP TABLE IF EXISTS `ayp_sec`;

CREATE TABLE `ayp_sec` (
  `sectionId` varchar(75) NOT NULL,
  `aypId` varchar(45) NOT NULL,
  `sectionTitle` varchar(255) NOT NULL,
  `workdays` int(11) NOT NULL COMMENT 'auto calculated working days',
  PRIMARY KEY (`sectionId`),
  KEY `FK_section_aypId` (`aypId`),
  CONSTRAINT `FK_section_aypId` FOREIGN KEY (`aypId`) REFERENCES `ayp_amaster` (`aypId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ayp_sec_classes` */

DROP TABLE IF EXISTS `ayp_sec_classes`;

CREATE TABLE `ayp_sec_classes` (
  `classId` varchar(75) NOT NULL,
  `sectionId` varchar(75) NOT NULL,
  `ceGradeId` varchar(45) NOT NULL,
  `gradeTitle` varchar(100) NOT NULL,
  `divisionTitle` varchar(45) NOT NULL,
  `infraId` varchar(45) DEFAULT NULL,
  `aypId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`classId`),
  KEY `FK_class_sectionId` (`sectionId`),
  KEY `FK_class_infraId` (`infraId`),
  CONSTRAINT `FK_class_sectionId` FOREIGN KEY (`sectionId`) REFERENCES `ayp_sec` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `bUId` varchar(45) NOT NULL,
  `title` varchar(100) NOT NULL,
  `status` varchar(1) NOT NULL,
  `defaultCurriculum` varchar(45) NOT NULL,
  PRIMARY KEY (`bUId`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `boardcurriculum` */

DROP TABLE IF EXISTS `boardcurriculum`;

CREATE TABLE `boardcurriculum` (
  `boardId` varchar(45) NOT NULL,
  `curriculumId` varchar(45) NOT NULL,
  PRIMARY KEY (`boardId`,`curriculumId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_activity_custom` */

DROP TABLE IF EXISTS `content_activity_custom`;

CREATE TABLE `content_activity_custom` (
  `activityId` varchar(60) NOT NULL,
  `chapterId` varchar(60) DEFAULT NULL,
  `tpId` varchar(60) DEFAULT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `title` varchar(250) NOT NULL,
  `type` varchar(250) NOT NULL,
  `isDraft` int(1) NOT NULL,
  `isShared` int(1) unsigned NOT NULL,
  `isSync` int(1) unsigned NOT NULL,
  PRIMARY KEY (`activityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_activity_data` */

DROP TABLE IF EXISTS `content_activity_data`;

CREATE TABLE `content_activity_data` (
  `activityId` varchar(60) NOT NULL,
  `xml` mediumtext NOT NULL,
  PRIMARY KEY (`activityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_activity_map` */

DROP TABLE IF EXISTS `content_activity_map`;

CREATE TABLE `content_activity_map` (
  `activityId` varchar(60) NOT NULL,
  `assetId` varchar(60) NOT NULL,
  PRIMARY KEY (`activityId`,`assetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_activity_tata` */

DROP TABLE IF EXISTS `content_activity_tata`;

CREATE TABLE `content_activity_tata` (
  `activityId` varchar(45) NOT NULL,
  `tpId` varchar(45) NOT NULL,
  `title` varchar(250) NOT NULL,
  `keywords` varchar(512) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`activityId`),
  KEY `Index_tpId` (`tpId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_asset_custom` */

DROP TABLE IF EXISTS `content_asset_custom`;

CREATE TABLE `content_asset_custom` (
  `assetId` varchar(60) NOT NULL,
  `chapterId` varchar(60) DEFAULT NULL,
  `tpId` varchar(60) DEFAULT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `isDraft` int(1) NOT NULL,
  `isShared` int(1) unsigned NOT NULL,
  `title` varchar(250) NOT NULL,
  `mimeType` varchar(45) NOT NULL,
  `fileName` varchar(250) NOT NULL,
  `thumbFileName` varchar(250) DEFAULT NULL,
  `ansKeyId` varchar(512) DEFAULT NULL,
  `description` varchar(512) NOT NULL,
  `keywords` varchar(512) NOT NULL,
  `isSync` int(1) unsigned NOT NULL,
  `assetType` varchar(45) NOT NULL,
  `subType` varchar(45) NOT NULL,
  PRIMARY KEY (`assetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_asset_data` */

DROP TABLE IF EXISTS `content_asset_data`;

CREATE TABLE `content_asset_data` (
  `assetId` varchar(60) NOT NULL,
  `xml` text NOT NULL,
  PRIMARY KEY (`assetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_asset_tata` */

DROP TABLE IF EXISTS `content_asset_tata`;

CREATE TABLE `content_asset_tata` (
  `assetId` varchar(45) NOT NULL,
  `tpId` varchar(45) NOT NULL,
  `lcmsSubjectId` varchar(45) NOT NULL,
  `lcmsGradeId` varchar(45) NOT NULL,
  `title` varchar(250) NOT NULL,
  `mimeType` varchar(45) NOT NULL,
  `assetType` varchar(45) NOT NULL,
  `thumbFileName` varchar(250) DEFAULT NULL,
  `fileName` varchar(250) NOT NULL,
  `ansKeyId` varchar(45) DEFAULT NULL,
  `copyright` varchar(250) DEFAULT NULL,
  `subType` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `keywords` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`assetId`),
  KEY `Index_tpId` (`tpId`) USING BTREE,
  KEY `CAT_TPTYP_IDX` (`tpId`,`assetType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_books_tata` */

DROP TABLE IF EXISTS `content_books_tata`;

CREATE TABLE `content_books_tata` (
  `bookId` varchar(45) NOT NULL,
  `xml` text NOT NULL,
  `title` varchar(250) NOT NULL,
  `lastUpdatedOn` varchar(45) NOT NULL,
  `bookStatus` bit(1) NOT NULL DEFAULT b'0',
  `bookJson` text,
  `hasEbook` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_chapter_custom` */

DROP TABLE IF EXISTS `content_chapter_custom`;

CREATE TABLE `content_chapter_custom` (
  `chapterId` varchar(60) NOT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `title` varchar(250) NOT NULL,
  `isDraft` int(1) unsigned NOT NULL,
  `isShared` int(1) unsigned NOT NULL,
  `xml` text NOT NULL,
  `isSync` int(1) unsigned NOT NULL,
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_chapter_tata` */

DROP TABLE IF EXISTS `content_chapter_tata`;

CREATE TABLE `content_chapter_tata` (
  `bookId` varchar(60) NOT NULL,
  `chapterId` varchar(60) NOT NULL,
  `title` varchar(250) NOT NULL,
  `xml` text NOT NULL,
  PRIMARY KEY (`chapterId`,`bookId`) USING BTREE,
  KEY `Index_BOOKID` (`bookId`) USING BTREE,
  KEY `CCT_BookIndex` (`bookId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_gallery_custom` */

DROP TABLE IF EXISTS `content_gallery_custom`;

CREATE TABLE `content_gallery_custom` (
  `assetId` varchar(60) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `category_1` varchar(450) NOT NULL,
  `category_2` varchar(450) NOT NULL,
  `category_3` varchar(450) DEFAULT NULL,
  `category_4` varchar(450) DEFAULT NULL,
  `category_5` varchar(450) DEFAULT NULL,
  `lastUpdatedOn` datetime NOT NULL,
  `isShared` int(1) unsigned DEFAULT NULL,
  `isSync` int(1) unsigned NOT NULL,
  `title` varchar(255) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`assetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_gallery_tata` */

DROP TABLE IF EXISTS `content_gallery_tata`;

CREATE TABLE `content_gallery_tata` (
  `assetId` varchar(60) NOT NULL,
  `category_1` varchar(450) NOT NULL,
  `category_2` varchar(450) DEFAULT NULL,
  `category_3` varchar(450) DEFAULT NULL,
  `category_4` varchar(450) DEFAULT NULL,
  `category_5` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`assetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_gamecontent_custom` */

DROP TABLE IF EXISTS `content_gamecontent_custom`;

CREATE TABLE `content_gamecontent_custom` (
  `gameContentId` varchar(60) NOT NULL,
  `gameTemplateId` varchar(60) NOT NULL,
  `subjectId` varchar(60) NOT NULL,
  `topicId` varchar(60) NOT NULL,
  `category` varchar(60) DEFAULT NULL,
  `title` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `version` varchar(5) DEFAULT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `isDraft` int(1) unsigned NOT NULL,
  `isShared` int(1) unsigned NOT NULL,
  `keywords` varchar(512) DEFAULT NULL,
  `isSync` int(1) unsigned NOT NULL,
  PRIMARY KEY (`gameContentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_gamecontent_tata` */

DROP TABLE IF EXISTS `content_gamecontent_tata`;

CREATE TABLE `content_gamecontent_tata` (
  `gameContentId` varchar(60) NOT NULL,
  `gameTemplateId` varchar(60) NOT NULL,
  `subjectId` varchar(60) NOT NULL,
  `topicId` varchar(60) NOT NULL,
  `category` varchar(60) DEFAULT NULL,
  `title` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `version` varchar(5) DEFAULT NULL,
  `keywords` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`gameContentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_gametemplate_tata` */

DROP TABLE IF EXISTS `content_gametemplate_tata`;

CREATE TABLE `content_gametemplate_tata` (
  `gameTemplateId` varchar(60) NOT NULL,
  `launchFile` varchar(45) NOT NULL,
  `authorFile` varchar(45) NOT NULL,
  `active` int(1) unsigned NOT NULL,
  PRIMARY KEY (`gameTemplateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_gametopic` */

DROP TABLE IF EXISTS `content_gametopic`;

CREATE TABLE `content_gametopic` (
  `topicId` varchar(60) NOT NULL,
  `title` varchar(250) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_map` */

DROP TABLE IF EXISTS `content_map`;

CREATE TABLE `content_map` (
  `mapId` varchar(75) NOT NULL,
  `organizationId` varchar(15) NOT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `bookid` varchar(45) NOT NULL,
  `assetId` varchar(45) NOT NULL,
  `status` varchar(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`mapId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_question_custom` */

DROP TABLE IF EXISTS `content_question_custom`;

CREATE TABLE `content_question_custom` (
  `questionId` varchar(60) NOT NULL,
  `chapterId` varchar(60) NOT NULL,
  `tpId` varchar(60) DEFAULT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `isDraft` int(1) NOT NULL,
  `isShared` int(1) unsigned NOT NULL,
  `keywords` varchar(512) NOT NULL,
  `isSync` int(1) unsigned NOT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_question_data` */

DROP TABLE IF EXISTS `content_question_data`;

CREATE TABLE `content_question_data` (
  `questionId` varchar(100) NOT NULL,
  `xml` text NOT NULL,
  `q_json` text,
  `q_status` bit(1) DEFAULT b'0',
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_question_tata` */

DROP TABLE IF EXISTS `content_question_tata`;

CREATE TABLE `content_question_tata` (
  `questionId` varchar(45) NOT NULL,
  `tpId` varchar(45) NOT NULL,
  `lcmsSubjectId` varchar(45) NOT NULL,
  `lcmsGradeId` varchar(45) NOT NULL,
  `keywords` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`questionId`),
  KEY `Index_tpId` (`tpId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_tp_custom` */

DROP TABLE IF EXISTS `content_tp_custom`;

CREATE TABLE `content_tp_custom` (
  `tpId` varchar(60) NOT NULL,
  `title` varchar(250) NOT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `isDraft` int(1) unsigned NOT NULL,
  `isShared` int(1) unsigned NOT NULL,
  `keywords` varchar(512) NOT NULL,
  `isSync` int(1) unsigned NOT NULL,
  `chapterId` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`tpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `content_tp_tata` */

DROP TABLE IF EXISTS `content_tp_tata`;

CREATE TABLE `content_tp_tata` (
  `tpId` varchar(45) NOT NULL,
  `title` varchar(250) NOT NULL,
  `lcmsSubjectId` varchar(45) NOT NULL,
  `lcmsGradeId` varchar(45) NOT NULL,
  `keywords` varchar(512) DEFAULT NULL,
  `jsonstatus` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`tpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `curriculum_book` */

DROP TABLE IF EXISTS `curriculum_book`;

CREATE TABLE `curriculum_book` (
  `curriculumId` varchar(45) NOT NULL,
  `levelId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `bookId` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`curriculumId`,`levelId`,`subjectId`,`bookId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `curriculum_grade` */

DROP TABLE IF EXISTS `curriculum_grade`;

CREATE TABLE `curriculum_grade` (
  `gradeId` varchar(45) NOT NULL,
  `title` varchar(100) NOT NULL,
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`gradeId`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `curriculum_language` */

DROP TABLE IF EXISTS `curriculum_language`;

CREATE TABLE `curriculum_language` (
  `lanUId` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` varchar(2) NOT NULL,
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`lanUId`),
  UNIQUE KEY `languagename` (`name`) USING BTREE,
  UNIQUE KEY `languagecode` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `curriculum_level` */

DROP TABLE IF EXISTS `curriculum_level`;

CREATE TABLE `curriculum_level` (
  `levelId` varchar(45) NOT NULL,
  `title` varchar(100) NOT NULL,
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`levelId`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `curriculum_subject` */

DROP TABLE IF EXISTS `curriculum_subject`;

CREATE TABLE `curriculum_subject` (
  `subjectId` varchar(45) NOT NULL,
  `title` varchar(100) NOT NULL,
  `status` varchar(1) NOT NULL,
  `mapping` varchar(45) NOT NULL,
  `hasGames` varchar(1) NOT NULL,
  PRIMARY KEY (`subjectId`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `custom_resource` */

DROP TABLE IF EXISTS `custom_resource`;

CREATE TABLE `custom_resource` (
  `res_id` varchar(255) CHARACTER SET latin1 NOT NULL,
  `org_id` varchar(255) CHARACTER SET latin1 NOT NULL,
  `owner_id` varchar(255) CHARACTER SET latin1 NOT NULL,
  `shared` int(11) NOT NULL,
  `status` bit(1) DEFAULT b'1',
  `name` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `keywords` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`res_id`),
  KEY `user_id` (`owner_id`),
  KEY `org_id` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `encryption_keys` */

DROP TABLE IF EXISTS `encryption_keys`;

CREATE TABLE `encryption_keys` (
  `secret` varchar(100) DEFAULT NULL,
  `salt_hex` varchar(100) DEFAULT NULL,
  `iv_hex` varchar(100) NOT NULL,
  `key_hex` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `neta` */

DROP TABLE IF EXISTS `neta`;

CREATE TABLE `neta` (
  `col1` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `neta2` */

DROP TABLE IF EXISTS `neta2`;

CREATE TABLE `neta2` (
  `col1` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `neta3` */

DROP TABLE IF EXISTS `neta3`;

CREATE TABLE `neta3` (
  `col1` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `resource_rating` */

DROP TABLE IF EXISTS `resource_rating`;

CREATE TABLE `resource_rating` (
  `organizationId` varchar(20) NOT NULL,
  `resourceId` varchar(60) NOT NULL,
  `resourceType` varchar(45) NOT NULL,
  `lastUpdatedOn` datetime NOT NULL,
  `pointratings` text,
  `rating` varchar(10) NOT NULL,
  `totalRatings` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`resourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `resource_user_rating` */

DROP TABLE IF EXISTS `resource_user_rating`;

CREATE TABLE `resource_user_rating` (
  `userId` varchar(60) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `resourceId` varchar(60) NOT NULL,
  `resourceType` varchar(45) NOT NULL,
  `lastUpdatedOn` datetime NOT NULL,
  `comment` text,
  `rating` int(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `organization_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`,`resourceId`,`resourceType`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `rules_content_providers` */

DROP TABLE IF EXISTS `rules_content_providers`;

CREATE TABLE `rules_content_providers` (
  `providerId` varchar(45) NOT NULL,
  `providerTitle` varchar(250) NOT NULL,
  `licenseStartDate` date DEFAULT NULL,
  `licenseEndDate` date DEFAULT NULL,
  `licenseStatus` int(1) unsigned DEFAULT NULL,
  `licenseType` varchar(45) NOT NULL,
  PRIMARY KEY (`providerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school` */

DROP TABLE IF EXISTS `school`;

CREATE TABLE `school` (
  `schoolid` varchar(16) NOT NULL,
  `name` varchar(75) NOT NULL,
  `status` int(1) unsigned NOT NULL,
  `registrationstatus` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `boardid` varchar(45) NOT NULL,
  `deliverymodel` varchar(45) NOT NULL,
  `cuid` varchar(45) NOT NULL,
  `lastSyncOn` varchar(45) NOT NULL,
  `licencetype` int(1) unsigned NOT NULL,
  `noofterminals` varchar(10) NOT NULL DEFAULT '0,0',
  `customerid` varchar(4000) DEFAULT NULL,
  `agreementno` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`schoolid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_academic_grades` */

DROP TABLE IF EXISTS `school_academic_grades`;

CREATE TABLE `school_academic_grades` (
  `academicyearid` varchar(75) NOT NULL,
  `schoolgradeid` varchar(45) NOT NULL,
  `gradename` varchar(45) NOT NULL,
  `classedgegradeid` varchar(45) NOT NULL,
  `orderno` int(5) unsigned NOT NULL,
  `divisions` int(5) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_academic_year` */

DROP TABLE IF EXISTS `school_academic_year`;

CREATE TABLE `school_academic_year` (
  `academicyearid` varchar(75) NOT NULL,
  `schoolid` varchar(16) NOT NULL,
  `academicyear` varchar(45) NOT NULL,
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL,
  `remarks` varchar(1000) NOT NULL,
  `status` int(1) unsigned NOT NULL,
  `isdefault` int(1) unsigned NOT NULL DEFAULT '0',
  `issynced` int(1) unsigned NOT NULL,
  PRIMARY KEY (`academicyearid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_access_modules` */

DROP TABLE IF EXISTS `school_access_modules`;

CREATE TABLE `school_access_modules` (
  `moduleid` int(10) unsigned NOT NULL,
  `schoolid` varchar(16) NOT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_access_modules_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_class_students` */

DROP TABLE IF EXISTS `school_class_students`;

CREATE TABLE `school_class_students` (
  `schoolclassid` varchar(75) NOT NULL,
  `schoolid` varchar(16) NOT NULL,
  `classstudentid` varchar(75) NOT NULL,
  `rolenumber` int(10) NOT NULL,
  KEY `schoolclassid` (`schoolclassid`),
  CONSTRAINT `school_class_students_ibfk_1` FOREIGN KEY (`schoolclassid`) REFERENCES `school_classes` (`schoolclassid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_class_subjects` */

DROP TABLE IF EXISTS `school_class_subjects`;

CREATE TABLE `school_class_subjects` (
  `academicyearid` varchar(75) NOT NULL,
  `schoolgradeid` varchar(45) NOT NULL,
  `schoolid` varchar(16) NOT NULL,
  `subjectid` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_class_subjects_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_class_teachers` */

DROP TABLE IF EXISTS `school_class_teachers`;

CREATE TABLE `school_class_teachers` (
  `schoolclassid` varchar(75) NOT NULL,
  `schoolid` varchar(16) NOT NULL,
  `subUId` varchar(45) NOT NULL,
  `classteacherid` varchar(75) NOT NULL,
  KEY `schoolclassid` (`schoolclassid`),
  CONSTRAINT `school_class_teachers_ibfk_1` FOREIGN KEY (`schoolclassid`) REFERENCES `school_classes` (`schoolclassid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_classes` */

DROP TABLE IF EXISTS `school_classes`;

CREATE TABLE `school_classes` (
  `schoolclassid` varchar(75) NOT NULL,
  `schoolid` varchar(16) NOT NULL,
  `schoolgradeid` varchar(45) NOT NULL,
  `divisionno` int(1) NOT NULL,
  `academicyearid` varchar(75) NOT NULL,
  `classteacherid` varchar(75) NOT NULL,
  PRIMARY KEY (`schoolclassid`),
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_classes_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_details` */

DROP TABLE IF EXISTS `school_details`;

CREATE TABLE `school_details` (
  `schoolid` varchar(16) NOT NULL,
  `startdate` varchar(45) NOT NULL,
  `enddate` varchar(45) NOT NULL,
  `pincode` varchar(45) NOT NULL,
  `contactperson` varchar(45) NOT NULL,
  `contactnumber` varchar(45) NOT NULL,
  `remarks` varchar(1000) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `startTime` varchar(45) DEFAULT NULL,
  `endTime` varchar(45) DEFAULT NULL,
  `daysOfweek` varchar(75) DEFAULT NULL,
  `periodDuration` varchar(45) DEFAULT NULL,
  `break` text,
  `extraSettings` varchar(4000) DEFAULT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_details_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_divisions` */

DROP TABLE IF EXISTS `school_divisions`;

CREATE TABLE `school_divisions` (
  `schoolid` varchar(16) NOT NULL,
  `divisionno` int(1) unsigned NOT NULL,
  `divisionrefname` varchar(45) NOT NULL,
  `classedgegradeid` varchar(45) NOT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_divisions_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_grade_subjects` */

DROP TABLE IF EXISTS `school_grade_subjects`;

CREATE TABLE `school_grade_subjects` (
  `schoolid` varchar(16) NOT NULL,
  `subjectid` varchar(45) NOT NULL,
  `schoolgradeid` varchar(45) NOT NULL,
  KEY `SGS_Grade_IDX` (`schoolid`,`schoolgradeid`) USING BTREE,
  CONSTRAINT `school_grade_subjects_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_grades` */

DROP TABLE IF EXISTS `school_grades`;

CREATE TABLE `school_grades` (
  `schoolid` varchar(16) NOT NULL,
  `classedgegradeid` varchar(45) NOT NULL,
  `gradename` varchar(45) NOT NULL,
  `divisions` int(1) unsigned NOT NULL,
  `schoolgradeid` varchar(45) NOT NULL,
  `orderno` int(5) unsigned NOT NULL,
  `categoryid` varchar(45) DEFAULT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_grades_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_language` */

DROP TABLE IF EXISTS `school_language`;

CREATE TABLE `school_language` (
  `schoolid` varchar(16) NOT NULL,
  `lanUId` varchar(45) NOT NULL,
  `orderBy` int(1) unsigned NOT NULL,
  PRIMARY KEY (`schoolid`,`lanUId`) USING BTREE,
  CONSTRAINT `school_language_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_last_sync` */

DROP TABLE IF EXISTS `school_last_sync`;

CREATE TABLE `school_last_sync` (
  `schoolid` varchar(16) NOT NULL,
  `lastsyncOn` datetime NOT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_last_sync_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_licence` */

DROP TABLE IF EXISTS `school_licence`;

CREATE TABLE `school_licence` (
  `schoolid` varchar(16) NOT NULL,
  `key1` varchar(1000) NOT NULL,
  `key2` varchar(1000) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `notes` varchar(1000) DEFAULT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_licence_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_managers` */

DROP TABLE IF EXISTS `school_managers`;

CREATE TABLE `school_managers` (
  `schoolid` varchar(16) NOT NULL,
  `users` longtext NOT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_managers_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_permissions` */

DROP TABLE IF EXISTS `school_permissions`;

CREATE TABLE `school_permissions` (
  `userId` varchar(75) NOT NULL,
  `resourceId` varchar(75) NOT NULL,
  `schoolId` varchar(45) NOT NULL,
  `resourcetype` varchar(10) NOT NULL,
  PRIMARY KEY (`userId`,`resourceId`,`schoolId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_role_access` */

DROP TABLE IF EXISTS `school_role_access`;

CREATE TABLE `school_role_access` (
  `role` varchar(75) NOT NULL,
  `schoolid` varchar(16) NOT NULL,
  `moduleid` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_subjects` */

DROP TABLE IF EXISTS `school_subjects`;

CREATE TABLE `school_subjects` (
  `schoolid` varchar(16) NOT NULL,
  `subjectid` varchar(45) NOT NULL,
  `specificto` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  KEY `schoolid` (`schoolid`),
  CONSTRAINT `school_subjects_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_sync` */

DROP TABLE IF EXISTS `school_sync`;

CREATE TABLE `school_sync` (
  `schoolid` varchar(16) NOT NULL,
  `type` varchar(75) NOT NULL,
  `issynced` int(1) unsigned NOT NULL,
  PRIMARY KEY (`schoolid`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_terminals` */

DROP TABLE IF EXISTS `school_terminals`;

CREATE TABLE `school_terminals` (
  `schoolid` varchar(16) NOT NULL,
  `terminalkey` varchar(45) NOT NULL,
  `terminaltype` varchar(45) NOT NULL,
  `location` varchar(512) NOT NULL,
  PRIMARY KEY (`schoolid`,`terminalkey`) USING BTREE,
  CONSTRAINT `school_terminals_ibfk_1` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `school_usage_days` */

DROP TABLE IF EXISTS `school_usage_days`;

CREATE TABLE `school_usage_days` (
  `schoolId` varchar(16) NOT NULL,
  `reportDate` varchar(25) NOT NULL,
  `days` int(4) unsigned DEFAULT NULL,
  `history` text,
  `status` int(1) unsigned NOT NULL,
  PRIMARY KEY (`schoolId`,`reportDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `toolimg_mapping_subject` */

DROP TABLE IF EXISTS `toolimg_mapping_subject`;

CREATE TABLE `toolimg_mapping_subject` (
  `toolimgid` varchar(45) NOT NULL,
  `subjectid` varchar(45) NOT NULL,
  PRIMARY KEY (`toolimgid`,`subjectid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `toolimg_mapping_tp` */

DROP TABLE IF EXISTS `toolimg_mapping_tp`;

CREATE TABLE `toolimg_mapping_tp` (
  `toolimgid` varchar(45) NOT NULL,
  `mappingtps` varchar(45) NOT NULL,
  PRIMARY KEY (`toolimgid`,`mappingtps`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `toolrepo` */

DROP TABLE IF EXISTS `toolrepo`;

CREATE TABLE `toolrepo` (
  `toolUid` varchar(45) NOT NULL,
  `toolName` varchar(250) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `strand` varchar(250) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `launchPage` varchar(125) NOT NULL,
  PRIMARY KEY (`toolUid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ugenerated_mylibrary` */

DROP TABLE IF EXISTS `ugenerated_mylibrary`;

CREATE TABLE `ugenerated_mylibrary` (
  `userId` varchar(60) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `assetId` varchar(60) NOT NULL,
  `typeId` varchar(45) NOT NULL,
  `language` varchar(20) DEFAULT NULL,
  `isSync` int(1) unsigned NOT NULL,
  `addedOn` datetime NOT NULL,
  PRIMARY KEY (`userId`,`assetId`,`typeId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ugenerated_notes` */

DROP TABLE IF EXISTS `ugenerated_notes`;

CREATE TABLE `ugenerated_notes` (
  `noteId` varchar(60) NOT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `chapterId` varchar(60) NOT NULL,
  `tpId` varchar(60) DEFAULT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `xml` text NOT NULL,
  `lastUpdatedOn` datetime NOT NULL,
  `isDraft` int(1) unsigned DEFAULT NULL,
  `isShared` int(1) unsigned DEFAULT NULL,
  `isSync` int(1) unsigned NOT NULL,
  PRIMARY KEY (`noteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ugenerated_presentation` */

DROP TABLE IF EXISTS `ugenerated_presentation`;

CREATE TABLE `ugenerated_presentation` (
  `presentationId` varchar(60) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `isDraft` int(1) unsigned NOT NULL,
  `isShared` int(1) unsigned NOT NULL,
  `keywords` varchar(512) NOT NULL,
  `isSync` int(1) unsigned NOT NULL,
  PRIMARY KEY (`presentationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ugenerated_presentation_chapters` */

DROP TABLE IF EXISTS `ugenerated_presentation_chapters`;

CREATE TABLE `ugenerated_presentation_chapters` (
  `presentationId` varchar(60) NOT NULL,
  `chapterId` varchar(60) NOT NULL,
  `tpId` varchar(60) DEFAULT NULL,
  `gradeId` varchar(60) NOT NULL,
  `subjectId` varchar(60) NOT NULL,
  `lastUpdatedOn` datetime NOT NULL,
  PRIMARY KEY (`presentationId`,`chapterId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ugenerated_presentation_data` */

DROP TABLE IF EXISTS `ugenerated_presentation_data`;

CREATE TABLE `ugenerated_presentation_data` (
  `presentationId` varchar(60) NOT NULL,
  `xml` text NOT NULL,
  PRIMARY KEY (`presentationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ugenerated_userbookmark` */

DROP TABLE IF EXISTS `ugenerated_userbookmark`;

CREATE TABLE `ugenerated_userbookmark` (
  `userId` varchar(60) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `data` text NOT NULL,
  `lastUpdatedOn` datetime NOT NULL,
  PRIMARY KEY (`userId`,`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ugenerated_whiteboard` */

DROP TABLE IF EXISTS `ugenerated_whiteboard`;

CREATE TABLE `ugenerated_whiteboard` (
  `cwbId` varchar(60) NOT NULL,
  `wbTitle` varchar(250) NOT NULL,
  `organizationId` varchar(20) NOT NULL,
  `userId` varchar(60) NOT NULL,
  `gradeId` varchar(45) NOT NULL,
  `subjectId` varchar(45) NOT NULL,
  `chapterId` varchar(60) NOT NULL,
  `tpId` varchar(60) DEFAULT NULL,
  `lastUpdatedOn` datetime NOT NULL,
  `isShared` int(1) unsigned DEFAULT NULL,
  `isSync` int(1) unsigned NOT NULL,
  `hasVideo` int(1) unsigned DEFAULT NULL,
  `videolastUpdatedOn` datetime DEFAULT NULL,
  `videoisShared` int(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`cwbId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_badges` */

DROP TABLE IF EXISTS `user_badges`;

CREATE TABLE `user_badges` (
  `userId` varchar(60) NOT NULL DEFAULT '',
  `badgeId` int(10) DEFAULT NULL,
  `organizationId` varchar(20) DEFAULT NULL,
  `badgeTitle` varchar(100) DEFAULT NULL,
  `points` int(10) DEFAULT NULL,
  `upgradedOn` datetime DEFAULT NULL,
  `isSync` int(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_badges_points` */

DROP TABLE IF EXISTS `user_badges_points`;

CREATE TABLE `user_badges_points` (
  `id` varchar(80) NOT NULL DEFAULT '',
  `userId` varchar(60) DEFAULT NULL,
  `pointConfigId` int(10) DEFAULT NULL,
  `configType` varchar(100) DEFAULT NULL,
  `creditedOn` datetime DEFAULT NULL,
  `points` int(4) DEFAULT NULL,
  `logId` varchar(60) DEFAULT NULL,
  `resourceid` varchar(60) DEFAULT NULL,
  `resourcetype` varchar(45) DEFAULT NULL,
  `sessionId` varchar(60) DEFAULT NULL,
  `gradeId` varchar(45) DEFAULT NULL,
  `subjectId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
