package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.MedicineSchedule;

public interface MedicineServices {
	public List<MedicineSchedule> ScheduleDisplay();
	public List<MedicineSchedule> displayMedicalhistory(String useremailid);
	public List<MedicineSchedule> ViewMedical_his(MedicineSchedule u);
}
