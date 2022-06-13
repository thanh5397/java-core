/**
 * Copyright(C) 2020 Luvina Software
 * ViewDetailUserController.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.controllers;

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

/**
 * Controller thực hiện hiển thị chi tiết thông tin user
 * 
 * @author Ha Duyen Quang Huy
 */
@Controller
public class ViewDetailUserController {

	@Autowired
	TblUserRepository userRepo;

	@Autowired
	TblUserDaoImpl userDao;

	/**
	 * Xử lý khi click vào link từ màn hình ADM002
	 * 
	 * @param ModelMap: modelMap
	 * 
	 * @return String Path
	 */
	@RequestMapping(value = { "/viewDetailUser.do" }, method = RequestMethod.GET)
	public String doGet(@RequestParam(value = Constant.ID, required = false, defaultValue = "") String userId,
			ModelMap modelMap) {
		UserInfoEntity userInfo = null;
		int iD = 0;
		try {
			iD = Common.convertStringToInteger(userId);
			// Kiểm tra xem tồn tại user trong DB với iD vừa lấy từ request
			if (userRepo.existsById(iD)) {
				userInfo = userDao.getUserInfoById(iD);
				// Set userInfo để hiện thị trên màn hình ADM005
				modelMap.addAttribute(Constant.USER_INFO, userInfo);
				return "ADM005";
			} else {
				return  "redirect:/systemError.do"+ "?type=" + Constant.ERROR_013;
			}

		} catch (Exception e) {
			System.out.println("Error: ViewDetailUserController.doGet " + e.getMessage());
			return  "redirect:/systemError.do"+ "?type=" + Constant.ERROR_015;
		}
	}

}
