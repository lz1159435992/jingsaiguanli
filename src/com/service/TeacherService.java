package com.service;

import java.sql.SQLException;

import com.dao.TeacherDao;
import com.domain.Teacher;

public class TeacherService {

	/**
	 * 返回true表示字段可用
	 * @param t_name
	 * @return
	 * @throws SQLException
	 */
	public boolean chachong(String t_name) throws SQLException {
		TeacherDao teacherDao = new TeacherDao();
		return teacherDao.chachong(t_name);
	}

	/**
	 * 教师注册service方法
	 * @param teacher
	 * @throws SQLException 
	 */
	public void register(Teacher teacher) throws SQLException {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.register(teacher);
	}
	/**
	 * 根据教师名字查出这个教师的记录
	 * @param t_name
	 * @return
	 * @throws SQLException 
	 */
	public Teacher getTeacherByName(String t_name) throws SQLException {
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.getTeacherByName(t_name);
		return teacher;
	}
	/**
	 * 根据教师名和密码查询后登陆
	 * @param teacher1
	 * @return
	 * @throws SQLException 
	 */
	public Teacher login(Teacher teacher1) throws SQLException {
		TeacherDao teacherDao = new TeacherDao();
		Teacher existTeacher = teacherDao.login(teacher1);
		return existTeacher;
	}
	
}
