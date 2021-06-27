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

import com.ww.dileep.productcatalog.entity.SubCategory;
import com.ww.dileep.productcatalog.service.SubCategoryService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/subcategory")
@Slf4j
public class SubCategoryController {
	
	private static final Logger log = null;
	
	@Autowired
	private SubCategoryService subCatService;
	
	@PostMapping("/save")
	public SubCategory saveSubCategory(@RequestBody SubCategory SubCategory) {
		return subCatService.saveSubCategory(SubCategory);
	}

	@GetMapping("/{id}")
	public SubCategory findCatById(@PathVariable("id") int subcatId) {
		return subCatService.findSubCategoryById(subcatId);

	}
	
	@GetMapping("/findall")
	public List<SubCategory> findAll() {
		return subCatService.finaAllSubCategories();

	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSubCategoryById(@PathVariable("id") int subcatId) {
		subCatService.deleteBySubCategoryId(subcatId);
		return "Successfully deleted: " +subcatId;

	}
	
	@PutMapping("/update")
	public SubCategory updateSubCategory(@RequestBody SubCategory SubCategory) {
		return subCatService.saveSubCategory(SubCategory);
	}
}
