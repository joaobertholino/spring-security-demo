package com.joaobertholino.springsecuritydemo.controller;

import com.joaobertholino.springsecuritydemo.mapper.dto.AuthenticateDto;
import com.joaobertholino.springsecuritydemo.mapper.dto.TokenDto;
import com.joaobertholino.springsecuritydemo.service.AuthenticateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@AllArgsConstructor
public class AuthenticateController {
	private final AuthenticateService authenticateService;

	@PostMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<TokenDto> authenticate(@RequestBody AuthenticateDto authenticateDto) {
		TokenDto token = this.authenticateService.generatedUsernamePasswordToken(authenticateDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(token);
	}
}
