<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<h1>views/kitchen/kitchen_detail.jsp</h1>
	
	 <form role="form" method="post">
      <input type="hidden" name="kitchen_name" value="${kitchenVO.kitchen_name }">
   	</form>
   
		<input type="hidden" name="user_email" value="2@2.com">
		<div class="inputArea">
			<label>주방 이름</label>
			<input type="text" name="kitchen_name" value="${kitchenVO.kitchen_name }" readonly="readonly">
		</div>
		<div class="inputArea">
			<label>지역</label><input type="text" name="region" value="${kitchenVO.region }" readonly="readonly">
		</div>
		<div class="inputArea">
			<label>평수</label>
			<input type="text" name="acreage" value="${kitchenVO.acreage }" readonly="readonly">
		</div>
		<div class="inputArea">
			<label>렌탈 비용(월)</label>
			<input type="text" name="rental_price" value="${kitchenVO.rental_price }" readonly="readonly">
		</div>
		<div class="inputArea">
			<label>이미지</label>
			<div class="select_img">
			<img src="http://localhost:8088/controller/resources/${kitchenVO.image }" width="500"/></div>
			
		</div>
		<div class="inputArea">
			<label>지점명</label>
			<input type="text" name="branch_name" value="${kitchenVO.branch_name }" readonly="readonly">
		</div>
		<div class="inputArea">
			<label>내용</label>
			<input type="text" name="content" value="${kitchenVO.content }" readonly="readonly"><br>
		</div>	
		
		<!-- <h3>옵션(체크해주세요)</h3>
		<div>
			<label>전자레인지</label>
			<input type="checkbox" name="microwave_oven" value="y">
		</div>
		<div>
			<label>가스레인지</label>
			<input type="checkbox" name="gas_stove" value="y">
		</div>
		<div>
			<label>인덕션</label>
			<input type="checkbox" name="induction" value="y">
		</div>
		<div>
			<label>냉장고</label>
			<input type="checkbox" name="refrigerator" value="y">
		</div>
		<div>
			<label>냉동고</label>
			<input type="checkbox" name="freezer_refrigerator" value="y">
		</div>
		<div>
			<label>전기온수기</label>
			<input type="checkbox" name="electric_water_heater" value="y">
		</div>
		<div>
			<label>제빙기</label>
			<input type="checkbox" name="ice_making_machine" value="y">
		</div>
		<div>
			<label>싱크대</label>
			<input type="checkbox" name="sink" value="y">
		</div>
		<div>
			<label>배기후드</label>
			<input type="checkbox" name="exhaust_hood" value="y">
		</div>
		<div>
			<label>포스대</label>
			<input type="checkbox" name="pos" value="y">
		</div>
		<div>
			<label>인터넷</label>
			<input type="checkbox" name="internet" value="y">
		</div>
		<div>
			<label>전화기</label>
			<input type="checkbox" name="telephone" value="y">
		</div> -->
		
		<div>
			<button type="submit" id="modify-Btn">수정하기</button>
			<button type="submit" id="delete-Btn">삭제하기</button>
			<button type="submit" id="list-Btn" onclick="list();">목록보기</button>
		
		
		<script>
			function list(){
				alert("목록 페이지로 이동");
				location.href="/kitchen/list?user_email=2@2.com";
			}
		</script>
		
		<script>
		$(document).ready(function(){

			var formObj = $("form[role='form']");

			$("#modify_Btn").on("click",function(){
				alret("수정 버튼 클릭");
				formObj.attr("action","/kitchen/modify");
				formObj.attr("method","get");
				formObj.submit();
			});

			$("#delete_Btn").on("click",function(){
				alert("삭제 버튼 클릭");
				formObj.attr("action","/kitchen/delete");
				formObj.submit();
					
			});

		});
		</script>
		</div>
</body>
</html>