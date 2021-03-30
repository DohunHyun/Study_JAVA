<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<script type="text/javascript">
	function regist() {
		/* alert("hi"); */
		document.getElementById("registerForm").submit();
		
		// cookie 만들기 
		var id = document.getElementById("productNum").value;
		alert("id : " + id);
		
		<%
		Cookie cookie1 = new Cookie("id", id);
		Cookie cookie2 = new Cookie("name", name);
		Cookie cookie3 = new Cookie("price", price);
		%>
	}
</script>
</head>
<body>
	<form id="registerForm" method="get" action="">
		<div>
			<label>상품 번호</label>
			<input type="number" id="productNum">
		</div>
		<div>
			<label>상품 이름</label>
			<input type="text" id="productName">
		</div>
		<div>
			<label>상품 가격</label>
			<input type="number" id="productPrice">
		</div>
		<div>
			<label>상품 설명</label>
			<input type="text" id="productDesc">
		</div>
		
		<div>
			<button type="button" onclick="javascript:regist();">등록</button>
		</div>
	</form>
		
		
	
</body>
</html>