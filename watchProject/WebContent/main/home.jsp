<%@page import="org.json.simple.ItemList"%>
<%@page import="net.main.db.ItemAllDTO"%>
<%@page import="net.items.db.ItemDTO"%>
<%@page import="net.main.db.ImageTableDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.main.db.MainSliderBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 제이쿼리, bx슬라이더, home스크립트, homeCSS-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- 유어와치 UI -->
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="js/index.js"></script>

    <!-- Swiper -->
    <script src="js/swiper.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/swiper.min.css">
    
    <!-- Awesome5 Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
	
	<title>제목칸</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	
	<% 
	List<MainSliderBean> sliderList
		= (List<MainSliderBean>)request.getAttribute("sliderList");
	List<MainSliderBean> trendList
		= (List<MainSliderBean>)request.getAttribute("trendList");
	List<ImageTableDTO> imageTableList
		= (List<ImageTableDTO>)request.getAttribute("imageTableList");
	List<ItemDTO> arrival
		= (List<ItemDTO>)request.getAttribute("arrival");
	List<ItemAllDTO> itemAllList
		= (List<ItemAllDTO>)request.getAttribute("itemAllList");
	%>
	    
    <section>
        
        <article class="content-xl content-1 bg-white text-white pad-0"> <!-- 메인 이미지 뒷쪽 배경 봐꾸는거 -->
            <div class="swiper-container swiper-1 content">
                <div class="swiper-wrapper">
                    <!-- 슬라이드 페이지 -->
                    <%
                    for(int i=0; i<sliderList.size(); i++){
                    	MainSliderBean msb = sliderList.get(i);
                    %>
                    <div class="swiper-slide">
                    	<img src="<%=msb.getImg_path()+msb.getImg_file()%>"
                    		style="height:<%=msb.getHeight()%>;width:<%=msb.getWidth()%>">
                    </div>
                    <%
                    }
                    %>
                </div>
                <!-- 페이지 네이션 -->
                <div class="swiper-pagination"></div>
                <!-- 네비게이션 버튼 -->
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
                <!-- 스크롤 바 -->
                <!--
                <div class="swiper-scrollbar"></div>
                -->
            </div>
        </article>

       <%--  <article class="content-xl content-2 bg-white text-white pad-7 font-xl"> <!-- 메인 이미지 뒷쪽 배경 봐꾸는거 -->
            <h2>TREND REPORT</h2>
            <div class="swiper-container swiper-2">
                <div class="swiper-wrapper">
                    <!-- 슬라이드 페이지 -->
                    <%
                    for(int i=0; i<trendList.size(); i++){
                    	MainSliderBean msb = trendList.get(i);
                	
                    %>
                    <div class="swiper-slide">
                        <div class="card">
                            <div class="container">
                                <div class="white_box">
                                    	<%= msb.getTag() %>
                                </div>
                                <div class="fake_img">
                                    <img src="<%=msb.getImg_path()+msb.getImg_file()%>">
                                </div>
                            </div>
                            <a href="<%=msb.getLink()%>"><button>VIEW MORE</button></a>                  
                        </div>
                    </div>
                    <%
                    }
                    %>
                </div> --%>
                
                <!-- 네비게이션 버튼 -->
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            </div>


            
        </article>

        

        <article class="content-xl content-4 bg-white text-white pad-0">
            <div class="swiper-container swiper-4 content-xl">
                <div class="swiper-wrapper">
                    <!-- 슬라이드 페이지 -->
                    <div class="swiper-slide">
                        <div class="slide-container bg-white">
                            <img src="img/logo/citizen.svg" style="height: 80px;width: auto;">
                            
                            <h5>빛으로 가는 시계 시티즌</h5>
                            <div class="grid-container gtc5 grid1">
                                <div class="grid-img img1">
                                    <iframe id="ytplayer" type="text/html" width="100%" height="100%"
  										src="https://www.youtube.com/embed/z31PeVIWdL0?autoplay=1&mute=1&playlist=gPACXXlDhBQ&loop=1"
  										frameborder="0"></iframe>
                                    
                                </div>
                                <div class="grid-img img2">
                                    <img src="./img/hotBanner/citizen_01.jpg">
                                </div>
                                <div class="grid-img img3">
                                    <img src="./img/hotBanner/citizen_02.jpg">
                                </div>
                                <div class="grid-img img4">
                                    <img src="./img/hotBanner/citizen_03.jpg">
                                </div>
                            </div>
                            <button>VIEW MORE</button>
                        </div>
                    </div>
                    <!-- 슬라이드 페이지 -->
                    <div class="swiper-slide">
                        <div class="slide-container bg-white">
                            <img src="./img/logo/d&g.png">
                            <h5>청하가 소개하는 돌체앤가바나</h5>
                            <div class="grid-container gtc5 grid1">
                                <div class="grid-img img1">
                                    <iframe id="ytplayer" type="text/html" width="100%" height="100%"
  										src="https://www.youtube.com/embed/dgl9Mqd4858?autoplay=1&mute=1&playlist=gPACXXlDhBQ&loop=1"
  										frameborder="0"></iframe>
                                </div>
                                <div class="grid-img img2">
                                    <img src="./img/hotBanner/d&g_01.jpg">
                                </div>
                                <div class="grid-img img3">
                                    <img src="./img/hotBanner/any_09.jpg">
                                </div>
                                <div class="grid-img img4">
                                    <img src="./img/hotBanner/any_10.jpg">
                                </div>
                            </div>
                            <button>VIEW MORE</button>
                        </div>
                    </div>
                    <!-- 슬라이드 페이지 -->
                    <div class="swiper-slide">
                        <div class="slide-container bg-white">
                            <img src="./img/logo/ck-logo.png">
                            <h5>CALVIN KLEIN PERFORMANCE STYLE!</h5>
                            <div class="grid-container gtc3">
                                <div class="grid-img img1">
                                    <img src="./img/hotBanner/any_01.jpg" style="height: 100%; width: auto;">
                                </div>
                                <div class="grid-img img2">
                                    <img src="./img/hotBanner/any_01.jpg" style="height: 100%; width: auto;">
                                </div>
                                <div class="grid-img img3">
                                    <img src="./img/hotBanner/any_01.jpg" style="height: 100%; width: auto;">
                                </div>
                            </div>
                            <button>VIEW MORE</button>
                        </div>
                    </div>
                </div>
                <!-- 네비게이션 버튼 -->
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
                <!-- 스크롤 바 -->
                <!--
                <div class="swiper-scrollbar"></div>
                -->
            </div>
        </article>

      
      <!--   @@@@@@@@@@@@@@@@@@@@@@@@@@테마 1~4 필요하면 넣기 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->

      <!--   <article style="background-color: white;">
            <div class="wrapper">
                <div class="title">
                    <h3>테마1</h3>
                </div>
            </div>
        </article>

        <article style="background-color: pink;">
            <div class="wrapper">
                <div class="title">
                    <h3>테마2</h3>
                </div>
            </div>
        </article>

        <article style="background-color: blue;">
            <div class="wrapper">
                <div class="title">
                    <h3>테마3</h3>
                </div>
            </div>
        </article>

        <article style="background-color: brown;">
            <div class="wrapper">
                <div class="title">
                    <h3>테마4</h3>
                </div>
            </div>
        </article> -->
          <!--   @@@@@@@@@@@@@@@@@@@@@@@@@@테마 1~4 필요하면 넣기 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
        
    </section>
	
	
	
	
	
	<%@ include file="footer.jsp" %>
</body>
</html>