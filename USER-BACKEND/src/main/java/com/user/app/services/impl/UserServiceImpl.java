package com.user.app.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.user.app.entities.User;
import com.user.app.repository.UserRepository;
import com.user.app.services.UserService;

import javassist.NotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	@Override
	public String save(User user) throws Exception {
		String encodedPassword = passwordEncoder.encodePassword(user.getPassword());
		user.setPassword(encodedPassword);
		User savedUser = userRepository.save(user);
		if (savedUser != null) {
			return "user saved successfully";
		}
		throw new Exception("something going wrong.");
	}

	@Override
	public Page<User> getAll(Pageable pageable, String keyword) throws Exception {

		if (keyword.contentEquals("")) {
			return userRepository.findAll(pageable);
		}
		return userRepository.findAll(pageable, keyword);
	}

	@Override
	public User getById(long id) throws Exception {
		Optional<User> byId = userRepository.findById(id);
		if (byId.isPresent()) {
			return byId.get();
		}
		throw new NotFoundException("user with provided id is not found.");
	}

	@Override
	public String deleteUser(long id) throws Exception {
		Optional<User> byId = userRepository.findById(id);
		if (byId.isPresent()) {
			User user = byId.get();
			userRepository.delete(user);
			return "user deleted successfully.";
		}
		throw new Exception("user with id " + id + " not found.");
	}

	@Override
	public User loginUser(User user) throws Exception {
		String username = user.getUsername();
		String password = user.getPassword();
		User loggedUser = userRepository.findByUsernameAndPassword(username, password);
		if (loggedUser != null) {
			loggedUser.setPassword("*********");
			return loggedUser;
		}
		throw new Exception("user with " + username + " not existed.");
	}

	@Override
	public User findByUsername(String username) throws Exception {
		return userRepository.findByUsername(username);
	}

}
