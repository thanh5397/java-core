/**
 * Copyright(C) 2020 Luvina Software
 * ListUserController.java, 14/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.MstGroupEntity;
import manageuser.entities.UserInforEntity;
import manageuser.logics.MstGroupLogic;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.utils.MessageProperties;

/**
 * Mô tả: Controller để xử lý cho màn hình ADM002
 * 
 * @author Nguyễn Mạnh Quân
 */
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor mặc định.
	 */
	public ListUserController() {
	}

	/**
	 * Hàm xử lý lấy data để hiển thị màn hình danh sách user ADM002
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			HttpSession session = request.getSession();
			MstGroupLogic mstGroupLogic = new MstGroupLogicImpl();
			TblUserLogic tblUserLogic = new TblUserLogicImpl();
			List<MstGroupEntity> listMstGroupEntities = null;
			List<UserInforEntity> listUserInfor = null;
			List<Integer> listPaging = null;

			int totalUser = Constant.NUMBER_ZERO;
			int totalPage = Constant.NUMBER_ZERO;
			int currentPage = Constant.CURRENT_PAGE_DEFAULT;
			int offset = Constant.OFFSET_DEFAULT;
			int limit = Common.getLimit();
			int groupId = Common.convertStringToInt(request.getParameter(Constant.PARAM_GROUP_ID), Constant.GROUP_ID_DEFAUL);
			String fullName = request.getParameter(Constant.PARAM_FULL_NAME);
			String sortType = request.getParameter(Constant.PARAM_SORT_TYPE);
			String sortByFullName = request.getParameter(Constant.PARAM_SORT_BY_FULL_NAME);
			String sortByCodeLevel = request.getParameter(Constant.PARAM_SORT_BY_CODE_LEVEL);
			String sortByEndDate = request.getParameter(Constant.PARAM_SORT_BY_END_DATE);
			String type = request.getParameter(Constant.PARAM_TYPE);

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
				groupId = Common.convertStringToInt(request.getParameter(Constant.PARAM_GROUP_ID),
						Constant.GROUP_ID_ERROR);
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
				groupId = Common.convertStringToInt(request.getParameter(Constant.PARAM_GROUP_ID),
						Constant.GROUP_ID_ERROR);
				break;

			case Constant.TYPE_BACK:
				groupId = (int) session.getAttribute(Constant.PARAM_GROUP_ID);
				fullName = (String) session.getAttribute(Constant.PARAM_FULL_NAME);
				sortType = (String) session.getAttribute(Constant.PARAM_SORT_TYPE);
				sortByFullName = (String) session.getAttribute(Constant.PARAM_SORT_BY_FULL_NAME);
				sortByCodeLevel = (String) session.getAttribute(Constant.PARAM_SORT_BY_CODE_LEVEL);
				sortByEndDate = (String) session.getAttribute(Constant.PARAM_SORT_BY_END_DATE);
				currentPage = (int) session.getAttribute(Constant.PARAM_CURRENT_PAGE);
				break;
			}
			totalUser = tblUserLogic.getTotalUsers(groupId, fullName);

			if (totalUser > 0) {
				totalPage = Common.getTotalPage(totalUser, limit);
				if (totalPage > 1) {
					if (!Common.compareString(type, Constant.TYPE_BACK)) {
						currentPage = Common.convertStringToInt(request.getParameter(Constant.PARAM_CURRENT_PAGE),
								Constant.CURRENT_PAGE_DEFAULT);
						if (currentPage < 0) {
							currentPage = Constant.CURRENT_PAGE_DEFAULT;
						}
						if (currentPage > totalPage) {
							currentPage = totalPage;
						}
					}
					offset = Common.getOffset(currentPage, limit);
					listPaging = Common.getListPaging(totalUser, limit, currentPage);
				}
			} else {
				String message = MessageProperties.getMessageProperties(Constant.MSG005);
				request.setAttribute(Constant.PARAM_MESSAGE, message);
			}
			listMstGroupEntities = mstGroupLogic.getAllMstGroup();
			listUserInfor = tblUserLogic.getListUsers(offset, limit, groupId, fullName, sortType, sortByFullName,
					sortByCodeLevel, sortByEndDate);

			request.setAttribute(Constant.PARAM_LIST_GROUP, listMstGroupEntities);
			request.setAttribute(Constant.PARAM_LIST_USER_INFO, listUserInfor);
			request.setAttribute(Constant.PARAM_LIST_PAGING, listPaging);
			request.setAttribute(Constant.PARAM_CURRENT_PAGE, currentPage);
			request.setAttribute(Constant.PARAM_TOTAL_PAGE, totalPage);
			request.setAttribute(Constant.PARAM_FULL_NAME, fullName);
			request.setAttribute(Constant.PARAM_GROUP_ID, groupId);
			request.setAttribute(Constant.PARAM_SORT_TYPE, sortType);
			request.setAttribute(Constant.PARAM_SORT_BY_FULL_NAME, sortByFullName);
			request.setAttribute(Constant.PARAM_SORT_BY_CODE_LEVEL, sortByCodeLevel);
			request.setAttribute(Constant.PARAM_SORT_BY_END_DATE, sortByEndDate);

			session.setAttribute(Constant.PARAM_CURRENT_PAGE, currentPage);
			session.setAttribute(Constant.PARAM_FULL_NAME, fullName);
			session.setAttribute(Constant.PARAM_GROUP_ID, groupId);
			session.setAttribute(Constant.PARAM_SORT_TYPE, sortType);
			session.setAttribute(Constant.PARAM_SORT_BY_FULL_NAME, sortByFullName);
			session.setAttribute(Constant.PARAM_SORT_BY_CODE_LEVEL, sortByCodeLevel);
			session.setAttribute(Constant.PARAM_SORT_BY_END_DATE, sortByEndDate);

			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.ADM002);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("ListUserController: doGet: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}
}
