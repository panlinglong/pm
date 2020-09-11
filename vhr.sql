/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.31 : Database - vhr
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vhr` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vhr`;

/*Table structure for table `chuzu` */

DROP TABLE IF EXISTS `chuzu`;

CREATE TABLE `chuzu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房源id',
  `name` varchar(10) DEFAULT NULL COMMENT '小区名称',
  `fangs` varchar(10) DEFAULT NULL COMMENT '付款方式',
  `endDate` date DEFAULT NULL COMMENT '到期时间',
  `idCard` varchar(50) DEFAULT NULL COMMENT '房号',
  `email` varchar(20) DEFAULT NULL COMMENT '面积',
  `people` varchar(20) DEFAULT NULL COMMENT '接待人',
  `beginDate` date DEFAULT NULL COMMENT '起租时间',
  `workid` char(8) DEFAULT NULL COMMENT '编号',
  `reno` char(4) DEFAULT NULL COMMENT '装修毛坯',
  `price` varchar(20) DEFAULT NULL COMMENT '租金',
  `car` varchar(10) DEFAULT NULL COMMENT '车库车位',
  `looktime` varchar(50) DEFAULT NULL COMMENT '看房时间',
  `intr` char(4) DEFAULT NULL COMMENT '上门介绍',
  `phone2` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `xuequ` varchar(40) DEFAULT NULL COMMENT '学区',
  `jsjt1` varchar(10) DEFAULT NULL COMMENT '几室',
  `jsjt2` varchar(10) DEFAULT NULL COMMENT '几厅',
  `jsjt3` varchar(10) DEFAULT NULL COMMENT '几卫',
  `xingz` varchar(100) DEFAULT NULL COMMENT '房源性质',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `workID_key` (`workid`)
) ENGINE=InnoDB AUTO_INCREMENT=1950 DEFAULT CHARSET=utf8;

/*Data for the table `chuzu` */

insert  into `chuzu`(`id`,`name`,`fangs`,`endDate`,`idCard`,`email`,`people`,`beginDate`,`workid`,`reno`,`price`,`car`,`looktime`,`intr`,`phone2`,`xuequ`,`jsjt1`,`jsjt2`,`jsjt3`,`xingz`,`remarks`) values (1,'恒大名都','现金','2020-11-06','1-1-501','105','张三','2020-09-06','10000001','装修','1800/月','20','周末','上门','13599999999','xx中学','3室','2厅','1卫','未出租','公司房源'),(1948,'测试','银行卡',NULL,'1-1-1001','120','测试',NULL,'10000002','毛坯','200','12','下午','介绍','15888888888',NULL,'3室','2厅','1卫','未出租',NULL),(1949,'三港嘉苑','支付宝',NULL,'76-1-1802','110','李四',NULL,'10000003','装修','110','10','周末上午','上门','15388888888',NULL,'3室','2厅','1卫','未出租',NULL);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `parentId` int(11) DEFAULT NULL,
  `depPath` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `isParent` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`name`,`parentId`,`depPath`,`enabled`,`isParent`) values (1,'股东会',-1,'.1',1,1),(4,'董事会',1,'.1.4',1,1),(5,'总办',4,'.1.4.5',1,1),(8,'财务部',5,'.1.4.5.8',1,0),(78,'市场部',5,'.1.4.5.78',1,0),(91,'技术部',5,'.1.4.5.91',1,0),(92,'运维部',5,'.1.4.5.92',1,0);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房源id',
  `name` varchar(10) DEFAULT NULL COMMENT '小区名称',
  `gender` char(4) DEFAULT NULL COMMENT '是否满二',
  `birthday` date DEFAULT NULL COMMENT '/',
  `idCard` varchar(50) DEFAULT NULL COMMENT '房号',
  `email` varchar(20) DEFAULT NULL COMMENT '面积',
  `people` varchar(20) DEFAULT NULL COMMENT '接待人',
  `beginDate` date DEFAULT NULL COMMENT '成交时间',
  `workid` char(8) DEFAULT NULL COMMENT '编号',
  `reno` char(4) DEFAULT NULL COMMENT '装修毛坯',
  `price` varchar(20) DEFAULT NULL COMMENT '价格',
  `car` varchar(10) DEFAULT NULL COMMENT '车库车位',
  `looktime` varchar(50) DEFAULT NULL COMMENT '看房时间',
  `intr` char(4) DEFAULT NULL COMMENT '上门介绍',
  `phone2` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `xuequ` varchar(40) DEFAULT NULL COMMENT '学区',
  `jsjt1` varchar(10) DEFAULT NULL COMMENT '几室',
  `jsjt2` varchar(10) DEFAULT NULL COMMENT '几厅',
  `jsjt3` varchar(10) DEFAULT NULL COMMENT '几卫',
  `xingz` varchar(100) DEFAULT NULL COMMENT '公司/中介',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `workID_key` (`workid`)
) ENGINE=InnoDB AUTO_INCREMENT=1950 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`gender`,`birthday`,`idCard`,`email`,`people`,`beginDate`,`workid`,`reno`,`price`,`car`,`looktime`,`intr`,`phone2`,`xuequ`,`jsjt1`,`jsjt2`,`jsjt3`,`xingz`,`remarks`) values (1,'恒大名都','否','2020-09-03','1-1-501','105','张三','2020-09-07','00000001','装修','180','20','','上门','13599999999','xx中学','3室','2厅','1卫','已出售','公司房源'),(1948,'测试','否',NULL,'1-1-1001','120','测试',NULL,'00000002','毛坯','200','12','下午','介绍','15888888888',NULL,'3室','2厅','1卫','未出售',NULL),(1949,'三港嘉苑','否',NULL,'76-1-1802','110','李四',NULL,'00000003','装修','110','10','周末上午','上门','15388888888',NULL,'3室','2厅','1卫','未出售',NULL);

/*Table structure for table `hr` */

DROP TABLE IF EXISTS `hr`;

CREATE TABLE `hr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `hr` */

