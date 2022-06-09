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


	@Override
	public Boolean AddUser(User u) {
		System.out.println("ADDUser");
		Boolean s = false;
		try {
			String img = "";
			String isDependent = "NO";
			String relation = "SELF";
			String bg = "NULL";
			int weightuser = 0;
			int heightuser = 0;
			//String useradd = ("insert into users(email_id,password,imageUrl,country,name,contact,isDependent,relationship,blood_group,dob,weight,height)"+" values()");
			String useradd ="insert into users(email_id,password,imageUrl,country,name,contact,isDependent,relationship,blood_group,dob,weight,height) values('"+u.email+ "','"+u.password +"','"+ img +"','"+u.country+"','"+u.name+"',"+u.contact+",'"+isDependent +"','"+relation+"','"+bg+"',to_date('"+u.dob+"','yyyy-mm-dd'),"+weightuser+","+heightuser+")";
			System.out.println(useradd);
			int rs = st.executeUpdate(useradd);
			System.out.println(rs);
            s=true;
            }catch(Exception ex) {
            	System.out.println(ex);
                   
            }
		
		return s;
	}

}
