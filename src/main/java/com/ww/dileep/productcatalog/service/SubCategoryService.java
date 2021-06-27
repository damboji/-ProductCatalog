package com.ww.dileep.productcatalog.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.dileep.productcatalog.entity.Product;
import com.ww.dileep.productcatalog.entity.SubCategory;
import com.ww.dileep.productcatalog.repository.ProductRepository;
import com.ww.dileep.productcatalog.repository.SubCategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubCategoryService {

	private static final Logger log = null;

	@Autowired
	private SubCategoryRepository subCatRepo;

	public SubCategory saveSubCategory(SubCategory subCategory) {
		// TODO Auto-generated method stub
		return subCatRepo.save(subCategory);
	}

	public SubCategory findSubCategoryById(int subcatId) {
		// TODO Auto-generated method stub
		return subCatRepo.findBySubCategoryId(subcatId);
	}

	public List<SubCategory> finaAllSubCategories() {
		// TODO Auto-generated method stub
		return subCatRepo.findAll();
	}

	public void deleteBySubCategoryId(int subcatId) {
		// TODO Auto-generated method stub
		subCatRepo.deleteById(subcatId);
	}

	public List<SubCategory> findSubCatByCatId(int categoryId) {
		// TODO Auto-generated method stub
		return subCatRepo.findByCategoryId(categoryId);
	}

	
}
