/**
 * Copyright(C) 2020 Luvina Software
 * MstGroupLogic.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.logics;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstGroupEntity;

/**
 * Mô tả: Interface xử lý logic liên quan đến thông tin của group
 * @author Nguyễn Mạnh Quân
 */
public interface MstGroupLogic {
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
