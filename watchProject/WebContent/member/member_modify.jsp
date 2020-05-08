<%@page import="net.admin.member.db.AdminMemberDTO"%>
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
		AdminMemberDTO amdto = (AdminMemberDTO)request.getAttribute("selectedMember");
	%>
	
	<h1>회원 정보 수정(관리자)</h1>
	<form action = "./AdminMemberModifyAction.am">
	<input type="hidden" name="idx" value="<%=amdto.getIdx() %>">
	<input type="hidden" name="regist_date" value="<%=amdto.getRegist_date()%>">
	<input type="hidden" name="modify_date" value="<%=amdto.getModify_date()%>">
	<input type="hidden" name="delete_yn" value="<%=amdto.getDelete_yn()%>">
	
	메일 : <input type="text" name="user_email" placeholder="<%=amdto.getUser_email() %>"><hr>
	비밀번호 : <input type="text" name="user_pw" placeholder="<%=amdto.getUser_pw()%>"><hr>
	이름 : <input type="text" name="user_name" placeholder="<%=amdto.getUser_name()%>"><hr>
	주소 : <input type="text" name="address" placeholder="<%=amdto.getAddress() %>"><hr>
	상세 주소 : <input type="text" name="address_detail" placeholder="<%=amdto.getAddress_detail() %>"><hr>
	전화번호 : <input type="text" name="phone" placeholder="<%=amdto.getPhone()%>"><hr>
	상태 : <input type="text" name="user_status" placeholder="<%=amdto.getUser_status()%>"><hr>
	
	<input type="submit" value="수정">
	<input type="button" value="취소"
		onclick = "location.href='./MemberList.am'">
	</form>
	
</body>
</html>