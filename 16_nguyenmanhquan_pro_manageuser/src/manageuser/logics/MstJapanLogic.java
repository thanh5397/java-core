/**
 * Copyright(C) 2020 Luvina Software
 * MstJapanLogic.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.logics;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstJapanEntity;

/**
 * Mô tả: Interface xử lý logic liên quan đến thông tin của trình độ tiếng Nhật
 * @author Nguyễn Mạnh Quân
 */
public interface MstJapanLogic {
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
