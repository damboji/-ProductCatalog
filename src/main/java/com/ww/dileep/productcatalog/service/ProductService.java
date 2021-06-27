package com.ww.dileep.productcatalog.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ww.dileep.productcatalog.entity.Category;
import com.ww.dileep.productcatalog.entity.Product;
import com.ww.dileep.productcatalog.vo.Products;
import com.ww.dileep.productcatalog.entity.SubCategory;
import com.ww.dileep.productcatalog.repository.ProductRepository;
import com.ww.dileep.productcatalog.vo.Media;
import com.ww.dileep.productcatalog.vo.Sku;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	private static final Logger log = null;

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private SubCategoryService subCatService;
	
	@Autowired
	private RestTemplate restTemplate;

	public Product saveProduct(Product product) {
		//log.info("Inside saveProduct method in ProductService ");

		return productRepo.save(product);
	}

	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return productRepo.findByProductId(productId);
	}
	


	/*
	 * public List<Product> findProductsByCategory(String catName) { // TODO
	 * Auto-generated method stub return productRepo.findAllByCategoryName(catName);
	 * }
	 */
	
	public List<Products> findProductsByCategory(String catName) {
		// TODO Auto-generated method stub
		List<Product> prodList = productRepo.findAllByCategoryName(catName);
		List<Products> productResponseList = getCatsSkuAndMedia(prodList);
				
		return productResponseList;
	}

	

	private List<Products> getCatsSkuAndMedia(List<Product> prodList) {
		// TODO Auto-generated method stub
					
		List<Products> productResponseList = new ArrayList<Products>();
		
		for(int i = 0; i <prodList.size();i++) {
			Product p = prodList.get(i);
			Category c  = catService.findCatById(p.getCategoryId());
			SubCategory s  = subCatService.findSubCategoryById(p.getSubcategoryId());

			//Sku skuresult = restTemplate.getForObject("http://localhost:8001/sku/byproduct/"+p.getProductId(),Sku.class);
			Sku[] skuresult = restTemplate.getForObject("http://SKU-SERVICE/sku/byproduct/"+p.getProductId(),Sku[].class);


            List<Sku> sku = new ArrayList<Sku>();
            for(int eachSku = 0 ; eachSku < skuresult.length; eachSku++) {
                sku.add((Sku) skuresult[eachSku]);           
            }
            
            

			//Media mresult = restTemplate.getForObject("http://localhost:9001/media/byproduct/"+p.getProductId(),Media.class);
			Media[] mresult = restTemplate.getForObject("http://MEDIA-SERVICE/media/byproduct/"+p.getProductId(),Media[].class);

			
            List<Media> media = new ArrayList<Media>();
            for(int eachMedia = 0 ; eachMedia < mresult.length; eachMedia++) {
            	media.add((Media) mresult[eachMedia]);           
            }
            
            //media.add((Media) mresult[0]);   
            
			Products pr = new Products(p,c.getName(),s.getName(),sku,media);
			pr.setCategory(c);
			pr.setProduct(p);
			productResponseList.add(pr);
		}
		return productResponseList;
	}

	public boolean deleteByProductId(int productId) {
		// TODO Auto-generated method stub
		productRepo.deleteById(productId);
		return true;
	}

	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	
}
