<%@page import="java.util.List"%>
<%@page import="net.items.db.CodeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user_email = null;
		if(session.getAttribute("user_email") != null) {
			user_email = (String) session.getAttribute("user_email");
		}
		
		List<CodeDTO> codeList 
		= (List<CodeDTO>) request.getAttribute("codeList");
		
	%>
	
	<div class="top-menu">
		<ul>
		<% if(user_email == null) { %>
			<li><a href="#"><span>로그인</span></a></li> /
			<li><a href="#"><span>회원가입</span></a></li>
		<% } else { %>
			<li><a href="#"><span><%=user_email %> 님</span></a>
				<div>
					<a href="#"><span>내정보수정</span></a>
					<a href="#"><span>장바구니</span></a>
					<a href="#"><span>주문/결제내역</span></a>
					<a href="#"><span>배송내역</span></a>
				</div>
			</li>
			<li><a href="#"><span>로그아웃</span></a></li>
		<% } %>
		</ul>
	</div>


	<div class="main-menu">
		<ul>
			<li><a href='./ItemCategory.go'><span>전체 브랜드</span></a>
				<%-- <div>
					<ul>
						<%
							int size = codeList.size();
							int idx = 0;
							for (int i = 0; i <codeList.size(); i++) {
								CodeDTO cdto = codeList.get(idx);
						 %>
						<li><a href='./ItemCodeDetail.go?code=<%=cdto.getCode() %>'><span><%=cdto.getCode_name() %></span></a>
						</li>
						<%
							idx++;
							if(size <= idx) break;
							}
						%>
						<li><a href='./ItemsList.go?code=400'><span>ARMANI</span></a>
							<div>
								<a href='./ItemsList.go?code=400&code_detail=1'><span>메탈</span></a>
								<a href='./ItemsList.go?code=400&code_detail=2'><span>가죽</span></a>
								<a href='./ItemsList.go?code=400&code_detail=3'><span>우레탄</span></a>
							</div>
						</li>
					</ul>
				</div>
			</li> --%>
			<li><a href="#"><span>인기상품</span></a></li>
			<li><a href="#"><span>할인상품</span></a></li>
			<li><a href="#"><span>공지사항</span></a></li>
			<li><a href="#"><span>이벤트</span></a></li>
			<li><a href="#"><span>고객센터</span></a>
				<div>
					<a href="#"><span>1:1 문의</span></a>
					<a href="#"><span>실시간 채팅</span></a>
				</div>
			</li>
		</ul>
	</div>
			
</body>
</html>