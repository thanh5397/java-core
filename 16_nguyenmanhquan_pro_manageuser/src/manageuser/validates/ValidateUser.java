/**
 * Copyright(C) 2020 Luvina Software
 * ValidateUser.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.validates;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manageuser.entities.UserInforEntity;
import manageuser.logics.MstGroupLogic;
import manageuser.logics.MstJapanLogic;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.MstJapanLogicImpl;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.utils.MessageErrorProperties;

/**
 * Mô tả: Validate thông tin user nhập vào
 * 
 * @author Nguyễn Mạnh Quân
 */
public class ValidateUser {
	TblUserLogic tblUserLogic = new TblUserLogicImpl();

	/**
	 * Mô tả: Kiểm tra thông tin về tài khoản đăng nhập vào hệ thống
	 * 
	 * @param loginId  : tên đăng nhâp
	 * @param password : mật khẩu
	 * @return Danh sách lỗi
	 */
	public List<String> validateLogin(String loginName, String password)
			throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException {
		List<String> listError = new ArrayList<String>();
		try {
			if (Common.compareString(Constant.EMPTY_STRING, loginName)) {
				String loginNameER001 = MessageErrorProperties.getMessageError(Constant.ER001_LOGIN_NAME);
				listError.add(loginNameER001);
			}

			if (Common.compareString(Constant.EMPTY_STRING, password)) {
				String passwordER001 = MessageErrorProperties.getMessageError(Constant.ER001_PASSWORD);
				listError.add(passwordER001);
			}

			if (listError.size() == 0) {
				boolean isExist = tblUserLogic.existLogin(loginName, password);
				if (!isExist) {
					String ER016 = MessageErrorProperties.getMessageError(Constant.ER016);
					listError.add(ER016);
				}
			}
		} catch (Exception e) {
			System.out.println("ValidateUser: validateLogin: " + e.getMessage());
			throw e;
		}
		return listError;
	}

