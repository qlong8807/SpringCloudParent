package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author zyl
 * @date 2018年4月10日
 * @desc 
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class Application_Turbine {
	
	public static void main(String[] args) {
		SpringApplication.run(Application_Turbine.class, args);
	}
}
