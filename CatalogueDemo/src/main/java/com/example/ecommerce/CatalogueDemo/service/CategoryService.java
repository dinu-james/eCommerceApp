package com.example.ecommerce.CatalogueDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.CatalogueDemo.entity.Category;
import com.example.ecommerce.CatalogueDemo.exception.RecordNotFoundException;
import com.example.ecommerce.CatalogueDemo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> retrieveAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Optional<Category> retrieveCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		category.orElseThrow(() -> new RecordNotFoundException("Category not found with categoryId = "+ id));
		return category;
	}
	
	public Long createNewCategory(Category category) {
		categoryRepository.save(category);
		return category.getId();
	}
	
	public void updateCategory(Long id, Category category) {
		Optional<Category> existingCategory = categoryRepository.findById(id);
		if(!existingCategory.isPresent())
			throw new RecordNotFoundException("Category not found with categoryId = "+ id);
		category.setId(id);
		categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		category.orElseThrow(() -> new RecordNotFoundException("Category not found with categoryId = "+ id));
		categoryRepository.deleteById(id);
	}

}
