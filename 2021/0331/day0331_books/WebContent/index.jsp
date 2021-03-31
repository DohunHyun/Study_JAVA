<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>도서 관리 사이트 입니다.</h1>
	<a href="book?cmd=list">[책 목록보기]</a>
	<a href="<%=request.getContextPath()%>/book?cmd=addForm">[책 추가하기]</a>
	<%if(session.getAttribute("loginInfo") == null) {%>
		<a href="<%=request.getContextPath()%>/book?cmd=loginForm">[로그인하기]</a>
	<%} %>
</body>
</html>