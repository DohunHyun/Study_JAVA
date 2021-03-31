<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_result.jsp</title>
</head>
<body>
	<% if(request.getAttribute("loginResult").equals("success")) { %>
		<script type="text/javascript">
			alert('로그인 성공!');
			location.href = 'book?cmd=list';
		</script>
	<%} else { %>
		<script type="text/javascript">
			alert('로그인 실패!');
			location.href = 'book?cmd=loginForm';
		</script>
	<%} %>
</body>
</html>