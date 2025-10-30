package com.RK.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RK.Exception.UserException;
import com.RK.Model.User;
import com.RK.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}

		throw new UserException("User not found with id " + id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isEmpty()) {
			throw new UserException("User not found with id " + id);
		}

		userRepository.deleteById(existingUser.get().getId());

	}

	@Override
	public User updateUser(Long id, User user) throws Exception {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User updatedUser = existingUser.get();
			updatedUser.setFullName(user.getFullName());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPhone(user.getPhone());
			updatedUser.setRole(user.getRole());
			// updatedUser.setPassword(user.getPassword());
			updatedUser.setUserName(user.getUserName());
			return userRepository.save(updatedUser);
		} else {
			throw new UserException("User not found with id " + id);
		}
	}

}
