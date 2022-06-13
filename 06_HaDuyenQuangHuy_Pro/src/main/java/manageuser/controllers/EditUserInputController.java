/**
 * Copyright(C) 2020 Luvina Software
 * EditUserInputController.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.controllers;

import java.text.ParseException;
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
import manageuser.entities.UserInfoEntity;
import manageuser.repository.TblUserRepository;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.validates.ValidateUser;

/**
 * Controller xử lý logic tại màn hình ADM003 trường hợp Edit
 * 
 * @author Ha Duyen Quang Huy
 */
@Controller
public class EditUserInputController {

	@Autowired
	Common common;

	@Autowired
	TblUserRepository userRepo;

	@Autowired
	TblUserDaoImpl userDao;

	@Autowired
	ValidateUser vU;

	/**
	 * Hiển thị màn hình ADM003 trường hợp Edit
	 * 
	 * @param HttpServletRequest:  req 
	 * @param ModelMap: modelMap
	 * 
	 * @return String Path
	 */
	@RequestMapping(value = { "/editUserInput.do" }, method = RequestMethod.GET)
	public String doGet(HttpServletRequest request,
			@RequestParam(value = Constant.ID, required = false, defaultValue = "") String userId, ModelMap modelMap,
			@RequestParam(value = Constant.STATUS, required = false) String status) {
		try {
			int iD = Common.convertStringToInteger(userId);
			if (userRepo.existsById(iD)) {
				common.setDataLogicADM003(modelMap);
				modelMap.addAttribute(Constant.USER_INFO, getDefaultValue(request, modelMap, status, iD));
				return "ADM003";
			} else {
				return "redirect:/systemError.do" + "?type=" + Constant.ERROR_013;
			}

		} catch (Exception e) {
			System.out.println("Error: EditUserInputController.doGet " + e.getMessage());
			return "redirect:/systemError.do" + "?type=" + Constant.ERROR_015;
		}
	}

	/**
	 * Xử lý khi click vào button Xác nhận ADM004
	 * 
	 * @param HttpServletRequest:  req 
	 * @param ModelMap: modelMap
	 * @param HttpSession: session
	 * 
	 * @return String path
	 * 
	 */
	@RequestMapping(value = { "/editUserValidate.do", "/editUserInput.do" }, method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpSession session, ModelMap modelMap,
			@RequestParam(value = Constant.STATUS, required = false) String status,
			@RequestParam(value = Constant.ID, required = false, defaultValue = "") String userId) {
		try {
			int iD = Common.convertStringToInteger(userId);
			List<String> listError = null;
			String key = Common.creatSalt();
			UserInfoEntity userInfo = getDefaultValue(request, modelMap, status, iD);
			listError = vU.validateUser(userInfo);
			common.setDataLogicADM003(modelMap);
//			System.out.println(session.getAttribute(Constant.SESSION_LOGIN));
			if (Common.getLengthOfListString(listError) == 0) {
				// Chuỗi key được tạo ra từ creatSalt sẽ chứa giá trị của
				// userInfo
				session.setAttribute(key, userInfo);
				session.setAttribute(Constant.KEY_FROM_03, Constant.KEY_FROM_03);
				// Đồng thời gửi lên request một giá trị biến tên là key với
				// giá trị là key tạo ra từ creatSalt
				// Ví dụ với salt = 123456 thì sẽ có 1 biến key, ${key} =
				// 123456 và userInfo với ${123456} chứa userInfo
				return "redirect:/editUserConfirm.do" + "?key=" + key;
				// Trong trường hợp có lỗi sẽ sẽ lên request list lỗi để back về ADM003 và
				// userInfo để giữ giá trị
			} else {
				common.setDataLogicADM003(modelMap);
				modelMap.addAttribute(Constant.LISTERROR, listError);
				modelMap.addAttribute(Constant.USER_INFO, userInfo);
				return "ADM003";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/systemError.do";
		}
	}

	/**
	 * Thực hiện lấy giá trị mặc định các hạng mục của màn hình ADM004 - chức năng
	 * Edit
	 * 
	 * @param HttpServletRequest req
	 * @param ModelMap modelMap
	 * @param String status
	 * @param int iD
	 * 
	 * @return userInfo
	 */
	public UserInfoEntity getDefaultValue(HttpServletRequest req, ModelMap modelMap, String status, int iD)
			throws ParseException {
		UserInfoEntity userInfo = new UserInfoEntity();
		// Trường hợp default
		if (status == null) {
			userInfo = userDao.getUserInfoById(iD);
			// Trường hợp validate, lấy dữ liệu từ ADM003
		} else if (Constant.STATUS_VALIDATE.equals(status)) {
			userInfo.setUserId(iD);
			userInfo.setLoginName(req.getParameter(Constant.USERINFO_LOGIN_NAME));
			userInfo.setGroupName(req.getParameter(Constant.USERINFO_GROUP));
			userInfo.setFullName(req.getParameter(Constant.USERINFO_NAME));
			userInfo.setFullNameKana(req.getParameter(Constant.USERINFO_KANA_NAME));
			userInfo.setEmail(req.getParameter(Constant.USERINFO_EMAIL));
			userInfo.setTel(req.getParameter(Constant.USERINFO_TEL));
			userInfo.setNameLevel(req.getParameter(Constant.USERINFO_NAME_LEVEL));
			userInfo.setPassword(req.getParameter(Constant.USERINFO_PASSWORD));
			userInfo.setPasswordConfirm((req.getParameter(Constant.USERINFO_PASSWORD_CONFIRM)));
			userInfo.setBirthday(Common.getBirthdayFromRequest(req));

			if (!"".equals(userInfo.getNameLevel())) {
				userInfo.setStartDate(Common.getStartDateFromRequest(req));
				userInfo.setEndDate(Common.getEndDateFromRequest(req));
				userInfo.setTotal(req.getParameter(Constant.USERINFO_TOTAL));
			}
			// Trường hợp back, dữ liệu lấy từ session
		} else if (Constant.STATUS_BACK.equals(status)) {
			String key = req.getParameter(Constant.KEY_USER);
			// Lấy giá trị của userInfo từ key, ví dụ đang có 2 session với 2
			// key là {001} và {002} thì 001 sẽ chứa giá trị userInfo 1 và 002
			// sẽ chứa giá trị useInfo2
			userInfo = (UserInfoEntity) req.getSession().getAttribute(key);
			req.getSession().removeAttribute(key);

		}
		return userInfo;
	}
}
