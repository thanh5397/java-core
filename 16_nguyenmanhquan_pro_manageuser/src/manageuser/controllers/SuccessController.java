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

import manageuser.utils.Constant;
import manageuser.utils.MessageProperties;

/**
 * Mô tả: Controller xử lý các logic thông báo thành công
 * 
 * @author Nguyễn Mạnh Quân
 */
public class SuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor mặc định
     */
    public SuccessController() {
    }

	/**
	 * Xử lý các logic thông báo thành công.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = Constant.EMPTY_STRING;
		String type = request.getParameter(Constant.PARAM_TYPE);
		if (type == null) {
			type = Constant.EMPTY_STRING;
		}
		switch (type) {
		case Constant.TYPE_INSERT_SUCCESS:
			message = MessageProperties.getMessageProperties(Constant.MSG001);
			break;
		case Constant.TYPE_UPDATE_SUCCESS:
			message = MessageProperties.getMessageProperties(Constant.MSG002);
			break;
		case Constant.TYPE_DELETE_SUCCESS:
			message = MessageProperties.getMessageProperties(Constant.MSG003);
		}
		request.setAttribute(Constant.PARAM_MESSAGE, message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM006);
		dispatcher.forward(request, response);
	}
}
