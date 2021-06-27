package com.ww.dileep.productcatalog.repository;

import org.springframework.stereotype.Repository;
import com.ww.dileep.productcatalog.entity.Product;
import com.ww.dileep.productcatalog.entity.SubCategory;

import java.util.List;

import org.springframework.data.jpa.repository.*;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

	SubCategory findBySubCategoryId(int subCategoryId);

	List<SubCategory> findByCategoryId(int categoryId);


}
