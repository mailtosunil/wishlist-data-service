package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Item;

public interface ItemService {
	List<Item> fetchWishlistItems() ;
	Item deleteItemFromWishlist(Integer itemId);
	Item saveItemToWishlist(String prodId);
}
