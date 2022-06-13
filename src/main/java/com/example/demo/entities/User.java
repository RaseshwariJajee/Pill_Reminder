package com.example.demo.entities;

public class User {
	private int id;
	private String email;
	private String password;
	private String imageUrl;
	private String country;
	private String name ;
	private long contact;
	private String isDependent;
	private String relationship;
	private String blood_group;
	private String dob;
	private String newPassword;
	private int weight;
	private int height;
	public User( String name,String email,  long contact, String blood_group,String dob, int weight, int height) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.blood_group = blood_group;
		this.dob = dob;
		this.weight = weight;
		this.height = height;
	}
	public int getId() {
		return id;
	}
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
	public User( String email, String imageUrl, String country, String name, long contact, String blood_group,
			String dob, int weight, int height) {
		super();
		
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
	
	
	
	public User(String email,String password, String newPassword) {
		super();
		this.email = email;
		this.password = password;
		this.newPassword = newPassword;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	public User(int id, String name, String email, String imageUrl, String country, String isDependent,String relationship, long contact, String blood_group, String dob, int weight, int height) {
		this.id=id;
		this.email = email;
		this.imageUrl = imageUrl;
		this.country = country;
		this.name = name;
		this.isDependent=isDependent;
		this.relationship=relationship;
		this.contact = contact;
		this.blood_group = blood_group;
		this.dob = dob;
		this.weight = weight;
		this.height = height;	
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
