/**
 * Copyright(C) 2020 Luvina Software
 * BaseDao.java, 15/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Mô tả: Interface thao tác đóng/mở kết nối với DB 
 * @author Nguyễn Mạnh Quân
 */
public interface BaseDao {
	/**
	 * Mô tả: Hàm mở kết nối tới cơ sở dữ liệu
	 */
	public void openConnection() throws SQLException, IOException, ClassNotFoundException;
	
	/**
	 * Mô tả: Hàm đóng kết nối
	 */
	public void closeConnection() throws SQLException;
	
	/**
	 * Mô tả: Lấy connection
	 * @return Connection
	 */
	public Connection getConnection();
	
	/**
	 * Mô tả: Gán giá trị cho connection
	 * @param connection : kết nối
	 */
	public void setConnection(Connection connection);
}
