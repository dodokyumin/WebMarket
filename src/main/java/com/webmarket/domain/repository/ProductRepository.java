package com.webmarket.domain.repository;

import java.util.List;

import com.webmarket.domain.model.Product;

import com.webmarket.data.ProductRepositoryDbImpl;
import com.webmarket.data.ProductRepositoryImpl;
import com.webmarket.data.dao.MySqlProductDaoImpl;

public interface ProductRepository {
	
	public static ProductRepository getInstance() {
		// 메모리에 연결할 때
		//return ProductRepositoryImpl.getInstance();
		
		// DB에 연결할 때
		return new ProductRepositoryDbImpl(new MySqlProductDaoImpl());
	}

	public List<Product> getAllProducts();

	public Product getProductById(String id);

	public void addProduct(Product product);

}