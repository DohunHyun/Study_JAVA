<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addForm</title>
</head>
<body>
<h1>Welcome To SSAFY</h1>
<h3>상품 등록</h3>
<h4>새로 추가할 상품 정보 입력</h4>
	<form action="<%=request.getContextPath()%>/productAdd" method="post">
		<input type="hidden" name="act" value="add">
		serialnum : <input type="text" name="serialnum" placeholder="1111"><br>
		제목 : <input type="text" name="title"><br>
		가격 : <input type="number" name="price"><br>
		설명: <textarea rows="3" cols="20" 
			placeholder="상품에 대한 설명을 입력" name="description"></textarea><br>
		<input type="submit" value="작성완료">				
	</form>
	<a href="<%=request.getContextPath()%>/productList">상품 목록으로 </a>
</body>
</html>