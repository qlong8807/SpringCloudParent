package com.java.zz.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.zz.entity.Person;
import com.java.zz.service.PersonService;

@RestController
public class PersonController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonService personService;

	@RequestMapping("/person")
	String person() {
		return personService.person();
	}
	
	@GetMapping("person1")
	String person1(@RequestParam("name") String name) {
		return personService.person1(name);
	}
	@GetMapping("person2")
	Person person2(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
		return personService.person2(name, age);
	}
	@PostMapping("person3")
	String person3(@RequestBody Person person) {
		return personService.person3(person);
	}
}
