package com.jarvis.splitWise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.splitWise.dao.UserRegistrationDao;
import com.jarvis.splitWise.entity.User;
import com.jarvis.splitWise.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		User user =new User();
		model.addAttribute("user",user);
		return "html/registration";
	}
	
	@PostMapping("/save")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDao registrationDao) {
		userService.save(registrationDao);
		return "redirect:/registration?success";
	}
	
}
