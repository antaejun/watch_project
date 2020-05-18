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
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판 글쓰기</h3>
				</div>
				<!-- /.box-header -->
	
<!-- action페이지 속성이 없기 때문에 동일한 주소를 다시 호출post방식 -->
<form role="form" method="post">
<input type="hidden" name="idx" value="${kitchenVO.idx }">
	<div class="box-body">
		<div class="form-group">
		
		<input type="hidden" >
		
			<label for="exampleInputEmail1">예약하는사람 이메일</label> 
			<input type="text"
				name='user_email' class="form-control"  value="${user.user_name}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">예약하는 주방이름</label>
			<textarea class="form-control" name="kitchen_name" rows="3"
				placeholder="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">예약된 가격</label> 
			<input type="text"
				name="rental_price" class="form-control" placeholder="Enter Writer">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">렌탈코드</label> 
			<input type="text"
				name="kitchen_rental_code" class="form-control" placeholder="Enter Writer">
		</div>
	</div>
	<!-- /.box-body -->

	<div class="box-footer">
		<button type="submit" class="btn btn-primary" onclick="Rental();">결제 페이지로</button>
	</div>
</form>







<!-- Main content -->




<%@ include file="../main/footer.jsp" %>



<script>
   function List(){
        alert("목록 페이지로 이동");
        location.href="http://localhost:8088/controller/kitchen/List";
	   }
   function Rental(){
       alert("결제 페이지로 이동");
       location.href="http://localhost:8088/controller/rental/register?idx=${kitchenVO.idx }";
	   }
</script>


</body>
</html>














