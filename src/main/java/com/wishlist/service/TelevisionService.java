package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Television;

public interface TelevisionService {
	Television saveTelevision(Television television);
	List<Television> fetchTelevisions();
}
