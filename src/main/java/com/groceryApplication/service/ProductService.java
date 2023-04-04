package com.groceryApplication.service;

import java.util.List;

import com.groceryApplication.dto.ProductDto;
import com.groceryApplication.entities.ProductEntity;
import com.groceryApplication.enums.Category;


public interface ProductService {
	String addProduct(ProductEntity product);
	String deleteProduct(int productId);
	List<ProductEntity> getAllProducts();
	List<ProductEntity> getProductByCategory(Category category);
	//Product updateProduct(Product product);
	ProductEntity getById(int productId);
	String updateProduct(ProductDto product, int productid);
}
