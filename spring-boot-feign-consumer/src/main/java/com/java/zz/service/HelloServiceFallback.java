package com.java.zz.service;

import org.springframework.stereotype.Component;

import com.java.zz.entity.User;

@Component
public class HelloServiceFallback implements HelloService{

	@Override
	public String hello() {
		return "hello error";
	}

	@Override
	public String hello1(String name) {
		return "hello1 error";
	}

	@Override
	public User hello2(String name, Integer age) {
		return new User("error",0);
	}

	@Override
	public String hello3(User user) {
		return "hello3 error";
	}

}
