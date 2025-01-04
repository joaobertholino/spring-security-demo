package com.joaobertholino.springsecuritydemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
	ADMIN("Admin"),
	USER("User");

	private final String role;
}
