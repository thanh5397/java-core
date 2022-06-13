<%@page import="manageuser.utils.MessageErrorProperties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="css/style.css"></c:url>"
	rel="stylesheet" type="text/css" />
<title>ユーザ管理</title>
</head>
<body align="center">
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Begin vung input-->
	<form action="listUser.do" method="get" name="inputform">
		<table class="tbl_input" border="0" width="80%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" colspan="2">
					<div style="height: 50px"></div>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><font color="red"> <%
 	out.print(MessageErrorProperties.getValueByKey(request.getParameter("type")));
 %>
				</font></td>


			</tr>
			<tr>
				<td align="center" colspan="2">
					<div style="height: 70px"></div>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input class="btn" type="submit"
					value="OK" /></td>
			</tr>
		</table>
	</form>
	<!-- End vung input -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>