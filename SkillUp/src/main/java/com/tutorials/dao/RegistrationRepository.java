package com.tutorials.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorials.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String mailid);

	public User findByPassword(String password);
}
