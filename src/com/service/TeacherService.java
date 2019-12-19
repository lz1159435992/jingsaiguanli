package com.service;

import java.sql.SQLException;

import com.dao.TeacherDao;
import com.domain.Teacher;

public class TeacherService {

	/**
	 * ����true��ʾ�ֶο���
	 * @param t_name
	 * @return
	 * @throws SQLException
	 */
	public boolean chachong(String t_name) throws SQLException {
		TeacherDao teacherDao = new TeacherDao();
		return teacherDao.chachong(t_name);
	}

	/**
	 * ��ʦע��service����
	 * @param teacher
	 * @throws SQLException 
	 */
	public void register(Teacher teacher) throws SQLException {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.register(teacher);
	}
	/**
	 * ���ݽ�ʦ���ֲ�������ʦ�ļ�¼
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
	 * ���ݽ�ʦ���������ѯ���½
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
