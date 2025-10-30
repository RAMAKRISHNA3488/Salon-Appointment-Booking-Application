package com.rk.Category.Service.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.Category.Service.Modal.Category;
import com.rk.Category.Service.dto.SalonDTO;
import com.rk.Category.Service.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category, SalonDTO salonDTO) {
		Category newCategory = new Category();
		newCategory.setName(category.getName());
		newCategory.setSalonId(salonDTO.getId());
		newCategory.setImage(category.getImage());
		return categoryRepository.save(newCategory);
	}

	@Override
	public Set<Category> getAllCategoriesBySalonId(Long id) {
		return categoryRepository.findBySalonId(id);
	}

	@Override
	public Category getCategoryById(Long id) throws Exception {
		Category category = categoryRepository.findById(id).orElse(null);
		if (category == null) {
			throw new Exception("Category not found with id: " + id);
		}
		return category;
	}

	@Override
	public void deleteCategoryById(Long id,Long salonId) throws Exception {
		Category category= getCategoryById(id);
		if (!category.getSalonId().equals(salonId)) {
			throw new Exception("Category with id: " + id + " does not belong to salon with id: " + salonId);
		}
		categoryRepository.deleteById(id);
	}

}
