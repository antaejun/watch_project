<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
</head>
<body>
	<form role="form" method="post">
	<input type="hidden" name="idx" value="${param.idx }">
	수정 할 비밀번호 : <input type="password" name="user_pw" value="">

	</form>
	
	<button type="submit" class="btn-pwmodiAction">비밀번호 수정</button>
	
	<script>

		$(document).ready(function(){

			var formObj = $("form[role='form']");

			$(".btn-pwmodiAction").on("click",function(){
				formObj.attr("action", "/user/pwmodiAction");
				formObj.submit();
				});
			
			});
	
	</script>
	
</body>
</html>