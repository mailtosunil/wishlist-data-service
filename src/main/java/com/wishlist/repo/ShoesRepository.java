package com.wishlist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.model.Shoes;
@Repository
public interface ShoesRepository extends CrudRepository<Shoes, Integer> {

}
