package com.itbulls.learnit.onlinestore.persistence.dto.converters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.persistence.dto.ProductDto;
import com.itbulls.learnit.onlinestore.persistence.entities.Product;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultProduct;

@Service
public class ProductDtoToProductConverter {
	
	@Autowired
	private CategoryDtoToCategoryConverter categoryConverter;

	public List<Product> convertProductDtosToProducts(List<ProductDto> productDtos) {
		List<Product> products = new ArrayList<>();
		if (productDtos != null) {
			for (ProductDto productDto : productDtos) {
				products.add(convertProductDtoToProduct(productDto));
			}
		}
		
		return products;
	}

	public Product convertProductDtoToProduct(ProductDto productDto) {
		Product product = new DefaultProduct();
		if (productDto != null) {
			product.setId(productDto.getId());
			product.setPrice(productDto.getPrice().doubleValue());
			product.setProductName(productDto.getProductName());
			if (productDto.getCategoryDto() != null)
				product.setCategoryName(productDto.getCategoryDto().getCategoryName());
			product.setImgName(productDto.getImgName());
			product.setDescription(productDto.getDescription());
			product.setGuid(productDto.getGuid());
		}
		return product;
	}

	public List<ProductDto> convertProductsToProductDtos(List<Product> products) {
		List<ProductDto> productDtos = new ArrayList<>();
		
		for (Product product : products) {
			productDtos.add(convertProductToProductDto(product));
		}
		
		return productDtos;
	}

	private ProductDto convertProductToProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setPrice(BigDecimal.valueOf(product.getPrice()));
		productDto.setCategoryDto(categoryConverter.convertCategoryNameToCategoryDtoWithOnlyName(product.getCategoryName()));
		productDto.setProductName(product.getProductName());
		productDto.setImgName(product.getImgName());
		productDto.setDescription(product.getDescription());
		productDto.setGuid(product.getGuid());
		return productDto;
	}

}
