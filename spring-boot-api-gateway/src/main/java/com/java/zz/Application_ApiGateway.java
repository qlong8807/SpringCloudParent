package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.java.zz.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class Application_ApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(Application_ApiGateway.class, args);
	}
	
	/**
	 * 添加filter后，需要在请求的路径后面加上&accessToken=any
	 * @return
	 */
	@Bean
	public AccessFilter getAccessFilter() {
		return new AccessFilter();
	}
}
