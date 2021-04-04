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
        <%--location.href='${root}/notice?act=createNotice'--%>

        function writeArticle() {
            if (document.getElementById("subject").value == "") {
                alert("제목 입력!!!!");
                return;
            } else if (document.getElementById("content").value == "") {
                alert("내용 입력!!!!");
                return;
            } else if (document.getElementById("noticePwd").value == "") {
                alert("비밀번호 입력!!!!");
                return;
            } else {
                document.getElementById("writeform").action = "${root}/notice";
                document.getElementById("writeform").submit();
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
                    <button type="button" id="joinin_btn" class="btn" onclick="javascript:writeArticle();">
                        글 등록
                    </button>
                </ul>

            </header>

            <section id="banner">
                <div class="col-lg-6" align="center">
                    <h2>공지사항 작성</h2>
                    <form id="writeform" method="post" action="">
                        <input type="hidden" name="act" id="act" value="write">
                        <div class="form-group" align="left">
                            <label for="subject">제목:</label>
                            <input type="text" class="form-control" id="subject" name="subject">
                        </div>
                        <div class="form-group" align="left">
                            <label for="content">내용:</label>
                            <textarea class="form-control" rows="15" id="content" name="content"></textarea>
                        </div>
                        <div class="form-group" align="left">
                            <label for="subject">비밀번호 설정:</label>
                            <input type="password" class="form-control" id="noticePwd" name="noticePwd">
                        </div>
                        <p>비밀번호를 설정하지 않으면 아무나 해당글을 수정 / 삭제가 가능합니다!</p>
                    </form>
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
                    <li><a href="index.jsp">메인 페이지</a></li>
                    <li>
                        <span class="opener">매매 정보</span>
                        <ul>
                            <li><a href="${root}/house?act=mvdong">동별 검색</a></li>
                            <li><a href="${root}/house?act=mvapt">아파트별 검색</a></li>
                        </ul>
                    </li>
                    <li><a href="profile.jsp">회원 정보 확인</a></li>
                    <li><a href="notice.jsp">공지사항</a></li>
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