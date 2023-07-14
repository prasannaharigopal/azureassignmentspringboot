package com.nagarro.RestAPI.reviews.model;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nagarro.RestAPI.products.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nagarro.RestAPI.products.model.*;

/**
 * 
 * @author evprasannaharigopal
 *
 */
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private int rating;
	private String reviewTitle;
	private String description;
	@Enumerated(EnumType.STRING)
	private ReviewStatus status;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	public Review() {
		super();
	}

	public Review(int reviewId, int rating, String reviewTitle, String description, ReviewStatus status,
			Product product) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.reviewTitle = reviewTitle;
		this.description = description;
		this.status = status;
		this.product = product;

	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public ReviewStatus getStatus() {
		return status;
	}

	public void setStatus(ReviewStatus status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", rating=" + rating + ", reviewTitle=" + reviewTitle + ", description="
				+ description + ", status=" + status + "]";
	}

}
