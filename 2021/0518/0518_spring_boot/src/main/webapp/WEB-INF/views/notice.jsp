<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="./my_js/modal_login.js"></script> -->
    <link rel="stylesheet" href="assets/css/main.css"/>
    <style>
        #map {
            height: 500px;
        }
    </style>
    <script defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxYZb-KZJZA7ehSj9UbM0vlpMRNtKxSko&callback=initMap&libraries=&v=weekly"></script>
    <script>
        function writeArticle() {
            alert(1);
            let key = $('#dongSelect option:selected').val();
            location.href=getContextPath()+"/house?act=searchDong&dong="+key;
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
                    <button type="button" id="joinin_btn" class="btn"
                            onClick="location.href='${root}/notice?act=mvwrite'">
                        글 작성
                    </button>
                </ul>

            </header>

            <section id="banner">
                <div class="content">
                    <header>
                        <h1>HAPPY HOUSE NOTICE</h1>
                        <p>HAPPY HOUSE의 공지사항입니다. </p>
                        <p>가입한 사용자만 글을 작성할 수 있습니다. </p>
                    </header>
                </div>
                <div class="container">
                    <table class="table text-center">
                        <thead class="thead-light">
                        <tr>
                            <th>글 번호</th>
                            <th>제 목</th>
                            <th>작성자</th>
                            <th>등록일시</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty noticeList}">
                            <c:forEach items="${noticeList}" var="n">
                                <tr>
                                    <td>${n.articleno}</td>
                                    <td onclick="${root}/notice?act=mvwrite"><a class="txtlink">${n.subject}</a></td>
                                    <td>${n.content}</td>
                                    <td>${n.regtime}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </section>

        </div>
    </div>

    <!-- Sidebar -->
    <div id="sidebar">
        <div class="inner">

            <!-- Search -->
            <section id="search" class="alt">
                <form method="post" action="#">
                    <input type="text" name="query" id="query" placeholder="Search"/>
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
                <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>.
                    Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
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