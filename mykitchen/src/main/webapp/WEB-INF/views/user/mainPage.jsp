<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 후 보이는 메인 페이지</h1>
	<p>${user.user_name}님환영합니다...</p>
	<div>디자인에 맞게 로그아웃 버튼을 사용하세요!!!</div>
	<div>
		<form method="get" action="logout">
			<button type="submit" value="로그아웃">로그아웃</button>
		</form>
	</div>

	<div>
		<a href="logout">로그아웃</a>
	</div>
	<div>
		<input type="button" value="로그아웃" onclick="location.href='logout'" />
	</div>
</body>
</html>