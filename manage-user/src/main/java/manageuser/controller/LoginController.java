package manageuser.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import manageuser.utils.ConfigProperties;
import manageuser.utils.Constant;
import manageuser.validates.ValidateUser;

@Controller
public class LoginController {
	
	@GetMapping("/Login.do")
	public String showLogin() {
		return "ADM001";
	}
	@PostMapping("/Login.do")
	public String processLogin(Model model) {
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
				return "ADM001";
			}
		} catch (Exception e) {
			System.out.println("LoginController: doPost: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
		
	}
}
