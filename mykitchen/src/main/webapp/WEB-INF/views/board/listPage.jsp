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
   				 <a href="http://localhost:8088/controller/board/view?num=${customerscenter.num}">${customerscenter.title}</a>
				</td>
				<td>${customerscenter.regist_date}</td>
				<td>${customerscenter.user_email}</td>
			</tr>
		</c:forEach>
	</tbody>


</table>

<div>
<c:if test="${prev}">
 <span>[ <a href="http://localhost:8088/controller/board/listPage?num=${startPageNum - 1}">이전</a> ]</span>
</c:if>

<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
 <span>
 
  <c:if test="${select != num}">
   <a href="http://localhost:8088/controller/board/listPage?num=${num}">${num}</a>
  </c:if>    
  
  <c:if test="${select == num}">
   <b>${num}</b>
  </c:if>
    
 </span>
</c:forEach>

<c:if test="${next}">
 <span>[ <a href="http://localhost:8088/controller/board/listPage?num=${endPageNum + 1}">다음</a> ]</span>
</c:if>
<%-- 	<c:if test="${prev}"> --%>
<%-- 		<span>[ <a href="/board/listpage?num=${starPageNum - 1}">이전</a>]</span> --%>
<%-- 	</c:if> --%>
	
<%-- 	<c:forEach begin="${startPageNum}" end="${endPageNum}" var ="num"> --%>
<!-- 		<span> -->
<%-- 			<a href="/board/listPage?num=${num}">${num}></a> --%>
<!-- 		</span> -->
<%-- 	</c:forEach> --%>
	
<%-- 	<c:if test="${next}"> --%>
<%-- 		<span>[ <a href="/board/listPage?num=${endPageNum + 1}">다음</a>]</span> --%>
<%-- 	</c:if> --%>

 <%-- <c:forEach begin="1" end="${pageNum}" var="num">
    <span>
     <a href="/board/listPage?num=${num}">${num}</a>
  </span>
 </c:forEach> --%>
</div>



</body>
</html>