/**
 * Copyright(C) 2020 Luvina Software
 * TblUserLogic.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.logics;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInforEntity;

/**
 * Mô tả: Interface xử lý logic liên quan đến thông tin của user
 * 
 * @author Nguyễn Mạnh Quân
 */
public interface TblUserLogic {
	/**
	 * Mô tả: Kiểm tra loginName đã tồn tại trong bảng tbl_user chưa?
	 * 
	 * @param loginName : tên đăng nhập cần kiểm tra
	 * @param password  : mật khẩu
	 * @return - True: loginName tồn tại - False: loginName không tồn tại
	 */
	public boolean existLogin(String loginName, String password)
			throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException;

	/**
	 * Mô tả: Lấy tổng số user
	 * 
	 * @param groupId  : mã group
	 * @param fullName : họ tên
	 * @return tổng số user
	 */
	public int getTotalUsers(int groupId, String fullName) throws ClassNotFoundException, SQLException, IOException;

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
	 * @param loginName : Tên đăng nhập cần kiểm tra
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
	 * Mô tả: Insert data user vào bảng tbl_user và tbl_detail_user_japan
	 * 
	 * @param userInforEntity : Đối tượng UserInforEntity
	 * @return true(insert thành công); false(insert không thành công)
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws NoSuchAlgorithmException
	 */
	public boolean createUser(UserInforEntity userInforEntity)
			throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException;

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
	 * Mô tả: Update user vào bảng tbl_user và tbl_detail_user_japan
	 * 
	 * @param userInforEntity : Đối tượng UserInforEntity
	 * @param isExistDetailUserJapan : Biến kiểm tra tồn tại user trong bảng tbl_detail_user_japan chưa
	 * @return true(update thành công); false(update không thành công)
	 */
	public boolean updateUserInfor(UserInforEntity userInforEntity, boolean isExistDetailUserJapan) throws ClassNotFoundException, SQLException, IOException;
	
	/**
	 * Mô tả: Delete user trong bảng tbl_user và tbl_detail_user_japan
	 * @param userId : user_id
	 * @return true(delete thành công); false(delete không thành công)
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean deleteUserInfor(int userId) throws ClassNotFoundException, SQLException, IOException;
	
	/**
	 * Mô tả: Lấy ra rule của user trong bảng tbl_user
	 * @param userId : user_id
	 * @return rule của user
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public TblUserEntity getRuleByUserId(int userId) throws SQLException, IOException, ClassNotFoundException;
}
