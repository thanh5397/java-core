/**
 * Copyright(C) 2020 Luvina Software
 * BaseDaoImpl.java, 15/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import manageuser.dao.BaseDao;
import manageuser.utils.Constant;
import manageuser.utils.DatabaseProperties;

/**
 * Mô tả: Implement BaseDao để thao tác đóng/mở kết nối với DB
 * 
 * @author Nguyễn Mạnh Quân
 */
public class BaseDaoImpl implements BaseDao {
	Connection connection =null;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void openConnection() throws SQLException, IOException, ClassNotFoundException {
		String url = DatabaseProperties.getDatabaseProperties(Constant.URL_DB);
		String userName = DatabaseProperties.getDatabaseProperties(Constant.USER_NAME_DB);
		String password = DatabaseProperties.getDatabaseProperties(Constant.PASSWORD_DB);
		try {
			Class.forName(DatabaseProperties.getDatabaseProperties(Constant.DRIVER_DB));
			this.connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("BaseDaoImpl: getConnection: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Connection getConnection() {
		return connection;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
