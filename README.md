# employee-microservice

### service-registry
- Eureka Server
- service-registry is a server, it should not consider itself as a client

### department-service
- Spring Web
- Eureka Discovery Client
- Spring Boot Actuator
- Config Client

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