package com.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@SuppressWarnings("rawtypes")
	@GetMapping("/products")
	@ApiOperation(value = "View a list of available products", response = List.class)
	@ResponseBody
	public ResponseEntity products() {
		ResponseEntity response = null;
		List<Product> products = productService.getProducts();
		if (products != null && !products.isEmpty()) {
			response = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No Data Found", HttpStatus.NOT_FOUND);
		}
		return response;
	}
}
