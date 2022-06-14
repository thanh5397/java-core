<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script language="Javascript" src="js/script.js"></script>
    <title>ユーザ管理</title>
</head>

<body>
    <form action="" name="loginForm">
        <center>
            <table class="tbl_input" cellpadding="4" cellspacing="0" width="400px">
                <tr>
                    <th width="120px">&nbsp;</th>
                    <th></th>
                </tr>
                <tr>
                    <th colspan="2" align="left">アカウント名およびパスワードを入力してください</th>
                </tr>
                <c:choose>
                    <c:when test="${listError.size() > 0}">
                        <c:forEach var="error" items="${listError}">
                            <tr>
                                <td colspan="2">${error}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                <tr align="left">
                    <td class="lbl_left">アカウント名:</td>
                    <td align="left">
                        <input id="loginName" class="txBox" type="text" name="loginName" value="${loginName}" size="20"
                            onfocus="this.style.borderColor='#0066ff';" onblur="this.style.borderColor='#aaaaaa';" />
                    </td>
                </tr>
                <tr>
                    <td class="lbl_left">パスワード:</td>
                    <td align="left">
                        <input id="password" class="txBox" type="password" name="password" value="" size="22"
                            onfocus="this.style.borderColor='#0066ff';" onblur="this.style.borderColor='#aaaaaa';" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <input class="btn btn_wider btn_login" type="button" value="ログイン" />
                    </td>
                </tr>
            </table>
        </center>
    </form>
</body>
</html>