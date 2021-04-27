<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 전체목록 화면</title>
</head>
<body>
<%@ include file="../member/header.jsp" %>
	<c:choose>
		<c:when test="${empty bList}">
			<h2>저장된 책이 없습니다용</h2>
		</c:when>
		<c:otherwise>
		<form action="<%=request.getContextPath()%>/book" method="post">
			<input type="hidden" name="act" value="delete">
			<table border="1">
				<tr>
					<th>디비PK</th>
					<th>ISBN</th>
					<th>제목</th>
					<th>저자</th>
					<th>출판사</th>
					<th>가격</th>
				</tr>
				<c:forEach items="${bList}" var="b">
					<tr>
						<td>${b.bnum}</td>
						<td>${b.isbn}</td>
						<td>${b.title}</td>
						<td>${b.author}</td>
						<td>${b.publisher}</td>
						<td>${b.price}</td>
						<td><input type="checkbox" name="delNum" value="${b.bnum}"></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="삭제해버려!!">
		</form>
		</c:otherwise>
	</c:choose>
	<a href="<%=request.getContextPath()%>/bookAdd">[책 추가하고시퍼염]</a>
</body>
</html>