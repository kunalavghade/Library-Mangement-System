package com.library.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.curd.UserService;
import com.library.library.entities.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/User")
	public User saveUser(@RequestBody User user) {
		this.userService.save(user);
		return user;
	}
	
	@GetMapping("/User")
	public List<User> getUsers() {
		return this.userService.getUsers();
	}
	
	@GetMapping("/User/page/{num}") 
	public List<User> getUsers(@PathVariable int num) {
		Pageable p = PageRequest.of(num, 7);
		return this.userService.getUsers(p).getContent();
	}

	
}
