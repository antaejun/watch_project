<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
</head>
<body>
	
	<form role="form" method="post">
		<input type="hidden" name="idx" value="${user.idx }">

	이름 : <input type="text" name='user_name' placeholder="${user.user_name }" value=""><hr>
	<c:if test="${user.business_yn eq 'y' }">
	 사업체 : 
	</c:if>
	<c:if test="${user.business_yn eq 'n' }">
	 닉네임 : 
	</c:if>
	<input type="text" name='nick' placeholder="${user.nick }" value=""><hr>
	
	연락처 : <input type="text" name='phone' placeholder="${user.phone }" value=""><hr>
	
	<c:if test="${user.business_yn eq 'y' }">
	 입점 지역 : 
	</c:if>
	<c:if test="${user.business_yn eq 'n' }">
	 선호 지역 : 
	</c:if>
	
	<input type="text" name='region' placeholder="${user.region }" value=""><hr>
	
	<!-- 비밀번호 확인 : <input type="password" name="user_pw" value=""> -->
	</form>
	
	<button type="submit" class="btn-modifyaction">정보 수정</button>
	
	<script>
	$(document).ready(function(){

		var formObj = $("form[role='form']");

		$(".btn-modifyaction").on("click", function(){
			formObj.attr("action", "/user/modiaction");
			formObj.submit();
			});
		
		});

	</script>
	
</body>
</html>