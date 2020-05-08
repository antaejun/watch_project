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
    
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/view.css">
	<script src="js/view.js"></script>

    <!-- Swiper -->
    <script src="js/swiper.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/swiper.min.css">

    <!-- Awesome5 Icons -->
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">

    <title>Document</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <section>
        <article class="container view clearfix">
            <div class="swiper">
                <div class="fake_img" style="height: 500px; height: 500px; background-color: gray;">
                    img
                </div>
                <div class="pagenation">
                    <div class="fake_img" style="height: 100px; width: 100px; background-color: gray;">
                        thumbnail
                    </div>
                    <div class="fake_img" style="height: 100px; width: 100px; background-color: gray;">
                        thumbnail
                    </div>
                    <div class="fake_img" style="height: 100px; width: 100px; background-color: gray;">
                        thumbnail
                    </div>
                </div>
            </div>
            <div class="order">
                <div class="title">
                    <p>카시오></p>
                    <h2>여성시계 A139202</h2>
                    <p>★★★★★5.0</p>
                </div>
                <div class="order_form">
                    <div class="form_container price_container">
                        <p class="sale"><span class="sale_rate">15%</span><span class="cost">337,000원</span></p>
                        <p class="price">285,000<span class="won">원</span></p>
                    </div>
                    <hr>
                    <div class="form_container amount_container">
                        <div class="amount_form clearfix">
                            <div class="controller clearfix">
                                <button>-</button>
                                <input type="text">
                                <button>+</button>
                            </div>
                            <span class="price">285,000<span class="won">원</span></span>
                        </div>
                    </div>
                    <hr>
                    <div class="form_container buy_container">
                        <div class="radio_box">
                            <input type="radio" name="delivery" value="quick" id="quick">
                            <label for="quick"><label class="checked"></label><span>빠른배송</span></label>
                        </div>
                        <div class="radio_box">
                            <input type="radio" name="delivery" value="nomal" id="normal">
                            <label for="normal"><label class="checked"></label><span>일반배송</span></label>
                        </div>
                        <div class="radio_box">
                            <input type="radio" name="delivery" value="present" id="present">
                            <label for="present"><label class="checked"></label><span>선물하기</span></label>
                        </div>
                        
                        <br><br>
                        <button class="btn1">장바구니 담기</button>
                        <button class="btn2">바로 구매하기</button>
                    </div>
                    <hr>
                    <div class="form_container">
                        <div class="etc_subject">
                            <b>혜택정보</b>
                        </div>
                        <div class="etc_content">
                            [결제할인] 롯데카드 xxx,xxx원<br>
                            [마일리지] x,xxxP 추가적립
                        </div>
                    </div>
                    <hr>
                    <div class="form_container">
                        <div class="etc_subject">
                            <b>배송정보</b>
                        </div>
                        <div class="etc_content">
                            <span class="text-lightblue">5/8(금) 발송 예정</span><br>
                            배송비 무료
                        </div>
                    </div>
                    <hr>
                    <div class="form_container store clearfix">
                        YOUR WATCH LOGO
                        <button><i class="fab fa-rocketchat"></i>채팅상담</button>
                    </div>
                    

                </div>
            </div>
        </article>

        <article class="container details clearfix">
            <div class="pd_detail">
                <div class="nav_detail">
                    <ul>
                        <li><a href="#">상세정보</a></li>
                        <li><a href="#">리뷰</a></li>
                        <li><a href="#">Q&A</a></li>
                        <li><a href="#">교환/반품 안내</a></li>
                    </ul>
                </div>
                <div class="container ct1">
                    <table>
                        <tr>
                            <td class="column1">제조사</td><td>아이그너/스위스</td>
                        </tr>
                        <tr>
                            <td class="column1">모델번호</td><td>A1234_D_B</td>
                        </tr>
                        <tr>
                            <td class="column1">상품번호</td><td>PD71032-LE13929</td>
                        </tr>
                        <tr>
                            <td class="column1">상품상태</td><td>새상품</td>
                        </tr>
                        <tr>
                            <td class="column1">브랜드</td><td>아이그너</td>
                        </tr>
                    </table>
                    <hr>
                    <p><a href="#">필수표기정보 더보기▽</a></p>
                </div>
                <div class="container ct3">
                    <div class="scroll_box">
                        <div class="fake_img">img1</div>
                        <p>동해물과백두산이</p>
                        <div class="fake_img">img2</div>
                        <div class="fake_img">img3</div>
                    </div>
                    <button>상세정보 더보기▽</button>
                </div>
                <div class="container ct4">
                    리뷰
                </div>
                <div class="container ct5">
                    Q&A
                </div>
                <div class="container ct6">
                    교환/반품안내
                </div>
            </div>
            <div class="quick_menu">
                <div class="info">
                    <p>5/11(월) 발송 예정</p>
                    <p>배송비 무료</p>
                    <p>판매자 : YOUR WATCH(주)</p>
                    <hr>
                    <div class="amount_form clearfix">
                        <div class="controller clearfix">
                            <button>-</button>
                            <input type="text">
                            <button>+</button>
                        </div>
                        <span class="price">285,000<span class="won">원</span></span>
                    </div>
                </div>
                <div class="order">
                    <input type="radio" name="delivery" value="quick">빠른배송
                    <input type="radio" name="delivery" value="normal">일반배송
                    <input type="radio" name="delivery" value="present">선물하기
                    <br>
                    <button>장바구니 담기</button>
                    <button>바로 구매하기</button>
                </div>
            </div>
        </article>
    </section>



    <%@ include file="footer.jsp" %>
</body>
</html>
</html>