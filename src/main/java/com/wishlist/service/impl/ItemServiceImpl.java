package com.wishlist.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Item> fetchWishlistItems() {
		LOG.info("Execution starts: fetchWishlistItems method");
		List<Item> items = new ArrayList<>();
		itemRepository.findAll().forEach(items::add);
		LOG.info("Execution ends: fetchWishlistItems method");
		return items;
	}

	@Override
	public Item deleteItemFromWishlist(Integer itemId) {
		LOG.info("Execution starts: deleteItemFromWishlist method");
		Item item = itemRepository.findById(itemId).orElse(null);
		itemRepository.deleteById(itemId);
		LOG.info("Execution ends: deleteItemFromWishlist method");
		return item;
	}

	@Override
	public Item saveItemToWishlist(String prodId) {
		LOG.info("Execution starts: saveItemToWishlist method");
		Product product = productRepository.findById(Integer.parseInt(prodId)).orElse(null);
		Item itemEntity = new Item();
		if (product != null) {
			itemEntity = DataServiceUtility.populateItemProperties(itemEntity, product);
			itemRepository.save(itemEntity);
		}
		LOG.info("Execution ends: saveItemToWishlist method");
		return itemEntity;
	}

}
