package com.ww.dileep.productcatalog.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.dileep.productcatalog.entity.Category;
import com.ww.dileep.productcatalog.entity.Product;
import com.ww.dileep.productcatalog.repository.CategoryRepository;
import com.ww.dileep.productcatalog.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {

	private static final Logger log = null;

	@Autowired
	private CategoryRepository catRepo;

	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return catRepo.save(category);
	}

	public Optional<Category> findCategoryById(int catId) {
		// TODO Auto-generated method stub
		return catRepo.findById(catId);
	}

	public Category findCatById(int catId) {
		// TODO Auto-generated method stub
		return catRepo.findCategoryByCategoryId(catId);
	}

	public void deleteByCategoryId(int catId) {
		// TODO Auto-generated method stub
		catRepo.deleteById(catId);
	}

	public List<Category> finaAllCategories() {
		// TODO Auto-generated method stub
		return catRepo.findAll();
	}

	public Category findCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return catRepo.findByname(categoryName);
	}

	
}
