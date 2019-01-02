package com.wishlist.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.model.Television;
import com.wishlist.repo.TelevisionRepository;
import com.wishlist.service.TelevisionService;
@Service
public class TelevisionServiceImpl implements TelevisionService {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private TelevisionRepository televisionRepository;
	@Override
	public Television saveTelevision(Television television) {
		LOG.info("Execution starts: saveTelevision method");
		televisionRepository.save(television);
		LOG.info("Execution starts: saveTelevision method");
		return television;
	}

	@Override
	public List<Television> fetchTelevisions() {
		LOG.info("Execution starts: fetchTelevisions method");
		List<Television> televisions = new ArrayList<>();
		televisionRepository.findAll().forEach(televisions::add);
		LOG.info("Execution starts: fetchTelevisions method");
		return televisions;
	}

}
