package com.example.order_manager_api.services;

import com.example.order_manager_api.models.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBrandService {
    boolean existsById(Integer id);
    List<Brand> findAll();
    Brand findById(Integer id);
    Brand save(Brand newBrand);
    Brand update(Integer id, Brand newBrand);
    void delete(Integer id);
}
