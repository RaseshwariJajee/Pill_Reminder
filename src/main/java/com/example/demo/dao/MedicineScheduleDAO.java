package com.example.demo.dao;

import java.util.List;

import com.example.demo.entities.MedicineSchedule;

public interface MedicineScheduleDAO {
	public List<MedicineSchedule> DisplaySchedule();
	public List<MedicineSchedule> displayMedicalHistory(String useremailid);
	public List<MedicineSchedule> ViewMed_his(MedicineSchedule u);
	public Boolean MedicalUser(MedicineSchedule u);
}
