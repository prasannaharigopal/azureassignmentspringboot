package com.nagarro.RestAPI.users.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.RestAPI.users.model.LoginRequest;
import com.nagarro.RestAPI.users.model.User;
import com.nagarro.RestAPI.users.service.UserService;
/**
 * 
 * @author evprasannaharigopal
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User userById = userService.getUserById(id);
		return ResponseEntity.ok(userById);
	}

	@PutMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

	// Login Authentication
	@PostMapping("/login")
	public User login(@RequestBody LoginRequest loginRequest) {
		User user = userService.authenticateUser(loginRequest.getEmailId(), loginRequest.getPassword());
		if (user == null) {
			return null;
		} else {
			return user;
		}

	}

	// checking emailId is present or not
	@PostMapping("/checkEmailAlreadyExists/{email}")
	public boolean isUserAlreadyExists(@PathVariable String email) {
		return userService.checkEmailAlreadyExists(email);
	}

}
