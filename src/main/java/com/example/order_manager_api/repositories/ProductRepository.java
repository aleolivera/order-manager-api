package com.example.order_manager_api.repositories;
import com.example.order_manager_api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product>findAllByOrderByIdAsc();
    public List<Product>findAllByNameContainingOrderByIdAsc(String name);

}
