<%@page import="net.items.db.ItemDTO"%>
<%@page import="net.items.db.CodeDTO"%>
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
	<h1>WebContent/items/itemCategory.jsp</h1>
	
	<!-- request.setAttribute("codeList", codeList); 
		 request.setAttribute("itemsList", itemsList); -->
	<%
		List<CodeDTO> codeList 
			= (List<CodeDTO>) request.getAttribute("codeList");
		List<ItemDTO> itemsList
			= (List<ItemDTO>) request.getAttribute("itemsList");
	%>
	
	<!-- Navigation -->
	<jsp:include page="../inc/top.jsp" />
	<hr>
	<h1>전체 브랜드</h1>
	<%
		int size = codeList.size();
		int idx = 0;
		for (int i = 0; i <codeList.size(); i++) {
			CodeDTO cdto = codeList.get(idx);
	%>
	<div>
		<ul>
			<li>
				<a href='./ItemCodeDetail.go?code=<%=cdto.getCode() %>&code_name=<%=cdto.getCode_name() %>'>
				<span><%=cdto.getCode_name() %></span></a>
			</li>
		</ul>
	</div>
	<%
		idx++;
		if(size <= idx) break;
		}
	%>
	
	<hr>
	<h1>전체 품목</h1>
	<table border = "1">
		<%    
	        size = itemsList.size();
		    int col = 4;
		    int row = (size / col) + (size%col>0? 1:0);
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