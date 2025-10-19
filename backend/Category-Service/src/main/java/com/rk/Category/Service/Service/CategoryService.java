package com.rk.Category.Service.Service;

import java.util.Set;

import com.rk.Category.Service.Modal.Category;
import com.rk.Category.Service.dto.SalonDTO;

public interface CategoryService {
	
	Category saveCategory(Category category, SalonDTO salonDTO);
	
	Set<Category> getAllCategoriesBySalonId(Long id);
	
	Category getCategoryById(Long id) throws Exception;
	
	void deleteCategoryById(Long id,Long salonId) throws Exception;
	
	

}
