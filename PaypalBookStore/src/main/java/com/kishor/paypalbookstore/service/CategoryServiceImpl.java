package com.kishor.paypalbookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishor.paypalbookstore.dao.CategoryRepository;
import com.kishor.paypalbookstore.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
    
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getAllCategories() {
		
		return categoryRepository.findAll();
		
	}

}
