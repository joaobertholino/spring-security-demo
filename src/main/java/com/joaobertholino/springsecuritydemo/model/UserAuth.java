package com.joaobertholino.springsecuritydemo.model;

import com.joaobertholino.springsecuritydemo.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user_auth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAuth implements UserDetails {

	@Id
	private String username;

	@NotBlank(message = "The authenticated user's password cannot be null or empty.")
	@Column(nullable = false)
	private String password;

	@NotNull(message = "Authenticated user rules cannot be null.")
	@Enumerated(value = EnumType.ORDINAL)
	@Column(nullable = false)
	private UserRole role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == UserRole.ADMIN)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
}
