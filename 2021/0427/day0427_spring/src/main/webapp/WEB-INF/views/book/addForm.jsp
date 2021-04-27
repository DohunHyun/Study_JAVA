<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addForm.jsp</title>
</head>
<body>
	<%@include file="../member/header.jsp"%>

	<h4>새로 추가할 책 정보 입력</h4>
	<form action="<%=request.getContextPath()%>/bookAdd" method="post">
		<input type="hidden" name="act" value="add">
		ISBN : <input type="text" name="isbn" placeholder="1111"><br>
		제목 : <input type="text" name="title"><br>
		출판사 : <input type="text" name="publisher"><br>
		가격 : <input type="number" name="price"><br>
		저자 : <input type="text" name="author"><br>
		설명: <textarea rows="3" cols="20" 
			placeholder="책에대한 설명을 입력" name="description"></textarea><br>
		<input type="submit" value="작성완료">				
	</form>

</body>
</html>