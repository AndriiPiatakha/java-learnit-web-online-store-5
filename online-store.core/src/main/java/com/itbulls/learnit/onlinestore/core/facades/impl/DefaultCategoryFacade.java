package com.itbulls.learnit.onlinestore.core.facades.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.facades.CategoryFacade;
import com.itbulls.learnit.onlinestore.persistence.dao.CategoryDao;
import com.itbulls.learnit.onlinestore.persistence.dto.converters.CategoryDtoToCategoryConverter;
import com.itbulls.learnit.onlinestore.persistence.entities.Category;

@Service
public class DefaultCategoryFacade implements CategoryFacade {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CategoryDtoToCategoryConverter categoryConverter;


	@Override
	public List<Category> getCategories() {
		return categoryConverter.convertCategoryDtosToCategories(categoryDao.getCategories());
	}

}
