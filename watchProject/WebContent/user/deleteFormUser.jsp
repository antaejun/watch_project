	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>"WebContent/user/deleteFormUser.jsp"</h1>
   <%
      //ID값 가져오기 
      String user_email = (String) session.getAttribute("user_email");
      if(user_email == null){
    	 response.sendRedirect("./UserLogin.com");  
      }   
   %>   
   
   <fieldset>
    <legend>회원 탈퇴하기</legend>
     <form action="./UserDeleteAction.com" method="post">
     <input type="hidden" name="user_email" value="<%=user_email%>">
     
           비밀번호입력후 확인버튼 : <input type="password" name="user_pw">
       <input type="submit" value="탈퇴하기">
        	<input type="button" value="아니요"
	       onclick="location.href='./MainView.com';"
	/>
     </form>    
   </fieldset>
   
   
   
   
   
</body>
</html>