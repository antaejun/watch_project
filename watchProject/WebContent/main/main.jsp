<%@page import="net.items.db.CodeDTO"%>
<%@page import="net.items.db.ItemDTO"%>
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
	<!-- Navigation -->
	<jsp:include page="../inc/top.jsp" />
	
	<%
	 // request.setAttribute("codeList", codeList);
	 // request.setAttribute("itemsList", itemsList);
	 	List<CodeDTO> codeList = (List<CodeDTO>) request.getAttribute("codeList");
		List<ItemDTO> itemsList = (List<ItemDTO>) request.getAttribute("itemsList");
	%>
	
	<h1>트렌드</h1>
	<!-- 관리자페이지에서 트렌드값을 넘겨받아 출력 -->
	
	<h1>브랜드별 신상</h1>
	<!-- 관리자페이지에서 지정하여 넘겨준 codeList를 전달받아 각 code값(브랜드) 의 신상아이템 5개를 출력 -->
	
	
	
	
	

</body>
</html>