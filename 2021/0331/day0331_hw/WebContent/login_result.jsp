<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인결과</title>
</head>
<body>
	<%-- <% if(request.getAttribute("loginResult").equals("success")) { %>
		<script type="text/javascript">
			alert('로그인 성공!');
			location.href = 'book?cmd=list';
		</script>
	<%} else { %>
		<script type="text/javascript">
			alert('로그인 실패!');
			location.href = 'book?cmd=loginForm';
		</script>
	<%} %> --%>
	
	<c:if test="${loginInfo eq 'success'}">
		<script type="text/javascript">
			alert('로그인 성공!');
			location.href = 'product?cmd=list';
		</script>
	</c:if>
	<c:if test="${loginInfo ne 'success'}">
		<script type="text/javascript">
			alert('로그인 실패!');
			location.href = 'product?cmd=loginForm';
		</script>
	</c:if>
	
	
</body>
</html>