/**
 * Copyright(C) 2020 Luvina Software
 * TblDetailUserJapanDao.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao;

import java.io.IOException;
import java.sql.SQLException;

import manageuser.entities.TblDetailUserJapanEntity;

/**
 * Mô tả:
 * @author Nguyễn Mạnh Quân
 */
public interface TblDetailUserJapanDao extends BaseDao {
	/**
	 * Mô tả: Thực hiện thêm mới trình độ tiếng Nhật của 1 user vào DB
	 * 
	 * @param tblDetailUserJapanEntity : Đối tượng TblDetailUserJapanEntity
	 */
	public void insertDetailUserJapan(TblDetailUserJapanEntity tblDetailUserJapanEntity) throws SQLException;
	
	/**
	 * Mô tả: Kiểm tra tồn tại trình độ tiếng Nhật của user theo id
	 * @param userId : user_id
	 * @return true(tồn tại); false(không tồn tại)
	 * @throws SQLException 
	 */
	public boolean checkExistDetailUserJapanById(int userId) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Thực hiện edit trình độ tiếng Nhật của 1 user
	 * 
	 * @param tblDetailUserJapanEntity : Đối tượng TblDetailUserJapanEntity
	 */
	public void updateDetailUserJapan(TblDetailUserJapanEntity tblDetailUserJapanEntity) throws SQLException;
	
	/**
	 * Mô tả: Thực hiện xóa trình độ tiếng Nhật của 1 user
	 * @param userId : user_id
	 */
	public void deleteDetailUserJapan(int userId) throws SQLException;
}
