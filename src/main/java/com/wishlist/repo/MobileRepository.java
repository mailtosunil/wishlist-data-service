package com.wishlist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.model.Mobile;
@Repository
public interface MobileRepository extends CrudRepository<Mobile, Integer> {

}
