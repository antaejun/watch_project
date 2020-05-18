<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 삭제</title>
</head>
<body>

<div id="id">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">
삭제하시겠습니까?
<button type="submit">예</button>
<input type="button" onclick="location.href='/board/listPage?num=1'" value="아니오">


</form>

</body>
</html>