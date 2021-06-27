package com.ww.dileep.productcatalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
/*
 * @Data
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 */
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String description;
	private String url;
	private String currency;
	//@Column(nullable=false,insertable=false,updatable=false)
	private int categoryId;
	private int subcategoryId;
	
	/*
	 * @Transient private String categoryName; private String subCategoryName;
	 */

	/*
	 * @ManyToOne(optional=false)
	 * 
	 * @JoinColumn(name="categoryId") private Category category;
	 */
		
	/*
	 * public Category getCategory() { return category; } public void
	 * setCategory(Category category) { this.category = category; }
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	/*
	 * public String getCategoryName() { return categoryName; } public void
	 * setCategoryName(String categoryName) { this.categoryName = categoryName; }
	 * public String getSubCategoryName() { return subCategoryName; } public void
	 * setSubCategoryName(String subCategoryName) { this.subCategoryName =
	 * subCategoryName; }
	 */

}
