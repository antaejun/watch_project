<%@page import="net.items.db.ItemDTO"%>
<%@page import="net.items.db.CodeDetailDTO"%>
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
	<h1>WebContent/items/itemCodeDetail.jsp</h1>
	<!-- request.setAttribute("codeDetailList", codeDetailList); 
		 request.setAttribute("itemsList", itemsList);	-->
	<%
		List<CodeDetailDTO> codeDetailList 
			= (List<CodeDetailDTO>) request.getAttribute("codeDetailList");
		List<ItemDTO> itemsList = (List<ItemDTO>) request.getAttribute("itemsList");
	
		String code_name = request.getParameter("code_name");
	%>
	<!-- Navigation -->
	<jsp:include page="../inc/top.jsp" />
	<div>
		<ol>
			<li><a href="./ItemCategory.go">전체 브랜드</a></li>
			<li>-</li>
			<li><a href="#"><%=code_name %></a></li>
		</ol>
	</div>
	
	
	<table border="1">
	<%    
	        int size = codeDetailList.size();
		    int col = 5;
		    int row = (size / col) + (size%col>0? 1:0);
		    int idx = 0;
		    System.out.print("row : " + row);
		    CodeDetailDTO cddto = codeDetailList.get(idx);
		
			for (int i = 0; i < row; i++) {
		%>
		<tr>
			<td colspan="2">
				<a href='./ItemCodeDetail.go?code=<%=cddto.getCode() %>&code_name=<%=code_name%>'>전체보기</a>
			</td>
			<%
				for (int a = 0; a <col; a++) {
					cddto = codeDetailList.get(idx);
			%>
			<td colspan="2">
				<a href='./ItemsList.go?code=<%=cddto.getCode() %>&code_detail=<%=cddto.getCode_detail() %>&code_name=<%=code_name %>&code_detail_name=<%=cddto.getCode_detail_name() %>'>
		          <%=cddto.getCode_detail_name() %></a>
			</td>
			<%
				idx++;  
				if(size <= idx) break;
				}			
			%>
		</tr>
		<%
			}
		%>
	</table>
	
	<hr>
	
	<h1><%=code_name %> 전체상품</h1>
	<table border = "1">
		<%    
	        size = itemsList.size();
		    col = 4;
		    row = (size / col) + (size%col>0? 1:0);
		    idx = 0;
		
			for (int a = 0; a < row; a++) {
		%>
		<tr>
			<%
				for (int i = 0; i <col; i++) {
					ItemDTO idto = itemsList.get(idx);
			%>
			<td colspan="2">
		          <a href='./ItemsDetail.go?idx=<%=idto.getIdx()%>&item_code=<%=idto.getItem_code() %>'>
		          <%-- <img src="./upload/<%=idto.getList_image() %>"
		             width="130" height="130"><br> --%>
		          <%=idto.getItem_name() %><br>
		          <%=idto.getItem_size() %><br>
		          <%=idto.getItem_price() %>won
		          </a>
			</td>
			<%
				idx++;  
				if(size <= idx) break;
				}			
			%>
		</tr>
		<%
			}
		%>
		
	</table>
	
	
	
	
	
	
	
	
	
</body>
</html>