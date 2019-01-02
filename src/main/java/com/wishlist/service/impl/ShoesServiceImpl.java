package com.wishlist.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.model.Shoes;
import com.wishlist.repo.ShoesRepository;
import com.wishlist.service.ShoesService;
@Service
public class ShoesServiceImpl implements ShoesService {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private ShoesRepository shoesRepository;

	@Override
	public Shoes saveShoes(Shoes shoe) {
		LOG.info("Execution starts: saveShoes method");
		shoesRepository.save(shoe);
		LOG.info("Execution starts: saveShoes method");
		return shoe;
	}

	@Override
	public List<Shoes> fetchAllShoes() {
		LOG.info("Execution starts: fetchAllShoes method");
		List<Shoes> shoes = new ArrayList<>();
		shoesRepository.findAll().forEach(shoes::add);
		LOG.info("Execution starts: fetchAllShoes method");
		return shoes;
	}

}
