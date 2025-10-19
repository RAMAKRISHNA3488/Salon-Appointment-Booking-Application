package com.rk.Category.Service.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.Category.Service.Modal.Category;
import com.rk.Category.Service.Service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/salon/{id}")
	public ResponseEntity<Set<Category>> getCategoriesBySalon(@PathVariable Long id){
		Set<Category> categories = categoryService.getAllCategoriesBySalonId(id);
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) throws Exception{
		Category category = categoryService.getCategoryById(id);
		return ResponseEntity.ok(category);
	}
	
}
