package com.infosys.beans;


//Auth created as an object to store login only data for users submitting
//this information from the client side. Account object is only used
//on successful login
public class Auth {
	private String username;
	private String password;
	public Auth() {
		
	}
	public Auth(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
