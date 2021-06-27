package com.ww.dileep.productcatalog.vo;

import java.util.List;

public class ProductList {
	

	private int productCount;
	private List<Products> products;
	

	
	/*
	 * public ProductList(List<Product> findProductsByCategory) { // TODO
	 * Auto-generated constructor stub productCount = findProductsByCategory.size();
	 * products = findProductsByCategory; }
	 */

	public ProductList(List<Products> findProductsByCategory) {
		// TODO Auto-generated constructor stub
		productCount = findProductsByCategory.size();
		products = findProductsByCategory;
		
	}
	



	public List<Products> getProducts() {
		return products;
	}




	public void setProducts(List<Products> products) {
		this.products = products;
	}




	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	
}
