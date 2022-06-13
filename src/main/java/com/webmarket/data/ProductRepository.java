package com.webmarket.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.webmarket.domain.model.Product;

public class ProductRepository {

		private List<Product> products = new ArrayList<>();

	public ProductRepository() {
		
		Product phone = new Product("P1234", "iPhone 6s", 80000);
		phone.setDescription("4.7-inch, 1334x750 Retina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("new");
		
		Product notebook = new Product("P1234", "iPhone 6s", 80000);
		notebook.setDescription("4.7-inch, 1334x750 Retina HD display");
		notebook.setCategory("Smart Phone");
		notebook.setManufacturer("Apple");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("new");

		Product tablet = new Product("P1234", "iPhone 6s", 80000);
		tablet.setDescription("4.7-inch, 1334x750 Retina HD display");
		tablet.setCategory("Smart Phone");
		tablet.setManufacturer("Apple");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("new");

		products.add(phone);
		products.add(notebook);
		products.add(tablet);
		//db가 없으므로 메모리에 이렇게 올려놓고 사용한다는 것
	}
}