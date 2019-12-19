package com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.domain.Teacher;
import com.utils.JDBCUtils2;

public class TeacherDao {

	/**
	 * 查看用户名是否存在
	 * @param t_name
	 * @return 返回true表示字段可用
	 * @throws SQLException 
	 */
	public boolean chachong(String t_name) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Teacher existUser = queryRunner.query("select * from teacher where t_name = ?" , new BeanHandler<Teacher>(Teacher.class), t_name);
		if(existUser == null) {
			return true;
		}else {
			return false;
		}
				
	}

	public void register(Teacher teacher) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		queryRunner.update("insert into teacher values (null,?,?,?,?,?)", teacher.getT_name(),teacher.getT_password(),0,teacher.getT_email(),teacher.getT_xueyuan());
	}

	public Teacher getTeacherByName(String t_name) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Teacher existTeacher = queryRunner.query("select * from teacher where t_name = ?" , new BeanHandler<Teacher>(Teacher.class), t_name);
		return existTeacher;
	}

	public Teacher login(Teacher teacher1) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Teacher existTeacher = queryRunner.query("select * from teacher where t_name = ? and t_password=?" , new BeanHandler<Teacher>(Teacher.class), teacher1.getT_name(),teacher1.getT_password());
		return existTeacher;
	}

}
