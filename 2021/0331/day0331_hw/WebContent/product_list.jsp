<%@page import="model.ProductDTO"%>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<body>
<c:if test="${not empty loginInfo}">
	반갑습니다! ${loginInfo}님! 
</c:if>

<table border="1">
	<thead>
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>가격</td>
			<td>설명</td>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty requestScope.productList}">
			<tr>
				<td colspan="5">저장 된 상품이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty productList}">
			<c:forEach items="${productList}" var="p">
				<tr>
					<td>${p.serialnum}</td>
					<td>${p.title}</td>
					<td>${p.price}</td>
					<td>${p.description}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>

</body>
</html>