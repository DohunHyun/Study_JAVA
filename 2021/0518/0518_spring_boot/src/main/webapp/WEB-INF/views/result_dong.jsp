<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="${root}/assets/css/main.css" />
    <style>
        #map {
            height: 100%;
        }

        .invisible {
            display: none;
        }

        .visible {
            display: '';
        }
    </style>
    <script defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxYZb-KZJZA7ehSj9UbM0vlpMRNtKxSko&callback=initMap&libraries=&v=weekly"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function getContextPath() {
            var hostIndex = location.href.indexOf( location.host ) + location.host.length;
            return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
        }

        let map;

        $(function () {
            $('#dongSelect').change(function () {
                $('#aptList').children().removeClass('visible');
                $('#aptList').children().addClass('invisible');
                // $(this).removeClass('invisible');
                // $(this).addClass('visible');
                // $('#aptList').find(this).removeClass('invisible');
                // $('#aptList').children(find(this.value)).addClass('visible');

                $('#aptList').children('[id=' + this.value + ']').removeClass('invisible');
                $('#aptList').children('[id=' + this.value + ']').addClass('visible');
                console.log($('#aptList').find('[id=' + this.value + ']'));

            });

        })


        function initMap() {
            map = new google.maps.Map(document.getElementById("map"), {
                center: {
                    lat: 37.4693991197085,
                    lng: 126.8656255197085
                },
                zoom: 13
            });
            var marker = new google.maps.Marker({
                position: { lat: 37.5012743, lng: 127.039585 },
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
                            position: { lat: 37.5011233, lng: 127.032385 },
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

                $('marker')
                // https://maps.googleapis.com/maps/api/geocode/json?address=서울+강남구+역삼동+테헤란로+212&key=AIzaSyBxYZb-KZJZA7ehSj9UbM0vlpMRNtKxSko
            })

            $('#btn-search').click(function(){
                alert($('#dongSelect option:selected').val());
                let key = $('#dongSelect option:selected').val();
                location.href=getContextPath()+"/house?act=searchDong&dong="+key;

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

            <!-- Banner -->
            <section id="banner">
                <div class="content">
                    <header>
                        <h1>동 검색 결과</h1>
                        <p>${word} 로 검색한 동 결과 입니다.</p>
                    </header>
                    <div id="dongList">
                        <p> 동 이름 | 아파트 이름 | 거래 금액 | 지역 | 층 | 지번 | 타입</p>

                        <ul id="GMdong" class="visible">
                            <c:if test="${not empty searchResult}">
                                <c:forEach items="${searchResult}" var="h">
                                    <li>
                                        <p>${h.dong} | ${h.aptName}| ${h.dealAmount} | ${h.area} | ${h.floor} | ${h.jibun} | ${h.type}</p>

                                    </li>
                                </c:forEach>
                            </c:if>
                        </ul>
                    </div>

                </div>
                <span class="image object">
                        <div id="map"></div>
                    </span>
               
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
                <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a
                        href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5
                    UP</a>.</p>
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