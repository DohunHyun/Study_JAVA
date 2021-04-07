<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write success</title>
</head>
<body>
<script type="text/javascript">
	alert('글 작성이 완료되었습니다.');
	location.href="${ctx}/board?act=list";
</script>
글 작성이 완료되었습니다. 
<a href="${ctx}/board?act=list">[목록으로 돌아가기]</a>

</body>
</html>