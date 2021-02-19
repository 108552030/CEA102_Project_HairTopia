<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.notification.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<%-- <% --%>
<!-- // 	TransRecService transRecSvc = new TransRecService(); -->
<!-- // 	List<TransRecVO> list = transRecSvc.getAll(); -->
<!-- // 	pageContext.setAttribute("list", list); -->
<%-- %> --%>

<jsp:useBean id="notiSvc" scope="page"
	class="com.notification.model.NotiService" />
<jsp:useBean id="memSvc" scope="page"
	class="com.member.model.MemService" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body>
	<table>
		<tr>
			<th>提示編號</th>
			<th>提示會員</th>
			<th>提示內容</th>
			<th>發送時間</th>
			<th>讀取</th>
		</tr>


		<c:forEach var="notiVO" items="${notiSvc.all}">
			<tr>
				<td>${notiVO.notiNo}</td>
				<td><c:forEach var="memVO" items="${memSvc.all}">
						<c:if test="${notiVO.memNo == memVO.memNo}">
	                    	${memVO.memName}
                    	</c:if>
					</c:forEach>
				</td>
				<td>${notiVO.notiText}</td>
				<td>${notiVO.notiTime}	
				<%
				NotiVO notiVO = (NotiVO) pageContext.getAttribute("notiVO");
				%>
				
				<td><%=(notiVO.getNotiIsRead() == true) ? "已讀" : "未讀" %></td>
				
			</tr>
		</c:forEach>

	</table>
</body>
</html>