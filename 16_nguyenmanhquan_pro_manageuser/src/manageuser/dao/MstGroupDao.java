/**
 * Copyright(C) 2020 Luvina Software
 * MstGroupDao.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstGroupEntity;

/**
 * Mô tả: Interface thao tác với DB bảng mst_group
 * @author Nguyễn Mạnh Quân
 */
public interface MstGroupDao {
	/**
	 * Mô tả: Lấy danh sách group
	 * @return danh sách group
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<MstGroupEntity> getAllMstGroup() throws ClassNotFoundException, SQLException, IOException;
	
	/**
	 * Mô tả: Lấy tên group bằng id
	 * @param groupId : id
	 * @return tên group
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public String getGroupNameById(int groupId) throws SQLException, ClassNotFoundException, IOException;
}
