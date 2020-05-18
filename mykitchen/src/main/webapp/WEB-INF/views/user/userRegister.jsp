



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

<script type="text/javascript">
	$(document).ready(function() {
		// 취소
		$(".cencle").on("click", function() {

			location.href = "/login";

		})

		$("#submit").on("click", function() {
			if ($("#user_email").val() == "") {
				alert("아이디를 입력해주세요.");
				$("#user_id").focus();
				return false;
			}
			if ($("#user_pw").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#user_pw").focus();
				return false;
			}
			if ($("#user_name").val() == "") {
				alert("성명을 입력해주세요.");
				$("#user_name").focus();
				return false;
			}
			if ($("#nick").val() == "") {
				alert("닉네임을 입력해주세요.");
				$("#nick").focus();
				return false;
			}
			if ($("#phone").val() == "") {
				alert("전화번호를 입력해주세요.");
				$("#phone").focus();
				return false;
			}
			if ($("#region").val() == "") {
				alert("선호지역을 입력해주세요.");
				$("#region").focus();
				return false;
			}

		});

	})
</script>
<body>
    <%@include file="../main/header.jsp" %>
	<section id="container">
		<form method="post">
			<div class="form-group has-feedback">
				<label class="control-label" for="user_email">아이디</label> <input
					class="form-control" type="text" id="user_email" name="user_email" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="user_pw">비밀번호</label> <input
					class="form-control" type="password" id="user_pw" name="user_pw" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="user_name">이름</label> <input
					class="form-control" type="text" id=user_name name="user_name" />
			</div>

			<div class="form-group has-feedback">
				<label class="control-label" for="nick">닉네임</label> <input
					class="form-control" type="text" id="nick" name="nick" />
			</div>

			<div class="form-group has-feedback">
				<label class="control-label" for="phone">전화번호</label> <input
					class="form-control" type="text" id="phone" name="phone" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="region">매장지역</label> <input
					class="form-control" type="text" id="region" name="region" />
			</div>
			<input class="form-control" type="hidden" id="business_yn"
				name="business_yn" value="n" />


			<div class="form-group has-feedback">
				<button class="btn btn-success" type="submit" id="submit">회원가입</button>
				<input class="btn btn-default" type="button" value="취소"
					onclick="location.href='login'" />
			</div>
		</form>
	</section>









	
    



	<%@ include file="../main/footer.jsp" %>
</body>
</html>