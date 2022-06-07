package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import com.example.demo.entities.User;




public class UserDAOImpl implements UserDAO{
	
	private Connection con;
	static Statement st;
	public Boolean connect() 
	{Boolean x=false;
		try {
			 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
			st=this.con.createStatement();
			x=true;
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return x;
		
	}
	
	
	@Override
	public Boolean LoginVerify(User u) {
		
		
		
		Boolean s=false;
		try {
			
		            
		            ResultSet rs=st.executeQuery("select email_id,password from Users where email_id='"+u.email+"'");
		            while(rs.next()) {
		            	
		            	
		            	if(rs.getString("email_id").equals(u.email)&&rs.getString("password").equals(u.password))
		            	{
		            	s=true;
		            	}
		            	
		            }
		     }catch(Exception ex) {
		            
		     }

				return s;
	}

}
