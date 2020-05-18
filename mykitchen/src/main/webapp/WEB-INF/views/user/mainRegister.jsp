
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<공지사항 게시판 리스트를 db에서 긁어와서 뿌리기 >
    <title>타이틀제목</title>
</head>
<body>


    <%@include file="../main/header.jsp" %>



	<h1>사업자와 일반회원 구분하는 회원가입 페이지</h1>

	<a href="<c:url value='/user/ownerRegister'/>">사업자 회원가입</a>
	<br>
	<a href="<c:url value='http://localhost:8088/controller/user/userRegister'/>">일반회원 가입</a>
	<br />
	<input class="btn btn-default" type="button" value="취소"
		onclick="location.href='login'" />

    



	<%@ include file="../main/footer.jsp" %>
</body>
</html>