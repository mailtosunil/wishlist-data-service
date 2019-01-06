package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Product;

public interface ProductService {
	List<Product> getProducts();
	Product findProductById(Integer prodId);
}
