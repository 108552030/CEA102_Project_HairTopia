<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.chat.model.*"%>
<%@ page import="java.util.*"%>

<%-- <% --%>
<!-- // 	TransRecService transRecSvc = new TransRecService(); -->
<!-- // 	List<TransRecVO> list = transRecSvc.getAll(); -->
<!-- // 	pageContext.setAttribute("list", list); -->
<%-- %> --%>

<jsp:useBean id="chatSvc" scope="page"
	class="com.chat.model.ChatService" />
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
			<th>聊天編號</th>
			<th>發送會員</th>
			<th>接受會員</th>
			<th>內容</th>
			<th>訊息時間</th>
			<th>已讀</th>
			<th>圖片</th>

		</tr>


		<c:forEach var="chatVO" items="${chatSvc.all}">
			<tr>
				<td>${chatVO.chatNo}</td>
				<td><c:forEach var="memVO" items="${memSvc.all}">
						<c:if test="${chatVO.chatSender == memVO.memNo}">
	                    	${memVO.memName}
                    	</c:if>
					</c:forEach></td>
				<td><c:forEach var="memVO" items="${memSvc.all}">
						<c:if test="${chatVO.chatReceiver == memVO.memNo}">
	                    	${memVO.memName}
                    	</c:if>
					</c:forEach></td>
				<td>${chatVO.chatText}</td>
				<%
					ChatVO chatVO = (ChatVO) pageContext.getAttribute("chatVO");
				%> 
				<td>
				<fmt:formatDate value="${chatVO.chatTime}" pattern="yyyy-MM-dd  HH:mm:ss"/>
				</td>
				<td>
<%-- 					${chatVO.chatIsRead} --%>
				<%=(chatVO.getChatIsRead() == true) ? "已讀" : "未讀"%>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>