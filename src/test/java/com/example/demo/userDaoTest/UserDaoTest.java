 package com.example.demo.userDaoTest;
 import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.User;


 

@SpringBootTest
public class UserDaoTest {
	
	private UserDAOImpl dao=new UserDAOImpl();
	@BeforeEach
	void setUp() {
		if(!dao.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
	}
	@Test
	void connectionTest() {
		UserDAOImpl userimpl = new UserDAOImpl();
		assertEquals(true,userimpl.connect());
	}
	
	
	@Test
	void testVerify(){
		 
		User u=new User("ak@gmail.com","ak");
		//expected
		Boolean val1=true;
		
		//actual
		Boolean val2=dao.loginVerify(u); 
		
		assertThat(val1).isEqualTo(val2);  
		
		
	}
	
	
	@Test
	void testResetPassword(){
		 
		User u=new User("ak@gmail.com","ak","a*");
		//expected
		Boolean val1=true;
		
		//actual
		Boolean val2=dao.loginVerify(u); 
		
		assertThat(val1).isEqualTo(val2);  
		
		
	}
	
	@Test
	void checkAddUser(){
		UserDAOImpl userimpl = new UserDAOImpl();
		userimpl.connect();
		User u = new User("ak@gmail.com","ak","India","Akanksha",1234567890,"1999-03-20");
		assertEquals(true,userimpl.addUser(u));
	}
	
	

}
