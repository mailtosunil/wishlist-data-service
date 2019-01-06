package com.wishlist.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@ApiOperation(value = "View a list of available items", response = List.class)
	@GetMapping("/items")
	public List<Item> fetchWishlistItems() {
		LOG.info("Execution starts: data-service fetchWishlistItems");
		return itemService.fetchWishlistItems();
	}

	@ApiOperation(value = "For adding item to wishlist", response = Item.class)
	@PostMapping("/add/item")
	public Item saveItem(@RequestBody String prodId) {
		LOG.info(String.format("Execution starts: data-service saveItem: %s", prodId));
		return itemService.saveItemToWishlist(prodId);
	}

	@ApiOperation(value = "For deleting an item from wishlist", response = Item.class)
	@PostMapping("/delete/item")
	public Item deleteItem(@RequestBody String itemId) {
		LOG.info(String.format("Execution starts: data-service deleteItem: %s", itemId));
		return itemService.deleteItemFromWishlist(Integer.parseInt(itemId));
	}

}
