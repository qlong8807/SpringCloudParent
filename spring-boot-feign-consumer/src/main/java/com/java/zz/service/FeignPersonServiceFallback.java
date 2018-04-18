package com.java.zz.service;

import org.springframework.stereotype.Component;

import com.java.zz.entity.Person;

@Component
public class FeignPersonServiceFallback implements FeignPersonService{

	@Override
	public String person() {
		return "error";
	}

	@Override
	public String person1(String name) {
		return "error person1";
	}

	@Override
	public Person person2(String name, Integer age) {
		return new Person("error person2", 0);
	}

	@Override
	public String person3(Person person) {
		return "error person3";
	}

}
