/**
 * Copyright(C) 2020 Luvina Software
 * DeleteUserInforController.java, 13/08/2020 Nguyễn Mạnh Quân
 */
package manageuser.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.entities.TblUserEntity;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Mô tả: Controller xử lý các logic của chức năng Delete
 * 
 * @author Nguyễn Mạnh Quân
 */
public class DeleteUserInforController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor mặc định
	 */
	public DeleteUserInforController() {
	}

	/**
	 * Xử lý khi click vào button OK trên MessageBox DeleteUserInfor
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();
		try {
			TblUserLogic tblUserLogic = new TblUserLogicImpl();
			int userId = Common.convertStringToInt(request.getParameter(Constant.PARAM_USER_ID),
					Constant.USER_ID_ERROR);
			TblUserEntity tblUserEntity = tblUserLogic.getRuleByUserId(userId);
			if (tblUserEntity != null) {
				if (tblUserEntity.getRule() == 0) {
					response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER020);
				} else {
					boolean isDeleted = tblUserLogic.deleteUserInfor(userId);
					if (isDeleted) {
						response.sendRedirect(
								contextPath + Constant.SUCCESS_DO + Constant.QUERY_STRING_TYPE + Constant.TYPE_DELETE_SUCCESS);
					} else {
						response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
					}
				}
			} else {
				response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER014);
			}

		} catch (Exception e) {
			System.out.println("AddUserConfirmController: doPost: " + e.getMessage());
			response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_DO + Constant.QUERY_STRING_TYPE + Constant.ER015);
		}
	}
}
