package com.joaobertholino.springsecuritydemo.service.impl;

import com.joaobertholino.springsecuritydemo.repository.UserAuthRepository;
import com.joaobertholino.springsecuritydemo.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
	private final UserAuthRepository userAuthRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userAuthRepository.findByUsername(username);
	}
}
