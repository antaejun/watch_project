<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String kitchen_name = request.getParameter("kitchen_name");
	%>

	<h1>views/kitchen/option_register.jsp</h1>
	<fieldset>
		<legend>주방 옵션 등록</legend>
		<form role="form" method="post">
		
		<h3>옵션(체크해주세요)</h3>
		<div class="inputArea">
			<label>주방 이름: ${kitchen_name}</label>
			<input type="hidden" name="kitchen_name" value="${kitchen_name}">
		</div>
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
		</div>
		
		<button type="submit">등록</button>
		</form>
	</fieldset>
</body>
</html>
</body>
</html>