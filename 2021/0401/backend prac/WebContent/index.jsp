<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면 방명록!!</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
	<h3>SSAFY 방명록!!!(MVC)</h3>
	<c:if test="${userinfo eq null}">
		<%@ include file="/user/login.jsp" %>
	</c:if>
	<c:if test="${userinfo ne null}">
		<div>
			<strong>${userinfo.username}(${userinfo.email})</strong>님 환영합니다.
			<a href="${root}/main?act=logout">로그아웃</a>
		</div>
		<a href="${root}/main?act=mvwrite">글쓰기</a><br>
		<a href="${root}/main?act=list&key=&word=">글목록</a>
	</c:if>

</div>
</body>
</html>