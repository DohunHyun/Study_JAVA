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
		<script type="text/javascript" src="./my_js/profile.js"></script>
		<link rel="stylesheet" href="assets/css/main.css" />
	
		<script type="text/javascript">
		function modify() {
			if(document.getElementById("modifyid").value == "") {
				alert("아이디 입력!!!");
				return;
			} else if(document.getElementById("modifypwd").value == "") {
				alert("비밀번호 입력!!!");
				return;
			} else if(document.getElementById("modifyname").value == "") {
				alert("이름 입력!!!");
				return;
			} else if(document.getElementById("modifyname").value == "") {
				alert("이름 입력!!!");
				return;
			}else {
				document.getElementById("modifyform").action = "${root}/profilemodify";
				document.getElementById("modifyform").submit();
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
										
										<c:if test="${empty loginInfo}">
										<button type="button" id="login_btn" class="btn" onClick="location.href='${root}/login'">
											login
										</button>
										<button type="button" id="joinin_btn" class="btn" onClick="location.href='${root}/join'">
											Join in
										</button>
										</c:if>
										<c:if test="${not empty loginInfo}">
										<button type="button" id="logout_btn" class="btn" onClick="location.href='${root}/logout'">
											logout
										</button>
										<button type="button" id="profile_btn" class="btn" onClick="location.href='${root}/profile'">
											profile
										</button>
										</c:if>
									</ul>
								</header>

                <section>
									<header class="major">
										<h2>Profile</h2>
										<p>회원 정보 수정</p>
									</header>
									<form action="" id="modifyform" method="post">
									<h4>ID: </h4><input type="text" name="userid" id="modifyid" value="${loginInfo.userid}">
									<h4>PW: </h4><input type="password" name="userpwd" id="modifypwd" value="${loginInfo.userpwd}">
									<h4>NAME: </h4><input type="text" name="username" id="modifyname" value="${loginInfo.username}">
									<h4>EMAIL: </h4><input type="text" name="email" id="modifyemail" value="${loginInfo.email}">
<!-- 								<h4>Prefer Area: </h4><input type="text" name="modifypreferarea" id="modifypreferarea"> -->
									<button type="button" value="check" class="m-2" onclick="javascript:modify();">수정</button><br>
									 
									<div id="info"></div>
									<div id="modify"></div>
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