package com.joaobertholino.springsecuritydemo.repository;

import com.joaobertholino.springsecuritydemo.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, UUID> {
	UserDetails findByUsername(String username);
}
