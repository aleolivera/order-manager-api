package com.example.order_manager_api.services;

import com.example.order_manager_api.models.Brand;
import com.example.order_manager_api.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService{
    @Autowired
    private BrandRepository brandRepo;

    @Override
    public boolean existsById(Integer id) {
        return brandRepo.existsById(id);
    }

    @Override
    public List<Brand> findAll(){
        return brandRepo.findAllByOrderByIdAsc();
    }

    @Override
    public Brand findById(Integer id){
        return brandRepo.findById(id).orElse(null);
    }

    @Override
    public Brand save(Brand newBrand){
        return brandRepo.save(newBrand);
    }

    @Override
    public Brand update(Integer id, Brand newBrand){
        Brand brand = findById(id);
        if(brand == null) return null;

        brand.setName(newBrand.getName());

        return brandRepo.save(brand);
    }

    public void delete(Integer id){
        brandRepo.delete(findById(id));
    }


}
