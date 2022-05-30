/**
 * Copyright(C) 2020 Luvina Software
 * TblUserDao.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInforEntity;

/**
 * Mô tả: tnterface Thao tác với DB bảng tbl_user
 * 
 * @author Nguyễn Mạnh Quân
 */
public interface TblUserDao extends BaseDao {
	/**
	 * Mô tả: Kiểm tra loginName đã tồn tại trong bảng tbl_user chưa?
	 * 
	 * @param loginName: Tên đăng nhập cần tìm
	 * @return TblUserEntity Trả về password, salt của user
	 */
	public TblUserEntity getUserByLoginName(String loginName) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Kiểm tra loginName có phải là admin không?
	 * 
	 * @param loginName : Tên đăng nhập
	 * @return -1(không tồn tại), 0(là admin), 1(không là admin)
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public int checkAdminByLoginName(String loginName) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Lấy tổng số user
	 * 
	 * @param groupId  : mã group
	 * @param fullName : họ tên
	 * @return tổng số user
	 */
	public int getTotalUsers(int groupId, String fullName) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Lấy danh sách user
	 * 
	 * @param offset          : vị trí data cần lấy nào
	 * @param limit           : số lượng lấy
	 * @param groupId         : mã nhóm tìm kiếm
	 * @param fullName        : tên tìm kiếm
	 * @param sortType        : nhận biết xem cột nào được ưu tiên sắp xếp(full_name
	 *                        or end_date or code_level)
	 * @param sortByFullName  : giá trị sắp xếp của cột Tên(ASC or DESC)
	 * @param sortByCodeLevel : giá trị sắp xếp của cột Trình độ tiếng nhật(ASC or
	 *                        DESC)
	 * @param sortByEndDate   : giá trị sắp xếp của cột Ngày kết hạn(ASC or DESC)
	 * @return danh sách user
	 */
	public List<UserInforEntity> getListUsers(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate)
			throws SQLException, ClassNotFoundException, IOException;

	/**
	 * Mô tả: Kiểm tra loginName đã tồn tại trong bảng tbl_user chưa?
	 * 
	 * @param loginName: Tên đăng nhập cần kiểm tra
	 * @return true(tên đăng nhập đã tồn tại)
	 */
	public boolean checkExistLoginName(String loginName) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Kiểm tra email đã tồn tại trong bảng tbl_user chưa?
	 * 
	 * @param userId : user_id
	 * @param email  : email cần kiểm tra
	 * @return true(email đã tồn tại)
	 */
	public boolean checkExistEmail(int userId, String email) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Thực hiện thêm mới 1 user vào bảng tbl_user
	 * 
	 * @param tblUserEntity : Đối tượng chứa thông tin của user
	 * @return userId đối tượng vừa thêm mới
	 * @throws SQLException
	 */
	public int insertUser(TblUserEntity tblUserEntity) throws SQLException;

	/**
	 * Mô tả: Lấy thông tin chi tiết của User bằng mã User
	 * 
	 * @param userId : mã User
	 * @return Đối tượng UserInforEntity
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public UserInforEntity getUserDetailById(int userId) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Kiểm tra user_id có tồn tại trong bảng tbl_user chưa?
	 * 
	 * @param userId : userId
	 * @return true(tồn tại user_id)
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public boolean checkExistUserId(int userId) throws SQLException, IOException, ClassNotFoundException;

	/**
	 * Mô tả: Thực hiện edit user
	 * 
	 * @param tblUserEntity : Đối tượng chứa thông tin của user
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void updateUser(TblUserEntity tblUserEntity) throws SQLException;

	/**
	 * Mô tả: Thực hiện xóa user trong bảng tbl_user
	 * 
	 * @param userId : user_id
	 * @throws SQLException
	 */
	public void deleteUser(int userId) throws SQLException;

	/**
	 * Mô tả: Lấy ra rule của user trong bảng tbl_user
	 * 
	 * @param userId : user_id
	 * @return rule của user
	 * @throws SQLException
	 */
	public TblUserEntity getRuleByUserId(int userId) throws SQLException, IOException, ClassNotFoundException;
}
