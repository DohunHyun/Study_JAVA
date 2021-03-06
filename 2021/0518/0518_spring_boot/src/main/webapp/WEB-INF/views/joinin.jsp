<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>HAPPY HOUSE</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript" src="./my_js/joinin.js"></script>
		<link rel="stylesheet" href="assets/css/main.css" />
		<script type="text/javascript">
		function join() {
			if(document.getElementById("joinid").value == "") {
				alert("아이디 입력!!!");
				return;
			} else if(document.getElementById("joinpwd").value == "") {
				alert("비밀번호 입력!!!");
				return;
			} else if(document.getElementById("joinname").value == "") {
				alert("이름 입력!!!");
				return;
			}else {
				document.getElementById("joinform").action = "${root}/join";
				document.getElementById("joinform").submit();
			}
		}
		</script>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="${root}/" class="logo"><strong>HAPPY</strong> HOUSE</a>
									<ul class="icons">
										<button type="button" id="joinin_btn" class="btn" onClick="location.href='${root}/login'">
											Login
										</button>
									</ul>
								</header>

                <section>
									<header class="major">
										<h2>JOIN</h2>
									</header>

                  <form action="" id="joinform" method="post">
                  <input type="hidden" name="act" id="act" value="join">
                    <div class="form-group">
                      <label for="join_id">ID:</label>
                      <input type="text" class="form-control" placeholder="Enter ID" name="userid" id="joinid">
                      <button id="btn-id-check" class="mt-2">Check ID</button><br>
                    </div>
                    <div class="form-group">
                      <label for="join_pwd">Password:</label>
                      <input type="password" class="form-control" placeholder="Enter password" name = "userpwd" id="joinpwd">
                    </div>
                    <div class="form-group">
                      <label for="join_name">Name:</label>
                      <input type="text" class="form-control" placeholder="Enter name" name="username" id="joinname">
                    </div>
                    <div class="form-group">
                      <label for="join_email">Email address:</label>
                      <input type="email" class="form-control" placeholder="Enter email" name="email" id="joinemail">
                    </div>
                 
                    
                    <button type="button" class="btn" onclick="javascript:join();">Join in</button>
                  </form>
                </section>
						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>
								</section>

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="${root}/">메인 페이지</a></li>
										<li>
											<span class="opener">매매 정보</span>
											<ul>
												<li><a href="${root}/house/search/dong">동별 검색</a></li>
												<li><a href="${root}/house/search/apt">아파트별 검색</a></li>
											</ul>
										</li>
										<li><a href="${root}/profile">회원 정보 확인</a></li>
										<c:if test="${loginInfo ne null}">
										<li><a href="${root}/notice?act=getNotice">공지사항</a></li>
										</c:if>
									</ul>
								</nav>

							

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="${root}/assets/js/jquery.min.js"></script>
			<script src="${root}/assets/js/browser.min.js"></script>
			<script src="${root}/assets/js/breakpoints.min.js"></script>
			<script src="${root}/assets/js/util.js"></script>
			<script src="${root}/assets/js/main.js"></script>



	</body>
</html>