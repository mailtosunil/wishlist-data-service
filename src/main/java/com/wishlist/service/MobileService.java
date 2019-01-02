package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Mobile;

public interface MobileService {
	Mobile saveMobile(Mobile mobile);
	List<Mobile> fetchMobiles();
}
