package com.RK.Service;

import java.util.List;

import com.RK.Model.User;

public interface UserService {

	User createUser(User user);

	User getUserById(Long id) throws Exception;

	List<User> getAllUsers();

	void deleteUser(Long id) throws Exception;

	User updateUser(Long id, User user) throws Exception;

}
