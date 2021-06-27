package com.ww.dileep.productcatalog.repository;

import org.springframework.stereotype.Repository;
import com.ww.dileep.productcatalog.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductId(int productId);

	
	Product findByProductName(String name);


	@Query("select p from Product p,Category c where p.categoryId = c.categoryId and c.name=?1")
	List<Product> findAllByCategoryName(String catName);

}
