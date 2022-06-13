package com.example.demo.services;


import java.util.List;

import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.MedicineSchedule;
import com.example.demo.entities.User;

public class UserServiceImpl implements UserService{
	
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
	@Override
	public List<User> Details(String email) {
		 UserDAOImpl c=new UserDAOImpl();
		if(!c.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
		List<User> userDetails = c.getDetails(email);
        System.out.println(userDetails);
         return userDetails;
		
		
	}
	@Override
	public String Edit(User u) {
Boolean s;
		
        
        UserDAOImpl c=new UserDAOImpl();
       
        if(!c.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
         s=c.editUser(u);
         
         if(s==true) {
      	   return "Changes Updated";
         }
         else {
      	   return "Unable to Update Changes";
         }
		
	}

	
	

}
