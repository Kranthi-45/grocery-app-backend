package com.groceryApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryApplication.dto.WishlistDto;
import com.groceryApplication.entities.WishlistEntity;

public interface WishlistRepo extends JpaRepository<WishlistEntity, Integer> {

}
