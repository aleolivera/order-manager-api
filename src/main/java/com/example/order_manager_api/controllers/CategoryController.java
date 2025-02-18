package com.example.order_manager_api.controllers;

import com.example.order_manager_api.models.Category;
import com.example.order_manager_api.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/v1/categories")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/v1/categories/{id}")
    public Category findById(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @PostMapping("/v1/categories")
    public Category save(@RequestBody Category newCategory){
        return categoryService.save(newCategory);
    }

    @PutMapping("/v1/categories/{id}")
    public Category update(@PathVariable Integer id,@RequestBody Category newCategory){
        return categoryService.update(id,newCategory);
    }

    @DeleteMapping("/v1/categories/{id}")
    public void delete(@PathVariable Integer id){
        if(findById(id) != null)
            categoryService.delete(id);
    }
}
