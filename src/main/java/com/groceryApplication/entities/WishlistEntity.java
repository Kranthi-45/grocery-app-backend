package com.groceryApplication.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="wishlist")
public class WishlistEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int WishlistId;
	private double totalPrice;
	
	@JsonIgnore
	@OneToMany(targetEntity = ProductEntity.class)
	private List<ProductEntity> products;

	 
}
