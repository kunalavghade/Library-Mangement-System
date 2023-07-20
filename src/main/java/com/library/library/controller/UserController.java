package com.library.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.curd.UserService;
import com.library.library.entities.User;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		try {
			user = this.userService.save(user);
			System.out.println(Optional.of(null));
			return ResponseEntity.of(Optional.of(user));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{status}")
	public ResponseEntity<List<User>> getUsers(@PathVariable boolean status) {
		try {
			List<User> list = this.userService.getUsers(status);
			return ResponseEntity.of(Optional.of(list));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/page/{num}/{status}") 
	public ResponseEntity<Page<User>> getUsers(@PathVariable int num, @PathVariable boolean status) {
		try {
			Page<User> page= this.userService.getUsers(status,PageRequest.of(num, 7));
			return ResponseEntity.of(Optional.of(page));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
}
