<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.member.model.*"%>
<!DOCTYPE html>
<% 
	MemDAO dao = new MemDAO();
	MemVO memVO = dao.findByPrimaryKey(1);
	session.setAttribute("memVO", memVO);

%>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>

</body>
</html>