package com.wishlist.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.model.Mobile;
import com.wishlist.repo.MobileRepository;
import com.wishlist.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public Mobile saveMobile(Mobile mobile) {
		LOG.info("Execution starts: saveMobile method");
		mobileRepository.save(mobile);
		LOG.info("Execution starts: saveMobile method");
		return mobile;
	}

	@Override
	public List<Mobile> fetchMobiles() {
		LOG.info("Execution starts: fetchMobiles method");
		List<Mobile> mobiles = new ArrayList<>();
		mobileRepository.findAll().forEach(mobiles::add);
		System.out.println("-----> " + mobiles);
		LOG.info("Execution starts: fetchMobiles method");
		return mobiles;
	}

}
