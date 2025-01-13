package com.joaobertholino.springsecuritydemo.repository;

import com.joaobertholino.springsecuritydemo.model.UserAuth;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, UUID> {
	Optional<UserDetails> findUserAuthByUsername(@NotBlank(message = "The authenticated user name cannot be null and void.") String username);
}
