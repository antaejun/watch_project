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
  <h1>"WebContent/user/updateForm.jsp"</h1>
  <%
  	String user_email = (String) session.getAttribute("user_email");
  	
  	  	if (user_email == null)
  	  		response.sendRedirect("./UserLogin.com");
  	
  	  	// 회원정보 가져오기 
  	  	// request.setAttribute("ur", ur);
  	  	UserBean ur = (UserBean) request.getAttribute("ur");
  	
  	  	/* String gender = ur.getGender();
  	  	if (gender == null)
  	  		gender = "남"; */
  %>
  
  
  <fieldset>
    <legend> 회원 정보 수정 </legend>
    
    <form action="./UserUpdateAction.com" method="post">
	      아이디* : <input type="text" name="user_email" value="<%=ur.getUser_email()%>"  readonly><br>
	      비밀번호 : <input type="password" name="user_pw"><br>
	      이름 : <input type="text" name="user_name" value="<%=ur.getUser_name()%>"><br>
	      주소 : <input type="text" name="address" value="<%=ur.getAddress()%>"><br>
	      상세주소 : <input type="text" name="address_detail" value="<%=ur.getAddress_detail()%>"><br>
	      휴대폰 : <input type="text" name="phone" value="<%=ur.getPhone()%>"><br>
	      가입일자 : <input type="text" name="regist_date" value="<%=ur.getRegist_date()%>" readonly><br>
	     
	      수정일자 : <input type="text" name="modify_date" value="<%=ur.getModify_date()%>" ><br>
	    
	     
	   <input type="submit" value="회원정보 수정">   
    </form>  
  
  </fieldset>
  
  <h2> *표시된 항목은 데이터 중복X </h2>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>