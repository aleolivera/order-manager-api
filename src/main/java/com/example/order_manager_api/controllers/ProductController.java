package com.example.order_manager_api.controllers;

import com.example.order_manager_api.dto_assemblers.ProductDtoAssembler;
import com.example.order_manager_api.dtos.ProductDto;
import com.example.order_manager_api.models.Product;
import com.example.order_manager_api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ProductDtoAssembler productDtoAssembler;

    @GetMapping("/v1/products")
    public Collection<ProductDto> findAll(@RequestParam String name){
        if(name == null)
            return productDtoAssembler.toCollection(productService.findAll());

        return productDtoAssembler.toCollection(productService.findByNameContaining(name));
    }
    @GetMapping("/v1/products/{id}")
    public ProductDto findById(@PathVariable Long id){
        return productDtoAssembler.toDto(productService.findById(id));
    }

    @PostMapping("/v1/products")
    public ProductDto save(@RequestBody Product newProduct){
        return productDtoAssembler.toDto(productService.save(newProduct));
    }

    @PutMapping("/v1/products")
    public ProductDto update(@PathVariable Long id, @RequestBody Product newProduct){
        if(productService.findById(id) == null)
            return save(newProduct);

        return productDtoAssembler.toDto(productService.update(id,newProduct));
    }
    @DeleteMapping("/v1/products/{id}")
    public void delete(Long id){
        if(findById(id) != null)
            productService.delete(id);
    }
}
