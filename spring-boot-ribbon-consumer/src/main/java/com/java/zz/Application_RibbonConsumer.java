package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zyl
 * @date 2018年4月10日
 * @desc 
 */
//@SpringCloudApplication等同于以下三个注解。
//表示该应用为Eureka客户端应用
@EnableEurekaClient
//开启断路器功能
@EnableCircuitBreaker
@SpringBootApplication
public class Application_RibbonConsumer {
	
	//创建一个模板bean，并标识为客户端负载均衡。Ribbon会从注册中心获取服务列表，从而实现客户端负载均衡。
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application_RibbonConsumer.class, args);
	}
}
