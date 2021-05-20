package com.cg.aps.jwt;


import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private int userId;
	private String password;

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(int userId, String password) {
		this.setUserId(userId);
		this.setPassword(password);

	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

