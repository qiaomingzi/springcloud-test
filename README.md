## springcloud学习例子工程
### (1)springboot-test module
用户学习springboot基础例子，
1. test/com.example.server.HelloApplicationTests  测试MockMvc
2. main/com.example.annotation.TodoReport  jdk注解例子
3. main/com.example.springannotation.Main  演示@Configuration @Import注解
4. main/com.example.anotaionvalid.BeanValidatorTest 使用注解进行相关bean属性校验
5. main/com.example.MainApplication springboot主入口

### (2)springcloud-eureka module
学习eureka注册中心基本使用,及服务发布及调用过程。
此实验eureka-registry使用两个实列集群；eureka-service提供双实列服务，用于模拟服务断路、服务可用性测试
springcloud-ribbon 服务消费端使用ribbon进行负载均衡调用

#### 1. 启动注册中心(eureka-registry)
mvn spring-boot:run -Dspring.profiles.active=registryCenterA
mvn spring-boot:run -Dspring.profiles.active=registryCenterB

or

java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=registryCenterA
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=registryCenterB


访问
http://localhost:8761/ 或者 http://localhost:8762 可以看到两个注册中心

#### 2. 启动服务提供者(eureka-service)
mvn spring-boot:run -Dspring.profiles.active=serviceA
mvn spring-boot:run -Dspring.profiles.active=serviceB


http://localhost:7001/index 或者 http://localhost:7002/index 打印服务信息

#### 3. 启动服务消费端(springcloud-ribbon)
mvn spring-boot:run

访问
http://localhost:6001/index