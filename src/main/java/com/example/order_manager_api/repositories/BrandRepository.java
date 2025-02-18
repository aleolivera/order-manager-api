package com.example.order_manager_api.repositories;

import com.example.order_manager_api.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    public List<Brand> findAllByOrderByIdAsc();
}
