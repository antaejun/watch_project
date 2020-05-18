<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
       <!-- 제이쿼리, bx슬라이더, home스크립트, homeCSS-->
  
  <!-- 부트스트랩 -->
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
<h1>WEB-INF/kitchen/read.jsp</h1>
<!-- Main content -->









<!-- Main content -->



   <form role="form" method="post">
      <input type="hidden" name="idx" value="${kitchenVO.idx }">
   </form>

    <section>
        <article class="container view clearfix">
            <div class="swiper">
                <div class="fake_img" style="height: 150px; width:150px; background-color: gray; ">
                    img
                </div>
              
            </div>
            <div class="order">
                <div class="title">
                    
                    <h2>${kitchenVO.kitchen_name}</h2>
                    <p>${kitchenVO.content}</p>
                </div>
                <div class="order_form">
                    <div class="form_container price_container">
                        
                        <p class="price">${kitchenVO.rental_price}<span class="won">원</span></p>
                    </div>
                    <hr>
                
                    
               
                    <div class="form_container store clearfix">
                        <div class="box-footer">
		<button type="submit" class="btn btn-default" onclick="Rental();">예약하기</button>
		
		<button type="submit" class="btn btn-default" onclick="List();">목록보기</button>
	</div>
                        
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
               
            </div>
        </article>
    </section>

<%@ include file="../main/footer.jsp" %>



<script>
   function List(){
        alert("목록 페이지로 이동");
        location.href="http://localhost:8088/controller/kitchen/List";
	   }
   function Rental(){
       alert("예약 페이지로 이동");
       location.href="http://localhost:8088/controller/kitchen/List";
	   }
</script>


</body>
</html>












