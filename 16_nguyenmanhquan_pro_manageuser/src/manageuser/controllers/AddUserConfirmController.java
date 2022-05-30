/**
 * Copyright(C) 2020 Luvina Software
 * AddUserConfirmController.java, 14/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.UserInforEntity;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Mô tả: Controller xử lý các logic của màn hình ADM003
 * 
 * @author Nguyễn Mạnh Quân
 */
public class AddUserConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor mặc định
	 */
	public AddUserConfirmController() {
	}

	/**
	 * Xử lý khi click vào button Xác nhận của ADM003
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			HttpSession session = request.getSession();
			String keyMove = (String) session.getAttribute(Constant.PARAM_KEY_MOVE);
			if (Common.compareString(Constant.KEY_MOVE_FROM_ADM003, keyMove)) {
				session.removeAttribute(Constant.PARAM_KEY_MOVE);
				RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM004);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(contextPath + Constant.LIST_USER_DO);
			}

		} catch (Exception e) {
			System.out.println("AddUserConfirmController: doGet: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}

	/**
	 * Xử lý khi click vào button OK của ADM004
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			HttpSession session = request.getSession();
			TblUserLogic tblUserLogic = new TblUserLogicImpl();
			UserInforEntity userInforEntity = (UserInforEntity) session.getAttribute(Constant.PARAM_USER_INFO_ENTITY);
			session.removeAttribute(Constant.PARAM_USER_INFO_ENTITY);
			session.removeAttribute(request.getParameter(Constant.PARAM_KEY_USER));
			boolean isExist = false;
			if (tblUserLogic.checkExistLoginName(userInforEntity.getLoginName())
					|| tblUserLogic.checkExistEmail(userInforEntity.getUserId(), userInforEntity.getEmail())) {
				isExist = true;
				response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
			}
			if (!isExist) {
				boolean isInserted = tblUserLogic.createUser(userInforEntity);
				if (isInserted) {
					response.sendRedirect(contextPath + Constant.SUCCESS_DO + Constant.QUERY_STRING_TYPE + Constant.TYPE_INSERT_SUCCESS);
				}
			}
		} catch (Exception e) {
			System.out.println("AddUserConfirmController: doPost: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}
}
