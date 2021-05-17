package io.kimmking.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.kimmking.controller.PersonController;

public class iocTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("ioc.xml");
	
	/*
	 * ��̬
	 */
	@Test
	public void test01() {
		User u001 = (User)ac.getBean("User001");
		System.out.println(u001);
	}
	
	/*
	 * ��ָ̬������
	 */
	@Test
	public void test02() {
		User u001 = ac.getBean("User001",User.class);
		System.out.println(u001);
	}
	
	/*
	 * ��̬����
	 */
	@Test
	public void test03() {
		Product p001 = (Product)ac.getBean("Product001");
		System.out.println(p001);
	}
	
	/*
	 *ʵ������
	 */
	@Test
	public void test04() {
		Product p002 = (Product)ac.getBean("Product002");
		System.out.println(p002);
	}
	
	/*
	 *ʵ��BeanFactory�ӿ�
	 */
	@Test
	public void test05() {
		Product p003 = (Product)ac.getBean("myFactoryBean");
		System.out.println(p003);
	}
	

	/*
	 *����xml�ֹ�װ��
	 */
	@Test
	public void test06() {
		Person p001 = (Person)ac.getBean("person001");
		System.out.println(p001);
	}
	
	/*
	 *����xml�Զ�װ��
	 */
	@Test
	public void test07() {
		Person p002 = (Person)ac.getBean("person002");
		System.out.println(p002);
	}
	
	/*
	 *����ע���Զ�װ��
	 */
	@Test
	public void test08() {
		PersonController pc = (PersonController)ac.getBean("personController");
		Person p003 = pc.getPersonByName("lisi");
		System.out.println(p003);
	}
}
