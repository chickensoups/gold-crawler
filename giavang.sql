/*
SQLyog Enterprise - MySQL GUI v8.12 
MySQL - 5.0.67-community-nt : Database - giavang
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`giavang` /*!40100 DEFAULT CHARACTER SET ascii */;

USE `giavang`;

/*Table structure for table `giadauthegioi` */

DROP TABLE IF EXISTS `giadauthegioi`;

CREATE TABLE `giadauthegioi` (
  `id` int(5) NOT NULL auto_increment,
  `giamua` char(25) default NULL,
  `giaban` char(25) default NULL,
  `loaidau` char(255) default NULL,
  `thoigian` datetime default NULL,
  `tochuc` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `giangoaihoithegioi` */

DROP TABLE IF EXISTS `giangoaihoithegioi`;

CREATE TABLE `giangoaihoithegioi` (
  `id` int(5) NOT NULL auto_increment,
  `giamua` char(25) default NULL,
  `giaban` char(25) default NULL,
  `loaingoaite` char(25) default NULL,
  `thoigian` datetime default NULL,
  `tochuc` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `giangoaitevn` */

DROP TABLE IF EXISTS `giangoaitevn`;

CREATE TABLE `giangoaitevn` (
  `id` int(5) NOT NULL auto_increment,
  `giamua` char(25) default NULL,
  `giaban` char(25) default NULL,
  `loaingoaite` char(25) default NULL,
  `thoigian` datetime default NULL,
  `tochuc` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `giavangthegioi` */

DROP TABLE IF EXISTS `giavangthegioi`;

CREATE TABLE `giavangthegioi` (
  `id` int(5) NOT NULL auto_increment,
  `giamua` char(25) default NULL,
  `giaban` char(25) default NULL,
  `thoigian` datetime default NULL,
  `tochuc` char(25) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `giavangvn` */

DROP TABLE IF EXISTS `giavangvn`;

CREATE TABLE `giavangvn` (
  `id` int(5) NOT NULL auto_increment,
  `giamua` char(25) default NULL,
  `giaban` char(25) default NULL,
  `loaivang` char(255) default NULL,
  `thoigian` datetime default NULL,
  `tochuc` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `gold_dojihn` */

DROP TABLE IF EXISTS `gold_dojihn`;

CREATE TABLE `gold_dojihn` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `gold_dojihcm` */

DROP TABLE IF EXISTS `gold_dojihcm`;

CREATE TABLE `gold_dojihcm` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `gold_dongabank` */

DROP TABLE IF EXISTS `gold_dongabank`;

CREATE TABLE `gold_dongabank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `gold_sjchn` */

DROP TABLE IF EXISTS `gold_sjchn`;

CREATE TABLE `gold_sjchn` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `gold_sjctphcm` */

DROP TABLE IF EXISTS `gold_sjchcm`;

CREATE TABLE `gold_sjchcm` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `gold_sjcdn` */

DROP TABLE IF EXISTS `gold_sjcdn`;

CREATE TABLE `gold_sjcdn` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `gold_techcombank` */

DROP TABLE IF EXISTS `gold_techcombank`;

CREATE TABLE `gold_techcombank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `gold_tpbank` */

DROP TABLE IF EXISTS `gold_tpbank`;

CREATE TABLE `gold_tpbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `gold_vietinbank` */

DROP TABLE IF EXISTS `gold_vietinbank`;

CREATE TABLE `gold_vietinbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

/*Table structure for table `money_abbank` */

DROP TABLE IF EXISTS `money_abbank`;

CREATE TABLE `money_abbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_acb` */

DROP TABLE IF EXISTS `money_acb`;

CREATE TABLE `money_acb` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_agribank` */

DROP TABLE IF EXISTS `money_agribank`;

CREATE TABLE `money_agribank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_bacabank` */

DROP TABLE IF EXISTS `money_bacabank`;

CREATE TABLE `money_bacabank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_baovietbank` */

DROP TABLE IF EXISTS `money_baovietbank`;

CREATE TABLE `money_baovietbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_bidv` */

DROP TABLE IF EXISTS `money_bidv`;

CREATE TABLE `money_bidv` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_cbbank` */

DROP TABLE IF EXISTS `money_cbbank`;

CREATE TABLE `money_cbbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_dongabank` */

DROP TABLE IF EXISTS `money_dongabank`;

CREATE TABLE `money_dongabank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_eximbank` */

DROP TABLE IF EXISTS `money_eximbank`;

CREATE TABLE `money_eximbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) character set utf8 collate utf8_unicode_ci default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=ascii;

/*Table structure for table `money_gpbank` */

DROP TABLE IF EXISTS `money_gpbank`;

CREATE TABLE `money_gpbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_hdbank` */

DROP TABLE IF EXISTS `money_hdbank`;

CREATE TABLE `money_hdbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_kienlongbank` */

DROP TABLE IF EXISTS `money_kienlongbank`;

CREATE TABLE `money_kienlongbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_lienvietpostbank` */

DROP TABLE IF EXISTS `money_lienvietpostbank`;

CREATE TABLE `money_lienvietpostbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_maritimebank` */

DROP TABLE IF EXISTS `money_maritimebank`;

CREATE TABLE `money_maritimebank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_mbbank` */

DROP TABLE IF EXISTS `money_mbbank`;

CREATE TABLE `money_mbbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_namabank` */

DROP TABLE IF EXISTS `money_namabank`;

CREATE TABLE `money_namabank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_nationalcitizenbank` */

DROP TABLE IF EXISTS `money_nationalcitizenbank`;

CREATE TABLE `money_nationalcitizenbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_oceanbank` */

DROP TABLE IF EXISTS `money_oceanbank`;

CREATE TABLE `money_oceanbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_orientcommercialbank` */

DROP TABLE IF EXISTS `money_orientcommercialbank`;

CREATE TABLE `money_orientcommercialbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_pgbank` */

DROP TABLE IF EXISTS `money_pgbank`;

CREATE TABLE `money_pgbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_pvcombank` */

DROP TABLE IF EXISTS `money_pvcombank`;

CREATE TABLE `money_pvcombank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_sacombank` */

DROP TABLE IF EXISTS `money_sacombank`;

CREATE TABLE `money_sacombank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_scb` */

DROP TABLE IF EXISTS `money_scb`;

CREATE TABLE `money_scb` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_seabank` */

DROP TABLE IF EXISTS `money_seabank`;

CREATE TABLE `money_seabank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_sgb` */

DROP TABLE IF EXISTS `money_sgb`;

CREATE TABLE `money_sgb` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_shb` */

DROP TABLE IF EXISTS `money_shb`;

CREATE TABLE `money_shb` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_techcombank` */

DROP TABLE IF EXISTS `money_techcombank`;

CREATE TABLE `money_techcombank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_tpbank` */

DROP TABLE IF EXISTS `money_tpbank`;

CREATE TABLE `money_tpbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_vccbank` */

DROP TABLE IF EXISTS `money_vccbank`;

CREATE TABLE `money_vccbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_vibbank` */

DROP TABLE IF EXISTS `money_vibbank`;

CREATE TABLE `money_vibbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_vietabank` */

DROP TABLE IF EXISTS `money_vietabank`;

CREATE TABLE `money_vietabank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_vietbank` */

DROP TABLE IF EXISTS `money_vietbank`;

CREATE TABLE `money_vietbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `money_vietcombank` */

DROP TABLE IF EXISTS `money_vietcombank`;

CREATE TABLE `money_vietcombank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) character set utf8 collate utf8_unicode_ci default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=ascii;

/*Table structure for table `money_vietinbank` */

DROP TABLE IF EXISTS `money_vietinbank`;

CREATE TABLE `money_vietinbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) character set utf8 collate utf8_unicode_ci default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=ascii;

/*Table structure for table `money_vpbank` */

DROP TABLE IF EXISTS `money_vpbank`;

CREATE TABLE `money_vpbank` (
  `id` int(1) NOT NULL auto_increment,
  `buy` char(255) default NULL,
  `sell` char(255) default NULL,
  `currency` char(255) default NULL,
  `date` datetime default NULL,
  `transfer` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

/*Table structure for table `tochuc` */

DROP TABLE IF EXISTS `tochuc`;

CREATE TABLE `tochuc` (
  `id` int(1) unsigned zerofill NOT NULL auto_increment,
  `id_tochuc` int(4) NOT NULL,
  `ten_tochuc` char(255) character set utf8 collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=ascii;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
