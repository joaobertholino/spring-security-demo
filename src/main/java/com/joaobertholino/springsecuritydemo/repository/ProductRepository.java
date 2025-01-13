package com.joaobertholino.springsecuritydemo.repository;

import com.joaobertholino.springsecuritydemo.model.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
	Optional<Product> findProductByName(@NotBlank(message = "The product name cannot be null or empty.") String name);
}
