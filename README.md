## springcloud学习例子工程
### springcloud-eureka module
学习eureka注册中心基本使用
eureka-client 服务消费端

1. 启动注册中心(eureka-registry)
mvn spring-boot:run -Dspring.profiles.active=registryCenterA
mvn spring-boot:run -Dspring.profiles.active=registryCenterB

or

java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=registryCenterA
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=registryCenterB


访问
http://localhost:8761/ 或者 http://localhost:8762 可以看到两个注册中心

2. 启动服务提供者(eureka-service)
mvn spring-boot:run -Dspring.profiles.active=serviceA
mvn spring-boot:run -Dspring.profiles.active=serviceB


http://localhost:7001/index 或者 http://localhost:7002/index 打印服务信息

3. 启动服务消费端(springcloud-ribbon)
http://localhost:7001/index