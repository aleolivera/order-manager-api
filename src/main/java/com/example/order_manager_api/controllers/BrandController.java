package com.example.order_manager_api.controllers;

import com.example.order_manager_api.models.Brand;
import com.example.order_manager_api.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @GetMapping("/v1/brands")
    public List<Brand> findAll(){
        return brandService.findAll();
    }
    @GetMapping("/v1/brands/{id}")
    public Brand findById(@PathVariable Integer id){
        return brandService.findById(id);
    }

    @PostMapping("/v1/brands")
    public Brand save(@RequestBody Brand newBrand){
        return brandService.save(newBrand);
    }

    @PutMapping("/v1/brands/{id}")
    public Brand update(@PathVariable Integer id,@RequestBody Brand newBrand){
        return brandService.update(id,newBrand);
    }

    @DeleteMapping("/v1/brands/{id}")
    public void delete(@PathVariable Integer id){
        if(findById(id) != null)
            brandService.delete(id);
    }
}
