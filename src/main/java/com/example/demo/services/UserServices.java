package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserServices {
	public String loginCredentials(User u);
	public String registerDetails(User u);
	public String reset(User u);
}
