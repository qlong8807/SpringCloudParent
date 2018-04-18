package com.java.zz.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.zz.entity.Person;

public interface PersonService {
	
	//这里的注解是给consumer用的，provider不用这里的注解。

	@RequestMapping("/person")
	String person();
	
	@GetMapping("person1")
	String person1(@RequestParam("name") String name);
	@GetMapping("person2")
	Person person2(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	@PostMapping("person3")
	String person3(@RequestBody Person person);
}
