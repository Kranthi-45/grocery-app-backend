package com.groceryApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groceryApplication.dto.CartDto;
import com.groceryApplication.entities.CartEntity;
import com.groceryApplication.service.CartService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add-cart")
	public ResponseEntity<CartEntity> addItemToCart(@RequestBody CartDto cartDTO) {
		return new ResponseEntity<CartEntity>(cartService.addItemToCart(cartDTO),HttpStatus.OK);
	}
	
	@PutMapping("/update-cart")
	public ResponseEntity<CartEntity> updateItemToCart(@RequestParam int cartId, @RequestBody CartDto cartDTO) {
		return new ResponseEntity<CartEntity>(cartService.updateItemToCart(cartId,cartDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-cart")
	public ResponseEntity<String> deleteItemFromCart(@RequestParam int cartId) {
		cartService.deleteItemFromCart(cartId);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@GetMapping("/get-cart-by-id")
	public ResponseEntity<CartEntity> getCartById(@RequestParam int cartId) {
		return new ResponseEntity<CartEntity>(cartService.getCartById(cartId),HttpStatus.OK);
	}
	@GetMapping("/get-all-cart")
	public List<CartEntity> getAllCartItems() {
		return cartService.getAllCartItems();
	}
}
