package com.joaobertholino.springsecuritydemo.service;

import com.joaobertholino.springsecuritydemo.model.UserAuth;

public interface JwtService {
	String generatedToken(UserAuth userAuth);
	String validateToken(String token);
}
