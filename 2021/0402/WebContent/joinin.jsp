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
			} else if(document.getElementById("joinphone").value == "") {
				alert("번호 입력!!!");
				return;
			} else if(document.getElementById("joinaddress").value == "") {
				alert("주소 입력!!!");
				return;
			} else if(document.getElementById("joinpreferarea").value == "") {
				alert("선호지역 입력!!!");
				return;
			} else {
				document.getElementById("joinform").action = "${root}/user";
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
									<a href="index.jsp" class="logo"><strong>HAPPY</strong> HOUSE</a>
									<ul class="icons">
										<button type="button" id="joinin_btn" class="btn" onClick="location.href='./login.jsp'">
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
                      <input type="text" class="form-control" placeholder="Enter ID" name="joinid" id="joinid">
                      <button id="btn-id-check" class="mt-2">Check ID</button><br>
                    </div>
                    <div class="form-group">
                      <label for="join_pwd">Password:</label>
                      <input type="password" class="form-control" placeholder="Enter password" name = "joinpwd" id="joinpwd">
                    </div>
                    <div class="form-group">
                      <label for="join_name">Name:</label>
                      <input type="text" class="form-control" placeholder="Enter name" name="joinname" id="joinname">
                    </div>
                    <div class="form-group">
                      <label for="join_phone">Phone:</label>
                      <input type="text" class="form-control" placeholder="Enter phone" name="joinphone" id="joinphone">
                    </div>
                    <div class="form-group">
                      <label for="join_email">Email address:</label>
                      <input type="email" class="form-control" placeholder="Enter email" name="joinemail" id="joinemail">
                    </div>
                    <div class="form-group">
                      <label for="join_address">address:</label>
                      <input type="text" class="form-control" placeholder="Enter address" name="joinaddress" id="joinaddress">
                    </div>
                    <div class="form-group">
                    	<label for="join_prefer_area">Prefer Area:</label>
                    	<input type="text" class="form-control" placeholder="Enter prefer area" name="joinpreferarea" id="joinpreferarea">
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
										<li><a href="index.jsp">메인 페이지</a></li>
										<li>
											<span class="opener">매매 정보</span>
											<ul>
												<li><a href="search_dong.jsp">동별 검색</a></li>
												<li><a href="search_apart.jsp">아파트별 검색</a></li>
											</ul>
										</li>
										<li><a href="profile.jsp">회원 정보 확인</a></li>
									</ul>
								</nav>

							<!-- Section -->
								<!-- <section>
									<header class="major">
										<h2>Ante interdum</h2>
									</header>
									<div class="mini-posts">
										<article>
											<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
									</div>
									<ul class="actions">
										<li><a href="#" class="button">More</a></li>
									</ul>
								</section> -->

							<!-- Section -->
								<!-- <section>
									<header class="major">
										<h2>Get in touch</h2>
									</header>
									<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
										<li class="icon solid fa-phone">(000) 000-0000</li>
										<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
									</ul>
								</section> -->

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>



	</body>
</html>