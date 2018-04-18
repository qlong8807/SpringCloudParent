package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

/**
 * @author zyl
 * @date 2018年4月10日
 * @desc 
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application_FeignConsumer {
	
	/**
	 * 添加了这个配置feign才会开启全局日志。否则不会显示调用过程的信息。
	 * 然后在配置文件中配置logging.level.com.java.zz.service.HelloService=DEBUG
	 * @return
	 */
	@Bean
	Logger.Level setLoggerLevel(){
		return Logger.Level.FULL;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application_FeignConsumer.class, args);
	}
}
