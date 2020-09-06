/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : vhr

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-08-29 22:10:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
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

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '股东会', '-1', '.1', '1', '1');
INSERT INTO `department` VALUES ('4', '董事会', '1', '.1.4', '1', '1');
INSERT INTO `department` VALUES ('5', '总办', '4', '.1.4.5', '1', '1');
INSERT INTO `department` VALUES ('8', '财务部', '5', '.1.4.5.8', '1', '0');
INSERT INTO `department` VALUES ('78', '市场部', '5', '.1.4.5.78', '1', '0');
INSERT INTO `department` VALUES ('91', '技术部', '5', '.1.4.5.91', '1', '0');
INSERT INTO `department` VALUES ('92', '运维部', '5', '.1.4.5.92', '1', '0');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门',
  `jobLevelId` int(11) DEFAULT NULL COMMENT '职称ID',
  `posId` int(11) DEFAULT NULL COMMENT '职位ID',
  `beginDate` date DEFAULT NULL COMMENT '入职日期',
  `workID` char(8) DEFAULT NULL COMMENT '工号',
  PRIMARY KEY (`id`),
  KEY `departmentId` (`departmentId`),
  KEY `jobId` (`jobLevelId`),
  KEY `dutyId` (`posId`),
  KEY `workID_key` (`workID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`jobLevelId`) REFERENCES `joblevel` (`id`),
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`posId`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1945 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1943', '张三', '男', '1982-01-19', '33032198201193302', '944698296@qq.com', '13657687687', '91', '9', '29', '2020-04-26', '00000001');
INSERT INTO `employee` VALUES ('1944', '李四', '男', '1991-02-05', '320181199102055421', '1827874332@qq.com', '13777127845', '92', '12', '34', '2020-05-05', '00000002');

-- ----------------------------
-- Table structure for `hr`
-- ----------------------------
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

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES ('3', '系统管理员', '18568887789', '82881234', '北京', '1', 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', null);
INSERT INTO `hr` VALUES ('5', '光头强', '18568123489', '82123434', '上海', '1', 'guangtouqiang', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', null);
INSERT INTO `hr` VALUES ('10', '熊大', '18568123666', '82111555', '杭州', '1', 'xiongda', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', null);
INSERT INTO `hr` VALUES ('11', '熊二', '18568123377', '82111333', '杭州', '1', 'xionger', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', null);
INSERT INTO `hr` VALUES ('12', '阿童木', '18568128888', '82111222', '广州', '1', 'atongmu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', null);

-- ----------------------------
-- Table structure for `hr_role`
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_role
-- ----------------------------
INSERT INTO `hr_role` VALUES ('101', '3', '6');
INSERT INTO `hr_role` VALUES ('171', '5', '3');
INSERT INTO `hr_role` VALUES ('172', '10', '1');
INSERT INTO `hr_role` VALUES ('173', '11', '1');
INSERT INTO `hr_role` VALUES ('176', '12', '2');

-- ----------------------------
-- Table structure for `joblevel`
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职称名称',
  `titleLevel` enum('正高级','副高级','中级','初级','员级') DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joblevel
-- ----------------------------
INSERT INTO `joblevel` VALUES ('9', 'P1', '正高级', '2018-01-11 00:00:00', '1');
INSERT INTO `joblevel` VALUES ('10', 'P2', '副高级', '2018-01-11 21:19:20', '1');
INSERT INTO `joblevel` VALUES ('12', 'P3', '中级', '2018-01-11 21:35:39', '1');
INSERT INTO `joblevel` VALUES ('13', 'P4', '初级', '2018-01-11 00:00:00', '0');
INSERT INTO `joblevel` VALUES ('14', 'M1', '正高级', '2018-01-14 00:00:00', '1');
INSERT INTO `joblevel` VALUES ('15', 'M2', '副高级', '2018-01-14 00:00:00', '1');
INSERT INTO `joblevel` VALUES ('16', 'M3', '中级', '2018-01-14 16:19:14', '1');
INSERT INTO `joblevel` VALUES ('17', 'M4', '初级', '2018-01-14 16:19:24', '1');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
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

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/', null, null, '所有', null, null, '1');
INSERT INTO `menu` VALUES ('2', '/', '/home', 'Home', '员工资料', 'fa fa-user-circle-o', '1', '1');
INSERT INTO `menu` VALUES ('6', '/', '/home', 'Home', '系统管理', 'fa fa-windows', '1', '1');
INSERT INTO `menu` VALUES ('7', '/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', null, '2', '1');
INSERT INTO `menu` VALUES ('26', '/system/basic/hr/**', '/sys/hr', 'SysHr', '操作员管理', null, '6', '1');
INSERT INTO `menu` VALUES ('29', '/system/basic/pos/**', '/sys/pos', 'SysPos', '职位管理', null, '6', '1');
INSERT INTO `menu` VALUES ('30', '/system/basic/department/**', '/sys/dep', 'SysDep', '部门管理', null, '6', '1');
INSERT INTO `menu` VALUES ('31', '/system/basic/joblevel/**', '/sys/joblevel', 'SysJobLevel', '职称管理', null, '6', '1');
INSERT INTO `menu` VALUES ('32', '/system/basic/role/**', '/sys/role', 'SysRole', '权限管理', null, '6', '1');

-- ----------------------------
-- Table structure for `menu_role`
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=391 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('358', '7', '6');
INSERT INTO `menu_role` VALUES ('359', '26', '6');
INSERT INTO `menu_role` VALUES ('360', '29', '6');
INSERT INTO `menu_role` VALUES ('361', '30', '6');
INSERT INTO `menu_role` VALUES ('362', '31', '6');
INSERT INTO `menu_role` VALUES ('363', '32', '6');
INSERT INTO `menu_role` VALUES ('386', '7', '1');
INSERT INTO `menu_role` VALUES ('387', '29', '1');
INSERT INTO `menu_role` VALUES ('388', '31', '1');
INSERT INTO `menu_role` VALUES ('389', '7', '2');
INSERT INTO `menu_role` VALUES ('390', '7', '3');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职位',
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('29', '技术总监', '2018-01-11 21:13:42', '1');
INSERT INTO `position` VALUES ('30', '运营总监', '2018-01-11 21:13:48', '1');
INSERT INTO `position` VALUES ('31', '市场总监', '2018-01-11 00:00:00', '1');
INSERT INTO `position` VALUES ('33', '研发工程师', '2018-01-14 00:00:00', '0');
INSERT INTO `position` VALUES ('34', '运维工程师', '2018-01-14 16:11:41', '1');
INSERT INTO `position` VALUES ('36', 'Java研发经理', '2019-10-01 00:00:00', '1');
INSERT INTO `position` VALUES ('38', '财务总监', '2020-04-09 22:31:08', '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_manager', '部门经理');
INSERT INTO `role` VALUES ('2', 'ROLE_personnel', '人事专员');
INSERT INTO `role` VALUES ('3', 'ROLE_recruiter', '招聘主管');
INSERT INTO `role` VALUES ('6', 'ROLE_admin', '系统管理员');

-- ----------------------------
-- Procedure structure for `addDep`
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
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
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `deleteDep`
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
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
end
;;
DELIMITER ;
