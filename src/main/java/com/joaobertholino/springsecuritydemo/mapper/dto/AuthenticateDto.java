package com.joaobertholino.springsecuritydemo.mapper.dto;

public record AuthenticateDto(
		String username,
		String password
) {
}
