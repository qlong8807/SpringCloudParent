package com.java.zz.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.zz.entity.User;

/**
 * @author zyl
 * @date 2018年4月12日
 * @desc feign的断路器实现方式为 1.根据当前接口新建一个实现类，实现类中写出断路后的流程；2.指定fallback的实现类
 */
@FeignClient(name="eureka-provider",fallback=HelloServiceFallback.class)
public interface HelloService {

	@RequestMapping("/hello")
	String hello();
	
	@GetMapping("hello1")
	String hello1(@RequestParam("name") String name);
	@GetMapping("hello2")
	User hello2(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	@GetMapping("hello3")
	String hello3(@RequestBody User user);
}
