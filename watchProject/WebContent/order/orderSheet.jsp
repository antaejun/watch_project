<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/order/orderSheet.jsp</h1>
	<%
		int order_amount = Integer.parseInt(request.getParameter("order_amount"));
		String item_code = request.getParameter("item_code");
		String item_name = request.getParameter("item_name");
		String order_size = request.getParameter("item_size");
		String order_color =  request.getParameter("item_color");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
	%>
	<form action="" method="post">
	<input type="hidden" name="item_code" value="<%=item_code %>">
	<input type="hidden" name="order_amount" value="<%=order_amount %>">
	<input type="hidden" name="order_size" value="<%=order_size %>">
	<input type="hidden" name="order_color" value="<%=order_color %>">
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
		%>
		<tr>
			<td><%=item_name %></td>
			<td><%=order_color %></td>
			<td><%=order_size %></td>
			<td><%=item_price %>원</td>
			<td><%=order_amount %></td>
		</tr>
		<%
			total += order_amount * item_price;
		%>
		<tr>
			<td colspan="5">총 주문 금액 : <%=total %> 원</td>
			<input type="hidden" name="order_price" value="<%=total %>">
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
				<input type="radio" name="payment_type" value="kakaopay">카카오페이
				<input type="radio" name="payment_type" value="무통장입금">무통장입금
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