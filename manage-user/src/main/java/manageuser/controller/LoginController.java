package manageuser.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import manageuser.utils.Constant;
import manageuser.validates.ValidateUser;

@Controller
public class LoginController {
	
	@Autowired
	ValidateUser validateUser;
	
	@GetMapping("/Login.do")
	public String showLogin() {
		return "ADM001";
	}
	@PostMapping("/Login.do")
	public String processLogin(Model model,@RequestParam(value = Constant.PARAM_LOGIN_NAME,required=false) String loginName,@RequestParam(value = Constant.PARAM_PASSWORD,required=false) String password,HttpServletRequest request) {
		try {
			List<String> listError = new ArrayList<String>();
			listError = validateUser.validateLogin(loginName, password);
			if (listError.size() == 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute(Constant.PARAM_LOGIN_NAME, loginName);
//				int maxInactiveInterval = Integer.parseInt(ConfigProperties.getConfigProperties(Constant.MAX_INACTIVE_INTERVAL));
//				session.setMaxInactiveInterval(maxInactiveInterval);
//				response.sendRedirect(contextPath + Constant.LIST_USER_DO + Constant.QUERY_STRING_TYPE + Constant.TYPE_DEFAULT);
				return "redirect:/" + Constant.LIST_USER_DO + Constant.QUERY_STRING_TYPE + Constant.TYPE_DEFAULT;
			} else {
				model.addAttribute(Constant.PARAM_LOGIN_NAME, loginName);
				model.addAttribute(Constant.PARAM_LIST_ERROR, listError);
				return "ADM001";
			}
		} catch (Exception e) {
			System.out.println("LoginController: doPost: " + e.getMessage());
			return "redirect:/" + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015;
		}
		
	}
}
