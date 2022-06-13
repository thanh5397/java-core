/**
 * Copyright(C) 2020 Luvina Software
 * ListUserController.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import manageuser.dao.impl.MstGroupDaoImpl;
import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.entities.MstGroupEntity;
import manageuser.entities.UserInfoEntity;
import manageuser.utils.Common;
import manageuser.utils.ConfigProperties;
import manageuser.utils.Constant;

/**
 * Class ListUserController - Controller xử lý hiển thị list User
 * 
 * @author Ha Duyen Quang Huy
 */
@Controller
public class ListUserController {

	@Autowired
	TblUserDaoImpl userDao;

	@Autowired
	MstGroupDaoImpl mstGroup;

	/**
	 * Hiển thị màn hình danh sách user ADM002
	 * 
	 * @param HttpServletRequest: request
	 * @param HttpSession: session
	 * @param ModelMap: modelMap
	 * 
	 * @return String path
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/listUser.do" }, method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpSession session, ModelMap modelMap,
			@RequestParam(value = "Status", required = false) String status,
			@RequestParam(value = Constant.GROUP_ID, required = false, defaultValue = Constant.DEFAULT_GROUP_ID
					+ "") String currentGroup,
			@RequestParam(value = Constant.TEXTBOX_FULLNAME, required = false, defaultValue = Constant.DEFAULT_FULL_NAME) String currentFullName,
			@RequestParam(value = Constant.SORT_BY, required = false, defaultValue = Constant.DEFAULT_SORT_TYPE) String currentSortBy,
			@RequestParam(value = Constant.CURRENT_PAGE, required = false, defaultValue = Constant.DEFAULT_PAGE
					+ "") String currentPage,
			@RequestParam(value = "click", required = false, defaultValue = "") String clickOnPaging,
			@RequestParam(value = Constant.SORT_BY_VALUE_FULLNAME, required = false, defaultValue = Constant.DEFAULT_SORT_FULL_NAME) String currentSortFullName,
			@RequestParam(value = Constant.SORT_BY_VALUE_CODELEVEL, required = false, defaultValue = Constant.DEFAULT_SORT_CODE_LEVEL) String currentSortCodeLevel,
			@RequestParam(value = Constant.SORT_BY_VALUE_ENDDATE, required = false, defaultValue = Constant.DEFAULT_SORT_END_DATE) String currentSortEndDate) {
		try {
			List<Integer> listPage = new ArrayList<Integer>();
			int currentPageInt = Common.convertStringToInteger(currentPage, Constant.DEFAULT_VALUE_ZERO);
			int limitPage = Common.convertStringToInteger(ConfigProperties.getValueByKey(Constant.LIMIT_PAGE));
			int limit = Common.convertStringToInteger(ConfigProperties.getValueByKey(Constant.LIMIT));
			int totalRecord = Constant.DEFAULT_TOTAL_RECORD;
			int totalPage = Constant.DEFAULT_TOTAL_PAGE;
			int offset = Constant.DEFAULT_OFFSET;
			List<MstGroupEntity> listGroup = mstGroup.getAllMstGroup();
			List<UserInfoEntity> listUser = null;
			if (status == null) {
				status = Constant.LISTUSER_TYPE_DEFAULT;
			}

			switch (status) {

			case Constant.LISTUSER_TYPE_SORT:
				switch (currentSortBy) {
				case Constant.SORT_BY_FULLNAME:
					currentSortFullName = (Constant.SORT_INCREMENT.equals(currentSortFullName))
							? Constant.SORT_DECREMENT
							: Constant.SORT_INCREMENT;

					break;

				case Constant.SORT_BY_CODELEVEL:
					currentSortCodeLevel = (Constant.SORT_INCREMENT.equals(currentSortCodeLevel))
							? Constant.SORT_DECREMENT
							: Constant.SORT_INCREMENT;

					break;

				case Constant.SORT_BY_ENDDATE:
					currentSortEndDate = (Constant.SORT_INCREMENT.equals(currentSortEndDate)) ? Constant.SORT_DECREMENT
							: Constant.SORT_INCREMENT;

					break;
				}

				break;
			case Constant.LISTUSER_TYPE_PAGING:
				if ("next".equals(clickOnPaging)) {
					currentPageInt = (currentPageInt % limitPage != 0)
							? (currentPageInt / limitPage + 1) * limitPage + 1
							: currentPageInt + 1;
				}
				// Trong tường hợp click vào back
				if ("back".equals(clickOnPaging)) {
					currentPageInt = (currentPageInt % 3 == 0) ? (currentPageInt / limitPage - 2) * limitPage + 1
							: (currentPageInt / limitPage - 1) * limitPage + 1;
				}
				totalRecord = userDao.getTotalUser(Integer.parseInt(currentGroup), currentFullName);
				totalPage = Common.getTotalPage(totalRecord, limit);
				if (currentPageInt > totalPage) {
					currentPageInt = totalPage;
				}
				// Trường hợp currentPage nhỏ hơn 0
				if (currentPageInt <= 0) {
					currentPageInt = 1;
				}
				// Giá trị offset để thực hiện lấy giá trị từ vị trí của
				// currentPage
				offset = Common.getOffSet(currentPageInt, limit);

				break;

			case Constant.LISTUSER_TYPE_BACK:

				listUser = (List<UserInfoEntity>) session.getAttribute(Constant.LIST_USER_RESULT);
				currentGroup = (String) session.getAttribute(Constant.GROUP_ID);
				currentFullName = (String) session.getAttribute(Constant.TEXTBOX_FULLNAME);
				currentPage = (String) session.getAttribute(Constant.CURRENT_PAGE);
				currentSortFullName = (String) session.getAttribute(Constant.SORT_BY_VALUE_FULLNAME);
				currentSortCodeLevel = (String) session.getAttribute(Constant.SORT_BY_VALUE_CODELEVEL);
				currentSortEndDate = (String) session.getAttribute(Constant.SORT_BY_VALUE_ENDDATE);

				break;
			}

			listUser = userDao.getListUsers(offset, limit, Common.convertStringToInteger(currentGroup, 0),
					currentFullName, currentSortBy, currentSortFullName, currentSortCodeLevel, currentSortEndDate);
			totalRecord = userDao.getTotalUser(Integer.parseInt(currentGroup), currentFullName);
			totalPage = Common.getTotalPage(totalRecord, limit);
			listPage = Common.getListPaging(totalRecord, limit, currentPageInt);
			modelMap.addAttribute(Constant.TEXTBOX_FULLNAME, currentFullName);
			modelMap.addAttribute(Constant.GROUP_ID, currentGroup);
			modelMap.addAttribute("listUser", listUser);
			modelMap.addAttribute(Constant.SORT_BY, currentSortBy);
			modelMap.addAttribute(Constant.SORT_BY_VALUE_FULLNAME, currentSortFullName);
			modelMap.addAttribute(Constant.SORT_BY_VALUE_ENDDATE, currentSortEndDate);
			modelMap.addAttribute(Constant.SORT_BY_VALUE_CODELEVEL, currentSortCodeLevel);
			modelMap.addAttribute(Constant.TOTAL_PAGE, totalPage);
			modelMap.addAttribute(Constant.CURRENT_PAGE, currentPageInt);
			modelMap.addAttribute(Constant.LIST_PAGE, listPage);
			modelMap.addAttribute(Constant.GROUP, listGroup);
			
			session.setAttribute(Constant.GROUP_ID, currentGroup);
			session.setAttribute(Constant.TEXTBOX_FULLNAME, currentFullName);
			// Set lên session giá trị listUser để giữ lại vùng kết quả tìm kiếm
			session.setAttribute(Constant.LIST_USER_RESULT, listUser);
			// Set lên session giá trị currentPage để giữ lại giá trị trang hiện tại 
			session.setAttribute(Constant.CURRENT_PAGE, currentPage);
			// Set lên session giá trị hạng mục hiện tại đang được sort và sort các hạng mục theo tiêu chí gì. 
			session.setAttribute(Constant.SORT_BY, currentSortBy);
			session.setAttribute(Constant.SORT_BY_VALUE_FULLNAME, currentSortFullName);
			session.setAttribute(Constant.SORT_BY_VALUE_ENDDATE, currentSortEndDate);
			session.setAttribute(Constant.SORT_BY_VALUE_CODELEVEL, currentSortCodeLevel);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "ADM002";
	}
}
