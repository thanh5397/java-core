<%@page import="manageuser.utils.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin vung header -->
<div>
	<div>
		<table>
			<tr>
				<td width="80%"><img
					src="<c:url value="/images/logo-manager-user.gif"></c:url>"
					alt="Luvina" />
				<td>
				<td align="left"><a href="logout.do">ログアウト</a> &nbsp; <a
					href="listUser.do?Status=${Constant.LISTUSER_TYPE_DEFAULT}">トップ</a>
				<td>
			</tr>
		</table>
	</div>
</div>
<!-- End vung header -->