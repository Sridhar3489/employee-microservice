package com.microservices.config_server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	private static final Logger log = LoggerFactory.getLogger(ConfigServerApplication.class);

	public static void main(String[] args) {
		log.info("Hi Zipkin Server");
		SpringApplication.run(ConfigServerApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void logZipkinUrl(ApplicationReadyEvent event) {
		System.out.println("Loaded Zipkin base URL: " + event.getApplicationContext().getEnvironment().getProperty("spring.zipkin.base-url"));
	}

//	@RestController
//	@GetMapping
//	public String hello() {
//		log.info("Hello World");
//		return "Hello World";
//	}

}
