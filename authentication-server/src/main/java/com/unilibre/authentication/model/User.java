package com.unilibre.authentication.model;

public class User {
	private int id;
	
	private String username;
	
	private String firstname;
	
	private String token;
	

	public User(int id, String username, String firstname) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getToken() {
		return firstname;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
