package com.jarvis.splitWise.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jarvis.splitWise.dao.UserRegistrationDao;
import com.jarvis.splitWise.entity.Role;
import com.jarvis.splitWise.entity.User;
import com.jarvis.splitWise.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User save(UserRegistrationDao registrationDao) {
		User user = new User(registrationDao.getFirstName(),registrationDao.getLastName() , registrationDao.getEmail(),
				passwordEncoder.encode(registrationDao.getPassword()), registrationDao.getContactNo(), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role ->  new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

}
