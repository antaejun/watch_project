<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

       <!-- 제이쿼리, bx슬라이더, home스크립트, homeCSS-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- 유어와치 UI -->
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/common.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/index.css">
    <script src="http://localhost:8088/controller/resources/vendor/bootstrap/js/index.js"></script>

    <!-- Swiper -->
    <script src="http://localhost:8088/controller/resources/vendor/bootstrap/js/swiper.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/swiper.min.css">
    
    <!-- Awesome5 Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
	
<%@ include file="../main/header.jsp" %>
<h1>WEB-INF/kitchen/Map.jsp</h1>

<style>
<!--
.sub_top{width:100%; height:226px; background:url(http://localhost:8088/controller/resources/img/chef-1209161_1280.jpg) center no-repeat; background-size: cover;}
.sub_top .menu_tit{width:1200px; margin:0 auto; text-align:center; color:#fff; line-height: 220px; font-size:2.6em; font-weight:bold;}

   .sub_top .menu_tit{width:100%;}
	.sub_top.space {margin:0 0 20px 0;}
		.sub_top{height:150px;}
    .sub_top .menu_tit{font-size:2em; line-height: 130px;}
    
        .sub_top{height:100px;}
    .sub_top .menu_tit{font-size:2em; line-height: 90px;}
-->
</style>

<title>지도 생성하기</title>

<!DOCTYPE html>
<html>
<head>
   
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>간단한 지도 표시하기</title>
  <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=a20r0s4bgz"></script>
  
<script>



var menu_total_offset;

	$(document).ready(function() {
		$('.menu li').on('mouseenter', function(){
			sub_value = $(this).attr('value');
			$('.sub_mn_wrap').hide();
			$('.sub_mn_con li').hide();
			if(sub_value == 'sub02' || sub_value == 'sub03' || sub_value == 'sub04' || sub_value == 'sub_cook'|| sub_value == 'sub06'){
				$('.sub_mn_wrap').show();
				$('.sub_mn_con .'+$(this).attr('value')).show();
			}			
		});
		$('.menu_total').on('mouseleave', function(){
			$('.sub_mn_wrap').hide();
			$('.sub_mn_con li').hide();
		});

		$('.tour_btn').click(function(){
			$('.tour_youcanbook').toggle();
		});
		$('#mask').click(function(){
			$(".mobile_menu").hide("slide", { direction: "left" }, 300);
			wrapWindowByMask();
		});

		header_offset = $('header').offset().top;
		header_height = $('header').height();
		mobile_header_height = $('.mobile_top').height();
		$( window ).scroll( function() {
		  if ( $( document ).scrollTop() > header_offset ) {
			$( '.menu_total' ).addClass( 's' );
			$( '.mobile_top' ).addClass( 's' );	
			$( '.g_nb' ).addClass( 's' );
			if($(document).width() > 767 ){
				$('.sub_top').css('margin-top',header_height+'px');
			}else{
				$('.sub_top').css('margin-top',mobile_header_height+'px');
			}
		  }else{
			$( '.menu_total' ).removeClass( 's' );
			$( '.mobile_top' ).removeClass( 's' );
			$( '.g_nb' ).removeClass( 's' );
			$('.sub_top').css('margin-top','0px');
		  }		 
		});

	});

	function topFunction() {
		$('body, html').animate({scrollTop:0}, 1000);
	}
	function m_menu_toggle(){
		if( $(".mobile_menu").css("display") == 'block' ){			
			$(".mobile_menu").hide("slide", { direction: "left" }, 300);
		}else{
			$(".mobile_menu").show("slide", { direction: "left" }, 300);
		}
		wrapWindowByMask();
	}
	function wrapWindowByMask(){
		//화면의 높이와 너비를 구한다.
		var maskHeight = $(document).height();  
		var maskWidth = $(window).width();  

		//마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
		$('#mask').css({'width':maskWidth,'height':maskHeight}); 
		//애니메이션 효과
		if(  $("#mask").css("opacity") == 0){
			$('#mask').fadeTo("slow",0.8);
			$('#mask').show();
		}else{
			$('#mask').fadeTo("slow",0);
			$('#mask').hide();
		}
	}
	function page_move( url ){
		location.href = url;
	}
	$(window).bind("pageshow", function(event) {
		if (event.originalEvent.persisted) {
			window.location.reload() 
		}
	});

	

</script>
</head>
<body>
<div class="sub_top">
    	<div class="menu_tit">입점 안내</div>
    </div>

<div id="map" style="width:100%;height:300px; width:800px;"></div>
<div class="sub_top space">
    	
    </div>
    
    <div class="contents">
    	<div class="sub_con">


			<p class="sb_tit"><img src="http://localhost:8088/controller/resources/img/sb_tit_icon.png">지점</p>
			
			<!--<table class="tb member s" cellpadding="0" cellspacing="0">
				<colgroup>
					<col width="15%;">
					<col width="10%;">
					<col width="45%;">
					<col width="10%;">
					<col width="20%;">
				</colgroup>
				<tr class='sub_th 1'>
					<th colspan="5">부산</th>
				</tr>
				<tr>
				  	<td class="sub05">해운대구</td>
					<td class="sub05">좌동</td>
					<td class="sub05">울트라타워점 (부산시 해운대구 좌동로 88, 202호)</td>
					<td class="sub05">지도</td>
					<td class="sub05 nt">tel.051-704-8080</td>
				</tr>
			</table>-->
			
			<div class="cook_info">
			   <div class="office">
				   <h3><img src="http://localhost:8088/controller/resources/img/cloud.png" style="height: 25px; width: 25px;"> 부산 ㅣ 해운대구 좌동점</h3>
			       <p><b>tel. <em >051)704-8080</em></b><br>
                      <b>[도로명]</b>&nbsp;&nbsp; 부산시 해운대구 좌동로 88, 202호 (울트라타워)<br>
                      <b>[지번]</b>&nbsp;&nbsp;&nbsp; 부산시 해운대구 좌동 1461-1
			       </p>
				</div>
				
			    <div class="map right" id='map'>
				</div>
			</div>
			

    	</div>


<script>
/* var mapOptions = {
    center: new naver.maps.LatLng(35.1584794, 129.0620088),
    zoom: 20
    
   
};

var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(35.1584794, 129.0620088),
    zoom: 20
});

var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng(35.1584794, 129.0620088),
    map: map
}); */

var HOME_PATH = window.HOME_PATH || '.';

var cityhall = new naver.maps.LatLng(35.1584794, 129.0620088),
    map = new naver.maps.Map('map', {
        
        zoom: 15
    }),
    marker = new naver.maps.Marker({
        map: map,
        position: cityhall
    });

var contentString = [
        '<div class="iw_inner">',
        '   <h3>공유주방 제목</h3>',
        '   <p>부산 부산진구 동천로 109 삼한골든게이트 7층 | 부전동 112-3<br />',
        
        '       47246 | 건물 &gt; 공유주방<br />',
        '       <a href="http://www.itwillbs.co.kr/" target="_blank">www.itwillbs.co.kr/</a>',
        '   </p>',
        '</div>'
    ].join('');

var infowindow = new naver.maps.InfoWindow({
    content: contentString
});

naver.maps.Event.addListener(marker, "click", function(e) {
    if (infowindow.getMap()) {
        infowindow.close();
    } else {
        infowindow.open(map, marker);
    }
});

infowindow.open(map, marker);
</script>
</body>
</html>





  <%@ include file="../main/footer.jsp" %>
</body>
</html>
</html>