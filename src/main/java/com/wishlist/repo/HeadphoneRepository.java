package com.wishlist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.model.Headphone;

@Repository
public interface HeadphoneRepository extends CrudRepository<Headphone, Integer> {

}
