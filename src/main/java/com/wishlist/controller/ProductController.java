package com.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishlist.model.Product;
import com.wishlist.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "wishlist-data-service-product", description = "Operation related to products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	@ApiOperation(value = "View a list of available products", response = List.class)
	public List<Product> products(){
		return productService.getProducts();
	}
}
