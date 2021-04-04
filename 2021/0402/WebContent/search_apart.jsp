<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" href="assets/css/main.css"/>
    <style>
        #map {
            height: 100%;
        }
    </style>
    <script defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxYZb-KZJZA7ehSj9UbM0vlpMRNtKxSko&callback=initMap&libraries=&v=weekly"></script>
    <script>
        let map;

        function initMap() {
            map = new google.maps.Map(document.getElementById("map"), {
                center: {
                    lat: 37.4693991197085,
                    lng: 126.8656255197085
                },
                zoom: 13
            });
            var marker = new google.maps.Marker({
                position: {lat: 37.5012743, lng: 127.039585},
                map: map
            });

            $.getJSON('아파트매매실거래자료현황.json', function (data) {
                $.each(data, function (index, item) {
                    var urlFront = 'https://maps.googleapis.com/maps/api/geocode/json?address=';
                    var urlBack = '&key=AIzaSyBxYZb-KZJZA7ehSj9UbM0vlpMRNtKxSko';
                    var urlMid = '경기도+광명시+' + item.LEGALDONG_NM + '+' + item.LOTNO;
                    var url = urlFront + urlMid + urlBack;

                    // console.log(url);

                    $.getJSON(url, function (data) {
                        // console.log(data.results[0].geometry.location);
                        $.each(data, function (index, item) {
                            // console.log(JSON.stringify(item));
                            // console.log(item[0].geometry.location.lat);

                            // console.log('lat : ' + item.geometry.location.lat);
                            var marker = new google.maps.Marker({
                                position: {
                                    lat: item[0].geometry.location.lat,
                                    lng: item[0].geometry.location.lng
                                },
                                map: map
                            })
                        })

                        var marker = new google.maps.Marker({
                            position: {lat: 37.5011233, lng: 127.032385},
                            map: map
                        });
                    })
                })

                $.ajax({
                    url: '아파트매매실거래자료현황.json',
                    type: 'GET',
                    contentType: 'application/json;charset=utf-8',
                    dataType: 'json',
                    success: function (data) {
                        $.each(data, function (index, item) {
                            if ($('#dongSelect').find(item.LEGALDONG_NM)) {
                            } else {
                                $('#dongSelcet').append(item.LEGALDONG_NM)
                            }
                        })
                    },
                    error: function (xhr, status, msg) {
                        console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
                    }
                })
                // https://maps.googleapis.com/maps/api/geocode/json?address=서울+강남구+역삼동+테헤란로+212&key=AIzaSyBxYZb-KZJZA7ehSj9UbM0vlpMRNtKxSko
            })
            function getContextPath() {
                var hostIndex = location.href.indexOf( location.host ) + location.host.length;
                return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
            }
            $('#btn-search').click(function () {
                let key = $('#aptSelect').val();
                location.href = getContextPath() + "/house?act=searchApt&apt=" + key;
            })
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
                    <c:if test="${userinfo eq null}">
										<button type="button" id="login_btn" class="btn" onClick="location.href='${root}/user?act=mvlogin'">
											login
										</button>
										<button type="button" id="joinin_btn" class="btn" onClick="location.href='${root}/user?act=mvjoin'">
											Join in
										</button>
										</c:if>
										<c:if test="${userinfo ne null}">
										<button type="button" id="logout_btn" class="btn" onClick="location.href='${root}/user?act=logout'">
											logout
										</button>
										<button type="button" id="profile_btn" class="btn" onClick="location.href='${root}/user?act=mvprofile'">
											profile
										</button>
										</c:if>
                </ul>
            </header>

            <!-- Banner -->
            <section id="banner">
                <div class="content">
                    <header>
                        <h2>아파트 이름으로 검색하기<br/>
                            HAPPY HOUSE</h2>
                        <p>아파트 매물을 아파트 이름별로 조회해보세요.</p>
                    </header>
                    <input id="aptSelect">

                    </input>
                    <p></p>
                    <ul id="btn-search" class="actions">
                        <li><a href="#" class="button big">Search</a></li>
                    </ul>
                </div>
                <span class="image object">
										<div id="map"></div>
									</span>
                <!-- <span class="image object">
                    <img src="images/pic10.jpg" alt="" />
                </span> -->
            </section>

            <!-- Section -->
            <!-- <section>
                <header class="major">
                    <h2>Erat lacinia</h2>
                </header>
                <div class="features">
                    <article>
                        <span class="icon fa-gem"></span>
                        <div class="content">
                            <h3>Portitor ullamcorper</h3>
                            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        </div>
                    </article>
                    <article>
                        <span class="icon solid fa-paper-plane"></span>
                        <div class="content">
                            <h3>Sapien veroeros</h3>
                            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        </div>
                    </article>
                    <article>
                        <span class="icon solid fa-rocket"></span>
                        <div class="content">
                            <h3>Quam lorem ipsum</h3>
                            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        </div>
                    </article>
                    <article>
                        <span class="icon solid fa-signal"></span>
                        <div class="content">
                            <h3>Sed magna finibus</h3>
                            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        </div>
                    </article>
                </div>
            </section> -->

            <!-- Section -->
            <!-- <section>
                <header class="major">
                    <h2>Ipsum sed dolor</h2>
                </header>
                <div class="posts">
                    <article>
                        <a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
                        <h3>Interdum aenean</h3>
                        <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        <ul class="actions">
                            <li><a href="#" class="button">More</a></li>
                        </ul>
                    </article>
                    <article>
                        <a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
                        <h3>Nulla amet dolore</h3>
                        <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        <ul class="actions">
                            <li><a href="#" class="button">More</a></li>
                        </ul>
                    </article>
                    <article>
                        <a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
                        <h3>Tempus ullamcorper</h3>
                        <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        <ul class="actions">
                            <li><a href="#" class="button">More</a></li>
                        </ul>
                    </article>
                    <article>
                        <a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
                        <h3>Sed etiam facilis</h3>
                        <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        <ul class="actions">
                            <li><a href="#" class="button">More</a></li>
                        </ul>
                    </article>
                    <article>
                        <a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
                        <h3>Feugiat lorem aenean</h3>
                        <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        <ul class="actions">
                            <li><a href="#" class="button">More</a></li>
                        </ul>
                    </article>
                    <article>
                        <a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
                        <h3>Amet varius aliquam</h3>
                        <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                        <ul class="actions">
                            <li><a href="#" class="button">More</a></li>
                        </ul>
                    </article>
                </div>
            </section> -->

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