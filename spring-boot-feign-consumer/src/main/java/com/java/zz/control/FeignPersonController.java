package com.java.zz.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.zz.entity.Person;
import com.java.zz.service.PersonService;

@RestController
public class FeignPersonController {

	@Autowired
	private PersonService personService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/person")
	public String hello2() {
		logger.info("/person");
		StringBuilder sb = new StringBuilder();
		sb.append(personService.person()).append("\n");
		sb.append(personService.person1("张三")).append("\n");
		sb.append(personService.person2("李四", 29)).append("\n");
		sb.append(personService.person3(new Person("王五", 33))).append("\n");
		return sb.toString();
	}
}
