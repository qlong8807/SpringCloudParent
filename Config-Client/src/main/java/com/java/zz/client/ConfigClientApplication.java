package com.java.zz.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
}

@RefreshScope
@RestController
class MessageController{
	
	@Value("${foo:sss}")
	private String message;
	
	@RequestMapping("/getMsg")
	public String getMsg() {
		return this.message;
	}
}
