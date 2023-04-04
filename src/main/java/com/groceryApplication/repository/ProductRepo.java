package com.groceryApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryApplication.entities.ProductEntity;
import com.groceryApplication.enums.Category;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

	List<ProductEntity> findByCategory(Category category);

	
}
