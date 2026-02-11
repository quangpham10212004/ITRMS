package com.robin.itrms.exception;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserNotFoundException extends RuntimeException implements UserDetails {
	public UserNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super("Can not find user with id: "+id);
	}
	public UserNotFoundException(String username) {
		super("Can not find user with name: "+username);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

	@Override
	public @Nullable String getPassword() {
		return "";
	}

	@Override
	public String getUsername() {
		return "";
	}
}
