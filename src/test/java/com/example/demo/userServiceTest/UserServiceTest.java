package com.example.demo.userServiceTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;

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
	void checkuser() {
		UserServiceImpl serviceimp = new UserServiceImpl();
		String res = "Registered Successfully";
		User u = new User("abcc@gmail.com","eee","India","abcc",1274567890,"1999-07-20");
		assertEquals(res,serviceimp.registerDetails(u));
	}
	
	
	@Test
	void testReset() {
		User u=new User("abcc@gmail.com","eee","ee9");
		
		String s1="Password Reset Successful";
		String s2=ser.reset(u);
		assertThat(s1).isEqualTo(s2);
		
	}
	
	@Test
	void testLoginCredentials() {
		User u=new User("abcc@gmail.com","ee9");
		
		String s1="Login Successful";
		String s2=ser.loginCredentials(u);
		assertThat(s1).isEqualTo(s2);
	}
	
	
}
