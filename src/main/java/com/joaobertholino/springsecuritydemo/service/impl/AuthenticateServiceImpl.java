package com.joaobertholino.springsecuritydemo.service.impl;

import com.joaobertholino.springsecuritydemo.mapper.dto.AuthenticateDto;
import com.joaobertholino.springsecuritydemo.mapper.dto.TokenDto;
import com.joaobertholino.springsecuritydemo.model.UserAuth;
import com.joaobertholino.springsecuritydemo.service.AuthenticateService;
import com.joaobertholino.springsecuritydemo.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	@Override
	public TokenDto generatedUsernamePasswordToken(AuthenticateDto authenticateDto) {
		UsernamePasswordAuthenticationToken usernamePasswordToken = new UsernamePasswordAuthenticationToken(authenticateDto.username(), authenticateDto.password());
		Authentication auth = this.authenticationManager.authenticate(usernamePasswordToken);
		String token = this.jwtService.generatedToken((UserAuth) auth.getPrincipal());
		return new TokenDto(token);
	}
}
