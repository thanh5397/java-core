<%@ page import="manageuser.utils.MessageProperties"%>
<%@ page import="manageuser.utils.Constant"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="func"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/user.js"></script>
<title>ユーザ管理</title>
</head>
<body>

	<!-- Begin vung header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- End vung header -->

	<!-- Begin vung dieu kien tim kiem -->
	<form action="listUser.do" method="get" name="mainform">
		<input type="hidden" name="${Constant.LISTUSER_STATUS}"
			value="${Constant.LISTUSER_TYPE_SEARCH}" />
		<table class="tbl_input" border="0" width="90%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>会員名称で会員を検索します。検索条件無しの場合は全て表示されます。</td>
			</tr>
			<tr>
				<td width="100%">
					<table class="tbl_input" cellpadding="4" cellspacing="0">
						<tr>
							<td class="lbl_left">氏名:</td>
							<td align="left"><input class="txBox" type="text"
								name="name" size="20" value="${func:escapeXml(name)}"
								onfocus="this.style.borderColor='#0066ff';"
								onblur="this.style.borderColor='#aaaaaa';" /></td>
							<td></td>
						</tr>
						<tr>
							<td class="lbl_left">グループ:</td>
							<td align="left" width="80px"><select name="group_id">
									<option value="0">全て</option>
									<c:forEach items="${mstGroup}" var="group">
										<option value="${group.getGroupId()}"
											${group.getGroupId() == group_id ? 'selected="selected"' : ''}>${group.getGroupName()}</option>
									</c:forEach>

							</select></td>
							<td align="left"><input class="btn" type="submit" value="検索" />
								<input class="btn" type="button" value="新規追加"
								onclick="location.href='addUserInput.do'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- End vung dieu kien tim kiem -->
	</form>

	<c:url value="" var="urlSort">
		<c:param name="Status" value="${Constant.LISTUSER_TYPE_SORT}" />
		<c:param name="group_id" value="${group_id}" />
		<c:param name="name" value="${name}" />
		<c:param name="sortByFullName" value="${sortByFullName}" />
		<c:param name="sortByCodeLevel" value="${sortByCodeLevel}" />
		<c:param name="sortByEndDate" value="${sortByEndDate}" />
	</c:url>

	<c:set var="displaySortFullName"
		value="${(sortByFullName eq 'ASC') ? '▲▽' :'△▼' }"></c:set>
	<c:set var="displaySortCodeLevel"
		value="${(sortByCodeLevel eq 'ASC') ? '▲▽' :'△▼' }"></c:set>
	<c:set var="displaySortEndDate"
		value="${(sortByEndDate eq 'ASC') ? '▲▽' :'△▼' }"></c:set>

	<!-- Begin vung hien thi danh sach user -->
	<table class="tbl_list" border="1" cellpadding="4" cellspacing="0"
		width="80%">

		<tr class="tr2">
			<th align="center" width="20px">ID</th>
			<th align="left">氏名 <a href="${urlSort}&sortBy=fullName">${displaySortFullName}
			</a>
			</th>
			<th align="left">生年月日</th>
			<th align="left">グループ</th>
			<th align="left">メールアドレス</th>
			<th align="left" width="70px">電話番号</th>
			<th align="left">日本語能力 <a href="${urlSort}&sortBy=codeLevel">${displaySortCodeLevel}</a>
			</th>
			<th align="left">失効日 <a href="${urlSort}&sortBy=endDate">${displaySortEndDate}</a>
			</th>
			<th align="left">点数</th>
		</tr>

		<c:choose>
			<c:when test="${listUser.size() > 0}">
				<c:forEach items="${listUser}" var="user">
					<tr>
						<td align="right" nowrap="nowrap"><a
							href="viewDetailUser.do?ID=${user.getUserId()}">${func:escapeXml(user.getUserId())}</a></td>
						<td nowrap="nowrap">${func:escapeXml(user.getFullName())}</td>
						<td align="center" nowrap="nowrap"><fmt:formatDate pattern="yyyy/MM/dd"
								value="${user.getBirthday()}" /></td>
						<td nowrap="nowrap">${func:escapeXml(user.getGroupName())}</td>
						<td nowrap="nowrap">${func:escapeXml(user.getEmail())}</td>
						<td nowrap="nowrap">${user.getTel()}</td>
						<td nowrap="nowrap">${func:escapeXml(user.getNameLevel())}</td>
						<td align="center" nowrap="nowrap"><fmt:formatDate pattern="yyyy/MM/dd"
								value="${user.getEndDate()}" /></td>
						<td align="right" nowrap="nowrap">${user.getTotal()}</td>

					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="9">${MessageProperties.getValueByKey("MSG005")}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<!-- End vung hien thi danh sach user -->


	<!-- Begin vung paging -->

	<c:url value="" var="urlPage">
		<c:param name="Status" value="${Constant.LISTUSER_TYPE_PAGING}" />
		<c:param name="group_id" value="${group_id}" />
		<c:param name="name" value="${name}" />
		<c:param name="sortBy" value="${sortBy}" />
		<c:param name="sortByFullName" value="${sortByFullName}" />
		<c:param name="sortByCodeLevel" value="${sortByCodeLevel}" />
		<c:param name="sortByEndDate" value="${sortByEndDate}" />
	</c:url>

	<table>
		<c:if test="${!(func:length(listPage) == 1 && currentPage == 1)}">
			<tr>
				<td class="lbl_paging"><c:if test="${currentPage > 3 }">
						<a href="${urlPage}&currentPage=${currentPage}&click=back"><<&nbsp;</a>
					</c:if> <c:forEach items="${listPage}" var="page">

						<c:if test="${page != currentPage }">
							<a href="${urlPage}&currentPage=${page}">${page}&nbsp;</a>
						</c:if>

						<c:if test="${page == currentPage}">${page}&nbsp;</c:if>
					</c:forEach> <c:if test="${listPage[func:length(listPage)-1] < totalPage }">
						<a href="${urlPage}&currentPage=${currentPage}&click=next">>>&nbsp;</a>
					</c:if></td>
			</tr>
		</c:if>

	</table>
	<!-- End vung paging -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>