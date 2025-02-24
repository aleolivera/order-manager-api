package com.example.order_manager_api.controllers;

import com.example.order_manager_api.dto_assemblers.BrandDtoAssembler;
import com.example.order_manager_api.dto_assemblers.IDtoAssembler;
import com.example.order_manager_api.dtos.BrandDto;
import com.example.order_manager_api.models.Brand;
import com.example.order_manager_api.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private IBrandService brandService;
    @Autowired
    private BrandDtoAssembler brandDtoAssembler;

    @GetMapping("/v1/brands")
    public Collection<BrandDto> findAll(){
        return brandDtoAssembler.toCollection(brandService.findAll());
    }
    @GetMapping("/v1/brands/{id}")
    public BrandDto findById(@PathVariable Integer id){
        return brandDtoAssembler.toDto(brandService.findById(id));
    }

    @PostMapping("/v1/brands")
    public BrandDto save(@RequestBody Brand newBrand){
        return brandDtoAssembler.toDto(brandService.save(newBrand));
    }

    @PutMapping("/v1/brands/{id}")
    public BrandDto update(@PathVariable Integer id,@RequestBody Brand newBrand){
        return brandDtoAssembler.toDto(brandService.update(id,newBrand));
    }

    @DeleteMapping("/v1/brands/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(findById(id) != null)
            brandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
