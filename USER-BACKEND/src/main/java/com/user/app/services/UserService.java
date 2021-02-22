package com.user.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.user.app.entities.User;

public interface UserService {

	public abstract String save(User user) throws Exception;

	public abstract Page<User> getAll(Pageable pageable, String keyword) throws Exception;

	public abstract User getById(long id) throws Exception;
	
	public abstract String deleteUser(long id) throws Exception;
	
	public abstract User loginUser(User user) throws Exception;

	public abstract User findByUsername(String username) throws Exception;
}