insert  into `hr`(`id`,`name`,`phone`,`telephone`,`address`,`enabled`,`username`,`password`,`remark`) values (3,'系统管理员','18568887789','82881234','北京',1,'admin','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',NULL),(5,'光头强','18568123489','82123434','上海',1,'guangtouqiang','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.',NULL),(10,'熊大','18568123666','82111555','杭州',1,'xiongda','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.',NULL),(11,'熊二','18568123377','82111333','杭州',1,'xionger','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.',NULL),(12,'阿童木','18568128888','82111222','广州',1,'atongmu','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.',NULL);

/*Table structure for table `hr_role` */

DROP TABLE IF EXISTS `hr_role`;

CREATE TABLE `hr_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hrid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `hr_role_ibfk_1` (`hrid`),
  CONSTRAINT `hr_role_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE CASCADE,
  CONSTRAINT `hr_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;

/*Data for the table `hr_role` */

insert  into `hr_role`(`id`,`hrid`,`rid`) values (101,3,6),(173,11,1),(179,12,2),(180,10,1),(181,5,3);

/*Table structure for table `joblevel` */

DROP TABLE IF EXISTS `joblevel`;

CREATE TABLE `joblevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职称名称',
  `titleLevel` enum('正高级','副高级','中级','初级','员级') DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `joblevel` */

insert  into `joblevel`(`id`,`name`,`titleLevel`,`createDate`,`enabled`) values (9,'P1','正高级','2018-01-11 00:00:00',1),(10,'P2','副高级','2018-01-11 21:19:20',1),(12,'P3','中级','2018-01-11 21:35:39',1),(13,'P4','初级','2018-01-11 00:00:00',0),(14,'M1','正高级','2018-01-14 00:00:00',1),(15,'M2','副高级','2018-01-14 00:00:00',1),(16,'M3','中级','2018-01-14 16:19:14',1),(17,'M4','初级','2018-01-14 16:19:24',1);

/*Table structure for table `kehu` */

DROP TABLE IF EXISTS `kehu`;

CREATE TABLE `kehu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房源id',
  `name` varchar(10) DEFAULT NULL COMMENT '客户姓名',
  `gender` char(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '/',
  `demand` varchar(100) DEFAULT NULL COMMENT '需求',
  `followup` text COMMENT '跟进',
  `beginDate` date DEFAULT NULL COMMENT '/',
  `kehuid` char(8) DEFAULT NULL COMMENT '编号',
  `phone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `xingz` varchar(10) DEFAULT NULL COMMENT '性质',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `hrid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `workID_key` (`kehuid`),
  KEY `hrid` (`hrid`),
  CONSTRAINT `kehu_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1950 DEFAULT CHARSET=utf8;

/*Data for the table `kehu` */

insert  into `kehu`(`id`,`name`,`gender`,`birthday`,`demand`,`followup`,`beginDate`,`kehuid`,`phone`,`xingz`,`remarks`,`hrid`) values (1,'张三三','男','2020-09-03','120平20000/平，城南','9月5日通过微信联系修改需求为','2020-09-07','40000001','13599999999','上门客户','',12),(1948,'李思思','女',NULL,'长租一套，3w一年','9月7日通过电话约好下周看房时间',NULL,'40000002','15888888888','介绍客户',NULL,10),(1949,'王五五','男',NULL,'某某学区房100平','9月1日XXXXXXXXXXXXXXXXXXXXXXXXXX；\r\n9月2日XXXXXXXXXXXXXXXXXXXXxx',NULL,'40000003','15388888888','上门客户',NULL,5);

/*Table structure for table `kehu_a` */

DROP TABLE IF EXISTS `kehu_a`;

