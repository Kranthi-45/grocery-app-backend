package com.groceryApplication.dto;

import java.util.List;

import com.groceryApplication.entities.ProductEntity;

import lombok.Data;

@Data
public class WishlistDto {

	private List<Integer> productId;
	private double totalPrice;

	}
