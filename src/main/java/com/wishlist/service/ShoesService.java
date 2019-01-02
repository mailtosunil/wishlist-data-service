package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Shoes;

public interface ShoesService {
	
	Shoes saveShoes(Shoes shoe);
	List<Shoes> fetchAllShoes();
}
