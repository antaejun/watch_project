<%@page import="net.review.db.ReviewDTO"%>
<%@page import="net.review.db.ReviewDAO"%>
<%@page import="java.util.List"%>
<%@page import="net.items.db.ItemDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
  src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		// request.setAttribute("idto", idto);
		ItemDTO idto = (ItemDTO)request.getAttribute("idto");
		
		String user_email = "test@test.com";
		if(session.getAttribute("user_email") != null) {
			user_email = (String) session.getAttribute("user_email");
		}
		
	%>
	
	<form action="" method="post" name="fr">
		<input type="hidden" name="user_email" value='test@test.com'>
		<input type="hidden" name="item_code" value="<%= idto.getItem_code()%>">
		<table border="1">
			<tr>
				<td>
					<%-- <img src="./upload/<%=idto.getList_image() %>"
		             width="500" ><br> --%>
					<h2><%=idto.getItem_name() %></h2><br>
					<input type="hidden" name="item_name" value="<%=idto.getItem_name() %>">
					<%=idto.getItem_price() %>원<br>
					<input type="hidden" name="item_price" value="<%=idto.getItem_price() %>">
					<select name="item_size">
						<option value="">사이즈를 선택하세요.</option>
						
						<c:forTokens var="item_size" items="${idto.item_size }" 
							delims=",">
							<option value="${item_size }">${item_size } </option>
						</c:forTokens>
					</select><br>
					<select name="item_color">
						<option value="">색상을 선택하세요.</option>
						
						<c:forTokens var="item_color" items="${idto.item_color }" 
							delims=",">
							<option value="${item_color }">${item_color } </option>
						</c:forTokens>
					</select><br>
					남은수량 : <%=idto.getItem_amount() %> 개<br>
					<input type="hidden" name="item_amount" value="<%=idto.getItem_amount() %>">
					구매수량 : <input type="text" name="order_amount" value="1" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/> 개<br>
					
					<button onclick="isBuy();">구매하기</button>
					<button onclick="isBasket();">장바구니</button>
					<h3>상세정보</h3>
					<%=idto.getItem_info() %>
				</td>
		</table>
	
	
	
	</form>
	
	<hr>
	
	
		<input type="hidden" id="code" name="item_code" value="<%=idto.getItem_code() %>">
		작성자 <input type="text" id="user_id" name="user_email" value='test@test.com' readonly="readonly" ><br>
		리뷰내용 <textarea rows="10" id="content" cols="20" name="content"></textarea><br>
		<input type="button" id="btn_re" value="작성완료">		

	
	<hr>
	<% 
		//List<ReviewDTO> reviewList = rdao.getReviewList(item_code);
		List<ReviewDTO> reviewList
			= (List<ReviewDTO>) request.getAttribute("reviewList");
	
	%>
	<table border="1">
	<thead>
		<tr>
			<th>리뷰내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody class="reviewt">
	<%
	 for(int i=0; i<reviewList.size(); i++){
		 ReviewDTO rdto = reviewList.get(i);
		 %>
		 
		 <tr>
		  <td> <%=rdto.getContent() %></td>
		  <td><%=rdto.getUser_email() %></td>
		 </tr>
		 
		 <%
	 }
	
	%>
	</tbody>
		<%-- <%
	        int size = reviewList.size();
		    int col = 5;
		    int row = (size / col) + (size%col>0? 1:0);
		    int review_num = 0;
		    
		    ReviewDTO rdto = reviewList.get(review_num);
		
			for (int a = 0; a < row; a++) {
		 %>
		<tr class="reviewt">
			<%
				for (int i = 0; i <col; i++) {
					rdto = reviewList.get(review_num);
			%>
			<td>
				리뷰내용 <%=rdto.getContent() %><br>
				작성자 <%= rdto.getUser_email()%>
				<hr>
				
			</td>
			<%
			review_num++;  
			   if(size <= review_num) break;
			 }			
			%>
		</tr>
		<% } %> --%>
	</table>
	
	<script type="text/javascript">
	function isBuy() {
  		
  		// 크기, 색상 선택없을시 요소 포커싱
  		if(document.fr.item_size.value == "") {
  			alert("사이즈를 선택하세요.");
  			document.fr.item_size.focus();
  			return;
  		}
  		if(document.fr.item_color.value == "") {
  			alert("색상을 선택하세요.");
  			document.fr.item_color.focus();
  			return;
  		}
  		if(document.fr.item_amount.value < document.fr.order_amount.value){
  			alert("상품 재고보다 주문수량이 많아 주문할 수 없습니다.");
  			document.fr.order_amount.focus();
  			return;
  		}
  		
  		var check1 = confirm("결제페이지로 이동하시겠습니까?");
  			
  		if(check1) {
	  		document.fr.action="./OrderSheet.or";
	  		document.fr.submit();
  		} else {
  			return;
  		}
  	}
	
  	function isBasket() {
  		// alert("장바구니 버튼 클릭");
  		
  		// 크기, 색상 선택없을시 요소 포커싱
  		if(document.fr.item_size.value == "") {
  			alert("사이즈를 선택하세요.");
  			document.fr.item_size.focus();
  			return;
  		}
  		if(document.fr.item_color.value == "") {
  			alert("색상을 선택하세요.");
  			document.fr.item_color.focus();
  			return;
  		}
  		if(document.fr.item_amount.value < document.fr.order_amount.value){
  			alert("상품 재고보다 주문수량이 많아 장바구니 담기가 불가합니다.");
  			document.fr.order_amount.focus();
  			return;
  		}
  		
  		// "장바구니에 저장 하시겠습니까?"
  		// 확인 - 페이지이동(submit)
  		// 취소 - 변화 없음
  		var check = confirm("장바구니에 저장 하시겠습니까?");
  		
  		if(check) {
  			document.fr.action="./BasketAdd.ba";
  			document.fr.submit();
  		} else {
  			return;
  		}
  	}
  	
  	$(function(){
  		
  		$('#btn_re').click(function(){
  			
	  		var code = $('#code').val();
	  		var user_id = $('#user_id').val();
	  		var content = $('#content').val();
	  		var allData = {code:code,user_id:user_id,content:content};
	  		var data = JSON.stringify(allData);
	  		console.log(data);
	  		$('#content').val("");
	  		$.ajax({
	  			type: "POST",
	  			url: '/TeamProject/ReviewWrite.re',
	  			data: JSON.stringify(allData),
	  			dataType: 'json',
	  			contentType:"application/json",
	  			success: function(data){
	  				console.log("xxxx : " + data.length);
	  				console.log("xxxx : " + data[1].content);
	  				console.log("xxxx : " + data[0].user_email);
	  				$('.reviewt').html("");
	  				
	  				for(var i=0; i<data.length; i++){
	  					
	  					 $('.reviewt').append('<tr><td>'+data[i].content+'</td>'+
	  			  	            '<td> '+data[i].user_email+'</td></tr>'
	  			  	     );
	  				}
	  	           
	  	        }
	  			});
	  		 
  		});
  	});
  	
  
  
  </script>
	
</body>
</html>