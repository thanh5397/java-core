/**
 * Copyright(C) 2020 Luvina Software
 * LoginController.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.utils.Constant;
import manageuser.validates.ValidateUser;

/**
 * Class LoginController Xử lý việc Login ở màn hình ADM001
 *
 * @author HaDuyenQuangHuy
 */
@Controller
public class LoginController {

	@Autowired
	ValidateUser validateUser;

	@Autowired
	TblUserDaoImpl tbl;

	/**
	 *  Xử lý hiển thị màn hình login khi nhập url /login.do
	 *  
	 *  @return String path
	 */
	@RequestMapping(value = { "/", "/login.do" }, method = RequestMethod.GET)
	public String doGet() {

		return "ADM001";
	}

	/**
	 * Điều hướng khi sumbit - nhấn vào button Login tại ADM001
	 * 
	 * @param ModelMap: modelMap
	 * @param HttpServletRequest: request
	 * @param HttpSession: session
	 *
	 * @return String path
	 */
	@RequestMapping(value = { "/", "/login.do" }, method = RequestMethod.POST)
	public String doPost(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
			ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		try {
			List<String> listError = validateUser.validateLogin(loginName, password);
			if (listError.size() == 0) {
				HttpSession newSession = request.getSession();
				newSession.setAttribute(Constant.SESSION_LOGIN, loginName);
				modelMap.addAttribute("listError", listError);
				modelMap.addAttribute("loginName", loginName);
				return "redirect:/listUser.do";
			} else {
				return "ADM001";
			}
		} catch (Exception e) {
			return "systemError";
		}

	}
}
