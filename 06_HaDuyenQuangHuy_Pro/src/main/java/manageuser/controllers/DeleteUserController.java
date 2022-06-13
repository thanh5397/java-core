/**
 * Copyright(C) 2020  Luvina software
 * DeleterUserController.java,  28/09/2020 HaDuyenQuangHuy
 */
package manageuser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.logics.TblUserLogic;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Controller xử lý việc xóa một user
 * 
 * @author Ha Duyen Quang Huy
 */
@Controller
public class DeleteUserController {
	@Autowired
	TblUserDaoImpl userDao;

	@Autowired
	TblUserLogic userLogic;

	/**
	 * Xử lý khi click vào button Delete ADM005
	 * 
	 * @return String Path
	 */
	@RequestMapping(value = { "/deleteUser.do" }, method = RequestMethod.POST)
	public String doPost(@RequestParam(value = Constant.USER_ID, required = false, defaultValue = "") String userId) {
		try {

			int iD, ruleUser;
			iD = Common.convertStringToInteger(userId);
			ruleUser = userDao.getRuleByUserId(iD);
			if (ruleUser == Constant.RULE_USER) {
				if (userLogic.deleteUser(iD)) {
					return "redirect:" + Constant.URL_SUCCESS + "?type=" + Constant.DELETE_SUCCESS;
				} else {
					return "redirect:/systemError.do" + "?type=" + Constant.ERROR_014;
				}
				// nếu id có rule User là Admin, hiển thị ra màn hình thông báo lỗi ER020
			} else if (ruleUser == Constant.RULE_ADMIN) {
				return "redirect:/systemError.do" + "?type=" + Constant.ERROR_020;
				// nếu user xóa không tồn tại, hiển thị ra màn hình thông báo lỗi ER014
			} else {
				return "redirect:/systemError.do" + "?type=" + Constant.ERROR_014;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: DeleteUserController.doPost " + e.getMessage());
			return "redirect:/systemError.do" + "?type=" + Constant.ERROR_015;
		}
	}
}
