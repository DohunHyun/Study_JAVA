<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${ctx}/board" method="post">
	<input type="hidden" name="act" value="write">
	<table>
		<tr>
			<td>제목</td>
			<td><input name="btitle" type="text" placeholder="글 제목 입력하세요"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input name="bwriter" type="text" placeholder="글 제목 입력하세요"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><textarea rows="20" cols="30"  name="bcontent"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="작성완료"></td>
		</tr>
		
	</table>


</form>

</body>
</html>