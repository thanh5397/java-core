<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<!-- Begin vung input-->
	<c:set value="${userInforEntity.userId}" var="userIdVariable"/>
	<c:choose>
		<c:when test="${userIdVariable == 0}">
			<c:url value="AddUserValidate.do" var="ValidateURL"/>
		</c:when>
		<c:otherwise>
			<c:url value="EditUserValidate.do" var="ValidateURL"/>
		</c:otherwise>
	</c:choose>
	<form action="${ValidateURL}" method="post" name="inputform">
		<input type="hidden" name="userId" value="${userIdVariable}"/>
		<input type="hidden" name="type" value="VALIDATE" />
		<table class="tbl_input" border="0" width="75%" cellpadding="0" cellspacing="0">
			<tr>
				<th align="left">
					<div style="padding-left:100px;">
						会員情報編集
					</div>
				</th>
			</tr>
			<c:choose>
              	<c:when test="${listError.size() > 0}">
                 	<c:forEach var="error" items="${listError}">
                      	<tr>
                          	<td class="errMsg">
	                          	<div style="padding-left:120px">
									${error}
								</div>
                           	</td>
                       	</tr>
                   	</c:forEach>
              	</c:when>
            	<c:otherwise>
                   	<tr>
                     	<td class="errMsg">
							<div style="padding-left:120px">
								&nbsp;
							</div>
						</td>
                   	</tr>
              	</c:otherwise>
            </c:choose>
			<tr>
				<td align="left">
					<div style="padding-left:100px;">
						<table border="0" width="100%" class="tbl_input" cellpadding="4" cellspacing="0">
							<tr>
								<td class="lbl_left">
									<font color="red">*</font> アカウント名:
								</td>
								<td align="left">
									<c:choose>
										<c:when test="${userIdVariable == 0}">
											<input id="first" class="txBox" type="text" name="loginName" value="${fn:escapeXml(userInforEntity.loginName)}" size="15"
											onfocus="this.style.borderColor='#0066ff';"
											onblur="this.style.borderColor='#aaaaaa';" />
										</c:when>
										<c:otherwise>
											<input id="first" class="txBox" type="text" name="loginName" value="${fn:escapeXml(userInforEntity.loginName)}" size="15"
											onfocus="this.style.borderColor='#0066ff';"
											onblur="this.style.borderColor='#aaaaaa';" readonly="readonly"/>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">
									<font color="red">*</font> グループ:
								</td>
								<td align="left">
									<select name="groupId">
										<option value="0">選択してください</option>
										<c:forEach var="group" items="${listGroup}">
	                                        <c:choose>
	                                            <c:when test="${group.groupId == userInforEntity.groupId}">
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
									<span>&nbsp;&nbsp;&nbsp;</span>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">
									<font color="red">*</font> 氏名:
								</td>
								<td align="left">
									<input class="txBox" type="text" name="fullName" value="${fn:escapeXml(userInforEntity.fullName)}" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" />
								</td>
							</tr>
							<tr>
								<td class="lbl_left">カタカナ氏名:</td>
								<td align="left">
									<input class="txBox" type="text" name="fullNameKana" value="${fn:escapeXml(userInforEntity.fullNameKana)}" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" />
								</td>
							</tr>
							<tr>
								<td class="lbl_left">
									<font color="red">*</font> 生年月日:
								</td>
								<td align="left">
									<select name="yearBirthday">
										<c:forEach var="yearBirth" items="${listYear}">
	                                        <c:choose>
	                                            <c:when test="${yearBirth == userInforEntity.arrBirthday.get(2) }">
	                                                <option value="${yearBirth}" selected="selected">
	                                                    <c:out value="${yearBirth}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${yearBirth}">
	                                                    <c:out value="${yearBirth}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									年
									<select name="monthBirthday">
										<c:forEach var="monthBirth" items="${listMonth}">
	                                        <c:choose>
	                                            <c:when test="${monthBirth == userInforEntity.arrBirthday.get(1) }">
	                                                <option value="${monthBirth}" selected="selected">
	                                                    <c:out value="${monthBirth}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${monthBirth}">
	                                                    <c:out value="${monthBirth}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									月
									<select name="dayBirthday">
										<c:forEach var="dayBirth" items="${listDay}">
	                                        <c:choose>
	                                            <c:when test="${dayBirth == userInforEntity.arrBirthday.get(0) }">
	                                                <option value="${dayBirth}" selected="selected">
	                                                    <c:out value="${dayBirth}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${dayBirth}">
	                                                    <c:out value="${dayBirth}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									日
								</td>
							</tr>
							<tr>
								<td class="lbl_left">
									<font color="red">*</font> メールアドレス:
								</td>
								<td align="left">
									<input class="txBox" type="text" name="email" value="${fn:escapeXml(userInforEntity.email)}" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" />
								</td>
							</tr>
							<tr>
								<td class="lbl_left">
									<font color="red">*</font>電話番号:
								</td>
								<td align="left">
									<input class="txBox" type="text" name="tel" value="${fn:escapeXml(userInforEntity.tel)}" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" />
								</td>
							</tr>
							<c:if test="${userIdVariable == 0 }">
								<tr>
									<td class="lbl_left">
										<font color="red">*</font> パスワード:
									</td>
									<td align="left">
										<input class="txBox" type="password" name="password" value="${fn:escapeXml(userInforEntity.password)}" size="30"
											onfocus="this.style.borderColor='#0066ff';"
											onblur="this.style.borderColor='#aaaaaa';" />
									</td>
								</tr>
								<tr>
									<td class="lbl_left">パスワード（確認）:</td>
									<td align="left">
										<input class="txBox" type="password" name="rePassword" value="${fn:escapeXml(userInforEntity.rePassword)}" size="30"
											onfocus="this.style.borderColor='#0066ff';"
											onblur="this.style.borderColor='#aaaaaa';" />
									</td>
								</tr>
							</c:if>
							<tr>
								<th align="left" colspan="2">
									<a href="#" onclick="showHide()">日本語能力</a>
								</th>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">資格:</td>
								<td align="left">
									<select name="codeLevel">
										<option value="0">選択してください</option>	
										<c:forEach var="japan" items="${listJapan}">
	                                        <c:choose>
	                                            <c:when test="${japan.codeLevel == userInforEntity.codeLevel}">
	                                                <option value="${japan.codeLevel}" selected="selected">
	                                                    <c:out value="${japan.nameLevel}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${japan.codeLevel}">
	                                                    <c:out value="${japan.nameLevel}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
								</td>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">資格交付日: </td>
								<td align="left">
									<select name="yearStartDate">
										<c:forEach var="yearStart" items="${listYear}">
	                                        <c:choose>
	                                            <c:when test="${yearStart == userInforEntity.arrStartDate.get(2) }">
	                                                <option value="${yearStart}" selected="selected">
	                                                    <c:out value="${yearStart}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${yearStart}">
	                                                    <c:out value="${yearStart}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									年
									<select name="monthStartDate">
										<c:forEach var="monthStart" items="${listMonth}">
	                                        <c:choose>
	                                            <c:when test="${monthStart == userInforEntity.arrStartDate.get(1) }">
	                                                <option value="${monthStart}" selected="selected">
	                                                    <c:out value="${monthStart}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${monthStart}">
	                                                    <c:out value="${monthStart}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									月
									<select name="dayStartDate">
										<c:forEach var="dayStart" items="${listDay}">
	                                        <c:choose>
	                                            <c:when test="${dayStart == userInforEntity.arrStartDate.get(0) }">
	                                                <option value="${dayStart}" selected="selected">
	                                                    <c:out value="${dayStart}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${dayStart}">
	                                                    <c:out value="${dayStart}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									日
								</td>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">失効日: </td>
								<td align="left">
									<select name="yearEndDate">
										<c:forEach var="yearEnd" items="${listYearEndDate}">
	                                        <c:choose>
	                                            <c:when test="${yearEnd == userInforEntity.arrEndDate.get(2) }">
	                                                <option value="${yearEnd}" selected="selected">
	                                                    <c:out value="${yearEnd}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${yearEnd}">
	                                                    <c:out value="${yearEnd}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									年
									<select name="monthEndDate">
										<c:forEach var="monthEnd" items="${listMonth}">
	                                        <c:choose>
	                                            <c:when test="${monthEnd == userInforEntity.arrEndDate.get(1) }">
	                                                <option value="${monthEnd}" selected="selected">
	                                                    <c:out value="${monthEnd}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${monthEnd}">
	                                                    <c:out value="${monthEnd}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									月
									<select name="dayEndDate">
										<c:forEach var="dayEnd" items="${listDay}">
	                                        <c:choose>
	                                            <c:when test="${dayEnd == userInforEntity.arrEndDate.get(0) }">
	                                                <option value="${dayEnd}" selected="selected">
	                                                    <c:out value="${dayEnd}" />
	                                                </option>
	                                            </c:when>
	                                            <c:otherwise>
	                                                <option value="${dayEnd}">
	                                                    <c:out value="${dayEnd}" />
	                                                </option>
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </c:forEach>
									</select>
									日
								</td>
							</tr>
							<tr class="lbl-level-japan" style="display:none">
								<td class="lbl_left">点数: </td>
								<td align="left">
									<input class="txBox" type="text" name="strTotal" value="${fn:escapeXml(userInforEntity.strTotal)}" size="5"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" />
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
						<input class="btn" type="submit" value="確認" />
					</td>
					<td>
						<c:choose>
							<c:when test="${userIdVariable == 0}">
								<c:url value="ListUser.do" var="backURL">
					                <c:param name="type" value="BACK" />
		            			</c:url>
							</c:when>
							<c:otherwise>
								<c:url value="ViewDetailUser.do" var="backURL">
					                <c:param name="userId" value="${userIdVariable}"/>
		            			</c:url>
							</c:otherwise>
						</c:choose>
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