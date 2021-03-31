<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book add result.jsp</title>
</head>
<body>
<%
	String id = (String) session.getAttribute("loginInfo");
if(id!=null) {
%> 
로그인된 사용자군요! <%=id%>님 반갑습니다 <br>
<%} %>

책 추가 결과 : <%=request.getAttribute("addResult") %><br>
<a href="<%=request.getContextPath()%>/book?cmd=list">[책 목록으로]</a>

</body>
</html>