package com.robin.itrms.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.robin.itrms.entity.User;
import com.robin.itrms.exception.UserNotFoundException;
import com.robin.itrms.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRepository getUserRepo() {
    return userRepo;
    }
    //R
    public User getUserInfo(Long id) {
    return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));

    }
    //R
    public List<User> getAllUsers(){
      return this.getUserRepo().findAll();

    }
    //C
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.getUserRepo().save(user);
    }
    //U
    public User updateUser(User newUser, long id) {
      UserRepository repo = this.getUserRepo();
      return repo.findById(id)
              .map(user ->{
                  user.setEmail(newUser.getEmail());
                  user.setPassword(newUser.getPassword());
                  return repo.save(user);
              })
              .orElseThrow(()-> new RuntimeException(String.format("Update user with id: %d failed", id)));
    }

    //D
    public void deleteUser(Long id) {
      this.getUserRepo().deleteById(id);
    }

}
