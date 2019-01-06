package com.wishlist.utilities;

import java.util.concurrent.ThreadLocalRandom;

import com.wishlist.model.Item;
import com.wishlist.model.Product;

public class DataServiceUtility {

	public static int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(0, 3);
	}

	private DataServiceUtility() {
		super();
	}

	public static Item populateItemProperties(Item item, Product product) {
		item.setDesc(product.getDesc());
		item.setType(product.getType());
		item.setValue(product.getValue());
		if (ItemTypes.Headphone.toString().equals(product.getType())) {
			item.setImgUrl("https://openclipart.org/image/300px/svg_to_png/27070/egore911_saw.png");
		} else if (ItemTypes.Mobile.toString().equals(product.getType())) {
			item.setImgUrl("https://openclipart.org/image/300px/svg_to_png/73/rejon_Hammer.png");
		} else if (ItemTypes.Shoes.toString().equals(product.getType())) {
			item.setImgUrl("https://openclipart.org/image/300px/svg_to_png/120337/xbox-controller_01.png");
		} else if (ItemTypes.Television.toString().equals(product.getType())) {
			item.setImgUrl("https://openclipart.org/image/300px/svg_to_png/58471/garden_cart.png");
		}
		return item;
	}
}
