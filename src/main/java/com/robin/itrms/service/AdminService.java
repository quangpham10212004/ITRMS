package com.robin.itrms.service;

import com.robin.itrms.eenum.RoleUser;
import com.robin.itrms.eenum.UserStatus;
import com.robin.itrms.entity.Admin;
import com.robin.itrms.entity.User;
import com.robin.itrms.exception.UserNotFoundException;
import com.robin.itrms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
    private UserRepository userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin getAdminInfo(String userName) {
        return (Admin)userRepo.findByUserName(userName).orElseThrow(() -> new UserNotFoundException(userName));
    }

    public Admin CreateNewAdmin(User user) {
        Admin admin = new Admin();
        admin.setUserName(user.getUserName());
        admin.setEmail(user.getEmail());
        admin.setId(user.getId());
        admin.setDob(user.getDob());
        admin.setPassword(passwordEncoder.encode(user.getPassword()));
        admin.setRole(RoleUser.ADMIN);
        admin.setStatus(UserStatus.ACTIVE);
        admin.setPhoneNumber(user.getPhoneNumber());
        return userRepo.save(admin);
    }
}
