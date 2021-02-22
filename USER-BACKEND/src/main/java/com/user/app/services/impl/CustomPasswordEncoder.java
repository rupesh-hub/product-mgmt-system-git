package com.user.app.services.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPasswordEncoder {

	public String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
}
