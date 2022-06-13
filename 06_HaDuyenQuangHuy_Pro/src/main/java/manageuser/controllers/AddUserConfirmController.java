/**
 * Copyright(C) 2020 Luvina Software
 * AddUserConfirmController.java, 09/29/2020 HaDuyenQuangHuy
 */
package manageuser.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.entities.UserInfoEntity;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Controller xử lý các logic của màn hình ADM004 trường hợp Add
 * 
 * @author Ha Duyen Quang Huy
 */
@Controller
public class AddUserConfirmController {

	@Autowired
	TblUserLogicImpl tblUserLogic;

	@Autowired
	TblUserDaoImpl tblUserDao;

	/**
	 * Xử lý khi click vào button Xác nhận của ADM003
	 * 
	 * @param HttpServletRequest:  resquest
	 * 
	 * @return String Path
	 */
	@RequestMapping(value = { "/addUserConfirm.do" }, method = RequestMethod.GET)
	public String doGet(HttpServletRequest req,
			@RequestParam(value = Constant.KEY_USER, required = false, defaultValue = "") String key) {
		HttpSession session = req.getSession();
		String key03 = (String) session.getAttribute(Constant.KEY_FROM_03);
		try {
			if (Common.compareString(Constant.KEY_FROM_03, key03)) {
				// Lấy giá trị của khóa từ req
				// Key đóng vai trò như là con trỏ để chỉ đến userInfo trên request
				UserInfoEntity userInfo = (UserInfoEntity) session.getAttribute(key);
				// set lại UserInfo mới chứa trong "userInfo" để forward sang màn hình ADM004
				session.setAttribute(Constant.USER_INFO, userInfo);
				// set lại key lên request để phục vụ cho trường hợp back về
				return "ADM004";
				// Nếu không tồn tại key03 sẽ di chuyển sang màn hình thông báo lỗi
			} else {
				return "systemError";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "systemError";
	}

	/**
	 * Xử lý khi click vào button Ok của màn hình ADM004 trường hợp Add
	 * 
	 * @param HttpServletRequest:  req
	 * 
	 * @return String Path
	 */
	@RequestMapping(value = { "/addUserOK.do" }, method = RequestMethod.POST)
	public String doPost(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserInfoEntity userInfo = null;
		boolean checkSuccess = false;
		try {
			// Lấy từ userInfo từ session để thực hiện têm mới một user
			userInfo = (UserInfoEntity) session.getAttribute(Constant.USER_INFO);
			// Xóa userInfo vừa được lấy từ server
			session.removeAttribute(Constant.USER_INFO);
			// Nếu kiểm tra userName và email của userInfo không tồn tại thì tiến hành thêm
			// mới 1 user
			if (!tblUserDao.checkExistedUserByLoginName(userInfo.getLoginName())
					&& !tblUserDao.checkExistedUserByEmail(userInfo.getEmail())) {
				checkSuccess = tblUserLogic.createUser(userInfo);
			}
			if (!checkSuccess) {
//				resp.sendRedirect(req.getContextPath() + Constant.URL_SUCCESS + "?type=" + Constant.INSERT_SUCCESS);
				return "redirect:/systemError.do" + "?type=" + Constant.ERROR_014;
			}
		} catch (Exception e) {
//			resp.sendRedirect(req.getContextPath() + "/" + Constant.URL_SYS_ERROR + "?type=" + Constant.ERROR_015);
			System.out.println("Error: AddUserConfirmController.doPost " + e.getMessage());
			return "redirect:/systemError.do" + "?type=" + Constant.ERROR_015;
		}
		return "redirect:/success.do" + "?type=" + Constant.INSERT_SUCCESS;
	}
}
