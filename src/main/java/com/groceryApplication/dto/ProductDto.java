package com.groceryApplication.dto;

import com.groceryApplication.enums.Category;

import lombok.Data;

@Data
public class ProductDto {
	
	private int ProductId;
	private String productName;
	private String description;
	private Category category;
	private String imageUrl;
	private double price;
	

}
