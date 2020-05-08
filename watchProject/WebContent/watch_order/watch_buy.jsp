<%@page import="net.items.db.ItemDTO"%>
<%@page import="net.shoppingBasket.db.shoppingBasketDTO"%>
<%@page import="net.user.db.UserBean"%>
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
	<h1>WebContent/watch_order/watch_buy.jsp</h1>
	
	<!-- 
	  request.setAttribute("basketList", basketList);
	  request.setAttribute("goodsList", goodsList);
	  request.setAttribute("memberDTO", memberDTO);
	  
	  해당정보를 가져와서 저장후 출력
	 -->
	 <%
	 	List basketList =(List) request.getAttribute("basketList");
	 	 	 	   List watchList = (List) request.getAttribute("watchList");
	 	 	 	   UserBean UserDTO =(UserBean) request.getAttribute("userDTO");
	 %>
	 
	 <!-- 주문 목록정보(상품)  -->
	 <!-- 사진,상품명,수량,색상,크기,가격 -->
	 <form action="./OrderWatchAdd.or" method="post">
	 <table border="1">
	   <tr>
	     <td colspan="6"> 
	       <h4> 주문 상세 내역 </h4>
	     </td>
	   </tr>
	   <tr>
	      <td>사진</td>
	      <td>상품명</td>
	      <td>수량</td>
	      <td>색상</td>
	      <td>크기</td>
	      <td>가격</td>	   
	   </tr>
	   
	   <%
	   	   	int total = 0;
	   		int total1 = 0;
	   		int totalAmount = 0;
	   	   	   	   	    for(int i=0;i<basketList.size();i++){
	   	   	   	   	    	shoppingBasketDTO sbkdto =(shoppingBasketDTO) basketList.get(i);
	   	   	   	   ItemDTO wdto =(ItemDTO) watchList.get(i);
	   	   %>
	    	   <tr>
			      <td>
			       <%-- <img src="./upload/<%=wdto.getImage().split(",")[0]%>"
			           width="50" height="50"
			       > --%>
			      </td>
			      <td><%=wdto.getItem_name() %></td>
			      <td><%=sbkdto.getBasket_amount() %></td>
			      <td><%=sbkdto.getBasket_size()%></td>
			      <td><%=sbkdto.getBasket_color() %></td>
			      <td><%=total1 = sbkdto.getBasket_amount() * wdto.getItem_price()	%></td>	   
			   </tr>
	    	<%
	    	total +=total1;	    
	    	totalAmount += sbkdto.getBasket_amount();
	    }
	   %>
	   <tr>
	     <td colspan="6">총 금액 : <%=total %>원</td>
	   </tr>
	    <tr>
	     <td colspan="6">총 수량 : <%=totalAmount %>개</td>
	   </tr>
	   <tr>
	     <td colspan="6">
	       <h4> 주문자 정보 </h4>  
	     </td>	   
	   </tr>
	   
	   <tr>
	     <td colspan="3">이름</td>
	     <td colspan="3">
	     
	     <input type="text" name="order_name" 
	              value="<%=UserDTO.getUser_name() %>"
	       ></td>	   
	   </tr>
	   <tr>
	     <td colspan="3">휴대폰</td>
	     <td colspan="3">
	       <input type="text" name="order_phone">
	     </td>	   
	   </tr>
	   
	     <td colspan="6">
          <h4>배송지 정보</h4>
         </td>
	   </tr>
	   <tr>
	     <td colspan="3">받는 사람</td>
	     <td colspan="3">
	       <input type="text" name="receive_name" 
	              value="<%=UserDTO.getUser_name() %>"
	       >
	     </td>	   
	   </tr>
	   <tr>
	     <td colspan="3">전화번호(휴대전화)</td>
	     <td colspan="3">
	       <input type="text" name="receive_phone">
	     </td>	   
	   </tr>
	  
	   <tr>
	     <td colspan="3">배송지 주소</td>
	     <td colspan="3">
	     <input type="text" name="receive_address">
	     </td>	   
	   </tr>
	   <tr>
	     <td colspan="3">배송지 상세 주소</td>
	     <td colspan="3">
	     <input type="text" name="receive_adress_detail">
	     </td>	   
	   </tr>
	   <tr>
	     <td colspan="3">기타 요구 사항</td>
	     <td colspan="3">
	      <input type="text" name="memo">
	     </td>	   
	   </tr>
	   
	   <tr>
	     <td colspan="6">
          <h4>결제 정보</h4>
         </td>
	   </tr>
	   <tr>
	     <td colspan="3">온라인 입금(입금자명)</td>
	     <td colspan="3">
	     <input type="text" name="trade_payer">   <!-- 결제 테이블로 보기 -->
	     </td>	   
	   </tr>
	   
	   <tr>
	      <td colspan="6">
	         <input type="submit" value="주문하기">
	         <input type="reset" value="취소하기">
	      </td>	    
	   </tr>
	   
	 </table>
	 </form>
	 <!-- 주문자 정보 -->
	 
	
	
	
	
	
	
	
	
	
	

</body>
</html>