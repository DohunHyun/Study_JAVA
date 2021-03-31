<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가 결과</title>
</head>
<body>
<c:if test="${not empty loginInfo}">
	반갑습니다! ${loginInfo}님! 
</c:if>
상품 추가 결과 : <%=request.getAttribute("addResult") %><br>
<a href="<%=request.getContextPath()%>/product?cmd=list">[상품 목록으로]</a>


</body>
</html>