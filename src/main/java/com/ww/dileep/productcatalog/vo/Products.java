package com.ww.dileep.productcatalog.vo;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ww.dileep.productcatalog.entity.Category;
import com.ww.dileep.productcatalog.entity.Product;
import com.ww.dileep.productcatalog.vo.Media;
import com.ww.dileep.productcatalog.vo.Sku;

public class Products {
	
	/*
	 * private List<Product> products; //private List<ProductResponse>
	 * productReponse; private int productCount; private Product product;
	 */	
	private int productId;
	private String productName;
	private String description;
	private String url;
	private String currency;
	private String categoryName;
	private String subcategoryName;
	
	@JsonIgnore
	private Product product;
	@JsonIgnore
	private Category category;
	private List<Sku> sku;
	private List<Media> media;
	//private SubCategory subCategory;
	/*
	 * public ProductResponse(List<Product> findProductsByCategory) { // TODO
	 * Auto-generated constructor stub productCount = findProductsByCategory.size();
	 * products = findProductsByCategory; }
	 */
	

	public Products(Product p, String cname,String sname,List<Sku> sku2, List<Media> media) {
		// TODO Auto-generated constructor stub
		this.categoryName = cname;
		this.subcategoryName = sname;
		this.productId = p.getProductId();
		this.productName = p.getProductName();
		this.description = p.getDescription();
		this.url = p.getUrl();
		this.currency = p.getCurrency();
		this.subcategoryName = sname;
		this.setSku(sku2);
		this.setMedia(media);
	}

	@JsonProperty("Product Id")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@JsonProperty("Product Name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("URL")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@JsonProperty("Currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@JsonProperty("Category")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@JsonProperty("Subcategory")
	public String getSubcategoryName() {
		return subcategoryName;
	}


	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	@JsonIgnore
	public Product getProduct() {
		return product;
	}

	@JsonIgnore
	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonIgnore
	public Category getCategory() {
		return category;
	}

	@JsonIgnore
	public void setCategory(Category category) {
		this.category = category;
	}


	@JsonProperty("SKUs")
	public List<Sku> getSkus() {
		return sku;
	}

	public void setSku(List<Sku> sku) {
		this.sku = sku;
	}


	@JsonProperty("Medias")
	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

}
