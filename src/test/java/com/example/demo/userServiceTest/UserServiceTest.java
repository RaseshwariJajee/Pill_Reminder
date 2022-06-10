package com.example.demo.userServiceTest;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;


import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	private UserDAOImpl dao=new UserDAOImpl();
	private  UserServiceImpl ser=new UserServiceImpl();
	
	@BeforeEach
	void setUp() {
		if(!dao.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
	}
	
	@Test
	void testReset() {
		User u=new User("roma.jajee99@gmail.com","Jajee","Jajee1");
		
		String s1="Password Reset Successful";
		String s2=ser.reset(u);
		assertThat(s1).isEqualTo(s2);
		
	}
	@Test
	void testLoginCredentials() {
		User u=new User("roma.jajee99@gmail.com","Jajee1");
		
		String s1="Login Successful";
		String s2=ser.loginCredentials(u);
		assertThat(s1).isEqualTo(s2);
	}
	

}
