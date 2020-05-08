<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>"WebContent/user/loginFormUser.jsp"</h1>
   <!-- 
     로그인 페이지 
     ID,PW를 입력받아서 전달페이지 
   -->
   
   <fieldset>
     <legend> 회 원 로 그 인 </legend>
     	<form action="./UserLoginAction.com" method="post">
           	아이디 : <input type="text" name="user_email"><br>
           	비밀번호 : <input type="password" name="user_pw"><br>
           	<hr>
           	<input type="submit" value="로그인">
           	<input type="button" name="insertBtn" value="회원가입"
           	       onclick="location.href='./UserJoin.com'" 
           	> 
   		</form>
   </fieldset>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>