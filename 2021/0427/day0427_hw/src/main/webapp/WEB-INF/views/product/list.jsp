<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome to ssafy list</title>
</head>
<body>
<h1>Welcome To SSAFY</h1>
<h3>상품 목록</h3>

<table border="1">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>가격</th>
		<th>설명</th>
	</tr>
	<c:forEach items="${pList}" var="p">
		<tr>
			<td>${p.serialnum}</td>
			<td>${p.title}</td>
			<td>${p.price}</td>
			<td>${p.description}</td>
		</tr>
	</c:forEach>
</table>
<a href="<%=request.getContextPath()%>/productAdd">[새상품 추가]</a>

</body>
</html>