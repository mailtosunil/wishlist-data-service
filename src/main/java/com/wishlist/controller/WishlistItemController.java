package com.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wishlist.model.Item;
import com.wishlist.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/data")
@Api(value = "wishlist-data-service", description = "Operation related to wishlist items")
public class WishlistItemController {
	@Autowired
	private ItemService itemService;

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "View a list of available items", response = List.class)
	@GetMapping("/items")
	public ResponseEntity fetchWishlistItems() {
		ResponseEntity response = null;
		List<Item> items = itemService.fetchWishlistItems();
		if (items != null && !items.isEmpty()) {
			response = new ResponseEntity<List<Item>>(items, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No Data Found", HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "For adding item to wishlist", response = Item.class)
	@PostMapping("/add/item")
	@ResponseBody
	public ResponseEntity saveItem(@RequestBody String prodId) {
		ResponseEntity response = null;
		Item item = itemService.saveItemToWishlist(prodId);
		if (item != null) {
			response = new ResponseEntity<Item>(item, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Unable to add item to wishlist", HttpStatus.NOT_MODIFIED);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "For deleting an item from wishlist", response = Item.class)
	@PostMapping("/delete/item")
	@ResponseBody
	public ResponseEntity deleteItem(@RequestBody String itemId) {
		ResponseEntity response = null;
		Item item = itemService.deleteItemFromWishlist(Integer.parseInt(itemId));
		if (item != null) {
			response = new ResponseEntity<Item>(item, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Unable to delete item from wishlist", HttpStatus.NOT_MODIFIED);
		}
		return response;
	}
}
