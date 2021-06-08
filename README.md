# 一个前后端分离的学习项目

## 开发环境

- JDK 1.8.0_231 (1.8.0_271)   
- Maven 3.6.3 (3.8.1)   
- IntelliJ IDEA 2019.3 (IntelliJ IDEA 2020.3.3)
- Mysql 5.7.17
- SpringBoot 2.3.4.RELEASE
- Zookeeper 3.4.10
- ElasticSearch 7.12.1

## 运行方式

1. git clone https://github.com/lizihang/dm.git
2. 初始化数据库
   1. 在dm-system/src/main/resources/sql目录下找到dm_init.sql
   2. 在navicat中运行此文件
3. 在IDEA中导入项目根目录下的pom.xml文件
4. 主启动类：dm-system/src/main/java/com/dm/DmApplication.java

## 各Module介绍
|Module名称           |Module介绍|备注|  
|:-------------------|:--------- |---| 
|dm-common           |utils类，项目公用vo，基础配置类等    | |
|dm-fund             |财务系统                          | |
|dm-log              |通过SpringAOP实现的日志服务，自定义注解@DmLog        | |
|dm-quartz           |SpringBoot整合Quartz实现定时任务   | |
|dm-system           |系统模块                          | |
|dm-dubbo-api        |分布式服务接口                     | |
|dm-dubbo-consumer   |分布式服务消费者                   | |
|dm-dubbo-provider   |分布式服务提供者                   | |


## SpringBoot整合文档

### [01-SpringBoot整合MyBatis](/document/技术文档/01-SpringBoot整合MyBatis.md)

### [02-SpringBoot整合Druid](/document/技术文档/02-SpringBoot整合Druid.md)

### [03-SpringBoot整合Redis](/document/技术文档/03-SpringBoot整合Redis.md)

### [04-SpringBoot整合SpringSecurity](/document/技术文档/04-SpringBoot整合SpringSecurity.md)

### [05-SpringBoot整合swagger](/document/技术文档/05-SpringBoot整合swagger.md)

### [06-SpringBoot整合Quartz](/document/技术文档/06-SpringBoot整合Quartz.md)

### [07-SpringBoot整合ElasticSearch](/document/技术文档/07-SpringBoot整合ElasticSearch.md)   

### [分布式Demo](/document/技术文档/分布式Demo.md)