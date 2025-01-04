package com.joaobertholino.springsecuritydemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotBlank(message = "The product name cannot be null or empty.")
	@Column(name = "product_name", unique = true, nullable = false)
	private String name;

	@NotNull(message = "The price of the product cannot be zero.")
	@DecimalMin(message = "The price of the product cannot be negative or equals to zero.", value = "0.00", inclusive = false)
	@Column(name = "product_price", precision = 10, scale = 2)
	private BigDecimal price;
}
