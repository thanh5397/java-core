/**
 * Copyright(C) 2020 Luvina Software
 * LoginController.java, 14/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.utils.ConfigProperties;
import manageuser.utils.Constant;
import manageuser.validates.ValidateUser;

/**
 * Mô tả: Controller để xử lý cho màn hình ADM001
 * @author Nguyễn Mạnh Quân
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor mặc định.
	 */
	public LoginController() {
	}

	/**
	 * Hàm xử lý khi click button đăng nhập tại màn hình ADM001
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		// Xử lý ngoại lệ
		try {
			ValidateUser validateUser = new ValidateUser();
			String loginName = request.getParameter(Constant.PARAM_LOGIN_NAME);
			String password = request.getParameter(Constant.PARAM_PASSWORD);
			List<String> listError = new ArrayList<String>();
			listError = validateUser.validateLogin(loginName, password);
			if (listError.size() == 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute(Constant.PARAM_LOGIN_NAME, loginName);
				int maxInactiveInterval = Integer.parseInt(ConfigProperties.getConfigProperties(Constant.MAX_INACTIVE_INTERVAL));
				session.setMaxInactiveInterval(maxInactiveInterval);
				response.sendRedirect(contextPath + Constant.LIST_USER_DO + Constant.QUERY_STRING_TYPE + Constant.TYPE_DEFAULT);
			} else {
				request.setAttribute(Constant.PARAM_LOGIN_NAME, loginName);
				request.setAttribute(Constant.PARAM_LIST_ERROR, listError);
				RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM001);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("LoginController: doPost: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}

	/**
	 * Hàm xử lý load trang login
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM001);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("LoginController: doGet: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}
}
