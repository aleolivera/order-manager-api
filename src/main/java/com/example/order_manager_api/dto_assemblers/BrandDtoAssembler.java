package com.example.order_manager_api.dto_assemblers;

import com.example.order_manager_api.dtos.BrandDto;
import com.example.order_manager_api.models.Brand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BrandDtoAssembler implements IDtoAssembler<Brand, BrandDto> {
    @Override
    public BrandDto toDto(Brand brand) {
        if(brand == null) return null;
        return new BrandDto(brand.getId(), brand.getName());
    }

    @Override
    public Collection<BrandDto> toCollection(Collection<Brand> list) {
        if(list == null) return null;

        List<BrandDto> dtoList = new ArrayList<>(list.size());

        for(Brand brand : list){
            dtoList.add(toDto(brand));
        }

        return dtoList;
    }
}
