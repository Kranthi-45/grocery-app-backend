package com.groceryApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryApplication.entities.ProductEntity;
import com.groceryApplication.entities.WishlistEntity;
import com.groceryApplication.service.WishlistService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	
	@Autowired
	private WishlistService wishlistService;
	
	
	@PostMapping("/addWishlist")
	public ResponseEntity<WishlistEntity> addWishlist( @RequestBody WishlistEntity wishlist) { 
			return new ResponseEntity<WishlistEntity>(wishlistService.addWishlist(wishlist) , HttpStatus.OK);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void deleteWishlistById(@PathVariable int id){
		wishlistService.deleteWishlist(id);
	}
	
	
	@GetMapping("getWishlistById/{wishlistId}")
	public ResponseEntity<WishlistEntity> getWishlistById (@PathVariable int wishlistId){
	return new ResponseEntity<WishlistEntity>(wishlistService.getWishlistById(wishlistId),HttpStatus.OK);
	}
	
	@GetMapping("getAllWishlist")
	public List<WishlistEntity> getAllWishlist(){
		return wishlistService.getAllWishlist();
	}
	

}
