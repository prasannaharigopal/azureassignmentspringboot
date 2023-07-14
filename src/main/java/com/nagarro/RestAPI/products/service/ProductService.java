package com.nagarro.RestAPI.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.RestAPI.products.model.Product;
import com.nagarro.RestAPI.products.repository.ProductRepository;

/**
 * 
 * @author evprasannaharigopal
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// saving product into products table
	@Transactional
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// Get Data from Products Table
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();

	}

	// GetProduct by Id
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	// Get Product by Code
	public Product getProductByCode(int code) {
		return productRepository.findByProductCode(code);
	}

	// Get product by name
	public Product getProductByName(String name) {
		return productRepository.findByProductName(name);
	}

	// Update Product
	@Transactional
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(product);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductBrand(product.getProductBrand());
		existingProduct.setProductCode(product.getProductCode());
		existingProduct.setProductPrice(product.getProductPrice());
		return productRepository.save(existingProduct);

	}

	// delete ProductBy Id
	@Transactional
	public String deleteProductById(int id) {
		productRepository.deleteById(id);
		return "Product deleted!";
	}

	// get the products count
	public long getProductCount() {
		return productRepository.count();
	}

}
