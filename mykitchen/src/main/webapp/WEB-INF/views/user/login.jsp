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



	    <%@include file="../main/header.jsp" %>
	    
	    
	    <br><br><br><br>
	    
	    
	    	<h3>로그인 페이지</h3>
<body class="text-center">
	<form name='homeForm' method="post" >
		<c:if test="${user == null}">
			<div>
				<label for="user_email"></label>
				<input  type="text" id="user_email"
					name="user_email">
			</div>
			<div>
				<label for="user_pw"></label> <input type="password" id="user_pw"
					name="user_pw">
			</div>
			<br/>
			<div>
				<button class="btn btn-default" type="submit">로그인</button>
				<button class="btn btn-default" type="button" onclick="document.location='http://localhost:8088/controller/user/mainRegister'">회원가입</button>
			</div>
		</c:if>
		<c:if test="${user != null }">
			<div>
				<p>${user.user_name}님환영 합니다</p>
				<a href="logout">로그아웃</a>
			</div>
		</c:if>
		<c:if test="${msg == false}">
			<p style="color: red;">로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.</p>
		</c:if>

	</form>
    



	<%@ include file="../main/footer.jsp" %>
</body>
</html>

