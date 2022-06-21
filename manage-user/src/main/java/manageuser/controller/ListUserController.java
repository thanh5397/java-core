package manageuser.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import manageuser.dto.MstGroupDTO;
import manageuser.dto.UserInforDTO;
import manageuser.service.IMstGroupService;
import manageuser.service.ITblUserService;
import manageuser.utils.Common;
import manageuser.utils.Constant;

@Controller
public class ListUserController {
	
	@Autowired
    MessageSource messageSource;
	
	@Autowired
	ITblUserService tblUserService;
	
	@Autowired
	IMstGroupService mstGroupService;
	
	@Autowired
	Common common;
	
	@GetMapping("/ListUser.do")
	public String showListUser(Model model,HttpServletRequest request,@RequestParam(value = Constant.PARAM_GROUP_ID,required=false,defaultValue=Constant.GROUP_ID_ERROR) int groupId,
											@RequestParam(value = Constant.PARAM_FULL_NAME,required=false) String fullName,
											@RequestParam(value = Constant.PARAM_SORT_TYPE,required=false) String sortType,
											@RequestParam(value = Constant.PARAM_SORT_BY_FULL_NAME,required=false) String sortByFullName,
											@RequestParam(value = Constant.PARAM_SORT_BY_CODE_LEVEL,required=false) String sortByCodeLevel,
											@RequestParam(value = Constant.PARAM_SORT_BY_END_DATE,required=false) String sortByEndDate,
											@RequestParam(value = Constant.PARAM_TYPE,required=false) String type,
											@RequestParam(value = Constant.PARAM_CURRENT_PAGE,required=false,defaultValue=Constant.CURRENT_PAGE_DEFAULT) String currentPage) {
		try {
			HttpSession session = request.getSession();
			List<MstGroupDTO> listMstGroupEntities = null;
			List<UserInforDTO> listUserInfor = null;
			List<Integer> listPaging = null;

			int totalUser = Constant.NUMBER_ZERO;
			int totalPage = Constant.NUMBER_ZERO;
//			int currentPage = Constant.CURRENT_PAGE_DEFAULT;
			int offset = Constant.OFFSET_DEFAULT;
			int limit = common.getLimit();
//			int groupId = Common.convertStringToInt(request.getParameter(Constant.PARAM_GROUP_ID), Constant.GROUP_ID_DEFAUL);
//			String fullName = request.getParameter(Constant.PARAM_FULL_NAME);
//			String sortType = request.getParameter(Constant.PARAM_SORT_TYPE);
//			String sortByFullName = request.getParameter(Constant.PARAM_SORT_BY_FULL_NAME);
//			String sortByCodeLevel = request.getParameter(Constant.PARAM_SORT_BY_CODE_LEVEL);
//			String sortByEndDate = request.getParameter(Constant.PARAM_SORT_BY_END_DATE);
//			String type = request.getParameter(Constant.PARAM_TYPE);
			MstGroupDTO mstGroupDTO = new MstGroupDTO();
			groupId = Constant.GROUP_ID_DEFAUL;
			fullName = Constant.EMPTY_STRING;
			sortType = Constant.SORT_TYPE_FULL_NAME;
			sortByFullName = Constant.SORT_ASC;
			sortByCodeLevel = Constant.SORT_ASC;
			sortByEndDate = Constant.SORT_DESC;

			if (type == null) {
				type = Constant.EMPTY_STRING;
			}
			switch (type) {
				case Constant.TYPE_DEFAULT:
					groupId = Constant.GROUP_ID_DEFAUL;
					fullName = Constant.EMPTY_STRING;
					sortType = Constant.SORT_TYPE_FULL_NAME;
					sortByFullName = Constant.SORT_ASC;
					sortByCodeLevel = Constant.SORT_ASC;
					sortByEndDate = Constant.SORT_DESC;
					break;
	
				case Constant.TYPE_SEARCH:
//					groupId = Common.convertStringToInt(request.getParameter(Constant.PARAM_GROUP_ID),
//							Constant.GROUP_ID_ERROR);
					sortType = Constant.SORT_TYPE_FULL_NAME;
					sortByFullName = Constant.SORT_ASC;
					sortByCodeLevel = Constant.SORT_ASC;
					sortByEndDate = Constant.SORT_DESC;
					break;
	
				case Constant.TYPE_SORT:
					switch (sortType) {
	
						case Constant.SORT_TYPE_FULL_NAME:
							sortByCodeLevel = Constant.SORT_ASC;
							sortByEndDate = Constant.SORT_DESC;
							break;
		
						case Constant.SORT_TYPE_CODE_LEVEL:
							sortByFullName = Constant.SORT_ASC;
							sortByEndDate = Constant.SORT_DESC;
							break;
		
						case Constant.SORT_TYPE_END_DATE:
							sortByFullName = Constant.SORT_ASC;
							sortByCodeLevel = Constant.SORT_ASC;
							break;
						}
					break;
	
				case Constant.TYPE_PAGING:
//					groupId = Common.convertStringToInt(request.getParameter(Constant.PARAM_GROUP_ID),
//							Constant.GROUP_ID_ERROR);
					break;
	
				case Constant.TYPE_BACK:
					groupId = (int) session.getAttribute(Constant.PARAM_GROUP_ID);
					fullName = (String) session.getAttribute(Constant.PARAM_FULL_NAME);
					sortType = (String) session.getAttribute(Constant.PARAM_SORT_TYPE);
					sortByFullName = (String) session.getAttribute(Constant.PARAM_SORT_BY_FULL_NAME);
					sortByCodeLevel = (String) session.getAttribute(Constant.PARAM_SORT_BY_CODE_LEVEL);
					sortByEndDate = (String) session.getAttribute(Constant.PARAM_SORT_BY_END_DATE);
					currentPage = (String) session.getAttribute(Constant.PARAM_CURRENT_PAGE);
					break;
				}
//				mstGroupDTO = mstGroupService.findMstGroupByGroupId(groupId);
				//totalUser = tblUserService.getCountTotalUser(groupId,fullName);
				if (totalUser > 0) {
					totalPage = Common.getTotalPage(totalUser, limit);
					if (totalPage > 1) {
						if (!Common.compareString(type, Constant.TYPE_BACK)) {
							if (Common.convertStringToInt(currentPage,0) < 0) {
								currentPage = Constant.CURRENT_PAGE_DEFAULT;
							}
							if (Common.convertStringToInt(currentPage,0) > totalPage) {
								currentPage = Common.convertIntToString(totalPage,"0");
							}
						}
						offset = Common.getOffset(Common.convertStringToInt(currentPage,0), limit);
						listPaging = Common.getListPaging(totalUser, limit, Common.convertStringToInt(currentPage,0));
					}
				} else {
					String message = messageSource.getMessage(Constant.MSG005,null,null);
					model.addAttribute(Constant.PARAM_MESSAGE, message);
				}
				listMstGroupEntities = mstGroupService.findAll();
				listUserInfor = tblUserService.getListUsers(1, offset, limit, groupId, fullName, sortType, sortByFullName, sortByCodeLevel, sortByEndDate);
	
				model.addAttribute(Constant.PARAM_LIST_GROUP, listMstGroupEntities);
				model.addAttribute(Constant.PARAM_LIST_USER_INFO, listUserInfor);
				model.addAttribute(Constant.PARAM_LIST_PAGING, listPaging);
				model.addAttribute(Constant.PARAM_CURRENT_PAGE, currentPage);
				model.addAttribute(Constant.PARAM_TOTAL_PAGE, totalPage);
				model.addAttribute(Constant.PARAM_FULL_NAME, fullName);
				model.addAttribute(Constant.PARAM_GROUP_ID, groupId);
				model.addAttribute(Constant.PARAM_SORT_TYPE, sortType);
				model.addAttribute(Constant.PARAM_SORT_BY_FULL_NAME, sortByFullName);
				model.addAttribute(Constant.PARAM_SORT_BY_CODE_LEVEL, sortByCodeLevel);
				model.addAttribute(Constant.PARAM_SORT_BY_END_DATE, sortByEndDate);
	
				session.setAttribute(Constant.PARAM_CURRENT_PAGE, currentPage);
				session.setAttribute(Constant.PARAM_FULL_NAME, fullName);
				session.setAttribute(Constant.PARAM_GROUP_ID, groupId);
				session.setAttribute(Constant.PARAM_SORT_TYPE, sortType);
				session.setAttribute(Constant.PARAM_SORT_BY_FULL_NAME, sortByFullName);
				session.setAttribute(Constant.PARAM_SORT_BY_CODE_LEVEL, sortByCodeLevel);
				session.setAttribute(Constant.PARAM_SORT_BY_END_DATE, sortByEndDate);
	
				return "ADM002";
		} catch (Exception e) {
			System.out.println("ListUserController: doGet: " + e.getMessage());
			return Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015;
		}
	}
}
