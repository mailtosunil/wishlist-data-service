package com.wishlist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.model.Television;
@Repository
public interface TelevisionRepository extends CrudRepository<Television, Integer> {

}
