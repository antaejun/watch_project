<%@page import="net.basket.db.BasketDTO"%>
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
	<!-- 
		request.setAttribute("basketList", basketList);
		request.setAttribute("itemsList", itemsList);
	 -->
	 <%
	 	List basketList = (List) request.getAttribute("basketList");
	 	List itemsList = (List) request.getAttribute("itemsList");
	 %>
	 
	 <form action="" method="post">
	<table border="1">
		<tr>
			<td colspan="5">
				<h4> 주문/결제 </h4>
			</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td>색상</td>
			<td>크기</td>
			<td>가격</td>
			<td>수량</td>
		</tr>
		<%
			int total = 0;
 			for(int i=0;i<basketList.size();i++) {
				BasketDTO bkdto = (BasketDTO) basketList.get(i);
				ItemDTO idto = (ItemDTO) itemsList.get(i);
 		%>
		<tr>
			<td><%=idto.getItem_name() %></td>
			<td><%=bkdto.getBasket_amount() %></td>
			<td><%=bkdto.getBasket_size() %></td>
			<td><%=idto.getItem_price() %>원</td>
			<td><%=bkdto.getBasket_amount() %></td>
		</tr>
		<%
			total += bkdto.getBasket_amount() * idto.getItem_price();
 			}
		%>
		<tr>
			<td colspan="5">총 주문 금액 : <%=total %> 원</td>
		</tr>
		<tr>
			<td colspan="5">
				<h4> 주문자 정보 </h4>
			</td>
		</tr>
		<tr>
			<td colspan="2">주문자</td>
			<td colspan="3">
				<input type="text" name="order_name" value="홍길동">
			</td>
		</tr>
		<tr>
			<td colspan="2">연락처</td>
			<td colspan="3">
				<input type="text" name="order_phone" value="01000000000">
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<h4> 배송지 정보 </h4>
			</td>
		</tr>
		<tr>
			<td colspan="2">수령인</td>
			<td colspan="3">
				<input type="text" name="receive_name">
			</td>
		</tr>
		<tr>
			<td colspan="2">연락처</td>
			<td colspan="3">
				<input type="text" name="receive_phone">
			</td>
		</tr>
		<tr>
			<td colspan="6">배송지 주소</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="text" name="receive_adress" placeholder="주소">
			</td>
			<td colspan="3">
				<input type="text" name="receive_adress_detail" placeholder="상세주소">
			</td>
		</tr>
		<tr>
			<td colspan="2">배송 메모</td>
			<td colspan="3">
				<input type="text" name="memo">
			</td>
		</tr>
		<tr>
			<td colspan="5"><h4>결제 정보</h4></td>
		</tr>
		<tr>
			<td colspan="2">결제방법</td>
			<td colspan="3">
				<input type="radio" name="payment_method" value="kakaopay">카카오페이
				<input type="radio" name="payment_method" value="무통장입금">무통장입금
			</td>
		</tr>
		<tr>
			<td colspan="2">무통장 입금(입금자명)</td>
			<td colspan="3">
				<input type="text" name="trade_payer">
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<input type="submit" value="주문하기">
				<input type="reset" value="취소하기">
		</tr>
	</table>
	</form>

</body>
</html>
</body>
</html>