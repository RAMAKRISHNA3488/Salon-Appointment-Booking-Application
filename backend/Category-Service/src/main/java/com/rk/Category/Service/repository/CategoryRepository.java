package com.rk.Category.Service.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.Category.Service.Modal.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Set<Category> findBySalonId(Long salonId);
}
