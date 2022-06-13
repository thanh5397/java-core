/**
 * Copyright(C) 2020 Luvina Software
 * LogoutController.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import manageuser.utils.Constant;

/**
 * Class LogoutController xử lý logout khi nhấn vào url /logout.do
 *
 * @author Ha Duyen Quang Huy
 */
@Controller
public class LogoutController {
	
	/**
	 * Đăng xuất khỏi hệ thống
	 * 
	 * @return String path
	 */
	@RequestMapping(value = {"/logout.do" }, method = RequestMethod.GET)
	public String doGet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.SESSION_LOGIN);
		
		return "ADM001";
	}

}
