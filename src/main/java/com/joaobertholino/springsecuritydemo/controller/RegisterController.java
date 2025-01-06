package com.joaobertholino.springsecuritydemo.controller;

import com.joaobertholino.springsecuritydemo.mapper.dto.RegisterDto;
import com.joaobertholino.springsecuritydemo.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
@RequiredArgsConstructor
public class RegisterController {
	private final RegisterService registerService;

	@PostMapping(value = "/user/admin", consumes = "application/json")
	public ResponseEntity<Void> registerNewUserAdmin(@RequestBody RegisterDto registerDto) {
		this.registerService.register(registerDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<Void> registerNewUserNonAdmin(@RequestBody RegisterDto registerDto) {
		this.registerService.register(registerDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
