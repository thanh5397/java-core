<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="func"%>
<%@page import="manageuser.utils.Common"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="css/style.css"></c:url>"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value="js/user.js"></c:url>"></script>
<title>ユーザ管理</title>
</head>
<body>

	<!-- Begin vung header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- End vung header -->

	<!-- Begin vung input-->


	<form
		action="${userInfo.getUserId() > 0 ? 'editUserValidate.do' : 'addUserValidate.do'}"
		method="post" name="inputform">
		<input type="hidden" name="Status" value="validate" /> <input
			type="hidden" name="ID" value="${userInfo.getUserId()}" />
		<table class="tbl_input" border="0" width="75%" cellpadding="0"
			cellspacing="0">
			<tr>
				<th align="left">
					<div style="padding-left: 100px;">会員情報編集</div>
				</th>
			</tr>
			<tr>
				<td class="errMsg">
					<div style="padding-left: 100px">
						<c:forEach items="${listError}" var="error">
							<c:if test="${error ne '' }">${error} <br>
							</c:if>

						</c:forEach>
					</div>
				</td>
			</tr>
			<tr>
				<td align="left">
					<div style="padding-left: 100px;">
						<table border="0" width="100%" class="tbl_input" cellpadding="4"
							cellspacing="0">
							<tr>
								<td class="lbl_left"><font color="red">*</font> アカウント名:</td>
								<td align="left"><input class="txBox" type="text"
									name="loginName" value="${func:escapeXml(userInfo.getLoginName())}" size="15"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';"
									${userInfo.getUserId() > 0 ? 'readonly' : ''} /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> グループ:</td>
								<td align="left"><select name="group">
										<option value="">選択してください</option>
										<c:forEach items="${mstGroup}" var="group">
											<option value="${group.getGroupName()}"
												${group.getGroupName() == userInfo.getGroupName() ? 'selected="selected"' : ''}>${group.getGroupName()}</option>
										</c:forEach>
								</select> <span>&nbsp;&nbsp;&nbsp;</span></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> 氏名:</td>
								<td align="left"><input class="txBox" type="text"
									name="name" value="${func:escapeXml(userInfo.getFullName())}" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left">カタカナ氏名:</td>
								<td align="left"><input class="txBox" type="text"
									name="kanaName" value="${func:escapeXml(userInfo.getFullNameKana())}" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> 生年月日:</td>
								<td align="left"><select id="YearBirth" name="yearBirth"
									onchange="changeMonthBirth()">
										<c:forEach items="${listYear}" var="year">
											<option value="${year}"
												${year == userInfo.getBirthday().getYear()  + 1900? 'selected="selected"' : ''}>${year}</option>
										</c:forEach>
								</select>年 <select id="MonthBirth" onchange="changeMonthBirth()"
									name="monthBirth">
										<c:forEach items="${listMonth}" var="month">
											<option value="${month}"
												${month == userInfo.getBirthday().getMonth() +1 ? 'selected="selected"' : ''}>${Common.padStart(month,'0')}</option>
										</c:forEach>
								</select>月 <select id="DayBirth" name="dayBirth">
										<c:forEach items="${listDay}" var="day">
											<option value="${day}"
												${day == userInfo.getBirthday().getDate() ? 'selected="selected"' : ''}>${Common.padStart(day,'0')}</option>
										</c:forEach>
								</select>日</td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> メールアドレス:</td>
								<td align="left"><input class="txBox" type="text"
									name="email" value="${func:escapeXml(userInfo.getEmail())}" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font>電話番号:</td>
								<td align="left"><input class="txBox" type="text"
									name="tel" value="${func:escapeXml(userInfo.getTel())}" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<c:if test="${userInfo.getUserId() == 0}">
								<tr>
									<td class="lbl_left"><font color="red">*</font> パスワード:</td>
									<td align="left"><input class="txBox" type="password"
										name="password" value="${func:escapeXml(userInfo.getPassword())}" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>

								<tr>
									<td class="lbl_left">パスワード（確認）:</td>
									<td align="left"><input class="txBox" type="password"
										name="passwordConfirmed"
										value="${func:escapeXml(userInfo.getPasswordConfirm())}" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>
							</c:if>

							<tr>
								<th align="left" colspan="2"><a href="#"
									onclick="hideAndShow()">日本語能力</a></th>
							</tr>
							<tr id="hS0" style="display: none">
								<td class="lbl_left">資格:</td>
								<td align="left"><select name="nameLevel">
										<option value="">選択してください</option>
										<c:forEach items="${mstJapan}" var="level">
											<option value="${level.getNameLevel()}"
												${level.getNameLevel() == userInfo.getNameLevel() ? 'selected="selected"' : ''}>
												${level.getNameLevel()}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr id="hS1" style="display: none">
								<td class="lbl_left">資格交付日:</td>
								<td align="left"><select id="YearStart"
									onchange="changeMonthStart()" name="yearStart">
										<c:forEach items="${listYear}" var="year">
											<option value="${year}"
												${year == userInfo.getStartDate().getYear()  + 1900? 'selected="selected"' : ''}>${year}</option>
										</c:forEach>
								</select>年 <select id="MonthStart" onchange="changeMonthStart()"
									name="monthStart">
										<c:forEach items="${listMonth}" var="month">
											<option value="${month}"
												${month == userInfo.getStartDate().getMonth() +1 ? 'selected="selected"' : ''}>${Common.padStart(month,'0')}</option>
										</c:forEach>
								</select>月 <select id="DayStart" name="dayStart">
										<c:forEach items="${listDay}" var="day">
											<option value="${day}"
												${day == userInfo.getStartDate().getDate() ? 'selected="selected"' : ''}>${Common.padStart(day,'0')}</option>
										</c:forEach>
								</select>日</td>
							</tr>
							<tr id="hS2" style="display: none">
								<td class="lbl_left">失効日:</td>
								<td align="left"><select id="YearEnd"
									onchange="changeMonthEnd()" name="yearEnd">
										<c:forEach items="${listYearEndDate}" var="year">
											<option value="${year}"
												${year == userInfo.getEndDate().getYear()  + 1900? 'selected="selected"' : ''}>${year}</option>
										</c:forEach>
								</select>年 <select id="MonthEnd" onchange="changeMonthEnd()"
									name="monthEnd">
										<c:forEach items="${listMonth}" var="month">
											<option value="${month}"
												${month == userInfo.getEndDate().getMonth() +1 ? 'selected="selected"' : ''}>${Common.padStart(month,'0')}</option>
										</c:forEach>
								</select>月 <select id="DayEnd" name="dayEnd">
										<c:forEach items="${listDay}" var="day">
											<option value="${day}"
												${day == userInfo.getEndDate().getDate() ? 'selected="selected"' : ''}>${Common.padStart(day,'0')}
											</option>
										</c:forEach>
								</select>日</td>
							</tr>
							<tr id="hS3" style="display: none">
								<td class="lbl_left">点数:</td>
								<td align="left"><input class="txBox" type="text"
									name="total" value="${func:escapeXml(userInfo.getTotal())}" size="5"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<div style="padding-left: 100px;">&nbsp;</div>
		<!-- Begin vung button -->
		<div style="padding-left: 45px;">
			<table border="0" cellpadding="4" cellspacing="0" width="300px">
				<tr>
					<th width="200px" align="center">&nbsp;</th>
					<td><input class="btn" type="submit" value="確認" /></td>
					<c:choose>
						<c:when test="${userInfo.getUserId() > 0}">
						<td><input class="btn" type="button" value="戻る" onclick="location.href='viewDetailUser.do?ID=${userInfo.getUserId()}'"/></td>
						</c:when>
						<c:otherwise>
						<td><input class="btn" type="button" value="戻る" onclick="location.href='listUser.do?Status=Back'"/></td></c:otherwise>
					</c:choose>
					
					
				</tr>
			</table>
			<!-- End vung button -->
	</form>
	<!-- End vung input -->

	<!-- Begin vung footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End vung footer -->
</body>

</html>