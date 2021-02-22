package com.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entities.User;
import com.user.app.services.UserService;

@RestController
//@RequestMapping(path = "/api/v1")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/save")
	public ResponseEntity<String> save(@RequestBody User user) throws Exception {

		return ResponseEntity.ok(userService.save(user));
	}

	@GetMapping(path = "/find")
	public ResponseEntity<Page<User>> getAll(@RequestParam(name = "page") int page,
			@RequestParam(name = "limit") int limit, @RequestParam(name = "keyword") String keyword) throws Exception {
		Pageable pageable = PageRequest.of((page - 1), limit);
		Page<User> userPage = userService.getAll(pageable, keyword);

		return ResponseEntity.ok(userPage);
	}

	@GetMapping(path = "/find-id")
	public ResponseEntity<User> getById(@RequestParam("id") long id) throws Exception {
		User user = userService.getById(id);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestParam("id") long id) throws Exception {
		String message = userService.deleteUser(id);
		return ResponseEntity.ok(message);
	}
}
