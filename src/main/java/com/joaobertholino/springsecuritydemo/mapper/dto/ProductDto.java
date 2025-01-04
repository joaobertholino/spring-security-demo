package com.joaobertholino.springsecuritydemo.mapper.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDto(
		@NotBlank(message = "The name of the product responding to a request cannot be null or empty.")
		String name,

		@NotNull(message = "The price of the product in dto to a request cannot be zero.")
		@DecimalMin(message = "The price of the product in dto to a request cannot be negative or equal to zero.", value = "0.00", inclusive = false)
		BigDecimal price
) {
}
