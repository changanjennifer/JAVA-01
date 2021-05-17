package io.kimmking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kimmking.bean.Person;
import io.kimmking.dao.PersonDao;

@Service
public class PersonService {

	@Autowired
	PersonDao personDao;
	
	public Person getPersonByName(String name) {
		return personDao.getPersonByName(name);
	}
}
