<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<h3>상품 목록</h3>
<table border="1">
	<tr>
		<th>상품 코드</th>
		<th>상품명</th>
		<th>재고 수량</th>
	</tr>
	<c:forEach items="${pList}" var="p">
		<tr>
			<td>${p.pcode}</td>
			<td>${p.pname}</td>
			<td>${p.pquantity}</td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>