#### Java JDBC



采用mysql DB 8.0.18，

dbconfig.properties: (其中下半段是Hikari所需的参数)

```
! mysql db setting
jdbcUrl=jdbc:mysql://localhost:3306/coffeedb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
db_server=localhost
db_serverport=3306
user=root
password=root

!used for HikariCP
cachePrepStmts=true
prepStmtCacheSize=250
prepStmtCacheSqlLimit=2408
```



maven project加入Mysql的connect J 驱动, 参考官网说明

```
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>8.0.16</version>
	</dependency>  
```



### 使用Hikari: 

###### Hikari 的github地址（**https://github.com/brettwooldridge/HikariCP**)

maven的依赖

```
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
        <version>4.0.2</version>
    </dependency>
```



##### References:

https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html

https://zetcode.com/articles/hikaricp/

https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-overview.html

