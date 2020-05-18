<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
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
<title>회원가입</title>
</head>


	<h3>로그인 페이지</h3>
	    <%@include file="../main/header.jsp" %>
	    
	    
	    <br><br><br><br>
	    
	    
	    
	<fieldset>
		<legend>사업자 주방 등록</legend>
		<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
		<input type="hidden" name="user_email" value="2@2.com">
		<div class="inputArea">
			<label>주방 이름</label>
			<input type="text" name="kitchen_name">
		</div>
		<div class="inputArea">
			<label>지역</label><input type="text" name="region">
		</div>
		<div class="inputArea">
			<label>평수</label>
			<input type="text" name="acreage">
		</div>
		<div class="inputArea">
			<label>렌탈 비용(월)</label>
			<input type="text" name="rental_price">
		</div>
		<div class="inputArea">
			<label>이미지 등록</label>
			<input type="file" id="image" name="file" accept="image/*">
			<div class="select_img"><img src=""/></div>
			
			<script>
				$("#image").change(function(){
					if(this.files && this.files[0]) {
						var reader = new FileReader;
						reader.onload = function(data) {
							$(".select_img img").attr("src", data.target.result).width(500);
						} 
						reader.readAsDataURL(this.files[0]);
					}
				});
			</script>
			
		</div>
		<div class="inputArea">
			<label>지점명</label>
			<input type="text" name="branch_name">
		</div>
		<div class="inputArea">
			<label>내용</label>
			<input type="text" name="content"><br>
		</div>	
		
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
		
		<button type="submit">등록</button>
		</form>
	</fieldset>
    



	<%@ include file="../main/footer.jsp" %>
</body>
</html>

