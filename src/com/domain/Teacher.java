package com.domain;

/**
 * teacherÄ£ÐÍ
 * @author Administrator
 *
 */
public class Teacher {
	private int t_id;
	private String t_name;
	private String t_password;
	private String t_xueyuan;
	private String t_email;
	private int t_state;
	
	
	public String getT_xueyuan() {
		return t_xueyuan;
	}
	public void setT_xueyuan(String t_xueyuan) {
		this.t_xueyuan = t_xueyuan;
	}
	public String getT_email() {
		return t_email;
	}
	public void setT_email(String t_email) {
		this.t_email = t_email;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_password() {
		return t_password;
	}
	public void setT_password(String t_password) {
		this.t_password = t_password;
	}
	public int getT_state() {
		return t_state;
	}
	public void setT_state(int t_state) {
		this.t_state = t_state;
	}
}
