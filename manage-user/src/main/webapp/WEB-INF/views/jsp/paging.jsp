<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Test</title>
</head>

<body>
    <table>
        <tr>
            <td class="lbl_paging">
                <c:if test="${listPaging.size() > 0}">
                    <c:url value="ListUser.do" var="pagingURL">
                        <c:param name="type" value="PAGING" />
                        <c:param name="fullName" value="${fn:escapeXml(fullName)}" />
                        <c:param name="groupId" value="${fn:escapeXml(groupId)}" />
                        <c:param name="sortType" value="${fn:escapeXml(sortType)}" />
                        <c:param name="sortByFullName" value="${fn:escapeXml(sortByFullName)}" />
                        <c:param name="sortByCodeLevel" value="${fn:escapeXml(sortByCodeLevel)}" />
                        <c:param name="sortByEndDate" value="${fn:escapeXml(sortByEndDate)}" />
                    </c:url>
                    <c:if test="${listPaging.get(0) > 3}">
                        <a href="${pagingURL}&currentPage=${listPaging.get(0) - 3}">&lt;&lt;</a> &nbsp;
                    </c:if>
                    <c:forEach var="page" items="${listPaging}">
                        <a href="${pagingURL}&currentPage=${page}">${page}</a> &nbsp;
                    </c:forEach>
                    <c:if test="${listPaging.get(listPaging.size() - 1) < totalPage}">
                        <a href="${pagingURL}&currentPage=${listPaging.get(0) + 3}">&gt;&gt;</a>
                    </c:if>
                </c:if>
            </td>
        </tr>
    </table>
</body>

</html>