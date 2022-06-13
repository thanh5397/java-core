/**
 * Copyright(C) 2020  Luvina software
 * EditUserConfirmController.java, 09/29/2020 HuyHDQ
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
import manageuser.repository.TblUserRepository;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Controller xử lý các logic của màn hình ADM004 trường hợp Edit
 * 
 * @author Ha Duyen Quang Huy
 */
@Controller
public class EditUserConfirmController {
	@Autowired
	TblUserLogicImpl tblUserLogic;

	@Autowired
	TblUserDaoImpl tblUserDao;

	@Autowired
	TblUserRepository userRepo;

	/**
	 * Xử lý hiển thị màn hình ADM004
	 * 
	 * @param HttpServletRequest:  req
	 * @param HttpSession: session
	 * 
	 * @return String path
	 * 
	 */
	@RequestMapping(value = { "/editUserConfirm.do" }, method = RequestMethod.GET)
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
	 * Xử lý khi click vào button Ok của màn hình ADM004 trường hợp Edit
	 * 
	 * @param HttpServletRequest:  req
	 * 
	 * @return String path
	 */
	@RequestMapping(value = { "editUserOK.do" }, method = RequestMethod.POST)
	public String doPost(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserInfoEntity userInfo;
		int userId;
		try {
			// Lấy userInfo từ trên session
			userInfo = (UserInfoEntity) session.getAttribute(Constant.USER_INFO);
			session.removeAttribute(Constant.USER_INFO);
			userId = userInfo.getUserId();
			// Kiểm tra nếu tồn tại useriD
			if (userRepo.existsById(userId)) {
				// Kiểm tra Email có tồn tại trong DB hay không
				if (!tblUserDao.checkExistedUserByEmail(userInfo.getEmail(), userInfo.getUserId())) {
					boolean checkEditSuccess = tblUserLogic.updateUser(userInfo);
					// Kiểm tra xem việc edit co thành công hay không
					// Nếu có chuyển sang màn hình thông báo thành công
					if (checkEditSuccess) {
						return "redirect:/success.do" + "?type=" + Constant.UPDATE_SUCCESS;
						// Nếu không chuyển sang màn hình thông báo lỗi
					} else {
						return "redirect:/systemError.do" + "?type=" + Constant.ERROR_015;
					}
					// Nếu email đã tồn tại trong DB thì chuyển sang màn hình thông báo lỗi
					// Trong trường hợp có người edit lại giá trị email trong DB
				} else {
					return "redirect:/systemError.do" + "?type=" + Constant.ERROR_015;
				}
			} else {
				return "redirect:/systemError.do" + "?type=" + Constant.ERROR_013;
			}

		} catch (Exception e) {
			System.out.println("Error: EditUserConfirmController.doPost " + e.getMessage());
			return "redirect:/systemError.do" + "?type=" + Constant.ERROR_015;
		}
	}

}
