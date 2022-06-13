/**
 * Copyright(C) 2020 Luvina Software
 * LoginController.java, 15/07/2020 HaDuyenQuangHuy
 */
package manageuser.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import manageuser.dao.impl.MstGroupDaoImpl;
import manageuser.dao.impl.MstJapanDaoImpl;
import manageuser.entities.MstGroupEntity;
import manageuser.entities.MstJapanEntity;

/**
 * Class Common
 *
 * @author HaDuyenQuangHuy
 */
@Service
public class Common {

	@Autowired
	MstGroupDaoImpl mstGroup;

	@Autowired
	MstJapanDaoImpl mstJapan;


	/**
	 * Kiểm tra empty hay không
	 * 
	 * @param str chuỗi truyền vào
	 * @return true nếu empty, false nếu không empty
	 */
	public static boolean checkEmpty(String str) {
		if ("".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * So sánh 2 String
	 * 
	 * @param value:         giá trị String ban đầu
	 * @param compareString: giá trị String cần so sánh
	 * @return true/false nếu 2 String bằng nhau/ không bằng nhau
	 */
	public static boolean compareString(String value, String valueCompare) {
		if (value.equals(valueCompare)) {
			return true;
		}
		return false;
	}

	/**
	 * Mã hóa mật khẩu
	 * 
	 * @param password: mật khẩu trước mã hóa
	 * @param salt:     chuỗi thêm vào để mã hóa với mật khẩu
	 * @return chuỗi sau khi được mã hóa
	 */
	public static String encryptPassword(String password, String salt) {
		byte[] sha1 = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.update((password + salt).getBytes("UTF-8"));
			sha1 = crypt.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return convertByteToString(sha1).replace("-", "");
	}

	/**
	 * Chuyển 1 mảng các byte thành một chuỗi String
	 * 
	 * @param result Chuỗi một String sau khi chuyển đổi
	 * @return result
	 */
	private static String convertByteToString(byte[] value) {
		String result = "";
		for (int i = 0; i < value.length; i++) {
			result += value[i];
		}
		return result;
	}

	/**
	 * Kiểm tra hiện tại đang có session trên hệ thống không
	 * 
	 * @param session giá trị session hiện tại trên hệ thống
	 * @return true/false: có hoặc không tồn tại iD với rule là Admin trên session
	 */
	public static Boolean checkLogin(HttpSession session) throws ClassNotFoundException, SQLException {
		boolean checkLogin = false;
		String loginName = null;
		// Kiểm tra loginName còn tồn tại trên session hay không
		loginName = (String) session.getAttribute(Constant.SESSION_LOGIN);
		if (loginName != null) {
			checkLogin = true;
		}
		return checkLogin;
	}

	/**
	 * Chuyển 1 String thành Integer
	 * 
	 * @param string Giá trị String nhập vào
	 * @return value parse trong trường hợp không bị lỗi, chả về default data trong
	 *         trường hợp bị lỗi
	 */
	public static int convertStringToInteger(String string) {
		int value = 0;
		try {
			value = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			value = Constant.DEFAULT_VALUE;
		}
		return value;
	}

	/**
	 * Chuyển 1 String thành Integer
	 * 
	 * @param String string: Giá trị String nhập vào
	 * @param String defaultValue: Giá trị mặc đinh trả về nếu việc parseInt bị lỗi
	 * @return value parse trong trường hợp không bị lỗi, chả về default data trong
	 *         trường hợp bị lỗi
	 */
	public static int convertStringToInteger(String string, int defaultValue) {
		int value = 0;
		try {
			value = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			value = defaultValue;
			return value;
		}
		return value;
	}

	/**
	 * Lấy ra số trang ứng với số bản ghi
	 * 
	 * @param totalRecord tổng số bản ghi
	 * @param limit       giá trị record hiển thị trên 1 trang
	 * 
	 * @return Số trang ứng với số bản ghi
	 */
	public static int getTotalPage(int totalRecord, int limit) {
		return ((int) Math.ceil((double) totalRecord / limit));
	}

	/**
	 * Lấy ra số trang ứng với số bản ghi
	 * 
	 * @param limitPage số trang hiển thị tối đa ở paging
	 * @param limit     giá trị record hiển thị trên 1 trang
	 * @param totalPage Tổng số trang hiện tại
	 * @param trang     hiện tại đang hiển thị
	 * @param startPage số thứ tự của trang đầu tiên
	 * @param endPage   số thứ tự của trang cuối cùng
	 * 
	 * @return List các trang từ trang đầu tiên đến trang cuối cùng
	 */
	public static List<Integer> getListPaging(int totalRecord, int limit, int currentPage) {
		List<Integer> listPaging = new ArrayList<Integer>();
		int limitPage = convertStringToInteger(ConfigProperties.getValueByKey("LIMIT_PAGE"));
		int totalPage = Common.getTotalPage(totalRecord, limit);
		if (currentPage < 0) {
			currentPage = Constant.DEFAULT_PAGE;
		}
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		int startPage = (currentPage - 1) / limitPage * limitPage + 1;
		int endPage = startPage + limitPage - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}
		for (int i = startPage; i <= endPage; i++) {
			// System.out.println(i);
			listPaging.add(i);
		}
		return listPaging;
	}

	/**
	 * Lấy ra vị trí bản ghi trong record ứng với trang hiện tại
	 * 
	 * @param currentPage vị trí trang hiện tại
	 * @param limit       giá trị record hiển thị trên 1 trang
	 * 
	 * @return vị trí bản ghi trong record ứng với trang hiện tại
	 */
	public static int getOffSet(int currentPage, int limit) {
		return (currentPage - 1) * limit;
	}

	/**
	 * Lấy tất cả year từ năm bắt đầu đến năm kết thúc
	 * 
	 * @param startYear năm bắt đầu
	 * @param endYear   năm kết thúc
	 * 
	 * @return listYear chứa các năm được lấy
	 */
	public static List<Integer> getListYear(int startYear, int endYear) {
		List<Integer> listYear = new ArrayList<Integer>();
		for (int i = endYear; i >= startYear; i--) {
			listYear.add(i);
		}
		return listYear;
	}

	/**
	 * replace các ký tự đặc biệt trong tìm kiếm like (sql)
	 * 
	 * @param String str: chuỗi cần được replace
	 * 
	 * @return Chuỗi sau khi đã được replace wildCard
	 **/
	public static String replaceWildCard(String str) {
		return str.replace("%", "#%").replace("!", "#!").replace("_", "#_");
	}

	/**
	 * Lấy tất cả tháng trong năm từ 1 -> 12
	 * 
	 * @return listMonth chứa các năm được lấy
	 */
	public static List<Integer> getListMonth() {
		List<Integer> listMonth = new ArrayList<Integer>();
		for (int i = 1; i <= Constant.MONTH_OF_YEAR; i++) {
			listMonth.add(i);
		}
		return listMonth;
	}

	/**
	 * Lấy tất cả ngày trong năm từ 1 -> 31
	 * 
	 * @return listDay chứa các năm được lấy
	 */
	public static List<Integer> getListDay() {
		List<Integer> listDay = new ArrayList<Integer>();
		for (int i = 1; i <= Constant.DAY_OF_MONTH; i++) {
			listDay.add(i);
		}
		return listDay;
	}

	/**
	 * Lấy tất cả ngày hiện tại
	 * 
	 * @param none
	 * 
	 * @return java.util.Calendar.getInstance().getTime() - giá trị ngày hiện tại
	 */
	public static Date getCurrentDate() {
		return java.util.Calendar.getInstance().getTime();

	}

	/**
	 * Lấy giá trị độ dài của một listString
	 * 
	 * @param total   Độ dài tổng của listString
	 * @param sublist Phần tử con của listString
	 * 
	 * @return total
	 */
	public static int getLengthOfListString(List<String> listStr) {
		int total = 0;
		for (String sublist : listStr) {
			total += sublist.length();
		}
		return total;
	}

	/**
	 * 
	 * Kiểm tra một giá trị là ngày có hợp lệ
	 * 
	 * @param Date dateVale: giá trị của ngày cần kiểm tra
	 *
	 * @true/false: giá trị ngày hợp lệ/ không hợp lệ
	 */
	public static boolean checkFormatDate(Date dateValue) {
		int date = dateValue.getDate();
		int month = dateValue.getMonth() + 1;
		int year = dateValue.getYear() + 1900;
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			if (date > 30) {
				return false;
			}
			break;
		case 2:
			if ((year % 4 == 0) && (year % 100 != 0)) {
				if (date > 29) {
					return false;
				}
			} else {
				if (date > 28) {
					return false;
				}
			}
			break;

		default:
			if (date > 31) {
				return false;
			}
		}
		return true;

	}


