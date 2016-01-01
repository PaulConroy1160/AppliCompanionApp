package com.example.loginapp.model;

public class User {

	// instance variables

	private int id;
	private String userName;
	private String userName2;
	private String password;
	private String email;

	// default constraucter
	public User() {
		id = 0;
		userName = null;
		userName2 = null;
		password = null;
		email = null;

	}

	// constructer
	public User(int i, String u, String u2, String p, String e) {
		this.setId(i);
		this.setUserName(u);
		this.setUserName2(u2);
		this.setPassword(p);
		this.setEmail(e);
	}

	// getters and setters
	
	public int getId(){
		return id;
	}
	
	public void setId(int i){
		this.id = i;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName2() {
		return userName2;
	}

	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}

}
