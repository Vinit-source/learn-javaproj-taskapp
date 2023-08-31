package com.fssa.learnJava.project.taskapp.model;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * @param email
	 * @param password
	 */
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param loggedInEmail
	 */
	public User(String loggedInEmail) {
		this.email = loggedInEmail;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
//	Using isLoggedIn to maintain LoggedInUser.
//	/**
//	 * @return the isLoggedIn
//	 */
//	public boolean isLoggedIn() {
//		return isLoggedIn;
//	}
//	/**
//	 * @param isLoggedIn the isLoggedIn to set
//	 */
//	public void setLoggedIn(boolean isLoggedIn) {
//		this.isLoggedIn = isLoggedIn;
//	}
	
	
}