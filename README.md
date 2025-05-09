# employee-microservice

### service-registry
- Eureka Server
- service-registry is a server, it should not consider itself as a client

### department-service
- Spring Web
- Eureka Discovery Client
- Spring Boot Actuator
- Config Client
- Spring Reactive Web - webflux

### config-server
- Config Server from Spring Cloud Gateway
- All other services must use this config server to get their configurations
- By default, it will use the git repository to get the configurations
- `spring.profiles.active=native` to use the native profile
- All the configurations of multiple services are in the `src/main/resources` directory
``` yml
#server:
#  port: 8081

spring:
  application:
    name: department-service

#eureka:
#  client:
#    serviceUrl:
#      defaultZone: ${EUREKA_CLIENT_SERVICEURL_DEFAULTZONE}
```
- Only the application name is required in the configuration file of the service, rest of the configurations will be fetched from the config server

### Zipkin
- https://hub.docker.com/r/openzipkin/zipkin/
- 9411
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

### Http Exchange
- Connecting employee-service to department-service

### API Gateway
- Spring Cloud Gateway
- Reactive Gateway
- Config Client
- Eureka Discovery Client
- Zipkin
`lb://employee-service` to connect to employee-service
`lb://department-service` to connect to department-service
- In case of docker, `http://container-name`