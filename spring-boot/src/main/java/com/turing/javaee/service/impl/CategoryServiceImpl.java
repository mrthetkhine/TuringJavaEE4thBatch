package com.turing.javaee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turing.javaee.model.Category;
import com.turing.javaee.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories = new ArrayList<>();
		
		Category technology = new Category(1L,"Technology");
		Category business = new Category(2L,"Business");
		Category accounting = new Category(3L,"Accouting");
		
		categories.add(technology);
		categories.add(business);
		categories.add(accounting);
		
		return categories;
	}

}
