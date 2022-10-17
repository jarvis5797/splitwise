package com.jarvis.splitWise.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.splitWise.dao.UserRegistrationDao;
import com.jarvis.splitWise.entity.Role;
import com.jarvis.splitWise.entity.User;
import com.jarvis.splitWise.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User save(UserRegistrationDao registrationDao) {
		User user = new User(registrationDao.getFirstName(),registrationDao.getLastName() , registrationDao.getEmail(),
				registrationDao.getPassword(), registrationDao.getContactNo(), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

}
