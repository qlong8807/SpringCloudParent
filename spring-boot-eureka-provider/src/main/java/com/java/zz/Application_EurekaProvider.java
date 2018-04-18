package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Application_EurekaProvider {

	public static void main(String[] args) {
		SpringApplication.run(Application_EurekaProvider.class, args);
	}
}
