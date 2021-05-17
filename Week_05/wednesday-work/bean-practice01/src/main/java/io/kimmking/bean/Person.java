package io.kimmking.bean;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	private int age;
	private Car car;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	@Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", sex=" + sex +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
