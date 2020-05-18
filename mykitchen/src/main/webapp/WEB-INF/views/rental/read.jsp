<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

   <form role="form" method="post">
      <input type="hidden" name="bno" value="${rentalVO.bno }">
   </form>



<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판 본문보기</h3>
				</div>
				<!-- /.box-header -->
	
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">제목</label> 
			<input type="text"
				name='title' class="form-control" 
				readonly="readonly" value="${rentalVO.title}"
				>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">내용</label>
			<textarea class="form-control" name="content" rows="3"
				readonly="readonly">${rentalVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">글쓴이</label> 
			<input type="text"
				name="writer" class="form-control"
				readonly="readonly" value="${rentalVO.writer }">
		</div>
	</div>
	<!-- /.box-body -->

	<div class="box-footer">
		<button type="submit" class="btn btn-warning">수정하기</button>
		<button type="submit" class="btn btn-danger">삭제하기</button>
		<button type="submit" class="btn btn-primary" onclick="test();">목록보기</button>
	</div>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
   function test(){
        alert("목록 페이지로 이동");
        location.href="/rental/listAll";
	   }
</script>

<script>
  $(document).ready(function(){

	  //alert("제이쿼리 실행");
	  // 폼태그를 선택해서 특정 페이지로 이동
	  // 정보(글번호bno)를 가지고 이동
	  
	  // 폼태그 접근
	  var formObj = $("form[role='form']");

	  //alert(fromObj);

	  // 삭제하기 
     $(".btn-danger").on("click",function(){
           alert("삭제 버튼 클릭");
           formObj.attr("action","/rental/delete");
           formObj.submit();    	 
         });

     // 수정하기 
     $(".btn-warning").on("click",function(){
           alert("수정 버튼 클릭");
           formObj.attr("action","/rental/modify");
           formObj.attr("method","get");
           formObj.submit();    	 
         });
     
	  
	  
	});
</script>





<%@ include file="../footer.jsp" %>

