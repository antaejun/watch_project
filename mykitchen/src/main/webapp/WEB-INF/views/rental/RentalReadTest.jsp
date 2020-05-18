<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<%@ include file="../header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">글 목록</h3>
				</div>
				<div class="box-body">
		<%-- <h2>${kitchenList }</h2> --%>		
	<table class="table table-bordered">
		<tr>
			<th style="width: 10px">글 번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th style="width: 40px">조회수</th>
		</tr>
		
		<c:forEach items="${kitchenList}" var="kitchenVO">
			<tr>
				<th style="width: 10px">${kitchenVO.idx }</th>
				<th>
				  <a href="/kitchen/read?bno=${kitchenVO.idx }">${kitchenVO.kitchen_name }</a>
				</th>
				<th>${kitchenVO.user_email }</th>
				<th>
					<%-- <fmt:formatDate 
					pattern="yyyy-MM-dd HH:mm"
					value="${kitchenVO.regdate }"/> --%>
				</th>
				<th style="width: 40px">${kitchenVO.rental_price }</th>
			</tr>
		</c:forEach>
		
		
	</table>

				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script type="text/javascript">
    //alert("출력");
    // 전달정보가 SUCCESS 일때만 "정상처리된 페이지 입니다"
    //  "글 저장이 성공했습니다."
    
    var result = '${result}';
    // alert("result : "+result);
    
    if(result == 'SUCCESS'){
        alert("글 저장 성공! 정상처리된 페이지 입니다.");
        }
    
    


</script>




<%@ include file="../footer.jsp" %>
