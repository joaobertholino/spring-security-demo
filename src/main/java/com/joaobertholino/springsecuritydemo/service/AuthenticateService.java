package com.joaobertholino.springsecuritydemo.service;

import com.joaobertholino.springsecuritydemo.mapper.dto.AuthenticateDto;
import com.joaobertholino.springsecuritydemo.mapper.dto.TokenDto;

public interface AuthenticateService {
	TokenDto generatedUsernamePasswordToken(AuthenticateDto data);
}
