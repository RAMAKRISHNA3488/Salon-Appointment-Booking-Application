package com.rk.Category.Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.Category.Service.Modal.Category;
import com.rk.Category.Service.Service.CategoryService;
import com.rk.Category.Service.dto.SalonDTO;

@RestController
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		SalonDTO dto = new SalonDTO();
		dto.setId(1L);
		Category saveCategory = categoryService.saveCategory(category, dto);
		return ResponseEntity.ok(saveCategory);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
		SalonDTO dto = new SalonDTO();
		dto.setId(1L);
		categoryService.deleteCategoryById(id, dto.getId());
		return ResponseEntity.ok("Category deleted successfully");
	}

}
