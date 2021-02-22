package com.user.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u "
			+ "where u.firstName LIKE %?1% " 
			+ "OR u.lastName LIKE %?1% " 
			+ "OR u.email LIKE %?1% "
			+ "OR u.username LIKE %?1% " 
			+ "OR u.age LIKE %?1% " 
			+ "OR u.id LIKE %?1%")
	public Page<User> findAll(Pageable pageable, String keyword);
	
	public User findByUsernameAndPassword(String username, String password);
	public User findByUsername(String username);
}
