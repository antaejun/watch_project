





<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 제이쿼리, bx슬라이더, home스크립트, homeCSS-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
                
              <div class="inputArea">
			<label>이미지</label>
			<div class="select_img">
			<img src="../resources${kitchenVO.image }" width="500"/></div>
			
		</div>
            </div>
            <div class="order">
                <div class="title">
                    
                    <h2>${kitchenVO.kitchen_name}</h2>
                    <p>${kitchenVO.content}</p>
                </div>
                <div class="order_form">
                    <div class="form_container price_container">
                        <p>지점 : ${kitchenVO.branch_name }</p>
                        <p>지역 : ${kitchenVO.region }</p>
                        <p class="price">임대 비용(월)${kitchenVO.rental_price}<span class="won">원</span></p>
                        <p>평수 : ${kitchenVO.acreage }평</p>
                    </div>
                    <hr>
                
                    
               
                    <div class="form_container store clearfix">
                        <div class="box-footer">
		<button type="submit" class="btn btn-default" onclick="Rental();" style="background-color: black">예약하기</button>
		
		<button type="submit" class="btn btn-default" onclick="List();" style="background-color: black">목록보기</button>
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


		
		
		<!-- <h3>옵션(체크해주세요)</h3>
		<div>
			<label>전자레인지</label>
			<input type="checkbox" name="microwave_oven" value="y">
		</div>
		<div>
			<label>가스레인지</label>
			<input type="checkbox" name="gas_stove" value="y">
		</div>
		<div>
			<label>인덕션</label>
			<input type="checkbox" name="induction" value="y">
		</div>
		<div>
			<label>냉장고</label>
			<input type="checkbox" name="refrigerator" value="y">
		</div>
		<div>
			<label>냉동고</label>
			<input type="checkbox" name="freezer_refrigerator" value="y">
		</div>
		<div>
			<label>전기온수기</label>
			<input type="checkbox" name="electric_water_heater" value="y">
		</div>
		<div>
			<label>제빙기</label>
			<input type="checkbox" name="ice_making_machine" value="y">
		</div>
		<div>
			<label>싱크대</label>
			<input type="checkbox" name="sink" value="y">
		</div>
		<div>
			<label>배기후드</label>
			<input type="checkbox" name="exhaust_hood" value="y">
		</div>
		<div>
			<label>포스대</label>
			<input type="checkbox" name="pos" value="y">
		</div>
		<div>
			<label>인터넷</label>
			<input type="checkbox" name="internet" value="y">
		</div>
		<div>
			<label>전화기</label>
			<input type="checkbox" name="telephone" value="y">
		</div> -->
		
		






<%@ include file="../main/footer.jsp" %>



<script>
   function List(){
        alert("목록 페이지로 이동");
        location.href="http://localhost:8088/controller/kitchen/List";
	   }
   function Rental(){
       alert("예약 페이지로 이동");
       location.href="http://localhost:8088/controller/rental/register?idx=${kitchenVO.idx }";
	   }
</script>


</body>
</html>












