package com.nagarro.RestAPI.stats.controller;

import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.RestAPI.products.repository.ProductRepository;
import com.nagarro.RestAPI.products.service.ProductService;
import com.nagarro.RestAPI.reviews.service.ReviewService;
import com.nagarro.RestAPI.stats.model.TableCountResponse;
import com.nagarro.RestAPI.users.repository.UserDao;
import com.nagarro.RestAPI.users.service.UserService;
/**
 * 
 * @author evprasannaharigopal
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class TableDataCount {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ReviewService reviewService;

	
	@GetMapping("/tableCounts")
	public ResponseEntity<?> getTableRowCount() {

		long usersCount = userService.getUserCount();
		long productsCount = productService.getProductCount();
		long reviewsCount = reviewService.getReviewsCount();
		TableCountResponse tableCountResponse = new TableCountResponse(usersCount, productsCount, reviewsCount);
		return ResponseEntity.ok(tableCountResponse);

	}
}
