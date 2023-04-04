package com.FlyNow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlyNow.entities.User;
import com.FlyNow.repository.UserRepository;

//import com.flight_reservation.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	//http://localhost:8080/flynow/
	@RequestMapping("/showLoginPage")
	public String showLoginPage () {
		return "login/login";
	}

	
	//http://localhost:8080/flynow/showReg
	@RequestMapping("/showReg")
	public String showReg () {
		return "login/showReg";
	}
	
	//http://localhost:8080/flynow/login
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user ) {
		userRepo.save(user);
		return "login/login";
		
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId")String emailId, @RequestParam("password")String password,ModelMap modelMap) {
		User user = userRepo.findByEmail(emailId);
		if (user!=null) {
			
		if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
			return "findFlights";
		} else {
			modelMap.addAttribute("error", "Invalid username/password");
			return "login/login";
		}
		} else {
			modelMap.addAttribute("error", "Invalid username/password");
			return "login/login";
		}
		
	}
	
}
