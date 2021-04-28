<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<h2>상품목록</h2>
	<table border="1">
		<thead>
			<tr>
				<td>상품 코드</td>
				<td>상품명</td>
				<td>재고 수량</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty productList}">
				<c:forEach items="${productList}" var="p">
					<tr>
						<td>${p.code}</td>
						<td>${p.name}</td>
						<td>${p.quantity}</td>
					</tr>			
				</c:forEach>
			</c:if>
			<c:if test="${empty productList}">
				<tr>
					<td colspan="3">등록된 상품이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</body>
</html>