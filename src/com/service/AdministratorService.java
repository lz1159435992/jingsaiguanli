package com.service;

import java.sql.SQLException;

import com.dao.AdministratorDao;
import com.domain.Administrator;

public class AdministratorService {
	/**
	 * 根据管理员名和密码查询后登陆
	 * @param administrator
	 * @return
	 * @throws SQLException 
	 */
	public Administrator login(Administrator administrator) throws SQLException {
		AdministratorDao administratorDao = new AdministratorDao();
		Administrator existAdministrator = administratorDao.login(administrator);
		return existAdministrator;
	}
}
