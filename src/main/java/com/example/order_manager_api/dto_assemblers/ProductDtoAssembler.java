package com.example.order_manager_api.dto_assemblers;

import com.example.order_manager_api.dtos.BrandDto;
import com.example.order_manager_api.dtos.CategoryDto;
import com.example.order_manager_api.dtos.ProductDto;
import com.example.order_manager_api.models.Brand;
import com.example.order_manager_api.models.Category;
import com.example.order_manager_api.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProductDtoAssembler implements IDtoAssembler<Product, ProductDto> {
    @Autowired
    private IDtoAssembler<Brand, BrandDto> brandDtoAssembler;
    @Autowired
    private IDtoAssembler<Category, CategoryDto> categoryDtoAssembler;
    @Override
    public ProductDto toDto(Product product) {
        if(product == null) return null;

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStock(),
                product.getMaxStock(),
                product.getMinStock(),
                product.getPrice(),
                product.getCreated(),
                brandDtoAssembler.toDto(product.getBrand()),
                categoryDtoAssembler.toDto(product.getCategory())
        );
    }

    @Override
    public Collection<ProductDto> toCollection(Collection<Product> collection) {
        if(collection == null) return null;

        List<ProductDto> dtoList = new ArrayList<>(collection.size());

        for(Product product : collection){
            dtoList.add(toDto(product));
        }

        return dtoList;
    }
}
