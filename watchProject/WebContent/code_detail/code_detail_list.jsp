<%@page import="net.code.detail.db.CodeDetailDTO"%>
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
		List<CodeDetailDTO> codeDetailList = (List)request.getAttribute("codeDetailList");
	%>
	
	<h2><a href="./adminmain.jsp">관리자 메인</a></h2>
	<h2><a href="./CodesList.co">코드 목록</a></h2>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>코드 상세</td>
			<td>코드 상세 네임</td>
			<td>코드</td>
			<td>등록일</td>
			<td>상세 코드 비활성화 </td>
			<td>상세 코드 수정</td>
		</tr>
		
		<%
		for(int i=0; i<codeDetailList.size();i++){
			CodeDetailDTO cddto = codeDetailList.get(i);
		%>
		<tr>
			<td>
			<input type="text" class="idx" name="idx" value="<%=cddto.getIdx() %>" readonly>
			</td>
			<td><%=cddto.getCode_detail() %></td>
			<td><%=cddto.getCode_detail_name() %></td>
			<td><%=cddto.getCode() %></td>
			<td><%=cddto.getRegist_date() %></td>
			<%if(cddto.getDelete_yn().equals("n")){ %>
			<td>
			<a href='./CodeDetailDisable.cd?idx=<%=cddto.getIdx()%>&code=<%=cddto.getCode()%>'><%=cddto.getDelete_yn() %></a>
			</td>
			<%}else{ %> 
			<td>
			<a href='./CodeDetailAble.cd?idx=<%=cddto.getIdx()%>&code=<%=cddto.getCode()%>'><%=cddto.getDelete_yn() %></a>
			</td>
			<%} %>
			<td>
			<input type="button" value="상세 코드 수정" class="modifydetail">
			</td>
		</tr>
		
		<%} %>
	</table>

	<!-- jQuery CodeDetail 수정 -->
	<form class="cdm" action="./CodeDetailModifyAction.cd">
	<input type="hidden" name="code" value="${param.code }">
	<table border="1" class="cd_modify">
	
	</table>
	<input type="button" value="상세 코드 수정하기" class="cdmodify">
	</form>
	
	<script type="text/javascript">
		$(document).ready(function (){
			
			$(".modifydetail").click(function(){
				var idx = $('.modifydetail').index(this);
				var did = $('.idx').eq(idx).val();
				var innerhtml = '<tr>'+
					'<td>번호</td>'+
					'<td>상세코드</td>'+
					'<td>상세코드명</td>'+
					'</tr>'+
					'<tr>'+
					'<td><input type="text" name="idx" value="'+did+'"></td>'+
					'<td><input type="text" name="code_detail"></td>'+
					'<td><input type="text" name="code_detail_name"></td>'+
					'</tr>';
		
					$('.cd_modify').html(innerhtml);
			});
			
			$(".cdmodify").click(function(){
				$(".cdm").submit();
			});
			
		});
	
	</script>
	
</body>
</html>