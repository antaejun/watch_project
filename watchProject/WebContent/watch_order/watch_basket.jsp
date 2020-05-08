<%@page import="net.items.db.ItemDTO"%>
<%@page import="net.shoppingBasket.db.shoppingBasketDTO"%>
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
 <h1>WebContent/goods_order/goods_basket.jsp</h1>
 
 <!-- 
    request 영역에 저장된 객체 저장
    request.setAttribute("basketList", basketList);
	request.setAttribute("goodsList", goodsList);
  -->
  <%
  	List basketList = (List)request.getAttribute("basketList");
         List watchList = (List)request.getAttribute("watchList");
  %>
  
  <!-- 장바구니 테이블 생성 -->
  <table border="1">
  <!-- 번호,사진,제품명,크기,색상, 수량, 가격, 취소 -->
  <tr>
    <td>번호</td>
    <td>제품명</td>
    <td>크기</td>
    <td>색상</td>
    <td>수량</td>
    <td>가격</td>
    <td>취소</td>
  </tr>
  
  <%
  int total = 0;
  
  	for(int i=0;i<basketList.size();i++){
    	  shoppingBasketDTO wbdto = (shoppingBasketDTO)basketList.get(i);
    	  ItemDTO wdto = (ItemDTO)watchList.get(i);
  %>
	     <tr>
		    <td><%=wbdto.getIdx() %></td>
		    <td><%=wdto.getItem_name() %></td>
		    <td><%=wbdto.getBasket_size() %></td>
		    <td><%=wbdto.getBasket_color() %></td>
		    <td><%=wbdto.getBasket_amount() %></td>
		    <%-- <td><%=wdto.getItem_price() %></td> --%>
		    <td><%=total = wdto.getItem_price() * wbdto.getBasket_amount() %></td>
		    <td>
		           <a href="./shoppingBasketDelete.shopping?idx=<%=wbdto.getIdx()%>">취소</a>
		    </td>
		  </tr>
	  <%
  }  
  %>
  
  </table>
  
  <!-- 
     구매하기, 계속쇼핑하기 링크
   -->
   <h3><a href="./OrderWatchStar.or"> [ 구매하기] </a></h3>
   <h3><a href="./WatchList.go"> [쇼핑 계속하기] </a></h3>
   <h3><a href="./MainView.com"> [메인 메뉴] </a></h3>
   
 
 
 
 
 
 
 
 
 

</body>
</html>