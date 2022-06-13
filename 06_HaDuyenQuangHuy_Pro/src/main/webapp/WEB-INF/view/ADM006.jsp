<%@page import="manageuser.utils.MessageProperties"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="/css/style.css"></c:url>"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value="/js/user.js"></c:url>"></script>
<title>ユーザ管理</title>
</head>
<body>
	<!-- Begin vung header -->	
		<jsp:include page="header.jsp"></jsp:include>

<!-- End vung header -->	

<!-- Begin vung input-->	
	<form action="listUser.do" method="get" name="inputform">
	<table  class="tbl_input"   border="0" width="80%"  cellpadding="0" cellspacing="0" >	
		<tr>
			<td align="center" colspan="2">
				<div style="height:50px"></div>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<%
 					out.print(MessageProperties.getValueByKey(request.getParameter("type")));
				 %>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<div style="height:70px"></div>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input class="btn" type="submit" value="OK" onclick=""/>
			</td>
		</tr>
	</table>
	</form>
<!-- End vung input -->

<!-- Begin vung footer -->
	<jsp:include page="footer.jsp"></jsp:include>
<!-- End vung footer -->
</body>

</html>