package com.example.order_manager_api.services;

import com.example.order_manager_api.models.Product;
import com.example.order_manager_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAllByOrderByIdAsc();
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        return productRepo.findAllByNameContainingOrderByIdAsc(name);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product save(Product newProduct) {
        return productRepo.save(newProduct);
    }

    @Override
    public Product update(Long id, Product newProduct) {
        Product product = findById(id);
        if(product == null) return null;

        product.setName(newProduct.getName());
        product.setCreated(newProduct.getCreated());
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());
        product.setStock(newProduct.getStock());
        product.setMinStock(newProduct.getMinStock());
        product.setMaxStock(newProduct.getMaxStock());
        product.setBrand(product.getBrand());
        product.setCategory(product.getCategory());

        return productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.delete(findById(id));
    }
}
