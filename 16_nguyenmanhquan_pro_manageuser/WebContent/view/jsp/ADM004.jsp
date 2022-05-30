<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="view/css/style.css" rel="stylesheet" type="text/css" />
	<script language="Javascript" src="view/js/script.js"></script>
	<title>ユーザ管理</title>
</head>

<body>
	<!-- Begin vung header -->
	<jsp:include page="header.jsp" />

	<!-- End vung header -->

	<!-- Begin vung input-->
	<c:set value="${userInforEntity.userId}" var="userIdVariable"/>
	<c:choose>
		<c:when test="${userIdVariable == 0}">
			<c:url value="AddUserConfirm.do" var="ConfirmURL"/>
		</c:when>
		<c:otherwise>
			<c:url value="EditUserConfirm.do" var="ConfirmURL"/>
		</c:otherwise>
	</c:choose>
	<form action="${ConfirmURL}" method="post" name="inputform">
		<table class="tbl_input" border="0" width="75%" cellpadding="0" cellspacing="0">
			<tr>
				<th align="left">
					<div style="padding-left:100px;">
						情報確認<br></br>
						入力された情報をＯＫボタンクリックでＤＢへ保存してください
					</div>
					<div style="padding-left:100px;">&nbsp;</div>
				</th>
			</tr>
			<tr>
				<td align="left">
					<div style="padding-left:100px;">
						<table border="1" width="70%" class="tbl_input" cellpadding="4" cellspacing="0" style="table-layout: fixed;">
							<tr>
								<td class="lbl_left">アカウント名:</td>
								<td align="left">
									<c:out value="${userInforEntity.loginName}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">グループ:</td>
								<td align="left">
									<c:out value="${userInforEntity.groupName}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">氏名:</td>
								<td align="left" style="word-wrap: break-word">
									<c:out value="${userInforEntity.fullName}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">カタカナ氏名:</td>
								<td align="left">
									<c:out value="${userInforEntity.fullNameKana}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">生年月日:</td>
								<td align="left">
									<fmt:formatDate value="${userInforEntity.birthday}" pattern="yyyy/MM/dd" />
								</td>
							</tr>
							<tr>
								<td class="lbl_left">メールアドレス:</td>
								<td align="left" style="word-wrap: break-word">
									<c:out value="${userInforEntity.email}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">電話番号:</td>
								<td align="left">
									<c:out value="${userInforEntity.tel}"/>
								</td>
							</tr>
							<tr>
								<th colspan="2"><a href="#" onclick="showHide()">日本語能力</a></th>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">資格:</td>
								<td align="left">
									<c:if test="${userInforEntity.nameLevel != ''}">
										<c:out value="${userInforEntity.nameLevel}"/>
									</c:if>
								</td>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">資格交付日:</td>
								<td align="left">
									<c:if test="${userInforEntity.nameLevel != ''}">
										<fmt:formatDate value="${userInforEntity.startDate}" pattern="yyyy/MM/dd" />
									</c:if>
								</td>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">失効日:</td>
								<td align="left">
									<c:if test="${userInforEntity.nameLevel != ''}">
										<fmt:formatDate value="${userInforEntity.endDate}" pattern="yyyy/MM/dd" />
									</c:if>
								</td>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">点数:</td>
								<td align="left">
									<c:if test="${userInforEntity.nameLevel != ''}">
										<c:out value="${userInforEntity.total}"/>
									</c:if>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<div style="padding-left:100px;">&nbsp;</div>
		<!-- Begin vung button -->
		<div style="padding-left:45px;">
			<table border="0" cellpadding="4" cellspacing="0" width="300px">
				<tr>
					<th width="200px" align="center">&nbsp;</th>
					<td>
						<input class="btn" type="submit" value="OK" />
					</td>
					<td>
					<c:url value="AddUserInput.do" var="backURL">
			                <c:param name="type" value="BACK" />
			                <c:param name="keyUser" value="${param.keyUser}" />
            			</c:url>
						<input class="btn" type="button" value="戻る" onclick="location.href='${backURL}'"/>
					</td>
				</tr>
			</table>
		</div>
		<!-- End vung button -->
	</form>
	<!-- End vung input -->

	<!-- Begin vung footer -->
	<jsp:include page="footer.jsp" />
	<!-- End vung footer -->
</body>

</html>