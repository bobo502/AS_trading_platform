/*
 Navicat Premium Data Transfer

 Source Server         : trading_platform
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : trading_platform

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 18/05/2020 19:37:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buy_information
-- ----------------------------
DROP TABLE IF EXISTS `buy_information`;
CREATE TABLE `buy_information`  (
  `buy_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `buy_price` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `logo_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`buy_id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `buy_information_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buy_information
-- ----------------------------
INSERT INTO `buy_information` VALUES (2, '二手自行车', '一辆二手的山地自行车，接受组装，不要太旧', '200-400', 10, 'http://localhost:8001/image/ForBuy/23d7c5ce378c4e87ab84f2c89e14bf5e.jpg', '2020-05-11 20:20:07');
INSERT INTO `buy_information` VALUES (3, '机械键盘', '青轴的。两年内，', '100-150', 10, 'http://localhost:8001/image/ForBuy/6bf7e9fdeee5453db44d004b07786de9.jpg', '2020-05-13 15:02:30');
INSERT INTO `buy_information` VALUES (4, '手机', '苹果，三星', '1500-2000', 10, 'http://localhost:8001/image/ForBuy/af7e01569d91444089df1051423b04b8.jpg', '2020-05-13 15:02:30');
INSERT INTO `buy_information` VALUES (5, '小音箱', '小米', '100-200', 10, 'http://localhost:8001/image/ForBuy/c47df7070470445a8f7fb52f17ea1390.jpg', '2020-05-13 15:02:30');
INSERT INTO `buy_information` VALUES (6, '测试', '123', '615', 10, 'http://localhost:8001/image/ForBuy/3db6fa5377c04d55a4c544f96a22d85f.jpg', '2020-05-13 15:02:30');

-- ----------------------------
-- Table structure for buy_tags
-- ----------------------------
DROP TABLE IF EXISTS `buy_tags`;
CREATE TABLE `buy_tags`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buy_tags
-- ----------------------------
INSERT INTO `buy_tags` VALUES (28, 2, '价格可谈');
INSERT INTO `buy_tags` VALUES (29, 2, '欢迎来撩');
INSERT INTO `buy_tags` VALUES (30, 2, '非诚勿扰');
INSERT INTO `buy_tags` VALUES (31, 3, '原装正品');
INSERT INTO `buy_tags` VALUES (32, 3, '无拆无修');
INSERT INTO `buy_tags` VALUES (33, 3, '如假包退');
INSERT INTO `buy_tags` VALUES (34, 3, '价格可谈');
INSERT INTO `buy_tags` VALUES (35, 4, '原装正品');
INSERT INTO `buy_tags` VALUES (36, 4, '无拆无修');
INSERT INTO `buy_tags` VALUES (37, 4, '如假包退');
INSERT INTO `buy_tags` VALUES (38, 4, '价格可谈');
INSERT INTO `buy_tags` VALUES (39, 5, '原装正品');
INSERT INTO `buy_tags` VALUES (40, 5, '无拆无修');
INSERT INTO `buy_tags` VALUES (41, 5, '价格可谈');
INSERT INTO `buy_tags` VALUES (42, 6, '一口价');
INSERT INTO `buy_tags` VALUES (43, 6, '欢迎来撩');
INSERT INTO `buy_tags` VALUES (44, 6, '非诚勿扰');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '数码产品');
INSERT INTO `category` VALUES (2, '书籍教材');
INSERT INTO `category` VALUES (3, '衣鞋帽伞');
INSERT INTO `category` VALUES (4, '代步工具');
INSERT INTO `category` VALUES (5, '体育健身');
INSERT INTO `category` VALUES (6, '家用电器');
INSERT INTO `category` VALUES (7, '日常用品');
INSERT INTO `category` VALUES (8, '虚拟产品');
INSERT INTO `category` VALUES (9, '手工设计');
INSERT INTO `category` VALUES (10, '乐器');
INSERT INTO `category` VALUES (11, '其他');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `stars` int(1) NOT NULL,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for photos
-- ----------------------------
DROP TABLE IF EXISTS `photos`;
CREATE TABLE `photos`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photos
-- ----------------------------
INSERT INTO `photos` VALUES (9, 1, 'http://localhost:8001/image/Goods/245d56ec9dae42eca14846ad6d6d0aac.jpg');
INSERT INTO `photos` VALUES (10, 2, 'http://localhost:8001/image/Goods/12a64fb1d43544e7bbb7fb3b91d47c66.png');
INSERT INTO `photos` VALUES (11, 3, 'http://localhost:8001/image/Goods/1969d161ae724d1593c2e21bcb289ebc.jpg');
INSERT INTO `photos` VALUES (13, 5, 'http://localhost:8001/image/Goods/04fadbafd3404fed8be893484101325e.png');
INSERT INTO `photos` VALUES (14, 6, 'http://localhost:8001/image/Goods/fd5601a1240b4e17bc2ca0e853253ca6.png');
INSERT INTO `photos` VALUES (16, 8, 'http://localhost:8001/image/Goods/630539bd89504445a63a6d538e1000fe.png');
INSERT INTO `photos` VALUES (17, 8, 'http://localhost:8001/image/Goods/3536350fcd7b4ccfaf3f93a2c3e111a4.jpg');
INSERT INTO `photos` VALUES (18, 8, 'http://localhost:8001/image/Goods/7f1ad74061d24401986384711f086489.jpg');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品标题',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品简介',
  `bid_price` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标价',
  `original_price` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '原价',
  `reclassify_id` int(11) DEFAULT NULL COMMENT '分类id',
  `postage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '魅族手机Note6', '手机屏幕6.0寸，晓龙850处理器', '1000', '3000', 1, '商议', 10, '2020-05-09 11:08:26');
INSERT INTO `product` VALUES (2, '惠普电脑', '游戏本', '2500', '6500', 7, '商议', 10, '2020-05-09 11:08:26');
INSERT INTO `product` VALUES (3, '平板', '苹果mini', '2000', '5000', 6, '商议', 10, '2020-05-09 11:08:26');
INSERT INTO `product` VALUES (5, '笔记本', '联想小新650', '1500', '4000', 7, '商议', 10, '2020-05-09 11:08:26');
INSERT INTO `product` VALUES (6, '电脑', '测试', '500', '1200', 8, '商议', 10, '2020-05-10 20:24:38');
INSERT INTO `product` VALUES (8, '很帅的电脑', '两年前买的', '1200', '5200', 8, '商议', 10, '2020-05-11 12:00:45');

-- ----------------------------
-- Table structure for reclassify
-- ----------------------------
DROP TABLE IF EXISTS `reclassify`;
CREATE TABLE `reclassify`  (
  `reclassify_id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `reclassify` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`reclassify_id`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `reclassify_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reclassify
-- ----------------------------
INSERT INTO `reclassify` VALUES (1, 1, '手机', 'http://localhost:8001/image/university/48b35d1d437544f0a7c4f842591057a5.jpg');
INSERT INTO `reclassify` VALUES (6, 1, '平板', 'http://localhost:8001/image/university/b950e561b7014a24a733ad9d213a84b2.jpg');
INSERT INTO `reclassify` VALUES (7, 1, '笔记本', 'http://localhost:8001/image/university/3a82829022c34863bfbd9da72b07d0fd.png');
INSERT INTO `reclassify` VALUES (8, 1, '台式机', 'http://localhost:8001/image/university/bb3e4805680e47398bf7ba85a3695c67.jpg');
INSERT INTO `reclassify` VALUES (9, 1, '手表手环', 'http://localhost:8001/image/university/a3704414904f44f2be1e3d4c9209dc83.jpg');
INSERT INTO `reclassify` VALUES (10, 1, '单反相机', 'http://localhost:8001/image/university/7e76ffe212ec4845b0e03ec9c807386a.jpg');
INSERT INTO `reclassify` VALUES (11, 1, '充电宝', 'http://localhost:8001/image/university/283aa3723ce74ea6a12af636732e054d.jpg');
INSERT INTO `reclassify` VALUES (12, 1, '耳机', 'http://localhost:8001/image/university/87f7f47366f64026b9bec8b76d59594e.jpg');
INSERT INTO `reclassify` VALUES (13, 1, '手机配件', 'http://localhost:8001/image/university/78530377cb964ba5b29a0211b6776e65.jpg');
INSERT INTO `reclassify` VALUES (14, 1, '电脑配件', 'http://localhost:8001/image/university/c0f0e14baefe47a8913e403646dfa59b.jpg');
INSERT INTO `reclassify` VALUES (15, 1, '路由器', 'http://localhost:8001/image/university/2846296e64a84f00aab76948c832c65f.jpg');
INSERT INTO `reclassify` VALUES (16, 1, '其他', 'http://localhost:8001/image/university/d33b43c941fa45e68c16ada5e89e6a1d.png');
INSERT INTO `reclassify` VALUES (17, 2, '教科书', 'http://localhost:8001/image/university/cd0bc945ee7a4f61af50aaf345f35bd3.jpg');
INSERT INTO `reclassify` VALUES (18, 2, '文学', 'http://localhost:8001/image/university/92da880aa60c408d812dffc4ac0f0f19.jpg');
INSERT INTO `reclassify` VALUES (19, 2, '小说', 'http://localhost:8001/image/university/c478a1b35e664f6e884b2193b10ed524.jpg');
INSERT INTO `reclassify` VALUES (20, 2, '电子书', 'http://localhost:8001/image/university/998fe75b9e1a40c28cad1f8572cf2db4.png');
INSERT INTO `reclassify` VALUES (21, 2, '教育考试', 'http://localhost:8001/image/university/4bae02b41bd54993b6050e6384e0fa25.jpg');
INSERT INTO `reclassify` VALUES (22, 2, '动漫', 'http://localhost:8001/image/university/a52220a2c8c44a868ae1f5bdc581f08a.jpg');
INSERT INTO `reclassify` VALUES (23, 2, '其他', 'http://localhost:8001/image/university/9e5a30e3af254b708ae0aa950c424d92.png');
INSERT INTO `reclassify` VALUES (24, 3, '裙子', 'http://localhost:8001/image/university/f0a71a88638c47f6a5b863056149b864.jpg');
INSERT INTO `reclassify` VALUES (25, 3, '裤子', 'http://localhost:8001/image/university/7c2036bd3ef64b92bbdad83d1d559849.jpg');
INSERT INTO `reclassify` VALUES (26, 3, '帽子', 'http://localhost:8001/image/university/eae65a67ea3e4ac495038c1b200a079b.jpg');
INSERT INTO `reclassify` VALUES (27, 3, '衣服', 'http://localhost:8001/image/university/e9cc0638c798449a8d2e09f932dacde4.jpg');
INSERT INTO `reclassify` VALUES (28, 3, '鞋子', 'http://localhost:8001/image/university/26458b24b7d7473194694ec3a19774f6.jpg');
INSERT INTO `reclassify` VALUES (29, 3, '箱子', 'http://localhost:8001/image/university/97d9a7dec9604a3e8d4283a752f3a549.jpg');
INSERT INTO `reclassify` VALUES (30, 3, '包包', 'http://localhost:8001/image/university/92e22e6de0354ef3a3c4bca88d6020dc.jpg');
INSERT INTO `reclassify` VALUES (31, 3, '雨伞', 'http://localhost:8001/image/university/bc2bc3c8afde4fb4a0a896b2b236b5bb.jpg');
INSERT INTO `reclassify` VALUES (32, 3, '其他', 'http://localhost:8001/image/university/4be1be1ce739448fa39b36e26c329e4f.png');
INSERT INTO `reclassify` VALUES (33, 4, '自行车', 'http://localhost:8001/image/university/e508b9a1558b428586a79a2c635c184a.jpg');
INSERT INTO `reclassify` VALUES (34, 4, '旱冰鞋', 'http://localhost:8001/image/university/9aea04bdf3534b47bce0a3835b3ee699.jpg');
INSERT INTO `reclassify` VALUES (35, 4, '平衡车', 'http://localhost:8001/image/university/cb5b68175b26447e902a83d2010dd146.jpg');
INSERT INTO `reclassify` VALUES (36, 4, '滑板', 'http://localhost:8001/image/university/c5d16710a261401eb1eb62f876ec3af1.jpg');
INSERT INTO `reclassify` VALUES (37, 4, '油车', 'http://localhost:8001/image/university/2648fdf76cfa467e89e0c9493e763f31.jpg');
INSERT INTO `reclassify` VALUES (38, 4, '电动车', 'http://localhost:8001/image/university/36e00fe0dac944ecae6053eabbc6d000.jpg');
INSERT INTO `reclassify` VALUES (39, 4, '其他', 'http://localhost:8001/image/university/2a1b287133924bee8d142044f2cbf3dc.png');
INSERT INTO `reclassify` VALUES (40, 5, '球类', 'http://localhost:8001/image/university/c9d144280b864ac993a4f6ce5391fd19.jpg');
INSERT INTO `reclassify` VALUES (41, 5, '球拍', 'http://localhost:8001/image/university/d1fb93d9e137474da342523e753bef0b.jpg');
INSERT INTO `reclassify` VALUES (42, 5, '运动鞋', 'http://localhost:8001/image/university/db4226a4b7a34871b63f2f8d890a141f.jpg');
INSERT INTO `reclassify` VALUES (43, 5, '运动装备', 'http://localhost:8001/image/university/17c204b51ca04067b0d31b744b2fdc8a.jpg');
INSERT INTO `reclassify` VALUES (44, 5, '健身装备', 'http://localhost:8001/image/university/d697dba4de524c789364e7503c915c1a.jpg');
INSERT INTO `reclassify` VALUES (45, 5, '其他', 'http://localhost:8001/image/university/e112e3df618a484484935317090de408.png');
INSERT INTO `reclassify` VALUES (46, 6, '电磁炉', 'http://localhost:8001/image/university/7dccae2f6a754e588af4cdb1e36ddcfc.jpg');
INSERT INTO `reclassify` VALUES (47, 6, '洗衣机', 'http://localhost:8001/image/university/9d680939217d44eea7887c5303615fbf.jpg');
INSERT INTO `reclassify` VALUES (48, 6, '冰箱', 'http://localhost:8001/image/university/977408cfaed742298e93068007852647.jpg');
INSERT INTO `reclassify` VALUES (49, 6, '风扇', 'http://localhost:8001/image/university/1678c5aff2034ce19684a060099ea753.jpg');
INSERT INTO `reclassify` VALUES (50, 6, '电饭煲', 'http://localhost:8001/image/university/ae99a042f44d40e99f2338bd5b72addf.jpg');
INSERT INTO `reclassify` VALUES (51, 6, '豆浆机', 'http://localhost:8001/image/university/a1e1fe78a1204d0b8a8f23419e2dee84.jpg');
INSERT INTO `reclassify` VALUES (52, 6, '电吹风', 'http://localhost:8001/image/university/876ed2ecac074234839e5a345dd4df38.jpg');
INSERT INTO `reclassify` VALUES (53, 6, '音响', 'http://localhost:8001/image/university/648b0c834e3847558cd3852519747943.jpg');
INSERT INTO `reclassify` VALUES (54, 6, '其他', 'http://localhost:8001/image/university/b095e078043e4e1c8d7816cb7444792f.png');
INSERT INTO `reclassify` VALUES (55, 7, '化妆护肤', 'http://localhost:8001/image/university/2fbe6a1c87b54c7f8509215de72e3966.jpg');
INSERT INTO `reclassify` VALUES (56, 7, '小工具', 'http://localhost:8001/image/university/75f41e32bb34409086902602a544e050.jpg');
INSERT INTO `reclassify` VALUES (57, 7, '学习用品', 'http://localhost:8001/image/university/d11513ede7d846c6b95690d2148768a1.jpg');
INSERT INTO `reclassify` VALUES (58, 7, '其他', 'http://localhost:8001/image/university/6674e7cf1e1f4fe4ada8d02331dcd7e9.png');
INSERT INTO `reclassify` VALUES (61, 8, '游戏周边', 'http://localhost:8001/image/university/32b6b9da0d5f428687662af8301b052b.jpg');
INSERT INTO `reclassify` VALUES (62, 8, '充值卡', 'http://localhost:8001/image/university/3889a80d4e674d21ba6d4a226079221b.jpg');
INSERT INTO `reclassify` VALUES (63, 8, '各种账号', 'http://localhost:8001/image/university/4f5c280099174bfba4ae40155e1af8f4.jpg');
INSERT INTO `reclassify` VALUES (64, 8, '其他', 'http://localhost:8001/image/university/fa2c544d5db5461990ad53aaaea98e9f.png');
INSERT INTO `reclassify` VALUES (65, 9, '书法', 'http://localhost:8001/image/university/a431e147afd640aeb0b5d3ea5790c80c.jpg');
INSERT INTO `reclassify` VALUES (66, 9, '绘画', 'http://localhost:8001/image/university/db4999d4598a4a0ba7909cef6b168117.jpg');
INSERT INTO `reclassify` VALUES (67, 9, '工艺品', 'http://localhost:8001/image/university/c7923d88f09040e39c1bd1e06ff4ccfe.jpg');
INSERT INTO `reclassify` VALUES (68, 9, '服装设计', 'http://localhost:8001/image/university/895db5d313fd4a108ac3a3aebde48a20.jpg');
INSERT INTO `reclassify` VALUES (69, 9, '其他', 'http://localhost:8001/image/university/cd82af2baf264d24b0fa20b75f443ffe.png');
INSERT INTO `reclassify` VALUES (70, 10, '吉他', 'http://localhost:8001/image/university/b85556e4ad364d67b2324d2a4671ad56.jpg');
INSERT INTO `reclassify` VALUES (71, 10, '钢琴', 'http://localhost:8001/image/university/70c9f724a1204ed79194e117bf9ef7b0.jpg');
INSERT INTO `reclassify` VALUES (72, 10, '尤克里里', 'http://localhost:8001/image/university/06624b702864487d89d7a482e9c7197d.jpg');
INSERT INTO `reclassify` VALUES (73, 10, '民族管弦', 'http://localhost:8001/image/university/30b35372aabb44ec9a67f71dbb0c468e.jpg');
INSERT INTO `reclassify` VALUES (74, 10, '西洋管弦', 'http://localhost:8001/image/university/0f61321520124c3c81d4d039975fbdb5.jpg');
INSERT INTO `reclassify` VALUES (75, 10, '打击乐器', 'http://localhost:8001/image/university/1a0a53ad58054549b48024cb2fcf4ac6.jpg');
INSERT INTO `reclassify` VALUES (76, 10, '乐器配件', 'http://localhost:8001/image/university/1f6a31a868654d89a7d4b0afb210e651.jpg');
INSERT INTO `reclassify` VALUES (77, 10, '电脑音乐', 'http://localhost:8001/image/university/151df1da294044c28956866d3e5a86ed.jpg');
INSERT INTO `reclassify` VALUES (78, 10, '口琴/竖琴', 'http://localhost:8001/image/university/d77e2856763e4f1fb65567d42262514f.jpg');
INSERT INTO `reclassify` VALUES (79, 10, '电子琴', 'http://localhost:8001/image/university/5798eabf690d4bfe9822cbee9d2884a9.jpg');
INSERT INTO `reclassify` VALUES (80, 11, '其他', 'http://localhost:8001/image/university/0ba5a2d8316049049ed436340dfaacf0.png');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roles` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, '普通用戶');
INSERT INTO `roles` VALUES (2, '管理员');

-- ----------------------------
-- Table structure for roles_user
-- ----------------------------
DROP TABLE IF EXISTS `roles_user`;
CREATE TABLE `roles_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of roles_user
-- ----------------------------
INSERT INTO `roles_user` VALUES (2, 2, 9);
INSERT INTO `roles_user` VALUES (3, 1, 10);

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES (57, 1, '原装正品');
INSERT INTO `tags` VALUES (58, 1, '无拆无修');
INSERT INTO `tags` VALUES (59, 1, '如假包退');
INSERT INTO `tags` VALUES (60, 1, '一口价');
INSERT INTO `tags` VALUES (61, 1, '欢迎来撩');
INSERT INTO `tags` VALUES (62, 2, '原装正品');
INSERT INTO `tags` VALUES (63, 2, '一口价');
INSERT INTO `tags` VALUES (64, 2, '欢迎来撩');
INSERT INTO `tags` VALUES (65, 2, '非诚勿扰');
INSERT INTO `tags` VALUES (66, 3, '无拆无修');
INSERT INTO `tags` VALUES (67, 3, '如假包退');
INSERT INTO `tags` VALUES (68, 3, '一口价');
INSERT INTO `tags` VALUES (69, 3, '欢迎来撩');
INSERT INTO `tags` VALUES (70, 3, '非诚勿扰');
INSERT INTO `tags` VALUES (82, 6, '一口价');
INSERT INTO `tags` VALUES (81, 5, '非诚勿扰');
INSERT INTO `tags` VALUES (80, 5, '欢迎来撩');
INSERT INTO `tags` VALUES (79, 5, '一口价');
INSERT INTO `tags` VALUES (78, 5, '如假包退');
INSERT INTO `tags` VALUES (77, 5, '原装正品');
INSERT INTO `tags` VALUES (83, 6, '欢迎来撩');
INSERT INTO `tags` VALUES (84, 6, '非诚勿扰');
INSERT INTO `tags` VALUES (90, 8, '价格可谈');
INSERT INTO `tags` VALUES (91, 8, '一口价');
INSERT INTO `tags` VALUES (92, 8, '欢迎来撩');
INSERT INTO `tags` VALUES (93, 8, '非诚勿扰');

-- ----------------------------
-- Table structure for university
-- ----------------------------
DROP TABLE IF EXISTS `university`;
CREATE TABLE `university`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `university` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of university
-- ----------------------------
INSERT INTO `university` VALUES (1, '肇庆学院', 'http://localhost:8001/image/school/560ae251dcaa4ea7bc4f6e34e0d08f57.png', 1);
INSERT INTO `university` VALUES (2, '广州大学', 'http://localhost:8001/image/school/560ae251dcaa4ea7bc4f6e34e0d08f57.png', 1);
INSERT INTO `university` VALUES (3, '五邑大学', 'http://localhost:8001/image/school/50c41cd9a6ca432a86c1ee1b8145ab9f.jpg', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `head_portrait` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `university_id` int(30) DEFAULT NULL,
  `email` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `real_name` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `personalized_signature` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `count` int(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `wechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`, `email`) USING BTREE,
  INDEX `university_id`(`university_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `university_id` FOREIGN KEY (`university_id`) REFERENCES `university` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, NULL, NULL, NULL, '1409009452@qq.com', NULL, NULL, NULL, 3, '$2a$10$Ft0IodW4F5MXLzDSbD/C5uG7Y8iSunS5jbtMOp7r4FxCnHtBDTOCC', NULL, NULL);
INSERT INTO `user` VALUES (9, NULL, NULL, NULL, '1409009853@qq.com', NULL, NULL, NULL, 3, '$2a$10$z6RRrbGWhbxdCh0tK/8IgON3fOjqJ2li/guNNZl8ErwxY281yX7ei', NULL, NULL);
INSERT INTO `user` VALUES (10, '在下波波君', 'http://localhost:8001/image/User/b84e1729feec469190f6f368f22d0ccc.jpg', 1, '1409009852@qq.com', '123', 1, '今天的心情不错，多跑跑步', 1, '$2a$10$WKQbAhO/amFUvZbkT8vAx.qf6T7CaC3Slju3yOTiV0UNqzFKtbLh2', '1409009852', '18023649297');

SET FOREIGN_KEY_CHECKS = 1;
