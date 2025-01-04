package com.joaobertholino.springsecuritydemo.controller;

import com.joaobertholino.springsecuritydemo.mapper.dto.ProductDto;
import com.joaobertholino.springsecuritydemo.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/product")
@AllArgsConstructor
public class ProductController {
	private ProductServiceImpl productServiceImpl;

	@GetMapping(value = "/get", produces = "application/json")
	public ResponseEntity<ProductDto> findByName(@RequestParam(name = "productName") @NotBlank(message = "The product name parameter in the controller class cannot be null or empty.") String productName) {
		ProductDto productDto = this.productServiceImpl.findByName(productName);
		return ResponseEntity.status(HttpStatus.FOUND).body(productDto);
	}

	@PostMapping(value = "/insert", consumes = "application/json")
	public ResponseEntity<Void> insertProduct(@RequestBody @Valid ProductDto productDto) {
		this.productServiceImpl.insertProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
