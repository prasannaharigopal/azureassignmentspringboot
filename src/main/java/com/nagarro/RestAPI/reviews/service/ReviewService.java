package com.nagarro.RestAPI.reviews.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.RestAPI.products.model.Product;
import com.nagarro.RestAPI.products.repository.ProductRepository;
import com.nagarro.RestAPI.products.service.ProductService;
import com.nagarro.RestAPI.reviews.model.Review;
import com.nagarro.RestAPI.reviews.model.ReviewStatus;
import com.nagarro.RestAPI.reviews.repository.ReviewRepository;
/**
 * 
 * @author evprasannaharigopal
 *
 */
@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;

	// getting Reviews
	public List<Review> getReviews() {
		return (List<Review>) reviewRepository.findAll();
	}

	// get Review Count
	public long getReviewsCount() {
		return reviewRepository.count();
	}

	// getting review by id
	public List<Review> getReviewById(int productId) {
		Product product = productService.getProductById(productId);
		return product.getReviews();
	}

	@Transactional
	// saving review for particular product
	public Review createReview(Review review) {
		review.setStatus(ReviewStatus.PENDING);
		return reviewRepository.save(review);
	}

	@Transactional
	// delete review By Id
	public String deleteReview(int id) {
		reviewRepository.deleteById(id);
		return "deleted";
	}

	// updating status of the review to approved
	public Review updatedReviewStatus(int id) {
		Review review = reviewRepository.findById(id).orElse(null);
		review.setStatus(ReviewStatus.APPROVED);
		reviewRepository.save(review);
		return review;

	}

	// rejecting a review by Admin
	public Review rejectReviewStatus(int id) {
		Review review = reviewRepository.findById(id).orElse(null);
		review.setStatus(ReviewStatus.REJECTED);
		reviewRepository.save(review);
		return review;
	}

}
