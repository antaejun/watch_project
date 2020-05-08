<%@page import="net.code.db.CodeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.4.1.js"></script>
	
</head>
<body>
	<%
		List<CodeDTO> codesList = (List)request.getAttribute("codesList");
	%>
	
	<h2><a href="./adminmain.jsp">관리자 메인</a></h2>
	<h2><a href="./CodesAdd.co">코드 등록</a></h2>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>코드</td>
			<td>코드네임</td>
			<td>등록일</td>
			<td>코드 비활성화 </td>
			<td>코드 수정</td>
		<tr>
		<%
		for(int i=0; i<codesList.size();i++){
			CodeDTO cdto = codesList.get(i);
		%>
		<tr>
			<td><%=cdto.getIdx() %></td>
			<td>
			<a href="./CodeDetailList.cd?code=<%=cdto.getCode()%>">
			<input type="text" class="code_num" name="code" value="<%=cdto.getCode() %>" readonly>
			</a>
			<input type="button" value="상세 코드 추가" class="adddetail">
			</td>
			<td><%=cdto.getCode_name() %></td>		
			<td><%=cdto.getRegist_date() %></td>
			<%if(cdto.getDelete_yn().equals("n")){ %>
			<td>
			<a href='./CodeDisable.co?idx=<%=cdto.getIdx()%>'><%=cdto.getDelete_yn() %></a>
			</td>
			<%}else{ %>
			<td>
			<a href='./CodeAble.co?idx=<%=cdto.getIdx()%>'><%=cdto.getDelete_yn() %></a>
			</td>
			<%} %>
			<td><a href='./CodeModify.co?idx=<%=cdto.getIdx()%>'>코드 수정</a></td>
		</tr>
		<%} %>		
	
	</table>
	<hr>
	
	<!-- jQuery CodeDetail 추가 입력 및 전송 -->
	<form class="cdd" action="./CodeDetailAddAction.cd">
	<table border="1" class="code_details">
	</table>
	
	<input type="button" value="상세코드추가하기" class="codedetailadd">
	</form>
	
	
	<script type="text/javascript">
	
		$(document).ready(function () {
			//alert("경로 ok");
			
			/* $("#adddetail").bind('click',function(){
			alert("click");
			}); */
			
			//디테일 추가
			$(".adddetail").click(function(){
				var idx = $('.adddetail').index(this);
				var code = $('.code_num').eq(idx).val();
				var innerhtml = '<tr>'+
						'<td>코드</td>'+
						'<td>상세코드</td>'+
						'<td>상세코드명</td>'+
						
					'</tr>'+
					'<tr>'+
						'<td><input type="text" name="code" value="'+code+'"></td>'+
						'<td><input type="text" name="code_detail"></td>'+
						'<td><input type="text" name="code_detail_name"></td>'+
					
					'</tr>';
				
				$('.code_details').html(innerhtml);
			});
			
			$(".codedetailadd").click(function(){
				$(".cdd").submit();
			});
		//디테일 추가 끝	
		
		});
		
		
	</script>
	
</body>
</html>