package com.domain;

import java.sql.Timestamp;

/**
 * 学生比赛详细信息模型
 * @author Administrator
 *
 */
public class Com_info {

	private int c_id;
	private String c_xuehao;
	private String c_stu_name;
	private String c_banji;
	private String c_bisai;
	private String c_tea_name;
	private String c_dengji;
	private String c_leibie;
	private String c_img;
	private Timestamp c_date;
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_xuehao() {
		return c_xuehao;
	}
	public void setC_xuehao(String c_xuehao) {
		this.c_xuehao = c_xuehao;
	}
	public String getC_stu_name() {
		return c_stu_name;
	}
	public void setC_stu_name(String c_stu_name) {
		this.c_stu_name = c_stu_name;
	}
	public String getC_banji() {
		return c_banji;
	}
	public void setC_banji(String c_banji) {
		this.c_banji = c_banji;
	}
	public String getC_bisai() {
		return c_bisai;
	}
	public void setC_bisai(String c_bisai) {
		this.c_bisai = c_bisai;
	}
	public String getC_tea_name() {
		return c_tea_name;
	}
	public void setC_tea_name(String c_tea_name) {
		this.c_tea_name = c_tea_name;
	}
	public String getC_dengji() {
		return c_dengji;
	}
	public void setC_dengji(String c_dengji) {
		this.c_dengji = c_dengji;
	}
	public String getC_leibie() {
		return c_leibie;
	}
	public void setC_leibie(String c_leibie) {
		this.c_leibie = c_leibie;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
}
