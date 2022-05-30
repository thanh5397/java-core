/**
 * Copyright(C) 2020 Luvina Software
 * Constant.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.utils;

/**
 * Mô tả: Chứa các Constant của dự án
 * @author Nguyễn Mạnh Quân
 */
public class Constant {
	//=============== Vùng Database Properties ===============
	public static final String PROPERTIES_DATABASE_PATH = "/Database.properties";
	
	public static final String DRIVER_DB = "driver";
	public static final String URL_DB = "url";
	public static final String USER_NAME_DB = "userName";
	public static final String PASSWORD_DB = "password";
	
	//=============== Vùng Message Error Properties ===============
	public static final String PROPERTIES_MESSAGE_ERROR_PATH = "/MessageError.properties";
	
	public static final String ER001_LOGIN_NAME = "ER001_LOGIN_NAME";
	public static final String ER001_PASSWORD = "ER001_PASSWORD";
	public static final String ER001_FULL_NAME = "ER001_FULL_NAME";
	public static final String ER001_EMAIL = "ER001_EMAIL";
	public static final String ER001_TEL = "ER001_TEL";
	public static final String ER001_TOTAL = "ER001_TOTAL";
	public static final String ER002_GROUP = "ER002_GROUP";
	public static final String ER003_LOGIN_NAME = "ER003_LOGIN_NAME";
	public static final String ER003_EMAIL = "ER003_EMAIL";
	public static final String ER004_GROUP = "ER004_GROUP";
	public static final String ER004_CODE_LEVEL = "ER004_CODE_LEVEL";
	public static final String ER005_EMAIL = "ER005_EMAIL";
	public static final String ER005_TEL = "ER005_TEL";
	public static final String ER006_FULL_NAME = "ER006_FULL_NAME";
	public static final String ER006_FULL_NAME_KANA = "ER006_FULL_NAME_KANA";
	public static final String ER006_EMAIL = "ER006_EMAIL";
	public static final String ER006_TEL = "ER006_TEL";
	public static final String ER006_TOTAL = "ER006_TOTAL";
	public static final String ER007_LOGIN_NAME = "ER007_LOGIN_NAME";
	public static final String ER007_PASSWORD = "ER007_PASSWORD";
	public static final String ER008_PASSWORD = "ER008_PASSWORD";
	public static final String ER009_FULL_NAME_KANA = "ER009_FULL_NAME_KANA";
	public static final String ER011_BIRTHDAY = "ER011_BIRTHDAY";
	public static final String ER011_START_DATE = "ER011_START_DATE";
	public static final String ER011_END_DATE = "ER011_END_DATE";
	public static final String ER012 = "ER012";
	public static final String ER013 = "ER013";
	public static final String ER014 = "ER014";
	public static final String ER015 = "ER015";
	public static final String ER016 = "ER016";
	public static final String ER017 = "ER017";
	public static final String ER018_TOTAL = "ER018_TOTAL";
	public static final String ER019 = "ER019";
	public static final String ER020 = "ER020";
	
	public static final String FOMART_LOGIN_NAME_REGEX = "^[a-zA-Z]+[a-zA-Z0-9_]*$";
	public static final String FOMART_EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	public static final String FOMART_TEL_REGEX = "^[0-9]{1,4}-[0-9]{1,4}-[0-9]{1,4}$";
	public static final String FOMART_KANA_REGEX_HALF_SIZE = "^[ｧ-ﾝﾞﾟ]+$";
	public static final String FOMART_KANA_REGEX_FULL_SIZE = "^([ァ-ン]|ー)+$";
	public static final String FOMART_HALF_SIZE_DIGIT_REGEX = "^[0-9]+$";
	
	public static final int LOGIN_NAME_MIN_LENGTH = 4;
	public static final int LOGIN_NAME_MAX_LENGTH = 15;
	public static final int FULL_NAME_MAX_LENGTH = 255;
	public static final int EMAIL_MAX_LENGTH = 100;
	public static final int TEL_MAX_LENGTH = 14;
	public static final int PASSWORD_MIN_LENGTH = 5;
	public static final int PASSWORD_MAX_LENGTH = 15;
	public static final int TOTAL_MAX_LENGTH = 9;
	
	//=============== Vùng Message Properties ===============
	public static final String PROPERTIES_MESSAGE_PATH = "/Message.properties";
	
	public static final String MSG001 = "MSG001";
	public static final String MSG002 = "MSG002";
	public static final String MSG003 = "MSG003";
	public static final String MSG004 = "MSG004";
	public static final String MSG005 = "MSG005";
	
	//=============== Vùng Config Properties ===============
	public static final String PROPERTIES_CONFIG_PATH = "/Config.properties";
	
	public static final String LIMIT = "limit";
	public static final String LIMIT_PAGE = "limitPage";
	public static final String MAX_INACTIVE_INTERVAL = "maxInactiveInterval";

	//=============== Vùng Link/Action ===============
	public static final String LIST_USER_DO = "/ListUser.do";
	public static final String LOGIN_DO = "/Login.do";
	public static final String LOGOUT_DO = "/Logout.do";
	public static final String ADD_USER_CONFIRM_DO = "/AddUserConfirm.do";
	public static final String EDIT_USER_CONFIRM_DO = "/EditUserConfirm.do";
	public static final String VIEW_USER_DETAIL_DO = "/ViewDetailUser.do";
	public static final String SUCCESS_DO = "/Success.do";
	public static final String SYSTEM_ERROR_DO = "/SystemError.do";
	public static final String ADM001 = "view/jsp/ADM001.jsp";
	public static final String ADM002 = "view/jsp/ADM002.jsp";
	public static final String ADM003 = "view/jsp/ADM003.jsp";
	public static final String ADM004 = "view/jsp/ADM004.jsp";
	public static final String ADM005 = "view/jsp/ADM005.jsp";
	public static final String ADM006 = "view/jsp/ADM006.jsp";
	public static final String SYSTEM_ERROR = "view/jsp/System_Error.jsp";
	
