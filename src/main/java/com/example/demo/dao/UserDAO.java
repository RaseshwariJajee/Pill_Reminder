package com.example.demo.dao;
import com.example.demo.entities.User;

public interface UserDAO {
	public Boolean loginVerify(User u);
	public Boolean addUser(User u);
	public Boolean resetPassword(User u);
}
