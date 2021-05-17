package io.kimmking.dao;

import org.springframework.stereotype.Repository;

import io.kimmking.bean.Person;

@Repository
public class PersonDao {

	public Person getPersonByName(String name) {
		Person p = new Person();
		p.setName(name);
		p.setSex("man");
		p.setAge(30);
	
		return p;
	}
}
