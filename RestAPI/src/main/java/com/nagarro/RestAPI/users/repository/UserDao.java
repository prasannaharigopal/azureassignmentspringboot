package com.nagarro.RestAPI.users.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.RestAPI.users.model.User;

/**
 * 
 * @author evprasannaharigopal
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	User findByEmailIdAndPassword(String emailId, String password);

	boolean existsByEmailId(String email);

}
