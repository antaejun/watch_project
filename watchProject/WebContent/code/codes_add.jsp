<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 코드 등록</h1>
	
	<form action="./CodeAddAction.co" name="fr">
	<fieldset>
	<legend>코드 등록</legend>
	코드 : <input type="text" name="code"><br>
	코드 네임 : <input type="text" name="code_name">
	<hr><hr>
	<input type="submit" value="등록 하기"><input type="reset" value="다시 등록">
	</form>
	</fieldset>
	
	<h2>*코드는 숫자를 입력해주세요.</h2>
	<hr><hr>
	<a href="./CodesList.co">코드 목록 보기</a>
	
</body>
</html>