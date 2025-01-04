package com.joaobertholino.springsecuritydemo.service;

import com.joaobertholino.springsecuritydemo.mapper.dto.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface ProductService {
	ProductDto findByName(@NotBlank(message = "The product name parameter in the service class cannot be null or empty.") String name);

	void insertProduct(@Valid ProductDto productDto);
}
