package com.ww.dileep.productcatalog.repository;

import org.springframework.stereotype.Repository;

import com.ww.dileep.productcatalog.entity.Category;
import com.ww.dileep.productcatalog.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByname(String categoryName);

	Category findCategoryByCategoryId(int catId);
	
	//List<Category> findByName(String name);

	
}
