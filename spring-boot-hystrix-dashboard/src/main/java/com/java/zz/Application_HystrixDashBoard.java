package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zyl
 * @date 2018年4月10日
 * @desc 
 */
@EnableHystrixDashboard
@SpringBootApplication
public class Application_HystrixDashBoard {
	
	public static void main(String[] args) {
		SpringApplication.run(Application_HystrixDashBoard.class, args);
	}
}
