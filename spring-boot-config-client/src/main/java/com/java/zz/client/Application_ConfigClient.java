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
public class Application_ConfigClient {

	public static void main(String[] args) {
		SpringApplication.run(Application_ConfigClient.class, args);
	}
	
}

@RefreshScope
@RestController
class MessageController{
	
	@Value("${from:aaa}")
	private String message;
	
	@RequestMapping("/")
	public String getMsg() {
		return "message:"+this.message;
	}
}
