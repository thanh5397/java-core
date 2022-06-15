package manageuser.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import manageuser.entities.MstGroupEntity;
import manageuser.entities.MstJapanEntity;



public class Common {
	public static String encryptPassword(String password, String salt)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String passwordEncrypted = "";
		try {
			String value = password + salt;
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(value.getBytes("utf8"));
			passwordEncrypted = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println("Common: encryptPassword: " + e.getMessage());
			throw e;
		}
		return passwordEncrypted;
	}

	public static boolean compareString(String firstString, String secondString) {
		boolean isEqual = false;
		if (firstString.equals(secondString)) {
			isEqual = true;
		}
		return isEqual;
	}

	public static boolean checkLogin(HttpSession session) throws ClassNotFoundException, SQLException, IOException {
//		boolean isLogin = false;
//		if (session != null) {
//			String loginName =  (String) session.getAttribute(Constant.PARAM_LOGIN_NAME);
//			if (!Common.checkBlank(loginName)) {
//				TblUserDao tblUserDao = new TblUserDaoImpl();
//				if (tblUserDao.checkAdminByLoginName(loginName) == 0) {
//					isLogin = true;
//				}
//			}
//		}
//		return isLogin;
		return true;
	}

	public static String replaceWildcard(String strInput) {
		StringBuilder strReplaced = new StringBuilder();
		String strOutput = Constant.EMPTY_STRING;
		if (!(Constant.EMPTY_STRING.equals(strInput))) {
			for (int i = 0; i < strInput.length(); i++) {
				char charAtI = strInput.charAt(i);
				switch (charAtI) {
				case '%':
					strReplaced.append("\\%");
					break;
				case '_':
					strReplaced.append("\\_");
					break;
				case '\\':
					strReplaced.append("\\\\");
					break;
				default:
					strReplaced.append(charAtI);
					break;
				}
			}
			strOutput = strReplaced.toString();
		}
		return strOutput;
	}

	public static int convertStringToInt(String strInput, int outputInt) {
		int output;
		try {
			output = Integer.parseInt(strInput);
		} catch (NumberFormatException e) {
			output = outputInt;
		}
		return output;
	}

	public static List<Integer> getListPaging(int totalUser, int limit, int currentPage)
			throws NumberFormatException, IOException {
		List<Integer> listPaging = null;
//		try {
//			int totalPage = getTotalPage(totalUser, limit);
//			int limitPage = Integer.parseInt(ConfigProperties.getConfigProperties(Constant.LIMIT_PAGE));
//			int startPage = (int) Math.ceil((double) currentPage / limitPage) * limitPage - (limitPage - 1);
//			listPaging = new ArrayList<Integer>();
//			for (int i = startPage; i <= startPage + 2 && i <= totalPage; i++) {
//				listPaging.add(i);
//			}
//		} catch (NumberFormatException | IOException e) {
//			System.out.println("Common: getListPaging: " + e.getMessage());
//			throw e;
//		}
		return listPaging;
	}

	public static int getOffset(int currentPage, int limit) {
		int offer;
		offer = (currentPage - 1) * limit;
		return offer;
	}

	public static int getLimit() throws NumberFormatException, IOException {
		int limit;
//		try {
//			limit = Integer.parseInt(ConfigProperties.getConfigProperties(Constant.LIMIT));
//		} catch (NumberFormatException | IOException e) {
//			System.out.println("Common: getLimit: " + e.getMessage());
//			throw e;
//		}
		return 0;
	}

	public static int getTotalPage(int totalUser, int limit) {
		int totalPage = (int) Math.ceil((double) totalUser / limit);
		return totalPage;
	}

	public static List<String> getListColumnName(Connection connection, String table) throws SQLException {
		List<String> listColumnName = new ArrayList<String>();
		try {
			Connection conn = connection;
			String sql = "SHOW columns FROM " + table + ";";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listColumnName.add(rs.getString("Field"));
			}
		} catch (SQLException e) {
			System.out.println("Common: getListColumnName: " + e.getMessage());
			throw e;
		}
		return listColumnName;
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	public static List<Integer> getListYear(int fromYear, int toYear) {
		List<Integer> listYears = new ArrayList<Integer>();
		for (int i = toYear; i >= fromYear; i--) {
			listYears.add(i);
		}
		return listYears;
	}

	public static List<Integer> getListMonth() {
		List<Integer> listMonths = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			listMonths.add(i);
		}
		return listMonths;
	}

	public static List<Integer> getListDay() {
		List<Integer> listDays = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			listDays.add(i);
		}
		return listDays;
	}

	public static List<Integer> convertDateToArray(Date date) {
		List<Integer> listElementOfDate = new ArrayList<Integer>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd" + Constant.SYMBOL_SPLIT_DATE + "MM" + Constant.SYMBOL_SPLIT_DATE + "yyyy");
		String strDate = simpleDateFormat.format(date);
		StringTokenizer stringTokenizer = new StringTokenizer(strDate, Constant.SYMBOL_SPLIT_DATE);
		if (stringTokenizer.countTokens() == 3) {
			while (stringTokenizer.hasMoreElements()) {
				listElementOfDate.add(Integer.parseInt(stringTokenizer.nextToken()));
			}
		}
		return listElementOfDate;
	}

	public static Date convertArrayToDate(List<Integer> arrDate) throws ParseException {
		Date date = null;
		StringBuilder strDate = new StringBuilder();
		strDate.append(arrDate.get(0) + Constant.SYMBOL_SPLIT_DATE);
		strDate.append(arrDate.get(1) + Constant.SYMBOL_SPLIT_DATE);
		strDate.append(arrDate.get(2) + Constant.SYMBOL_SPLIT_DATE);
		try {
			date = new SimpleDateFormat("dd" + Constant.SYMBOL_SPLIT_DATE + "MM" + Constant.SYMBOL_SPLIT_DATE + "yyyy")
					.parse(strDate.toString());
		} catch (ParseException e) {
			System.out.println("Common: convertStringToDate: " + e.getMessage());
			throw e;
		}
		return date;
	}

	public static boolean checkBlank(String strInput) {
		boolean isBlank = true;
		if (strInput != null) {
			if (!Common.compareString(Constant.EMPTY_STRING, strInput.trim())) {
				isBlank = false;
			}
		}
		return isBlank;
	}

	public static boolean checkFormat(String strInput, String regex) {
		boolean isTrue = Pattern.matches(regex, strInput);
		return isTrue;
	}

	public static boolean checkLength(String strInput, int min, int max) {
		boolean isTrue = false;
		int length = strInput.length();
		if (length >= min && length <= max) {
			isTrue = true;
		}
		return isTrue;
	}

	public static boolean checkOneByte(String strInput) {
		boolean isTrue = false;
		if (strInput.getBytes().length == strInput.length()) {
			isTrue = true;
		}
		return isTrue;

	}

	public static boolean checkDate(List<Integer> arrDate) {
		boolean isTrue = false;
		int day = arrDate.get(0);
		int month = arrDate.get(1);
		int year = arrDate.get(2);
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day <= 31) {
				isTrue = true;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day <= 30) {
				isTrue = true;
			}
			break;

		case 2:
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				if(day <= 29) {
					isTrue = true;
				}
			} else {
				if(day <= 28) {
					isTrue = true;
				}
			}
			break;
		}
		
		return isTrue;
	}

	public static boolean compareDate(Date date1, Date date2) {
		boolean isAfter = date1.after(date2);
		return isAfter;
	}
	
	public static String createSalt() {
		return String.valueOf(new Date().getTime());
	}
	
	public static void setDataLogic(HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException {
//		MstGroupLogic mstGroupLogic = new MstGroupLogicImpl();
//		MstJapanLogic mstJapanLogic = new MstJapanLogicImpl();
//		List<MstGroupEntity> listMstGroupEntities = null;
//		List<MstJapanEntity> listMstJapanEntities = null;
//		List<Integer> listYears = null;
//		List<Integer> listYearsEndDate = null;
//		List<Integer> listMonths = null;
//		List<Integer> listDays = null;
//		Date currentDate = null;
//		int yearNow = Constant.NUMBER_ZERO;
//
//		try {
//			listMstGroupEntities = mstGroupLogic.getAllMstGroup();
//			listMstJapanEntities = mstJapanLogic.getAllMstJapan();
//
//			currentDate = Common.getCurrentDate();
//			List<Integer> dateArray = Common.convertDateToArray(currentDate);
//			yearNow = dateArray.get(2);
//			listYears = Common.getListYear(Constant.START_YEAR_PULL_DOWN, yearNow);
//			listYearsEndDate = Common.getListYear(Constant.START_YEAR_PULL_DOWN, yearNow + 1);
//			listMonths = Common.getListMonth();
//			listDays = Common.getListDay();
//
//			request.setAttribute(Constant.PARAM_LIST_GROUP, listMstGroupEntities);
//			request.setAttribute(Constant.PARAM_LIST_JAPAN, listMstJapanEntities);
//			request.setAttribute(Constant.PARAM_LIST_YEAR, listYears);
//			request.setAttribute(Constant.PARAM_LIST_YEAR_END_DATE, listYearsEndDate);
//			request.setAttribute(Constant.PARAM_LIST_MONTH, listMonths);
//			request.setAttribute(Constant.PARAM_LIST_DAY, listDays);
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//			System.out.println("Common: setDataLogic: " + e.getMessage());
//			throw e;
//		}
	}

	public static String convertIntToString(int intInput,String defaultStr) {
		String output;
		try {
			output = String.valueOf(intInput);
		} catch (NullPointerException e) {
			output = defaultStr;
		}
		return output;
	}
}
