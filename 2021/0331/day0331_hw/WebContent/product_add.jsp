<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
</head>
<body>
<c:if test="${not empty loginInfo}">
	반갑습니다! ${loginInfo}님! 
</c:if>

	<form action="<%=request.getContextPath()%>/product" method="post">
		상품번호 : <input type="text" name="serialnum"><br>
		상품명 : <input type="text" name="title"><br>
		가격 : <input type="text" name="price"><br>
		설명 : <input type="text" name="description"><br>
		<input type="hidden" name="cmd" value="add"> <!-- url에 못넣으니까! post방식이라서 -->
		<input type="submit" value="작성완료">
	</form>



</body>
</html>