<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/header.css">

<meta charset="UTF-8">
<title>Insert title here</title>
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
<h1>MapACall</h1>

<div class="sub_top">
    	<div class="menu_tit">입점 안내</div>
    </div>

    <div class="contents">
    	<div class="sub_con">
			<!--tab 클릭 또는 터치 시 해당 내용으로 위치 지정-->
			<p class="sub_tab sea">
            	<span class="s_tab 0 on" onclick="scroll_tab('sb_tit:eq(0)');">운영비용</span>
                <span class="s_tab 1" onclick="scroll_tab('sb_tit:eq(1)');">창업비용</span>
				<span class="s_tab 2" onclick="scroll_tab('sb_tit:eq(2)');">예상수익</span>
            </p>
			<!--//tab 클릭 또는 터치 시 해당 내용으로 위치 지정-->
			
			<!--tab 고정 후 class sub_tab.s 또 sub_tab.sea.s-->
			<p class="sub_tab sea s" style="display: none;">
            	<span class="s_tab 0 on">운영비용</span>
                <span class="s_tab 1">창업비용</span>
				<span class="s_tab 2">예상수익</span>
            </p>
			<!--//tab 고정 후 class sub_tab.s 또 sub_tab.sea.s-->
			
        	<p class="sb_tit"><img src="img/sb_tit_icon.png">운영비용</p>
			
			<div class="mn_border sub">
		      <h2 class="mn_tit sub">&middot; 고정비용 <!--<em>(총합계 ￦ 1,300,000)</em>--></h2>

			<div class="mn_box">
            <div class="mn_box1">
				<h3 class="mn_box_tit">임대료</h3>
				<p class="mn_box_cost"><img src="img/mn_box_img01.png"><br><del>95만원</del> &rarr; <em style="color: red">프로모션</em> 85만원<br><em>(보증금 5백만원)</em></p>
				<p class="mn_box_text">조리기구 제외한 <br>주방장비 일체 무상제공</p>
			</div>
			<div class="mn_box2">
				<h3 class="mn_box_tit">관리비</h3>
				<p class="mn_box_cost b"><img src="img/mn_box_img02.png" class="mn_box_img02"><br><del>35만원</del> &rarr; <em style="color: red">프로모션</em> 30만원</p>
				<p class="mn_box_text">공용 냉난방/전기/조명, 시설/장비수리, CCTV, 인터넷, 청소, 방역, 음식물쓰레기, 라운지 커피/음료, 프린트/팩스, 포스기, 화재보험</p>
			</div>
		<!--<div class="mn_box3">
				<h3 class="mn_box_tit">마케팅비</h3>
				<p class="mn_box_cost"><img src="img/mn_box_img03.png"><br>100,000원<br><em>(복수업종 시 추가당 5만원)</em></p>
				<p class="mn_box_text">공동 배달사이트, 포인트적립SW, 지하도/아파트 게시대, 전단지 배포, 블로그/SNS 홍보, 포탈 검색광고</p>
			</div>-->
		  </div>
		
		      <h2 class="mn_tit bg">&middot; 추가비용</h2>
		      <p class="mn_box4">호실내 가스/전기/수도</p>
		   </div>
</body>
</html>