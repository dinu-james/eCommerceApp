package com.example.ecommerce.CatalogueDemo.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.CatalogueDemo.entity.Category;
import com.example.ecommerce.CatalogueDemo.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/categories")
@Api("Set of endpoints for creating, retrieving, updating & deleting Category.")
public class CategoryController {

	private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService service;
	
	@ApiOperation("Get all Categories.")
	@GetMapping("/")
	public ResponseEntity<List<Category>> retrieveAllCategories() {
		return ResponseEntity.status(HttpStatus.OK).body(
				service.retrieveAllCategories());
	}
	
	@ApiOperation("Get a Category details. 404 if the category ID is not found.")
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Optional<Category>> retrieveCategoryById(@PathVariable Long categoryId) {
		return ResponseEntity.status(HttpStatus.OK).body(service.retrieveCategoryById(categoryId));
		
	}
	
	@ApiOperation("Create a new Category.")
	@PostMapping("/category")
	public ResponseEntity<Long> createNewCategory(@RequestBody Category category) {
		Long categoryId = service.createNewCategory(category);
		LOG.info("New Category created with ID: "+ categoryId);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryId);
	}
	 
	@ApiOperation("Update a category. 404 if the category ID is not found.")
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Void> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
		service.updateCategory(categoryId, category);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@ApiOperation("Delete a category. 404 if the category ID is not found.")
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
		service.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
