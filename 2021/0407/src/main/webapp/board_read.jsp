<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	function getCmtList() {
		$.ajax({
			url:'${ctx}/ajax',
			data:{'act':'cmtList', 'bnum':'${boardDto.bnum}'},
			method: 'get',
			success:function(data) {
				let table = '<table>';
				$.each(data, function(idx, cmt) {
					table += '<tr border="1">';
					table += '<td>' + cmt['cwriter'] + '</td>';
					table += '<td>' + cmt['ccontent'] + '</td>';
					table += '</tr>';
				})
				table += '</table>';
				
				$('#cmt-area').html(table);
			}
		})
	}
	$(function() {
		getCmtList();
		
		$('#cmt-btn').click(function() {
			$.ajax({
				url:'${ctx}/ajax',
				data:{
					'act' : 'cmtWrite', 
					'bnum' : '${boardDto.bnum}', 
					'cwriter' : $('#cmt-writer').val(), 
					'ccontent' : $('#cmt-content').val()
					},
				method:'post',
				success:function() {
					if(data == 'success') {
						alert('댓글작성완료!');
						getCmtList();
					} else if(data == 'fail') {
						alert('댓글작성 실패!');						
					} else {
						alert('무슨 상황?!');												
					}
				}
			})
		})
		
	})
</script>
</head>
<body>
<table border="1">
		<tr>
			<td>제목</td>
			<td>${boardDto.btitle}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${boardDto.bwriter}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${boardDto.bcontent}</td>
		</tr>
		<a href="${ctx}/board?act=list">[목록으로 돌아가기]</a>
		
		<div id="cmt-area">
		
		</div>
		
		<div id="cmt-write-area">
			댓글작성자 : <input type="text" id="cmt-writer" placeholder="이름을 쓰세요"><br>
			댓글내용 : <input type="text" id="cmt-content" placeholder="댓글내용을 쓰세요"><br>
			<button id="cmt-btn">댓글작성</button>
		</div>
</table>
</body>
</html>