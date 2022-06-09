package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;




@RestController
public class UserController {
	UserServiceImpl impl = new UserServiceImpl();
	
	@CrossOrigin
    @PostMapping("/login")
    public String Check(@RequestBody User u){	
		
		
			return impl.loginCredentials(u);
			
		}    
    
	@CrossOrigin
    @PostMapping("/register")
	public String Register(@RequestBody User u) {
		return impl.RegisterDetails(u);
	}
	
}
