<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Rule Test select page</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM notification: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM notification: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/notification/listAllNoti.jsp'>List</a> all Noti.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/noti/noti.do" >
        <b>輸入消息編號 (如1,2...):</b>
        <input type="text" name="notiNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="notiSvc" scope="page" class="com.notification.model.NotiService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/noti/noti.do" >
       <b>選擇條款編號:</b>
       <select size="1" name="notiNo">
         <c:forEach var="notiVO" items="${notiSvc.all}" > 
          <option value="${notiVO.notiNo}">${notiVO.notiNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/noti/noti.do" >
       <b>選擇通知:</b>
       <select size="1" name="notiNo">
         <c:forEach var="notiVO" items="${notiSvc.all}" > 
          <option value="${notiVO.notiNo}">${notiVO.notiText}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/notification/addNoti.jsp'>Add</a> a new Rule.</li>
</ul>

</body>
</html>