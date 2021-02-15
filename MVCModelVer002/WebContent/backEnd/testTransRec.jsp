<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.transaction_record.model.*"%>
<%@ page import="java.util.*"%>

<%-- <% --%>
<!-- // 	TransRecService transRecSvc = new TransRecService(); -->
<!-- // 	List<TransRecVO> list = transRecSvc.getAll(); -->
<!-- // 	pageContext.setAttribute("list", list); -->
<%-- %> --%>

<jsp:useBean id="transRecSvc" scope="page"
	class="com.transaction_record.model.TransRecService" />
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
			<th>交易編號</th>
			<th>交易會員</th>
			<th>交易時間</th>
			<th>交易項目</th>
			<th>交易金額</th>
			<th>餘額</th>

		</tr>


		<c:forEach var="transRecVO" items="${transRecSvc.all}">
			<tr>
				<td>${transRecVO.traNo}</td>
				<td>
					<c:forEach var="memVO" items="${memSvc.all}">
						<c:if test="${transRecVO.memNo == memVO.memNo}">
	                    	${memVO.memName}
                    	</c:if>
					</c:forEach>
				</td>
				<td>${transRecVO.traTime}</td>
				<%
				TransRecVO transRecVO = (TransRecVO) pageContext.getAttribute("transRecVO");
				%>
				<td><%=(transRecVO.getTraDes() == 1) ? "儲值":"提款"%></td>
				<td>${transRecVO.traPri}</td>
				<td>${transRecVO.traBal}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>