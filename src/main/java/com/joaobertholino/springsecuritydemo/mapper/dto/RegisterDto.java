package com.joaobertholino.springsecuritydemo.mapper.dto;

import com.joaobertholino.springsecuritydemo.enums.UserRole;

public record RegisterDto(
		String username,
		String password,
		UserRole role
) {
}
