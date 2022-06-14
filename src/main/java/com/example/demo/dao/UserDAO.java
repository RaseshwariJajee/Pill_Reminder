package com.example.demo.dao;
import java.util.List;

import com.example.demo.entities.User;

public interface UserDAO {
	public Boolean loginVerify(User u);
	public Boolean addUser(User u);
	public Boolean resetPassword(User u);	
	public Boolean editUser(User u);
	public List<User> getDetails(String email);
	
	public List<User> viewDependents(User u);
	public int viewid(String email);
	
}
