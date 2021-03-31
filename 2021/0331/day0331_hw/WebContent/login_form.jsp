<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h3>여기는 로그인 화면입니다.</h3>
<form action="<%=request.getContextPath()%>/product" method="post">
	ID : <input type="text" name="userId"><br>
	PW : <input type="password" name="userPw"><br>
	<input type="hidden" name="cmd" value="login">
	<input type="submit" value="LOGIN">
</form>
</body>
</html>