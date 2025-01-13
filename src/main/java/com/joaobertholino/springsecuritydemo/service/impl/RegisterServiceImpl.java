package com.joaobertholino.springsecuritydemo.service.impl;

import com.joaobertholino.springsecuritydemo.mapper.dto.RegisterDto;
import com.joaobertholino.springsecuritydemo.model.UserAuth;
import com.joaobertholino.springsecuritydemo.repository.UserAuthRepository;
import com.joaobertholino.springsecuritydemo.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {
	private final UserAuthRepository userAuthRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void register(RegisterDto registerDto) {
		if (this.userAuthRepository.findByUsername(registerDto.username()) != null) throw new RuntimeException();

		String passwordEncrypted = this.passwordEncoder.encode(registerDto.password());
		UserAuth userAuthToSave = new UserAuth(registerDto.username(), passwordEncrypted, registerDto.role());
		this.userAuthRepository.save(userAuthToSave);
	}
}
