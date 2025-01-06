package com.joaobertholino.springsecuritydemo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {
	ADMIN("ADMIN"),
	USER("USER");

	private final String role;
}
