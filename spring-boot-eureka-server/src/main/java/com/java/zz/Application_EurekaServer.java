package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Application_EurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(Application_EurekaServer.class, args);
	}
}
