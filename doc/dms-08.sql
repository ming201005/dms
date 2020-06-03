/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost
 Source Database       : dms

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : utf-8

 Date: 05/08/2020 10:49:43 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '院系ID号',
  `name` varchar(50) DEFAULT NULL COMMENT '院系名称',
  `des` varchar(1000) DEFAULT NULL COMMENT '院系概况',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `organization`
-- ----------------------------
BEGIN;
INSERT INTO `organization` VALUES ('1', '国际贸易院系', '<p>国际贸易院系</p>'), ('2', '经济管理系', '<p>经济管理系</p>'), ('3', '计算机科学与技术院校', '<p>计算机科学与技术院校</p>'), ('4', '数学院系', '<p>数学院系</p>'), ('5', '物理院系', '<p>物理院系</p>'), ('6', '生物工程院系', '<p>生物工程院系</p>');
COMMIT;

-- ----------------------------
--  Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `type_id` int DEFAULT NULL COMMENT '文件类型ID-外键',
  `resource_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件名称',
  `path_resource_name` varchar(255) DEFAULT NULL COMMENT '物理视频上存储的文件名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `resource_size` decimal(12,2) DEFAULT NULL COMMENT '文件大小（单位MB：9.35MB)',
  `file_suffix` varchar(255) DEFAULT NULL COMMENT '文件后缀：doc、pdf、等',
  `resource_state` int DEFAULT NULL COMMENT '文件状态，0：私有；1：公共',
  `up_user` varchar(255) DEFAULT NULL COMMENT '文件上传人',
  `des` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `resource`
-- ----------------------------
BEGIN;
INSERT INTO `resource` VALUES ('155', '8', 'ECS服务器CentOS 安装Nginx.docx', '/8/a441fe2bc6d8460e88c900ba44833b05.docx', '2020-04-23 15:59:13', '25320.00', 'docx', '1', 'admin', ''), ('156', '9', '模块运行截图.docx', '/9/2b065dca1fe8444c9121e36558a84f4d.docx', '2020-04-23 16:28:09', '664208.00', 'docx', '1', 'admin', '<p>优秀论文分享。</p>'), ('157', '2', '2018-推动企业上云实施指南(2018-2020年)-工业和信息化部印发.docx', '/2/a2ee590fa33c4df983c59fc43530f6d3.docx', '2020-04-24 04:16:17', '896380.00', 'docx', '1', 'admin', '<p>DFFDFFDF</p>'), ('158', '15', '附录E-软件测试（验收）大纲.docx', '/15/937c0f865c0e45fb88e4909765ffbc5f.docx', '2020-04-24 06:09:31', '55214.00', 'docx', '1', 'admin', '<p>可以，修改过了。</p>'), ('159', '15', '项目经理任命书.doc', '/15/c3ce0cd99f9b467692ef616571922e0e.doc', '2020-04-24 05:40:01', '32768.00', 'doc', '1', 'admin', '<p>项目经理任命书</p>'), ('160', '15', '国担项目团队核心人员任命书.xlsx', '/15/4760ce18f87e4ae3925ec088d4d70a9e.xlsx', '2020-04-24 05:40:41', '67346.00', 'xlsx', '1', 'admin', '<p>核心</p>'), ('161', '15', '附录D-软件数据库设计报告文档模板.docx', '/15/7d56faf4ff1b45a5800c9e7cba40d814.docx', '2020-04-24 05:44:34', '59077.00', 'docx', '1', 'admin', '<p>很好，分享报告资料。</p>'), ('162', '2', '附录A-软件需求分析报告文档模板.docx', '/2/66ad0d4e3fd14f27b0af77d94dc0b45e.docx', '2020-04-24 05:56:49', '62221.00', 'docx', '1', 'admin', '<p>更新了。。。。</p>'), ('163', '13', '生物怪物学', '/13/77c57f6b05994cc094c36571a25e3c1c.xlsx', '2020-04-24 06:12:27', '13275.00', 'xlsx', '1', 'admin', ''), ('164', '7', '（cmd：106）SOS号码更新.doc', '/7/a3d7816a7a8641d79bf211b236de3a5a.doc', '2020-04-24 07:32:42', '37888.00', 'doc', '1', 'admin', '<p>资料已经上传，</p>'), ('166', '13', '模块运行截图.docx', '/13/b6cfcca4e7374fe7944691ea1e526d0c.docx', '2020-04-24 10:56:48', '664208.00', 'docx', '1', 'admin', '<p>9999</p>'), ('167', '15', '2018-推动企业上云实施指南(2018-2020年)-工业和信息化部印发.docx', '/15/a172ab6a1d974094a3559353882e920e.docx', '2020-04-24 14:48:22', '896380.00', 'docx', '0', 'lilan', '<p>李兰个人资料</p>'), ('168', '11', 'ECS服务器CentOS 安装Nginx.docx', '/11/4143a5c9f1174c458226a2b57ba16c1a.docx', '2020-04-24 20:48:39', '25320.00', 'docx', '0', 'admin', '<p>特儿童版&nbsp;</p>'), ('169', '8', 'ECS服务器CentOS 安装Nginx.docx', '/8/7afca26b61844f979fe604bfe3a511b9.docx', '2020-04-24 21:06:28', '25320.00', 'docx', '0', '王五', '<p>阿打算的发生阿斯蒂芬&nbsp;</p>'), ('170', '7', '模块运行截图.docx', '/7/31cce36eaf044fac8845076f42407792.docx', '2020-04-24 21:06:53', '664208.00', 'docx', '1', '王五', '<p>它依然热热同仁堂</p>'), ('171', '10', '参考：2015年项目管理制度汇编_V1.0的副本.docx', '/10/dabb6427d6bd4a66a687343e08bd611c.docx', '2020-04-27 03:29:47', '373626.00', 'docx', '1', 'admin', '<p>也一样</p>'), ('172', '2', '软件项目管理制度v1.1.docx', '/2/5b8514c0025d45d4beb15cc16d63b7e9.docx', '2020-04-27 03:32:08', '212860.00', 'docx', '1', 'admin', '<p>娃娃案发时发生地方</p>'), ('173', '10', '产品研发部规章制度及软件项目管理方法.doc', '/10/a8d0ab772ade47e7902721e553b1558d.doc', '2020-04-27 03:35:48', '310784.00', 'doc', '0', '老六', '<p>沙发斯蒂芬&nbsp;</p>'), ('174', '4', '软件开发流程管理制度.doc', '/4/5f78241240974e46921f589f773d0f1f.doc', '2020-04-27 03:45:00', '77312.00', 'doc', '1', 'admin', '<p>ooo</p>'), ('175', '13', '软件开发流程管理制度.doc', '/13/1c1911b390894195bfe37f64b822fc36.doc', '2020-04-27 04:40:46', '77312.00', 'doc', '1', 'admin', '<p>阿斯顿发顺丰</p>'), ('176', '16', '软件项目管理制度v1.1.docx', '/16/f9669fd37d5b4a81aa731e2854a0aaae.docx', '2020-04-27 04:46:33', '212860.00', 'docx', '0', 'liuneng', '<p>66666666</p>'), ('177', '10', '软件项目管理制度v1.1.docx', '/10/43819e3ec7c54296b0bb1fc3fa6dcd98.docx', '2020-04-27 04:49:12', '212860.00', 'docx', '0', '李四', '<p>赞许时</p>'), ('178', '12', '产品研发部规章制度及软件项目管理方法.doc', '/12/e1663a874e634d90b7e7d0d5932d7c74.doc', '2020-04-27 04:52:53', '310784.00', 'doc', '1', 'lilan', '<p>yyyyy</p>'), ('179', '14', '软件项目管理制度v1.1.docx', '/14/c19668d2d2e9476bbf37f559cb2819a5.docx', '2020-05-02 13:33:43', '212860.00', 'docx', '0', 'admin', '<p>66666</p>'), ('180', '16', '产品研发部规章制度及软件项目管理方法.doc', '/16/f2bb4cae80314a819547078031f3d5aa.doc', '2020-05-04 08:02:39', '310784.00', 'doc', '0', 'zhaosi', '<p>问题问v</p>'), ('181', '11', '产品研发部规章制度及软件项目管理方法.doc', '/11/7485aeb963994553bfd1af7464b5ee59.doc', '2020-05-06 02:36:40', '310784.00', 'doc', '0', 'ming205', '<p>45545454</p>');
COMMIT;

-- ----------------------------
--  Table structure for `resource_type`
-- ----------------------------
DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE `resource_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `resource_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源类型名称',
  `resource_type_sort` int DEFAULT NULL COMMENT '排序',
  `resource_des` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `organization_id` int DEFAULT NULL COMMENT '组织，对应院系主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `resource_type`
-- ----------------------------
BEGIN;
INSERT INTO `resource_type` VALUES ('2', '微积分基础理论', '1', '<p>微积分基础理论</p>', '4'), ('3', '计算机文件', '1', '<p>计算机文件</p>', '3'), ('4', '软件设计类', '3', '<p>软件设计类</p>', '3'), ('7', '软件工程文档', '6', '<p>软件工程文档</p>', '3'), ('8', '软考资料', '4', '<p>软考资料</p>', '3'), ('9', '优秀论文', '5', '<p>优秀论文</p>', '3'), ('10', 'AA', '1', '<p>A-1</p>', '1'), ('11', '经济学知识', '1', '<p>经济学知识</p>', '2'), ('12', 'B2', '2', '<p>B2</p>', '5'), ('13', 'C-1', '1', '<p>C-1R</p>', '6'), ('14', '计算机理论算法类', '2', '<p>计算机理论算法类</p>', '3'), ('15', 'B1', '1', '<p>B-1</p>', '5'), ('16', '概率论知识', '2', '<p>概率论知识</p>', '4'), ('17', '硕士论文', '3', '', '4');
COMMIT;

-- ----------------------------
--  Table structure for `sys_backend_api_table`
-- ----------------------------
DROP TABLE IF EXISTS `sys_backend_api_table`;
CREATE TABLE `sys_backend_api_table` (
  `backend_api_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `backend_api_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'API名称',
  `backend_api_url` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'API请求地址',
  `backend_api_method` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'API请求方式：GET、POST、PUT、DELETE',
  `pid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父ID',
  `backend_api_sort` int NOT NULL COMMENT '排序',
  `description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`backend_api_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_backend_api_table`
-- ----------------------------
BEGIN;
INSERT INTO `sys_backend_api_table` VALUES ('0419051c16d7a9efe828819c5460c09c', '院系管理', 'none', null, null, '101', null), ('1', '所有', '/**', 'GET,POST,PUT,DELETE', '', '100', 'admin特有'), ('13b46ca028db1d7ca27428bf6cde71a3', '下载资料', '/resource/downLoad', 'GET', '4725d5b946c8789ebd2f758a93d416d8', '205', '下载资料'), ('181caf56a3ae4b3a8147b25cdff3d0bb', '修改用户(包括其他用户)', '/user', 'PUT', 'ccb6659817cf193adc6bfb4dc17709ec', '908', '修改用户(包括其他用户)'), ('228c8f32ae692f9cf17e9e6ffd85fa00', '修改个人账户', '/user/updateCurrentUser', 'PUT', 'ccb6659817cf193adc6bfb4dc17709ec', '909', '修改个人账户'), ('234dbd90c37363e2a6dea629adc7389e', '删除资料类型', '/resourceType', 'DELETE', '4725d5b946c8789ebd2f758a93d416d8', '210', '删除资料类型'), ('33866885a51a62b9b8c7f3a74086a012', '删除用户', '/user', 'DELETE', 'ccb6659817cf193adc6bfb4dc17709ec', '910', '删除用户'), ('34241131f88a0001b95286d3f531274d', '前端菜单增、改、删', '/sysFrontendMenuTable', 'DELETE,POST,PUT', 'ccb6659817cf193adc6bfb4dc17709ec', '902', '前端菜单增、改、删'), ('35bc07ac450bad2f8eb0ba2c44d66f60', '查询角色', '/sysRoleTable', 'GET', 'ccb6659817cf193adc6bfb4dc17709ec', '904', '查询角色'), ('3c4593addf852016a49bab68b7539441', '查询公共资料', '/resource/public', 'GET', '4725d5b946c8789ebd2f758a93d416d8', '202', '查询公共资料'), ('450abcb4ae42d1783ad21893cdd10487', '查看用户', '/user', 'GET', 'ccb6659817cf193adc6bfb4dc17709ec', '906', '查看用户'), ('4725d5b946c8789ebd2f758a93d416d8', '资料管理', 'none', '', null, '200', '资料管理下所有API'), ('485465261cf93c8081b0c368451ce91e', '查询资料', '/resource', 'GET', '4725d5b946c8789ebd2f758a93d416d8', '201', '查询资料'), ('5db146a32587583d8fcaeefffc1a266b', '新增用户', '/user/register', 'POST', 'ccb6659817cf193adc6bfb4dc17709ec', '907', '新增用户'), ('623c3f7156fb4a345f3c030f87d09aa9', '查看菜单管理', '/sysFrontendMenuTable', 'GET', 'ccb6659817cf193adc6bfb4dc17709ec', '901', '查看菜单管理'), ('6244f815c963cfd6453f65be437a4739', '根据ID查看用户信息', '/user/*', 'GET', 'ccb6659817cf193adc6bfb4dc17709ec', '906', '根据ID查看用户信息'), ('642775614fe269fb2bda425142bd3b38', '查询院系', '/organization', 'GET', '0419051c16d7a9efe828819c5460c09c', '102', '查询院系'), ('6ede6d660c1a757ebee3cca310f8ee14', '资料公开设置', '/resource/setpublic/*/*', 'GET', '4725d5b946c8789ebd2f758a93d416d8', '207', '资料公开设置'), ('74c2875e1d29a54ad457e7ad6154f9e8', '根据ID查看资料', '/resource/*', 'GET', '4725d5b946c8789ebd2f758a93d416d8', '203', '根据ID查看资料'), ('750be7ac660b8572993d540117b93758', '资料上传', '/resource/uploadFile', 'POST', '4725d5b946c8789ebd2f758a93d416d8', '204', '资料上传'), ('760ba9bf47fcda793203b1f3cd731083', '删除资料', '/resource/deleteFile', 'DELETE', '4725d5b946c8789ebd2f758a93d416d8', '206', '删除资料'), ('7cd70c92a359f69ff2472479ed7b7bda', '删除院系', '/organization', 'DELETE', '0419051c16d7a9efe828819c5460c09c', '105', '删除院系'), ('86aaeb7eddace56566e43fc6ed51d63b', '新增/修改院系查询', '/organization', 'PUT,POST', '0419051c16d7a9efe828819c5460c09c', '104', '新增/修改院系查询'), ('adc60ab150c543223d9d454b1e9d43a6', '查看资料类型', '/resourceType', 'GET', '4725d5b946c8789ebd2f758a93d416d8', '208', '查看资料类型'), ('b6da5d981adb6516ebb5a462f3e5ce7c', '根据ID查看院系', '/organization/*', 'GET', '0419051c16d7a9efe828819c5460c09c', '103', '根据ID查看院系'), ('c0254ebeb49d15d3b6c0ffdc1c65f2bb', '角色增、改、删', '/sysRoleTable', 'DELETE,POST,PUT', 'ccb6659817cf193adc6bfb4dc17709ec', '905', '角色增、改、删'), ('ccb6659817cf193adc6bfb4dc17709ec', '系统管理', 'none', null, null, '900', null), ('d9cb563e20b3c17b9a860eb3a652e34f', '后端API', '/sysBackendApiTable', 'GET', 'ccb6659817cf193adc6bfb4dc17709ec', '903', '后端API'), ('fa0c9a0b71a1d654f4ad2db4aac8e903', '新增/修改资料类型', '/resourceType', 'POST,PUT', '4725d5b946c8789ebd2f758a93d416d8', '209', '新增/修改资料类型');
COMMIT;

-- ----------------------------
--  Table structure for `sys_frontend_menu_table`
-- ----------------------------
DROP TABLE IF EXISTS `sys_frontend_menu_table`;
CREATE TABLE `sys_frontend_menu_table` (
  `frontend_menu_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `frontend_menu_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '前端菜单名称',
  `frontend_menu_url` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '前端菜单访问HTML地址',
  `pid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父ID',
  `frontend_menu_sort` int NOT NULL COMMENT '排序',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `icon` varchar(50) DEFAULT NULL COMMENT '小图标',
  PRIMARY KEY (`frontend_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_frontend_menu_table`
-- ----------------------------
BEGIN;
INSERT INTO `sys_frontend_menu_table` VALUES ('0af385f5e237445d369a49cb35b20da4', '系统管理', null, null, '900', null, 'el-icon-setting'), ('0c11607e6dab392725a2c1f6a21a0638', '院系管理', null, null, '100', '院系管理', 'el-icon-school'), ('176609193be0db6ee77e8b4d8735e073', '院系管理', './organization/list.html', '0c11607e6dab392725a2c1f6a21a0638', '101', '院系管理', 'el-icon-office-building'), ('2e39333633bff9a9e9c59414c2b45ddd', '资料管理', './resource/index.html', 'b3c72fd354b3df32ceb1dd7db0c61086', '201', '资料管理', 'el-icon-upload'), ('40ca076892e16ef6f788eb4d753df964', '用户管理', 'sys/user.html', '0af385f5e237445d369a49cb35b20da4', '902', '用户管理', 'el-icon-user-solid'), ('80c23202f9d72076359518ef33854a4f', '角色-菜单分配', 'sys/rolemenu.html', '0af385f5e237445d369a49cb35b20da4', '906', '角色-菜单分配', 'el-icon-s-operation'), ('ab9fdc8116dab6c8d110aa4387c97e08', '角色-API分配', 'sys/roleapi.html', '0af385f5e237445d369a49cb35b20da4', '907', '角色-API分配', 'el-icon-tickets'), ('b2dcfb940a72deb68b338b934128a1e4', '资料分类', './resource/resourceType.html', 'b3c72fd354b3df32ceb1dd7db0c61086', '202', '资料分类', 'el-icon-menu'), ('b3c72fd354b3df32ceb1dd7db0c61086', '资料管理', null, null, '200', null, 'el-icon-folder'), ('b973d15c229778a6d98e742d096b2e41', '角色管理', 'sys/role.html', '0af385f5e237445d369a49cb35b20da4', '901', '角色管理页面', 'el-icon-user'), ('d2948d3e4a0914825f70aa39ce1c9d23', '账号信息', 'sys/info.html', '0af385f5e237445d369a49cb35b20da4', '908', null, 'el-icon-s-custom'), ('e1fc2013f32ece3c772becb9489296e4', '后端API管理', 'sys/api.html', '0af385f5e237445d369a49cb35b20da4', '904', '后端API管理页面', 'el-icon-set-up'), ('e529e97e6ab0f95fc85cfbda5247eeaa', '前端菜单管理', 'sys/menu.html', '0af385f5e237445d369a49cb35b20da4', '903', null, 'el-icon-s-order'), ('e9eda624eee0d83e9651db8275a3b391', '公共资料', './resource/index-public.html', 'b3c72fd354b3df32ceb1dd7db0c61086', '203', '公共资料，人人可查', 'el-icon-s-platform'), ('eb70ecd66ed156ca2f49e4d0e32b36f6', '角色-用户分配', 'sys/roleuser.html', '0af385f5e237445d369a49cb35b20da4', '905', '角色用户分配', 'el-icon-s-unfold');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_backend_api_table`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_backend_api_table`;
CREATE TABLE `sys_role_backend_api_table` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `backend_api_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'API管理表ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=638 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_role_backend_api_table`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_backend_api_table` VALUES ('10', 'd04c2ebb1e32995f384ad49f6d4b421d', '234dbd90c37363e2a6dea629adc7389e'), ('11', 'd04c2ebb1e32995f384ad49f6d4b421d', 'fa0c9a0b71a1d654f4ad2db4aac8e903'), ('12', 'd04c2ebb1e32995f384ad49f6d4b421d', '4725d5b946c8789ebd2f758a93d416d8'), ('13', 'd04c2ebb1e32995f384ad49f6d4b421d', '760ba9bf47fcda793203b1f3cd731083'), ('14', 'd04c2ebb1e32995f384ad49f6d4b421d', '49bcd49553fd6274c5ea8b6fcc84097e'), ('15', 'd04c2ebb1e32995f384ad49f6d4b421d', 'adc60ab150c543223d9d454b1e9d43a6'), ('16', 'd04c2ebb1e32995f384ad49f6d4b421d', '73b81575b6737e4d38e6716bc773c5bb'), ('17', 'd04c2ebb1e32995f384ad49f6d4b421d', '8ba918894b2ed504e2a3db56b33327b4'), ('18', '1', '1'), ('504', 'f043599a60177e005d3628613dac9f12', '13b46ca028db1d7ca27428bf6cde71a3'), ('505', 'f043599a60177e005d3628613dac9f12', '6244f815c963cfd6453f65be437a4739'), ('506', 'f043599a60177e005d3628613dac9f12', 'ccb6659817cf193adc6bfb4dc17709ec'), ('507', 'f043599a60177e005d3628613dac9f12', '228c8f32ae692f9cf17e9e6ffd85fa00'), ('508', 'f043599a60177e005d3628613dac9f12', '642775614fe269fb2bda425142bd3b38'), ('509', 'f043599a60177e005d3628613dac9f12', '3c4593addf852016a49bab68b7539441'), ('510', 'f043599a60177e005d3628613dac9f12', 'adc60ab150c543223d9d454b1e9d43a6'), ('511', 'ad6c8c05447aa8e6f941832d09b76559', '4725d5b946c8789ebd2f758a93d416d8'), ('512', 'ad6c8c05447aa8e6f941832d09b76559', '74c2875e1d29a54ad457e7ad6154f9e8'), ('513', 'ad6c8c05447aa8e6f941832d09b76559', '760ba9bf47fcda793203b1f3cd731083'), ('514', 'ad6c8c05447aa8e6f941832d09b76559', 'ccb6659817cf193adc6bfb4dc17709ec'), ('515', 'ad6c8c05447aa8e6f941832d09b76559', '3c4593addf852016a49bab68b7539441'), ('516', 'ad6c8c05447aa8e6f941832d09b76559', 'adc60ab150c543223d9d454b1e9d43a6'), ('517', 'ad6c8c05447aa8e6f941832d09b76559', '642775614fe269fb2bda425142bd3b38'), ('518', 'ad6c8c05447aa8e6f941832d09b76559', '13b46ca028db1d7ca27428bf6cde71a3'), ('519', 'ad6c8c05447aa8e6f941832d09b76559', 'b6da5d981adb6516ebb5a462f3e5ce7c'), ('520', 'ad6c8c05447aa8e6f941832d09b76559', '750be7ac660b8572993d540117b93758'), ('521', 'ad6c8c05447aa8e6f941832d09b76559', '234dbd90c37363e2a6dea629adc7389e'), ('522', 'ad6c8c05447aa8e6f941832d09b76559', '6244f815c963cfd6453f65be437a4739'), ('523', 'ad6c8c05447aa8e6f941832d09b76559', '485465261cf93c8081b0c368451ce91e'), ('524', 'ad6c8c05447aa8e6f941832d09b76559', '228c8f32ae692f9cf17e9e6ffd85fa00'), ('525', 'ad6c8c05447aa8e6f941832d09b76559', '6ede6d660c1a757ebee3cca310f8ee14'), ('526', 'ad6c8c05447aa8e6f941832d09b76559', 'fa0c9a0b71a1d654f4ad2db4aac8e903'), ('588', '0a4d68b39d5a1d6fcf828523a326664f', '3c4593addf852016a49bab68b7539441'), ('589', '0a4d68b39d5a1d6fcf828523a326664f', '485465261cf93c8081b0c368451ce91e'), ('590', '0a4d68b39d5a1d6fcf828523a326664f', '228c8f32ae692f9cf17e9e6ffd85fa00'), ('591', '0a4d68b39d5a1d6fcf828523a326664f', '13b46ca028db1d7ca27428bf6cde71a3'), ('592', '0a4d68b39d5a1d6fcf828523a326664f', '74c2875e1d29a54ad457e7ad6154f9e8'), ('593', '0a4d68b39d5a1d6fcf828523a326664f', '6ede6d660c1a757ebee3cca310f8ee14'), ('594', '0a4d68b39d5a1d6fcf828523a326664f', '760ba9bf47fcda793203b1f3cd731083'), ('595', '0a4d68b39d5a1d6fcf828523a326664f', '750be7ac660b8572993d540117b93758'), ('596', '0a4d68b39d5a1d6fcf828523a326664f', '4725d5b946c8789ebd2f758a93d416d8'), ('597', '0a4d68b39d5a1d6fcf828523a326664f', 'adc60ab150c543223d9d454b1e9d43a6'), ('598', '0a4d68b39d5a1d6fcf828523a326664f', '642775614fe269fb2bda425142bd3b38'), ('599', '0a4d68b39d5a1d6fcf828523a326664f', 'ccb6659817cf193adc6bfb4dc17709ec'), ('600', '0a4d68b39d5a1d6fcf828523a326664f', '6244f815c963cfd6453f65be437a4739'), ('601', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'adc60ab150c543223d9d454b1e9d43a6'), ('602', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'b6da5d981adb6516ebb5a462f3e5ce7c'), ('603', '4cbb378dfd857fea8fe8a9e4b0d4776a', '3c4593addf852016a49bab68b7539441'), ('604', '4cbb378dfd857fea8fe8a9e4b0d4776a', '6244f815c963cfd6453f65be437a4739'), ('605', '4cbb378dfd857fea8fe8a9e4b0d4776a', '750be7ac660b8572993d540117b93758'), ('606', '4cbb378dfd857fea8fe8a9e4b0d4776a', '74c2875e1d29a54ad457e7ad6154f9e8'), ('607', '4cbb378dfd857fea8fe8a9e4b0d4776a', '6ede6d660c1a757ebee3cca310f8ee14'), ('608', '4cbb378dfd857fea8fe8a9e4b0d4776a', '642775614fe269fb2bda425142bd3b38'), ('609', '4cbb378dfd857fea8fe8a9e4b0d4776a', '228c8f32ae692f9cf17e9e6ffd85fa00'), ('610', '4cbb378dfd857fea8fe8a9e4b0d4776a', '485465261cf93c8081b0c368451ce91e'), ('611', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'ccb6659817cf193adc6bfb4dc17709ec'), ('612', '2f412c59e5077e0cd53d21fac3eee402', '450abcb4ae42d1783ad21893cdd10487'), ('613', '2f412c59e5077e0cd53d21fac3eee402', '7cd70c92a359f69ff2472479ed7b7bda'), ('614', '2f412c59e5077e0cd53d21fac3eee402', 'fa0c9a0b71a1d654f4ad2db4aac8e903'), ('615', '2f412c59e5077e0cd53d21fac3eee402', '485465261cf93c8081b0c368451ce91e'), ('616', '2f412c59e5077e0cd53d21fac3eee402', '4725d5b946c8789ebd2f758a93d416d8'), ('617', '2f412c59e5077e0cd53d21fac3eee402', '33866885a51a62b9b8c7f3a74086a012'), ('618', '2f412c59e5077e0cd53d21fac3eee402', '3c4593addf852016a49bab68b7539441'), ('619', '2f412c59e5077e0cd53d21fac3eee402', '760ba9bf47fcda793203b1f3cd731083'), ('620', '2f412c59e5077e0cd53d21fac3eee402', '86aaeb7eddace56566e43fc6ed51d63b'), ('621', '2f412c59e5077e0cd53d21fac3eee402', '35bc07ac450bad2f8eb0ba2c44d66f60'), ('622', '2f412c59e5077e0cd53d21fac3eee402', '6ede6d660c1a757ebee3cca310f8ee14'), ('623', '2f412c59e5077e0cd53d21fac3eee402', '13b46ca028db1d7ca27428bf6cde71a3'), ('624', '2f412c59e5077e0cd53d21fac3eee402', '623c3f7156fb4a345f3c030f87d09aa9'), ('625', '2f412c59e5077e0cd53d21fac3eee402', '6244f815c963cfd6453f65be437a4739'), ('626', '2f412c59e5077e0cd53d21fac3eee402', 'd9cb563e20b3c17b9a860eb3a652e34f'), ('627', '2f412c59e5077e0cd53d21fac3eee402', '234dbd90c37363e2a6dea629adc7389e'), ('628', '2f412c59e5077e0cd53d21fac3eee402', '642775614fe269fb2bda425142bd3b38'), ('629', '2f412c59e5077e0cd53d21fac3eee402', '74c2875e1d29a54ad457e7ad6154f9e8'), ('630', '2f412c59e5077e0cd53d21fac3eee402', '0419051c16d7a9efe828819c5460c09c'), ('631', '2f412c59e5077e0cd53d21fac3eee402', '5db146a32587583d8fcaeefffc1a266b'), ('632', '2f412c59e5077e0cd53d21fac3eee402', '181caf56a3ae4b3a8147b25cdff3d0bb'), ('633', '2f412c59e5077e0cd53d21fac3eee402', '750be7ac660b8572993d540117b93758'), ('634', '2f412c59e5077e0cd53d21fac3eee402', 'adc60ab150c543223d9d454b1e9d43a6'), ('635', '2f412c59e5077e0cd53d21fac3eee402', 'b6da5d981adb6516ebb5a462f3e5ce7c'), ('636', '2f412c59e5077e0cd53d21fac3eee402', 'ccb6659817cf193adc6bfb4dc17709ec'), ('637', '2f412c59e5077e0cd53d21fac3eee402', '228c8f32ae692f9cf17e9e6ffd85fa00');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_frontend_menu_table`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_frontend_menu_table`;
CREATE TABLE `sys_role_frontend_menu_table` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `frontend_menu_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '前端菜单管理ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=391 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_role_frontend_menu_table`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_frontend_menu_table` VALUES ('52', '1', '*'), ('53', '1', 'b2dcfb940a72deb68b338b934128a1e4'), ('54', '1', 'c9fe45ef063af26c3e4c3208ffe1ff9f'), ('55', '1', '105eb6c65a907eb589dbd3a9eeea013a'), ('56', '1', '434e4bd50799bd145f4590d0f4705162'), ('57', '1', 'e529e97e6ab0f95fc85cfbda5247eeaa'), ('58', '1', 'e1fc2013f32ece3c772becb9489296e4'), ('59', '1', '737addccb1ac6307d29802ad988b13d8'), ('60', '1', '6423ae277e4ec862ff23bd7b2c0922ce'), ('61', '1', 'b65d3ad4906ffc8be6932f9a1f51df1d'), ('62', '1', 'd2948d3e4a0914825f70aa39ce1c9d23'), ('63', '1', 'b3c72fd354b3df32ceb1dd7db0c61086'), ('64', '1', 'eb70ecd66ed156ca2f49e4d0e32b36f6'), ('65', '1', '94025c8731dc0dc403b66f9e8899cbc7'), ('66', '1', 'b973d15c229778a6d98e742d096b2e41'), ('67', '1', '7f448ccf628eb577e20f6413c5810300'), ('68', '1', '40ca076892e16ef6f788eb4d753df964'), ('69', '1', '0af385f5e237445d369a49cb35b20da4'), ('70', '1', 'ab9fdc8116dab6c8d110aa4387c97e08'), ('71', '1', '76cb7b2df76c79d159c561ecfbd54ef2'), ('72', '1', '2e5739a73173a22ed55eca37bb67aae6'), ('73', '1', 'a3baa2f584b4032be78d38bd49b891c8'), ('74', '1', 'c7eb10d6513f40ac25f75e34a2679eab'), ('75', '1', '3a8846521659085ed6ce0b0187d6d72a'), ('120', 'd04c2ebb1e32995f384ad49f6d4b421d', 'b3c72fd354b3df32ceb1dd7db0c61086'), ('121', 'd04c2ebb1e32995f384ad49f6d4b421d', '6423ae277e4ec862ff23bd7b2c0922ce'), ('122', 'd04c2ebb1e32995f384ad49f6d4b421d', 'c7eb10d6513f40ac25f75e34a2679eab'), ('123', 'd04c2ebb1e32995f384ad49f6d4b421d', '105eb6c65a907eb589dbd3a9eeea013a'), ('124', 'd04c2ebb1e32995f384ad49f6d4b421d', 'b65d3ad4906ffc8be6932f9a1f51df1d'), ('125', 'd04c2ebb1e32995f384ad49f6d4b421d', '2e5739a73173a22ed55eca37bb67aae6'), ('126', 'd04c2ebb1e32995f384ad49f6d4b421d', '434e4bd50799bd145f4590d0f4705162'), ('127', 'd04c2ebb1e32995f384ad49f6d4b421d', '94025c8731dc0dc403b66f9e8899cbc7'), ('128', 'd04c2ebb1e32995f384ad49f6d4b421d', '7f448ccf628eb577e20f6413c5810300'), ('129', 'd04c2ebb1e32995f384ad49f6d4b421d', '3a8846521659085ed6ce0b0187d6d72a'), ('130', 'd04c2ebb1e32995f384ad49f6d4b421d', 'b2dcfb940a72deb68b338b934128a1e4'), ('131', 'd04c2ebb1e32995f384ad49f6d4b421d', '737addccb1ac6307d29802ad988b13d8'), ('132', 'd04c2ebb1e32995f384ad49f6d4b421d', 'a3baa2f584b4032be78d38bd49b891c8'), ('133', 'd04c2ebb1e32995f384ad49f6d4b421d', 'c9fe45ef063af26c3e4c3208ffe1ff9f'), ('337', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'b3c72fd354b3df32ceb1dd7db0c61086'), ('338', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'e9eda624eee0d83e9651db8275a3b391'), ('339', '4cbb378dfd857fea8fe8a9e4b0d4776a', '2e39333633bff9a9e9c59414c2b45ddd'), ('340', '4cbb378dfd857fea8fe8a9e4b0d4776a', '0af385f5e237445d369a49cb35b20da4'), ('341', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'd2948d3e4a0914825f70aa39ce1c9d23'), ('342', 'ad6c8c05447aa8e6f941832d09b76559', 'e9eda624eee0d83e9651db8275a3b391'), ('343', 'ad6c8c05447aa8e6f941832d09b76559', 'd2948d3e4a0914825f70aa39ce1c9d23'), ('344', 'ad6c8c05447aa8e6f941832d09b76559', '0af385f5e237445d369a49cb35b20da4'), ('345', 'ad6c8c05447aa8e6f941832d09b76559', '2e39333633bff9a9e9c59414c2b45ddd'), ('346', 'ad6c8c05447aa8e6f941832d09b76559', 'b3c72fd354b3df32ceb1dd7db0c61086'), ('347', 'f043599a60177e005d3628613dac9f12', 'e9eda624eee0d83e9651db8275a3b391'), ('348', 'f043599a60177e005d3628613dac9f12', '0af385f5e237445d369a49cb35b20da4'), ('349', 'f043599a60177e005d3628613dac9f12', 'b3c72fd354b3df32ceb1dd7db0c61086'), ('350', 'f043599a60177e005d3628613dac9f12', 'd2948d3e4a0914825f70aa39ce1c9d23'), ('363', '0a4d68b39d5a1d6fcf828523a326664f', '2e39333633bff9a9e9c59414c2b45ddd'), ('364', '0a4d68b39d5a1d6fcf828523a326664f', '0af385f5e237445d369a49cb35b20da4'), ('365', '0a4d68b39d5a1d6fcf828523a326664f', 'b3c72fd354b3df32ceb1dd7db0c61086'), ('366', '0a4d68b39d5a1d6fcf828523a326664f', 'd2948d3e4a0914825f70aa39ce1c9d23'), ('367', '0a4d68b39d5a1d6fcf828523a326664f', 'e9eda624eee0d83e9651db8275a3b391'), ('384', '2f412c59e5077e0cd53d21fac3eee402', 'b3c72fd354b3df32ceb1dd7db0c61086'), ('385', '2f412c59e5077e0cd53d21fac3eee402', '40ca076892e16ef6f788eb4d753df964'), ('386', '2f412c59e5077e0cd53d21fac3eee402', '0af385f5e237445d369a49cb35b20da4'), ('387', '2f412c59e5077e0cd53d21fac3eee402', '2e39333633bff9a9e9c59414c2b45ddd'), ('388', '2f412c59e5077e0cd53d21fac3eee402', 'd2948d3e4a0914825f70aa39ce1c9d23'), ('389', '2f412c59e5077e0cd53d21fac3eee402', 'e9eda624eee0d83e9651db8275a3b391'), ('390', '2f412c59e5077e0cd53d21fac3eee402', 'b2dcfb940a72deb68b338b934128a1e4');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_table`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_table`;
CREATE TABLE `sys_role_table` (
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `pid` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '角色组（对应父组ID）',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `sys_role_table_pk` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_role_table`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_table` VALUES ('0a4d68b39d5a1d6fcf828523a326664f', 'ROLE_学办', '学办', ''), ('1', 'ROLE_ADMIN', '系统超级管理员，不能动！', ''), ('2f412c59e5077e0cd53d21fac3eee402', 'ROLE_院系管理员', '院系管理员', ''), ('4cbb378dfd857fea8fe8a9e4b0d4776a', 'ROLE_教师', '教师', ''), ('ad6c8c05447aa8e6f941832d09b76559', 'ROLE_教务处', '教务处', ''), ('f043599a60177e005d3628613dac9f12', 'ROLE_学生', '学生', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_user_table`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user_table`;
CREATE TABLE `sys_role_user_table` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色ID',
  `user_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_role_user_table`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_user_table` VALUES ('43', 'd04c2ebb1e32995f384ad49f6d4b421d', '6268cbe21e573513a66799114d925e04'), ('83', 'ad6c8c05447aa8e6f941832d09b76559', 'a52c5bd70816579b40b420e84776eb9e'), ('90', '1', 'bcad19f214499feab47f15b18ae9bc88'), ('130', 'ad6c8c05447aa8e6f941832d09b76559', 'c843a2f07310789272ce520372d67b45'), ('132', '1', 'c843a2f07310789272ce520372d67b45'), ('135', 'ad6c8c05447aa8e6f941832d09b76559', '6a388aa2da5e54e69413b81f78841ee7'), ('149', 'ad6c8c05447aa8e6f941832d09b76559', 'f2eb7b3df76fbfdc06576379e4b97e79'), ('156', '0a4d68b39d5a1d6fcf828523a326664f', '144bbef9a25f221a609f67d1e8ab1791'), ('157', '0a4d68b39d5a1d6fcf828523a326664f', '9c2657b5e7b65f53a2c91d07155291d6'), ('168', 'f043599a60177e005d3628613dac9f12', '240143f4102107a0be6370f662662c4d'), ('169', 'f043599a60177e005d3628613dac9f12', '6af8e3382c986033b0472a115db59e07'), ('170', 'f043599a60177e005d3628613dac9f12', '63e11fa9df9775cc37070066c54aa7ca'), ('171', 'f043599a60177e005d3628613dac9f12', 'c9b8378353694555f9eb2c1e70215255'), ('173', 'f043599a60177e005d3628613dac9f12', '57603f94a0203dfcf1c4665e3b097044'), ('174', 'f043599a60177e005d3628613dac9f12', '448280175e7bfd5e00b349610d69b94a'), ('175', 'f043599a60177e005d3628613dac9f12', '144bbef9a25f221a609f67d1e8ab1791'), ('176', 'f043599a60177e005d3628613dac9f12', '2cf463cd062baab770bf71a1b0e81a97'), ('182', '0a4d68b39d5a1d6fcf828523a326664f', 'b0deeda46693ea27bbf632304de765f6'), ('183', 'f043599a60177e005d3628613dac9f12', 'b0deeda46693ea27bbf632304de765f6'), ('184', '2f412c59e5077e0cd53d21fac3eee402', '6a388aa2da5e54e69413b81f78841ee7'), ('185', '2f412c59e5077e0cd53d21fac3eee402', 'f4cc7aa71be7a1a161ddfcbe1e204e72'), ('187', '2f412c59e5077e0cd53d21fac3eee402', '144bbef9a25f221a609f67d1e8ab1791'), ('188', '2f412c59e5077e0cd53d21fac3eee402', '9c2657b5e7b65f53a2c91d07155291d6'), ('189', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'c843a2f07310789272ce520372d67b45'), ('190', '4cbb378dfd857fea8fe8a9e4b0d4776a', '26dd252092f26501a02fe9be8e270f5e'), ('191', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'c2ea699c481735cd2288dcedbc558d54'), ('192', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'a52c5bd70816579b40b420e84776eb9e'), ('193', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'f4cc7aa71be7a1a161ddfcbe1e204e72'), ('194', '4cbb378dfd857fea8fe8a9e4b0d4776a', 'b03db7efbc274fddb752cef09d064685'), ('195', '2f412c59e5077e0cd53d21fac3eee402', '2b934cfc0701b3cf0f71f087f6e030a7');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user_table`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_table`;
CREATE TABLE `sys_user_table` (
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `user_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录账号',
  `user_show` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `pass_word` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码-BCR算法加密',
  `user_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `user_type` int DEFAULT NULL COMMENT '用户类型：1-学生；2-非学生（泛指教师及工作人员）；',
  `state` int DEFAULT NULL COMMENT '状态',
  `description` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `organization_id` int DEFAULT NULL COMMENT '组织，对应院系主键',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_user_table`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_table` VALUES ('144bbef9a25f221a609f67d1e8ab1791', 'ming202', '小明哥', '$2a$10$WKISQOkQ7pmzgt2KsWAXBeOd/2wtJ.1i9JQaNqTbnLEqnla5rU.DO', '男', '1', '1', '', '1'), ('240143f4102107a0be6370f662662c4d', 'liaoxiaomei', '廖小梅', '$2a$10$IKSKaPVCPujPUcXRHLxh1.F3AusCdwq.Lc0uqwQTUrpeYlcfQ3AiG', '女', '1', '1', '<p>廖小梅，大二，优秀学生</p>', '3'), ('26dd252092f26501a02fe9be8e270f5e', '李四', null, '$2a$10$wdMb/ZS5cZ2yiaDFY57VA.dsF/VNTqxHsUU9X6x/K5XpbDXra2lKi', '男', '1', '1', null, '1'), ('2b934cfc0701b3cf0f71f087f6e030a7', '刘海', null, '$2a$10$7vwnir13o9uSkan5HmScEely6gm1YxWhqEmzEqH5JnQCqoiJMoEam', '男', '1', '1', '<p>这是刘海。大四，准备考研。</p>', '3'), ('2cf463cd062baab770bf71a1b0e81a97', 'liguoliang', '李国良', '$2a$10$OHJUKk7BEhTeU6bgvDucce1i8pkthzRBOL0hhGhHvPx5pAF7jSsty', '男', '1', '1', '<p>大二，预备党员</p>', '3'), ('448280175e7bfd5e00b349610d69b94a', 'liuwu', '刘五', '$2a$10$fw2JAKnp0mPF0ceDsawE1eAMxQtfrzG/.tkMCkcQwuWkS5xOSqjlK', '男', '1', '1', '<p>阿斯顿发</p>', '5'), ('57603f94a0203dfcf1c4665e3b097044', '学生1', null, '$2a$10$KfQ100Z5BydmR6fFR7BJI.9pqA83hgMfB5lqOPSjfzMtIDyjAUQSq', '女', '1', '1', null, '1'), ('63e11fa9df9775cc37070066c54aa7ca', '学生2', null, '$2a$10$cPpRJ1QYgPEAw6FgjYRSLeJpHkXeVP49vtrLp9uownpMHgsp4DVKW', null, '1', '1', null, '2'), ('6a388aa2da5e54e69413b81f78841ee7', 'ming205', '刘能', '$2a$10$u9SVBojNHfkou8QGB/juhOxd.Hp9AD8rMvjkOu2SRfAl8K3zbVxOa', '男', '1', '1', '<p>刘能</p>', '2'), ('6af8e3382c986033b0472a115db59e07', 'zhangsan', '张三', '$2a$10$TnAI/owRb28asrXVkxd/.eqKmaKpz0lF634A9nJ3AEXtFz5XTR.3e', '男', '1', '1', '<p>张三，国际贸易学院，成绩优异。</p>', '1'), ('9c2657b5e7b65f53a2c91d07155291d6', 'lilan', '李兰', '$2a$10$aEsm.nPypzPh2V.hVdLgwu.hPUivMdneCMT.zg6JWvjqU8dhomSr.', '女', '1', '1', '<p>李兰，好学生。</p>', '5'), ('a52c5bd70816579b40b420e84776eb9e', '老六', null, '$2a$10$pvTeO4NFX8R1v7gX9iiGBOphYoHgpTaKwtFmAR5PDhCYMCVcHQPqy', null, '2', '1', null, '1'), ('b03db7efbc274fddb752cef09d064685', 'ming203', null, '$2a$10$rtdXB9ik8vpqzH0//d0Hn.IAUbEQXGKjk3z2Gi65Ml9xHfBH.cCsm', null, '2', '1', null, '3'), ('b0deeda46693ea27bbf632304de765f6', 'zhaosi', '赵四', '$2a$10$8uk63X3lnlXo9iUXgjWOJ.ryty8VZVmG1Vri7rmTNT0l1KmbwTcW.', '男', '1', '1', '', '4'), ('bcad19f214499feab47f15b18ae9bc88', 'admin', '刘秀', '$2a$10$K8TYHgBAHn9o/RII6HA0puDIINuadS8tCRxo4/hqBR7Zv7ZtCdk9S', '男', '1', '1', '超级管理员', '3'), ('c2ea699c481735cd2288dcedbc558d54', 'ming201', null, '$2a$10$SArCswUoIl165AJ55hfxjuq8w4OL/CAKTOnuRa2TeK.5NvYjPnWDm', null, '2', '1', '小明', '3'), ('c843a2f07310789272ce520372d67b45', 'ming206', '莫小明', '$2a$10$oNrMKsjOSaJ0EuVFyVpsLeaLm5Y/GAtIoUlmfrmly9qQKamtNPbXu', '男', '2', '1', '<p>工会主席、教务处。</p>', '3'), ('c9b8378353694555f9eb2c1e70215255', 'lili', '丽丽', '$2a$10$iXLlYxaa7VO5MMXCOaiKx.UEDCAWsD1gSX.2fyzoCCXcJzZTxqYR2', '女', '1', '1', '<p>大四</p>', '4'), ('f4cc7aa71be7a1a161ddfcbe1e204e72', 'liuneng', '刘能', '$2a$10$ez3Pfol2jJsLFNB.2Ai3wefFjDQgOBc/ai51/1HGGppK1JYtCgJyi', '男', '2', '1', '<p>数学系中会讲笑话的奇葩。</p>', '4');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
