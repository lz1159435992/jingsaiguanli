package com.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils2 {
	
	//创建一个连接池,但这个连接池只需要创建一次
	private static final ComboPooledDataSource datasource = new ComboPooledDataSource();
	
	/**
	 * 获得连接的方法
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {

		return datasource.getConnection();	
	}
	
	/**
	 * 获得连接池
	 */
	public static DataSource getDataSource() {
		return datasource;
	}
	/**
	 * 释放资源 不需要，因为引入了DBUtils的jar包，内部实现了资源的释放
	 */
	
}
