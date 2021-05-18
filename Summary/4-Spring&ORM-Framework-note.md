#### Spring 和 ORM 等框架



​        Spring是一个强大的Java开发框架， 支持DI依赖注入及面向切面（AOP)的编程，具有良好的可扩展性。这是将成熟的设计思想应用到框架设计中，使得Java开发更面向工程应用迈进了一大步。 同时，Spring 管理对象生命周期之后，也改变了编程和协作模式。



##### 依赖注入DI：

​        spring可以通过XML, annotation, 注解类等方式来装配所需要注入的类，借助这种DI方式对象无需知道依赖来自于何处或者依赖的实现方式，依赖对象通常会通过接口了解所注入的对象，以确保低耦合。

​       为了实现依赖注入，可以用java的反射机制，也可以用中间层代理（字节码增强技术)来实现。

​      Bean的加载过程如下图：

​          ![https://github.com/changanjennifer/JAVA-01/blob/main/Summary/images/4-SpringBean-Loadingprocess.png](https://github.com/changanjennifer/JAVA-01/blob/main/Summary/images/4-SpringBean-Loadingprocess.png)

​       Spring bean的配置方式也是在不断演进中， 提供了多种配置方法多种，参见表1：

​        表1： Spring Bean的配置方法

| 注解Anotation              | 版本及功能      | 方式              |
| -------------------------- | --------------- | ----------------- |
| XML  @AutoWire             | 1.0和2.0        | XML配置、注解注入 |
| @Service                   | 2.5             | 半自动注解配置    |
| @Bean @Configuration       | 3.0             | Java config配置   |
| @Condition @AutoConfigureX | 4.0、SpringBoot | 全自动注解配置    |

​         

##### Spring 对AOP的支持：

​       使得之前要分散到应用各处的重复行为（例如日志、事务和安全等）放入可重用的模块中，有效减少了代码冗余，将系统解耦，让我们的类关注自身的主要功能。其AOP框架能帮助将切面织入到方法执行的周围，以及自定义处理异常增加自定义的行为。 

​       为了实现AOP，可以使用java的动态代理，也可以使用中间代理层，字节码增强（例如CGLib等技术)来实现。

​       Spring支持4种方式的切面注解，基于代理的经典的Spring AOP、纯POJO切面、@AspectJ注解驱动的切面和注入式AspecctJ切面 

​       其中使用AspectJ注解来声明通知方法，支持5种注入点 After,AfterReturning,AfterThrowing, Before, Around。 以及通知此启用自动代理，及切点的定义。表2给出了aspectJ注解和基于XML配置的列表，两种方法是等价的，使用时遵循其语法进行配置即可。

表2： AspectJ和基于XML的AOP配置

| AspectJ配置元素 | 用途                                                         | AOP配置元素               | 用途                                                         |
| --------------- | ------------------------------------------------------------ | ------------------------- | ------------------------------------------------------------ |
|                 | 需要在JavaConfig中加上@EnableAspectJAutoProxy注解 启动自动代理功能 | \<aop:aspectj-autoproxy/> | 启用@Aspectj注解却动的切面                                   |
|                 |                                                              | \<aop:config>             | 顶层的AOP配置元素，大多数的\<aop:*>元素必须包含在\<aop:config>元素内 |
|                 |                                                              | \<aop:declare-parents>    | 以透明的方式为被通知的对象引入额外的接口                     |
| @Aspect         | 定义POJO类为一个切面，                                       | \<aop:advisor>            | 定义AOP通知器                                                |
| @After          | 通知方法会在目标方法返回或抛出异常后调用                     | \<aop:after>              | 定义AOP后置通知(不管通知方法是否执行成功)                    |
| @AfterReturning | 通知方法会在目标方法返回后调用                               | \<aop:after-returning>    | 定义AOP返回通知                                              |
| @AfterThrowing  | 通知方法会在目标方法抛出异常后调用                           | \<aop:after-throwing>     | 定义AOP异常通知                                              |
| @Around         | 通知方法会在目标方法封装起来                                 | \<aop:around>             | 定义AOP环绕通知                                              |
| @Before         | 通知方法会在目标方法调用之前执行                             | \<aop:before>             | 定义一个AOP前置通知                                          |
| @Pointcut       | 声明频繁使用的切点                                           | \<aop:pointcut>           | 定义一个切点                                                 |
|                 |                                                              |                           |                                                              |

##### Spring的强大及集成功能：

​           除了DI和AOP特性之外，Spring框架的主要6大模块为：

1. 核心组件：Bean/Context和AOP， 

2. 测试Test模组：Spring 提供了强大的UT测试及集成测试功能。 为servlet，Portlet等对象提供了一系列Mock对象实现。在集成测试方面，可加载Spring ApplicationContext的Bean集合以及与Spring上下文中的bean进行交互。

3. DataAccess功能包括： Tx事务处理，JDBC和ORM， 

4. Web框架：SpringMVC /WebFlux

   

5. 集成功能： Remoting远程服务调用, JMS(支持常用的MQ)和websocket. 

6. 语言方面支持Kotlin和groovy.  

​       

##### SpringBoot：

​     Spring是不断演进的架构，为了简化开发和配置，让运行变得简单，Spring团队在去Web容器化方面进行了诸多努力，并基于maven和POM的java生态，整合POM模板，诞生了Springboot这一生产级别的脚手架应用。它能创建独立运行的Spring应用，直接嵌入Tomcat或jetty ,无需部署war包，提供starter脚手架，整合了第三方类库和协同工具，提供生产production-ready特性，是工业级的生产框架。



##### ORM框架：

​     Java的ORM框架是在java的JDBC基础上发展而来，能加速数据库OR Mapping及DB访问的处理。主要的流行框架有Hibernate, mybatis （SQL 与配置文件的形式，SQL与程序分离， SQL写在XML中，降低代码耦合度，分工更为方便，维护性好，方便监控、调优）等。 Spring支持上述流行的ORM框架，Spring的事务管理支持所有的流行ORM框架以及JDBC。 

Hibernate 移植性好，日志系统比较健全， 但与java代码结合的比较紧密。

Mybatis 小巧简单，mybatis 将SQL 与开发代码分离,  方便DBA与程序员分工协作。



##### 其他相关框架：

​    Guava：是Google推出的开源java库， 提供了集合、缓存方面的功能，支持原语、并发性、常见注解、字符串处理，I/O和验证的使用方法，是经过高度优化的类库。

​    lombok 是基于JSR269实现的java类库，会利用注解自动生成java bean中啰嗦的get/set及有参、无参的构造函数，还能自动生成Logger, ToString\HashCode, Builder等java特色的函数或是符合设计模式的方法，能让java代码更简洁美观。 它基于字节码增强技术，在编译期处理。

