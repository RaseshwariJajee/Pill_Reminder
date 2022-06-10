package com.example.demo.userControllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.controller.UserController;
import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;

public class UserControllerTest {
	
	private UserDAOImpl dao=new UserDAOImpl();
	private  UserController controller=new UserController();
	
	@BeforeEach
	void setUp() {
		if(!dao.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
	}
	
	
	
	@Test
	void testResetPassword() {
		User u=new User("sam@gmail.com","Sam","Mas");
		
		String s1="Password Reset Successful";
		String s2=controller.resetPassword(u);
		assertThat(s1).isEqualTo(s2);
		
	}/*
	
	@Test
	void testCheck() {
		User u=new User("sam@gmail.com","Sam");
		
		String s1="Login Successful";
		String s2=controller.check(u);
		assertThat(s1).isEqualTo(s2);
	
	
	
}*/
}