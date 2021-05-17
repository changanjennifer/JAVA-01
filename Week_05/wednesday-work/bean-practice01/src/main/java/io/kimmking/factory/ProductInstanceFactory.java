package io.kimmking.factory;

import io.kimmking.bean.Product;

public class ProductInstanceFactory {
	public Product getProduct(String name) {
		System.out.println("ProductInstanceFactory ... ...");
		Product product = new Product();
		product.setId(123456);
		product.setName(name);
		product.setType("book");
		product.setCount(19);
		return product;
	}
}
