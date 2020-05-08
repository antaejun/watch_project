<%@page import="net.items.db.ItemDTO"%>
<%@page import="net.basket.db.BasketDTO"%>
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

	<h1>WebContent/order/basket.jsp</h1>
	
	<%
		// request.setAttribute("basketList", basketList);
		// request.setAttribute("itemsList", itemsList);
		List basketList = (List)request.getAttribute("basketList");
		List itemsList = (List)request.getAttribute("itemsList");
	%>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제품명</td>
			<td>색상</td>
			<td>사이즈</td>
			<td>상품 금액</td>
			<td>수량</td>
			<td>총 금액</td>
			<td>장바구니 삭제</td>
		</tr>
		<%
			for(int i=0;i<basketList.size();i++) {
				BasketDTO bkdto = (BasketDTO)basketList.get(i);
				ItemDTO idto = (ItemDTO)itemsList.get(i);
		%>
		<tr>
			<td><%=bkdto.getIdx() %></td>
			<td><%=idto.getItem_name() %></td>
			<td><%=bkdto.getBasket_color() %></td>
			<td><%=bkdto.getBasket_size() %></td>
			<td><%=idto.getItem_price() %> 원</td>
			<td><%=bkdto.getBasket_amount() %> 개</td>
			<td><%=bkdto.getBasket_price() %> 원</td>
			<td>
				<a href="./BasketDelete.ba?idx=<%=bkdto.getIdx() %>">삭제</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	
	<h3><a href="./BasketOrderSheet.or"> [구매하기] </a></h3>
	<h3><a href="./ItemsList.go"> [쇼핑 계속하기] </a></h3>

</body>
</html>