<%@page import="net.orderWatch.db.WatchOrderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/goods_order/order_list.jsp</h1>
	<%
		//request.setAttribute("orderList", orderList);
		  ArrayList orderWatchList 
		    = (ArrayList) request.getAttribute("orderWatchList");
		  
		  // 주문상태에 따른 화면 표시값 변경
		  // 0 - 대기중
		  // 1 - 발송준비
		  // 2 - 발송완료
		  // 3 - 배송중
		  // 4 - 배송완료
		  // 5 - 주문취소
		  			

	%>
	
	<h2> 결제 완료 / 주문 목록 </h2>
	
	<table border="1">
	  <tr>
	     <td>주문번호</td>
	     <td>상품명</td>
	     <td>결재방법</td>
	     <td>주문금액</td>
	     <td>주문상태</td>
	     <td>주문일시</td>
	     <td>운송장번호</td>
	  </tr>
	  
	  <%System.out.println("밑에가 안됨@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	  	  	for(int i=0;i<orderWatchList.size();i++){
	  	  		   WatchOrderDTO wodto = (WatchOrderDTO) orderWatchList.get(i);
	  	  		 %>
	    <tr>
	     <td>
	       <a href="./OrderWatchDetail.or?order_code=<%=wodto.getOrder_code()%>">
	         <%=wodto.getOrder_code() %>
	         <%System.out.println("위가 안됨"); %>
	       </a>	     
	     </td>
	     <td><%=wodto.getItem_code() %></td>
	     <td>결제방법 적기</td>
	     <td><%=wodto.getOrder_price() %>원</td>
	     
	     <%
	     String msg = "";
	     
	   /*   if(wodto.getO_status() == 0){ msg="대기중"; }
	     else if(wodto.getO_status() == 1){ msg="발송준비"; }
	     else if(wodto.getO_status() == 2){ msg="발송완료"; }
	     else if(wodto.getO_status() == 3){ msg="배송중"; }
	     else if(wodto.getO_status() == 4){ msg="배송완료"; }
	     else if(wodto.getO_status() == 5){ msg="주문취소"; }
	     else{ msg="관리자에게 문의하세요!"; } */
	     
	     switch(wodto.getOrder_status()){
	     
	     case "0":
	    	 msg="대기중";
	    	 break;
	     case "1":
	    	 msg="발송준비";
	    	 break;
	     case "2":
	    	 msg="발송완료"; 
	    	 break;
	     case "3":
	    	 msg="배송중";
	    	 break;
	     case "4":
	    	 msg="배송완료"; 
	    	 break;
	     case "5":
	    	 msg="주문취소";
	    	 break;
	    	 default:
	    		 msg="관리자 문의바람!";
	    		 System.out.println("이건성공2");
	     }
	     
	     
	     %>	     
	     <%-- <td><%=wodto.getO_status() %></td> --%>
	     <td><%=msg %></td>
	     
	     <td><%=wodto.getOrder_date() %></td>
	     <td>
	      <%=wodto.getOrder_code() %>
	      <a href="#">배송조회</a>
	     </td>
	  	</tr>
	  <%
	   }System.out.println("이건성공3");
	  %>
	
	</table>










</body>
</html>