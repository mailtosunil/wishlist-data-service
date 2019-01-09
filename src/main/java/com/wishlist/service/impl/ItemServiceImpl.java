package com.wishlist.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.model.Item;
import com.wishlist.model.Product;
import com.wishlist.repo.ItemRepository;
import com.wishlist.repo.ProductRepository;
import com.wishlist.service.ItemService;
import com.wishlist.utilities.DataServiceUtility;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Item> fetchWishlistItems() {
		List<Item> items = new ArrayList<>();
		itemRepository.findAll().forEach(items::add);
		return items;
	}

	@Override
	public Item deleteItemFromWishlist(Integer itemId) {
		Item item = itemRepository.findById(itemId).orElse(null);
		itemRepository.deleteById(itemId);
		return item;
	}

	@Override
	public Item saveItemToWishlist(String prodId) {
		Product product = productRepository.findById(Integer.parseInt(prodId)).orElse(null);
		Item itemEntity = new Item();
		if (product != null) {
			itemEntity = DataServiceUtility.populateItemProperties(itemEntity, product);
			itemRepository.save(itemEntity);
		}
		return itemEntity;
	}
}
