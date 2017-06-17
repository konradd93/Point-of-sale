package com.konrad.service;

import com.konrad.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeProductService implements IProductService {
   // private ProductDao productDao;
    private List<Product> dbProducts;
    private Product product;

    public Product findById(long id) {
        dbProducts = new ArrayList<>();
        dbProducts.add(new Product("AS1234590","Lalka",29.99));
        dbProducts.add(new Product("023141222","Ołówek",1.19));
        dbProducts.add(new Product("232419992","Długopis",2.05));
        dbProducts.add(new Product("13148141919","Zeszyt",10.99));
        dbProducts.add(new Product("1194821488","Leżak",130));
        dbProducts.add(new Product("ATW211000","Koło",29.99));
        product = dbProducts.get((int)id);
        return product;
    }
    public List<Product> findAll() {
        dbProducts = new ArrayList<>();
        dbProducts.add(new Product("AS1234590","Lalka",29.99));
        dbProducts.add(new Product("023141222","Ołówek",1.19));
        dbProducts.add(new Product("232419992","Długopis",2.1));
        dbProducts.add(new Product("13148141919","Zeszyt",10.99));
        dbProducts.add(new Product("1194821488","Leżak",130));
        dbProducts.add(new Product("ATW211000","Koło",29.99));
        return dbProducts;
    }
}
