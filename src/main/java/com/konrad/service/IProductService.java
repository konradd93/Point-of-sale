package com.konrad.service;

import com.konrad.model.Product;

import java.util.List;

public interface IProductService {
    public Product findById(long id);
    public List<Product> findAll();
}
