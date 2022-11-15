package com.jarvis.splitWise.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import com.jarvis.splitWise.dao.UserRegistrationDao;
import com.jarvis.splitWise.entity.User;

@Repository
public interface UserService extends UserDetailsService {
	User save(UserRegistrationDao registrationDao);
	
}
