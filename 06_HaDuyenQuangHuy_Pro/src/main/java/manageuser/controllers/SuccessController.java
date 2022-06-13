/**
 * Copyright(C) 2020  Luvina software
 * SuccessController.java, 09/29/2020 HuyHDQ
 */
package manageuser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import manageuser.utils.Constant;

/**
 * Controller xử lý hiển thị màn hình success controller 
 * @author Ha Duyen Quang Huy
 */
@Controller
public class SuccessController {
	
	/**
	 * Xử lý hiển thị trong 3 trường hợp add, edit, delete thành công  
	 * 
	 * @return String path
	 */
	@RequestMapping(value = { "/success.do" }, method = RequestMethod.GET)
	public String doGet(@RequestParam(Constant.TYPE) String type) {
		return "ADM006";
	}
}
