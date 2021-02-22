package com.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entities.AuthenticationRequest;
import com.user.app.filter.util.JwtUtil;

@RestController
@RequestMapping(path = "/api/v1")
//@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "welcome to user service application.";
	}


	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid username and password");
		}
		return jwtUtil.generateToken(request.getUsername());

	}

}
