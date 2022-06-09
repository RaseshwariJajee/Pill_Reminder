package com.example.demo.dao;
import com.example.demo.entities.User;

public interface UserDAO {
	public Boolean LoginVerify(User u);
	public Boolean AddUser(User u);

}
