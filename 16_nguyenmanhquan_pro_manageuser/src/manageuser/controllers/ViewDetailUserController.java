/**
 * Copyright(C) 2020 Luvina Software
 * ViewUserDetailController.java, 07/08/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.entities.UserInforEntity;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Mô tả: Controller xử lý các logic của màn hình ADM005
 * 
 * @author Nguyễn Mạnh Quân
 */
public class ViewDetailUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor mặc định
	 */
	public ViewDetailUserController() {
	}

	/**
	 * Xử lý khi click vào link ID của ADM002
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			int userId = Common.convertStringToInt(request.getParameter(Constant.PARAM_USER_ID), Constant.USER_ID_ERROR);
			TblUserLogic tblUserLogic = new TblUserLogicImpl();
			if (tblUserLogic.checkExistUserId(userId)) {
				UserInforEntity userInforEntity = tblUserLogic.getUserDetailById(userId);
				request.setAttribute(Constant.PARAM_USER_INFO_ENTITY, userInforEntity);
				request.setAttribute(Constant.PARAM_USER_ID, userId);
				RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM005);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER013);
			}
		} catch (Exception e) {
			System.out.println("ViewUserDetailController: doGet: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}
}
