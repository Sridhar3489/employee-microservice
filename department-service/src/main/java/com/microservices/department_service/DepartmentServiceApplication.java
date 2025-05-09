package com.microservices.department_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DepartmentServiceApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void logZipkinUrl(ApplicationReadyEvent event) {
		System.out.println("Loaded Zipkin base URL: " + event.getApplicationContext().getEnvironment().getProperty("spring.zipkin.base-url"));
	}


}
