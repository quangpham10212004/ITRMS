package com.robin.itrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robin.itrms.entity.User;
import com.robin.itrms.service.UserService;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("")
	public List<User> showAllUsers(){
		return userService.getAllUsers();
	}
	public List<User> ShowAllMembers(){
		return userService.getAllMembers();
	}

	@PostMapping("")
	public User createNewUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	// specification
	
	@GetMapping("/{id}")
	public EntityModel<User> showSelectedUser(@PathVariable Long id) {
		User user =  userService.getUserInfo(id);
    return EntityModel.of(
    		user, 
    		linkTo(methodOn(UserController.class).showSelectedUser(id)).withSelfRel(),
    		linkTo(methodOn(UserController.class).showAllUsers()).withRel("all"));

	}

	@PutMapping("/{id}")
	public User changeUserEmailAndPassword(@RequestBody User newUser,@PathVariable Long id) {
		User temp = userService.getUserInfo(id);
		boolean invalid = newUser.getEmail() == temp.getEmail() ;
		if(!invalid)
			return userService.getUserRepo().findById(id).
				map(user -> {
					user.setEmail(newUser.getEmail() );
					user.setPassword(newUser.getPassword());
					return userService.getUserInfo(id);
				}).
				orElseGet(()->{
					return userService.createUser(newUser);
				});
		return userService.getUserRepo().findById(id)
				.map(user ->{
					user.setPassword(newUser.getPassword());
					return userService.getUserInfo(id);
				}).orElseGet(()->{
					return userService.createUser(newUser);
				});
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		
	}
}
