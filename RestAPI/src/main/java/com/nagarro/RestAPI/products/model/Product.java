package com.nagarro.RestAPI.products.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nagarro.RestAPI.reviews.model.Review;
import com.sun.istack.NotNull;

/**
 * 
 * @author evprasannaharigopal
 *
 */
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int productCode;
	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private String productBrand;
	private double productPrice;

	@OneToMany(targetEntity = Review.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private List<Review> reviews;

	public Product(int productCode, String productName, String productBrand, double productPrice, List<Review> review) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.reviews = reviews;
	}

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", productName=" + productName + ", productBrand="
				+ productBrand + ", productPrice=" + productPrice + ", reviews=" + reviews + "]";
	}

}
