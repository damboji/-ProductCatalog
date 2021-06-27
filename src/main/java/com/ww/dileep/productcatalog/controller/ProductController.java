package com.ww.dileep.productcatalog.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ww.dileep.productcatalog.entity.Product;
import com.ww.dileep.productcatalog.service.ProductService;
import com.ww.dileep.productcatalog.vo.ProductList;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
	
	private static final Logger log = null;
	
	@Autowired
	private ProductService productService;	
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		//log.info("Inside saveProduct method in ProductController ");
		return productService.saveProduct(product);
	}

	@GetMapping("/{id}")
	public Product findProductById(@PathVariable("id") int productId) {
		//log.info("Inside findProductById  method in ProductController ");
		return productService.findProductById(productId);

	}
	
	/*
	 * @GetMapping("/category/{categoryName}") public ProductList
	 * findProductsByCategory(@PathVariable("categoryName") String categoryName) {
	 * 
	 * List<Product> products= productService.findProductsByCategory(categoryName);
	 * ProductList pl = new
	 * ProductList(productService.findProductsByCategory(categoryName)); return pl;
	 * 
	 * }
	 */
	
	@GetMapping("/category/{categoryName}")
	public ProductList findProductsByCategory(@PathVariable("categoryName") String categoryName) {
		
		//List<Product> products= productService.findProductsByCategory(categoryName);
		ProductList pl = new ProductList(productService.findProductsByCategory(categoryName));
		return pl;

	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProductById(@PathVariable("id") int productId) {
		//log.info("Inside findProductById  method in ProductController ");
		 productService.deleteByProductId(productId);
		return "Successfully deleted: " +productId;

	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		//log.info("Inside saveProduct method in ProductController ");
		return productService.updateProduct(product);
	}
}
