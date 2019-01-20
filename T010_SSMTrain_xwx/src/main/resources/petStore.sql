/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : pet_store

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 16/01/2019 16:19:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address`
(
  `id`            int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '收货地址ID',
  `uid`           int(11)                                                NOT NULL COMMENT '用户ID',
  `recv_name`     varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `recv_province` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '省份',
  `recv_city`     varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '城市',
  `recv_area`     varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '区、县',
  `recv_address`  char(11) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL COMMENT '完整地址',
  `recv_phone`    int(11)                                                NULL DEFAULT NULL COMMENT '移动电话',
  `recv_tel`      varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定电话',
  `recv_zip_code` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '邮编',
  `recv_tag`      varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '收货地址标签（家、公司、代收地点.....）',
  `is_default`    int(11)                                                NULL DEFAULT 1 COMMENT '是否为默认收货地址(0: 默认 1: 否)',
  `created_time`  datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_address_user` (`uid`) USING BTREE,
  INDEX `fk_district_province` (`recv_province`) USING BTREE,
  INDEX `fk_district_city` (`recv_city`) USING BTREE,
  INDEX `fk_district_area` (`recv_area`) USING BTREE,
  CONSTRAINT `fk_address_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_district_area` FOREIGN KEY (`recv_area`) REFERENCES `t_district` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_district_city` FOREIGN KEY (`recv_city`) REFERENCES `t_district` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_district_province` FOREIGN KEY (`recv_province`) REFERENCES `t_district` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '收货地址详情信息表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_district
-- ----------------------------
DROP TABLE IF EXISTS `t_district`;
CREATE TABLE `t_district`
(
  `id`     int(11)                                                NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '上级地区编码',
  `code`   varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '该地区编码',
  `name`   varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该地区名称',
  PRIMARY KEY (`id`, `code`) USING BTREE,
  INDEX `code` (`code`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '地区详情表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`
(
  `id`           int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '消息公告ID',
  `title`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息公告主题',
  `content`      text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '消息公告内容',
  `created_user` int(11)                                                 NULL DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_notice_user` (`created_user`) USING BTREE,
  CONSTRAINT `t_notice_user` FOREIGN KEY (`created_user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '商城信息公告表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`
(
  `id`           int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `uid`          int(11)                                                NULL DEFAULT NULL COMMENT '用户ID',
  `recv_name`    varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `recv_phone`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单收货人电话',
  `recv_address` int(100)                                               NULL DEFAULT NULL COMMENT '订单收货人地址',
  `total_price`  decimal(22, 2)                                         NULL DEFAULT NULL COMMENT '总金额',
  `status`       int(11)                                                NULL DEFAULT NULL COMMENT '订单状态(-1:已取消,0:交易已关闭,1:待付款,2:待发货,3:待确认收货,4:收货成功待评价,5:退货中)',
  `created_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '订单创建时间',
  `pay_time`     datetime(0)                                            NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order_user` (`uid`) USING BTREE,
  INDEX `fk_order_address` (`recv_address`) USING BTREE,
  CONSTRAINT `fk_order_address` FOREIGN KEY (`recv_address`) REFERENCES `t_address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '订单表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`
(
  `id`        int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '订单商品条目ID',
  `order_id`  int(11)                                                 NULL DEFAULT NULL COMMENT '订单ID',
  `pet_id`    int(20)                                                 NULL DEFAULT NULL COMMENT '宠物ID',
  `pet_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成订单时宠物名称',
  `pet_age`   int(11)                                                 NULL DEFAULT NULL COMMENT '生成订单时宠物的年龄',
  `pet_color` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '生成订单时宠物颜色',
  `pet_price` decimal(22, 2)                                          NULL DEFAULT NULL COMMENT '生成订单时宠物的单价',
  `pet_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成订单时宠物图片路径',
  `pet_num`   int(10)                                                 NULL DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_detail_order` (`order_id`) USING BTREE,
  INDEX `fk_pet_detail` (`pet_id`) USING BTREE,
  CONSTRAINT `fk_detail_order` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_pet_detail` FOREIGN KEY (`pet_id`) REFERENCES `t_pets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '宠物订单详情'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_pets
-- ----------------------------
DROP TABLE IF EXISTS `t_pets`;
CREATE TABLE `t_pets`
(
  `id`           int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '宠物ID',
  `name`         varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '宠物名称',
  `family`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科别（猫，犬，鸟，鱼、鼠）',
  `size`         char(20) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '宠物类型(超小型,超大型,小型,中型,大型)',
  `fn_feature`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能特点:家庭犬、玩具犬、工作犬、梗类犬、牧羊犬、狩猎犬、枪猎犬',
  `advantages`   char(20) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '买点/有点（聪明,粘人,不掉毛,不爱叫,友善,会看家,耐热,易训）',
  `birth`        datetime(0)                                             NULL DEFAULT NULL COMMENT '出生日期',
  `love`         int(11)                                                 NULL DEFAULT NULL COMMENT '爱心指数（0~100）',
  `color`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '宠物颜色',
  `variety`      varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '宠物品种',
  `price`        decimal(22, 2)                                          NULL DEFAULT NULL COMMENT '宠物单价',
  `image`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `num`          int(10)                                                 NULL DEFAULT NULL COMMENT '库存数量',
  `status`       int(1)                                                  NULL DEFAULT 1 COMMENT '商品状态(1: 上架  2: 下架  3: 删除)',
  `priority`     int(10)                                                 NULL DEFAULT NULL COMMENT '显示优先级',
  `created_user` int(11)                                                 NULL DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_pet` (`created_user`) USING BTREE,
  CONSTRAINT `fk_user_pet` FOREIGN KEY (`created_user`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '宠物详情信息表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_cart`;
CREATE TABLE `t_shop_cart`
(
  `id`      int(11)    NOT NULL AUTO_INCREMENT COMMENT '购物车条目ID',
  `uid`     int(11)    NULL DEFAULT NULL COMMENT '用户ID',
  `pet_id`  bigint(20) NULL DEFAULT NULL COMMENT '宠物ID',
  `pet_num` int(11)    NOT NULL COMMENT '宠物添加数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_cart_user` (`uid`) USING BTREE,
  CONSTRAINT `fk_cart_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_item_cart` FOREIGN KEY (`id`) REFERENCES `t_order_item` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '购物车详情信息表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
  `id`           int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username`     varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password`     char(36) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL COMMENT '密码',
  `gender`       int(11)                                                NOT NULL COMMENT '性别(0:女,1:男)',
  `email`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone`        char(20) CHARACTER SET utf8 COLLATE utf8_general_ci    NULL DEFAULT NULL COMMENT '电话',
  `avatar`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `salt`         char(36) CHARACTER SET utf8 COLLATE utf8_general_ci    NULL DEFAULT NULL COMMENT '盐值(注册时随机生成)',
  `grade`        int(11)                                                NULL DEFAULT NULL COMMENT '用户等级(0: 管理员, 1: 普通用户, 2: 会员用户...)',
  `status`       int(11)                                                NULL DEFAULT NULL COMMENT '用户状态(0:离线，1:在线，-1:注销)',
  `last_login`   datetime(0)                                            NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `created_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_index` (`username`) USING BTREE,
  UNIQUE INDEX `phone_index` (`phone`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户信息表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
