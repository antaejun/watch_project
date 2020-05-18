<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page session="false"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
		String user_email = request.getParameter("user_email");
	%> --%>
	<h1> 주방 등록 목록 </h1>
	
	<table border="1">
		<tr>
			<th>주방이름</th>
			<th>이미지(썸네일)</th>
			<th>등록날짜</th>
		</tr>
		<c:forEach items="${kitchenList }" var="kitchenVO">
		<tr>
			<td><a href="http://localhost:8088/kitchenB/kitchen_detail?kitchen_name=${kitchenVO.kitchen_name }">${kitchenVO.kitchen_name}</a></td>
			<td><img src="http://localhost:8088/controller/resources/${kitchenVO.thumb_image}" /></td>
			<td>${kitchenVO.regist_date }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="register">신규 주방 등록</a>
	
	
</body>
</html>
