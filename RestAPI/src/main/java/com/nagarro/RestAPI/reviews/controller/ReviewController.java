package com.nagarro.RestAPI.reviews.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.RestAPI.products.model.Product;
import com.nagarro.RestAPI.products.service.ProductService;
import com.nagarro.RestAPI.reviews.model.Review;
import com.nagarro.RestAPI.reviews.service.ReviewService;

/**
 * 
 * 
 * @author evprasannaharigopal
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ProductService productService;

	// getting review
	@GetMapping("/getReviews")
	public ResponseEntity<List<Review>> getReviews() {
		List<Review> reviews = reviewService.getReviews();
		return ResponseEntity.ok(reviews);
	}

	// Posting review
	@PostMapping("/products/{productId}/addreview")
	public ResponseEntity<Review> createReview(@PathVariable int productId, @RequestBody Review review) {
		Product product = productService.getProductById(productId);
		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		review.setProduct(product);
		Review savedReview = reviewService.createReview(review);

		return ResponseEntity.ok(savedReview);
	}

	// getting review
	@GetMapping("/products/{productId}/reviews")
	public ResponseEntity<List<Review>> getReviewByProductId(@PathVariable int productId) {
		List<Review> reviews = reviewService.getReviewById(productId);
		return ResponseEntity.ok(reviews);
	}

	// deleting review
	@DeleteMapping("/review/{id}/delete")
	public ResponseEntity<String> deleteReview(@PathVariable int id) {
		String result = reviewService.deleteReview(id);
		return ResponseEntity.ok(result);

	}

	// approving review
	@PutMapping("/approve/{id}/reviewstatus")
	public ResponseEntity<?> updateReviewStatus(@PathVariable int id) {
		Review approvedReview = reviewService.updatedReviewStatus(id);
		return ResponseEntity.ok(approvedReview);
	}

	// rejecting review
	@PutMapping("/reject/review/{id}")
	public ResponseEntity<?> rejectReview(@PathVariable int id) {
		Review rejectedReview = reviewService.rejectReviewStatus(id);
		return ResponseEntity.ok(rejectedReview);

	}

}
