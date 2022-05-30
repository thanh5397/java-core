<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="view/css/style.css" rel="stylesheet" type="text/css" />
    <script language="Javascript" src="view/js/script.js"></script>
    <title>ユーザ管理</title>
</head>

<body onload="setFocus()">
    <!-- Begin vung header -->
    <jsp:include page="header.jsp" />
    <!-- End vung header -->

    <!-- Begin vung dieu kien tim kiem -->
    <form action="ListUser.do" method="get">
        <input type="hidden" name="type" value="SEARCH" />
        <input type="hidden" name="currentPage" value="1" />
        <table class="tbl_input" border="0" width="90%" cellpadding="0" cellspacing="0">
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
                            <td align="left"><input id="first" class="txBox" type="text" name="fullName"
                                    value="${fn:escapeXml(fullName)}" size="20"
                                    onfocus="this.style.borderColor='#0066ff';"
                                    onblur="this.style.borderColor='#aaaaaa';" />
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="lbl_left">グループ:</td>
                            <td align="left" width="80px">
                                <select name="groupId">
                                    <option value="0">全て</option>
                                    <c:forEach var="group" items="${listGroup}">
                                        <c:choose>
                                            <c:when test="${group.groupId == groupId }">
                                                <option value="${group.groupId}" selected="selected">
                                                    <c:out value="${group.groupName}" />
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${group.groupId}">
                                                    <c:out value="${group.groupName}" />
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                            <td align="left">
                            	<input class="btn" type="submit" value="検索" />
                            	<c:url value="AddUserInput.do" var="ADM003URL"></c:url>
                                <input class="btn" type="button" value="新規追加" onclick="location.href='${ADM003URL}'" />
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <!-- End vung dieu kien tim kiem -->
    </form>
    <!-- Begin vung hien thi danh sach user -->
    <c:choose>
        <c:when test="${listUserInfor.size() > 0}">
            <c:url value="ListUser.do" var="sortURL">
                <c:param name="type" value="SORT" />
                <c:param name="fullName" value="${fullName}" />
                <c:param name="groupId" value="${groupId}" />
            </c:url>
            <table class="tbl_list" border="1" cellpadding="4" cellspacing="0" width="80%" style="table-layout: fixed;">
                <tr class="tr2">
                    <th align="center" width="20px">ID</th>
                    <th align="left">氏名
						<c:choose>
                           	<c:when test="${sortByFullName eq 'ASC' }">
                              	<a href="${sortURL}&sortType=full_name&sortByFullName=DESC"><c:out value="▲▽" /></a>
                           	</c:when>
                         	<c:otherwise>
                                <a href="${sortURL}&sortType=full_name&sortByFullName=ASC"><c:out value="△▼" /></a>
							</c:otherwise>
						</c:choose>
                    </th>
                    <th align="left">生年月日</th>
                    <th align="left">グループ</th>
                    <th align="left">メールアドレス</th>
                    <th align="left" width="70px">電話番号</th>
                    <th align="left">日本語能力
                        <c:choose>
                           	<c:when test="${sortByCodeLevel eq 'ASC' }">
                              	<a href="${sortURL}&sortType=code_level&sortByCodeLevel=DESC"><c:out value="▲▽" /></a>
                           	</c:when>
                         	<c:otherwise>
                                <a href="${sortURL}&sortType=code_level&sortByCodeLevel=ASC"><c:out value="△▼" /></a>
							</c:otherwise>
						</c:choose>
                    </th>
                    <th align="left">失効日
                      	<c:choose>
                           	<c:when test="${sortByEndDate eq 'ASC' }">
                              	<a href="${sortURL}&sortType=end_date&sortByEndDate=DESC"><c:out value="▲▽" /></a>
                           	</c:when>
                         	<c:otherwise>
                                <a href="${sortURL}&sortType=end_date&sortByEndDate=ASC"><c:out value="△▼" /></a>
							</c:otherwise>
						</c:choose>
                    </th>
                    <th align="left">点数</th>
                </tr>
                <c:forEach var="user" items="${listUserInfor}">
                    <tr>
                        <td align="right" style="word-wrap: break-word">
                        	<c:set var="userId" value="${user.userId}"></c:set>
                        	<c:url value="ViewDetailUser.do" var="ViewDetailUserURL">
                        		<c:param name="userId" value="${userId}"/>
                        	</c:url>
                            <a href="${ViewDetailUserURL}">${userId}</a>
                        </td>
                        <td style="word-wrap: break-word">
                            <c:out value="${user.fullName}" />
                        </td>
                        <td align="center">
                            <fmt:formatDate value="${user.birthday}" pattern="yyyy/MM/dd" />
                        </td>
                        <td>
                            <c:out value="${user.groupName}" />
                        </td>
                        <td style="word-wrap: break-word">
                            <c:out value="${user.email}" />
                        </td>
                        <td style="word-wrap: break-word">
                            <c:out value="${user.tel}" />
                        </td>
                        <td>
                            <c:out value="${user.nameLevel}" />
                        </td>
                        <td align="center">
                            <fmt:formatDate value="${user.endDate}" pattern="yyyy/MM/dd" />
                        </td>
                        <td align="right">
                            <c:if test="${user.total > 0}">
                            	<c:out value="${user.total}" />
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            ${message}
        </c:otherwise>
    </c:choose>

    <!-- End vung hien thi danh sach user -->

    <!-- Begin vung paging -->
    <jsp:include page="paging.jsp" />
    <!-- End vung paging -->

    <!-- Begin vung footer -->
    <jsp:include page="footer.jsp" />
    <!-- End vung footer -->

</body>

</html>