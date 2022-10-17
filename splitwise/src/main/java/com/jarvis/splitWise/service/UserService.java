package com.jarvis.splitWise.service;

import com.jarvis.splitWise.dao.UserRegistrationDao;
import com.jarvis.splitWise.entity.User;

public interface UserService {
	User save(UserRegistrationDao registrationDao);
	
}
