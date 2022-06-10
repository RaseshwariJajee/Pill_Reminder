 package com.example.demo.userDaoTest;
 import static org.assertj.core.api.Assertions.assertThat;

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
	void testVerify(){
		 
		User u=new User("roma1@gmail.com","Roma*");
		//expected
		Boolean val1=true;
		
		//actual
		Boolean val2=dao.loginVerify(u); 
		
		assertThat(val1).isEqualTo(val2);  
		
		
	}
	@Test
	void testResetPassword(){
		 
		User u=new User("roma1@gmail.com","Roma*","Roma**");
		//expected
		Boolean val1=true;
		
		//actual
		Boolean val2=dao.loginVerify(u); 
		
		assertThat(val1).isEqualTo(val2);  
		
		
	}
	

}
