package com.robin.itrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robin.itrms.entity.User;
import com.robin.itrms.repository.UserRepository;

@Service 
public class UserService {
	
	
	private final UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User getUserInfo(Long id) {
		return userRepo.findById(id).
				orElseThrow(()-> new RuntimeException("User not found"));
	}
	
}
