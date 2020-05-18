<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>

<div id="id">
	<%@ include file="../include/nav.jsp" %>
</div>

<table border = "1">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
		
		<c:forEach items="${list}" var="customerscenter">
			<tr>
				<td>${customerscenter.num}</td>
				<td>
   				 <a href="/board/view?num=${customerscenter.num}">${customerscenter.title}</a>
				</td>
				<td>${customerscenter.regist_date}</td>
				<td>${customerscenter.user_email}</td>
			</tr>
		</c:forEach>
	</tbody>


</table>





</body>
</html>