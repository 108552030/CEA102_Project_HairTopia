<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ page import="com.rule.model.*"%>
<%@ page import="java.util.*"%>

<%
	RuleService rulSvc = new RuleService();
	List<RuleVO> list = rulSvc.getAll();
	pageContext.setAttribute("list", list);
%>

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
		<th>規則編號</th>
		<th>規則標題</th>
		<th>新聞內容</th>

	</tr>
		

	<c:forEach var="ruleVO" items="${list}">
		<tr>
			<td>${ruleVO.ruleNo}</td>
			<td>${ruleVO.ruleName}</td>
			<td>${ruleVO.ruleCon}</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>