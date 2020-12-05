package com.tutorials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorials.dao.RegistrationRepository;
import com.tutorials.model.User;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserbyMailId(String mailid) {
		return repo.findByEmailId(mailid);
	}

	public User fetchUserbyPassword(String password) {
		return repo.findByPassword(password);
	}

}
