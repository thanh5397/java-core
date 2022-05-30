/**
 * Copyright(C) 2020 Luvina Software
 * MstJapanDao.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstJapanEntity;

/**
 * Mô tả: Interface thao tác với DB bảng mst_japan
 * @author Nguyễn Mạnh Quân
 */
public interface MstJapanDao {
	/**
	 * Mô tả: Lấy danh sách trình độ tiếng Nhật
	 * @return danh sách trình độ tiếng Nhật
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<MstJapanEntity> getAllMstJapan() throws SQLException, ClassNotFoundException, IOException;
	
	/**
	 * Mô tả: Lấy tên trình độ tiếng Nhật bằng code
	 * @param codeLevel : code
	 * @return tên trình độ tiếng nhật
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public String getNameLevelByCodeLevel(String codeLevel) throws SQLException, ClassNotFoundException, IOException;
}
