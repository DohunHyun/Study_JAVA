<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies) {
%>
쿠키 내용 : <%=c.getName() %><br>
쿠키 값 : <%=c.getValue() %><br>
<hr>
<% } %>
</body>
</html>