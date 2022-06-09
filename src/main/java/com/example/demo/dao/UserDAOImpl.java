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
	public Boolean addUser(User u) {
		
		Boolean s = false;
		try {
			String img = "";
			String isDependent = "NO";
			String relation = "SELF";
			String bg = "NULL";
			int weightuser = 0;
			int heightuser = 0;
			String useradd ="insert into users(email_id,password,imageUrl,country,name,contact,isDependent,relationship,blood_group,dob,weight,height) values('"+u.getEmail()+ "','"+u.getPassword() +"','"+ img +"','"+u.getCountry()+"','"+u.getName()+"',"+u.getContact()+",'"+isDependent +"','"+relation+"','"+bg+"',to_date('"+u.getDob()+"','yyyy-mm-dd'),"+weightuser+","+heightuser+")";
			//System.out.println(useradd);
			int rs = st.executeUpdate(useradd);
			
            s=true;
            }catch(Exception ex) {
            	
            	
            	System.out.println(ex);
                   
            }
		
		return s;
	} 
	
	@Override
	public Boolean loginVerify(User u) {
		
		
		
		Boolean s=false;
		try {
			
		            
		            ResultSet rs=st.executeQuery("select email_id,password from Users where email_id='"+u.getEmail()+"'");
		            while(rs.next()) {
		            	
		            	
		            	if(rs.getString("email_id").equals(u.getEmail())&&rs.getString("password").equals(u.getPassword()))
		            	{
		            	s=true;
		            	}
		            	
		            }
		     }catch(Exception ex) {
		            
		     }

				return s;
	}
	@Override
	public Boolean resetPassword(User u) {
		
		Boolean s=false;
		try {
			
		            
		            ResultSet rs=st.executeQuery("select password from Users where email_id='"+u.getEmail()+"'");
		            while(rs.next()) {
		            	
		            	
		            	if(rs.getString("password").equals(u.getPassword()))
		            	{
		            		String updatepassword ="update users set password='"+u.getNewPassword()+"' where email_id='"+u.getEmail()+"'";
		            		
		        			int rs1 = st.executeUpdate(updatepassword);
		        			
		            	s=true;
		            	}
		            	
		            }
		     }catch(Exception ex) {
		            
		     }

				return s;
	}

}
