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
	String userId = "ssafy";
	Cookie cookie = new Cookie("remeberMe", userId);
	response.addCookie(cookie);
%>
쿠키 생성 완료!

</body>
</html>