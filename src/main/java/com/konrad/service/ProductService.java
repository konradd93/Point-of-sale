package com.konrad.service;

import com.konrad.dao.ProductDao;
import com.konrad.model.Product;

import java.util.List;

public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product findById(long id) {
        return productDao.findById(id);
    }
    public List<Product> findAll() { return productDao.findAll();}
}
