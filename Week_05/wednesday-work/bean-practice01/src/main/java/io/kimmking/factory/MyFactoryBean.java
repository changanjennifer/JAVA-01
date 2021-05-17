package io.kimmking.factory;

import org.springframework.beans.factory.FactoryBean;

import io.kimmking.bean.Product;

public class MyFactoryBean implements FactoryBean<Product>{

	@Override
	public Product getObject() throws Exception {
		System.out.println("MyFactoryBean ... ...");
		Product product = new Product();
		product.setId(123456);
		product.setName("Spring in action");
		product.setType("book");
		product.setCount(19);
		return product;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Product.class;
	}

}
