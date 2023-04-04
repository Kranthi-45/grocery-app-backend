package com.groceryApplication.service;

import java.util.List;

import com.groceryApplication.dto.CartDto;
import com.groceryApplication.entities.CartEntity;

public interface CartService {
	
	CartEntity addItemToCart(CartDto cartDTO );
	
	CartEntity updateItemToCart(int cartId, CartDto cartDTO);

	String deleteItemFromCart(int cartId);
	
	CartEntity getCartById(int cartId);

	List<CartEntity> getAllCartItems();
	
	
}
