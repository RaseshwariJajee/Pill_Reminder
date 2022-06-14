package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.MedicineSchedule;
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
			EncryptionDecryption td =new EncryptionDecryption();
			String img = "";
			String isDependent = "NO";
			String relation = "SELF";
			String bg = "NULL";
			int weightuser = 0;
			int heightuser = 0;
			String encrypted=td.encrypt(u.getPassword());
			String useradd ="insert into users(email_id,password,imageUrl,country,name,contact,isDependent,relationship,blood_group,dob,weight,height) values('"+u.getEmail()+ "','"+encrypted +"','"+ img +"','"+u.getCountry()+"','"+u.getName()+"',"+u.getContact()+",'"+isDependent +"','"+relation+"','"+bg+"',to_date('"+u.getDob()+"','yyyy-mm-dd'),"+weightuser+","+heightuser+")";
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
			EncryptionDecryption td =new EncryptionDecryption();
			
		            
		            ResultSet rs=st.executeQuery("select email_id,password from Users where email_id='"+u.getEmail()+"'");
		            while(rs.next()) {
		            	
		            	String decrypted=td.decrypt(rs.getString("password"));
		            	
		            	
		            	
		            	if(rs.getString("email_id").equals(u.getEmail())&&decrypted.equals(u.getPassword()))
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
		try {EncryptionDecryption td =new EncryptionDecryption();
			
		            
		            ResultSet rs=st.executeQuery("select password from Users where email_id='"+u.getEmail()+"'");
		           
		            while(rs.next()) {
		            	
		            	String decrypted=td.decrypt(rs.getString("password"));
		            	
		            	//System.out.println(decrypted);
		            	if(decrypted.equals(u.getPassword()))
		            		
		            	{
		            		String encrypted=td.encrypt(u.getNewPassword());
		            		String updatepassword ="update users set password='"+encrypted+"' where email_id='"+u.getEmail()+"'";
		        		
		        			int rs1 = st.executeUpdate(updatepassword);
		        			
		            	s=true;
		            	}
		            	
		            }
		     }catch(Exception ex) {
		            
		     }

				return s;
	}
	@Override
	public List<User> getDetails(String email) {
		
		List<User> user = new ArrayList<>();
		try {
			
			
			String sql = "select id,name,email_id,imageUrl,country,isDependent,relationship,contact,blood_group,dob,weight,height from users where email_id='"+email+"'";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
		        int id =rs.getInt("id");
		        String name = rs.getString("name");
		        String email1 = rs.getString("email_id");
		        String imageUrl = rs.getString("imageUrl");
		        String country = rs.getString("country");
		        String isDependent = rs.getString("isDependent");
		        String relationship = rs.getString("relationship");
		        long contact = rs.getLong("contact");
		        String blood_group = rs.getString("blood_group");
		        String dob = rs.getString("dob");
		        int weight = rs.getInt("weight");
		        int height = rs.getInt("height");
		        
		        user.add(new User(id,name,email1,imageUrl,country,isDependent,relationship,contact,blood_group,dob,weight,height));
		      }
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return user;
		
	}
	@Override	
	public Boolean editUser(User u) {
Boolean s=false;

	if(u.getRelationship().equalsIgnoreCase("SELF"))
	{
		try {
		u.setIsDependent("NO");	
	String update ="Update users set relationship='"+u.getRelationship()+"',isDependent='"+u.getIsDependent()+"',name='"+u.getName()+"',contact="+u.getContact()+",blood_group='"+u.getBlood_group()+"',dob=to_date('"+u.getDob()+"','yyyy/mm/dd'),weight="+u.getWeight()+",height="+u.getHeight()+" where email_id='"+u.getEmail()+"'";
	
          int x=st.executeUpdate(update);
          s=true;
            }
	catch(Exception ex) {
            	System.out.println(ex);
            	
                   
            }
            return s;
}
	
else
{
	try {
		u.setIsDependent("YES");
		String password = "NULL";
		String country = "NULL";
		String img = "";
		String dependentadd ="insert into users(email_id,password,imageUrl,country,name,contact,isDependent,relationship,blood_group,dob,weight,height) values('"+u.getEmail()+ "','"+password +"','"+ img +"','"+country+"','"+u.getName()+"',"+u.getContact()+",'"+u.getIsDependent() +"','"+u.getRelationship()+"','"+u.getBlood_group()+"',to_date('"+u.getDob()+"','yyyy/mm/dd'),"+u.getWeight()+","+u.getHeight()+")";
		String getdependentid="select id from users where email_id='"+u.getEmail()+"'";
				int rs = st.executeUpdate(dependentadd);
				ResultSet rs1 = st.executeQuery(getdependentid);
				while(rs1.next()) {
					int id =rs1.getInt("id");					
					String relation="insert into Relations values("+id+","+u.getId()+")";
					int r = st.executeUpdate(relation);
					
				s=true;
				}
				
		
            }
	catch(SQLIntegrityConstraintViolationException e)
	{
		try {
			u.setIsDependent("YES");	
		String update ="Update users set relationship='"+u.getRelationship()+"',isDependent='"+u.getIsDependent()+"',name='"+u.getName()+"',contact="+u.getContact()+",blood_group='"+u.getBlood_group()+"',dob=to_date('"+u.getDob()+"','yyyy/mm/dd'),weight="+u.getWeight()+",height="+u.getHeight()+" where email_id='"+u.getEmail()+"'";
		
	          int x=st.executeUpdate(update);
	          s=true;
	            }
		catch(Exception ex) {
	            	System.out.println(ex);
	            	
	                   
	            }
		
	}
	catch(Exception ex) {
		
            	System.out.println(ex);
            	       
	
	
}
	return s;
		
	}
	
		

	}
	@Override
	public List<User> viewDependents(User u) {
		List<User> user = new ArrayList<>();
		try {
			String dependents="select dependent_id from relations where user_id="+u.getId();
			ResultSet rs1 = st.executeQuery(dependents);
			while(rs1.next())
			{
				
				String dependent = "select name,email_id,imageUrl,country,isDependent,relationship,contact,blood_group,dob,weight,height from users where id="+rs1.getInt("dependent_id")+" and relationship='"+u.getRelationship()+"'";
				
				ResultSet rs = st.executeQuery(dependent);
						
			
			while(rs.next()) {
				
		        
		        String name = rs.getString("name");
		        
		        String email1 = rs.getString("email_id");
		        
		        String imageUrl = rs.getString("imageUrl");
		        
		        String country = rs.getString("country");
		        
		        String isDependent = rs.getString("isDependent");
		        
		        String relationship = rs.getString("relationship");
		        
		        long contact = rs.getLong("contact");
		        
		        String blood_group = rs.getString("blood_group");
		        
		        String dob = rs.getString("dob");
		        
		        int weight = rs.getInt("weight");
		        
		        int height = rs.getInt("height");
		        user.add(new User(u.getId(),name,email1,imageUrl,country,isDependent,relationship,contact,blood_group,dob,weight,height));
		      }
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return user;
		
		
	}
	@Override
	public int viewid(String email) {
		int id2=0;
		try {
			st=con.createStatement();
			String sql = "select id from users where email_id='"+email+"'";
			System.out.println(sql);
			//System.out.println(rs);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
		
				id2 = rs.getInt("id");
				System.out.println(id2);
			}
		}catch(Exception ex) {
			
		}

		return id2;
		
	}
}
