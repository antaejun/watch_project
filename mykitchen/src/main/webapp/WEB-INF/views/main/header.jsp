<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/header.css">
<script src="http://localhost:8088/controller/resources/vendor/bootstrap/js/header.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Gothic+A1:300&display=swap" rel="stylesheet">
	<header>
        <div class="wrapper">
        <!-- 왼쪽으로 움직이는 div -->
            <div class="left">
                <div class="top">
                    <ul>
                        <li class="lf"><a href="http://localhost:8088/controller/"><img alt="" src="http://localhost:8088/controller/resources/img/logo_black.png"></a></li>
                       



                     <!--  로그인부터 고객센터까지 보이는 칸 -->
                    
                        
                        
                        <li class="rt"> <a href="http://localhost:8088/controller/board/listPage?num=1">고객센터</a></li>
                        
                        
                        <c:if test="${user == null}">
                        <li class="rt"><a href="http://localhost:8088/controller/user/myInfo">My (제목)</a></li>
                        <li class="rt"><a href="http://localhost:8088/controller/kitchenB/businessMain">사업자 페이지</a></li>
                          <li class="rt"><a href="http://localhost:8088/controller/user/logout">로그아웃</a></li>
                        </c:if>
						<c:if test="${user != null}">  
						<li class="rt"><a href="http://localhost:8088/controller/user/login">로그인</a></li>
						<li class="rt"><a href="http://localhost:8088/controller/user/mainRegister">회원가입</a></li>
						
						</c:if>
                    </ul>
                </div>
                
                
                     <!--  로그인부터 고객센터까지 보이는 칸 -->
                     
                     <!-- 홈부터 소개페이지가 보이는칸 -->
                <div class="bottom">
                    <div class="lf">
                        
                        <i class="fas fa-search"></i>
                        <input class="search" type="text" placeholder="">
                    </div>
                    <div class="ct">
                        <h2>제목<br>입력칸</h2>
                    </div>
                 
                </div>
                <!-- 홈부터 소개페이지가 보이는칸 -->
                
            </div>
            <!-- 왼쪽으로 움직이는 div -->
        </div>
        <nav>
            <ul>
                <li><a href="http://localhost:8088/controller/">Home</a></li>
                <li><a href="http://localhost:8088/controller/kitchen/List" class="dropbtn">주방안내(주방소개 페이지)</a></li>
                <li><a href="http://localhost:8088/controller/MapACall/Map" class="dropbtn">입점 및 문의(지점 지도+ 전번)</a></li>
                <li><a href="http://localhost:8088/controller/News/News" class="dropbtn">공유주방 소개페이지</a></li>
                <li><a href="#" class="dropbtn">공유주방 뉴스</a></li>
               
            </ul>
          
        </nav>
    </header>