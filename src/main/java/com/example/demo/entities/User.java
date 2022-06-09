package com.example.demo.entities;


public class User {
	public int id;
	public String email;
	public String password;
	public String imageUrl;
	public String country;
	public String name ;
	public long contact;
	public String isDependent;
	public String relationship;
	public String blood_group;
	public String dob;
	public int weight;
	public int height;
	
	public User(int id, String email, String imageUrl, String country, String name, long contact, String blood_group,
			String dob, int weight, int height) {
		super();
		this.id = id;
		this.email = email;
		this.imageUrl = imageUrl;
		this.country = country;
		this.name = name;
		this.contact = contact;
		this.blood_group = blood_group;
		this.dob = dob;
		this.weight = weight;
		this.height = height;
	}
	
	public int getId() {
		return id;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getIsDependent() {
		return isDependent;
	}
	public void setIsDependent(String isDependent) {
		this.isDependent = isDependent;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


	public User(String email, String password, String country, String name, long contact, String dob) {
		super();
		this.email = email;
		this.password = password;
		this.country = country;
		this.name = name;
		this.contact = contact;
		this.dob = dob;
	}
	
	
	
	
	

}
