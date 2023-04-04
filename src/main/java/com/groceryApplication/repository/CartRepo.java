package com.groceryApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryApplication.entities.CartEntity;

public interface CartRepo extends JpaRepository<CartEntity, Integer>{

}
