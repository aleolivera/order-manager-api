package com.example.order_manager_api.controllers;

import com.example.order_manager_api.dto_assemblers.CategoryDtoAssembler;
import com.example.order_manager_api.dtos.CategoryDto;
import com.example.order_manager_api.models.Category;
import com.example.order_manager_api.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Category category = categoryService.findById(id);

        if(category == null)
            return ResponseEntity.notFound().build();

        CategoryDto dto = categoryDtoAssembler.toDto(category);
        if(dto == null)
            return ResponseEntity.internalServerError().build();

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/v1/categories")
    public ResponseEntity<?> save(@RequestBody Category newCategory){
        CategoryDto dto = categoryDtoAssembler.toDto(categoryService.save(newCategory));

        if(dto == null)
            return ResponseEntity
                    .internalServerError()
                    .build();

        return ResponseEntity
                .created(URI.create("/v1/categories/" + dto.getId()))
                .body(dto);
    }

    @PutMapping("/v1/categories/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody Category newCategory){

        if(!categoryService.existsById(id))
            return ResponseEntity
                    .notFound()
                    .build();

        CategoryDto dto = categoryDtoAssembler.toDto(categoryService.update(id,newCategory));
        if(dto == null)
            return ResponseEntity
                    .internalServerError()
                    .build();

        return ResponseEntity
                .created(URI.create("/v1/categories/"+dto.getId()))
                .body(dto);
    }

    @DeleteMapping("/v1/categories/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(!categoryService.existsById(id)){
            return ResponseEntity
                    .notFound()
                    .build();
        }

        categoryService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
