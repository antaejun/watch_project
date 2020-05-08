<%@page import="net.orderWatch.db.WatchOrderDTO"%>
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
	<h1>WebContent/goods_order/order_detail.jsp</h1>
	
	<%
			// request.setAttribute("orderDetailList", orderDetailList);
			
			List orderDetailList =
			(List)request.getAttribute("orderDetailList");

			 // 테이블 생성
			 // 상품명,상품크기,상품색상, 주문개수, 주문금액
			 // 총 주문금액 합계 출력
		%>
	
	<table border="1">
	  <tr>
	    <td>상품명</td>
	    <td>상품 크기</td>
	    <td>상품 색상</td>
	    <td>주문 수량</td>
	    <td>주문 금액</td>	  
	  </tr>
	  <%
	  	int total = 0;
	  	   for(int i=0;i<orderDetailList.size();i++){
	  		   WatchOrderDTO odto = (WatchOrderDTO)orderDetailList.get(i);
	  		   total += (odto.getOrder_price());
	  %>
		     <tr>
			    <td><%=odto.getOrder_name() %></td>
			    <td><%=odto.getOrder_size() %></td>
			    <td><%=odto.getOrder_color() %></td>
			    <td><%=odto.getOrder_amount() %></td>
			    <td><%=odto.getOrder_price() %>원</td>	  
			  </tr>
		   <%	
	   }
	  %>
	  <tr>
	    <td colspan="5">
	           <h4>총 주문금액 : <%=total %> 원</h4>
	    </td>
	  </tr>
	</table>
	<h3> <a href="./OrderWatchList.or">뒤로가기</a> </h3>
	
	
	
	
	
	

</body>
</html>