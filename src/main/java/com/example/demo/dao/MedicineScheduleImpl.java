package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.MedicineSchedule;

public class MedicineScheduleImpl implements MedicineScheduleDAO{
	
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
	public List<MedicineSchedule> DisplaySchedule() {
		List<MedicineSchedule> users = new ArrayList<>();
		try {
			System.out.println("hi");
			st=con.createStatement();
			String sql = "select user_Id,illness,doctor_details,medicine_details,start_date,end_date,dosage_amount,dosage_frequency,dosage_times,email_notify from Medicine_Schedules";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
		        int id = rs.getInt("user_Id");
		        String illness = rs.getString("illness");
		        String doctor_details = rs.getString("doctor_details");
		        String medicine_deatils = rs.getString("medicine_details");
		        String start_date = rs.getString("start_date");
		        String end_date = rs.getString("end_date");
		        String dosage_amount = rs.getString("dosage_amount");
		        int dosage_frequency = rs.getInt("dosage_frequency");
		        String dosage_times = rs.getString("dosage_times");
		        String email_notify = rs.getString("email_notify");
		        users.add(new MedicineSchedule(id,illness,doctor_details,medicine_deatils,start_date,end_date,dosage_amount,dosage_frequency,dosage_times,email_notify));
		      }
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return users;
	}
	@Override
	public List<MedicineSchedule> displayMedicalHistory(String useremailid) {
		List<MedicineSchedule> usershistory = new ArrayList<>();
		try {
			int id1=checkid(useremailid);
			System.out.println(id1);
			String sql = "select user_Id,illness,doctor_details,medicine_details,start_date,end_date,dosage_amount,dosage_frequency,dosage_times,email_notify from Medicine_Schedules where user_id="+id1;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
		        int id = rs.getInt("user_Id");
		        String illness = rs.getString("illness");
		        String doctor_details = rs.getString("doctor_details");
		        String medicine_deatils = rs.getString("medicine_details");
		        String start_date = rs.getString("start_date");
		        String end_date = rs.getString("end_date");
		        String dosage_amount = rs.getString("dosage_amount");
		        int dosage_frequency = rs.getInt("dosage_frequency");
		        String dosage_times = rs.getString("dosage_times");
		        String email_notify = rs.getString("email_notify");
		        usershistory.add(new MedicineSchedule(id,illness,doctor_details,medicine_deatils,start_date,end_date,dosage_amount,dosage_frequency,dosage_times,email_notify));
		      }
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return usershistory;
		
	}
	public int checkid(String useremailid) throws SQLException {
		int id2=0;
		st=con.createStatement();
		String sql = "select id from Users where email_id="+useremailid;
		System.out.println(sql);
		//System.out.println(rs);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
	
			id2 = rs.getInt("id");
			System.out.println(id2);
		}

		return id2;
	}
	

}
