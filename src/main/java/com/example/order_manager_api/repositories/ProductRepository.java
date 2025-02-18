package com.example.order_manager_api.repositories;
import com.example.order_manager_api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> { }
