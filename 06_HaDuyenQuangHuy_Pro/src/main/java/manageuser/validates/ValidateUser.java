package manageuser.validates;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageuser.dao.impl.MstGroupDaoImpl;
import manageuser.dao.impl.MstJapanDaoImpl;
import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.entities.UserInfoEntity;
import manageuser.logics.TblUserLogic;
import manageuser.repository.TblUserRepository;
import manageuser.utils.Common;
import manageuser.utils.MessageErrorProperties;

@Service
public class ValidateUser {

	@Autowired
	TblUserLogic userLogic;

	@Autowired
	TblUserDaoImpl userDao;

	@Autowired
	TblUserRepository userRepo;

	@Autowired
	ValidateUser vU;

	@Autowired
	MstGroupDaoImpl groupDao;

	@Autowired
	MstJapanDaoImpl japanDao;

	public List<String> validateLogin(String loginId, String password) throws Exception {

		/**
		 * Kiểm tra loginName và password được nhập từ màn hình đăng nhập
		 * 
		 * @param loginID  Tên đăng nhập nhập vào từ màn hình
		 * @param password Mật khẩu nhập vào từ màn hình
		 * @return: List danh sách các lỗi
		 */
		List<String> listError = new ArrayList<String>();
		if ("".equals(loginId) && ("".equals(password))) {
			listError.add(MessageErrorProperties.getValueByKey("ER001_LoginName"));
			listError.add(MessageErrorProperties.getValueByKey("ER001_Password"));
		} else if ("".equals(loginId)) {
			listError.add(MessageErrorProperties.getValueByKey("ER001_LoginName"));
		} else if ("".equals(password)) {
			listError.add(MessageErrorProperties.getValueByKey("ER001_Password"));
		}

		else if (!userLogic.checkExistLogin(loginId, password)) {
			listError.add(MessageErrorProperties.getValueByKey("ER003"));
		}
		return listError;

	}

