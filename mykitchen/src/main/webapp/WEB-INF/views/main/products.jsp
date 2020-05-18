<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 제이쿼리, bx슬라이더, home스크립트, homeCSS-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- 유어와치 UI -->
    <script src="js/products.js"></script>
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/css/common.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/css/products.css">

    <!-- Swiper -->
    <script src="js/swiper.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/css/swiper.min.css">

    <!-- Awesome5 Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">

    <title>YOUR WATCH</title>
</head>
<body>
    <%@include file="header.jsp" %>

    <section>
        <article class="container nav_info clearfix">
            <p>홈 > 남성용시계</p>
        </article>
        <article class="container title clearfix">
            <h2>남성용시계</h2>
        </article>
        <article class="side_bar clearfix">
            <div class="container side_nav clearfix">
                <div class="nav_box clearfix">
                    <h1 class="clearfix" style="float: left;">필터</h1>
                    <button id="reset"></button>
                    <label for="reset"><i class="fas fa-redo" style="margin: 0 5px;"></i>초기화</label>
                </div>
                
                <hr>
                <div class="nav_box clearfix">
                    <h1>카테고리</h1>
                    <ul style="margin-left: 15px;">
                        <li>남성시계</li>
                        <li>여성시계</li>
                        <li>공용시계</li>
                        <li>유아용시계</li>
                    </ul>
                </div>
                <hr>

                <div class="nav_box clearfix">
                    <h1>브랜드</h1>
                    <ul class="nav_check">
                        <li>
                            <input type="checkbox" id="brand1"><label for="brand1"><i class="fas fa-check"></i><span>카시오</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand2"><label for="brand2"><i class="fas fa-check"></i><span>지샥</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand3"><label for="brand3"><i class="fas fa-check"></i><span>시티즌</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand4"><label for="brand4"><i class="fas fa-check"></i><span>스와치</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand5"><label for="brand5"><i class="fas fa-check"></i><span>엠포리오아르마니</span></label>
                        </li>
                    </ul>
                </div>
                <hr>

                <div class="nav_box clearfix">
                    <h1>밴드소재</h1>
                    <ul class="nav_check">
                        <li>
                            <input type="checkbox" id="band1"><label for="band1"><i class="fas fa-check"></i><span>기타</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="band2"><label for="band2"><i class="fas fa-check"></i><span>스테인리스스틸</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="band3"><label for="band3"><i class="fas fa-check"></i><span>가죽</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="band4"><label for="band4"><i class="fas fa-check"></i><span>플라스틱</span></label>
                        </li>
                    </ul>
                </div>
                <hr>

                <div class="nav_box clearfix">
                    <h1>가격</h1>
                    <input type="range" style="width: 200px;">x원
                    <button>적용하기</button>
                </div>
                <hr>

                <div class="nav_box clearfix">
                    <h1>색상</h1>
                    <ul class="color">
                        <li>
                            <input type="checkbox" id="white"><label for="white" style="background-color: white; border: 1px solid gray; color: black;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="black"><label for="black" style="background-color: black;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="red"><label for="red" style="background-color: red;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="orange"><label for="orange" style="background-color: orange;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="yellow"><label for="yellow" style="background-color: yellow;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="green"><label for="green" style="background-color: green;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="blue"><label for="blue" style="background-color: blue;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="navy"><label for="navy" style="background-color: navy;"><i class="fa fa-check"></i></label>
                        </li>
                        <li>
                            <input type="checkbox" id="purple"><label for="purple" style="background-color: purple;"><i class="fa fa-check"></i></label>
                        </li>
                    </ul>
                </div>
                <hr>

                <div class="nav_box clearfix">
                    <h1>사이즈</h1>
                </div>
                <hr>
                <div class="nav_box clearfix">
                    <h1>별점</h1>
                </div>
            </div>
        </article>
        <article class="contents clearfix">
            <div class="fillter">
                <div class="selected">
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                </div>
            </div>
            <div class="align clearfix">
                <ul>
                    <li><a href="#">인기순</a></li>
                    <li><a href="#">판매순</a></li>
                    <li><a href="#">최신순</a></li>
                    <li><a href="#">낮은 가격순</a></li>
                    <li><a href="#">높은 가격순</a></li>
                </ul>
                <select name="amount">
                    <option value="60">60개씩 보기</option>
                    <option value="30">30개씩 보기</option>
                    <option value="15">15개씩 보기</option>
                    <option value="9">9개씩 보기</option>
                </select>
            </div>
            <div class="items">
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
                <div class="card">
                    <div class="fake_img">
                        
                    </div>
                    <div class="img_tag1">
                        NEW
                    </div>
                    <div class="img_tag2">
                        -20%
                    </div>
                    <div class="text_box">
                        <p>★★★★★</p>
                        <p><b>카시오</b>CASIO-10R</p>
                        <p><b>00,000</b><small>원</small></p>
                    </div>
                </div>
            </div>
            <div class="pagination">
                <div class="page">
                    <a href="#">&laquo;</a>
                    <a href="#">1</a>
                    <a href="#" class="active">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">&raquo;</a>
                </div>
            </div>
        </article>
    </section>



    <%@include file="footer.jsp" %>
</body>
</html>