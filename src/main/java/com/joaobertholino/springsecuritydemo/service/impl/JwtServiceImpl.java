package com.joaobertholino.springsecuritydemo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.joaobertholino.springsecuritydemo.model.UserAuth;
import com.joaobertholino.springsecuritydemo.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtServiceImpl implements JwtService {
	@Value(value = "${spring.security.jwt.secret}")
	private String secret;

	@Value(value = "${spring.application.name}")
	private String issuer;

	@Override
	public String generatedToken(UserAuth userAuth) {
		Algorithm algorithm = Algorithm.HMAC256(this.secret);
		return JWT
				.create()
				.withIssuer(this.issuer)
				.withSubject(userAuth.getUsername())
				.withExpiresAt(this.getInstant())
				.sign(algorithm);
	}

	@Override
	public String validateToken(String token) {
		return JWT
				.require(Algorithm.HMAC256(this.secret))
				.withIssuer(this.issuer)
				.build()
				.verify(token)
				.getSubject();
	}

	private Instant getInstant() {
		return LocalDateTime
				.now()
				.plusHours(2)
				.toInstant(ZoneOffset.of("-03:00"));
	}
}
