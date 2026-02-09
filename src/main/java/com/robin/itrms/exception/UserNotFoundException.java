package com.robin.itrms.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super("Can not find user with id: "+id);
	}
}
