package com.wishlist;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wishlist.model.Headphone;
import com.wishlist.model.Item;
import com.wishlist.model.Mobile;
import com.wishlist.model.Shoes;
import com.wishlist.model.Television;
import com.wishlist.service.HeadphoneService;
import com.wishlist.service.ItemService;
import com.wishlist.service.MobileService;
import com.wishlist.service.ShoesService;
import com.wishlist.service.TelevisionService;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class WishlistDataServiceApplication {

	@Autowired
	private ItemService itemService;

	@Autowired
	private MobileService mobileService;

	@Autowired
	private HeadphoneService headphoneService;

	@Autowired
	private ShoesService shoesService;

	@Autowired
	private TelevisionService televisionService;
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		SpringApplication.run(WishlistDataServiceApplication.class, args);
	}

	@GetMapping("/wishlist/items")
	public List<Item> fetchWishlistItems() {
		LOG.info("Execution starts: data-service fetchWishlistItems");
		return itemService.fetchWishlistItems();
	}

	@PostMapping("/wishlist/add")
	public Item saveItem(@RequestBody Item item) {
		LOG.info(String.format("Execution starts: data-service saveItem: %s", item));
		return itemService.saveItemToWishlist(item);
	}

	@PostMapping("/wishlist/delete")
	public Item deleteItem(@RequestBody String itemId) {
		LOG.info(String.format("Execution starts: data-service deleteItem: %s", itemId));
		return itemService.deleteItemFromWishlist(Integer.parseInt(itemId));
	}

	@GetMapping("/mobiles")
	public List<Mobile> fetchMobiles() {
		LOG.info("Execution starts: data-service fetchMobiles: ");
		return mobileService.fetchMobiles();
	}

	@PostMapping("/mobiles/add")
	public Mobile saveMobile(@RequestBody Mobile mobile) {
		LOG.info("Execution starts: data-service saveMobile: ");
		return mobileService.saveMobile(mobile);
	}

	@GetMapping("/shoes")
	public List<Shoes> fetchShoes() {
		LOG.info("Execution starts: data-service fetchShoes: ");
		return shoesService.fetchAllShoes();
	}

	@PostMapping("/shoes/add")
	public Shoes saveShoes(@RequestBody Shoes shoes) {
		LOG.info("Execution starts: data-service saveShoes: ");
		return shoesService.saveShoes(shoes);
	}

	@GetMapping("/televisions")
	public List<Television> fetchTelevisions() {
		LOG.info("Execution starts: data-service fetchTelevisions: ");
		return televisionService.fetchTelevisions();
	}

	@PostMapping("/televisions/add")
	public Television saveTelevision(@RequestBody Television television) {
		LOG.info("Execution starts: data-service saveTelevision: ");
		return televisionService.saveTelevision(television);
	}

	@GetMapping("/headphones")
	public List<Headphone> fetchHeadphones() {
		LOG.info("Execution starts: data-service fetchHeadphones: ");
		return headphoneService.fetchHeadphones();
	}

	@PostMapping("/headphones/add")
	public Headphone saveHeadphone(@RequestBody Headphone headphone) {
		LOG.info("Execution starts: data-service saveHeadphone: ");
		return headphoneService.saveHeadphone(headphone);
	}

}
