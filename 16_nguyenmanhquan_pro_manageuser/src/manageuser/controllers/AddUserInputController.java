/**
 * Copyright(C) 2020 Luvina Software
 * AddUserInputController.java, 14/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.UserInforEntity;
import manageuser.logics.MstGroupLogic;
import manageuser.logics.MstJapanLogic;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.MstJapanLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.validates.ValidateUser;

/**
 * Mô tả: Controller xử lý các logic của màn hình ADM003
 * 
 * @author Nguyễn Mạnh Quân
 */
public class AddUserInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor mặc định
	 */
	public AddUserInputController() {
	}

	/**
	 * Mô tả: Xử lý khi click vào button Add của ADM002
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			UserInforEntity userInforEntity = null;
			userInforEntity = getDefaultValue(request);
			Common.setDataLogic(request);
			request.setAttribute(Constant.PARAM_USER_INFO_ENTITY, userInforEntity);
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM003);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("AddUserInputController: doGet: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}

	/**
	 * Mô tả: Xử lý khi click vào button Xác nhận của ADM003
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			HttpSession session = request.getSession();
			ValidateUser validateUser = new ValidateUser();
			UserInforEntity userInforEntity = null;
			List<String> listError = new ArrayList<String>();
			userInforEntity = getDefaultValue(request);
			listError = validateUser.validateUserInfo(userInforEntity);
			if (listError.size() == 0) {
				session.setAttribute(Constant.PARAM_USER_INFO_ENTITY, userInforEntity);
				String keyUser = Common.createSalt();
				session.setAttribute(keyUser, userInforEntity);
				session.setAttribute(Constant.PARAM_KEY_MOVE, Constant.KEY_MOVE_FROM_ADM003);
				response.sendRedirect(contextPath + Constant.ADD_USER_CONFIRM_DO + Constant.QUERY_STRING_KEY_USER + keyUser);
			} else {
				Common.setDataLogic(request);
				request.setAttribute(Constant.PARAM_LIST_ERROR, listError);
				request.setAttribute(Constant.PARAM_USER_INFO_ENTITY, userInforEntity);
				RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM003);
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("AddUserInputController: doPost: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}

	/**
	 * Mô tả: Get giá trị default cho màn hình ADM003
	 * 
	 * @return đối tượng chứa thông tin của màn hình ADM003
	 */
	private UserInforEntity getDefaultValue(HttpServletRequest request)
			throws ParseException, ClassNotFoundException, SQLException, IOException {
		UserInforEntity userInforEntity = null;
		try {
			Date now = Common.getCurrentDate();
			String loginName = Constant.EMPTY_STRING;
			int groupId = Constant.NUMBER_ZERO;
			String groupName = Constant.EMPTY_STRING;
			String fullName = Constant.EMPTY_STRING;
			String fullNameKana = Constant.EMPTY_STRING;
			Date birthday = now;
			String email = Constant.EMPTY_STRING;
			String tel = Constant.EMPTY_STRING;
			String password = Constant.EMPTY_STRING;
			String rePassword = Constant.EMPTY_STRING;
			String codeLevel = Constant.EMPTY_STRING;
			String nameLevel = Constant.EMPTY_STRING;
			String strTotal = Constant.EMPTY_STRING;
			Date startDate = now;
			Date endDate = now;
			List<Integer> arrBirthday = null;
			List<Integer> arrStartDate = null;
			List<Integer> arrEndDate = null;
			arrBirthday = Common.convertDateToArray(birthday);
			arrStartDate = Common.convertDateToArray(startDate);
			arrEndDate = Common.convertDateToArray(endDate);
			arrEndDate.set(2, arrEndDate.get(2) + 1);
			int total = Constant.NUMBER_ZERO;

			String type = request.getParameter(Constant.PARAM_TYPE);
			if (type == null) {
				type = Constant.EMPTY_STRING;
			}
			switch (type) {
			case Constant.TYPE_VALIDATE:
				MstGroupLogic mstGroupLogic = new MstGroupLogicImpl();
				MstJapanLogic mstJapanLogic = new MstJapanLogicImpl();
				loginName = request.getParameter(Constant.PARAM_LOGIN_NAME);
				groupId = Integer.parseInt(request.getParameter(Constant.PARAM_GROUP_ID));
				groupName = mstGroupLogic.getGroupNameById(groupId);
				fullName = request.getParameter(Constant.PARAM_FULL_NAME);
				fullNameKana = request.getParameter(Constant.PARAM_FULL_NAME_KANA);
				arrBirthday.clear();
				arrBirthday.add(Integer.parseInt(request.getParameter(Constant.PARAM_DAY_BIRTH_DAY)));
				arrBirthday.add(Integer.parseInt(request.getParameter(Constant.PARAM_MONTH_BIRTH_DAY)));
				arrBirthday.add(Integer.parseInt(request.getParameter(Constant.PARAM_YEAR_BIRTH_DAY)));
				birthday = Common.convertArrayToDate(arrBirthday);
				email = request.getParameter(Constant.PARAM_EMAIL);
				tel = request.getParameter(Constant.PARAM_TEL);
				password = request.getParameter(Constant.PARAM_PASSWORD);
				rePassword = request.getParameter(Constant.PARAM_RE_PASSWORD);
				codeLevel = request.getParameter(Constant.PARAM_CODE_LEVEL);
				if (!Common.compareString(Constant.STRING_VALUE_ZERO, codeLevel)) {
					nameLevel = mstJapanLogic.getNameLevelByCodeLevel(codeLevel);
					arrStartDate.clear();
					arrStartDate.add(Integer.parseInt(request.getParameter(Constant.PARAM_DAY_START_DATE)));
					arrStartDate.add(Integer.parseInt(request.getParameter(Constant.PARAM_MONTH_START_DATE)));
					arrStartDate.add(Integer.parseInt(request.getParameter(Constant.PARAM_YEAR_START_DATE)));
					startDate = Common.convertArrayToDate(arrStartDate);
					arrEndDate.clear();
					arrEndDate.add(Integer.parseInt(request.getParameter(Constant.PARAM_DAY_END_DATE)));
					arrEndDate.add(Integer.parseInt(request.getParameter(Constant.PARAM_MONTH_END_DATE)));
					arrEndDate.add(Integer.parseInt(request.getParameter(Constant.PARAM_YEAR_END_DATE)));
					endDate = Common.convertArrayToDate(arrEndDate);
					total = Common.convertStringToInt(request.getParameter(Constant.PARAM_STRING_TOTAL),
							Constant.NUMBER_ZERO);
					strTotal = request.getParameter(Constant.PARAM_STRING_TOTAL);
				}
				break;
			case Constant.TYPE_BACK:
				HttpSession session = request.getSession();
				String keyUser = request.getParameter(Constant.PARAM_KEY_USER);
				userInforEntity = (UserInforEntity) session.getAttribute(keyUser);
				session.removeAttribute(keyUser);
				break;
			}

			if (!Common.compareString(Constant.TYPE_BACK, type)) {
				userInforEntity = new UserInforEntity();
				userInforEntity.setLoginName(loginName);
				userInforEntity.setGroupId(groupId);
				userInforEntity.setGroupName(groupName);
				userInforEntity.setFullName(fullName);
				userInforEntity.setFullNameKana(fullNameKana);
				userInforEntity.setBirthday(birthday);
				userInforEntity.setArrBirthday(arrBirthday);
				userInforEntity.setEmail(email);
				userInforEntity.setTel(tel);
				userInforEntity.setPassword(password);
				userInforEntity.setRePassword(rePassword);
				userInforEntity.setCodeLevel(codeLevel);
				userInforEntity.setNameLevel(nameLevel);
				userInforEntity.setStartDate(startDate);
				userInforEntity.setArrStartDate(arrStartDate);
				userInforEntity.setEndDate(endDate);
				userInforEntity.setArrEndDate(arrEndDate);
				userInforEntity.setTotal(total);
				userInforEntity.setStrTotal(strTotal);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("AddUserInputController: getDefaultValue: " + e.getMessage());
			throw e;
		}

		return userInforEntity;
	}
}
