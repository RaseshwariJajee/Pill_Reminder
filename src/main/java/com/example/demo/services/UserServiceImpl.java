package com.example.demo.services;


import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.User;

public class UserServiceImpl implements UserServices{

	@Override
	public String loginCredentials(User u) {
		Boolean s;
        
        UserDAOImpl c=new UserDAOImpl();
       
        if(!c.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
         s=c.LoginVerify(u);
         
         if(s==true) {
      	   return "Login Successful";
         }
         else {
      	   return "Login Unsuccessful";
         }
	}

}
