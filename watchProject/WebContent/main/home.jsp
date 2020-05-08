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
	
	<title>YOUR WATCH</title>
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
	%>
	    
    <section>
        
        <article class="content-xl content-1 bg-black text-white pad-0">
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

        <article class="content-xl content-2 bg-black text-white pad-2 font-xl">
            <br>
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
                </div>
                
                <!-- 네비게이션 버튼 -->
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            </div>


            
        </article>

        <article class="content-xl content-3 bg-gradient1 text-white pad-2 font-xl">
            <br>
            <%
			for(int i=0; i<imageTableList.size(); i++){
				ImageTableDTO dto = imageTableList.get(i);
                	
			%>
			<%= dto.getO_name()%>
			<%
			}
			%>
			<%
			for(int i=0; i<arrival.size(); i++){
				ItemDTO dto = arrival.get(i);
			
			%>
			<%= dto.getItem_name() %>
			<%
			}
			%>
            <h1>NEW ARRIVAL</h1>
            <h5>99,999개</h5>
            <p>전체보기 ></p>
            <div class="swiper-container swiper-3 content-s text-black">
                <div class="swiper-wrapper">
                    <!-- 슬라이드 페이지 -->
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>aaa</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>bbb</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>ccc</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>ddd</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>eee</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>fff</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>ggg</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>hhh</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>iii</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="card-2 cascade">
                            <div class="fake_img">

                            </div>
                            <div class="item">
                                <h1>jjj</h1>
                                <p>가나다라마바사</p>
                                <p>아아아아아아아</p>
                                <p>999원, 333원</p>
                            </div>
                        </div>
                    </div>
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

        <article class="content-xl content-4 bg-black text-white pad-0">
            <div class="swiper-container swiper-4 content-xl">
                <div class="swiper-wrapper">
                    <!-- 슬라이드 페이지 -->
                    <div class="swiper-slide">
                        <div class="slide-container bg-black">
                            <img src="img/logo/citizen.svg" style="height: 80px;width: auto;">
                            
                            <h5>빛으로 가는 시계 시티즌</h5>
                            <div class="grid-container gtc5 grid1">
                                <div class="grid-img img1">
                                    <iframe id="ytplayer" type="text/html" width="100%" height="100%"
  										src="https://www.youtube.com/embed/gPACXXlDhBQ?autoplay=1&mute=1&playlist=gPACXXlDhBQ&loop=1"
  										frameborder="0"></iframe>
                                    
                                </div>
                                <div class="grid-img img2">
                                    2
                                </div>
                                <div class="grid-img img3">
                                    3
                                </div>
                                <div class="grid-img img4">
                                    4
                                </div>
                            </div>
                            <button>VIEW MORE</button>
                        </div>
                    </div>
                    <!-- 슬라이드 페이지 -->
                    <div class="swiper-slide">
                        <div class="slide-container bg-hotpink">
                            <h3>Logo</h3>
                            <h5>청하가 소개하는 돌체앤가바나</h5>
                            <h5>가나다라마바사</h5>
                            <div class="grid-container gtc5 grid1">
                                <div class="grid-img img1">
                                    1
                                </div>
                                <div class="grid-img img2">
                                    2
                                </div>
                                <div class="grid-img img3">
                                    3
                                </div>
                                <div class="grid-img img4">
                                    4
                                </div>
                            </div>
                            <button>VIEW MORE</button>
                        </div>
                    </div>
                    <!-- 슬라이드 페이지 -->
                    <div class="swiper-slide">
                        <div class="slide-container bg-beige">
                            <h3>Logo</h3>
                            <h5>청하가 소개하는 돌체앤가바나</h5>
                            <h5>가나다라마바사</h5>
                            <div class="grid-container gtc5 grid1">
                                <div class="grid-img img1">
                                    1
                                </div>
                                <div class="grid-img img2">
                                    2
                                </div>
                                <div class="grid-img img3">
                                    3
                                </div>
                                <div class="grid-img img4">
                                    4
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

        <article class="content-xl content-5 bg-white text-black pad-3">
            <div class="wrapper">
                <h1>가나다</h1>
                <p>호이호이</p>
                <div class="container container-5">
                    <div class="left">
                        <div class="fake_img">

                        </div>
                    </div>
                    <div class="right">
                        <div class="top">
                            <h3>DAILY<br>기분 전환 마린룩</h3>
                            <p>
                                동해물과백두산이<br>
                                마르고닳도록<br>
                                하느님이보우하사<br>
                                우리나라만세<br>
                            </p>
                        </div>
                        <div class="bottom">
                            <div class="left">
                                div1
                            </div>
                            
                            <div class="center">
                                div2
                            </div>
                            
                            <div class="right">
                                div3
                            </div>
                            
                        </div>
                    </div>

                </div>
            </div>
        </article>

        <article class="content-xl content-6 bg-darkbrown text-white">
            <div class="wrapper content-sm">
                <h2>PROMOTION</h2>
                <div class="swiper-container swiper-6">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <div class="fake_img">
                                1
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="fake_img">
                                2
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="fake_img">
                                3
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="fake_img">
                                4
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="fake_img">
                                5
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="fake_img">
                                6
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="fake_img">
                                7
                            </div>
                        </div>
                    </div>

                    <div class="swiper-pagination"></div>
                    <div class="swiper-button-prev"></div>
                    <div class="swiper-button-next"></div>

                </div>
                
            </div>
        </article>

        <article style="background-color: white;">
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
        </article>
    </section>
	
	
	
	
	
	<%@ include file="footer.jsp" %>
</body>
</html>