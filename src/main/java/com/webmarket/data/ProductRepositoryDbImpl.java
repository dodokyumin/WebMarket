package com.webmarket.data;

import java.util.Collections;
import java.util.List;
import com.webmarket.data.dao.ProductDao;
import com.webmarket.domain.model.Product;
import com.webmarket.domain.repository.ProductRepository;

public class ProductRepositoryDbImpl implements ProductRepository {
    private ProductDao dao;

    public ProductRepositoryDbImpl(ProductDao dao) {
       this.dao = dao;
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.emptyList();
    }

    @Override
    public Product getProductById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addProduct(Product product) {
        // TODO Auto-generated method stub

    }

}