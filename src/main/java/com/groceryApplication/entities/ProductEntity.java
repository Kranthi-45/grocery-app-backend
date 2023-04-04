package com.groceryApplication.entities;

import javax.persistence.Entity;import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groceryApplication.enums.Category;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String description;
	@Enumerated(EnumType.STRING)
	private Category category;
	private String imageUrl;
	private double ProductPrice;
	
}
