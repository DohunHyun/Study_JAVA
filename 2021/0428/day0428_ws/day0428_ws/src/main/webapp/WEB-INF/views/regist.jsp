<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#registForm>label {
	display: inline-block;
	width: 100px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<script>
	let isSubmit = false;
	$(function(){
		$('#code').blur(function(){
			console.log($(this).val());
			$.ajax({
				url: '${ctx}/pcodeCheck?pCode='+$(this).val(),
				method:'get',
				dataType:'text', // 지금 보낸 요청에 어떤 데이터가 응답으로 오나
				success:function(result){
					if(result == 'yes'){
						$('#codeError').text('써도 됨');
						isSubmit = true;
					}else{
						$('#codeError').text('중복! 못써!');
						isSubmit = false;
					}
				}
			})
		})
		
		$('#regist').click(function(){
			if(isSubmit){
				$('#registForm').submit();
			}else{
				alert('중복 코드라 등록이 불가합니다!');
				return false;
			}
		})
	})
</script>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<h2>상품 등록</h2>
	<form method="post" action="${root }/product" id="registForm">
		<input type="hidden" id="check" name="check" value="true">
		<label for="code">상품코드:</label>
		<input type="text" name="code" id="code">
		<span id="codeError" class="error"></span><br>
		<label for="name">상품명:</label>
		<input type="text" name="name" id="name">
		<br>
		<label for="quantity">수량:</label>
		<input type="number" name="quantity" id="quantity">
		<br>
		<input type="button" value="상품등록" id="regist">
	</form>
</body>
<script>

</script>
</html>
