package com.groceryApplication.service;

import java.util.List;
import java.util.Optional;

import com.groceryApplication.dto.WishlistDto;
import com.groceryApplication.entities.WishlistEntity;

public interface WishlistService {
	
	//public WishlistEntity addWishlist(WishlistEntity wishlist);

	public String deleteWishlist(int wishlistId);

	public WishlistEntity getWishlistById(int wishlistId);
	
	public List<WishlistEntity> getAllWishlist();

	public WishlistEntity addWishlist(WishlistEntity wishlist);

}
