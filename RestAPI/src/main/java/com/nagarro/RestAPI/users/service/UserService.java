package com.nagarro.RestAPI.users.service;

import com.nagarro.RestAPI.users.model.Role;
import com.nagarro.RestAPI.users.model.User;

import com.nagarro.RestAPI.users.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author evprasannaharigopal
 *
 */

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// Saving the User Data
	@Transactional
	public User saveUser(User user) {
		user.setRole(Role.USER);
		return userDao.save(user);
	}

	// Get the UserData
	public List<User> getUsers() {
		return (List<User>) userDao.findAll();
	}

	// Get User by Id
	public User getUserById(int userId) {
		return userDao.findById(userId).orElse(null);

	}

	// saving list of users
	@Transactional
	public List<User> saveUsers(List<User> users) {
		return (List<User>) this.userDao.saveAll(users);
	}

	// get the Count of Users
	public long getUserCount() {
		return userDao.count() - 1;
	}

	// deleting user
	@Transactional
	public String deleteUser(int id) {
		userDao.deleteById(id);
		return "deleted";
	}

	// Authenticate User with email and password
	public User authenticateUser(String email, String password) {
		User user = userDao.findByEmailIdAndPassword(email, password);
		if (user == null) {
			throw new IllegalArgumentException("wrong credentials");
		}
		return user;
	}

	// checking existing email id or Not
	public boolean checkEmailAlreadyExists(String email) {
		return userDao.existsByEmailId(email);
	}
}
