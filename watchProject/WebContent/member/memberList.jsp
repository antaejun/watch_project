<%@page import="net.admin.member.db.AdminMemberDTO"%>
<%@page import="java.util.List"%>
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
		List<AdminMemberDTO> memberList = (List)request.getAttribute("memberList");
	%>

	<h2><a href="./adminmain.jsp">관리자 메인</a></h2>
	
	<table border = "1">
		<tr>
			<td>번호</td>
			<td>메일</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>주소</td>
			<td>상세주소</td>
			<td>전화번호</td>
			<td>등록일</td>
			<td>최종수정일</td>
			<td>비활성화</td>
			<td>상태</td>
			<td>회원정보 수정</td>
		</tr>

	<%
		for(int i=0; i<memberList.size(); i++){
			AdminMemberDTO amdto = memberList.get(i);
	%>
		<tr>
			<td><%=amdto.getIdx() %></td>
			<td><%=amdto.getUser_email() %></td>
			<td><%=amdto.getUser_pw() %></td>
			<td><%=amdto.getUser_name() %></td>
			<td><%=amdto.getAddress() %></td>
			<td><%=amdto.getAddress_detail() %></td>
			<td><%=amdto.getPhone() %></td>
			<td><%=amdto.getRegist_date() %></td>
			<td><%=amdto.getModify_date() %></td>
			<%if(amdto.getDelete_yn().equals("n")){ %>
			<td>
			<a href='./MemberDisable.am?idx=<%=amdto.getIdx()%>'><%=amdto.getDelete_yn() %></a>
			</td>
			<%}else{ %>
			<td>
			<a href='./MemberAble.am?idx=<%=amdto.getIdx()%>'><%=amdto.getDelete_yn() %></a>
			</td>
			<%} %>
			<td><%=amdto.getUser_status() %></td>
			<td><a href='./AdminMemberModify.am?idx=<%=amdto.getIdx()%>'>회원 정보 수정</a></td>		
		</tr>
	<%
	} 
	%>
		
	</table>
	
</body>
</html>