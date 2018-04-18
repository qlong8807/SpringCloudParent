package com.java.zz.service.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.java.zz.entity.Person;
import com.java.zz.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Override
	public String person() {
		return "hello person";
	}

	@Override
	public String person1(String name) {
		return "hello "+name;
	}

	@Override
	public Person person2(String name, Integer age) {
		return new Person(name, age);
	}

	@Override
	public String person3(Person person) {
		int nextInt = new Random().nextInt(5000);
		try {
			TimeUnit.MILLISECONDS.sleep(nextInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello "+person.getName()+","+person.getAge();
	}

}
