<%@page import="net.code.db.CodeDTO"%>
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
		CodeDTO cdto = (CodeDTO)request.getAttribute("selectedCode");
	%>
	
	<h1>코드 수정 페이지</h1>
	
	<form action = "./CodeModifyAction.co">
	<input type="hidden" name="idx" value="<%=cdto.getIdx()%>">
	<input type="hidden" name="regist_date" value="<%=cdto.getRegist_date()%>">
	<input type="hidden" name="delete_yn" value="<%=cdto.getDelete_yn()%>">
	
		<input type="text" value="<%=cdto.getCode() %>" name="code">
		<input type="text" value="<%=cdto.getCode_name() %>" name="code_name">

		<input type="submit" value="수정하기">
		<input type="button" value="취소하기"
		onclick="location.href='./CodesList.co'">
	</form>

</body>
</html>