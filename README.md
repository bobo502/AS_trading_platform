# AS校园二手交易平台

技术

`mysql5.7+springboot+nacos+dubbo+mybatis+vue`

### `vue`前端

github:https://github.com/bobo502/AS_trading-platform-vue

图片展示的访问地址：[因github网速，请移步访问](http://www.bobostudy.xyz/blogshowdetail?aid=130)

### 项目描述

本项目采用`java`框架`springboot`作为后端，`vue`作为前端的前后端分离项目，本篇描述重点在后端

| 文件夹 | 具体描述 |
|  :---  | :---  |
| deal-bean | 存储公用的实体类和服务类 |
| deal-controller | 接收请求并连接注册中心远程调用user服务和manager服务 |
| deal-userservice | 连接数据库并执行对应用户的sql语句，暴露服务给注册中心 |
| deal-managerservice | 连接数据库并执行对应管理员的sql语句，暴露服务给注册中心 |
| img | 存放前端截图 |
| trading_platform.sql | 数据库文件 |

### 快速开始

1.构建数据库

> 数据库文件已经上传，具体见trading_lpaform.sql,下载并自己创建数据库，然后在数据库中运行该文件

2.下载Nacos

> 本项目用到了阿里巴巴的Nacos作为注册中心，请下载1.2.0版本，启动项目前先运行该软件

3.修改userservice和mangerservice项目中的application.properties配置文件的mybatis配置

4.修改deal-controller下的config -->WebMvcConfig,配置文件夹路径为自己创建的路径，该代码意思是将/image/下的url路径映射到本地的文件夹中，文件夹自己创建即可

修改util下的EmailUtil,设置 26 、38 、46行中的邮箱和授权码为自己的，如何开通授权码请自行百度

修改util下的picUtil中的本地存入格式为前面创建的路径

5.运行项目顺序  

deal-userservice -> deal-managerservice ->deal-controller

因为如果先运行deal-controller项目，该项目从nacos中找不到服务会报错

6.测试

下载前端项目，并运行

用户：1409009852@qq.com 密码：123

管理员：1409009853@qqq.com 密码：123

### 项目进度

| 功能模块 | 情况 |
|  ----  | ----  |
| 用户发布商品 | 完成 |
| 用户发送求购信息 | 完成 |
| 用户个人信息管理 | 完成 |
| 用户商品信息、求购信息管理 | 完成 |
| 商品信息展示、求购信息展示 | 完成 |
| 开通学校信息 | 完成 |
| 用户注册 | 完成 |
| 管理员商品分类管理 | 完成 |
| 管理员模块 | 待 |
| 用户评论 | 待 |



