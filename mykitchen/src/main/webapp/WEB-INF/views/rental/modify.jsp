<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>


<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판 글 수정하기</h3>
				</div>
				<!-- /.box-header -->
	
<!-- action페이지 속성이 없기 때문에 동일한 주소를 다시 호출post방식 -->
<form role="form" method="post" id="fm">
	<div class="box-body">
	
		<div class="form-group">
			<label for="exampleInputEmail1">글번호</label> 
			<input type="text"
				name='bno' class="form-control" value="${rentalVO.bno }" readonly >
		</div>
	
		<div class="form-group">
			<label for="exampleInputEmail1">제목</label> 
			<input type="text"
				name='title' class="form-control" value="${rentalVO.title}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">내용</label>
			<textarea class="form-control" name="content" rows="3"
				>${rentalVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">글쓴이</label> 
			<input type="text"
				name="writer" class="form-control" value="${rentalVO.writer}">
		</div>
	</div>
	<!-- /.box-body -->
</form>
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">수정하기</button>
		<button type="submit" class="btn btn-warning">목록으로</button>
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

<script type="text/javascript">
  $(document).ready(function(){

	  var formObj = $("#fm");

	  $(".btn-primary").on("click",function(){
            // 수정하기 
          alert(" 수정하기 ");
          formObj.submit();
		  });

	  $(".btn-warning").on("click",function(){
          // 목록으로 
        alert(" 목록으로  ");
        location.href='/rental/listAll';
		  });

	  
	  

	  });
</script>



<%@ include file="../footer.jsp" %>

