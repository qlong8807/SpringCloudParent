package com.java.zz.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.zz.entity.User;
import com.java.zz.service.HelloService;

@RestController
public class FeignConsumerController {

	@Autowired
	private HelloService helloService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/hello")
	public String hello2() {
		logger.info("/hollo");
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello1("张三")).append("\n");
		sb.append(helloService.hello2("李四", 29)).append("\n");
		sb.append(helloService.hello3(new User("王五", 33))).append("\n");
		return sb.toString();
	}
}
