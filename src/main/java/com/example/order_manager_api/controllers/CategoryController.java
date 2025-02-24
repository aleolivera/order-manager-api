package com.example.order_manager_api.controllers;

import com.example.order_manager_api.dto_assemblers.CategoryDtoAssembler;
import com.example.order_manager_api.dtos.CategoryDto;
import com.example.order_manager_api.models.Category;
import com.example.order_manager_api.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private CategoryDtoAssembler categoryDtoAssembler;

    @GetMapping("/v1/categories")
    public Collection<CategoryDto> findAll(){
        return categoryDtoAssembler.toCollection(categoryService.findAll());
    }

    @GetMapping("/v1/categories/{id}")
    public CategoryDto findById(@PathVariable Integer id){
        return categoryDtoAssembler.toDto(categoryService.findById(id));
    }

    @PostMapping("/v1/categories")
    public CategoryDto save(@RequestBody Category newCategory){
        return categoryDtoAssembler.toDto(categoryService.save(newCategory));
    }

    @PutMapping("/v1/categories/{id}")
    public CategoryDto update(@PathVariable Integer id,@RequestBody Category newCategory){
        return categoryDtoAssembler.toDto(categoryService.update(id,newCategory));
    }

    @DeleteMapping("/v1/categories/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(findById(id) != null) categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
