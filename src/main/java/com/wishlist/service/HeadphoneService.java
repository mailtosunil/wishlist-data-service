package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Headphone;

public interface HeadphoneService {
	
	Headphone saveHeadphone(Headphone headphone);
	List<Headphone> fetchHeadphones();
}
