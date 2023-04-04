package com.groceryApplication.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryApplication.entities.WishlistEntity;
import com.groceryApplication.exceptions.CartNotFoundException;
import com.groceryApplication.exceptions.WishlistNotExistsException;
import com.groceryApplication.repository.ProductRepo;
import com.groceryApplication.repository.WishlistRepo;
import com.groceryApplication.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService{
	
	@Autowired
	private WishlistRepo wishlistRepo;
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public WishlistEntity addWishlist(WishlistEntity wishlist) {
		return wishlistRepo.save(wishlist);
	}

	@Override
	public String deleteWishlist(int wishlistId) {
		wishlistRepo.deleteById(wishlistId);
		return "Wishlist deleted successfully";
		
	}

	

	@Override
	public List<WishlistEntity> getAllWishlist() {
		
		return wishlistRepo.findAll();
	}

	@Override
	public WishlistEntity getWishlistById(int wishlistId) {
		return wishlistRepo.findById(wishlistId).orElseThrow(()-> new WishlistNotExistsException("Wishlist not found with given Id"));
	}
	
	
	

}
