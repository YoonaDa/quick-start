# quick-start

## 介绍
quick-start是由YoonaDa整合的一个可快速开始写Crud的Demo。
该Demo有多个分支，对应不同版本，功能也不相同。master分支默认是和最新的分支相同

### v1版本(在v1分支)
quick-start的v1版本整合了tk.mybatis、MySQL、Redis、Swagger2，编写了一些基本的系统异常类、公共枚举、系统响应类等，
同时也有mybatis的逆向工程，可快速生成。有CRUD的小demo

#### 使用步骤
##### 1、 git clone -b v1 https://github.com/YoonaDa/quick-start.git
##### 2、 导入 src/main/resources/sql/ 下的quick-start.sql
##### 3、 可以逆向工程生成entity、Dao和XML
######  3.1、修改 src/main/resources/generator/config.properties的tableName
###### 3.2、点击IDEA的右侧"Maven",点击Plugins ==> mybatis-generator ==> mybatis-generator:generator

#### Swagger的访问位置：
http://127.0.0.1:9999/api/swagger-ui.html

### v2版本(在v2分支)
quick-start的v2版本是在v1版本的基础上进行改进。
该Demo是基于SpringBoot的2.3.1.RELEASE整合SpringSecurity来实现前后分离权限注解+JWT登录认证,AOP实现自定义日志注解。
同时整合了MyBatis-Plus、MySQL5.7、Redis、Swagger2，编写了一些基本的系统异常类、公共枚举、系统响应类等。
整合了腾讯云短信服务、163邮箱
支持传统的jar包打包,同时也支持Dockerfile打包。

#### 使用步骤
##### 1、 git clone -b v2 https://gitlab.com/YoonaDa/quick-start.git
##### 2、 导入 src/main/resources/sql/ 下的quick-start-v2.sql

#### Swagger的访问位置：
http://127.0.0.1:9999/api/swagger-ui.html