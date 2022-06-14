package com.example.demo.services;

import java.util.List;

import com.example.demo.dao.MedicineScheduleDAO;
import com.example.demo.dao.MedicineScheduleImpl;
import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entities.MedicineSchedule;

public class MedicineScheduleServiceImpl implements MedicineServices{

	@Override
	public List<MedicineSchedule> ScheduleDisplay() {
		Boolean s;
        
		MedicineScheduleImpl md =new MedicineScheduleImpl();
       
        if(!md.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
        List<MedicineSchedule> listusers = md.DisplaySchedule();
        System.out.println(listusers);
         return listusers;
	}

	@Override
	public List<MedicineSchedule> displayMedicalhistory(String useremailid) {
		Boolean s;
        
        MedicineScheduleImpl md =new MedicineScheduleImpl();
       
        if(!md.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
        List<MedicineSchedule> listhistory = md.displayMedicalHistory(useremailid);
        System.out.println(listhistory);
        return listhistory;
	}

	@Override
	public List<MedicineSchedule> ViewMedical_his(MedicineSchedule u) {
		Boolean s;
		
        
		MedicineScheduleImpl md =new MedicineScheduleImpl();
       
        if(!md.connect()) {
            System.out.println("Error in establishing Connection");
            
     }
        System.out.println("hi");
        List<MedicineSchedule> listmedhistory = md.ViewMed_his(u);
        System.out.println(listmedhistory);
   
         
         return listmedhistory;
		

	}

}
