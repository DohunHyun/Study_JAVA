<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<script type="text/javascript">
	alert('글 수정이 완료되었습니다.');
	let v = '${msg}';
	location.href='${ctx}/list';
</script>

</body>
</html>