package com.ww.dileep.productcatalog.controller;


import java.util.List;
import java.util.Optional;

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

import com.ww.dileep.productcatalog.entity.Category;
import com.ww.dileep.productcatalog.service.CategoryService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
	
	private static final Logger log = null;
	
	@Autowired
	private CategoryService catService;
	
	@PostMapping("/save")
	public Category saveCategory(@RequestBody Category category) {
		return catService.saveCategory(category);
	}

	@GetMapping("/{id}")
	public Optional<Category> findCatById(@PathVariable("id") int catId) {
		return catService.findCategoryById(catId);

	}
	
	@GetMapping("/findall")
	public List<Category> findAll() {
		return catService.finaAllCategories();

	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCategoryById(@PathVariable("id") int catId) {
		catService.deleteByCategoryId(catId);
		return "Successfully deleted: " +catId;

	}
	
	@PutMapping("/update")
	public Category updateCategory(@RequestBody Category category) {
		return catService.saveCategory(category);
	}
}
