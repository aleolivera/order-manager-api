package com.example.order_manager_api.services;

import com.example.order_manager_api.models.Category;
import com.example.order_manager_api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public boolean existsById(Integer id) {
        return categoryRepo.existsById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAllByOrderByIdAsc();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category save(Category newCategory) {
        return categoryRepo.save(newCategory);
    }

    @Override
    public Category update(Integer id, Category newCategory) {
        Category category = findById(id);
        if(category == null) return null;

        category.setName(newCategory.getName());

        return categoryRepo.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepo.delete(findById(id));
    }
}
