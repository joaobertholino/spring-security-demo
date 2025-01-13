package com.joaobertholino.springsecuritydemo.service.impl;

import com.joaobertholino.springsecuritydemo.mapper.ProductMapper;
import com.joaobertholino.springsecuritydemo.mapper.dto.ProductDto;
import com.joaobertholino.springsecuritydemo.model.Product;
import com.joaobertholino.springsecuritydemo.repository.ProductRepository;
import com.joaobertholino.springsecuritydemo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	private ProductMapper productMapper;

	@Override
	public ProductDto findByName(String name) {
		Product product = this.productRepository.findProductByName(name).orElseThrow(() -> new RuntimeException("Product not found in the database."));
		return this.productMapper.entityToResponse(product);
	}

	@Override
	public void insertProduct(ProductDto productDto) {
		Product entityToSave = this.productMapper.RequestToEntity(productDto);
		this.productRepository.save(entityToSave);
	}
}
