<%@page import="net.user.db.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>"WebContent/user/Userinfo.jsp"</h1>
  <%
  	//세션값 처리 
      String user_email =(String) session.getAttribute("user_email");
    	
      if(user_email == null){
      	response.sendRedirect("./UserLogin.com");
      }
      
      
      //UserInfoAction 클래스에서 전달된 정보를 저장 (request영역데이터)
      UserBean ur = (UserBean)request.getAttribute("ur");
  %>
  <h1> 회원정보 페이지 </h1>
  
  <h2> 아이디 : <%=ur.getUser_email() %></h2>
  <h2> 비밀번호 : <%=ur.getUser_pw() %></h2>
  <h2> 이름: <%=ur.getUser_name() %></h2>
  <h2> 회원가입일 : <%=ur.getRegist_date() %></h2>
  <h2> 주소 : <%=ur.getAddress() %></h2>
  <h2> 상세주소 : <%=ur.getAddress_detail() %></h2>
  <h2> 탈퇴여부 : <%=ur.getDelete_yn() %></h2>
  <h2> 휴대폰 : <%=ur.getPhone() %></h2>
  <h2> 회원활동여부 : <%=ur.getUser_status() %></h2>
  <h2> 수정날짜 : <%=ur.getModify_date() %></h2>
  
  
  <h3><a href="./MainView.com"> main 페이지 </a></h3>
  
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>