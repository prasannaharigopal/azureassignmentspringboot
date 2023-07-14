package com.nagarro.RestAPI.stats.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author evprasannaharigopal
 *
 */

public class TableCountResponse {
	private long usersCount;
	private long productsCount;
	private long reviewsCount;

	public TableCountResponse(long usersCount, long productsCount, long reviewsCount) {
		this.usersCount = usersCount;
		this.productsCount = productsCount;
		this.reviewsCount = reviewsCount;
	}

	public TableCountResponse() {

	}

	public long getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(long usersCount) {
		this.usersCount = usersCount;
	}

	public long getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(long productsCount) {
		this.productsCount = productsCount;
	}

	public long getReviewsCount() {
		return reviewsCount;
	}

	public void setReviewsCount(long reviewsCount) {
		this.reviewsCount = reviewsCount;
	}

	@Override
	public String toString() {
		return "TableCountResponse [usersCount=" + usersCount + ", productsCount=" + productsCount + ", reviewsCount="
				+ reviewsCount + "]";
	}

}
