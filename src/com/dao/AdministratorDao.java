package com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.domain.Administrator;
import com.utils.JDBCUtils2;

public class AdministratorDao {
	public Administrator login(Administrator administrator) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Administrator existAdministrator = queryRunner.query("select * from administrator where a_username = ? and a_password=?" , new BeanHandler<Administrator>(Administrator.class), administrator.getA_username(),administrator.getA_password());
		return existAdministrator;
	}
}
