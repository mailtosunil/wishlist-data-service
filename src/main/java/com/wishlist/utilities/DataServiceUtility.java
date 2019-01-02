package com.wishlist.utilities;

import java.util.concurrent.ThreadLocalRandom;

public class DataServiceUtility {
	
	public static int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(0,3);
	}

	private DataServiceUtility() {
		super();
	}
}
