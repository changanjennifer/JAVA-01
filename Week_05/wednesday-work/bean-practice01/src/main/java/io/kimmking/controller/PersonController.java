package io.kimmking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.kimmking.bean.Person;
import io.kimmking.service.PersonService;

@Controller
public class PersonController {

	 
	@Autowired
	PersonService personService;
	
	public Person getPersonByName(String name) {
		return personService.getPersonByName(name);
	}
}
