package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	public String loginCredentials(User u);
	public String registerDetails(User u);
	public String reset(User u);
	
	
	public String Edit(User u);
	public List<User> Details(String email);
	
	public List<User> ViewDependents(User u);
	
}