	/**
	 * Kiểm tra validate các hạng mục tại màn hình ADM003
	 * 
	 * @param listError Danh sách lỗi của các hạng mục trên màn hình
	 * @return: listError
	 */
	public List<String> validateUser(UserInfoEntity userInfo) {
//		@Autowired
//		ValidateUser vU = new ValidateUser();

		List<String> listError = new ArrayList<String>();
		int iD;
		try {
			iD = userInfo.getUserId();
			if (iD == 0) {
				listError.add(vU.validateLoginName(userInfo.getLoginName()));
				listError.add(validatePassword(userInfo.getPassword()));
				listError.add(validatePasswordConfirm(userInfo.getPassword(), userInfo.getPasswordConfirm()));
				listError.add(vU.validateEmail(userInfo.getEmail()));
			} else {
				listError.add(vU.validateEmail(userInfo.getEmail(), userInfo.getUserId()));
			}
			listError.add(validateGroupName(userInfo.getGroupName()));
			listError.add(validateFullName(userInfo.getFullName()));
			listError.add(validateFullNameKana(userInfo.getFullNameKana()));
			listError.add(validateBirthday(userInfo.getBirthday()));
			listError.add(validateTel(userInfo.getTel()));
			listError.add(validateNameLevel(userInfo.getNameLevel()));
			if (!"".equals(userInfo.getNameLevel())) {
				listError.add(validateEndDate(userInfo.getEndDate(), userInfo.getStartDate()));
				listError.add(validateStartDate(userInfo.getStartDate()));
				listError.add(validateTotal(userInfo.getTotal()));
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ValidateUser: validateUser() " + e.getMessage());
		}
		return listError;
	}

	/**
	 * Validate hạng mục loginName trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	public String validateLoginName(String loginName) throws SQLException, ClassNotFoundException {
		String error = "";
		if (Common.checkEmpty(loginName)) {
			error = MessageErrorProperties.getValueByKey("ER001_LOGINNAME");
		} else if (!Common.checkRegrex(loginName, "^[a-zA-Z][a-zA-Z0-9_-]+$")) {
			error = MessageErrorProperties.getValueByKey("ER0019_LOGINNAME");
		} else if (loginName.length() < 4 || loginName.length() > 15) {
			error = MessageErrorProperties.getValueByKey("ER007_LOGINNAME");
		} else if (userDao.checkExistedUserByLoginName(loginName)) {
			error = MessageErrorProperties.getValueByKey("ER003_LOGINNAME");
		}
		return error;
	}

	/**
	 * Validate hạng mục Email trên màn hình ADM003 trong trường hợp Add
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private String validateEmail(String email) throws SQLException, ClassNotFoundException {
		String error = "";
		if (Common.checkEmpty(email)) {
			error = MessageErrorProperties.getValueByKey("ER001_MAIL");
		} else if (email.length() > 100) {
			error = MessageErrorProperties.getValueByKey("ER006_MAIL");
		} else if (!Common.checkRegrex(email, "^.{1,}@[a-zA-Z0-9]{1,}.[a-zA-Z0-9]{1,}$")) {
			error = MessageErrorProperties.getValueByKey("ER005_MAIL");
		} else if (userDao.checkExistedUserByEmail(email)) {
			System.out.println(userDao.checkExistedUserByLoginName(email));
			error = MessageErrorProperties.getValueByKey("ER003_MAIL");
		}
		return error;
	}

	/**
	 * Validate hạng mục Email trên màn hình ADM003 trong trường hợp Edit
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private String validateEmail(String email, int iD) throws SQLException, ClassNotFoundException {
		String error = "";
		if (Common.checkEmpty(email)) {
			error = MessageErrorProperties.getValueByKey("ER001_MAIL");
		} else if (email.length() > 100) {
			error = MessageErrorProperties.getValueByKey("ER006_MAIL");
		} else if (!Common.checkRegrex(email, "^.{1,}@[a-zA-Z0-9]{1,}.[a-zA-Z0-9]{1,}$")) {
			error = MessageErrorProperties.getValueByKey("ER005_MAIL");
		} else if (userDao.checkExistedUserByEmail(email, iD)) {
			error = MessageErrorProperties.getValueByKey("ER003_MAIL");
		}
		return error;
	}

	/**
	 * Validate hạng mục FullName trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private static String validateFullName(String fullName) {
		String error = "";
		if (Common.checkEmpty(fullName)) {
			error = MessageErrorProperties.getValueByKey("ER001_FULLNAME");
		} else if (fullName.length() > 255) {
			error = MessageErrorProperties.getValueByKey("ER006_FULLNAME");
		}

		return error;
	}

	/**
	 * Validate hạng mục FullNameKana trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private static String validateFullNameKana(String fullNameKana) {
		String error = "";
		if (!isKatakana(fullNameKana)) {
			error = MessageErrorProperties.getValueByKey("ER009_FULLNAMEKANA");
		} else if (fullNameKana.length() > 255) {
			error = MessageErrorProperties.getValueByKey("ER006_FULLNAMEKANA");
		}

		return error;
	}

	/**
	 * Validate hạng mục Password trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	public static String validatePassword(String password) {
		String error = "";
		if (Common.checkEmpty(password)) {
			error = MessageErrorProperties.getValueByKey("ER001_PASSWORD");
		} else if (!isOneByteCharacter(password)) {
			error = MessageErrorProperties.getValueByKey("ER008_PASSWORD");
		} else if (password.length() < 4 || password.length() > 15) {
			error = MessageErrorProperties.getValueByKey("ER007_PASSWORD");
		}
		return error;
	}

	/**
	 * Validate hạng mục PasswordConfirm trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	public static String validatePasswordConfirm(String password, String passwordConfirm) {
		String error = "";
		if (!Common.compareString(passwordConfirm, password)) {
			error = MessageErrorProperties.getValueByKey("ER017_PASSWORD_CONFIRM");
		}
		return error;
	}

	/**
	 * Validate hạng mục GroupName trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private String validateGroupName(String groupName) throws SQLException, ClassNotFoundException {
		String error = "";
		if (Common.checkEmpty(groupName)) {
			error = MessageErrorProperties.getValueByKey("ER002_GROUPNAME");
		} else if (!groupDao.checkExistMstGroup(groupName)) {
			error = MessageErrorProperties.getValueByKey("ER004_GROUPNAME");
		}

		return error;
	}

	/**
	 * Validate hạng mục NameLevel trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private String validateNameLevel(String codeLevel) throws SQLException, ClassNotFoundException {
		String error = "";
		if (Common.checkEmpty(codeLevel)) {
			return error;
		} else if (!japanDao.checkExistMstJapan(codeLevel)) {
			error = MessageErrorProperties.getValueByKey("ER004_CODELEVEL");
		}

		return error;
	}

	/**
	 * Validate hạng mục Birthday trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private static String validateBirthday(Date birthday) {
		String error = "";
		if (!Common.checkFormatDate(birthday)) {
			error = MessageErrorProperties.getValueByKey("ER011_BIRTHDAY");
		}
		return error;
	}

	/**
	 * Validate hạng mục Tel trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private static String validateTel(String tel) {
		String error = "";
		if (Common.checkEmpty(tel)) {
			error = MessageErrorProperties.getValueByKey("ER001_TEL");
		} else if (tel.length() > 15) {
			error = MessageErrorProperties.getValueByKey("ER006_TEL");
		} else if (!Common.checkRegrex(tel, "^[0-9]{1,}-[0-9]{1,}-[0-9]{1,}$")) {
			error = MessageErrorProperties.getValueByKey("ER005_TEL");
		}

		return error;
	}

	/**
	 * Validate hạng mục startDate trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private static String validateStartDate(Date startDate) {
		String error = "";
		if (!Common.checkFormatDate(startDate)) {
			error = MessageErrorProperties.getValueByKey("ER011_STARTDATE");
		}
		return error;
	}

	/**
	 * Validate hạng mục endDate trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private static String validateEndDate(Date endDate, Date startDate) {
		String error = "";
		if (!Common.checkFormatDate(endDate)) {
			error = MessageErrorProperties.getValueByKey("ER011_ENDDATE");
			return error;
		}
		if (endDate.compareTo(startDate) <= 0) {
			error = MessageErrorProperties.getValueByKey("ER012_ENDDATE");
		}
		return error;
	}

	/**
	 * Validate hạng mục total trên màn hình ADM003
	 * 
	 * @param error Lỗi tương ứng với hạng mục validate hiện tại
	 * @return error
	 */
	private static String validateTotal(String total) {
		String error = "";
		if (Common.checkEmpty(total)) {
			error = MessageErrorProperties.getValueByKey("ER001_TOTAL");
		} else if (!isHalfsize(total)) {
			error = MessageErrorProperties.getValueByKey("ER018_TOTAL");
		} else if (total.length() > 10) {
			error = MessageErrorProperties.getValueByKey("ER006_TOTAL");
		}
		return error;
	}

	/**
	 * Kiểm tra một String có phải là số Halfsize phục vụ cho validate hạng mục
	 * Total
	 * 
	 * @return true/false nếu chứa halfsize/không chứa halfsize
	 */
	public static boolean isHalfsize(String text) {
		return Pattern.matches("[0-9]+", text);
	}

	/**
	 * Kiểm tra có một String có phải là katakana phục vụ cho validate FullName kana
	 * 
	 * @return true/false nếu String chứa tất cả kí tự là/không là Katakana
	 */
	public static boolean isKatakana(String text) {
		char[] c = text.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if ((Character.UnicodeBlock.of(c[i]) != Character.UnicodeBlock.KATAKANA) && (!isDigit(c[i]))
					&& (!Character.isWhitespace(c[i]))) {

				return false;
			}
		}
		return true;
	}

	/**
	 * Kiểm tra có một ký tự có phải là số không
	 * 
	 * @return true/false nếu ký tự là số/ không là số
	 */
	public static boolean isDigit(char c) {
		int x = (int) c;

		if ((x >= 48) && (x <= 57)) {
			return true;
		}

		return false;
	}

	/**
	 * Kiểm tra có một ký tự có phải là ký tự 1 byte hay không
	 * 
	 * @return true/false nếu ký tự là/không là 1 byte
	 */
	public static boolean isOneByteCharacter(String str) {
		return Pattern.matches("[\\^x00-\\x7F]+", str);
	}

}