CREATE TABLE `kehu_a` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kehuid` char(8) DEFAULT NULL COMMENT '编号',
  `kfjl` varchar(200) DEFAULT NULL COMMENT '看房记录',
  `kfdate` date DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`),
  KEY `workID_key` (`kehuid`),
  CONSTRAINT `kehu_a_ibfk_2` FOREIGN KEY (`kehuid`) REFERENCES `kehu` (`kehuid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1950 DEFAULT CHARSET=utf8;

/*Data for the table `kehu_a` */

insert  into `kehu_a`(`id`,`kehuid`,`kfjl`,`kfdate`) values (1,'40000001',NULL,NULL),(1948,'40000002',NULL,NULL),(1949,'40000003',NULL,NULL);

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`url`,`path`,`component`,`name`,`iconCls`,`parentId`,`enabled`) values (1,'/',NULL,NULL,'所有',NULL,NULL,1),(2,'/','/home','Home','二手房管理','fa fa-home',1,1),(3,'/','/home','Home','新房管理','fa fa-home',1,1),(4,'/','/home','Home','客户管理','fa fa-user-circle-o',1,1),(6,'/','/home','Home','系统管理','fa fa-windows',1,1),(7,'/employee/basic/**','/emp/basic','EmpBasic','出售房源信息',NULL,2,1),(8,'/employee/chuzu/**','/emp/chuzu','EmpChuzu','出租房源信息',NULL,2,1),(9,'/employee/basic/**','/emp/basic2','EmpBasic2','出售房源',NULL,2,1),(10,'/employee/chuzu/**','/emp/chuzu2','EmpChuzu2','出租房源',NULL,2,1),(11,'/newinfo/basic/**','/new/inf','NewInf','报备管理',NULL,3,1),(12,'/kehu/basic/**','/kehu/baisc','KehuBasic','客户信息',NULL,4,1),(13,'/kehu/allkehu/**','/kehu/allkehu','KehuAll','所有客户信息',NULL,4,1),(14,'/newinfo/basic/**','/new/inf2','NewInf2','报备信息',NULL,3,1),(26,'/system/basic/hr/**','/sys/hr','SysHr','人员管理',NULL,6,1),(32,'/system/basic/role/**','/sys/role','SysRole','权限管理',NULL,6,1);

/*Table structure for table `menu_role` */

DROP TABLE IF EXISTS `menu_role`;

CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `rid` (`rid`),
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=614 DEFAULT CHARSET=utf8;

/*Data for the table `menu_role` */

insert  into `menu_role`(`id`,`mid`,`rid`) values (582,7,1),(583,8,1),(584,11,1),(585,12,1),(590,7,3),(591,8,3),(592,11,3),(593,13,3),(594,26,3),(595,32,3),(596,7,6),(597,8,6),(598,9,6),(599,10,6),(600,11,6),(601,14,6),(602,12,6),(603,13,6),(604,26,6),(605,32,6),(610,9,2),(611,10,2),(612,14,2),(613,12,2);

/*Table structure for table `newinfo` */

DROP TABLE IF EXISTS `newinfo`;

CREATE TABLE `newinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name1` varchar(10) DEFAULT NULL COMMENT '客户名字',
  `dates` date DEFAULT NULL COMMENT '时间',
  `name2` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `mianji` varchar(20) DEFAULT NULL COMMENT '面积',
  `people1` varchar(20) DEFAULT NULL COMMENT '带看人',
  `workid` char(8) DEFAULT NULL COMMENT '编号',
  `people2` varchar(20) DEFAULT NULL COMMENT '对接人',
  `phone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `workID_key` (`workid`)
) ENGINE=InnoDB AUTO_INCREMENT=1951 DEFAULT CHARSET=utf8;

/*Data for the table `newinfo` */

insert  into `newinfo`(`id`,`name1`,`dates`,`name2`,`mianji`,`people1`,`workid`,`people2`,`phone`,`remarks`) values (1,'张一的','2020-08-21','滨江123','105','张三五','20000001','王五','13599999999','少时诵诗书'),(1948,'测试','2020-09-08','玲珑湾213','120','测试','20000002','王宇','15888888888',NULL),(1949,'张二','2020-09-08','！@#￥%……&','110','李四','20000003','王武','15388888888',NULL);

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职位',
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`name`,`createDate`,`enabled`) values (29,'技术总监','2018-01-11 21:13:42',1),(30,'运营总监','2018-01-11 21:13:48',1),(31,'市场总监','2018-01-11 00:00:00',1),(33,'研发工程师','2018-01-14 00:00:00',0),(34,'运维工程师','2018-01-14 16:11:41',1),(36,'Java研发经理','2019-10-01 00:00:00',1),(38,'财务总监','2020-04-09 22:31:08',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`nameZh`) values (1,'ROLE_manager','经理'),(2,'ROLE_personnel','普通员工'),(3,'ROLE_recruiter','管理员'),(6,'ROLE_admin','系统管理员');

/* Procedure structure for procedure `addDep` */

/*!50003 DROP PROCEDURE IF EXISTS  `addDep` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
end */$$
DELIMITER ;

/* Procedure structure for procedure `deleteDep` */

/*!50003 DROP PROCEDURE IF EXISTS  `deleteDep` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  declare a int;
  select count(*) into a from department where id=did and isParent=false;
  if a=0 then set result=-2;
  else
  select count(*) into ecount from employee where departmentId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from department where id=did;
  delete from department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where id=pid;
  end if;
  end if;
  end if;
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