	/**
	 * Kiểm tra xem một str có hợp lệ với một chuỗi regrex
	 * 
	 * @param String str: Chuỗi String nhập vào
	 * @param String regrex: Chuỗi regex để kiểm tra
	 * 
	 * @return true/false nếu chuỗi str có hợp vệ với regrex
	 */
	public static boolean checkRegrex(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(str).matches();
	}

	/**
	 * CreateSalt dựa vào mốc thời gian hiện tại
	 * 
	 * @return String
	 * 
	 */
	public static String creatSalt() {
		Calendar now = Calendar.getInstance();
		String year = now.get(Calendar.YEAR) % 100 + "";
		String month = padStart((now.get(Calendar.MONTH) + 1 + ""), '0');
		String day = padStart(now.get(Calendar.DAY_OF_MONTH) + "", '0');
		String hour = padStart(now.get(Calendar.HOUR_OF_DAY) + "", '0');
		String minute = padStart(now.get(Calendar.MINUTE) + "", '0');
		String second = padStart(now.get(Calendar.SECOND) + "", '0');
		String milisSecond = now.get(Calendar.MILLISECOND) / 10 + "";
		return year + month + day + hour + minute + second + milisSecond;
	}

	/**
	 * Thêm vào trước chuỗi string 1 ký tự nếu string đó có độ dài <2
	 * 
	 * @param char   symbol : ký tự được thêm vào
	 * @param String value: chuỗi để thêm vào ký tự
	 * 
	 * @return String value: chuỗi sau khi được thêm vào ký tự
	 */
	public static String padStart(String value, char symbol) {
		int length = value.length();
		if ((length > 2) || (length < 1)) {
			return value;
		}
		value = symbol + value;
		value = value.substring(length - 1, length + 1);
		return value;
	};

