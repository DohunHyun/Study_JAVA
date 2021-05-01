<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 </title>
</head>
<body>
<%@ include file="include/header.jsp" %>

<h3>게시글 수정</h3>

<form action="${ctx}/update" method="post">
		<input type="hidden" name="act" value="update">
		<input type="hidden" name="bnum" value="${original.bnum }">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="btitle" type="text" value="${original.btitle} "></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input name="bwriter" type="text" value="${original.bwriter}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><textarea rows="20" cols="30" name="bcontent">${original.bcontent}</textarea> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
	</form>

</body>
</html>