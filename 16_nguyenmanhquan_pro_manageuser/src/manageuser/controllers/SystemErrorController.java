/**
 * Copyright(C) 2020 Luvina Software
 * ListUserController.java, 03/08/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.utils.MessageErrorProperties;

/**
 * Mô tả: Controller xử lý các logic thông báo lỗi
 * 
 * @author Nguyễn Mạnh Quân
 */
public class SystemErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor mặc định
     */
    public SystemErrorController() {
        super();
    }

	/**
	 * Xử lý các logic thông báo lỗi.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = Constant.EMPTY_STRING;
		String type = request.getParameter(Constant.PARAM_TYPE);
		if (!Common.checkBlank(type)) {
			error = MessageErrorProperties.getMessageError(type);
		}
		request.setAttribute(Constant.PARAM_ERROR, error);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.SYSTEM_ERROR);
		dispatcher.forward(request, response);
	}
}