	/**
	 * format một đối tượng Date thành một chuỗi String tương ứng với định dạng
	 * yyyy-MM-dd
	 *
	 * @param Date date: đối tượng Date cần format
	 * 
	 * @return Chuỗi String chứa giá trị của Date sau khi format
	 */
	public static String convertDateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	/**
	 * Chuyển một chuỗi String thành Date
	 *
	 * @param String str: đối tượng String cần parse
	 * 
	 * @return date: Đối tượng Date sau khi được convert
	 */
	public static Date convertStringtoDate(String str) {
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			return null;
		}
		return date;

	}

	/**
	 * Set giá trị cho các combobox tại màn hình ADM003
	 * 
	 * @param HttpServletRequest req: req từ phía client
	 * 
	 * @return none
	 */
	public void setDataLogicADM003(ModelMap modelMap) {
		List<MstGroupEntity> listGroup = mstGroup.getAllMstGroup();
		List<MstJapanEntity> listJapan = mstJapan.getAllMstJapan();
		List<Integer> listDay = Common.getListDay();
		List<Integer> listMonth = Common.getListMonth();
		List<Integer> listYear = Common.getListYear(Constant.DEFAULT_START_YEAR,
				Calendar.getInstance().get(Calendar.YEAR));
		List<Integer> listYearEndDate = Common.getListYear(Constant.DEFAULT_START_YEAR,
				Calendar.getInstance().get(Calendar.YEAR) + 1);
		modelMap.addAttribute("mstGroup", listGroup);
		modelMap.addAttribute("mstJapan", listJapan);
		modelMap.addAttribute("listDay", listDay);
		modelMap.addAttribute("listMonth", listMonth);
		modelMap.addAttribute("listYear", listYear);
		modelMap.addAttribute("listYearEndDate", listYearEndDate);

	}

	/**
	 * Lấy thuộc tính Birthday của đối tượng userInfo tại màn hình ADM003
	 * 
	 * @param HttpServletRequest req: req từ phía client
	 * 
	 * @return Date birthday: thuộc tính Birthday của đối tượng useInfo tại màn hình
	 *         ADM003
	 */
	public static Date getBirthdayFromRequest(HttpServletRequest req) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Common.convertStringToInteger(req.getParameter("yearBirth")));
		cal.set(Calendar.MONDAY, Common.convertStringToInteger(req.getParameter("monthBirth")) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Common.convertStringToInteger(req.getParameter("dayBirth")));
		return cal.getTime();
	}

	/**
	 * Lấy thuộc tính endDate của đối tượng userInfo tại màn hình ADM003
	 * 
	 * @param HttpServletRequest req: req từ phía client
	 * 
	 * @return Date endDate: thuộc tính Birthday của đối tượng useInfo tại màn hình
	 *         ADM003
	 */
	public static Date getEndDateFromRequest(HttpServletRequest req) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Common.convertStringToInteger(req.getParameter("yearEnd")));
		cal.set(Calendar.MONDAY, Common.convertStringToInteger(req.getParameter("monthEnd")) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Common.convertStringToInteger(req.getParameter("dayEnd")));
		return cal.getTime();
	}

	/**
	 * Lấy thuộc tính startDate của đối tượng userInfo tại màn hình ADM003
	 * 
	 * @param HttpServletRequest req: req từ phía client
	 * 
	 * @return Date startDate: thuộc tính Birthday của đối tượng useInfo tại màn
	 *         hình ADM003
	 */
	public static Date getStartDateFromRequest(HttpServletRequest req) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Common.convertStringToInteger(req.getParameter("yearStart")));
		cal.set(Calendar.MONDAY, Common.convertStringToInteger(req.getParameter("monthStart")) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Common.convertStringToInteger(req.getParameter("dayStart")));
		return cal.getTime();
	}

}