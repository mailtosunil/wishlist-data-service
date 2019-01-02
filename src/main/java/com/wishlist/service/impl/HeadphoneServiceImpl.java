package com.wishlist.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.model.Headphone;
import com.wishlist.repo.HeadphoneRepository;
import com.wishlist.service.HeadphoneService;

@Service
public class HeadphoneServiceImpl implements HeadphoneService {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private HeadphoneRepository headphoneRepository;

	@Override
	public Headphone saveHeadphone(Headphone headphone) {
		LOG.info("Execution starts: saveHeadphone method");
		headphoneRepository.save(headphone);
		LOG.info("Execution starts: saveHeadphone method");
		return headphone;
	}

	@Override
	public List<Headphone> fetchHeadphones() {
		LOG.info("Execution starts: fetchHeadphones method");
		List<Headphone> headphones = new ArrayList<>();
		headphoneRepository.findAll().forEach(headphones::add);
		LOG.info("Execution starts: fetchHeadphones method");
		return headphones;
	}

}
