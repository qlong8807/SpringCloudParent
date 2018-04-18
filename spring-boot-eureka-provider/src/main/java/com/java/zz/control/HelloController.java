package com.java.zz.control;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.zz.entity.User;

@RestController
public class HelloController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String index() {
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		logger.info("/hollo:host:"+instance.getHost()+",service-id:"+instance.getServiceId());
		return "Hello World!";
	}
	@RequestMapping(value="/hello/{name}",method=RequestMethod.GET)
	public String index2(@PathVariable("name") String uname) {
		Random random = new Random();
		int nextInt = random.nextInt(4000);
		try {
			Thread.sleep(nextInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		logger.info("/hollo2:host:"+instance.getHost()+",service-id:"+instance.getServiceId());
		return "Hello "+uname;
	}
	
	@GetMapping("hello1")
	public String hello1(@RequestParam String name) {
		return "hello "+name;
	}
	
	@GetMapping("hello2")
	public User hello2(@RequestHeader String name,@RequestHeader Integer age) {
		return new User(name, age);
	}
	
	@PostMapping("hello3")
	public String hello3(@RequestBody User user) {
		return "hello "+user.getName()+","+user.getAge();
	}
}
