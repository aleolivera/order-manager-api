package com.example.order_manager_api.services;

import com.example.order_manager_api.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> findByNameContaining(String name);
    Product findById(Long id);
    Product save(Product newProduct);
    Product update(Long id, Product newProduct);
    void delete(Long id);
}
