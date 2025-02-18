package com.example.order_manager_api.services;

import com.example.order_manager_api.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    Category save(Category newCategory);
    Category update(Integer id, Category newCategory);
    void delete(Integer id);
}
