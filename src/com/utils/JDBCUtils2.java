package com.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils2 {
	
	//����һ�����ӳ�,��������ӳ�ֻ��Ҫ����һ��
	private static final ComboPooledDataSource datasource = new ComboPooledDataSource();
	
	/**
	 * ������ӵķ���
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {

		return datasource.getConnection();	
	}
	
	/**
	 * ������ӳ�
	 */
	public static DataSource getDataSource() {
		return datasource;
	}
	/**
	 * �ͷ���Դ ����Ҫ����Ϊ������DBUtils��jar�����ڲ�ʵ������Դ���ͷ�
	 */
	
}
