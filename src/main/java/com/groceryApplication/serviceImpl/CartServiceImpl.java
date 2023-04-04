package com.groceryApplication.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groceryApplication.dto.CartDto;
import com.groceryApplication.entities.CartEntity;
import com.groceryApplication.entities.ProductEntity;
import com.groceryApplication.exceptions.CartNotFoundException;
import com.groceryApplication.repository.CartRepo;
import com.groceryApplication.repository.ProductRepo;
import com.groceryApplication.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ProductRepo productRepo;

		@Override
		public CartEntity addItemToCart(CartDto cartDTO) {
			List<ProductEntity> productEntityList = new ArrayList<>();
			for (int productId : cartDTO.getProductId()) {
				Optional<ProductEntity> optionalProduct = productRepo.findById(productId);
				if (optionalProduct.isPresent()) {
					productEntityList.add(optionalProduct.get());
				} else {
					throw new CartNotFoundException("Product doesn't exist with id: " + productId);
				}
			}

			CartEntity cartEntity = new CartEntity();
			cartEntity.setProductCount(cartDTO.getProductCount());
			cartEntity.setProducts(productEntityList);
			cartEntity.setTotalPrice(cartDTO.getTotalPrice());

			try {
				cartEntity = cartRepo.save(cartEntity);
				return cartEntity;
			} catch (Exception e) {
				throw new CartNotFoundException("Something went wrong while adding item to cart");
			}
		}

		@Override
		public CartEntity updateItemToCart(int cartId, CartDto cartDTO) {
			Optional<CartEntity> optionalCart = cartRepo.findById(cartId);
			if (optionalCart.isPresent()) {
				List<ProductEntity> productEntityList = new ArrayList<>();
				for (int productId : cartDTO.getProductId()) {
					Optional<ProductEntity> optionalProduct = productRepo.findById(productId);
					if (optionalProduct.isPresent()) {
						productEntityList.add(optionalProduct.get());
					} else {
						throw new CartNotFoundException("Product doesn't exist with id: " + productId);
					}
				}

				CartEntity cartEntity = optionalCart.get();
				cartEntity.setProductCount(cartDTO.getProductCount());
				cartEntity.setProducts(productEntityList);
				cartEntity.setTotalPrice(cartDTO.getTotalPrice());

				try {
					cartEntity = cartRepo.save(cartEntity);
					return cartEntity;
				} catch (Exception e) {
					throw new CartNotFoundException("Something went wrong while updating item in cart");
				}
			} else {
				throw new CartNotFoundException("Cart doesn't exist with id: " + cartId);
			}
		}
	

	@Override
	public String deleteItemFromCart(int cartId) {
	cartRepo.findById(cartId).orElseThrow(()->new CartNotFoundException("Cart not found"));
	cartRepo.deleteById(cartId);
	return "Deleted successfully";
	}
	

	@Override
	public CartEntity getCartById(int cartId) {
		return  cartRepo.findById(cartId).orElseThrow(()->new CartNotFoundException("Cart Not Found with given id"));
	}

	@Override
	public List<CartEntity> getAllCartItems() {
		return cartRepo.findAll();
		
	}

}
