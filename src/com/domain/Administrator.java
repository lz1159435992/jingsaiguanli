package com.domain;

public class Administrator {
	private int a_id;
	private String a_username;
	private String a_password;
	
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(int a_id, String a_username, String a_password) {
		super();
		this.a_id = a_id;
		this.a_username = a_username;
		this.a_password = a_password;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_username() {
		return a_username;
	}

	public void setA_username(String a_username) {
		this.a_username = a_username;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	
}
