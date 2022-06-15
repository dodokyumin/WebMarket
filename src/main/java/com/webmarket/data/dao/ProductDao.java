package com.webmarket.data.dao;

import java.util.List;

import com.webmarket.domain.model.Product;

// Data Access Object
// DB랑 연결할 놈
public interface ProductDao {
	// interface안에 작성한 멤버 = public final static 이 생략되어 있다. 일반적으로 이렇게 한곳에 적고 다른 곳에 뿌리는 방식.
	final static String COLUMN_ID = "p_id";
	final static String TABLE_NAME = "product";
	
	
	// interface 안에서는 public이 생략되어있고(default) public만 됨
	List<Product> getAll();
	
	// 실제로는 성공여부에 따라 리턴을 받게끔 한다.
	void insert(Product product);
	
	void update(Product product);
	
	void delete(Product product);
	
}
