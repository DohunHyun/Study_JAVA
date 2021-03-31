<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리 사이트</title>
</head>
<body>
<c:if test="${not empty loginInfo}">
	반갑습니다! ${loginInfo}님! 
</c:if>
	<h1>상품 관리 사이트 입니다.</h1>
	<a href="product?cmd=list">[상품 목록보기]</a>
	<a href="<%=request.getContextPath()%>/product?cmd=addForm">[상품 추가하기]</a>
	<%if(session.getAttribute("loginInfo") == null) {%>
		<a href="<%=request.getContextPath()%>/product?cmd=loginForm">[로그인하기]</a>
	<%} %>
</body>
</html>