# employee-microservice

### service-registry
- Eureka Server
- service-registry is a server, it should not consider itself as a client

### department-service
- Spring Web
- Eureka Discovery Client
- Spring Boot Actuator

### employee-service
- Spring Web
- Zipkin
- Config Client - to connect to config server
- Eureka Discovery Client - to connect to service registry
- 
``` bash
export SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8088
export EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka
export SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8088    
export SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/db
export SPRING_DATASOURCE_USERNAME=root
export SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.MySQL8Dialect
export SPRING_JPA_HIBERNATE_DDL_AUTO=update
export SPRING_DATASOURCE_PASSWORD=password
```