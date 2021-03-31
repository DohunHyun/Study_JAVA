<%@page import="model.BookDTO" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	String id = (String) session.getAttribute("loginInfo");
if(id!=null) {
%> 
로그인된 사용자군요! <%=id%>님 반갑습니다 <br>
<%} %>

<%
	List<BookDTO> bList = (List<BookDTO>)request.getAttribute("bookList");
%> --%>

<c:if test="${not empty loginInfo}">
	로그인된 사용자군요! ${loginInfo}님 반갑습니다 <br>
</c:if>
<table border="1">
	<thead>
		<tr>
			<td>isbn</td>
			<td>제목</td>
			<td>저자</td>
			<td>출판사</td>
			<td>가격</td>
		</tr>
	</thead>
	<tbody>
		<%-- <%if(bList == null || bList.size() == 0) { %>
			<tr>
				<td colspan="5">저장 된 책이 없습니다.</td>
			</tr>
			
		<%} else { %>
		<%		for(BookDTO b : bList) { %>
					<tr>
						<td><%=b.getIsbn() %></td>
						<td><%=b.getTitle() %></td>
						<td><%=b.getAuthor() %></td>
						<td><%=b.getPublisher() %></td>
						<td><%=b.getPrice() %></td>
					</tr>
		<%		} %>
		<%} %> --%>
		<c:if test="${empty requestScope.bookList}">
			<tr>
				<td colspan="5">저장 된 책이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty bookList}">
			<c:forEach items="${bookList}" var="b">
				<tr>
					<td>${b.isbn}</td>
					<td>${b.title}</td>
					<td>${b.author}</td>
					<td>${b.publisher}</td>
					<td>${b.price}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>

</body>
</html>