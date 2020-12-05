package com.tutorials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.model.User;
import com.tutorials.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	public RegistrationService reg;

	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String mailid = user.getEmailId();
		if (mailid != null) {
			User check = reg.fetchUserbyMailId(mailid);
			if (check != null) {
				throw new Exception("User already exists");
			}
		}
		User obj = null;
		obj = reg.saveUser(user);
		return obj;
	}

	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String mailid = user.getEmailId();
		String password = user.getPassword();
		User obj = null;
		User obj1 = null;
		if (mailid != null && password != null) {
			obj = reg.fetchUserbyMailId(mailid);
			obj1 = reg.fetchUserbyPassword(password);
		}
		if (obj == null || obj1 == null) {
			throw new Exception("Wrong credentials");
		}
		return obj;
	}
}
