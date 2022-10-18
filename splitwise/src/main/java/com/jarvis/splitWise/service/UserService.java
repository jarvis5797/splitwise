package com.jarvis.splitWise.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jarvis.splitWise.dao.UserRegistrationDao;
import com.jarvis.splitWise.entity.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDao registrationDao);
	
}
