package com.nagarro.RestAPI.products.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.RestAPI.products.model.Product;

/**
 * 
 * @author evprasannaharigopal
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	Product findByProductCode(int productCode);

	Product findByProductName(String productName);

}
