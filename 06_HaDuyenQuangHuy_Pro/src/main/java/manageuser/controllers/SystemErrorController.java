/**
 * Copyright(C) 2020  Luvina software
 * SystemErrorController.java, 09/29/2020 HuyHDQ
 */
package manageuser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import manageuser.utils.Constant;

/**
 * Controller xử lý hiển thị thông báo lỗi
 * @author Ha Duyen Quang Huy
 */
@Controller
public class SystemErrorController {

	/**
	 * Hiển thị màn hình thông báo lỗi SystemErrorController 
	 * 
	 * @return String Path
	 */
	@RequestMapping(value = { "/systemError.do" }, method = RequestMethod.GET)
	public String doGet(@RequestParam(Constant.TYPE) String type) {
		return "systemError";
	}
	
}