	public static final String QUERY_STRING_TYPE = "?type=";
	public static final String QUERY_STRING_KEY_USER = "?keyUser=";
	
	public static final String TYPE_DEFAULT = "DEFAULT";
	public static final String TYPE_SEARCH = "SEARCH";
	public static final String TYPE_SORT = "SORT";
	public static final String TYPE_PAGING = "PAGING";
	public static final String TYPE_BACK = "BACK";
	public static final String TYPE_VALIDATE = "VALIDATE";
	public static final String TYPE_INSERT_SUCCESS = "INSERT_SUCCESS";
	public static final String TYPE_UPDATE_SUCCESS = "UPDATE_SUCCESS";
	public static final String TYPE_DELETE_SUCCESS = "DELETE_SUCCESS";
	//==============================
	public static final String PARAM_USER_ID = "userId";
	public static final String PARAM_LOGIN_NAME = "loginName";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_RE_PASSWORD = "rePassword";
	public static final String PARAM_EMAIL = "email";
	public static final String PARAM_TEL = "tel";
	public static final String PARAM_TOTAL = "total";
	public static final String PARAM_STRING_TOTAL = "strTotal";
	public static final String PARAM_CODE_LEVEL = "codeLevel";
	public static final String PARAM_LIST_ERROR = "listError";
	public static final String PARAM_ERROR = "error";
	public static final String PARAM_MESSAGE = "message";
	public static final String PARAM_FULL_NAME = "fullName";
	public static final String PARAM_GROUP_ID = "groupId";
	public static final String PARAM_TYPE = "type";
	public static final String PARAM_SORT_TYPE = "sortType";
	public static final String PARAM_SORT_BY_FULL_NAME = "sortByFullName";
	public static final String PARAM_SORT_BY_CODE_LEVEL = "sortByCodeLevel";
	public static final String PARAM_SORT_BY_END_DATE = "sortByEndDate";
	public static final String PARAM_CURRENT_PAGE = "currentPage";
	public static final String PARAM_TOTAL_PAGE = "totalPage";
	public static final String PARAM_LIST_PAGING = "listPaging";
	public static final String PARAM_LIST_USER_INFO = "listUserInfor";
	public static final String PARAM_LIST_GROUP = "listGroup";
	public static final String PARAM_LIST_JAPAN = "listJapan";
	public static final String PARAM_LIST_YEAR = "listYear";
	public static final String PARAM_LIST_YEAR_END_DATE = "listYearEndDate";
	public static final String PARAM_LIST_MONTH = "listMonth";
	public static final String PARAM_LIST_DAY = "listDay";
	public static final String PARAM_USER_INFO_ENTITY = "userInforEntity";
	public static final String PARAM_ARR_BIRTH_DAY = "arrBirthday";
	public static final String PARAM_ARR_START_DATE = "arrStartDate";
	public static final String PARAM_ARR_END_DATE = "arrEndDate";
	public static final String PARAM_FULL_NAME_KANA = "fullNameKana";
	public static final String PARAM_DAY_BIRTH_DAY = "dayBirthday";
	public static final String PARAM_MONTH_BIRTH_DAY = "monthBirthday";
	public static final String PARAM_YEAR_BIRTH_DAY = "yearBirthday";
	public static final String PARAM_DAY_START_DATE = "dayStartDate";
	public static final String PARAM_MONTH_START_DATE = "monthStartDate";
	public static final String PARAM_YEAR_START_DATE = "yearStartDate";
	public static final String PARAM_DAY_END_DATE = "dayEndDate";
	public static final String PARAM_MONTH_END_DATE = "monthEndDate";
	public static final String PARAM_YEAR_END_DATE = "yearEndDate";
	public static final String PARAM_KEY_USER = "keyUser";
	public static final String PARAM_KEY_MOVE = "keyMove";
	
	public static final String KEY_MOVE_FROM_ADM003 = "ADM003";
	
	public static final int RULE_ADMIN = 0;
	public static final int RULE_USER = 1;
	
	public static final int NUMBER_ZERO = 0;
	public static final String EMPTY_STRING = "";
	public static final String STRING_VALUE_ZERO = "0";
	
	public static final int GROUP_ID_ERROR = -1;
	public static final int USER_ID_ERROR = -1;
	
	public static final String SORT_TYPE_FULL_NAME = "full_name";
	public static final String SORT_TYPE_CODE_LEVEL = "code_level";
	public static final String SORT_TYPE_END_DATE = "end_date";
	public static final String SORT_ASC = "ASC";
	public static final String SORT_DESC = "DESC";
	
	public static final int OFFSET_DEFAULT = 0;
	public static final int GROUP_ID_DEFAUL = 0;
	public static final int CURRENT_PAGE_DEFAULT = 1;

	public static final String SYMBOL_SPLIT_DATE = "/";
	public static final int START_YEAR_PULL_DOWN = 1900;
	
	public static final String CHARSET_ENCODING_UTF8 = "UTF-8";
}
