<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>"WebContent/user/mainView.jsp"</h1>
	<!-- 
	   로그인한 사용자의 경우 사용자 ID를 출력,
	   로그인X 사용자의 경우 로그인페이지로 이동 	   
	 -->
	 <%
	   // 세션정보(ID값 가져오기)
	   String user_email = (String)session.getAttribute("user_email");
	   String delete_yn = (String)session.getAttribute("delete_yn");

	   // 로그인 유무 판단 처리 
	   
	   if(user_email == null){
		  response.sendRedirect("./UserLogin.com");   
	   }  
	 %>
	
	<h2>사용자 ID :<%=user_email %></h2> 
	<h2>사용자 ID :${user_email }</h2> 
	
	<input type="button" value="로그아웃"
	       onclick="location.href='./UserLogout.com';"
	/>
	<hr>
	<hr>
	<a href="./UserInfo.com">회원 정보 조회</a>
	<hr>
	<hr>
	<a href="./UserUpdate.com">회원 정보 수정하기</a>
	<hr>
	<hr>
	<a href="./UserDelete.com">회원 정보 삭제하기</a>
	
	<hr>
	<hr>
	<a href="./BoardList.bo">게시판 리스트 이동하기</a>
	
	
	<hr>
	<hr>
	<a href="./WatchList.go">상품 정보보기(사용자) 이동하기</a>
	<hr>
	<hr>
	<a href="./shoppingBasketList.shopping">장바구니 페이지 이동하기</a>
	<hr>
	<hr>
	<a href="./OrderWatchList.or">주문목록 페이지 이동하기</a>
	<hr>
	<hr>
	<%
	 if(user_email != null){
	  if(user_email.equals("admin")){
	%>
		<h2>
		 <a href="./UserList.com">회원 정보 목록보기</a>
		</h2>
		<hr>
		<hr>
		
		<h2>
		 <a href="./WatchAdd.ag">관리자 상품등록</a>
		</h2>
		<hr><hr>
		<h2>
		 <a href="./WatchList.ag">관리자 상품리스트</a>
		</h2>
		<hr><hr>
		<h2>
		 <a href="./AdminOrderWatchList.ao">관리자 주문 처리하기</a>
		</h2>
		<hr><hr>
		
		
		
	<%
	  }
	 }
	%>
	
	
	
	
	
	
	
	

</body>
</html>