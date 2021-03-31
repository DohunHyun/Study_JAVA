<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book_add.jsp</title>
</head>
<body>
<%
	String id = (String) session.getAttribute("loginInfo");
if(id!=null) {
%> 
로그인된 사용자군요! <%=id%>님 반갑습니다 <br>
<%} %>


	<form action="<%=request.getContextPath()%>/book" method="post">
		ISBN : <input type="text" name="isbn"><br>
		제목 : <input type="text" name="title"><br>
		저자 : <input type="text" name="author"><br>
		가격 : <input type="text" name="price"><br>
		출판사 : <input type="text" name="publisher"><br>
		<input type="hidden" name="cmd" value="add"> <!-- url에 못넣으니까! post방식이라서 -->
		<input type="submit" value="작성완료">
	</form>

</body>
</html>