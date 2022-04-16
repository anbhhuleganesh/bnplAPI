package com.bnpl.fantasy.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.User;

@Component
public interface UserService {

	public void createUser(User user);
	
	public Optional<User> validateUser(User user);
}
