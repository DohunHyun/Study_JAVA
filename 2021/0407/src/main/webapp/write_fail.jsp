<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write fail</title>
</head>
<body>
글 작성이 실패했습니다. 
<a href="${ctx}/board?act=list">[목록으로 돌아가기]</a>

</body>
</html>