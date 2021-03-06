# eboot

---
    基于springboot开发的脚手架，旨在迅速搭建开发平台。采用分布式架构，
    集群部署方式。适用于中小型项目开发，具备快速集成，快速上手的特点。

# 使用技术

---
    1、基础框架：springboot + mybatis + springcloud
    2、权限框架：shiro
    3、缓存：redis
    4、数据库：mysql
    5、UI：LayUI
    6、session共享：spring-session-redis
    7、服务器端Java模板引擎：thymeleaf
    8、集成WebSocket
# 包含模块

---
    1、系统管理
        1.1 用户管理
        1.2 角色管理
        1.3 权限分配
        1.4 字典管理
    2、报表模块
        2.1 Echarts集成
    3、导入导出
        3.1 Excel的导入导出
        3.2 简单word的导出
# 模块说明

---
    0.eboot-actuator：服务监控
    1.eboot-admin：后台管理系统
    2.eboot-api：给移动端提供接口服务，集成jwt认证
    3.eboot-entity：实体类
    4.eboot-file：文件服务
    5.eboot-provider：服务注册中心
    6.eboot-service：业务处理服务接口
    7.eboot-tools：工具包
    8.eboot-web：PC/Wap服务
    9.eboot-consumer：消息队列消费者
    10.eboot-websocket： 在线聊天
    11.eboot-email：集成主流邮箱，发送邮件接口
## eboot-api简介
---
	eboot-api使用介绍：
		1: eboot-api对外接口实现token验证机制才能实现各个接口的调用
		2:  使用token验证技术：springboot+springsecurity+jwt
		3:怎么才能获取到token呢：地址为http://localhost:端口/login 此login地址为内置访问地址，在启动完成后，就可以访问 post方式；
		4:默认访问账户密码：username:superadmin  password:123456 
		5:数据库sql 请加QQ群：389863968
		
# eboot-email简介

---
    基于springboot开发的email发送邮件实现工具类，旨在迅速搭建开发邮件服务平台。

# 使用技术

---
    1、基础框架：springboot + spring-boot-starter-mail
# 几个名词解释

---
    	什么是POP3、SMTP和IMAP？详细介绍-请移步至网易帮助文档
	IMAP和POP3有什么区别？详细介绍-请移步至网易帮助文档
	什么是免费邮箱客户端授权码功能？详细介绍-请移步至网易帮助文档


# Spring Boot中发送邮件步骤

---
    0.添加Starter模块依赖
    1.添加Spring Boot配置(QQ/网易系/Gmail)
    2.调用JavaMailSender接口发送邮件
    		0.1	添加Starter模块依赖
    			<dependency>
    				<groupId>org.springframework.boot</groupId>
    				<artifactId>spring-boot-starter-mail</artifactId>
			</dependency>
		1.1 添加Spring Boot配置
			在application.yml中添加邮件相关的配置，这里分别罗列几个常用邮件的配置比如QQ邮箱、网易系邮箱、Gmail邮箱。
			1.1.1	QQ邮箱配置：说明：开启SSL时使用587端口时无法连接QQ邮件服务器
						spring:
						  mail:
						    host: smtp.qq.com #发送邮件服务器
						    username: xx@qq.com #QQ邮箱
						    password: xxxxxxxxxxx #客户端授权码
						    protocol: smtp #发送邮件协议
						    properties.mail.smtp.auth: true
						    properties.mail.smtp.port: 465 #端口号465或587
						    properties.mail.display.sendmail: Javen #可以任意
						    properties.mail.display.sendname: Spring Boot Guide Email #可以任意
						    properties.mail.smtp.starttls.enable: true
						    properties.mail.smtp.starttls.required: true
						    properties.mail.smtp.ssl.enable: true
						    default-encoding: utf-8
						    from: xx@qq.com #与上面的username保持一致
					
			1.1.2	网易系(126/163/yeah)邮箱配置
					126邮箱SMTP服务器地址:smtp.126.com,端口号:465或者994
					163邮箱SMTP服务器地址:smtp.163.com,端口号:465或者994
					yeah邮箱SMTP服务器地址:smtp.yeah.net,端口号:465或者994
						spring:
						  mail:
						    host: smtp.126.com
						    username: xx@126.com
						    password: xxxxxxxx
						    protocol: smtp
						    properties.mail.smtp.auth: true
						    properties.mail.smtp.port: 994 #465或者994
						    properties.mail.display.sendmail: Javen
						    properties.mail.display.sendname: Spring Boot Guide Email
						    properties.mail.smtp.starttls.enable: true
						    properties.mail.smtp.starttls.required: true
						    properties.mail.smtp.ssl.enable: true
						    default-encoding: utf-8
						    from: xx@126.com
						    
			1.1.3	Gmail邮箱配置
						spring:
						  mail:
						    host: smtp.gmail.com
						    username:xxx@gmail.com
						    password: xxxxx #Gmail账号密码
						    protocol: smtp
						    properties.mail.smtp.auth: true
						    properties.mail.smtp.port: 465
						    properties.mail.display.sendmail: Javen
						    properties.mail.display.sendname: Spring Boot Guide Email
						    properties.mail.smtp.starttls.enable: true
						    properties.mail.smtp.starttls.required: true
						    properties.mail.smtp.ssl.enable: true
						    from: xxx@gmail.com
						    default-encoding: utf-8								    						    

# 运行步骤

---
    1、创建数据库：eboot，导入eboot-admin/src/main/resources/sql/v{x}.sql
    2、导入项目，下载maven依赖
    3、配置eboot-service中的数据库信息
    4、配置eboot-admin/eboot-api中的redis信息
    5、配置eboot-file中的文件上传路径
    6、依次启动eboot-provider、eboot-file、eboot-service、eboot-admin
    7、访问 [首页](http://localhost:8882/index),默认用户名：superadmin，密码：123456

# 其他
    欢迎各位有什么需要的可以Issue提出来，我会视情况而定集成进来，尽量简化大家的工作
    项目肯定有很多不足之处，大家多提宝贵意见，多谢^_^
# 部分页面截图
![登录](https://gitee.com/uploads/images/2018/0514/173817_401f4989_660787.png "login.png")
![首页](https://gitee.com/uploads/images/2018/0514/173051_16baa875_660787.png "index.png")
![登录统计](https://gitee.com/uploads/images/2018/0514/173130_d65ff447_660787.png "login_report.png")
![菜单添加](https://gitee.com/uploads/images/2018/0514/173141_4a33e5f2_660787.png "menu_add.png")
![角色详情](https://gitee.com/uploads/images/2018/0514/173154_8bb32a20_660787.png "role_detail.png")
![角色授权](https://gitee.com/uploads/images/2018/0514/173204_68287e03_660787.png "role_permit.png")
![用户列表](https://gitee.com/uploads/images/2018/0514/173213_e00fc2d5_660787.png "user_index.png")
