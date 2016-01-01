package com.example.loginapp.model;

public class Job {

	// instance variables
	private int id;
	private String title;
	private String company;
	private String rPackage;
	private String summary;
	private String location;
	private String contractType;

	
	public Job(){
		id = 0;
		title = null;
		company = null;
		rPackage = null;
		summary = null;
		location = null;
		contractType = null;
	}

	

	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getrPackage() {
		return rPackage;
	}



	public void setrPackage(String rPackage) {
		this.rPackage = rPackage;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getContractType() {
		return contractType;
	}



	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

}
