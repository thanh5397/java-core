/**
 * Copyright(C) 2020 Luvina Software
 * LogoutController.java, 14/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.utils.Constant;

/**
 * Mô tả: Controller để xử lý Logout
 * @author Nguyễn Mạnh Quân
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Constructor mặc định. 
     */
    public LogoutController() {
    }

	/**
	 * Xử lý khi click button đăng xuất
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect(request.getContextPath() + Constant.LOGIN_DO);
		} catch (Exception e) {
			System.out.println("LogoutController: doGet: " + e.getMessage());
		}
	}
}
