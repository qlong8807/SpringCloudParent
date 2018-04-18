package com.java.zz.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class Application_ConfigClientBus {

	public static void main(String[] args) {
		SpringApplication.run(Application_ConfigClientBus.class, args);
	}
	
}

@RefreshScope
@RestController
class MessageController{
	
	@Value("${from:init_value}")
	private String message;
	
	@RequestMapping("/")
	public String getMsg() {
		return "message:"+this.message;
	}
}
