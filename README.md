# quick-start(v1)

### 介绍

quick-start(v1)是由YoonaDa整合的一个可快速开始写Crud的Demo。该Demo整合了tk.mybatis、MySQL、Redis、Swagger2，编写了一些基本的系统异常类、公共枚举、系统响应类等，同时也有mybatis的逆向工程，可快速生成。

### 使用步骤
##### 1、 git clone -b v1 https://gitlab.com/YoonaDa/quick-start.git
##### 2、 导入 src/main/resources/sql/ 下的quick-start.sql
##### 3、 可以逆向工程生成entity、Dao和XML
######  3.1、修改 src/main/resources/generator/config.properties的tableName

###### 3.2、点击IDEA的右侧"Maven",点击Plugins ==> mybatis-generator ==> mybatis-generator:generator


### Swagger的访问位置：
http://127.0.0.1:9999/api/swagger-ui.html