	/**
	 * Mô tả: Thực hiện validate thông tin user nhập từ màn hình ADM003
	 * 
	 * @param userInfor Đối tượng user cần check
	 * @return Danh sách lỗi
	 */
	public List<String> validateUserInfo(UserInforEntity userInfoEntity)
			throws IOException, ClassNotFoundException, SQLException {
		List<String> listError = new ArrayList<String>();
		try {
			int userId = userInfoEntity.getUserId();
			String loginName = userInfoEntity.getLoginName();
			int groupId = userInfoEntity.getGroupId();
			String fullName = userInfoEntity.getFullName();
			String fullNameKana = userInfoEntity.getFullNameKana();
			String email = userInfoEntity.getEmail();
			String tel = userInfoEntity.getTel();
			String password = userInfoEntity.getPassword();
			String codeLevel = userInfoEntity.getCodeLevel();
			List<Integer> arrBirthday = userInfoEntity.getArrBirthday();

			String checkGroupId = checkGroup(groupId);
			String checkFullName = checkFullName(fullName);
			String checkFullNameKana = checkFullNameKana(fullNameKana);
			String checkBirthday = checkBirthay(arrBirthday);
			String checkEmail = checkEmail(userId, email);
			String checkTel = checkTel(tel);
			
			if (userId == 0) {
				String checkLoginName = checkLoginName(loginName);
				if (!Common.compareString(Constant.EMPTY_STRING, checkLoginName)) {
					listError.add(checkLoginName);
				}
			}
			if (!Common.compareString(Constant.EMPTY_STRING, checkGroupId)) {
				listError.add(checkGroupId);
			}
			if (!Common.compareString(Constant.EMPTY_STRING, checkFullName)) {
				listError.add(checkFullName);
			}
			if (!Common.compareString(Constant.EMPTY_STRING, checkFullNameKana)) {
				listError.add(checkFullNameKana);
			}
			if (!Common.compareString(Constant.EMPTY_STRING, checkBirthday)) {
				listError.add(checkBirthday);
			}
			if (!Common.compareString(Constant.EMPTY_STRING, checkEmail)) {
				listError.add(checkEmail);
			}
			if (!Common.compareString(Constant.EMPTY_STRING, checkTel)) {
				listError.add(checkTel);
			}
			if (userId == 0) {
				String checkPassword = checkPassword(password);
				if (!Common.compareString(Constant.EMPTY_STRING, checkPassword)) {
					listError.add(checkPassword);
				} else {
					String rePassword = userInfoEntity.getRePassword();
					String checkRePassword = checkRePassword(password, rePassword);
					if (!Common.compareString(Constant.EMPTY_STRING, checkRePassword)) {
						listError.add(checkRePassword);
					}
				}
			}
			if (!Common.compareString(Constant.STRING_VALUE_ZERO, codeLevel)) {
				Date startDate = userInfoEntity.getStartDate();
				Date endDate = userInfoEntity.getEndDate();
				String strTotal = userInfoEntity.getStrTotal();
				List<Integer> arrStartDate = userInfoEntity.getArrStartDate();
				List<Integer> arrEndDate = userInfoEntity.getArrEndDate();

				String checkCodeLevel = checkCodeLevel(codeLevel);
				String checkStartDate = checkStartDate(arrStartDate);
				String checkEndDate = checkEndDate(arrEndDate, endDate, startDate);
				String checkTotal = checkTotal(strTotal);
				if (!Common.compareString(Constant.EMPTY_STRING, checkCodeLevel)) {
					listError.add(checkCodeLevel);
				}
				if (!Common.compareString(Constant.EMPTY_STRING, checkStartDate)) {
					listError.add(checkStartDate);
				}
				if (!Common.compareString(Constant.EMPTY_STRING, checkEndDate)) {
					listError.add(checkEndDate);
				}
				if (!Common.compareString(Constant.EMPTY_STRING, checkTotal)) {
					listError.add(checkTotal);
				}
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println("ValidateUser: validateUserInfo: " + e.getMessage());
			throw e;
		}
		return listError;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục loginName
	 * 
	 * @param loginName : Tên đăng nhập cần kiểm tra
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String checkLoginName(String loginName) throws IOException, ClassNotFoundException, SQLException {
		String error = "";

		try {
			if (Common.checkBlank(loginName)) {
				error = MessageErrorProperties.getMessageError(Constant.ER001_LOGIN_NAME);
			} else if (!Common.checkFormat(loginName, Constant.FOMART_LOGIN_NAME_REGEX)) {
				error = MessageErrorProperties.getMessageError(Constant.ER019);
			} else if (!Common.checkLength(loginName, Constant.LOGIN_NAME_MIN_LENGTH, Constant.LOGIN_NAME_MAX_LENGTH)) {
				error = MessageErrorProperties.getMessageError(Constant.ER007_LOGIN_NAME);
			} else if (tblUserLogic.checkExistLoginName(loginName)) {
				error = MessageErrorProperties.getMessageError(Constant.ER003_LOGIN_NAME);
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println("ValidateUser: checkLoginName: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục group
	 * 
	 * @param groupId : Mã group cần kiểm tra
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String checkGroup(int groupId) throws IOException, ClassNotFoundException, SQLException {
		String error = "";
		try {
			if (groupId == 0) {
				error = MessageErrorProperties.getMessageError(Constant.ER002_GROUP);
			} else {
				MstGroupLogic mstGroupLogic = new MstGroupLogicImpl();
				if (Common.compareString(Constant.EMPTY_STRING, mstGroupLogic.getGroupNameById(groupId))) {
					error = MessageErrorProperties.getMessageError(Constant.ER004_GROUP);
				}
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println("ValidateUser: checkGroup: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục fullName
	 * 
	 * @param fullName : Họ tên cần kiểm tra
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkFullName(String fullName) throws IOException {
		String error = "";
		try {
			if (Common.checkBlank(fullName)) {
				error = MessageErrorProperties.getMessageError(Constant.ER001_FULL_NAME);
			} else if (!Common.checkLength(fullName, Constant.NUMBER_ZERO, Constant.FULL_NAME_MAX_LENGTH)) {
				error = MessageErrorProperties.getMessageError(Constant.ER006_FULL_NAME);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkFullName: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục fullNameKana
	 * 
	 * @param fullNameKana : Tên kana
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkFullNameKana(String fullNameKana) throws IOException {
		String error = "";
		try {
			if (!Common.checkBlank(fullNameKana)) {
				if (!Common.checkFormat(fullNameKana, Constant.FOMART_KANA_REGEX_FULL_SIZE)
						&& !Common.checkFormat(fullNameKana, Constant.FOMART_KANA_REGEX_HALF_SIZE)) {
					error = MessageErrorProperties.getMessageError(Constant.ER009_FULL_NAME_KANA);
				} else if (!Common.checkLength(fullNameKana, Constant.NUMBER_ZERO, Constant.FULL_NAME_MAX_LENGTH)) {
					error = MessageErrorProperties.getMessageError(Constant.ER006_FULL_NAME_KANA);
				}
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkFullNameKana: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục birthday
	 * 
	 * @param arrBirthday : Danh sách chứa giá trị [ngày, tháng, năm]
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkBirthay(List<Integer> arrBirthday) throws IOException {
		String error = "";
		try {
			if (!Common.checkDate(arrBirthday)) {
				error = MessageErrorProperties.getMessageError(Constant.ER011_BIRTHDAY);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkBirthay: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục email
	 * 
	 * @param email : địa chỉ email cần kiểm tra
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String checkEmail(int userId, String email) throws IOException, ClassNotFoundException, SQLException {
		String error = "";
		try {
			if (Common.checkBlank(email)) {
				error = MessageErrorProperties.getMessageError(Constant.ER001_EMAIL);
			} else if (!Common.checkLength(email, Constant.NUMBER_ZERO, Constant.EMAIL_MAX_LENGTH)) {
				error = MessageErrorProperties.getMessageError(Constant.ER006_EMAIL);
			} else if (!Common.checkFormat(email, Constant.FOMART_EMAIL_REGEX)) {
				error = MessageErrorProperties.getMessageError(Constant.ER005_EMAIL);
			} else if (tblUserLogic.checkExistEmail(userId, email)) {
				error = MessageErrorProperties.getMessageError(Constant.ER003_EMAIL);
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println("ValidateUser: checkEmail: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục tel
	 * 
	 * @param tel : số điện thoại cần kiểm tra
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkTel(String tel) throws IOException {
		String error = "";
		try {
			if (Common.checkBlank(tel)) {
				error = MessageErrorProperties.getMessageError(Constant.ER001_TEL);
			} else if (!Common.checkLength(tel, Constant.NUMBER_ZERO, Constant.TEL_MAX_LENGTH)) {
				error = MessageErrorProperties.getMessageError(Constant.ER006_TEL);
			} else if (!Common.checkFormat(tel, Constant.FOMART_TEL_REGEX)) {
				error = MessageErrorProperties.getMessageError(Constant.ER005_TEL);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkTel: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục password
	 * 
	 * @param password : mật khẩu cần kiểm tra
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkPassword(String password) throws IOException {
		String error = "";
		try {
			if (Common.checkBlank(password)) {
				error = MessageErrorProperties.getMessageError(Constant.ER001_PASSWORD);
			} else if (!Common.checkOneByte(password)) {
				error = MessageErrorProperties.getMessageError(Constant.ER008_PASSWORD);
			} else if (!Common.checkLength(password, Constant.PASSWORD_MIN_LENGTH, Constant.PASSWORD_MAX_LENGTH)) {
				error = MessageErrorProperties.getMessageError(Constant.ER007_PASSWORD);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkPassword: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục mật khẩu xác nhận
	 * 
	 * @param rePassword : Mật khẩu nhập lại
	 * @param password   : Mật khẩu
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkRePassword(String rePassword, String password) throws IOException {
		String error = "";
		try {
			if (!Common.compareString(rePassword, password)) {
				error = MessageErrorProperties.getMessageError(Constant.ER017);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkRePassword: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục codeLevel
	 * 
	 * @param codeLevel : Mã trình độ tiếng Nhật
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public String checkCodeLevel(String codeLevel) throws IOException, ClassNotFoundException, SQLException {
		String error = "";
		try {
			MstJapanLogic mstJapanLogic = new MstJapanLogicImpl();
			if (Common.compareString(Constant.EMPTY_STRING, mstJapanLogic.getNameLevelByCodeLevel(codeLevel))) {
				error = MessageErrorProperties.getMessageError(Constant.ER004_CODE_LEVEL);
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println("ValidateUser: checkCodeLevel: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục startDate
	 * 
	 * @param arrStartDate : Danh sách chứa giá trị [ngày, tháng, năm] của ngày cấp
	 *                     chứng chỉ
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkStartDate(List<Integer> arrStartDate) throws IOException {
		String error = "";
		try {
			if (!Common.checkDate(arrStartDate)) {
				error = MessageErrorProperties.getMessageError(Constant.ER011_START_DATE);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkStartDate: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục endDate
	 * 
	 * @param arrEndDate : Danh sách chứa giá trị [ngày, tháng, năm] của ngày hết
	 *                   hạn
	 * @param endDate    : Đối tượng date của ngày hết hạn
	 * @param startDate  : Đối tượng date của ngày cấp chứng chỉ
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkEndDate(List<Integer> arrEndDate, Date endDate, Date startDate) throws IOException {
		String error = "";
		try {
			if (!Common.checkDate(arrEndDate)) {
				error = MessageErrorProperties.getMessageError(Constant.ER011_END_DATE);
			} else if (!Common.compareDate(endDate, startDate)) {
				error = MessageErrorProperties.getMessageError(Constant.ER012);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkEndDate: " + e.getMessage());
			throw e;
		}
		return error;
	}

	/**
	 * Mô tả: Kiểm tra hạng mục total
	 * 
	 * @param total : Điểm trình độ tiếng Nhật
	 * @return Câu thông báo lỗi phù hợp với mã lỗi
	 * @throws IOException
	 */
	public String checkTotal(String strTotal) throws IOException {
		String error = "";
		try {
			if (Common.checkBlank(strTotal)) {
				error = MessageErrorProperties.getMessageError(Constant.ER001_TOTAL);
			} else if (!Common.checkFormat(strTotal, Constant.FOMART_HALF_SIZE_DIGIT_REGEX)) {
				error = MessageErrorProperties.getMessageError(Constant.ER018_TOTAL);
			} else if (!Common.checkLength(strTotal, Constant.NUMBER_ZERO, Constant.TOTAL_MAX_LENGTH)) {
				error = MessageErrorProperties.getMessageError(Constant.ER006_TOTAL);
			}
		} catch (IOException e) {
			System.out.println("ValidateUser: checkTotal: " + e.getMessage());
			throw e;
		}
		return error;
	}
	
	public static void main(String[] args) {
		ValidateUser v = new ValidateUser();
		try {
			System.out.println(v.checkLoginName("ツツツツツツ"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
