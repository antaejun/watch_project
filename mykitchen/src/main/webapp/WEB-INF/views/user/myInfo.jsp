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
		<input type="hidden" name="user_pw" value="${user.user_pw }">
		<input type="hidden" name="delete_yn" value="${user.delete_yn }">
		<input type="hidden" name="business_yn" value="${user.business_yn }">
		<input type="hidden" name="user_status" value="${user.user_status }">
	
	이메일 : <input tpye="text" name="user_email" value="${user.user_email }" readonly><hr>
	성명 : <input type="text" name="user_name" value="${user.user_name }" readonly><hr>
	
	<c:if test="${user.business_yn eq 'y' }">
	 사업체 : 
	</c:if>
	<c:if test="${user.business_yn eq 'n' }">
	 닉네임 : 
	</c:if>
	<input type="text" name="nick" value="${user.nick }" readonly><hr>
	
	연락처 : <input type="text" name="phone" value="${user.phone }" readonly><hr>
	
	<c:if test="${user.business_yn eq 'y' }">
	 입점 지역 : 
	</c:if>
	<c:if test="${user.business_yn eq 'n' }">
	 선호 지역 : 
	</c:if>
	<input type="text" name="region" value="${user.region }" readonly><hr>
	가입일 : <input type="text" name="regist_date" value="
	<fmt:formatDate
	pattern="yyyy-MM-dd"
	value=	"${user.regist_date }"/>
	" readonly><hr>
	최종 수정일 : <input type="text" name="modify_date" value="
	<fmt:formatDate
	pattern="yyyy-MM-dd HH:mm"
	value= "${user.modify_date }"/>
	" readonly><hr>
	회원 유형 : 
	<c:if test="${user.business_yn eq 'y' }">
	 사업자
	</c:if>
	<c:if test="${user.business_yn eq 'n' }">
	 일반
	</c:if>
	<hr>
	</form>
	
	<button type="submit" class="btn-modify">정보 수정</button>
	<button type="submit" class="btn-delete">회원 탈퇴</button>
	<button type="submit" class="btn-pwmodi">비밀 번호 수정</button>
	
	<!-- <input type="button" value="회원 탈퇴" class="dtuser">
	
	<table border="1" class="userdt">
	
	</table> -->
	
	<script>
		$(document).ready(function(){

			var formObj = $("form[role='form']");

			//삭제
			$(".btn-delete").on("click",function(){
				formObj.attr("action", "http://localhost:8088/controller/user/userdelete");
				formObj.submit();
				});

			//수정
			$(".btn-modify").on("click", function(){
				formObj.attr("action", "http://localhost:8088/controller/user/modiform");
				//formObj.attr("method", "get");
				formObj.submit();
				});

			//비밀번호 수정
			$(".btn-pwmodi").on("click", function(){
				formObj.attr("action", "http://localhost:8088/controller/user/pwmodify");
				formObj.submit();
				});

			/* $(".dtuser").click(function(){
				
				}); */
			
		});

	</script>
	
	
</body>
</html>