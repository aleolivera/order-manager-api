package com.example.order_manager_api.dto_assemblers;

import com.example.order_manager_api.dtos.CategoryDto;
import com.example.order_manager_api.models.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CategoryDtoAssembler implements IDtoAssembler<Category, CategoryDto>{
    @Override
    public CategoryDto toDto(Category category) {
        if(category == null) return null;
        return new CategoryDto(category.getId(), category.getName());
    }

    @Override
    public Collection<CategoryDto> toCollection(Collection<Category> list) {
        if(list == null) return null;

        List<CategoryDto>dtoList = new ArrayList<>(list.size());

        for (Category category : list) {
            dtoList.add(toDto(category));
        }

        return dtoList;
    }
}
