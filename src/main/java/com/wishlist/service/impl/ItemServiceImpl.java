package com.wishlist.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.ItemTypes;
import com.wishlist.model.Headphone;
import com.wishlist.model.Item;
import com.wishlist.model.Mobile;
import com.wishlist.model.Shoes;
import com.wishlist.model.Television;
import com.wishlist.repo.HeadphoneRepository;
import com.wishlist.repo.ItemRepository;
import com.wishlist.repo.MobileRepository;
import com.wishlist.repo.ShoesRepository;
import com.wishlist.repo.TelevisionRepository;
import com.wishlist.service.ItemService;
import com.wishlist.utilities.DataServiceUtility;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private HeadphoneRepository headphoneRepository;

	@Autowired
	private TelevisionRepository televisionRepository;

	@Autowired
	private ShoesRepository shoesRepository;

	@Autowired
	private MobileRepository mobileRepository;

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
	public Item saveItemToWishlist(Item item) {
		LOG.info("Execution starts: saveItemToWishlist method");
		int randomNum = DataServiceUtility.getRandomNumber();
		List<Mobile> mobiles = new ArrayList<>();
		List<Shoes> shoes = new ArrayList<>();
		List<Television> televisions = new ArrayList<>();
		List<Headphone> headphones = new ArrayList<>();
		if (ItemTypes.Headphone.toString().equalsIgnoreCase(item.getItemName())) {
			headphoneRepository.findAll().forEach(headphones::add);
			item.setItemDesc(headphones.get(randomNum).getDesc());
			item.setItemValue(headphones.get(randomNum).getPrice());
		} else if (ItemTypes.Shoes.toString().equalsIgnoreCase(item.getItemName())) {
			shoesRepository.findAll().forEach(shoes::add);
			item.setItemDesc(shoes.get(randomNum).getDesc());
			item.setItemValue(shoes.get(randomNum).getPrice());
		} else if (ItemTypes.Mobile.toString().equalsIgnoreCase(item.getItemName())) {
			mobileRepository.findAll().forEach(mobiles::add);
			item.setItemDesc(mobiles.get(randomNum).getDesc());
			item.setItemValue(mobiles.get(randomNum).getPrice());
		} else if (ItemTypes.Television.toString().equalsIgnoreCase(item.getItemName())) {
			televisionRepository.findAll().forEach(televisions::add);
			item.setItemDesc(televisions.get(randomNum).getDesc());
			item.setItemValue(televisions.get(randomNum).getPrice());
		}
		itemRepository.save(item);
		LOG.info("Execution ends: saveItemToWishlist method");
		return item;
	}

}
