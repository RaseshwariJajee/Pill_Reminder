package com.example.demo.entities;

public class MedicineSchedule {
	private int user_id;
	private String illness;
	private String doctor_details;
	private String medicine_details;
	private String start_date;
	private String end_date;
	private String dosage_amount;
	private int doasge_feq;
	private String dosage_time;
	private String email_notify;
	private String relationship;
	
	public MedicineSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicineSchedule(int user_id, String illness, String doctor_details, String medicine_details,
			String start_date, String end_date, String dosage_amount, int doasge_feq, String dosage_time,
			String email_notify,String relationship) {
		super();
		this.user_id = user_id;
		this.illness = illness;
		this.doctor_details = doctor_details;
		this.medicine_details = medicine_details;
		this.start_date = start_date;
		this.end_date = end_date;
		this.dosage_amount = dosage_amount;
		this.doasge_feq = doasge_feq;
		this.dosage_time = dosage_time;
		this.email_notify = email_notify;
		this.relationship= relationship;
	}

	public MedicineSchedule(int user_id, String illness, String doctor_details, String medicine_details,
			String start_date, String end_date, String dosage_amount, int doasge_feq, String dosage_time,
			String email_notify) {
		super();
		this.user_id = user_id;
		this.illness = illness;
		this.doctor_details = doctor_details;
		this.medicine_details = medicine_details;
		this.start_date = start_date;
		this.end_date = end_date;
		this.dosage_amount = dosage_amount;
		this.doasge_feq = doasge_feq;
		this.dosage_time = dosage_time;
		this.email_notify = email_notify;
	}
	
	public MedicineSchedule(int user_id, String relationship) {
		super();
		this.user_id = user_id;
		this.relationship = relationship;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getDoctor_details() {
		return doctor_details;
	}

	public void setDoctor_details(String doctor_details) {
		this.doctor_details = doctor_details;
	}

	public String getMedicine_details() {
		return medicine_details;
	}

	public void setMedicine_details(String medicine_details) {
		this.medicine_details = medicine_details;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDosage_amount() {
		return dosage_amount;
	}

	public void setDosage_amount(String dosage_amount) {
		this.dosage_amount = dosage_amount;
	}

	public int getDoasge_feq() {
		return doasge_feq;
	}

	public void setDoasge_feq(int doasge_feq) {
		this.doasge_feq = doasge_feq;
	}

	public String getDosage_time() {
		return dosage_time;
	}

	public void setDosage_time(String dosage_time) {
		this.dosage_time = dosage_time;
	}

	public String getEmail_notify() {
		return email_notify;
	}

	public void setEmail_notify(String email_notify) {
		this.email_notify = email_notify;
	}
	
	
}
