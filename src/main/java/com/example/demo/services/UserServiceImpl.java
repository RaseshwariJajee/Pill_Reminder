package com.example.demo.services;


import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.User;

public class UserServiceImpl implements UserServices{
	
	@Override
	public String registerDetails(User u) {
		
		Boolean s;
		UserDAOImpl c = new UserDAOImpl();
		if(!c.connect()) {
			System.out.println("Error in establishing Connection");
		}
		s = c.addUser(u);
		if(s == true) {
			return "Registered Successfully";
		}else {
			return "Failed to Register";
		}
	} 

	@Override
	public String loginCredentials(User u) {
		Boolean s;
		
        
        UserDAOImpl c=new UserDAOImpl();
       
        if(!c.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
         s=c.loginVerify(u);
         
         if(s==true) {
      	   return "Login Successful";
         }
         else {
      	   return "Invalid Credentials";
         }
	}

	@Override
	public String reset(User u) {
Boolean s;
		
        
        UserDAOImpl c=new UserDAOImpl();
       
        if(!c.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
         s=c.resetPassword(u);
         
         if(s==true) {
      	   return "Password Reset Successful";
         }
         else {
      	   return "Wrong Password";
         }
		
		
	}

}
