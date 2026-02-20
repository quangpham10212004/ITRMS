package com.robin.itrms.service;

import com.robin.itrms.entity.Admin;
import com.robin.itrms.entity.User;
import com.robin.itrms.exception.UserNotFoundException;
import com.robin.itrms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
    private UserRepository userRepo;
    public Admin getAdminInfo(String userName) {
        return (Admin)userRepo.findByUserName(userName).orElseThrow(() -> new UserNotFoundException(userName));

    }
}
