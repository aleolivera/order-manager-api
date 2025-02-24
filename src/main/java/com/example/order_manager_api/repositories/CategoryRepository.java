package com.example.order_manager_api.repositories;

import com.example.order_manager_api.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByOrderByIdAsc();
}
