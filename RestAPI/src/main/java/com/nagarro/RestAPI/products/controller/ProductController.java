package com.nagarro.RestAPI.products.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.RestAPI.products.model.Product;
import com.nagarro.RestAPI.products.service.ProductService;

/**
 * 
 * @author evprasannaharigopal
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Save Product

	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	}

	// Get Products from table

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productService.getProducts();
		return ResponseEntity.ok(products);
	}

	// GetProducts by ProductCode

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product productById = productService.getProductById(id);
		return ResponseEntity.ok(productById);
	}

	// GetProducts by ProductCode

	@GetMapping("/product/{code}")
	public ResponseEntity<Product> getProductByCode(@PathVariable int code) {
		Product productByCode = productService.getProductByCode(code);
		return ResponseEntity.ok(productByCode);
	}

	// Get product by name

	@GetMapping("/productbyname/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name) {
		Product productByName = productService.getProductByName(name);
		return ResponseEntity.ok(productByName);
	}

	// Update Product details

	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
		return ResponseEntity.ok(updatedProduct);

	}

	// Delete Product
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		String message = productService.deleteProductById(id);
		return ResponseEntity.ok(message);
	}

}
