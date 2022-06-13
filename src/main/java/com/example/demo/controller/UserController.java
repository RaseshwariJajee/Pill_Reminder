package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;




@RestController
public class UserController {
	UserServiceImpl impl = new UserServiceImpl();
	
	@CrossOrigin
    @PostMapping("/login")
    public String check(@RequestBody User u){	
		
		
		
			return impl.loginCredentials(u);
			
		}    
	@CrossOrigin
    @PostMapping("/register")
	public String register(@RequestBody User u) {
		return impl.registerDetails(u);
	}
	@CrossOrigin
    @PostMapping("/reset_password")
	public String resetPassword(@RequestBody User u) {
		return impl.reset(u);
	}
	@CrossOrigin
    @GetMapping("/profile/{email}")
	public List<User> ViewDetails(@PathVariable String email) {
		
		        
        return impl.Details(email);
  }
	
	@CrossOrigin
	@PutMapping("/profile")
	public String EditDetails(@RequestBody User u) {
		        
        return impl.Edit(u);
  }
	
	
    

}
