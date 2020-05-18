<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 제이쿼리, bx슬라이더, home스크립트, homeCSS-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- 유어와치 UI -->
    <link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/common.css">
    <link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/index.css">
    <script src="resources/vendor/js/index.js"></script>

    <!-- Swiper -->
    <script src="resources/vendor/bootstrap/js/swiper.min.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/swiper.min.css">
    
    <!-- Awesome5 Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
	
	<title>제목칸</title>
</head>
<body>
	<%@ include file="../header.jsp" %>

    <section>
        <article class="container nav_info clearfix">
            <p>홈 > 부산 > 해운대</p>
        </article>
        <article class="container title clearfix">
            <h2>해운대지점</h2>
        </article>
        <article class="side_bar clearfix">
            <div class="container side_nav clearfix">
                <div class="nav_box clearfix">
                    <h1 class="clearfix" style="float: left;">필터</h1>
                    <button id="reset"></button>
                    <label for="reset"><i class="fas fa-redo" style="margin: 0 5px;"></i>초기화</label>
                </div>
                
                <hr>
            
            

                <div class="nav_box clearfix">
                    <h1>기물</h1>	
                    <ul class="nav_check">
                        <li>
                            <input type="checkbox" id="brand1"><label for="brand1"><i class="fas fa-check"></i><span>화구(1)</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand2"><label for="brand2"><i class="fas fa-check"></i><span>화구(2)</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand3"><label for="brand3"><i class="fas fa-check"></i><span>화구(3)</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand4"><label for="brand4"><i class="fas fa-check"></i><span>오븐</span></label>
                        </li>
                        <li>
                            <input type="checkbox" id="brand5"><label for="brand5"><i class="fas fa-check"></i><span>냉장고</span></label>
                        </li>
                    </ul>
                </div>
              

              
            

                <!-- <div class="nav_box clearfix">
                    <h1>가격</h1>
                    <input type="range" style="width: 200px;">x원
                    <button>적용하기</button>
                </div> -->
         

           
           

           
              	
            </div>
        </article>
        
        <article class="contents clearfix">
            <!-- <div class="fillter">
                <div class="selected">
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                    <label>스와치 <a href="#"><i class="fa fa-times"></i></a></label>
                </div>
            </div> -->
            <div class="align clearfix">
                <ul>
                    <li><a href="#">가격순(오름차순)</a></li>
                    <li><a href="#">가격순(내림차순)</a></li>
                    <li><a href="#">크기순(오름차순)</a></li>
                    <li><a href="#">크기순(내림차순)</a></li>
                    
                </ul>
                <select name="amount">               
                    <option value="15">10개씩 보기</option>
                    <option value="9">5개씩 보기</option>
                </select>
            </div>
            <div class="items">
                <div class="card">
                	<a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                    
                  
                    <div class="text_box">
		<c:forEach items="${rentalList}" var="rentalVO">
			<tr>
				<th style="width: 10px">${rentalVO.idx }</th>
				<th>
				  <a href="/rental/read?idx=${rentalVO.idx }">${rentalVO.title }</a>
				</th>
				<th>${rentalVO.user_email }</th>
				<th>
					<fmt:formatDate 
					pattern="yyyy-MM-dd HH:mm"
					value="${rentalVO.regdate }"/>
				</th>
				
			</tr>
		</c:forEach>
                        <p>DB에서 목록 들고오기(주방 내용)</p>
                    
                    </div>
                </div>
                <div class="card">
                     <a href="/rental/read?bno=${rentalVO.bno }">${rentalVO.title }</a><div class="fake_img">
                        
                    </div></a>
                 
                    <div class="text_box">
                         <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                 
                    <div class="text_box">
                   <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                   
                    <div class="text_box">
                         <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                   
                    <div class="text_box">
                         <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                   
                    <div class="text_box">
                         <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                   
               
                    <div class="text_box">
                        <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                   
                    <div class="text_box">
                          <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                    
                    <div class="text_box">
                         <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
                <div class="card">
                    <a href="./WatchDetail.gos"><div class="fake_img">
                        
                    </div></a>
                   
                    <div class="text_box">
                         <p>DB에서 목록 들고오기(주방 내용)</p>
                    </div>
                </div>
      
            </div>
            <div class="pagination">
                <div class="page">
                    <a href="#">&laquo;</a>
                    <a href="#">1</a>
                    <a href="#" class="active">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">&raquo;</a>
                </div>
            </div>
        </article>

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
    </section>


<%@ include file="../footer.jsp" %>
</body>
</html>