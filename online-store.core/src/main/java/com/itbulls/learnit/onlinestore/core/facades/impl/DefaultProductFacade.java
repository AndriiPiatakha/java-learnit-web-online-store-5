package com.itbulls.learnit.onlinestore.core.facades.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.facades.ProductFacade;
import com.itbulls.learnit.onlinestore.persistence.dao.ProductDao;
import com.itbulls.learnit.onlinestore.persistence.dto.converters.ProductDtoToProductConverter;
import com.itbulls.learnit.onlinestore.persistence.entities.Product;

@Service
public class DefaultProductFacade implements ProductFacade {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductDtoToProductConverter productConverter;


	@Override
	public List<Product> getProductsLikeName(String searchQuery) {
		return productConverter
				.convertProductDtosToProducts(productDao.getProductsLikeName(searchQuery));
	}

	@Override
	public List<Product> getProductsByCategoryId(Integer id) {
		return productConverter
				.convertProductDtosToProducts(productDao.getProductsByCategoryId(id));
	}

	@Override
	public List<Product> getProductsByCategoryIdForPageWithLimit(Integer categoryId, Integer page,
			Integer paginationLimit) {
		return productConverter
				.convertProductDtosToProducts(productDao.getProductsByCategoryIdPaginationLimit(categoryId, page, paginationLimit));
	}

	@Override
	public Integer getNumberOfPagesForCategory(Integer categoryId, Integer paginationLimit) {
		Integer totalProductsInCategory = productDao.getProductCountForCategory(categoryId);
		int pages = totalProductsInCategory / paginationLimit;
		if ( (totalProductsInCategory % paginationLimit) != 0) {
			pages++;
		}
		return pages;
	}

	@Override
	public Integer getNumberOfPagesForSearch(String searchQuery, Integer paginationLimit) {
		Integer totalProductsForSearch = productDao.getProductCountForSearch(searchQuery);
		int pages = totalProductsForSearch / paginationLimit;
		if ( (totalProductsForSearch % paginationLimit) != 0) {
			pages++;
		}
		return pages;
	}

	@Override
	public List<Product> getProductsLikeNameForPageWithLimit(String searchQuery, Integer page,
			Integer paginationLimit) {
		return productConverter
				.convertProductDtosToProducts(productDao
						.getProductsLikeNameForPageWithLimit(searchQuery, page, paginationLimit));
	}

	@Override
	public Product getProductById(Integer productId) {
		return productConverter.convertProductDtoToProduct(productDao.getProductById(productId));
	}

	@Override
	public Product getProductByGuid(String guid) {
		return productConverter.convertProductDtoToProduct(productDao.getProductByGuid(guid));
	}

}
