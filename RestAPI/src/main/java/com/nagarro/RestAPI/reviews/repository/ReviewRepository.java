package com.nagarro.RestAPI.reviews.repository;

/**
 * 
 * @author evprasannaharigopal
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.RestAPI.reviews.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
	

}
