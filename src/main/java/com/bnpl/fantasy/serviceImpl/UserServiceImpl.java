package com.bnpl.fantasy.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.User;
import com.bnpl.fantasy.repository.UserRepository;
import com.bnpl.fantasy.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private Logger logger;
	
	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public void createUser(User user) {
		
		userRepo.save(user);
	}
	
	@Override
	public Optional<User> validateUser(User user) {
		String emailId = user.getEmailId();
		String passphrase = user.getPassphrase();
		if(emailId != null)
			emailId = emailId.trim();
		if(passphrase != null)
			passphrase = passphrase.trim();
		return userRepo.findByEmailIdAndPassphrase(emailId, passphrase);
	}
}
