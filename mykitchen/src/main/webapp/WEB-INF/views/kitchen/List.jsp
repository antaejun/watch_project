<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 제이쿼리, bx슬라이더, home스크립트, homeCSS-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <!-- 부트스트랩 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- 유어와치 UI -->
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/common.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/index.css">
    <script src="http://localhost:8088/controller/resources/vendor/bootstrap/js/index.js"></script>

    <!-- Swiper -->
    <script src="http://localhost:8088/controller/resources/vendor/bootstrap/js/swiper.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://localhost:8088/controller/resources/vendor/bootstrap/css/swiper.min.css">
    
    <!-- Awesome5 Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
	
<%@ include file="../main/header.jsp" %>
<h1>WEB-INF/kitchen/List.jsp</h1>
<!-- Main content -->

		<%-- <%-- <h2>${kitchenList }</h2>		
	<table border="2" style="width: 1500px;" class="table table-striped">
	
		<tr><th>번호</th>
		<th>제목</th>
		<th>주방이름</th>
		<th>날짜</th>
		</tr>
		<c:forEach items="${kitchenList}" var="kitchenVO">
			<tr>
				<th style="width: 10px;">${kitchenVO.idx }</th>
				<th style="width: 900px;">
				 <a href="http://localhost:8088/controller/kitchen/read?idx=${kitchenVO.idx }">${kitchenVO.content }</a>
				</th>
				<th>${kitchenVO.kitchen_name }</th>
				<th>
					<fmt:formatDate 
					pattern="yyyy-MM-dd HH:mm"
					value="${kitchenVO.regist_date }"/>
				</th>
				
				
			</tr>
		</c:forEach>
		
		
	</table>




			

<script type="text/javascript">
    //alert("출력");
    // 전달정보가 SUCCESS 일때만 "정상처리된 페이지 입니다"
    //  "글 저장이 성공했습니다."
    
    var result = '${result}';
    // alert("result : "+result);
    
    if(result == 'SUCCESS'){
        alert("글 저장 성공! 정상처리된 페이지 입니다.");
        }
    
    


</script> --%>
 

	<%
		String user_email = request.getParameter("user_email");
	%>
	<h1> 주방 등록 목록 </h1>
	
	<table border="1">
		<tr>
			<th>주방이름</th>
			<th>이미지(썸네일)</th>
			<th>등록날짜</th>
		</tr>
		<c:forEach items="${kitchenList }" var="kitchenVO">
		<tr>
			<td><a href="http://localhost:8088/controller/kitchen/read?idx=${kitchenVO.idx }">${kitchenVO.kitchen_name}</a></td>
			<td><img src="http://localhost:8088/controller/resources${kitchenVO.thumb_image}" /></td>
			<td>${kitchenVO.regist_date }</td>
		</tr>
		</c:forEach>
	</table>
	
	

<%@ include file="../main/footer.jsp" %>

</body>
</html>