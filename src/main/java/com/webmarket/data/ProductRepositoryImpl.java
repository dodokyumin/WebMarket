package com.webmarket.data;

import java.util.ArrayList;
import java.util.List;

import com.webmarket.domain.model.Product;
import com.webmarket.domain.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    // static이 붙어있으면 여기 없는거야 그냥 여기 없다고 보자. 별개의 코드
    private static ProductRepositoryImpl instance = new ProductRepositoryImpl();
    
    
    // 이 레파지토리를 만들었을 때 위에 계속 만들지 말고 만들었던거를(static을 통해 이미 올린 후) 재사용하자.
    public static ProductRepositoryImpl getInstance() {
        return instance;
    }

    private ProductRepositoryImpl() {
        Product phone = new Product("P1234", "iPhone 6s", 800000);
        phone.setDescription("4.7-inch, 1334x750 Retina HD display");
        phone.setCategory("Smart Phone");
        phone.setManufacturer("Apple");
        phone.setUnitsInStock(1000);
        phone.setCondition("New");

        Product notebook = new Product("P1235", "LG PC 그램", 1500000);
        notebook.setDescription("4.7-inch, 1334x750 Retina HD display");
        notebook.setCategory("Smart Phone");
        notebook.setManufacturer("Apple");
        notebook.setUnitsInStock(1000);
        notebook.setCondition("Refubished");

        Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
        tablet.setDescription("4.7-inch, 1334x750 Retina HD display");
        tablet.setCategory("Smart Phone");
        tablet.setManufacturer("Apple");
        tablet.setUnitsInStock(1000);
        tablet.setCondition("Old");

        products.add(phone);
        products.add(notebook);
        products.add(tablet);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return products;
    }
    @Override	
    public Product getProductById(String id) {
        return products.stream()
                .filter((product) -> product.getId().equals(id))
                .findFirst()
                .get();
    }
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

}
